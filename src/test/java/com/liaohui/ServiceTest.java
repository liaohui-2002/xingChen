package com.liaohui;

import com.liaohui.domain.Post;
import com.liaohui.mapper.PostMapper;
import com.liaohui.service.IPostService;
import com.liaohui.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

/**
 * @auther Mr.Liao
 * @date 2022/10/30 16:46
 */
@Slf4j
@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class ServiceTest {
    @Autowired
    IUserService IUserService;

    @Autowired
    PostMapper postMapper;
    @Autowired
    IPostService postService;

    @Test
    public void testGetByUsername(){
        /*User user = IUserService.selectByUsername("13548439476");
        log.info("user:"+user);*/
    }

    @Test
    public void testPost(){
        Post post = postService.getById(1);
        System.out.println(post);
    }

    @Test
    public void testTime(){
        Post post = postMapper.selectById(7);
        Post post1 = postMapper.getByTypeAndUser(post.getUserId(), post.getPostType());
        long now = LocalDateTime.now().toInstant(ZoneOffset.of("+8")).toEpochMilli();
        long latest = post1.getCreateTime().toInstant(ZoneOffset.of("+8")).toEpochMilli();

/*        LocalDateTime localDateTime = LocalDateTime.ofEpochSecond(latest / 1000, 0, ZoneOffset.ofHours(8));
        log.info("最近时间 "+localDateTime);*/
        if (now-latest<=600000){
//            throw new CustomException("不要在一分钟内重复发同类型帖子！");
            log.info("不要在一分钟内重复发同类型帖子！");
        }
        else {
            log.info("可以正常发送！");
        }
    }
}
