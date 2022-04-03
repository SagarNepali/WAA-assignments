package com.waa.lab4.logger.logger.aspect;

import com.waa.lab4.logger.logger.domain.Logger;
import com.waa.lab4.logger.logger.service.LoggerService;
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
public class LoggerAspect {

    @Autowired
    private LoggerService loggerService;


    @Pointcut("@annotation(com.waa.lab4.logger.logger.aspect.annotation.ExecutionTime)")
    public void logExecutionTime(){}

    @Pointcut("execution(* com.waa.lab4.comment.service.CommentServiceImpl.*())")
    public void logCommentService(){}

    @Pointcut("execution(* com.waa.lab4.user.service.UserServiceImpl.*())")
    public void logUserService(){}

    @Pointcut("execution(* com.waa.lab4.post.service.PostServiceImpl.*())")
    public void logPostService(){}

    @After("logCommentService() || logUserService() || logPostService()")
    public void logAfterDBUse(JoinPoint joinPoint) throws Exception {
        Logger logger = new Logger()
                .builder()
                .operation(joinPoint.getTarget().getClass().getSimpleName()+" -> "+ joinPoint.getSignature().getName())
                .build();

        loggerService.save(logger);

    }

    @Around("logExecutionTime()")
    public Object logAroundExecutionTime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        long timerStart = System.currentTimeMillis();
        Object proceed = proceedingJoinPoint.proceed();
        long timerEnd = System.currentTimeMillis();
        System.out.println("Execution time for "+proceedingJoinPoint.getTarget().getClass().getSimpleName()
        +" -> "+proceedingJoinPoint.getSignature().getName()+" method is: "+(timerEnd-timerStart)+" ms");
        return proceed;
    }
}
