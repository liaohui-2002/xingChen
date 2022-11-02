package com.liaohui.controller;

import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.liaohui.common.Resp;
import com.liaohui.common.State;
import com.liaohui.domain.Post;
import com.liaohui.service.IPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

/**
 * @author liaohui
 * @date 2022/10/31 15:19
 */
@RestController
@RequestMapping("/post")
public class PostController {


    @Autowired
    IPostService postService;
    /**
     * 新增帖子
     * @param post
     * @return
     */
    @PostMapping("/add")
    public Resp addPost(@RequestBody Post post){
        postService.insert(post);
        return Resp.success(State.OK);
    }

    /**
     * 根据id查询
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Resp getPostById(@PathVariable("id") Long id){
        Post post = postService.findById(id);

        return Resp.success(State.OK,post);
    }

    /**
     * 修改帖子
     * @param post
     * @return
     */
    @PutMapping("/update")
    @PreAuthorize("hasAuthority('put')")
    public Resp updatePostById(@RequestBody Post post){

        LambdaUpdateWrapper<Post> wrapper = new LambdaUpdateWrapper<>();
        //找到要修改的目标
        wrapper.eq(Post::getId,post.getId());
        //进行修改
        wrapper.set(Post::getMessage,"失败总是贯穿人生始终！");
        postService.update(wrapper);

        return Resp.success(State.OK);
    }

    /**
     * 根据id删除帖子
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('del')")
    public Resp deleteById(@PathVariable("id") Long id){
        postService.removeById(id);
        return Resp.success(State.OK);
    }
}
