package com.oyiersan.livecomment.entity.model;

import lombok.Data;

@Data
public class ResponseModel <T> {

    /**
     * 错误码
     */
    public int code = -1;

    /**
     * 错误信息
     */
    public String errorMsg = "";

    /**
     * 返回数据
     */
    public T data = null;

    public ResponseModel(){}

    public ResponseModel(int code, String errorMsg, T data) {
        this.code = code;
        this.errorMsg = errorMsg;
        this.data = data;
    }

    public static <T> ResponseModel success(T data){
        ResponseModel rm = new ResponseModel();
        rm.setCode(1);
        rm.setData(data);
        return rm;
    }

    public static ResponseModel error(String errorMsg) {
        ResponseModel rm = new ResponseModel();
        rm.setCode(0);
        rm.setErrorMsg(errorMsg);
        return rm;
    }

    public static ResponseModel error(int code, String errorMsg) {
        ResponseModel rm = new ResponseModel();
        rm.setCode(code);
        rm.setErrorMsg(errorMsg);
        return rm;
    }
}