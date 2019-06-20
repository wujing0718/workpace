package com.huohougongfu.app.Gson;

import java.util.List;

public class ChaQuan {

    /**
     * msg : 操作成功
     * result : {"me":[{"id":3,"couponType":3,"title":"8折券","isMall":"0","beginTime":"2019-06-20 11:00:00","endTime":"2019-06-20 11:00:00","usableProductId":"","serviceRegulations":"满一千1000可用","createTime":"2019-06-13 11:00:00","updateTime":"2019-06-19 11:28:21","fullMoney":1000,"money":66,"discount":null,"couponCount":11,"storeId":null,"couponsLink":{"id":3,"tel":"13111111111","couponsId":3,"isUse":false,"isSend":false,"sendNick":"haomeng","pillowTalk":"悄悄话"},"introduction":"全部商品享受8折优惠","imgUrl":"http://zhmp.oss-cn-shenzhen.aliyuncs.com/tea/1559024167178.png"},{"id":1,"couponType":1,"title":"7折券","isMall":"0","beginTime":"2019-06-10 12:42:42","endTime":"2019-07-23 12:42:49","usableProductId":"","serviceRegulations":"满500","createTime":"2019-06-17 12:43:30","updateTime":"2019-06-19 13:42:42","fullMoney":500,"money":70,"discount":null,"couponCount":14,"storeId":null,"couponsLink":{"id":1,"tel":"13111111111","couponsId":1,"isUse":false,"isSend":false,"sendNick":null,"pillowTalk":null},"introduction":"免费领取一杯7折","imgUrl":"http://zhmp.oss-cn-shenzhen.aliyuncs.com/tea/1559024167178.png"}],"send":[{"id":2,"couponType":1,"title":"绿茶券","isMall":"0","beginTime":"2019-06-17 12:43:42","endTime":"2019-06-20 12:43:49","usableProductId":"","serviceRegulations":"满300","createTime":"2019-06-17 12:44:09","updateTime":"2019-06-19 11:28:22","fullMoney":300,"money":1,"discount":null,"couponCount":10,"storeId":null,"couponsLink":{"id":2,"tel":"13111111111","couponsId":2,"isUse":false,"isSend":true,"sendNick":"1","pillowTalk":"lol"},"introduction":"免费领取一杯绿茶","imgUrl":"http://zhmp.oss-cn-shenzhen.aliyuncs.com/tea/1559024167178.png"}]}
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
        private List<MeBean> me;
        private List<SendBean> send;

        public List<MeBean> getMe() {
            return me;
        }

        public void setMe(List<MeBean> me) {
            this.me = me;
        }

        public List<SendBean> getSend() {
            return send;
        }

        public void setSend(List<SendBean> send) {
            this.send = send;
        }

        public static class MeBean {
            /**
             * id : 3
             * couponType : 3
             * title : 8折券
             * isMall : 0
             * beginTime : 2019-06-20 11:00:00
             * endTime : 2019-06-20 11:00:00
             * usableProductId :
             * serviceRegulations : 满一千1000可用
             * createTime : 2019-06-13 11:00:00
             * updateTime : 2019-06-19 11:28:21
             * fullMoney : 1000
             * money : 66
             * discount : null
             * couponCount : 11
             * storeId : null
             * couponsLink : {"id":3,"tel":"13111111111","couponsId":3,"isUse":false,"isSend":false,"sendNick":"haomeng","pillowTalk":"悄悄话"}
             * introduction : 全部商品享受8折优惠
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
                 * id : 3
                 * tel : 13111111111
                 * couponsId : 3
                 * isUse : false
                 * isSend : false
                 * sendNick : haomeng
                 * pillowTalk : 悄悄话
                 */

                private int id;
                private String tel;
                private int couponsId;
                private boolean isUse;
                private boolean isSend;
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
             * id : 2
             * couponType : 1
             * title : 绿茶券
             * isMall : 0
             * beginTime : 2019-06-17 12:43:42
             * endTime : 2019-06-20 12:43:49
             * usableProductId :
             * serviceRegulations : 满300
             * createTime : 2019-06-17 12:44:09
             * updateTime : 2019-06-19 11:28:22
             * fullMoney : 300
             * money : 1
             * discount : null
             * couponCount : 10
             * storeId : null
             * couponsLink : {"id":2,"tel":"13111111111","couponsId":2,"isUse":false,"isSend":true,"sendNick":"1","pillowTalk":"lol"}
             * introduction : 免费领取一杯绿茶
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
            private CouponsLinkBeanX couponsLink;
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

            public CouponsLinkBeanX getCouponsLink() {
                return couponsLink;
            }

            public void setCouponsLink(CouponsLinkBeanX couponsLink) {
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

            public static class CouponsLinkBeanX {
                /**
                 * id : 2
                 * tel : 13111111111
                 * couponsId : 2
                 * isUse : false
                 * isSend : true
                 * sendNick : 1
                 * pillowTalk : lol
                 */

                private int id;
                private String tel;
                private int couponsId;
                private boolean isUse;
                private boolean isSend;
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
