package com.yhfund.bean;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 张鹏
 *         Date: 2018/9/28
 *         Time: 16:08
 *         Description:
 */
public class Worker {
    String name;
    String age;

    public Worker(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public Worker(String name, String age) {
        this.name = name;
        this.age = age;
    }
}
