package com.yhfund.aop;

import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 张鹏
 *         Date: 2018/8/15
 *         Time: 18:02
 *         Description:
 */
@Component  //加入到IOC容器
public class LoginHander {

    public void before() throws Throwable {
        System.out.println("进来的，真好");
    }
}
