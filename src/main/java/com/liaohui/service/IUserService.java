package com.liaohui.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.liaohui.domain.User;

/**
 * @auther Mr.Liao
 * @date 2022/10/30 16:15
 */
public interface IUserService extends IService<User> {
    public User selectByUsername(String username);
}
