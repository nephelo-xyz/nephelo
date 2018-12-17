package com.nephelo.api.vo.authority;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by xiangfei on 2017/10/16.
 */
@Data
public class PermissionInfo implements Serializable{
    private String code;
    private String type;
    private String uri;
    private String method;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }
}
