package com.huohougongfu.app.Gson;

import java.util.List;

public class KaQuanRecord {
    /**
     * msg : 操作成功
     * result : {"invalid":[{"id":4,"couponType":1,"title":"满减券","isMall":"0","beginTime":"2019-05-07 18:47:34","endTime":"2019-06-29 18:47:38","usableProductId":"2","serviceRegulations":"满500","createTime":"2019-06-17 18:47:44","updateTime":"2019-06-20 16:41:23","fullMoney":500,"money":70,"discount":null,"couponCount":111,"storeId":null,"couponsLink":{"id":4,"tel":"13111111111","couponsId":4,"isUse":false,"isSend":false,"isReceive":true,"sendNick":null,"pillowTalk":null},"introduction":null,"imgUrl":null}],"send":[{"id":1,"couponType":1,"title":"7折券","isMall":"0","beginTime":"2019-06-10 00:00:00","endTime":"2019-06-06 12:42:49","usableProductId":"","serviceRegulations":"满500","createTime":"2019-06-17 12:43:30","updateTime":"2019-06-20 17:02:30","fullMoney":500,"money":70,"discount":null,"couponCount":14,"storeId":null,"couponsLink":{"id":1,"tel":"13111111111","couponsId":1,"isUse":false,"isSend":true,"isReceive":false,"sendNick":null,"pillowTalk":null},"introduction":null,"imgUrl":null}]}
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
        private List<InvalidBean> invalid;
        private List<SendBean> send;

        public List<InvalidBean> getInvalid() {
            return invalid;
        }

        public void setInvalid(List<InvalidBean> invalid) {
            this.invalid = invalid;
        }

        public List<SendBean> getSend() {
            return send;
        }

        public void setSend(List<SendBean> send) {
            this.send = send;
        }

        public static class InvalidBean {
            /**
             * id : 4
             * couponType : 1
             * title : 满减券
             * isMall : 0
             * beginTime : 2019-05-07 18:47:34
             * endTime : 2019-06-29 18:47:38
             * usableProductId : 2
             * serviceRegulations : 满500
             * createTime : 2019-06-17 18:47:44
             * updateTime : 2019-06-20 16:41:23
             * fullMoney : 500
             * money : 70
             * discount : null
             * couponCount : 111
             * storeId : null
             * couponsLink : {"id":4,"tel":"13111111111","couponsId":4,"isUse":false,"isSend":false,"isReceive":true,"sendNick":null,"pillowTalk":null}
             * introduction : null
             * imgUrl : null
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
            private Object introduction;
            private String picture;

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

            public Object getIntroduction() {
                return introduction;
            }

            public void setIntroduction(Object introduction) {
                this.introduction = introduction;
            }

            public String getPicturel() {
                return picture;
            }

            public void setPicture(String picture) {
                this.picture = picture;
            }

            public static class CouponsLinkBean {
                /**
                 * id : 4
                 * tel : 13111111111
                 * couponsId : 4
                 * isUse : false
                 * isSend : false
                 * isReceive : true
                 * sendNick : null
                 * pillowTalk : null
                 */

                private int id;
                private String tel;
                private int couponsId;
                private boolean isUse;
                private boolean isSend;
                private boolean isReceive;
                private String sendNick;
                private String pillowTalk;

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

                public boolean isIsReceive() {
                    return isReceive;
                }

                public void setIsReceive(boolean isReceive) {
                    this.isReceive = isReceive;
                }

                public String getSendNick() {
                    return sendNick;
                }

                public void setSendNick(String sendNick) {
                    this.sendNick = sendNick;
                }

                public String getPillowTalk() {
                    return pillowTalk;
                }

                public void setPillowTalk(String pillowTalk) {
                    this.pillowTalk = pillowTalk;
                }
            }
        }

        public static class SendBean {
            /**
             * id : 1
             * couponType : 1
             * title : 7折券
             * isMall : 0
             * beginTime : 2019-06-10 00:00:00
             * endTime : 2019-06-06 12:42:49
             * usableProductId :
             * serviceRegulations : 满500
             * createTime : 2019-06-17 12:43:30
             * updateTime : 2019-06-20 17:02:30
             * fullMoney : 500
             * money : 70
             * discount : null
             * couponCount : 14
             * storeId : null
             * couponsLink : {"id":1,"tel":"13111111111","couponsId":1,"isUse":false,"isSend":true,"isReceive":false,"sendNick":null,"pillowTalk":null}
             * introduction : null
             * imgUrl : null
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
            private CouponsLinkBeanX couponsLink;
            private Object introduction;
            private String picture;

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

            public CouponsLinkBeanX getCouponsLink() {
                return couponsLink;
            }

            public void setCouponsLink(CouponsLinkBeanX couponsLink) {
                this.couponsLink = couponsLink;
            }

            public Object getIntroduction() {
                return introduction;
            }

            public void setIntroduction(Object introduction) {
                this.introduction = introduction;
            }

            public String getPicturel() {
                return picture;
            }

            public void setPicture(String picture) {
                this.picture = picture;
            }

            public static class CouponsLinkBeanX {
                /**
                 * id : 1
                 * tel : 13111111111
                 * couponsId : 1
                 * isUse : false
                 * isSend : true
                 * isReceive : false
                 * sendNick : null
                 * pillowTalk : null
                 */

                private int id;
                private String tel;
                private int couponsId;
                private boolean isUse;
                private boolean isSend;
                private boolean isReceive;
                private String sendNick;
                private String pillowTalk;

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

                public boolean isIsReceive() {
                    return isReceive;
                }

                public void setIsReceive(boolean isReceive) {
                    this.isReceive = isReceive;
                }

                public String getSendNick() {
                    return sendNick;
                }

                public void setSendNick(String sendNick) {
                    this.sendNick = sendNick;
                }

                public String getPillowTalk() {
                    return pillowTalk;
                }

                public void setPillowTalk(String pillowTalk) {
                    this.pillowTalk = pillowTalk;
                }
            }
        }
    }
}
