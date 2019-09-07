package com.huohougongfu.app.Gson;

import java.util.List;

public class ChanPinCanShu {



    private String msg;
    private ResultBean result;
    private int status;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public static class ResultBean {
        private List<String> keys;
        private List<Integer> type;

        public List<String> getKeys() {
            return keys;
        }

        public void setKeys(List<String> keys) {
            this.keys = keys;
        }

        public List<Integer> getType() {
            return type;
        }

        public void setType(List<Integer> type) {
            this.type = type;
        }
    }
}
