package com.gyb;

import com.gyb.annotation.TimeStatistic;
import com.gyb.config.TimeConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * Description:
 *
 * @author GB
 * @date 2022/1/14 19:10
 *
 * <pre>
 *              www.dustess.com
 *      Copyright (c) 2022. All Rights Reserved.
 * </pre>
 */
@Component("test")
public class Test2 {



    @TimeStatistic(desc = "测试")
    public  void test() throws InterruptedException {
        TimeUnit.SECONDS.sleep(1);
        System.out.println("开始");


    }


    public static void main(String[] args) throws InterruptedException {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(TimeConfiguration.class);
        Test2 test = (Test2) applicationContext.getBean("test");
        test.test();
    }



}
