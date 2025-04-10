package com.lisg.common.response;

import lombok.Getter;

/**
 * @program: micro-services
 * @description:
 * @author: Reagan Li
 * @create: 2025-04-10 14:02
 **/

@Getter
public enum ResponseEnum {

    SUCESS(1000,"请求成功！"),
    ERROR(9999,"请求失败！"),
    TOKEN_ERROR(4001,"请求TOKEN错误！"),
    TOKEN_NULL(4002,"请求TOKEN为空！"),
    FORBBIDEN(5000,"禁止此操作！");

    private int resultCode;
    private String resultMsg;

    ResponseEnum(int resultCode, String resultMsg) {
        this.resultCode = resultCode;
        this.resultMsg = resultMsg;
    }
}
