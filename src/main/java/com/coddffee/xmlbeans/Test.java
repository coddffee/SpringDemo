package com.coddffee.xmlbeans;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/********** 基于XML的配置 **********/
public class Test {

    private final String path = "classpath:com/coddffee/xmlbeans/";

    public Test() {
        super();
    }

    @org.junit.Test
    public void test1() {
        ApplicationContext context = new ClassPathXmlApplicationContext(path + "beans.xml");
        Employee employee = context.getBean("employee1",Employee.class);
        System.out.println(employee);
    }

    @org.junit.Test
    public void test2() {
        ApplicationContext context = new ClassPathXmlApplicationContext(path + "beans.xml");
        Employee employee = context.getBean("employee2",Employee.class);
        System.out.println(employee);
    }

    @org.junit.Test
    public void test3() {
        ApplicationContext context = new ClassPathXmlApplicationContext(path + "beans.xml");
        Employee employee = context.getBean("dismissedEmployee",Employee.class);
        System.out.println(employee);
    }

    @org.junit.Test
    public void test4() {
        ApplicationContext context = new ClassPathXmlApplicationContext(path + "beans.xml");
        Employee employee = context.getBean("employee3",Employee.class);
        System.out.println(employee);
    }

    @org.junit.Test
    public void test5() {
        ApplicationContext context = new ClassPathXmlApplicationContext(path + "beans.xml");
        Employee employee = context.getBean("employee4",Employee.class);
        System.out.println(employee + "department-" + employee.getGroup().getDepartment());
    }

    @org.junit.Test
    public void test6() {
        ApplicationContext context = new ClassPathXmlApplicationContext(path + "beans.xml");
        Group group = context.getBean("group2", Group.class);
        System.out.println(group.getName() + " employees : ");
        for (Employee employee : group.getEmployees()) {
            System.out.print(employee.getName() + " ");
        }
        System.out.println(".");
    }

    @org.junit.Test
    public void test7() {
        ApplicationContext context = new ClassPathXmlApplicationContext(path + "beans.xml");
        Employee employee = context.getBean("employee5", Employee.class);
        System.out.println(employee);
    }

    @org.junit.Test
    public void test8() {
        ApplicationContext context = new ClassPathXmlApplicationContext(path + "beans.xml");
        Employee employee = context.getBean("employee6", Employee.class);
        System.out.println(employee);
    }

    @org.junit.Test
    public void test9() {
        ApplicationContext context = new ClassPathXmlApplicationContext(path + "beans.xml");
        Group group = context.getBean("group3", Group.class);
        System.out.println(group);
    }

    @org.junit.Test
    public void test10() {
        ApplicationContext context = new ClassPathXmlApplicationContext(path + "beans.xml");
        Employee employee = context.getBean("employee8", Employee.class);
        System.out.println(employee);
        System.out.println(employee.getGroup());
        System.out.println(employee.getGroup().getDepartment());
    }

}
