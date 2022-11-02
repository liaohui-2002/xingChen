package com.liaohui;

import com.liaohui.domain.User;
import com.liaohui.mapper.UserMapper;
import org.junit.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @author Mr.lh
 * @date 2022/11/2 22:07
 */
@SpringBootTest
@MapperScan
public class MapperTest {

    @Autowired
    private UserMapper userMapper;
    @Test
    public void testUserMapper(){
        List<User> users = userMapper.selectList(null);
        System.out.println(users);
    }
}
