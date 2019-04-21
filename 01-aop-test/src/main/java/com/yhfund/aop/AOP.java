package com.yhfund.aop;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 张鹏
 *         Date: 2018/8/20
 *         Time: 17:21
 *         Description:
 */
@Component  //加入到ioc容器
@Aspect     //指定当前类为切面类
public class AOP {

    //指定切入点表达式，拦截那些方法，即为那些类生成代理对象
//     @Pointcut("execution(* com.bie.aop.UserDao.save(..))")  ..代表所有参数
//     @Pointcut("execution(* com.bie.aop.UserDao.*())")  指定所有的方法
//     @Pointcut("execution(* com.bie.aop.UserDao.save())") 指定save方法

    @Pointcut("execution(* com.yhfund.controller.TestController.*(..))")
    public void pointCut(){}
    @Pointcut("execution(* com.yhfund.controller..*(..))")
    public void pointCutAfter(){}

    @Before("pointCut()")
    public void before(JoinPoint joinpoint){
        //获取方法名
        String name = joinpoint.getSignature().getName();

        //获取参数列表
        List<Object> args = Arrays.asList(joinpoint.getArgs());

        System.out.println("开启事务");
    }
    @After("pointCutAfter()")
    public void after(){
        System.out.println("关闭事务");
    }

}
