package com.coddffee.annotationbeans;

import java.util.List;

public class Department {

    private String name;
    private List<Group> groups;
    private Employee leader;

    public Department() {
        super();
    }

    public Department(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Group> getGroups() {
        return groups;
    }

    public void setGroups(List<Group> groups) {
        this.groups = groups;
    }

    public Employee getLeader() {
        return leader;
    }

    public void setLeader(Employee leader) {
        this.leader = leader;
    }

    @Override
    public String toString() {
        return "name:" + name + ".";
    }

}
