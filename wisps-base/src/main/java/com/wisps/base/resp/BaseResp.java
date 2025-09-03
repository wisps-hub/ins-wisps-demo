package com.wisps.base.resp;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * 通用出参
 */
@Setter
@Getter
@ToString
public class BaseResp implements Serializable {
    private static final long serialVersionUID = 1L;

    private Boolean success;

    private String respCode;

    private String respMsg;
}
