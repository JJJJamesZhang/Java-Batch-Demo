package com.company.demojavabatch.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ControllerAspect {


    @Around("execution(public * com.company.demojavabatch.controller.EmployeeController.*(..))")
    public Object pointCut(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Long start = System.currentTimeMillis();
        Object obj = proceedingJoinPoint.proceed();
        Long cost = System.currentTimeMillis() - start;
        System.out.println("Method: " + proceedingJoinPoint.getSignature().getName() + " cost: " + cost + " ms");
        return obj;
    }
}
