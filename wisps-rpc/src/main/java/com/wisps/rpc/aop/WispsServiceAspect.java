package com.wisps.rpc.aop;

import com.alibaba.fastjson2.JSON;
import com.wisps.base.exception.BizException;
import com.wisps.base.exception.SystemException;
import com.wisps.base.resp.BaseResp;
import com.wisps.base.resp.RespCode;
import com.wisps.base.utils.BeanValidator;
import jakarta.validation.ValidationException;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.StopWatch;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * Facade的切面处理类，统一统计进行参数校验及异常捕获
 */
@Aspect
@Component
@Order(Integer.MIN_VALUE)
public class WispsServiceAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(WispsServiceAspect.class);

    @Around("@annotation(com.wisps.rpc.aop.WispsService)")
    public Object facade(ProceedingJoinPoint pjp) throws Exception {

        StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        Method method = ((MethodSignature) pjp.getSignature()).getMethod();
        Object[] args = pjp.getArgs();

        Class returnType = ((MethodSignature) pjp.getSignature()).getMethod().getReturnType();

        //循环遍历所有参数，进行参数校验
        for (Object parameter : args) {
            try {
                BeanValidator.validateObject(parameter);
            } catch (ValidationException e) {
                printLog(stopWatch, method, args, "failed to validate", null, e);
                return getFailedResponse(returnType, e);
            }
        }

        try {
            // 目标方法执行
            Object response = pjp.proceed();
            enrichObject(response);
            printLog(stopWatch, method, args, "end to execute", response, null);
            return response;
        } catch (Throwable throwable) {
            // 如果执行异常，则返回一个失败的response
            printLog(stopWatch, method, args, "failed to execute", null, throwable);
            return getFailedResponse(returnType, throwable);
        }
    }

    /**
     * 日志打印
     *
     * @param stopWatch
     * @param method
     * @param args
     * @param action
     * @param response
     */
    private void printLog(StopWatch stopWatch, Method method, Object[] args, String action, Object response,
                          Throwable throwable) {
        try {
            //因为此处有JSON.toJSONString，可能会有异常，需要进行捕获，避免影响主干流程
            LOGGER.info(getInfoMessage(action, stopWatch, method, args, response, throwable), throwable);
            // 如果校验失败，则返回一个失败的response
        } catch (Exception e1) {
            LOGGER.error("log failed", e1);
        }
    }

    /**
     * 统一格式输出，方便做日志统计
     * <p>
     * *** 如果调整此处的格式，需要同步调整日志监控 ***
     *
     * @param action    行为
     * @param stopWatch 耗时
     * @param method    方法
     * @param args      参数
     * @param response  响应
     * @return 拼接后的字符串
     */
    private String getInfoMessage(String action, StopWatch stopWatch, Method method, Object[] args, Object response,
                                  Throwable exception) {

        StringBuilder stringBuilder = new StringBuilder(action);
        stringBuilder.append(" ,method = ");
        stringBuilder.append(method.getName());
        stringBuilder.append(" ,cost = ");
        stringBuilder.append(stopWatch.getTime()).append(" ms");
        if (response instanceof BaseResp) {
            stringBuilder.append(" ,success = ");
            stringBuilder.append(((BaseResp) response).getSuccess());
        }
        if (exception != null) {
            stringBuilder.append(" ,success = ");
            stringBuilder.append(false);
        }
        stringBuilder.append(" ,args = ");
        stringBuilder.append(JSON.toJSONString(Arrays.toString(args)));

        if (response != null) {
            stringBuilder.append(" ,resp = ");
            stringBuilder.append(JSON.toJSONString(response));
        }

        if (exception != null) {
            stringBuilder.append(" ,exception = ");
            stringBuilder.append(exception.getMessage());
        }

        if (response instanceof BaseResp) {
            BaseResp baseResponse = (BaseResp) response;
            if (!baseResponse.getSuccess()) {
                stringBuilder.append(" , execute_failed");
            }
        }

        return stringBuilder.toString();
    }

    /**
     * 将response的信息补全，主要是code和message
     *
     * @param response
     */
    private void enrichObject(Object response) {
        if (response instanceof BaseResp) {
            if (((BaseResp) response).getSuccess()) {
                //如果状态是成功的，需要将未设置的responseCode设置成SUCCESS
                if (StringUtils.isEmpty(((BaseResp) response).getRespCode())) {
                    ((BaseResp) response).setRespCode(RespCode.SUCCESS.name());
                }
            } else {
                //如果状态是成功的，需要将未设置的responseCode设置成BIZ_ERROR
                if (StringUtils.isEmpty(((BaseResp) response).getRespCode())) {
                    ((BaseResp) response).setRespCode(RespCode.BIZ_ERROR.name());
                }
            }
        }
    }

    /**
     * 定义并返回一个通用的失败响应
     */
    private Object getFailedResponse(Class returnType, Throwable throwable)
            throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {

        //如果返回值的类型为BaseResponse 的子类，则创建一个通用的失败响应
        if (returnType.getDeclaredConstructor().newInstance() instanceof BaseResp) {
            BaseResp response = (BaseResp) returnType.getDeclaredConstructor().newInstance();
            response.setSuccess(false);
            if (throwable instanceof BizException bizException) {
                response.setRespMsg(bizException.getErrorCode().getMessage());
                response.setRespCode(bizException.getErrorCode().getCode());
            } else if (throwable instanceof SystemException systemException) {
                response.setRespMsg(systemException.getErrorCode().getMessage());
                response.setRespCode(systemException.getErrorCode().getCode());
            } else {
                response.setRespMsg(throwable.toString());
                response.setRespCode(RespCode.BIZ_ERROR.name());
            }

            return response;
        }

        LOGGER.error("failed to getFailedResponse , returnType (" + returnType + ") is not instanceof BaseResponse");
        return null;
    }
}
