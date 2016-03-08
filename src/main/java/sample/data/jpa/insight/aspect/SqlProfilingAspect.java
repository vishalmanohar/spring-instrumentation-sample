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
public class SqlProfilingAspect {
    @Around("execution(* org.hibernate.engine.jdbc.spi.SqlStatementLogger.logStatement(String, org.hibernate.engine.jdbc.internal.Formatter)) && args(sql, ..)")
    public Object aroundAdvice(ProceedingJoinPoint joinPoint, String sql) throws Throwable {
        System.out.println("LOOOLLLOLOL ::" + sql);
        return joinPoint.proceed();
    }
}
