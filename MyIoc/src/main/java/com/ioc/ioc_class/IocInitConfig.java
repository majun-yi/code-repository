package com.ioc.ioc_class;

import com.ioc.ioc_interface.MyIoc;
import org.reflections.Reflections;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Description TODO 在程序启动的时候就应该将`存储类信息的类`给加载到Map中，此时建立一个启动类用于初始化被@MyIoc标记的类的信息
 * @Author Administrator
 * @Date 2020/8/15 16:34
 */

/**
 * 步骤:
 * 第一步:实现CommandLineRunner接口并重写方法
 */
@Component
@Order(value = 1)
/**
 * 注解@Order或者接口Ordered的作用是定义Spring IOC容器中Bean的执行顺序的优先级，而不是定义Bean的加载顺序，Bean的加载顺序不受@Order或Ordered接口的影响；
 */
public class IocInitConfig implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        /**
         * 第二步:创建容器
         */
        ConcurrentHashMap<String, BeanDefinition> concurrentHashMap = new ConcurrentHashMap<>();

        /**
         * 第三步:基于反射 将 自定义的 MyIoc的加载
         */
        Reflections reflection = new Reflections();
        Set<Class<?>> typeAnnotateWith = reflection.getTypesAnnotatedWith(MyIoc.class);
        /**
         * 第四部: 将信息初始进 自动以容器 MyBeanFactory
         */
        for (Class clazz : typeAnnotateWith
        ) {
            BeanDefinition beanDefinition = new BeanDefinition();
            String className = clazz.getName();
            String superClassName = clazz.getSuperclass().getName();

            beanDefinition.setClassName(className);
            beanDefinition.setSuperName(superClassName);

            concurrentHashMap.put(className, beanDefinition);
        }
        MyBeanFactoryImpl.setBeanDineMap(concurrentHashMap);
    }
}
