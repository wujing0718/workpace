package com.huohougongfu.app.Gson;

public class ChaMi {

    /**
     * msg : 操作成功
     * result : {"income":0,"me":99809,"commission":1,"sent":0}
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
         * income : 0.0
         * me : 99809.0
         * commission : 1.0
         * sent : 0
         */

        private double income;
        private double me;
        private double commission;
        private int sent;

        public double getIncome() {
            return income;
        }

        public void setIncome(double income) {
            this.income = income;
        }

        public double getMe() {
            return me;
        }

        public void setMe(double me) {
            this.me = me;
        }

        public double getCommission() {
            return commission;
        }

        public void setCommission(double commission) {
            this.commission = commission;
        }

        public int getSent() {
            return sent;
        }

        public void setSent(int sent) {
            this.sent = sent;
        }
    }
}
