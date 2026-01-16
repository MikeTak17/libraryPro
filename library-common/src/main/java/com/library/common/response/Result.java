package com.library.common.response;


import com.library.common.constant.Constants;

import java.io.Serializable;

public class Result<T> implements Serializable {
    private static final long serialVersionUID = 1L;

    public static final int success = Constants.SUCCESS;

    public static final int fail = Constants.FAIL;

    private int code;

    private String msg;

    private T data;

    public static <T> Result<T> success(){
        return result(null, success, "操作成功");
    }

    public static <T> Result<T> success(T data){
        return result(data, success, "操作成功");
    }

    public static <T> Result<T> success(String msg, T data){
        return result(data, success, "msg");
    }

    public static <T> Result<T> success(String msg){
        return result(null, success, msg);
    }

    public static <T> Result<T> error(){
        return result(null, fail, "操作失敗");
    }

    public static <T> Result<T> error(String msg){
        return result(null, fail, msg);
    }

    public static <T> Result<T> error(int code, String msg){
        Result<T> result = new Result<>();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }

    public static <T> Result<T> error(T data){
        return result(data, fail, "操作失敗");
    }

    private static <T> Result<T> result(T data, int code, String msg){
        Result<T> result = new Result<>();
        result.setCode(code);
        result.setData(data);
        result.setMsg(msg);
        return result;
    }

    public int getCode(){
        return code;
    }

    public void setCode(int code){
        this.code = code;
    }

    public String getMsg(){
        return msg;
    }

    public void setMsg(String msg){
        this.msg = msg;
    }

    public T getData(){
        return data;
    }

    public void setData(T data){
        this.data = data;
    }
}