package com.huohougongfu.app.Gson;

public class ChaMi {
    /**
     * msg : 操作成功
     * result : {"monetary":0,"me":5,"sent":0}
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
         * monetary : 0.0
         * me : 5.0
         * sent : 0
         */

        private double monetary;
        private double me;
        private int sent;

        public double getMonetary() {
            return monetary;
        }

        public void setMonetary(double monetary) {
            this.monetary = monetary;
        }

        public double getMe() {
            return me;
        }

        public void setMe(double me) {
            this.me = me;
        }

        public int getSent() {
            return sent;
        }

        public void setSent(int sent) {
            this.sent = sent;
        }
    }
}
