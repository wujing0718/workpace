package com.huohougongfu.app.Gson;

import java.io.Serializable;
import java.util.List;

public class ShopYouHuiQuan implements Serializable{
    /**
     * msg : 操作成功
     * result : [{"id":5,"couponType":2,"title":"满减券","isMall":"1","beginTime":"2019-06-12 19:11:09","endTime":"2019-06-29 19:11:13","usableProductId":"2","serviceRegulations":"满200","createTime":"2019-06-17 19:11:21","updateTime":"2019-06-20 16:41:26","fullMoney":200,"money":43,"couponCount":15},{"id":6,"couponType":2,"title":"满减券","isMall":"1","beginTime":"2019-06-18 19:11:58","endTime":"2019-06-29 19:12:01","usableProductId":"2","serviceRegulations":"满200","createTime":"2019-06-17 19:12:09","updateTime":"2019-06-20 16:41:32","fullMoney":200,"money":40,"couponCount":11}]
     * status : 1
     */

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

    public static class ResultBean implements Serializable{
        /**
         * id : 5
         * couponType : 2
         * title : 满减券
         * isMall : 1
         * beginTime : 2019-06-12 19:11:09
         * endTime : 2019-06-29 19:11:13
         * usableProductId : 2
         * serviceRegulations : 满200
         * createTime : 2019-06-17 19:11:21
         * updateTime : 2019-06-20 16:41:26
         * fullMoney : 200
         * money : 43
         * couponCount : 15
         */

        private int id;
        private int couponType;
        private String title;
        private String isMall;
        private String beginTime;
        private String endTime;
        private String usableProductId;
        private String serviceRegulations;
        private String createTime;
        private String updateTime;
        private int fullMoney;
        private int money;
        private int couponCount;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getCouponType() {
            return couponType;
        }

        public void setCouponType(int couponType) {
            this.couponType = couponType;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getIsMall() {
            return isMall;
        }

        public void setIsMall(String isMall) {
            this.isMall = isMall;
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

        public String getUsableProductId() {
            return usableProductId;
        }

        public void setUsableProductId(String usableProductId) {
            this.usableProductId = usableProductId;
        }

        public String getServiceRegulations() {
            return serviceRegulations;
        }

        public void setServiceRegulations(String serviceRegulations) {
            this.serviceRegulations = serviceRegulations;
        }

        public String getCreateTime() {
            return createTime;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
        }

        public String getUpdateTime() {
            return updateTime;
        }

        public void setUpdateTime(String updateTime) {
            this.updateTime = updateTime;
        }

        public int getFullMoney() {
            return fullMoney;
        }

        public void setFullMoney(int fullMoney) {
            this.fullMoney = fullMoney;
        }

        public int getMoney() {
            return money;
        }

        public void setMoney(int money) {
            this.money = money;
        }

        public int getCouponCount() {
            return couponCount;
        }

        public void setCouponCount(int couponCount) {
            this.couponCount = couponCount;
        }
    }
}
