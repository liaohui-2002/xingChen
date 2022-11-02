package com.liaohui.common;

/**
 * @auther Mr.Liao
 * @date 2022/10/31 23:05
 */
public enum State {
    OK(200, "成功"),
    FAIL(500, "失败");




    public Integer code;
    public String msg;

    State(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
