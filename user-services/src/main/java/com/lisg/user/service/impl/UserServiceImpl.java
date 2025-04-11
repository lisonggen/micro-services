package com.lisg.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lisg.common.response.BizException;
import com.lisg.common.response.ResponseEnum;
import com.lisg.common.util.IdGeneraator;
import com.lisg.user.util.MD5Util;
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

    @Override
    public User register(User user) {
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.eq("phone", user.getPhone()).or().eq("email", user.getEmail());
        Long count = userMapper.selectCount(userQueryWrapper);
        if (count > 0) {
            throw new BizException("用户已存在", ResponseEnum.ERROR.getResultCode());
        }

        user.setUid(IdGeneraator.generateUserId());
        String password = MD5Util.getPassword(user.getPassword());
        user.setPassword(password);
        userMapper.insert(user);
        return user;
    }

}
