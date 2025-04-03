package com.lisg.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import model.entity.User;

public interface UserMapper extends BaseMapper<User> {
    // 这里可以添加自定义的查询方法
    // 例如：List<User> findByUsername(String username);
}
