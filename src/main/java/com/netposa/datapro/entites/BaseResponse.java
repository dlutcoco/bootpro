package com.netposa.datapro.entites;


import com.alibaba.fastjson.JSONObject;

public class BaseResponse {

    private int code = 200;
    
    private JSONObject data = new JSONObject();

    public BaseResponse() {
        super();    
    }

    public BaseResponse(int code, JSONObject data) {
        super();
        this.code = code;
        this.data = data;
    }
    
    public BaseResponse put(String key, Object value) {
        data.put(key, value);
        
        return this;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public JSONObject getData() {
        return data;
    }

    public void setData(JSONObject data) {
        this.data = data;
    }
}