package com.creawor.sales.common;

/**
 * Created by Jin_ on 2016/11/10.
 * 错误消息
 */
public enum ErrorCode {
    ILLEGAL_PARAMS("ILLEGAL_PARAMS", "request params invalid"),
    SERVER_ERROR("SERVER_ERROR", "server is busy");

    ErrorCode(String code, String message) {
        this.code = code;
        this.message = message;
    }

    private String code;

    private String message;

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
