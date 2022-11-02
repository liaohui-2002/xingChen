package com.liaohui.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.liaohui.domain.Post;

/**
 * @auther Mr.Liao
 * @date 2022/10/31 17:45
 */
public interface IPostService extends IService<Post> {



    void insert(Post post);

    Post findById(Long id);
}
