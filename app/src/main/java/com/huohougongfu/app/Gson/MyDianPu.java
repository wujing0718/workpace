package com.huohougongfu.app.Gson;

public class MyDianPu {


    /**
     * msg : 操作成功
     * result : {"total":30,"today":30}
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
         * total : 30
         * today : 30
         */

        private int total;
        private int today;

        public int getTotal() {
            return total;
        }

        public void setTotal(int total) {
            this.total = total;
        }

        public int getToday() {
            return today;
        }

        public void setToday(int today) {
            this.today = today;
        }
    }
}
