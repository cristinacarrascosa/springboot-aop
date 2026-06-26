package com.cristina.curso.springboot.aop.springboot_aop.aop;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(1)
@Component
@Aspect
public class GreetingFooAspect {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    

    @Before("GreetingServicePointcuts.greetingFooPointcut()") // Intercepta cualquier método de la clase GreetingService que devuelva un String y tenga cualquier número de argumentos
    public void loggerBefore(JoinPoint joinPoint) {
        
        String method = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());
        logger.info("Antes primero: " + method + " invocado con los parametros: " + args);
    }
    @After("reetingFooPointcut()") // Intercepta cualquier método de la clase GreetingService que devuelva un String y tenga cualquier número de argumentos
    public void loggerAfter(JoinPoint joinPoint) {
        
        String method = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());
        logger.info("2.Después Primero: " + method + " con los argumentos: " + args);
    }
}
