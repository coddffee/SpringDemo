package com.coddffee.annotationbeans;

import org.springframework.context.annotation.*;

/* 设置包扫描路径及排除项 */
@ComponentScan(
        value = "com.coddffee.annotationbeans",
        excludeFilters = {
                @ComponentScan.Filter(value = Test.class, type = FilterType.ASSIGNABLE_TYPE),
                @ComponentScan.Filter(value = SpringConfig.class, type = FilterType.ASSIGNABLE_TYPE)})
public class SpringConfig {
    public SpringConfig() {super();}
}
