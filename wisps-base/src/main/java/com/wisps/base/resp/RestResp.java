package com.wisps.base.resp;

import com.alibaba.fastjson2.JSONObject;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class RestResp extends BaseResp {

    private JSONObject data;

    private JSONObject error;

    @Override
    public Boolean getSuccess() {
        return data != null;
    }

    @Override
    public String getRespMsg() {
        if (this.error != null) {
            return error.getString("message");
        }
        return null;
    }

    @Override
    public String getRespCode() {
        if (this.error != null) {
            return error.getString("code");
        }
        return null;
    }
}
