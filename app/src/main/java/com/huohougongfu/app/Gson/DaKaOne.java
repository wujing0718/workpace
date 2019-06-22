package com.huohougongfu.app.Gson;

import java.util.List;

public class DaKaOne {
    /**
     * msg : 操作成功
     * result : [0,1,0,1,1,0,0]
     * status : 1
     */

    private String msg;
    private int status;
    private List<Integer> result;

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

    public List<Integer> getResult() {
        return result;
    }

    public void setResult(List<Integer> result) {
        this.result = result;
    }
}
