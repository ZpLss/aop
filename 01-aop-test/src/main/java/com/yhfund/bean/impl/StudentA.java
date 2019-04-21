package com.yhfund.bean.impl;

import com.yhfund.bean.Student;
import org.springframework.stereotype.Component;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 张鹏
 *         Date: 2018/8/15
 *         Time: 15:45
 *         Description:
 */
@Component
public class StudentA implements Student {
    private String age; // 年龄
    private String name; // 名字

    private Boolean yes;
    private Integer ages;

    private String sex;

    public StudentA(){}

    public StudentA(String age, String name) {
        this.age = age;
        this.name = name;
        if (true) {

        }
    }

    @Override
    public String toString() {
        return "StudentA{" +
                "age='" + age + '\'' +
                ", name='" + name + '\'' +
                ", yes=" + yes +
                ", ages=" + ages +
                ", sex='" + sex + '\'' +
                '}';
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void add( String s) {
        System.out.println( s + ":祖国你好！");
    }
}
