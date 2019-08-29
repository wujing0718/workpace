package com.huohougongfu.app.Gson;

import java.util.List;

public class LiBaoGson {

    /**
     * msg : 操作成功
     * result : {"receive":[{"id":13,"couponType":3,"title":"折扣券(新用户礼包)","isMall":"0","beginTime":"2019-07-02 16:10:29","endTime":"2021-12-31 00:00:00","usableProductId":null,"serviceRegulations":"9折优惠","createTime":"2019-08-22 16:12:28","updateTime":"2019-08-23 15:32:59","fullMoney":null,"money":null,"discount":0.9,"couponCount":100,"storeId":null,"couponsLink":{"id":13,"couponCode":null,"tel":"18910328110","couponsId":13,"isUse":false,"isSend":false,"isReceive":true,"sendNick":"赠送人昵称","pillowTalk":"悄悄话"},"introduction":null,"picture":"https://hotkungfu.oss-cn-beijing.aliyuncs.com/picture/10761566531730_.pic_hd.jpg"}],"system":[{"id":11,"couponType":1,"title":"喝茶券(新用户礼包)","isMall":"0","beginTime":"2019-07-02 16:10:29","endTime":"2021-12-31 00:00:00","usableProductId":1,"serviceRegulations":"免费领一杯茶","createTime":"2019-08-22 16:10:26","updateTime":"2019-08-23 14:33:14","fullMoney":null,"money":30,"discount":null,"couponCount":100,"storeId":null,"couponsLink":{"id":11,"couponCode":null,"tel":"18910328110","couponsId":11,"isUse":false,"isSend":false,"isReceive":false,"sendNick":null,"pillowTalk":null},"introduction":null,"picture":"https://hotkungfu.oss-cn-beijing.aliyuncs.com/picture/10761566531730_.pic_hd.jpg"},{"id":12,"couponType":3,"title":"折扣券(新用户礼包)","isMall":"0","beginTime":"2019-07-02 16:10:29","endTime":"2021-12-31 00:00:00","usableProductId":null,"serviceRegulations":"8折优惠","createTime":"2019-08-22 16:11:35","updateTime":"2019-08-23 15:32:55","fullMoney":null,"money":null,"discount":0.8,"couponCount":100,"storeId":null,"couponsLink":{"id":12,"couponCode":null,"tel":"18910328110","couponsId":12,"isUse":false,"isSend":false,"isReceive":false,"sendNick":null,"pillowTalk":null},"introduction":null,"picture":"https://hotkungfu.oss-cn-beijing.aliyuncs.com/picture/10771566531732_.pic_hd.jpg"}],"teariceRecords":[{"count":5,"sendId":1,"receiveId":3,"isReceive":true,"pillowtalk":"","createTime":"2019-08-23 22:08:37","updateTime":"2019-08-24 15:45:53","type":"登录","nickname":null,"photo":null,"sendName":"Drew","isView":false,"tid":336}]}
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
        private List<ReceiveBean> receive;
        private List<SystemBean> system;
        private List<TeariceRecordsBean> teariceRecords;

        public List<ReceiveBean> getReceive() {
            return receive;
        }

        public void setReceive(List<ReceiveBean> receive) {
            this.receive = receive;
        }

        public List<SystemBean> getSystem() {
            return system;
        }

        public void setSystem(List<SystemBean> system) {
            this.system = system;
        }

        public List<TeariceRecordsBean> getTeariceRecords() {
            return teariceRecords;
        }

        public void setTeariceRecords(List<TeariceRecordsBean> teariceRecords) {
            this.teariceRecords = teariceRecords;
        }

        public static class ReceiveBean {
            /**
             * id : 13
             * couponType : 3
             * title : 折扣券(新用户礼包)
             * isMall : 0
             * beginTime : 2019-07-02 16:10:29
             * endTime : 2021-12-31 00:00:00
             * usableProductId : null
             * serviceRegulations : 9折优惠
             * createTime : 2019-08-22 16:12:28
             * updateTime : 2019-08-23 15:32:59
             * fullMoney : null
             * money : null
             * discount : 0.9
             * couponCount : 100
             * storeId : null
             * couponsLink : {"id":13,"couponCode":null,"tel":"18910328110","couponsId":13,"isUse":false,"isSend":false,"isReceive":true,"sendNick":"赠送人昵称","pillowTalk":"悄悄话"}
             * introduction : null
             * picture : https://hotkungfu.oss-cn-beijing.aliyuncs.com/picture/10761566531730_.pic_hd.jpg
             */

            private int id;
            private int couponType;
            private String title;
            private String isMall;
            private String beginTime;
            private String endTime;
            private Object usableProductId;
            private String serviceRegulations;
            private String createTime;
            private String updateTime;
            private Object fullMoney;
            private Object money;
            private double discount;
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

            public Object getMoney() {
                return money;
            }

            public void setMoney(Object money) {
                this.money = money;
            }

            public double getDiscount() {
                return discount;
            }

            public void setDiscount(double discount) {
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
                 * id : 13
                 * couponCode : null
                 * tel : 18910328110
                 * couponsId : 13
                 * isUse : false
                 * isSend : false
                 * isReceive : true
                 * sendNick : 赠送人昵称
                 * pillowTalk : 悄悄话
                 */

                private int id;
                private Object couponCode;
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

        public static class SystemBean {
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

            public String getPicture() {
                return picture;
            }

            public void setPicture(String picture) {
                this.picture = picture;
            }

            public static class CouponsLinkBeanX {
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

        public static class TeariceRecordsBean {
            /**
             * count : 5
             * sendId : 1
             * receiveId : 3
             * isReceive : true
             * pillowtalk :
             * createTime : 2019-08-23 22:08:37
             * updateTime : 2019-08-24 15:45:53
             * type : 登录
             * nickname : null
             * photo : null
             * sendName : Drew
             * isView : false
             * tid : 336
             */

            private int count;
            private int sendId;
            private int receiveId;
            private boolean isReceive;
            private String pillowtalk;
            private String createTime;
            private String updateTime;
            private String type;
            private Object nickname;
            private Object photo;
            private String sendName;
            private boolean isView;
            private int tid;

            public int getCount() {
                return count;
            }

            public void setCount(int count) {
                this.count = count;
            }

            public int getSendId() {
                return sendId;
            }

            public void setSendId(int sendId) {
                this.sendId = sendId;
            }

            public int getReceiveId() {
                return receiveId;
            }

            public void setReceiveId(int receiveId) {
                this.receiveId = receiveId;
            }

            public boolean isIsReceive() {
                return isReceive;
            }

            public void setIsReceive(boolean isReceive) {
                this.isReceive = isReceive;
            }

            public String getPillowtalk() {
                return pillowtalk;
            }

            public void setPillowtalk(String pillowtalk) {
                this.pillowtalk = pillowtalk;
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

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public Object getNickname() {
                return nickname;
            }

            public void setNickname(Object nickname) {
                this.nickname = nickname;
            }

            public Object getPhoto() {
                return photo;
            }

            public void setPhoto(Object photo) {
                this.photo = photo;
            }

            public String getSendName() {
                return sendName;
            }

            public void setSendName(String sendName) {
                this.sendName = sendName;
            }

            public boolean isIsView() {
                return isView;
            }

            public void setIsView(boolean isView) {
                this.isView = isView;
            }

            public int getTid() {
                return tid;
            }

            public void setTid(int tid) {
                this.tid = tid;
            }
        }
    }
}
