package com.liaohui.common;

import lombok.Data;

/**
 * @auther Mr.Liao
 * @date 2022/10/30 16:36
 */
@Data
public class Resp {
    private Integer code; //编码：1成功，0和其它数字为失败
    private String msg; //错误信息
    private Object data;

    public Resp() {
    }

    private Resp(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    private Resp(Integer code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static Resp success(State state) {
        return new Resp(state.code, state.msg);
    }
    public static Resp success(State state, Object data) {
        return new Resp(state.code, state.msg, data);
    }

    public static Resp error(State state) {
        return new Resp(state.code, state.msg);
    }

    public static Resp error(State state, String customerMsg) {
        return new Resp(state.code, customerMsg);
    }

    public Integer getCode() {
        return code;
    }


    public String getMsg() {
        return msg;
    }



    public Object getData() {
        return data;
    }

}
