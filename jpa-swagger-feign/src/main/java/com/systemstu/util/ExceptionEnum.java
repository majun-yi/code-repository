package com.systemstu.util;

public enum ExceptionEnum {
    MESSAGE_NOT_FOUND(404, "信息不存在");
    private Integer code;
    private String message;

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    ExceptionEnum() {
    }

    ExceptionEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getMessage(Integer code) {
        for (ExceptionEnum e : ExceptionEnum.values()
        ) {
            if (e.getCode() == code) {
                return e.getMessage();
            }
        }
        return null;
    }
}
