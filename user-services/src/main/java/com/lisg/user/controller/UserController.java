package com.lisg.user.controller;

import com.lisg.common.response.BizException;
import com.lisg.common.response.ResponseEnum;
import com.lisg.common.response.ResponseResult;
import com.lisg.common.util.IdGeneraator;
import com.lisg.user.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import model.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.IdGenerator;
import org.springframework.web.bind.annotation.*;

/**
 * @program: micro-services
 * @description:
 * @author: Reagan Li
 * @create: 2025-04-03 16:02
 **/

@Tag(name = "用户管理", description = "提供用户相关的 API 接口")
@Slf4j
@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Operation(summary = "测试接口", description = "用于测试的接口")
    @GetMapping("/hello")
    public String hello() {
        log.info("user id: " + IdGeneraator.generateUserId());
        log.info("product id: " + IdGeneraator.generateProductId());
        log.info("order id: " + IdGeneraator.generateOrderId());
        return "Hello World!";
    }

    @Operation(summary = "通过uid 获取 user", description = "通过uid 获取 user")
    @GetMapping("/id/{uid}")
    public User getById(@PathVariable Long uid) {
        return userService.getUserById(uid);
    }

    @Operation(summary = "用户注册", description = "注册接口")
    @PostMapping("/register")
    public ResponseResult register(@RequestBody User user) {
        User register = userService.register(user);
        return ResponseResult.success(register);
    }


}
