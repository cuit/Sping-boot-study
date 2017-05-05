package com.xsc.exception;

import com.xsc.enums.ResultEnum;

/**
 * Created by XSC on 2017/5/5.
 */
public class StudentException extends RuntimeException {

    private Integer code;

    public StudentException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
