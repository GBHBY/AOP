package com.gyb.aop;

import com.gyb.annotation.TimeStatistic;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * Description: 方法执行时间切面类
 *
 * @author GB
 * @date 2022/1/14 17:19
 *
 * <pre>
 *              www.dustess.com
 *      Copyright (c) 2022. All Rights Reserved.
 * </pre>
 */
@Aspect
@Component
@Slf4j
public class TimeStatisticAspect {

    private final String tag = "*=*=*=*=*=*=*=*=*=*=*=*=*=";


    /**
     * Description: 切面方法
     * author: GB
     * datetime: 2022/1/14 17:29
     */
    @Around("@annotation(com.gyb.annotation.TimeStatistic)")
    public Object timeStatistic(ProceedingJoinPoint point) {
        MethodSignature methodSignature = (MethodSignature) point.getSignature();
        Method method = methodSignature.getMethod();
        //全限定类名
        String name = method.getDeclaringClass().getName() + "." + method.getName();
        TimeStatistic annotation = method.getAnnotation(TimeStatistic.class);
        //获取方法的描述
        String desc = annotation.desc();
        long l = 0;
        Object proceed = null;
        try {
            Object[] args = point.getArgs();
            proceed = point.proceed(args);
            l = System.currentTimeMillis();

        } catch (Throwable e) {
            log.error(tag + desc + name + "()" + "代码报错，不会执行时间" + tag);
        } finally {
            long l1 = System.currentTimeMillis();
            log.info(tag + desc + name + "()" + "执行时间:{}毫秒" + tag, l1 - l);
        }
        return proceed;

    }
}
