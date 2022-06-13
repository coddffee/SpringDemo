package com.coddffee.annotationbeans;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class RepositoryConfig {

    public RepositoryConfig() {super();}

    @Bean(value = "group1", initMethod = "initialize")
    public Group getGroup1() {
        return new Group("Group-1",new Department("Development"));
    }

    @Bean(value = "group2", destroyMethod = "destroy")
    public Group getGroup2() {
        return new Group("Group-2",new Department("Development"));
    }

    @Bean("group3")
    @Scope("prototype")
    public Group getGroup3() {
        return new Group("Group-3",new Department("Development"));
    }
}
