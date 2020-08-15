package com.ioc.ioc_class;

/**
 * @Description 建立一个实体类---->存储类信息的类 (类名 / 构造函数 / 属性值 / 父类)
 * @Author Administrator
 * @Date 2020/8/15 16:30
 */
public class BeanDefinition {
    private String className;
    private String alias;
    private String superName;

    public BeanDefinition() {
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getSuperName() {
        return superName;
    }

    public void setSuperName(String superName) {
        this.superName = superName;
    }
}
