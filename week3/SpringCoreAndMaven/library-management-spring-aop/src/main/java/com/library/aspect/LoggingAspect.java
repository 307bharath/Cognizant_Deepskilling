package com.library.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;

public class LoggingAspect {

    // Around advice to log execution time
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();

        // Proceed with the method
        Object result = joinPoint.proceed();

        long end = System.currentTimeMillis();
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        String methodName = signature.getDeclaringTypeName() + "." + signature.getName();

        System.out.println("Execution time of " + methodName + ": " + (end - start) + " ms");

        return result;
    }
}
