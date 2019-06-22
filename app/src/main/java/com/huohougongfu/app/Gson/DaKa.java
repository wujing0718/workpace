package com.huohougongfu.app.Gson;

import java.util.List;

public class DaKa {

    /**
     * msg : 操作成功
     * result : {"arr":[0,1,0,1,0,0,0],"isPunch":0}
     * status : 1
     */

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
        /**
         * arr : [0,1,0,1,0,0,0]
         * isPunch : 0
         */

        private int isPunch;
        private List<Integer> arr;

        public int getIsPunch() {
            return isPunch;
        }

        public void setIsPunch(int isPunch) {
            this.isPunch = isPunch;
        }

        public List<Integer> getArr() {
            return arr;
        }

        public void setArr(List<Integer> arr) {
            this.arr = arr;
        }
    }
}
