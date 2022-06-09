package com.coddffee;

import java.lang.reflect.Method;
import java.lang.reflect.Type;

/**
 * IoC也称为依赖注入(DI), org.springframework.beans包和org.springframework.context包是Spring-IoC的核心。
 * Spring中构成应用程序主干并由IoC容器管理的对象称为bean.
 * org.springframework.context.ApplicationContext接口代表Spring-IoC容器，负责实例化、配置和组装bean.
 * ClassPathXmlApplicationContext是ApplicationContext的实现之一，通过XML文件配置bean的元数据(MetaData).
 * Spring-IoC容器工作的高级视图：业务对象(POJOs)输入到IoC容器，IoC容器根据使用XML文件或注解配置的MetaData生产出完全配置的系统。
 * Spring-IoC元数据的配置可采用XML方式以及注解方式。
 */

public class App {
    public static void main( String[] args ) {
        System.out.println("Hello Springframework.");
    }
}
