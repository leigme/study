package me.leig.study.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @title: LogAspects
 * @description:
 * @author: leig
 * @create: 2020-04-06 20:55
 **/
@Aspect
@Component
public class LogAspects {

    @Pointcut(value = "execution(public int me.leig.study.bean.MathCalculator.*(..))")
    public void pointCut() {
    }

    @Before(value = "pointCut()")
    public void logStart(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        System.out.println(joinPoint.getSignature().getName() + "计算开始...{" + Arrays.asList(args) + "}");
    }

    @After(value = "pointCut()")
    public void logEnd(JoinPoint joinPoint) {
        System.out.println(joinPoint.getSignature().getName() + "计算结束...");
    }

    @AfterReturning(value = "pointCut()", returning = "obj")
    public void logResult(JoinPoint joinPoint, Object obj) {
        System.out.println(joinPoint.getSignature().getName() + "计算正常返回...结果是:{" + obj + "}");
    }

    @AfterThrowing(value = "pointCut()", throwing = "e")
    public void logException(JoinPoint joinPoint, Exception e) {
        System.out.println(joinPoint.getSignature().getName() + "计算异常...异常是:{" + e + "}");
    }

}
