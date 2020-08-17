package my_reflect.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MyReflectApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyReflectApplication.class, args);
        System.out.println("我是module:");
    }

}
