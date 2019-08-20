package com.huohougongfu.app.Gson;

import java.util.List;

public class ChaTaiDingDanDetail {


    /**
     * msg : 操作成功
     * result : {"id":67,"machineId":"A0002","detailId":"91","details":[{"id":91,"machineId":"A0002","teaId":1,"teaName":"红茶","price":10,"concentration":"淡","hasdust":1,"count":2,"createTime":"2019-07-24 18:20:21","updateTime":"2019-07-24 18:20:21"}],"verificationCode":"ZKJVESCN","teaRiceNum":0,"couponId":2,"orderStatus":"0","orderTotal":20,"countdownTime":"2019-07-24 18:35:22","createTime":"2019-07-24 18:20:22","updateTime":"2019-07-24 18:20:22","teas":null,"teaNum":1,"currentTime":"2019-07-25 13:44:28","coupon":{"id":2,"couponType":2,"title":"免费绿茶券","isMall":"0","beginTime":"2019-01-01 00:00:00","endTime":"2019-12-31 00:00:00","usableProductId":1,"serviceRegulations":"使用规则","createTime":null,"updateTime":"2019-07-23 09:56:57","fullMoney":200,"money":20,"discount":null,"couponCount":null,"storeId":null,"couponsLink":null,"introduction":null,"imgUrl":null},"isOverdue":true,"mid":47}
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
         * id : 67
         * machineId : A0002
         * detailId : 91
         * details : [{"id":91,"machineId":"A0002","teaId":1,"teaName":"红茶","price":10,"concentration":"淡","hasdust":1,"count":2,"createTime":"2019-07-24 18:20:21","updateTime":"2019-07-24 18:20:21"}]
         * verificationCode : ZKJVESCN
         * teaRiceNum : 0
         * couponId : 2
         * orderStatus : 0
         * orderTotal : 20.0
         * countdownTime : 2019-07-24 18:35:22
         * createTime : 2019-07-24 18:20:22
         * updateTime : 2019-07-24 18:20:22
         * teas : null
         * teaNum : 1
         * currentTime : 2019-07-25 13:44:28
         * coupon : {"id":2,"couponType":2,"title":"免费绿茶券","isMall":"0","beginTime":"2019-01-01 00:00:00","endTime":"2019-12-31 00:00:00","usableProductId":1,"serviceRegulations":"使用规则","createTime":null,"updateTime":"2019-07-23 09:56:57","fullMoney":200,"money":20,"discount":null,"couponCount":null,"storeId":null,"couponsLink":null,"introduction":null,"imgUrl":null}
         * isOverdue : true
         * mid : 47
         */

        private int id;
        private String machineId;
        private String detailId;
        private String verificationCode;
        private int teaRiceNum;
        private int couponId;
        private String orderStatus;
        private double orderTotal;
        private String countdownTime;
        private String createTime;
        private String updateTime;
        private Object teas;
        private int teaNum;
        private String currentTime;
        private CouponBean coupon;
        private boolean isOverdue;
        private int mid;
        private List<DetailsBean> details;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getMachineId() {
            return machineId;
        }

        public void setMachineId(String machineId) {
            this.machineId = machineId;
        }

        public String getDetailId() {
            return detailId;
        }

        public void setDetailId(String detailId) {
            this.detailId = detailId;
        }

        public String getVerificationCode() {
            return verificationCode;
        }

        public void setVerificationCode(String verificationCode) {
            this.verificationCode = verificationCode;
        }

        public int getTeaRiceNum() {
            return teaRiceNum;
        }

        public void setTeaRiceNum(int teaRiceNum) {
            this.teaRiceNum = teaRiceNum;
        }

        public int getCouponId() {
            return couponId;
        }

        public void setCouponId(int couponId) {
            this.couponId = couponId;
        }

        public String getOrderStatus() {
            return orderStatus;
        }

        public void setOrderStatus(String orderStatus) {
            this.orderStatus = orderStatus;
        }

        public double getOrderTotal() {
            return orderTotal;
        }

        public void setOrderTotal(double orderTotal) {
            this.orderTotal = orderTotal;
        }

        public String getCountdownTime() {
            return countdownTime;
        }

        public void setCountdownTime(String countdownTime) {
            this.countdownTime = countdownTime;
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

        public Object getTeas() {
            return teas;
        }

        public void setTeas(Object teas) {
            this.teas = teas;
        }

        public int getTeaNum() {
            return teaNum;
        }

        public void setTeaNum(int teaNum) {
            this.teaNum = teaNum;
        }

        public String getCurrentTime() {
            return currentTime;
        }

        public void setCurrentTime(String currentTime) {
            this.currentTime = currentTime;
        }

        public CouponBean getCoupon() {
            return coupon;
        }

        public void setCoupon(CouponBean coupon) {
            this.coupon = coupon;
        }

        public boolean isIsOverdue() {
            return isOverdue;
        }

        public void setIsOverdue(boolean isOverdue) {
            this.isOverdue = isOverdue;
        }

        public int getMid() {
            return mid;
        }

        public void setMid(int mid) {
            this.mid = mid;
        }

        public List<DetailsBean> getDetails() {
            return details;
        }

        public void setDetails(List<DetailsBean> details) {
            this.details = details;
        }

        public static class CouponBean {
            /**
             * id : 2
             * couponType : 2
             * title : 免费绿茶券
             * isMall : 0
             * beginTime : 2019-01-01 00:00:00
             * endTime : 2019-12-31 00:00:00
             * usableProductId : 1
             * serviceRegulations : 使用规则
             * createTime : null
             * updateTime : 2019-07-23 09:56:57
             * fullMoney : 200
             * money : 20
             * discount : null
             * couponCount : null
             * storeId : null
             * couponsLink : null
             * introduction : null
             * imgUrl : null
             */

            private int id;
            private int couponType;
            private String title;
            private String isMall;
            private String beginTime;
            private String endTime;
            private int usableProductId;
            private String serviceRegulations;
            private Object createTime;
            private String updateTime;
            private int fullMoney;
            private int money;
            private Object discount;
            private Object couponCount;
            private Object storeId;
            private Object couponsLink;
            private Object introduction;
            private Object imgUrl;

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

            public int getUsableProductId() {
                return usableProductId;
            }

            public void setUsableProductId(int usableProductId) {
                this.usableProductId = usableProductId;
            }

            public String getServiceRegulations() {
                return serviceRegulations;
            }

            public void setServiceRegulations(String serviceRegulations) {
                this.serviceRegulations = serviceRegulations;
            }

            public Object getCreateTime() {
                return createTime;
            }

            public void setCreateTime(Object createTime) {
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

            public Object getDiscount() {
                return discount;
            }

            public void setDiscount(Object discount) {
                this.discount = discount;
            }

            public Object getCouponCount() {
                return couponCount;
            }

            public void setCouponCount(Object couponCount) {
                this.couponCount = couponCount;
            }

            public Object getStoreId() {
                return storeId;
            }

            public void setStoreId(Object storeId) {
                this.storeId = storeId;
            }

            public Object getCouponsLink() {
                return couponsLink;
            }

            public void setCouponsLink(Object couponsLink) {
                this.couponsLink = couponsLink;
            }

            public Object getIntroduction() {
                return introduction;
            }

            public void setIntroduction(Object introduction) {
                this.introduction = introduction;
            }

            public Object getImgUrl() {
                return imgUrl;
            }

            public void setImgUrl(Object imgUrl) {
                this.imgUrl = imgUrl;
            }
        }

        public static class DetailsBean {
            /**
             * id : 91
             * machineId : A0002
             * teaId : 1
             * teaName : 红茶
             * price : 10.0
             * concentration : 淡
             * hasdust : 1
             * count : 2
             * createTime : 2019-07-24 18:20:21
             * updateTime : 2019-07-24 18:20:21
             */

            private int id;
            private String machineId;
            private int teaId;
            private String teaName;
            private double price;
            private String concentration;
            private int hasdust;
            private int count;
            private String createTime;
            private String updateTime;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getMachineId() {
                return machineId;
            }

            public void setMachineId(String machineId) {
                this.machineId = machineId;
            }

            public int getTeaId() {
                return teaId;
            }

            public void setTeaId(int teaId) {
                this.teaId = teaId;
            }

            public String getTeaName() {
                return teaName;
            }

            public void setTeaName(String teaName) {
                this.teaName = teaName;
            }

            public double getPrice() {
                return price;
            }

            public void setPrice(double price) {
                this.price = price;
            }

            public String getConcentration() {
                return concentration;
            }

            public void setConcentration(String concentration) {
                this.concentration = concentration;
            }

            public int getHasdust() {
                return hasdust;
            }

            public void setHasdust(int hasdust) {
                this.hasdust = hasdust;
            }

            public int getCount() {
                return count;
            }

            public void setCount(int count) {
                this.count = count;
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
        }
    }
}
