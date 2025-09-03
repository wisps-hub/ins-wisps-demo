package com.wisps.base.resp;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

/**
 * 响应
 */
@Setter
@Getter
public class MultiResp<T> extends BaseResp implements Serializable {
    private static final long serialVersionUID = 1L;

    private List<T> datas;

    public static <T> MultiResp<T> of(List<T> datas) {
        MultiResp<T> multiResponse = new MultiResp<>();
        multiResponse.setSuccess(true);
        multiResponse.setDatas(datas);
        return multiResponse;
    }

}
