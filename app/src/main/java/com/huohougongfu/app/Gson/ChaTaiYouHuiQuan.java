package com.huohougongfu.app.Gson;

import java.util.List;

public class ChaTaiYouHuiQuan {
    /**
     * msg : 操作成功
     * result : {"teaRice":36947,"proportion":0.01,"coupons":[{"id":2,"preferentialCode":null,"couponType":2,"title":"免费绿茶券","isMall":"0","beginTime":"2019-01-01 00:00:00","endTime":"2019-12-31 00:00:00","usableProductId":null,"serviceRegulations":"使用规则","createTime":null,"updateTime":"2019-07-17 17:14:18","fullMoney":200,"money":20,"discount":null,"couponCount":null,"storeId":null,"couponsLink":{"id":2,"tel":"13111111111","couponsId":2,"isUse":false,"isSend":false,"isReceive":false,"sendNick":"1","pillowTalk":"lol"},"introduction":null,"imgUrl":null},{"id":3,"preferentialCode":null,"couponType":3,"title":"8折券","isMall":"0","beginTime":"2019-06-20 11:00:00","endTime":"2019-06-29 11:00:00","usableProductId":1,"serviceRegulations":"满一千1000可用","createTime":"2019-06-13 11:00:00","updateTime":"2019-06-26 15:11:08","fullMoney":1000,"money":66,"discount":null,"couponCount":10,"storeId":null,"couponsLink":{"id":3,"tel":"13111111111","couponsId":3,"isUse":false,"isSend":false,"isReceive":true,"sendNick":"haomeng","pillowTalk":"悄悄话"},"introduction":null,"imgUrl":null}]}
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
         * teaRice : 36947
         * proportion : 0.01
         * coupons : [{"id":2,"preferentialCode":null,"couponType":2,"title":"免费绿茶券","isMall":"0","beginTime":"2019-01-01 00:00:00","endTime":"2019-12-31 00:00:00","usableProductId":null,"serviceRegulations":"使用规则","createTime":null,"updateTime":"2019-07-17 17:14:18","fullMoney":200,"money":20,"discount":null,"couponCount":null,"storeId":null,"couponsLink":{"id":2,"tel":"13111111111","couponsId":2,"isUse":false,"isSend":false,"isReceive":false,"sendNick":"1","pillowTalk":"lol"},"introduction":null,"imgUrl":null},{"id":3,"preferentialCode":null,"couponType":3,"title":"8折券","isMall":"0","beginTime":"2019-06-20 11:00:00","endTime":"2019-06-29 11:00:00","usableProductId":1,"serviceRegulations":"满一千1000可用","createTime":"2019-06-13 11:00:00","updateTime":"2019-06-26 15:11:08","fullMoney":1000,"money":66,"discount":null,"couponCount":10,"storeId":null,"couponsLink":{"id":3,"tel":"13111111111","couponsId":3,"isUse":false,"isSend":false,"isReceive":true,"sendNick":"haomeng","pillowTalk":"悄悄话"},"introduction":null,"imgUrl":null}]
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
             * id : 2
             * preferentialCode : null
             * couponType : 2
             * title : 免费绿茶券
             * isMall : 0
             * beginTime : 2019-01-01 00:00:00
             * endTime : 2019-12-31 00:00:00
             * usableProductId : null
             * serviceRegulations : 使用规则
             * createTime : null
             * updateTime : 2019-07-17 17:14:18
             * fullMoney : 200
             * money : 20
             * discount : null
             * couponCount : null
             * storeId : null
             * couponsLink : {"id":2,"tel":"13111111111","couponsId":2,"isUse":false,"isSend":false,"isReceive":false,"sendNick":"1","pillowTalk":"lol"}
             * introduction : null
             * imgUrl : null
             */

            private int id;
            private Object preferentialCode;
            private int couponType;
            private String title;
            private String isMall;
            private String beginTime;
            private String endTime;
            private Object usableProductId;
            private String serviceRegulations;
            private Object createTime;
            private String updateTime;
            private int fullMoney;
            private int money;
            private Object discount;
            private Object couponCount;
            private Object storeId;
            private CouponsLinkBean couponsLink;
            private Object introduction;
            private Object imgUrl;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public Object getPreferentialCode() {
                return preferentialCode;
            }

            public void setPreferentialCode(Object preferentialCode) {
                this.preferentialCode = preferentialCode;
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

            public Object getUsableProductId() {
                return usableProductId;
            }

            public void setUsableProductId(Object usableProductId) {
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

            public Object getImgUrl() {
                return imgUrl;
            }

            public void setImgUrl(Object imgUrl) {
                this.imgUrl = imgUrl;
            }

            public static class CouponsLinkBean {
                /**
                 * id : 2
                 * tel : 13111111111
                 * couponsId : 2
                 * isUse : false
                 * isSend : false
                 * isReceive : false
                 * sendNick : 1
                 * pillowTalk : lol
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
