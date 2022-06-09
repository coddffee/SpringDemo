package com.coddffee.beans;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class Employee implements InitializingBean, DisposableBean {

    private int id;
    private String name;
    private Group group;

    public Employee() {
        super();
    }

    public Employee(int id, String name, Group group) {
        this.id = id;
        this.name = name;
        this.group = group;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public static Employee fake() {
        return new Employee(0,"fake",null);
    }

    public Employee afterDismissed() {
        return new Employee(0,"ex-employee",null);
    }

    @Override
    public String toString() {
        return "id:" + id + "," + "name:" + name + "," + "group:" + (group == null ? "none" :  group.getName()) + ".";
    }

    /* 初始化回调，bean类实现InitializingBean接口 */
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("I am been initialized.");
    }
    /* 初始化回调，bean-xml中设置init-method属性为方法名，与接口方式效果一致 */
    public void init() {
        System.out.println("I am been initialized.");
    }

    /* 销毁回调，bean类实现DisposableBean接口 */
    @Override
    public void destroy() throws Exception {
        System.out.println("I am being destroyed.");
    }
    /* 销毁回调，bean-xml中设置destroy-method属性为方法名，与接口方式效果一致 */
    public void dispose() {
        System.out.println("I am being destroyed.");
    }

}
