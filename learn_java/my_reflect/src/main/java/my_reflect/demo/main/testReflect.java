package my_reflect.demo.main;

import my_reflect.demo.entity.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.DateFormat;
import java.util.Date;

/**
 * @Description TODO
 * @Author Administrator
 * @Date 2020/8/17 14:03
 */
public class testReflect {
    private static Logger logger = LoggerFactory.getLogger(testReflect.class);

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchFieldException, InvocationTargetException, NoSuchMethodException {
        //demo3();

        //demo4();

        //demo5();

        //demo6();

       // demo7();

        demo8();

    }

    /**
     * 1. 通过 反射获取 对象的 类名 和 包名(含路径)
     */
    public static void getClassNameAndPackageNameByReflect() {
        Person person = new Person();
        Class Clazz = person.getClass();
        Package packageName = person.getClass().getPackage();
        String name = person.getClass().getPackage().getName();

        //+ "包名称:%s" + packageName + "包名称:%s" + name
        logger.info("类名称:{},包名称:{},包名称2:{}", Clazz, packageName, name);
    }

    /**
     * 2.验证所有的类 都是Class的实例对象
     * 两种 输出内容一致
     */
    public static void demo2() throws ClassNotFoundException {
        Class<?> clazz1 = null;
        clazz1 = Class.forName("my_reflect.demo.entity.Person");
        logger.info("clazz的值:{}", clazz1);

        Class<Person> clazz2 = Person.class;
        logger.info("clazz2:{}", clazz2);
    }

    /**
     * 3.通过 反射机制, 用Class创建类对下你给[这也就是反射存在的意义所在]
     */
    public static void demo3() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        Class<?> clazz = Class.forName("my_reflect.demo.entity.Person");

        Person person = (Person) clazz.newInstance();

        person.setAge(18);
        person.setName("张安");
        person.setBirthday(new Date());
        person.setSex("男");
        logger.info("person:{}", person);
    }

    /**
     * 4.通过反射获取 类的构造函数,并实现创建带参实例对象
     */
    public static void demo4() throws ClassNotFoundException, IllegalAccessException, InvocationTargetException, InstantiationException {

        Class<?> clazz = Class.forName("my_reflect.demo.entity.Person");
        Constructor<?>[] constructors = clazz.getConstructors();

        Person person = (Person) constructors[0].newInstance();
        person.setName("李四");
        person.setSex("男人");
        person.setBirthday(new Date());
        person.setAge(40);

        Person person2 = (Person) constructors[1].newInstance("李四2", "男人2", 402, new Date());

        logger.info("person1:{}", person);
        logger.info("person2:{}", person2);
    }

    /**
     * 5.通过反射机制 操作成员变量 set 和 get
     */
    public static void demo5() throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        Class<?> clazz = null;

        clazz = Class.forName("my_reflect.demo.entity.Person");

        Object o = clazz.newInstance();


        Field name = clazz.getDeclaredField("name");

        name.setAccessible(true);
        name.set(o, "爱德森");
        logger.info("Obj:{}", name.get(o));
    }

    /**
     * 6.通过反射 得到类的一些属性: 继承的接口,父类,函数信息,成员信息,类型等
     */
    public static void demo6() throws ClassNotFoundException {
        Class<?> clazz = Class.forName("my_reflect.demo.entity.Person");
        /**
         * 获取属性信息
         */
        Field[] declaredFields = clazz.getDeclaredFields();
        for (int i = 0; i < declaredFields.length; i++) {
            logger.info("声明的属性变量:{}", declaredFields[i]);
        }

        /**
         * 获取方法信息
         */
        Method[] declaredMethods = clazz.getDeclaredMethods();
        for (int i = 0; i < declaredMethods.length; i++) {
            logger.info("方法信息:{}", declaredMethods[i]);
        }
        /**
         * 获取父类信息
         */
        Class<?> superclass = clazz.getSuperclass();
        logger.info("person的父类:{}", superclass.getName());

        /**
         * 获取实现的接口信息
         */
        Class<?>[] interfaces = clazz.getInterfaces();
        for (int i = 0; i < interfaces.length; i++) {
            logger.info("实现的接口信息:{}", interfaces[i]);
        }

    }

    /**
     * 通过反射 获取 类的方法
     */
    public static void demo7() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {

        Class<?> clazz = Class.forName("my_reflect.demo.entity.Person");
        Method method = clazz.getDeclaredMethod("getHello", String.class);

        Object result = method.invoke(clazz.newInstance(), "This is mainTest invoke");
        logger.info("调用getHello返回结果:{}", result);
    }

    /**
     * 获取类加载器
     *  在java中有三种类类加载器。[这段资料网上截取]
     * 		1）Bootstrap ClassLoader 此加载器采用c++编写，一般开发中很少见。
     * 		2）Extension ClassLoader 用来进行扩展类的加载，一般对应的是jre\lib\ext目录中的类
     * 		3）AppClassLoader 加载classpath指定的类，是最常用的加载器。同时也是java中默认的加载器
     */
    public static void demo8() throws ClassNotFoundException {
        Class<?> clazz = null;
        clazz = Class.forName("my_reflect.demo.entity.Person");
        String name = clazz.getClassLoader().getClass().getName();
        logger.info("类加载器的名称:{}", name);
    }
}
