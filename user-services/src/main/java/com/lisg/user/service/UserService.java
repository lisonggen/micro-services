package com.lisg.user.service;

import jakarta.servlet.http.HttpServletResponse;
import model.dto.UserRegisterDTO;
import model.entity.User;

public interface UserService {

    User getUserById(Long id);

    User register(UserRegisterDTO user);

    String login(HttpServletResponse response, User user);
}
