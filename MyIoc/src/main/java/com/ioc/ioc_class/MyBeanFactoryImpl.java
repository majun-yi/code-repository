package com.ioc.ioc_class;

import com.ioc.ioc_interface.MyBeanFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Description TODO
 * @Author Administrator
 * @Date 2020/8/15 17:09
 */

public class MyBeanFactoryImpl implements MyBeanFactory {
    private static Logger logger = LoggerFactory.getLogger(MyBeanFactoryImpl.class);

    /**
     * 存储对象名称和已经实例化的对象映射
     */
    private static ConcurrentHashMap<String, Object> beanMap = new ConcurrentHashMap<>();

    /**
     * 存储对象名称和对应对象信息的映射
     */
    private static ConcurrentHashMap<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<>();

    /**
     * 存储存储在容器中对象的名称
     */
    private static Set<String> beanNameSet = Collections.synchronizedSet(new HashSet<>());


    @Override
    public Object getBeanName(String name) throws Exception {
        /**
         * 看有没有已经实例化的对象,有的话就直接返回
         */
        Object object = beanMap.get(name);
        if (object != null) {
            //对实例化中的对象 注入需要的参数
            setFiled(object);
        }
        return null;
    }

    public void setFiled(Object bean) throws Exception {
        Field[] declaredFields = bean.getClass().getDeclaredFields();
        for (Field field : declaredFields
        ) {
            String filedAllName = field.getType().getName();
            if (beanNameSet.contains(filedAllName)) {
                Object beanName = getBeanName(filedAllName);
                //为对象中的属性赋值
                field.setAccessible(true);
                field.set(bean, beanName);
            }
        }
    }

    public Object getObject(BeanDefinition beanDefinition) {
        String className = beanDefinition.getClassName();
        Class<?> clazz = null;
        try {
            clazz = Class.forName(className);
        } catch (ClassNotFoundException e) {
            logger.info("不同根据beanName找到bean,{}", className);
            e.printStackTrace();
            logger.error("{MyBeanFactoryImpl}类的{getObject}方法出现异常:" + e.getMessage());
        }
        return clazz;
    }

    public static void setBeanDineMap(ConcurrentHashMap<String,BeanDefinition> beanDineMap) {
        MyBeanFactoryImpl.beanDefinitionMap = beanDineMap;
    }
    public static void setBeanDineMap(Set<String> beanNameSet){
        MyBeanFactoryImpl.beanNameSet = beanNameSet;
    }
}
