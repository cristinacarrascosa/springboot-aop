package com.cristina.curso.springboot.aop.springboot_aop.aop;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class GreetingAspect {

    private Logger logger = LoggerFactory.getLogger(this.getClass());


    /*@Before("execution(* com.cristina.curso.springboot.aop.springboot_aop.services.GreetingService.*(..))") // Intercepta cualquier método de la clase GreetingService que devuelva un String y tenga cualquier número de argumentos
    public void loggerBefore(JoinPoint joinPoint) {
        
        String method = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());
        logger.info("Antes: " + method + " con los argumentos: " + args);
    }

    @After("execution(* com.cristina.curso.springboot.aop.springboot_aop.services.GreetingService.*(..))") // Intercepta cualquier método de la clase GreetingService que devuelva un String y tenga cualquier número de argumentos
    public void loggerAfter(JoinPoint joinPoint) {
        
        String method = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());
        logger.info("Después: " + method + " con los argumentos: " + args);
    }

    @AfterReturning("execution(* com.cristina.curso.springboot.aop.springboot_aop.services.GreetingService.*(..))") // Intercepta cualquier método de la clase GreetingService que devuelva un String y tenga cualquier número de argumentos
    public void loggerAfterReturning(JoinPoint joinPoint) {
        
        String method = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());
        logger.info("Después de devolver valor: " + method + " con los argumentos: " + args);
    }

    // Se ejecuta después de que un método lanza una excepción. El método loggerAfterThrowing se ejecutará después de que cualquier método de la clase GreetingService lance una excepción. El JoinPoint se utiliza para obtener información sobre el método que lanzó la excepción, como su nombre y los argumentos que se le pasaron. Luego, se registra un mensaje en el logger con esta información.
    @AfterThrowing("execution(* com.cristina.curso.springboot.aop.springboot_aop.services.GreetingService.*(..))") // Intercepta cualquier método de la clase GreetingService que devuelva un String y tenga cualquier número de argumentos
    public void loggerAfterThrowing(JoinPoint joinPoint) {
        
        String method = joinPoint.getSignature().getName();
        String args = Arrays.toString(joinPoint.getArgs());
        logger.info("Después de lanzar excepción: " + method + " con los argumentos: " + args);
    }
*/
    @Around("execution(* com.cristina.curso.springboot.aop.springboot_aop.services.GreetingService.*(..))") // Intercepta cualquier método de la clase GreetingService que devuelva un String y tenga cualquier número de argumentos
    public Object loggerAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        String method = proceedingJoinPoint.getSignature().getName();
        String args = Arrays.toString(proceedingJoinPoint.getArgs());

        Object result = null;
        try {
            logger.info("Antes de ejecutar método: " + method + " con los argumentos: " + args);// Se ejecuta antes de que el método se ejecute
            result = proceedingJoinPoint.proceed();
            logger.info("El método " + method + " con los argumentos: " + args + " ha devuelto un resultado: " + result);// Se ejecuta después de que el método se ejecute y devuelva un resultado
            return result;// Devuelve el resultado del método interceptado
        } catch (Throwable throwable) {
            logger.error("Error en la llamada del metodo: " + method + " ()" );// Se ejecuta después de que el método lance una excepción
            throw throwable;
        }   
        

    }
}
