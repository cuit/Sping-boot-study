package com.xsc.enums;

/**
 * Created by XSC on 2017/5/5.
 */
public enum ResultEnum {
    PRIMARY_STUDENT(101,"初中生"),
    MIDDLE_STUDENT(102,"高中生")
    ;

    private Integer code;
    private String message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
