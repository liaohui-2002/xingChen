package com.liaohui.domain;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

/**
 * @auther Mr.Liao
 * @date 2022/10/31 15:12
 */
@Data
@TableName(value = "post")
public class Post {

    //帖子ID 主键
    @TableId(type = IdType.AUTO)
    private  Long id;
    //创建人 兼修改人
    private Long userId;

    //发布时间
    @DateTimeFormat(style = "yyyy-MM-dd HH:mm:ss")
    @TableField(fill=FieldFill.INSERT)//插入时填充字段
    private LocalDateTime createTime;

    //更新时间
    @DateTimeFormat(style = "yyyy-MM-dd HH:mm:ss")
    @TableField(fill= FieldFill.INSERT_UPDATE)//插入和更新时填充字段
    private LocalDateTime updateTime;

    //标题
    private String title;

    //内容
    private String Message;

    //图片链接
    private String imageLinks;
    //附件链接
    private String attachmentLinks;

    private Integer postType;

}
