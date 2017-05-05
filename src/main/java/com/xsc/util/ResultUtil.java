package com.xsc.util;

import com.xsc.model.Result;

/**
 * 统一返回格式
 * Created by XSC on 2017/5/5.
 */
public class ResultUtil {

    public static Result success(String message,Object data){
        Result result = new Result();
        result.setCode(0);
        result.setMessage(message);
        result.setData(data);
        return result;
    }

    public static Result success(String message){
        return success(message,null);
    }

    public static Result fail(Integer code,String message){
        Result result = new Result();
        result.setCode(code);
        result.setMessage(message);
        return result;
    }
}
