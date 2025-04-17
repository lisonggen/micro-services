package com.lisg.user.model.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @program: micro-services
 * @description:
 * @author: Reagan Li
 * @create: 2025-04-03 17:06
 **/

@Data
@NoArgsConstructor
@TableName("user")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "uid")  // 主键自增
    private String uid;

    private String username;
    private String password;
    private String phone;
    private String email;
    private String photo;
    private String role;
    private String message;

    @TableField(fill = FieldFill.INSERT)  // 自动填充创建时间
    private LocalDateTime createTime;

    @TableField(fill = FieldFill.INSERT_UPDATE)  // 自动填充更新时间
    private LocalDateTime updateTime;

    public User(String uid, String username, String role) {
        this.uid = uid;
        this.username = username;
        this.role = role;
    }

    public User(String username, String password, String phone, String email) {
        this.username = username;
        this.password = password;
        this.phone = phone;
        this.email = email;
    }
}
