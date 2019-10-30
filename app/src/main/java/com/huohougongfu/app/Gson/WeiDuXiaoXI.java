package com.huohougongfu.app.Gson;

public class WeiDuXiaoXI {

    /**
     * msg : 操作成功
     * result : {"comments":true,"jg":true,"praise":true}
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
         * comments : true
         * jg : true
         * praise : true
         */

        private boolean comments;
        private boolean jg;
        private boolean praise;

        public boolean isComments() {
            return comments;
        }

        public void setComments(boolean comments) {
            this.comments = comments;
        }

        public boolean isJg() {
            return jg;
        }

        public void setJg(boolean jg) {
            this.jg = jg;
        }

        public boolean isPraise() {
            return praise;
        }

        public void setPraise(boolean praise) {
            this.praise = praise;
        }
    }
}
