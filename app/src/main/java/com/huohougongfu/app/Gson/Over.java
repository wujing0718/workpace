package com.huohougongfu.app.Gson;

public class Over {
    /**
     * msg : 操作成功
     * result : {"balance":1}
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
         * balance : 1.0
         */

        private double balance;
        private boolean hasPayPassword;

        public boolean isHasPayPassword() {
            return hasPayPassword;
        }

        public void setHasPayPassword(boolean hasPayPassword) {
            this.hasPayPassword = hasPayPassword;
        }

        public double getBalance() {
            return balance;
        }

        public void setBalance(double balance) {
            this.balance = balance;
        }
    }
}
