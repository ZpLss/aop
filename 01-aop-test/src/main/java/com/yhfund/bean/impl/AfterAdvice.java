package com.yhfund.bean.impl;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 张鹏
 *         Date: 2018/8/15
 *         Time: 17:20
 *         Description:
 */
public class AfterAdvice implements MethodBeforeAdvice {
    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {
        System.out.println("这是后置通知。。。");
    }
}
