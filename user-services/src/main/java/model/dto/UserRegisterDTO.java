package model.dto;

import lombok.Data;

/**
 * @program: micro-services
 * @description:
 * @author: Reagan Li
 * @create: 2025-04-11 17:20
 **/

@Data
public class UserRegisterDTO {

    private String username;
    private String password;
    private String phone;
    private String email;

}
