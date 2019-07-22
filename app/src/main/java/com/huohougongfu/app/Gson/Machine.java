package com.huohougongfu.app.Gson;

import java.io.Serializable;
import java.util.List;

public class Machine implements Serializable{

    private String msg;
    private int status;
    private List<String> result;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public List<String> getResult() {
        return result;
    }

    public void setResult(List<String> result) {
        this.result = result;
    }
}
