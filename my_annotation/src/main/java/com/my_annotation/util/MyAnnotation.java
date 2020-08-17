package com.my_annotation.util;

/**
 * 一.自定义注解类型(要求和规范):
 * 1.访问修饰符必须为public，不写默认为public；
 * 2.该元素的类型只能是基本数据类型、String、Class、枚举类型、注解类型（体现了注解的嵌套效果）以及上述类型的一位数组；
 * 3.该元素的名称一般定义为名词，如果注解中只有一个元素，请把名字起为value（后面使用会带来便利操作）；
 * 4.()不是定义方法参数的地方，也不能在括号中定义任何参数，仅仅只是一个特殊的语法；
 * 5.default代表默认值，值必须和第2点定义的类型一致；
 * 6.如果没有默认值，代表后续使用注解时必须给该类型元素赋值。
 */

import java.lang.annotation.*;

/**
 * 二.元注解: 专门修饰注解的注解
 * 1.@Target :专门用来限定某个自定义注解能够被应用在哪些Java元素上面
 *      1.1  TYPE  -- 类和接口或枚举
 *      1.2  FIELD  -- 属性的声明
 *      1.3  METHOD  -- 方法
 *      1.4  PARAMETER  -- 方法形式参数声明
 *      1.5  CONSTRUCTOR  --构造方法的声明
 *      1.6  LOCAL_VARIABLE  --局部变量声明
 *      1.7  ANNOTATION_TYPE  -- 注解类型声明
 *      1.8  PACKAGE   -- 包的声明
 *
 * 2.@Retention：用来修饰自定义注解的生命周期：
 *      2.1java源文件阶段   SOURCE
 *            将被限定在Java源文件中，那么这个注解即不会参与编译也不会在运行期起任何作用，这个注解就和一个注释是一样的效果，只能被阅读Java文件的人看到
 *      2.2编译至class文件阶段   CLASS
 *            将被编译到Class文件中，那么编译器可以在编译时根据注解做一些处理动作，但是运行时JVM（Java虚拟机）会忽略它，我们在运行期也不能读取到；
 *      2.3运行时期阶段   RUNTIME  （我们实际开发中的自定义注解几乎都是使用的RetentionPolicy.RUNTIME；）
 *            可以在运行期的加载阶段被加载到Class对象中。那么在程序运行阶段，我们可以通过反射得到这个注解，并通过判断是否有这个注解或这个注解中属性的值，从而执行不同的程序代码段
 *
 *      2.4 在默认的情况下，自定义注解是使用的RetentionPolicy.CLASS。
 *
 * 3.@Documented
 *   用来指定自定义注解是否能随着被定义的java文件生成到JavaDoc文档当中。
 *
 * 4 @Inherited
 *   指定某个自定义注解如果写在了父类的声明部分，那么子类的声明部分也能自动拥有该注解。
 *   @Inherited 注解只对那些@Target被定义为ElementType.TYPE的自定义注解起作用。(类或接口级别)
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(value = {ElementType.TYPE})
@Documented
@Deprecated //指明注解 被废弃， 但可以继续使用（只是有删除线，不建议使用,这里仅为测试，该自定义注解也没有任何实质意义）
public @interface MyAnnotation {
    /**
     * 若仅仅只有一个值，可以使用 value(); ---> 默认可以直接使用，不用特意的指明为value --》例如：  @Table("student")/@Table(value = "student")
     * @return
     */
    String name();

    int age() default 18;

    int[] score();
}
