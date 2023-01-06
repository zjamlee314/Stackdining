package com.stackdining.www.model.bean;

/**
 * Created by Evan
 * on 2022/5/24
 */
public class PublicResultBean {

    private String data;
    private int status;
    private String msg;

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
