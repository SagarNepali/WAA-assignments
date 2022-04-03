package com.waa.lab4.logger.exception.aspect;

import com.waa.lab4.exception.domain.DataNotFoundException;
import com.waa.lab4.logger.exception.domain.ExceptionLogger;
import com.waa.lab4.logger.exception.service.ExceptionLoggerService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ExceptionLoggerAspect {

    @Autowired
    private ExceptionLoggerService exceptionLoggerService;

    @Pointcut("@annotation(com.waa.lab4.logger.exception.aspect.annotation.LogException)")
    public void logExceptionAnnotation(){}

    @Around("logExceptionAnnotation()")
    public Object logException(ProceedingJoinPoint proceedingJoinPoint) throws DataNotFoundException {

        Object obj =  null;

        try {
            obj = proceedingJoinPoint.proceed();

        }catch (Throwable ex){

            ExceptionLogger exceptionLogger = new ExceptionLogger().builder()
                    .operation(proceedingJoinPoint.getTarget().getClass().getSimpleName()+" -> "
                        +proceedingJoinPoint.getSignature().getName())
                    .exceptionMessage(ex.getMessage())
                    .exceptionType(ex.getClass().getSimpleName())
                    .build();
            exceptionLoggerService.save(exceptionLogger);
            throw new DataNotFoundException(ex.getMessage());
        }
        return obj;
    }

}
