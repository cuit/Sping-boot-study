package com.xsc.handle;

import com.xsc.exception.StudentException;
import com.xsc.model.Result;
import com.xsc.util.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by XSC on 2017/5/5.
 */
@ControllerAdvice
public class ExceptionHandle {

    private static final Logger logger = LoggerFactory.getLogger(ExceptionHandle.class);

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result handle(Exception e){
        if (e instanceof StudentException){
            StudentException studentException = (StudentException) e;
            return ResultUtil.fail(studentException.getCode(),studentException.getMessage());
        }else{
            logger.error("未知错误：{}",e);
            return ResultUtil.fail(-1,"未知错误");
        }
    }
}
