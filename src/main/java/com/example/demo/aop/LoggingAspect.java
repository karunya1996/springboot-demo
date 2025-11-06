package com.example.demo.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

//cross cutting logic like logging - will log automatically before running.

@Aspect
@Component
public class LoggingAspect {
   @Before("execution(* com.example.demo.service.*.*(..))")
   public void logBeforeServiceMethods() {
       System.out.println("[AOP] A service method is about to run");
   }
}