package com.example01.utils;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;
@Data
public class R {

    private Integer code;

    private String message;

    private Object data;

    public R(){}

    public R(Integer code,String message){
        this.code=code;
        this.message=message;
    }

    public R(Integer code,Object data){
        this.code=code;
        this.data=data;
    }

    public R(Integer code,String message,Object data){
        this.code=code;
        this.message=message;
        this.data=data;
    }

    public R renderSuccess(String message){
        return new R(20000,message);
    }

    public R renderError(String message){
        return new R(20001,message);
    }
    /*
    private Boolean success;
    private  Integer code;
    private String message;
    private Map<String, Object> date=new HashMap<String, Object>();

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Map<String, Object> getDate() {
        return date;
    }

    public void setDate(Map<String, Object> date) {
        this.date = date;
    }
    //构造方法
    private R(){}

    //成功静态方法
    public static R ok(){
        R r=new R();
        r.setSuccess(true);
        r.setCode(20000);
        r.setMessage("成功");
        return r;
    }

    //失败静态方法
    public static R error(){
        R r=new R();
        r.setSuccess(false);
        r.setCode(20001);
        r.setMessage("失败");
        return r;
    }

    public R success(Boolean success){
        this.setSuccess(success);
        return this;
    }

    public R message(String message){
        this.setMessage(message);
        return this;
    }
    public R code(Integer code){
        this.setCode(code);
        return this;
    }
    public R date(String key, String value){
        this.date.put(key,value);
        return this;
    }
    public R date(Map<String, Object> date){
        this.setDate(date);
        return this;
    }*/
}
