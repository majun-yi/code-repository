package com.test.enums;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public enum HTMLPageEnum {
    /**
     * 第三步：定义基本枚举值
     */
    PAGE_LIST("列表页面", 0),
    PAGE_DETAIL("详情页面", 1),
    PAGE_MONEY("佣金页面", 2),
    PAGE_TICKET("发票页面", 3);

    /**
     * 第一步：声明属性
     */
    private Integer code;
    private String name;

    /**
     * 第二步： 创建构造方法
     */
    HTMLPageEnum(String name, Integer code) {
        this.name = name;
        this.code = code;
    }

    /**
     * 第四步：提供getter方法（注意：不提供setter方法，保证枚举的唯一性）
     */
    public Integer getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    /**
     * 提供 自定义方法（可选）：
     * 1.根据code获取name
     * 2.根据name获取key
     * 3.获取枚举类的集合信息
     */
    /**
     * 1.根据code获取name
     *
     * @param code
     */
    public static String getName(Integer code) {
        for (HTMLPageEnum h : HTMLPageEnum.values()
        ) {
            if (h.getCode() == code) {
                return h.name;
            }
        }
        return null;
    }

    /**
     * 2.根据name获取code
     */
    public static Integer getCode(String name) {
        for (HTMLPageEnum h : HTMLPageEnum.values()
        ) {
            if (h.getName().equals(name)) {
                return h.code;
            }
        }
        return null;
    }

    /**
     * 3.将枚举值封装 至集合
     */
    private static List<Map> list = new ArrayList<>();

    static {
        for (HTMLPageEnum h : HTMLPageEnum.values()
        ) {
            Map<Integer, String> map = new HashMap<>();
            map.put(h.code, h.name);
            list.add(map);
        }
    }
    public static List<Map> getList(){
        return list;
    }
}
