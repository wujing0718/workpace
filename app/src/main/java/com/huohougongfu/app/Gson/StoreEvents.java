package com.huohougongfu.app.Gson;

import java.util.List;

public class StoreEvents {


    private String msg;
    private int status;
    private List<ResultBean> result;

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

    public List<ResultBean> getResult() {
        return result;
    }

    public void setResult(List<ResultBean> result) {
        this.result = result;
    }

    public static class ResultBean {
        /**
         * id : 7
         * activeName : 溜了溜了
         * mid : 88
         * reduceNumber : 50.0
         * fullAmount : 100.0
         * beginTime : 2019-09-11T16:00:00.000+0000
         * endTime : 2019-09-15T16:00:00.000+0000
         */

        private int id;
        private String activeName;
        private int mid;
        private double reduceNumber;
        private double fullAmount;
        private String beginTime;
        private String endTime;

        public boolean isSelect;

        public boolean isSelect() {
            return isSelect;
        }

        public void setSelect(boolean isSelect) {
            this.isSelect = isSelect;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getActiveName() {
            return activeName;
        }

        public void setActiveName(String activeName) {
            this.activeName = activeName;
        }

        public int getMid() {
            return mid;
        }

        public void setMid(int mid) {
            this.mid = mid;
        }

        public double getReduceNumber() {
            return reduceNumber;
        }

        public void setReduceNumber(double reduceNumber) {
            this.reduceNumber = reduceNumber;
        }

        public double getFullAmount() {
            return fullAmount;
        }

        public void setFullAmount(double fullAmount) {
            this.fullAmount = fullAmount;
        }

        public String getBeginTime() {
            return beginTime;
        }

        public void setBeginTime(String beginTime) {
            this.beginTime = beginTime;
        }

        public String getEndTime() {
            return endTime;
        }

        public void setEndTime(String endTime) {
            this.endTime = endTime;
        }
    }
}
