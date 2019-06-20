package com.huohougongfu.app.Gson;

import java.util.List;

public class MallGson {

    /**
     * msg : 操作成功
     * result : [{"id":6,"couponType":2,"title":"满减券","isMall":"1","beginTime":"2019-06-18 19:11:58","endTime":"2019-06-28 19:12:01","usableProductId":"2","serviceRegulations":"满200","createTime":"2019-06-17 19:12:09","updateTime":"2019-06-19 14:22:15","fullMoney":200,"money":40,"discount":null,"couponCount":11,"storeId":null,"couponsLink":{"id":6,"tel":"13111111111","couponsId":6,"isUse":false,"isSend":false,"sendNick":null,"pillowTalk":null},"introduction":"满200减40","imgUrl":"http://zhmp.oss-cn-shenzhen.aliyuncs.com/tea/1559024167178.png"}]
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

    public static class ResultBean {
        /**
         * id : 6
         * couponType : 2
         * title : 满减券
         * isMall : 1
         * beginTime : 2019-06-18 19:11:58
         * endTime : 2019-06-28 19:12:01
         * usableProductId : 2
         * serviceRegulations : 满200
         * createTime : 2019-06-17 19:12:09
         * updateTime : 2019-06-19 14:22:15
         * fullMoney : 200
         * money : 40
         * discount : null
         * couponCount : 11
         * storeId : null
         * couponsLink : {"id":6,"tel":"13111111111","couponsId":6,"isUse":false,"isSend":false,"sendNick":null,"pillowTalk":null}
         * introduction : 满200减40
         * imgUrl : http://zhmp.oss-cn-shenzhen.aliyuncs.com/tea/1559024167178.png
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
        private Object discount;
        private int couponCount;
        private Object storeId;
        private CouponsLinkBean couponsLink;
        private String introduction;
        private String imgUrl;

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

        public CouponsLinkBean getCouponsLink() {
            return couponsLink;
        }

        public void setCouponsLink(CouponsLinkBean couponsLink) {
            this.couponsLink = couponsLink;
        }

        public String getIntroduction() {
            return introduction;
        }

        public void setIntroduction(String introduction) {
            this.introduction = introduction;
        }

        public String getImgUrl() {
            return imgUrl;
        }

        public void setImgUrl(String imgUrl) {
            this.imgUrl = imgUrl;
        }

        public static class CouponsLinkBean {
            /**
             * id : 6
             * tel : 13111111111
             * couponsId : 6
             * isUse : false
             * isSend : false
             * sendNick : null
             * pillowTalk : null
             */

            private int id;
            private String tel;
            private int couponsId;
            private boolean isUse;
            private boolean isSend;
            private Object sendNick;
            private Object pillowTalk;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getTel() {
                return tel;
            }

            public void setTel(String tel) {
                this.tel = tel;
            }

            public int getCouponsId() {
                return couponsId;
            }

            public void setCouponsId(int couponsId) {
                this.couponsId = couponsId;
            }

            public boolean isIsUse() {
                return isUse;
            }

            public void setIsUse(boolean isUse) {
                this.isUse = isUse;
            }

            public boolean isIsSend() {
                return isSend;
            }

            public void setIsSend(boolean isSend) {
                this.isSend = isSend;
            }

            public Object getSendNick() {
                return sendNick;
            }

            public void setSendNick(Object sendNick) {
                this.sendNick = sendNick;
            }

            public Object getPillowTalk() {
                return pillowTalk;
            }

            public void setPillowTalk(Object pillowTalk) {
                this.pillowTalk = pillowTalk;
            }
        }
    }
}
