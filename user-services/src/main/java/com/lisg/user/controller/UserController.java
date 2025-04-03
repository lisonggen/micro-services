package com.lisg.user.controller;

import com.lisg.user.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import model.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: micro-services
 * @description:
 * @author: Reagan Li
 * @create: 2025-04-03 16:02
 **/

@Tag(name = "用户管理", description = "提供用户相关的 API 接口")
@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Operation(summary = "测试接口", description = "用于测试的接口")
    @GetMapping("/hello")
    public String hello() {
        return "Hello World!";
    }

    @Operation(summary = "通过uid 获取 user", description = "通过uid 获取 user")
    @GetMapping("/id/{uid}")
    public User getById(@PathVariable Long uid) {
        return userService.getUserById(uid);
    }


}
