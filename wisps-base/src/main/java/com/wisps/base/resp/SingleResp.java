package com.wisps.base.resp;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class SingleResp<T> extends BaseResp {
    private static final long serialVersionUID = 1L;

    private T data;

    public static <T> SingleResp<T> of(T data) {
        SingleResp<T> singleResponse = new SingleResp<>();
        singleResponse.setSuccess(true);
        singleResponse.setData(data);
        return singleResponse;
    }

    public static <T> SingleResp<T> fail(String errorCode, String errorMsg) {
        SingleResp<T> singleResponse = new SingleResp<>();
        singleResponse.setSuccess(false);
        singleResponse.setRespCode(errorCode);
        singleResponse.setRespMsg(errorMsg);
        return singleResponse;
    }

}
