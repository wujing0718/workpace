package com.huohougongfu.app.Gson;

public class OKGson {
    /**
     * msg : 操作成功
     * result : 再次收藏成功
     * status : 1
     */

    private String msg;
    private String result;
    private int status;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
