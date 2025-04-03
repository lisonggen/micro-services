package model.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @program: micro-services
 * @description:
 * @author: Reagan Li
 * @create: 2025-04-03 17:06
 **/

@Data
@TableName("user")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "uid", type = IdType.AUTO)  // 主键自增
    private Long uid;

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
}
