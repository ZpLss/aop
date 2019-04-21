package com.yhfund.controller;

import com.yhfund.bean.Student;
import javafx.application.Application;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * Created with IntelliJ IDEA.
 *
 * @author : 张鹏
 *         Date: 2018/8/15
 *         Time: 16:49
 *         Description:
 */
public class Test {

    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");

        Student student = (Student) ctx.getBean("student");
        student.add("wuj");
    }
}
