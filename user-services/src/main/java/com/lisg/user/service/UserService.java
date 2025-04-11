package com.lisg.user.service;

import model.entity.User;

public interface UserService {

    User getUserById(Long id);

    User register(User user);
}
