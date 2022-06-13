package com.coddffee.annotationbeans;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {
    public Test() {
        super();
    }

    @org.junit.Test
    public void test1() {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        Employee employee = context.getBean("employee",Employee.class);
        System.out.println(employee);
    }

}
