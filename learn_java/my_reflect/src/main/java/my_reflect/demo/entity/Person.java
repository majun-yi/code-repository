package my_reflect.demo.entity;

import my_reflect.demo.service.testService;

import java.util.Date;

/**
 * @Description 提供一个实体类, getter/setter/无参构造/有参构造/toString方法
 * @Author Administrator
 * @Date 2020/8/17 14:05
 */
public class Person  extends SuperMan implements testService{
    private String name;
    private String sex;
    private Integer age;
    private Date birthday;

    public Person() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Person(String name, String sex, Integer age, Date birthday) {
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                ", birthday=" + birthday +
                '}';
    }

    @Override
    public String getStr() {
        return "This is Class of Person,extends interface testService!!";
    }

    public String getHello(String name) {
        return "Hello a "+name;
    }
}
