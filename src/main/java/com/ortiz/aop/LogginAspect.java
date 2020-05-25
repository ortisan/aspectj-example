package com.ortiz.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Aspect
public class LogginAspect {

    private static Logger logger = LoggerFactory.getLogger(LogginAspect.class);

    @Pointcut("execution(* com.ortiz.core.*.*(..))")
    public void coreMethods() {}


    @Before("coreMethods()")
    public void before(JoinPoint joinPoint) {
        System.out.println("Before");
        logger.info("Core execution : " + joinPoint.toLongString());
    }

    @After("coreMethods()")
    public void after(JoinPoint joinPoint) {
        System.out.println("After");
        logger.info("Core execution executed: " + joinPoint.toLongString());
    }

}
