package com.lisg.common.interceptor;

import com.lisg.common.response.BizException;
import com.lisg.common.response.ResponseResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @program: micro-services
 * @description:
 * @author: Reagan Li
 * @create: 2025-04-10 17:40
 **/

@RestControllerAdvice
public class BizExceptionHandler {

    @ExceptionHandler(BizException.class)
    public ResponseResult handleBizException(BizException e) {
        return ResponseResult.error(e.getMessage()).code(e.getErrCode());
    }

    @ExceptionHandler(Exception.class)
    public ResponseResult handleException(Exception e) {
        return ResponseResult.error(e.getMessage());
    }

}
