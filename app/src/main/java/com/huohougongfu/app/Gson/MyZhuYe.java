package com.huohougongfu.app.Gson;

public class MyZhuYe {


    /**
     * msg : 操作成功
     * result : {"userId":43,"nickName":"测试账号","personalProfile":"个人简介","gender":1,"birthday":"1998-01-09T16:00:00.000+0000","email":"827321175@qq.com","phone":"13111111111","photo":"http://oss.irving.net.cn/tea/1562584072524.png","realName":"汪","idcard":"421333333333333333","teaRiceMe":36947,"teaRicePresent":0,"commission":1,"income":0,"qq":null,"wechat":null,"place":"深圳市","integral":"0","isMaster":false,"isMerchant":false,"state":false,"delFlag":0,"loginIp":"192.168.31.194","loginDate":null,"qrcode":null,"createTime":"2019-06-18 19:33:28","updateTime":"2019-07-09T07:49:51.000+0000","isSift":true,"buyMoney":0,"records":null,"master":{"id":3,"mId":null,"name":null,"portrait":null,"photo":null,"level":"评茶师","specialty":null,"status":null,"introduceContent":null,"createTime":"2019-08-23T08:17:21.000+0000","updateTime":"2019-08-23T10:18:05.000+0000","masterAddress":null,"storeId":null,"isMerchant":null,"nickName":null,"count":0,"isCollection":0,"merchant":null},"isAttention":1,"vip":true,"memberLevel":"0","zhuanKe":false,"fanCount":2,"attentionNum":6,"dynamicNum":32}
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
         * userId : 43
         * nickName : 测试账号
         * personalProfile : 个人简介
         * gender : 1
         * birthday : 1998-01-09T16:00:00.000+0000
         * email : 827321175@qq.com
         * phone : 13111111111
         * photo : http://oss.irving.net.cn/tea/1562584072524.png
         * realName : 汪
         * idcard : 421333333333333333
         * teaRiceMe : 36947.0
         * teaRicePresent : 0
         * commission : 1.0
         * income : 0.0
         * qq : null
         * wechat : null
         * place : 深圳市
         * integral : 0
         * isMaster : false
         * isMerchant : false
         * state : false
         * delFlag : 0
         * loginIp : 192.168.31.194
         * loginDate : null
         * qrcode : null
         * createTime : 2019-06-18 19:33:28
         * updateTime : 2019-07-09T07:49:51.000+0000
         * isSift : true
         * buyMoney : 0.0
         * records : null
         * master : {"id":3,"mId":null,"name":null,"portrait":null,"photo":null,"level":"评茶师","specialty":null,"status":null,"introduceContent":null,"createTime":"2019-08-23T08:17:21.000+0000","updateTime":"2019-08-23T10:18:05.000+0000","masterAddress":null,"storeId":null,"isMerchant":null,"nickName":null,"count":0,"isCollection":0,"merchant":null}
         * isAttention : 1
         * vip : true
         * memberLevel : 0
         * zhuanKe : false
         * fanCount : 2
         * attentionNum : 6
         * dynamicNum : 32
         */

        private int userId;
        private String nickName;
        private String personalProfile;
        private int gender;
        private String birthday;
        private String email;
        private String phone;
        private String photo;
        private String realName;
        private String idcard;
        private double teaRiceMe;
        private int teaRicePresent;
        private double commission;
        private double income;
        private Object qq;
        private Object wechat;
        private String place;
        private String integral;
        private boolean isMaster;
        private boolean isMerchant;
        private boolean state;
        private int delFlag;
        private String loginIp;
        private Object loginDate;
        private Object qrcode;
        private String createTime;
        private String updateTime;
        private boolean isSift;
        private double buyMoney;
        private Object records;
        private MasterBean master;
        private int isAttention;
        private boolean vip;
        private String memberLevel;
        private boolean zhuanKe;
        private int fanCount;
        private int attentionNum;
        private int dynamicNum;

        public int getUserId() {
            return userId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }

        public String getNickName() {
            return nickName;
        }

        public void setNickName(String nickName) {
            this.nickName = nickName;
        }

        public String getPersonalProfile() {
            return personalProfile;
        }

        public void setPersonalProfile(String personalProfile) {
            this.personalProfile = personalProfile;
        }

        public int getGender() {
            return gender;
        }

        public void setGender(int gender) {
            this.gender = gender;
        }

        public String getBirthday() {
            return birthday;
        }

        public void setBirthday(String birthday) {
            this.birthday = birthday;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getPhoto() {
            return photo;
        }

        public void setPhoto(String photo) {
            this.photo = photo;
        }

        public String getRealName() {
            return realName;
        }

        public void setRealName(String realName) {
            this.realName = realName;
        }

        public String getIdcard() {
            return idcard;
        }

        public void setIdcard(String idcard) {
            this.idcard = idcard;
        }

        public double getTeaRiceMe() {
            return teaRiceMe;
        }

        public void setTeaRiceMe(double teaRiceMe) {
            this.teaRiceMe = teaRiceMe;
        }

        public int getTeaRicePresent() {
            return teaRicePresent;
        }

        public void setTeaRicePresent(int teaRicePresent) {
            this.teaRicePresent = teaRicePresent;
        }

        public double getCommission() {
            return commission;
        }

        public void setCommission(double commission) {
            this.commission = commission;
        }

        public double getIncome() {
            return income;
        }

        public void setIncome(double income) {
            this.income = income;
        }

        public Object getQq() {
            return qq;
        }

        public void setQq(Object qq) {
            this.qq = qq;
        }

        public Object getWechat() {
            return wechat;
        }

        public void setWechat(Object wechat) {
            this.wechat = wechat;
        }

        public String getPlace() {
            return place;
        }

        public void setPlace(String place) {
            this.place = place;
        }

        public String getIntegral() {
            return integral;
        }

        public void setIntegral(String integral) {
            this.integral = integral;
        }

        public boolean isIsMaster() {
            return isMaster;
        }

        public void setIsMaster(boolean isMaster) {
            this.isMaster = isMaster;
        }

        public boolean isIsMerchant() {
            return isMerchant;
        }

        public void setIsMerchant(boolean isMerchant) {
            this.isMerchant = isMerchant;
        }

        public boolean isState() {
            return state;
        }

        public void setState(boolean state) {
            this.state = state;
        }

        public int getDelFlag() {
            return delFlag;
        }

        public void setDelFlag(int delFlag) {
            this.delFlag = delFlag;
        }

        public String getLoginIp() {
            return loginIp;
        }

        public void setLoginIp(String loginIp) {
            this.loginIp = loginIp;
        }

        public Object getLoginDate() {
            return loginDate;
        }

        public void setLoginDate(Object loginDate) {
            this.loginDate = loginDate;
        }

        public Object getQrcode() {
            return qrcode;
        }

        public void setQrcode(Object qrcode) {
            this.qrcode = qrcode;
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

        public boolean isIsSift() {
            return isSift;
        }

        public void setIsSift(boolean isSift) {
            this.isSift = isSift;
        }

        public double getBuyMoney() {
            return buyMoney;
        }

        public void setBuyMoney(double buyMoney) {
            this.buyMoney = buyMoney;
        }

        public Object getRecords() {
            return records;
        }

        public void setRecords(Object records) {
            this.records = records;
        }

        public MasterBean getMaster() {
            return master;
        }

        public void setMaster(MasterBean master) {
            this.master = master;
        }

        public int getIsAttention() {
            return isAttention;
        }

        public void setIsAttention(int isAttention) {
            this.isAttention = isAttention;
        }

        public boolean isVip() {
            return vip;
        }

        public void setVip(boolean vip) {
            this.vip = vip;
        }

        public String getMemberLevel() {
            return memberLevel;
        }

        public void setMemberLevel(String memberLevel) {
            this.memberLevel = memberLevel;
        }

        public boolean isZhuanKe() {
            return zhuanKe;
        }

        public void setZhuanKe(boolean zhuanKe) {
            this.zhuanKe = zhuanKe;
        }

        public int getFanCount() {
            return fanCount;
        }

        public void setFanCount(int fanCount) {
            this.fanCount = fanCount;
        }

        public int getAttentionNum() {
            return attentionNum;
        }

        public void setAttentionNum(int attentionNum) {
            this.attentionNum = attentionNum;
        }

        public int getDynamicNum() {
            return dynamicNum;
        }

        public void setDynamicNum(int dynamicNum) {
            this.dynamicNum = dynamicNum;
        }

        public static class MasterBean {
            /**
             * id : 3
             * mId : null
             * name : null
             * portrait : null
             * photo : null
             * level : 评茶师
             * specialty : null
             * status : null
             * introduceContent : null
             * createTime : 2019-08-23T08:17:21.000+0000
             * updateTime : 2019-08-23T10:18:05.000+0000
             * masterAddress : null
             * storeId : null
             * isMerchant : null
             * nickName : null
             * count : 0
             * isCollection : 0
             * merchant : null
             */

            private int id;
            private Object mId;
            private Object name;
            private Object portrait;
            private Object photo;
            private String level;
            private Object specialty;
            private Object status;
            private Object introduceContent;
            private String createTime;
            private String updateTime;
            private Object masterAddress;
            private Object storeId;
            private Object isMerchant;
            private Object nickName;
            private int count;
            private int isCollection;
            private Object merchant;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public Object getMId() {
                return mId;
            }

            public void setMId(Object mId) {
                this.mId = mId;
            }

            public Object getName() {
                return name;
            }

            public void setName(Object name) {
                this.name = name;
            }

            public Object getPortrait() {
                return portrait;
            }

            public void setPortrait(Object portrait) {
                this.portrait = portrait;
            }

            public Object getPhoto() {
                return photo;
            }

            public void setPhoto(Object photo) {
                this.photo = photo;
            }

            public String getLevel() {
                return level;
            }

            public void setLevel(String level) {
                this.level = level;
            }

            public Object getSpecialty() {
                return specialty;
            }

            public void setSpecialty(Object specialty) {
                this.specialty = specialty;
            }

            public Object getStatus() {
                return status;
            }

            public void setStatus(Object status) {
                this.status = status;
            }

            public Object getIntroduceContent() {
                return introduceContent;
            }

            public void setIntroduceContent(Object introduceContent) {
                this.introduceContent = introduceContent;
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

            public Object getMasterAddress() {
                return masterAddress;
            }

            public void setMasterAddress(Object masterAddress) {
                this.masterAddress = masterAddress;
            }

            public Object getStoreId() {
                return storeId;
            }

            public void setStoreId(Object storeId) {
                this.storeId = storeId;
            }

            public Object getIsMerchant() {
                return isMerchant;
            }

            public void setIsMerchant(Object isMerchant) {
                this.isMerchant = isMerchant;
            }

            public Object getNickName() {
                return nickName;
            }

            public void setNickName(Object nickName) {
                this.nickName = nickName;
            }

            public int getCount() {
                return count;
            }

            public void setCount(int count) {
                this.count = count;
            }

            public int getIsCollection() {
                return isCollection;
            }

            public void setIsCollection(int isCollection) {
                this.isCollection = isCollection;
            }

            public Object getMerchant() {
                return merchant;
            }

            public void setMerchant(Object merchant) {
                this.merchant = merchant;
            }
        }
    }
}
