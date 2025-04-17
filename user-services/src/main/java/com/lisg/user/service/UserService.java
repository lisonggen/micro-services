package com.lisg.user.service;

import jakarta.servlet.http.HttpServletResponse;
import com.lisg.user.model.dto.UserRegisterDTO;
import com.lisg.user.model.entity.User;

public interface UserService {

    User getUserById(Long id);

    User register(UserRegisterDTO user);

    String login(HttpServletResponse response, User user);
}
