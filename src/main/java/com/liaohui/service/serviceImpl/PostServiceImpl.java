package com.liaohui.service.serviceImpl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.liaohui.domain.Post;
import com.liaohui.exception.CustomException;
import com.liaohui.mapper.PostMapper;
import com.liaohui.service.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

/**
 * @auther Mr.Liao
 * @date 2022/10/31 17:46
 */
@Service
@Transactional
public class PostServiceImpl extends ServiceImpl<PostMapper, Post> implements IPostService {

    @Autowired
    PostMapper postMapper;
    @Override
    public void insert(Post post) {
        //根据创建人。类型查询最近一次发帖记录，和当前时间比较是否大于一个小时
        Post post1 = postMapper.getByTypeAndUser(post.getUserId(), post.getPostType());
        if(post1!=null){
            long now = LocalDateTime.now().toInstant(ZoneOffset.of("+8")).toEpochMilli();
            long latest = post1.getCreateTime().toInstant(ZoneOffset.of("+8")).toEpochMilli();
            if (now-latest<=60000){
                throw new CustomException("不要在一分钟内重复发同类型帖子！");
            }
        }

        int id = postMapper.insert(post);
        if(id<=0){
            throw new CustomException("插入失败！");
        }
    }
    @Override
    public Post findById(Long id) {
        Post post = getById(id);
        if(post == null){
            throw new CustomException("用户不存在！");
        }
        return post;
    }


}
