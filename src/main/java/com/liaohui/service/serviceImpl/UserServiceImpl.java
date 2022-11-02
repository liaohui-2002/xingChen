package com.liaohui.service.serviceImpl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.liaohui.domain.User;
import com.liaohui.exception.CustomException;
import com.liaohui.mapper.UserMapper;
import com.liaohui.service.IUserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * @auther Mr.Liao
 * @date 2022/10/30 16:16
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper,User> implements IUserService {
    @Autowired
    UserMapper userMapper;
    @Override
    public User selectByUsername(String username) {
        //进行学号校验
        boolean standard = isStandard(username);
        if(!standard){
            throw new CustomException("学号不合规");
        }
        User user = userMapper.selectByUsername(username);
        if (Objects.isNull(user)) {
            throw new CustomException("用户不存在");
        }
        return user;
    }

    private boolean isStandard(String s) {
        if(s.length()<12) {
           return false;
        }
        else if(!StringUtils.isNumeric(s.substring(0,11))){
            return false;
        } else {
            //下面这段拆分其实不再必要
            String grade = s.substring(0, 4);
            String college = s.substring(4, 6);
            String department = s.substring(6, 8);
            String classNum = s.substring(8, 10);
            String num = s.substring(10);
            return true;
        }
    }
}
