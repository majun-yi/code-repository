package com.ioc;

import com.ioc.ioc_class.MyBeanFactoryImpl;
import com.ioc.ioc_class.entity.Student;
import com.ioc.ioc_class.entity.User;
import com.ioc.ioc_interface.MyBeanFactory;
import org.apache.naming.factory.BeanFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.util.Assert;

@SpringBootApplication
public class IocApplication {


    public static void main(String[] args) throws Exception {
        SpringApplication.run(IocApplication.class, args);
        MyBeanFactory beanFactory = new MyBeanFactoryImpl();
        User user1 = (User) beanFactory.getBeanName("com.ioc.ioc_class.entity.User");
        User user2 = (User) beanFactory.getBeanName("com.ioc.ioc_class.entity.User");
        System.out.println("user1:"+user1);
        System.out.println("user2:"+user2);

        Student student1 = user1.getStudent();
        Student student2 = user2.getStudent();
        Student student3 = (Student) beanFactory.getBeanName("com.ioc.ioc_class.entity.Student");


        System.out.println("student1:"+student1);
        System.out.println("student2:"+student2);
        System.out.println("student3:"+student3);

    }

}
