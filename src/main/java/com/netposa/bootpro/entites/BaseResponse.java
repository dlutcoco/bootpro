package com.netposa.bootpro.entites;


import com.alibaba.fastjson.JSONObject;

public class BaseResponse {

    private int code = 200;
    
    private String message;
    
    private JSONObject data;

    public BaseResponse() {
        this(200);
    }

    public BaseResponse(int code) {
        this(code, "");
    }
    
    public BaseResponse(int code, String message) {
        this(code, message, new JSONObject());
    }
    
    public BaseResponse(int code, String message, JSONObject data) {
        super();
        this.code = code;
        this.message = message;
        this.data = data;
    }
    
    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
    
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public JSONObject getData() {
        return data;
    }

    public void setData(JSONObject data) {
        this.data = data;
    }
    
    public BaseResponse put(String key, Object value) {
        data.put(key, value);
        return this;
    }
    
    public BaseResponse code(int code) {
        this.code = code;
        return this;
    }
    
    public BaseResponse message(String message) {
        this.message = message;
        return this;
    }
}
