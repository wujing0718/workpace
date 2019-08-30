package com.huohougongfu.app.Gson;

import java.util.List;

public class ChaTaiYouHuiQuan {

    /**
     * msg : 操作成功
     * result : {"teaRice":411,"proportion":0.01,"coupons":[{"id":11,"couponType":1,"title":"喝茶券(新用户礼包)","isMall":"0","beginTime":"2019-07-02 16:10:29","endTime":"2021-12-31 00:00:00","usableProductId":1,"serviceRegulations":"免费领一杯茶(凤凰单枞)","createTime":"2019-08-22 16:10:26","updateTime":"2019-08-23 14:33:14","fullMoney":null,"money":30,"discount":null,"couponCount":100,"storeId":null,"couponsLink":{"id":11,"couponCode":null,"tel":"18910328110","couponsId":11,"isUse":false,"isSend":false,"isReceive":false,"sendNick":null,"pillowTalk":null},"introduction":null,"picture":"https://hotkungfu.oss-cn-beijing.aliyuncs.com/picture/10761566531730_.pic_hd.jpg"},{"id":12,"couponType":3,"title":"折扣券(新用户礼包)","isMall":"0","beginTime":"2019-07-02 16:10:29","endTime":"2021-12-31 00:00:00","usableProductId":null,"serviceRegulations":"8折优惠","createTime":"2019-08-22 16:11:35","updateTime":"2019-08-23 15:32:55","fullMoney":null,"money":null,"discount":0.8,"couponCount":100,"storeId":null,"couponsLink":{"id":12,"couponCode":null,"tel":"18910328110","couponsId":12,"isUse":false,"isSend":false,"isReceive":false,"sendNick":null,"pillowTalk":null},"introduction":null,"picture":"https://hotkungfu.oss-cn-beijing.aliyuncs.com/picture/10771566531732_.pic_hd.jpg"},{"id":13,"couponType":3,"title":"折扣券(新用户礼包)","isMall":"0","beginTime":"2019-07-02 16:10:29","endTime":"2021-12-31 00:00:00","usableProductId":null,"serviceRegulations":"9折优惠","createTime":"2019-08-22 16:12:28","updateTime":"2019-08-23 15:32:59","fullMoney":null,"money":null,"discount":0.9,"couponCount":100,"storeId":null,"couponsLink":{"id":13,"couponCode":null,"tel":"18910328110","couponsId":13,"isUse":false,"isSend":false,"isReceive":false,"sendNick":null,"pillowTalk":null},"introduction":null,"picture":"https://hotkungfu.oss-cn-beijing.aliyuncs.com/picture/10761566531730_.pic_hd.jpg"}]}
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
         * teaRice : 411
         * proportion : 0.01
         * coupons : [{"id":11,"couponType":1,"title":"喝茶券(新用户礼包)","isMall":"0","beginTime":"2019-07-02 16:10:29","endTime":"2021-12-31 00:00:00","usableProductId":1,"serviceRegulations":"免费领一杯茶(凤凰单枞)","createTime":"2019-08-22 16:10:26","updateTime":"2019-08-23 14:33:14","fullMoney":null,"money":30,"discount":null,"couponCount":100,"storeId":null,"couponsLink":{"id":11,"couponCode":null,"tel":"18910328110","couponsId":11,"isUse":false,"isSend":false,"isReceive":false,"sendNick":null,"pillowTalk":null},"introduction":null,"picture":"https://hotkungfu.oss-cn-beijing.aliyuncs.com/picture/10761566531730_.pic_hd.jpg"},{"id":12,"couponType":3,"title":"折扣券(新用户礼包)","isMall":"0","beginTime":"2019-07-02 16:10:29","endTime":"2021-12-31 00:00:00","usableProductId":null,"serviceRegulations":"8折优惠","createTime":"2019-08-22 16:11:35","updateTime":"2019-08-23 15:32:55","fullMoney":null,"money":null,"discount":0.8,"couponCount":100,"storeId":null,"couponsLink":{"id":12,"couponCode":null,"tel":"18910328110","couponsId":12,"isUse":false,"isSend":false,"isReceive":false,"sendNick":null,"pillowTalk":null},"introduction":null,"picture":"https://hotkungfu.oss-cn-beijing.aliyuncs.com/picture/10771566531732_.pic_hd.jpg"},{"id":13,"couponType":3,"title":"折扣券(新用户礼包)","isMall":"0","beginTime":"2019-07-02 16:10:29","endTime":"2021-12-31 00:00:00","usableProductId":null,"serviceRegulations":"9折优惠","createTime":"2019-08-22 16:12:28","updateTime":"2019-08-23 15:32:59","fullMoney":null,"money":null,"discount":0.9,"couponCount":100,"storeId":null,"couponsLink":{"id":13,"couponCode":null,"tel":"18910328110","couponsId":13,"isUse":false,"isSend":false,"isReceive":false,"sendNick":null,"pillowTalk":null},"introduction":null,"picture":"https://hotkungfu.oss-cn-beijing.aliyuncs.com/picture/10761566531730_.pic_hd.jpg"}]
         */

        private int teaRice;
        private double proportion;
        private List<CouponsBean> coupons;

        public int getTeaRice() {
            return teaRice;
        }

        public void setTeaRice(int teaRice) {
            this.teaRice = teaRice;
        }

        public double getProportion() {
            return proportion;
        }

        public void setProportion(double proportion) {
            this.proportion = proportion;
        }

        public List<CouponsBean> getCoupons() {
            return coupons;
        }

        public void setCoupons(List<CouponsBean> coupons) {
            this.coupons = coupons;
        }

        public static class CouponsBean {
            /**
             * id : 11
             * couponType : 1
             * title : 喝茶券(新用户礼包)
             * isMall : 0
             * beginTime : 2019-07-02 16:10:29
             * endTime : 2021-12-31 00:00:00
             * usableProductId : 1
             * serviceRegulations : 免费领一杯茶(凤凰单枞)
             * createTime : 2019-08-22 16:10:26
             * updateTime : 2019-08-23 14:33:14
             * fullMoney : null
             * money : 30
             * discount : null
             * couponCount : 100
             * storeId : null
             * couponsLink : {"id":11,"couponCode":null,"tel":"18910328110","couponsId":11,"isUse":false,"isSend":false,"isReceive":false,"sendNick":null,"pillowTalk":null}
             * introduction : null
             * picture : https://hotkungfu.oss-cn-beijing.aliyuncs.com/picture/10761566531730_.pic_hd.jpg
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

            public String getPicture() {
                return picture;
            }

            public void setPicture(String picture) {
                this.picture = picture;
            }

            public static class CouponsLinkBean {
                /**
                 * id : 11
                 * couponCode : null
                 * tel : 18910328110
                 * couponsId : 11
                 * isUse : false
                 * isSend : false
                 * isReceive : false
                 * sendNick : null
                 * pillowTalk : null
                 */

                private int id;
                private Object couponCode;
                private String tel;
                private int couponsId;
                private boolean isUse;
                private boolean isSend;
                private boolean isReceive;
                private Object sendNick;
                private Object pillowTalk;

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public Object getCouponCode() {
                    return couponCode;
                }

                public void setCouponCode(Object couponCode) {
                    this.couponCode = couponCode;
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
}
