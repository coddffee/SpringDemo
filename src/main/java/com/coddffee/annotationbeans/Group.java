package com.coddffee.annotationbeans;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.List;

public class Group {

    private String name;
    private Department department;
    private List<Employee> employees;
    private Employee leader;

    public Group() {
        super();
    }

    public Group(String name, Department department) {
        this.name = name;
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public Employee getLeader() {
        return leader;
    }

    public void setLeader(Employee leader) {
        this.leader = leader;
    }

    @Override
    public String toString() {
        return "name:" + name + "," + "department:" + (department == null ? "none" :  department.getName()) + ".";
    }

    public void initialize() {
        System.out.println("[Group] : I am initialized.");
    }

    public void destroy() {
        System.out.println("[Group] : I am destroyed.");
    }

}
