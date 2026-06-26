package com.cristina.curso.springboot.aop.springboot_aop.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class GreetingServicePointcuts {

     @Pointcut("execution(* com.cristina.curso.springboot.aop.springboot_aop.services.GreetingService.*(..))")
    public void greetingLoggerPointCut(){};

    @Pointcut("execution(* com.cristina.curso.springboot.aop.springboot_aop.services.GreetingService.*(..))")
    public void greetingFooPointcut(){};


}
