package com.lisg.common.response;

import lombok.Data;

/**
 * @program: micro-services
 * @description:
 * @author: Reagan Li
 * @create: 2025-04-10 17:26
 **/

@Data
public class BizException extends RuntimeException{

    private int errCode;

    public BizException(String message, int errCode) {
        super(message);
        this.errCode = errCode;
    }

    @Override
    public String toString() {
        return "MyException{" +
                "errCode=" + errCode +
                "message=" + this.getMessage() +
                '}';
    }
}
