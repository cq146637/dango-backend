package com.dango.common.exception;

/**
 * 自定义异常
 *
 * @author dango
 * @date 2018/9/6
 */
public class DangoException extends RuntimeException {

    private Integer code;

    public DangoException(Integer code, String message) {
        super(message);
        this.code = code;
    }

    public DangoException(String message) {
        this(400, message);
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }
}
