package com.lisg.common.response;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

/**
 * @program: micro-services
 * @description:
 * @author: Reagan Li
 * @create: 2025-04-10 13:55
 **/

@Data
@AllArgsConstructor
public class ResponseResult<T> implements Serializable {
    private int code = 1000;
    private String msg = "成功";
    private T data;

    private ResponseResult() {
    }

    public static ResponseResult success() {
        return success(null);
    }

    public static ResponseResult success(Object data) {
        ResponseResult responseResult = new ResponseResult<>();
        responseResult.setCode(ResponseEnum.SUCESS.getResultCode());
        responseResult.setMsg(ResponseEnum.SUCESS.getResultMsg());
        responseResult.setData(data);

        return responseResult;
    }

    public static ResponseResult error() {
        return error(null);
    }

    public static ResponseResult error(Object data) {
        ResponseResult responseResult = new ResponseResult<>();
        responseResult.setCode(ResponseEnum.ERROR.getResultCode());
        responseResult.setMsg(ResponseEnum.ERROR.getResultMsg());
        responseResult.setData(data);

        return responseResult;
    }

    //    自定义参数,链式编程
    public ResponseResult data(T data) {
        this.setData(data);
        return this;
    }

    public ResponseResult code(int code) {
        this.setCode(code);
        return this;
    }

    public ResponseResult msg(String msg) {
        this.setMsg(msg);
        return this;
    }

    //    自定义返回数据
    @Override
    public String toString() {
        return "RestResult{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
}
