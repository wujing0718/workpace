package com.huohougongfu.app.Gson;

import java.util.List;

public class ChaTaiDingDanDetail {


    /**
     * msg : 操作成功
     * result : {"id":201,"type":1,"orderNo":"M201908291351109264357","machineId":"AA-BB-CC201908051519594523747","detailId":"369","details":[{"id":369,"machineId":"AA-BB-CC201908051519594523747","teaId":1,"teaName":"凤凰单枞","price":0.02,"concentration":"浓","hasdust":1,"count":1,"createTime":"2019-08-29 13:51:10","updateTime":"2019-08-29 13:51:10"}],"machineProduct":{"id":null,"name":null,"productPrice":null,"weight":null,"commodityDescription":null,"masterGraph":null,"detailsFigureOne":null,"detailsFigureTwo":null,"detailsFigureThree":null,"createTime":null,"updateTime":null},"verificationCode":"1PLPA24X","payMethod":null,"tradeNo":"2019082922001483780588409586","teaRiceNum":2,"couponId":11,"orderStatus":"1","orderTotal":0.01,"countdownTime":"2019-08-29 14:06:10","createTime":"2019-08-29 13:51:10","updateTime":"2019-08-30 09:53:22","teas":null,"teaNum":1,"currentTime":"2019-08-31 13:40:51","coupon":{"id":11,"couponType":1,"title":"喝茶券(新用户礼包)","isMall":"0","beginTime":"2019-07-02 16:10:29","endTime":"2021-12-31 00:00:00","usableProductId":1,"serviceRegulations":"免费领一杯茶","createTime":"2019-08-22 16:10:26","updateTime":"2019-08-23 14:33:14","fullMoney":null,"money":30,"discount":null,"couponCount":100,"storeId":null,"couponsLink":null,"introduction":null,"picture":null},"refillNum":0,"takeTeaTime":null,"isOverdue":true,"mid":2}
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
         * id : 201
         * type : 1
         * orderNo : M201908291351109264357
         * machineId : AA-BB-CC201908051519594523747
         * detailId : 369
         * details : [{"id":369,"machineId":"AA-BB-CC201908051519594523747","teaId":1,"teaName":"凤凰单枞","price":0.02,"concentration":"浓","hasdust":1,"count":1,"createTime":"2019-08-29 13:51:10","updateTime":"2019-08-29 13:51:10"}]
         * machineProduct : {"id":null,"name":null,"productPrice":null,"weight":null,"commodityDescription":null,"masterGraph":null,"detailsFigureOne":null,"detailsFigureTwo":null,"detailsFigureThree":null,"createTime":null,"updateTime":null}
         * verificationCode : 1PLPA24X
         * payMethod : null
         * tradeNo : 2019082922001483780588409586
         * teaRiceNum : 2
         * couponId : 11
         * orderStatus : 1
         * orderTotal : 0.01
         * countdownTime : 2019-08-29 14:06:10
         * createTime : 2019-08-29 13:51:10
         * updateTime : 2019-08-30 09:53:22
         * teas : null
         * teaNum : 1
         * currentTime : 2019-08-31 13:40:51
         * coupon : {"id":11,"couponType":1,"title":"喝茶券(新用户礼包)","isMall":"0","beginTime":"2019-07-02 16:10:29","endTime":"2021-12-31 00:00:00","usableProductId":1,"serviceRegulations":"免费领一杯茶","createTime":"2019-08-22 16:10:26","updateTime":"2019-08-23 14:33:14","fullMoney":null,"money":30,"discount":null,"couponCount":100,"storeId":null,"couponsLink":null,"introduction":null,"picture":null}
         * refillNum : 0
         * takeTeaTime : null
         * isOverdue : true
         * mid : 2
         */

        private int id;
        private int type;
        private String orderNo;
        private String machineId;
        private String detailId;
        private MachineProductBean machineProduct;
        private String verificationCode;
        private Object payMethod;
        private String tradeNo;
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
        private int refillNum;
        private Object takeTeaTime;
        private boolean isOverdue;
        private int mid;
        private List<DetailsBean> details;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public String getOrderNo() {
            return orderNo;
        }

        public void setOrderNo(String orderNo) {
            this.orderNo = orderNo;
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

        public MachineProductBean getMachineProduct() {
            return machineProduct;
        }

        public void setMachineProduct(MachineProductBean machineProduct) {
            this.machineProduct = machineProduct;
        }

        public String getVerificationCode() {
            return verificationCode;
        }

        public void setVerificationCode(String verificationCode) {
            this.verificationCode = verificationCode;
        }

        public Object getPayMethod() {
            return payMethod;
        }

        public void setPayMethod(Object payMethod) {
            this.payMethod = payMethod;
        }

        public String getTradeNo() {
            return tradeNo;
        }

        public void setTradeNo(String tradeNo) {
            this.tradeNo = tradeNo;
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

        public int getRefillNum() {
            return refillNum;
        }

        public void setRefillNum(int refillNum) {
            this.refillNum = refillNum;
        }

        public Object getTakeTeaTime() {
            return takeTeaTime;
        }

        public void setTakeTeaTime(Object takeTeaTime) {
            this.takeTeaTime = takeTeaTime;
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

        public static class MachineProductBean {
            /**
             * id : null
             * name : null
             * productPrice : null
             * weight : null
             * commodityDescription : null
             * masterGraph : null
             * detailsFigureOne : null
             * detailsFigureTwo : null
             * detailsFigureThree : null
             * createTime : null
             * updateTime : null
             */

            private int id;
            private String name;
            private double productPrice;
            private Object weight;
            private String commodityDescription;
            private Object masterGraph;
            private Object detailsFigureOne;
            private Object detailsFigureTwo;
            private Object detailsFigureThree;
            private Object createTime;
            private Object updateTime;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public double getProductPrice() {
                return productPrice;
            }

            public void setProductPrice(double productPrice) {
                this.productPrice = productPrice;
            }

            public Object getWeight() {
                return weight;
            }

            public void setWeight(Object weight) {
                this.weight = weight;
            }

            public String getCommodityDescription() {
                return commodityDescription;
            }

            public void setCommodityDescription(String commodityDescription) {
                this.commodityDescription = commodityDescription;
            }

            public Object getMasterGraph() {
                return masterGraph;
            }

            public void setMasterGraph(Object masterGraph) {
                this.masterGraph = masterGraph;
            }

            public Object getDetailsFigureOne() {
                return detailsFigureOne;
            }

            public void setDetailsFigureOne(Object detailsFigureOne) {
                this.detailsFigureOne = detailsFigureOne;
            }

            public Object getDetailsFigureTwo() {
                return detailsFigureTwo;
            }

            public void setDetailsFigureTwo(Object detailsFigureTwo) {
                this.detailsFigureTwo = detailsFigureTwo;
            }

            public Object getDetailsFigureThree() {
                return detailsFigureThree;
            }

            public void setDetailsFigureThree(Object detailsFigureThree) {
                this.detailsFigureThree = detailsFigureThree;
            }

            public Object getCreateTime() {
                return createTime;
            }

            public void setCreateTime(Object createTime) {
                this.createTime = createTime;
            }

            public Object getUpdateTime() {
                return updateTime;
            }

            public void setUpdateTime(Object updateTime) {
                this.updateTime = updateTime;
            }
        }

        public static class CouponBean {
            /**
             * id : 11
             * couponType : 1
             * title : 喝茶券(新用户礼包)
             * isMall : 0
             * beginTime : 2019-07-02 16:10:29
             * endTime : 2021-12-31 00:00:00
             * usableProductId : 1
             * serviceRegulations : 免费领一杯茶
             * createTime : 2019-08-22 16:10:26
             * updateTime : 2019-08-23 14:33:14
             * fullMoney : null
             * money : 30
             * discount : null
             * couponCount : 100
             * storeId : null
             * couponsLink : null
             * introduction : null
             * picture : null
             */

            private int id;
            private int couponType;
            private String title;
            private String isMall;
            private String beginTime;
            private String endTime;
            private int usableProductId;
            private String serviceRegulations;
            private String createTime;
            private String updateTime;
            private Object fullMoney;
            private int money;
            private Object discount;
            private int couponCount;
            private Object storeId;
            private Object couponsLink;
            private Object introduction;
            private Object picture;

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

            public Object getFullMoney() {
                return fullMoney;
            }

            public void setFullMoney(Object fullMoney) {
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

            public int getCouponCount() {
                return couponCount;
            }

            public void setCouponCount(int couponCount) {
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

            public Object getPicture() {
                return picture;
            }

            public void setPicture(Object picture) {
                this.picture = picture;
            }
        }

        public static class DetailsBean {
            /**
             * id : 369
             * machineId : AA-BB-CC201908051519594523747
             * teaId : 1
             * teaName : 凤凰单枞
             * price : 0.02
             * concentration : 浓
             * hasdust : 1
             * count : 1
             * createTime : 2019-08-29 13:51:10
             * updateTime : 2019-08-29 13:51:10
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
