package com.huohougongfu.app.Gson;

public class TongJiGson {

    /**
     * msg : 操作成功
     * result : {"week":0.04,"mouth":0.04,"today":0.04}
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
         * week : 0.04
         * mouth : 0.04
         * today : 0.04
         */

        private double week;
        private double mouth;
        private double today;

        public double getWeek() {
            return week;
        }

        public void setWeek(double week) {
            this.week = week;
        }

        public double getMouth() {
            return mouth;
        }

        public void setMouth(double mouth) {
            this.mouth = mouth;
        }

        public double getToday() {
            return today;
        }

        public void setToday(double today) {
            this.today = today;
        }
    }
}
