package com.liaohui.domain;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author liaohui
 * @date 2022/10/30 16:04
 */
@Data
@TableName(value = "user")
public class User {
    //主键
    @TableId
    private Long id;
    private String username;
    private String password;
    private Integer age;

    private String phoneNum;

    private String idNum;

    public Long getId() {
        return id;
    }
}
