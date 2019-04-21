package com.yhfund.bean.impl;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 张鹏
 *         Date: 2018/8/15
 *         Time: 17:21
 *         Description:
 */
public class RoundAdvice implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        String s = invocation.getArguments()[0].toString();
        Object result= null;
        if (s.equals("wuji")){
            result = invocation.proceed();
        }else {
            System.out.println("不是wuji: 是 "+ s);
        }
        return result;
    }
}
