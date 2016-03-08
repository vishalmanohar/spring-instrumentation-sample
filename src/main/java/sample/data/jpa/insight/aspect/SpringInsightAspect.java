package sample.data.jpa.insight.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;
import sample.data.jpa.insight.model.CurrentRequestLog;
import sample.data.jpa.insight.model.RequestLog;

import java.util.Optional;

@Aspect
@Component
public class SpringInsightAspect {
    @Around("execution(* sample.data.jpa.service..*(..))")
    public Object aroundAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
        Optional<RequestLog> requestLog = CurrentRequestLog.get();
        return requestLog.isPresent() ? instrument(joinPoint, requestLog.get()) : joinPoint.proceed();
    }

    private Object instrument(ProceedingJoinPoint joinPoint, RequestLog requestLog) throws Throwable {
        Object returnObject;
        try {
            requestLog.startNode(methodName(joinPoint));

            StopWatch stopWatch = newStopWatch();
            returnObject = joinPoint.proceed();
            stopWatch.stop();

            requestLog.endNode(stopWatch.getTotalTimeMillis());
        } catch (Throwable throwable) {
            throw throwable;
        }
        return returnObject;
    }

    private String methodName(ProceedingJoinPoint joinPoint) {
        return joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName();
    }

    private StopWatch newStopWatch() {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        return stopWatch;
    }
}
