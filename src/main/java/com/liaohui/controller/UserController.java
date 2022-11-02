package com.liaohui.controller;

import com.liaohui.common.Resp;
import com.liaohui.common.State;
import com.liaohui.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @auther Mr.Liao
 * @date 2022/10/30 16:18
 */
@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    IUserService UserService;

    @GetMapping("/{username}")
    public Resp getByUsername(@PathVariable("username") String username) {
        log.info("根据用户名查询{}", username);
        UserService.selectByUsername(username);
        Resp resp = Resp.success(State.OK);
        return resp;
    }
}
