package com.coddffee.annotationbeans;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

/**
 * XML与注解混合配置时，可在XML文件中添加<context:annotation-config/>标签指定可使用注解配置
 *
 * 使用注解方式配置bean的元数据时需定义一个配置类对全局依赖关系进行配置
 *
 * bean的实例化：
 * 1.@Component : 修饰类，组件的通用形式，用于指示将POJO类实例化到IoC容器中，只能创建修饰类型的单个bean, 相当于<bean>标签的作用，
 *   其value属性用于设置bean的name
 * 2.@Repository : @Component的另一种形式，用于持久化层
 * 3.@Service : @Component的另一种形式，用于服务层
 * 4.@Controller : @Component的另一种形式，用于控制层
 * 5.@Scope : 设置bean的作用域，例如 @Scope("prototype")
 * 6.@ComponentScan : 修饰类(Spring配置类), 用于指定Spring扫描的包及排除项和包含项，
 *   获取IoC容器实例时传入配置类即可指定扫描包，例如：
 *   ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
 *
 * 依赖注入：
 * 1.@Required(Spring5.1弃用) : 用于修饰bean属性的setter, 用于指示bean属性再配置期间
 *   必须通过显示设置属性值或自动装配的方式进行注入，否则抛出BeanInitializationException
 * 2.@Autowired : 根据类型自动注入，可用于修饰构造器、属性、setter方法、任意方法和参数，
 *   具有一个属性 "boolean required()", 注意：
 *     (1)@Autowired修饰构造器时，如果构造器有参数则会先实例化参数
 *     (2)@Autowired修饰方法时，会在bean实例化完成后调用@Autowired修饰的方法，如果有参数则先实例化参数
 * 3.@Primary : 指定某类型的诸侯选自动注入bean, 可修饰类和方法
 * 4.@Qualifier : 根据bean名称或id匹配注入，可修饰类、属性、方法和参数
 * 5.@Resource : javax中的注解，除了根据bean名称匹配还根据类型进行匹配注入，相当于 @Autowired + @Qualifier
 * 6.@Value : 直接注入属性值(setter注入)，可使用EL表达式，例如：@Value("${employee1.group}"),
 *   或SpEL表达式：@Value("#{employee1.group}")
 *
 * Bean的配置 :
 * 1.@Bean : 用于修饰方法，方法的返回值会被放入IoC容器，常用属性：
 *   String value/name : 设置bean的name
 *   boolean autowireCandidate : 是否为自动装配候选bean
 *   String initMethod : 指定bean类型的初始化回调
 *   String destroyMethod : 指定bean类型的销毁回调
 * 2.@Configuration : @Component的另一种形式，用于修饰类，指示此类为一个bean配置类，此类用于定义bean
 * 3.@Import : 用于修饰配置类，将其它配置类中的配置导入

 * 生命周期回调：
 * 1.@PostConstruct : javax中的注解，用于修饰方法，指定bean类型的初始化回调，相当于init-method
 * 2.@PreDestroy : javax中的注解，用于修饰方法，指定bean类型的销毁回调，相当于destroy-method
 * 3.@Bean中的initMethod属性指定bean类型的初始化回调
 * 4.@Bean中的destroyMethod属性指定bean类型的销毁回调
 * 5.实现InitializingBean接口并重写afterPropertiesSet方法
 * 6.实现DisposableBean接口并重写destroy方法
 */

@Component("employee")
public class Employee {

    @Value("1")
    private int id;
    @Value("Tony")
    private String name;
    @Autowired
    @Qualifier("group1")
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

    @PostConstruct
    public void initialize() {
        System.out.println("[Employee] : I am initialized.");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("[Employee] : I am destroyed.");
    }

}
