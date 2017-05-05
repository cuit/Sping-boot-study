package com.xsc.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by XSC on 2017/5/5.
 */
@Aspect
@Component
public class HttpAspect {

    /**
     * 2017-05-05 14:37:03.164  INFO 7508 --- [nio-8008-exec-3] com.xsc.aspect.HttpAspect    : url=http://localhost:8008/students
     * 2017-05-05 14:37:03.164  INFO 7508 --- [nio-8008-exec-3] com.xsc.aspect.HttpAspect    : method=GET
     * 2017-05-05 14:37:03.164  INFO 7508 --- [nio-8008-exec-3] com.xsc.aspect.HttpAspect    : ip=0:0:0:0:0:0:0:1
     * 2017-05-05 14:37:03.164  INFO 7508 --- [nio-8008-exec-3] com.xsc.aspect.HttpAspect    : class_method=com.xsc.controller.StudentController.getAllStudents
     * 2017-05-05 14:37:03.164  INFO 7508 --- [nio-8008-exec-3] com.xsc.aspect.HttpAspect    : arg={}
     */
    private static final Logger logger = LoggerFactory.getLogger(HttpAspect.class);

    @Pointcut("execution(public * com.xsc.controller.StudentController.*(..))")
    public void log(){
    }

    @Before("log()")
    public void doBefore(JoinPoint joinPoint){
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest httpServletRequest = servletRequestAttributes.getRequest();
        // url
        logger.info("url={}",httpServletRequest.getRequestURL());
        // method
        logger.info("method={}",httpServletRequest.getMethod());
        // ip
        logger.info("ip={}",httpServletRequest.getRemoteAddr());
        // 类 方法
        logger.info("class_method={}",joinPoint.getSignature().getDeclaringTypeName()+"."+joinPoint.getSignature().getName());
        // 参数
        logger.info("arg={}",joinPoint.getArgs());
    }
}
