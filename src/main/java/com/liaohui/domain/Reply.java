package com.liaohui.domain;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author liaohui
 * @date 2022/10/31 17:16
 */
@Data
@TableName(value = "reply")
public class Reply {

    //评论Id 主键
    @TableId
    private Long id;

    //关联的帖子id
    private Integer postId;

    //评论人Id
    private Integer userId;

    //评论内容
    private String replyMsg;
    //上级评论id
    private Integer parentedReplyId;

    //评论时间
    private LocalDateTime dateTime;

}
