package com.systemstu.util;

/**
 * @Description TODO
 * @Author Administrator
 * @Date 2020/8/16 11:42
 */
public class MyException extends RuntimeException {
    /**
     * 异常编码
     */
    private Integer code;
    /**
     * 异常信息
     */
    private String message;

    public MyException(String message, Integer code) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * 异常描述
     * @param message
     */
    public MyException(String message) {
        super(message);
    }


    public MyException(String message, Integer code, String message1) {
        super(message);
        this.code = code;
        this.message = message1;
    }

}
