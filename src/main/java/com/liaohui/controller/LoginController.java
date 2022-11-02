package com.liaohui.controller;

import com.liaohui.common.Resp;
import com.liaohui.domain.User;
import com.liaohui.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Mr.lh
 * @date 2022/11/2 22:34
 */
@RestController
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping("/user/login")
    public Resp login(@RequestBody User user){
        return loginService.login(user);
    }
}
