package com.liaohui.service;

import com.liaohui.common.Resp;
import com.liaohui.domain.User;

/**
 * @author Mr.lh
 * @date 2022/11/2 22:36
 */
public interface LoginService {
    Resp login(User user);

    Resp logout();

}
