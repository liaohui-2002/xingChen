package com.liaohui.exception;
/**
 * @author liaohui
 * @date 2022/10/30 18:45
 */
public class CustomException  extends RuntimeException{

    private String msg;
    private Integer code;

    public CustomException(String msg){
        super(msg);
        this.msg = msg;
    }

    public CustomException(Integer code, String msg){
        super(msg);
        this.code = code;
        this.msg = msg;
    }
}
