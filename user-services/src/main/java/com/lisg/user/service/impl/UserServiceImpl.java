package com.lisg.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lisg.common.response.BizException;
import com.lisg.common.response.ResponseEnum;
import com.lisg.common.util.IdGeneraator;
import com.lisg.user.util.JwtTokenUtils;
import com.lisg.user.util.PasswordUtil;
import jakarta.servlet.http.HttpServletResponse;
import com.lisg.user.model.dto.UserRegisterDTO;
import com.lisg.user.model.entity.User;
import com.lisg.user.mapper.UserMapper;
import com.lisg.user.service.UserService;
import org.springframework.beans.BeanUtils;
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
    public User register(UserRegisterDTO userRegisterDTO) {
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.eq("phone", userRegisterDTO.getPhone()).or().eq("email", userRegisterDTO.getEmail());
        Long count = userMapper.selectCount(userQueryWrapper);
        if (count > 0) {
            throw new BizException("用户已存在", ResponseEnum.ERROR.getResultCode());
        }

        User user = new User();
        BeanUtils.copyProperties(userRegisterDTO, user);
        user.setUid(IdGeneraator.generateUserId());
        String password = PasswordUtil.encode(user.getPassword());
        user.setPassword(password);
        userMapper.insert(user);
        return user;
    }

    @Override
    public String login(HttpServletResponse response, User user) {
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.eq("phone", user.getPhone()).or().eq("email", user.getEmail());
        User dbUser = userMapper.selectOne(userQueryWrapper);
        if (dbUser == null) {
            throw new BizException("用户不存在", ResponseEnum.ERROR.getResultCode());
        }
        boolean matches = PasswordUtil.matches(user.getPassword(), dbUser.getPassword());
        if (!matches) {
            throw new BizException("密码错误", ResponseEnum.ERROR.getResultCode());
        }
        String token = JwtTokenUtils.sign(dbUser);
        response.setHeader("token", token);
        return "登录成功";
    }
}
