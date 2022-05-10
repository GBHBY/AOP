package com.gyb.annotation;

import org.springframework.stereotype.Component;

import java.lang.annotation.*;

/**
 * Description:计算方法运行时间的注解，将会在日志中打印以<br/>
 *  *=*=*=*=*=*=*=*=*=*=*=*=*=desc，全限定类名.方法名()执行时间:x毫秒*=*=*=*=*=*=*=*=*=*=*=*=*=
 *  格式输出
 *
 * @author GB
 * @date 2022/1/14 11:21
 *
 * <pre>
 *              www.dustess.com
 *      Copyright (c) 2022. All Rights Reserved.
 * </pre>
 */
@Target({ElementType.METHOD})
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface TimeStatistic {
    /**
     * 描述，
     * @return
     */
    String desc() default "";




}
