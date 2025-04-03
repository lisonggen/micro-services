package com.lisg.user.service.impl;

import model.entity.User;
import com.lisg.user.mapper.UserMapper;
import com.lisg.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: micro-services
 * @description:
 * @author: Reagan Li
 * @create: 2025-04-03 17:11
 **/

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User getUserById(Long id) {
        return userMapper.selectById(id);
    }
}
