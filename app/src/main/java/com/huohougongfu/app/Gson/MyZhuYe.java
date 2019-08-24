package com.huohougongfu.app.Gson;

public class MyZhuYe {


    /**
     * msg : 操作成功
     * result : {"userId":1,"nickName":"Drew","personalProfile":"个性签名","gender":1,"birthday":"1994-06-25T16:00:00.000+0000","email":"827321175@qq.com","phone":"15927484518","photo":"https://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTIjv8IiccVtfzLcLTDRcMWwZSuQpjhUfxTZQhK0icQZib5z4zHvbbuISVojeQgW5LWib8mWOROXlAzJeQ/132","realName":"汪应龙","idcard":"421022199406267513","teaRiceMe":20,"teaRicePresent":300,"commission":0,"income":0,"sinaToken":"","qq":"","qqToken":"","wechat":"","wechatToken":"oIJYd6HjzKdr3Fl15mRKBR2FroCw","rongToken":"57hSCP7pJk8JnzFSy/vvSSMqFDZQNArzrUE8jwbvLiq0IOviTxrx92Cg8X08td94CwgtD/C2NWsHZSM9JAsk2akVzzBkB0jE","place":"北京市","integral":320,"isMaster":true,"isMerchant":false,"state":false,"delFlag":0,"loginIp":"192.168.0.88","loginDate":null,"qrcode":null,"createTime":"2019-08-23 16:17:21","updateTime":"2019-08-23T12:13:44.000+0000","isSift":true,"buyMoney":0,"records":null,"master":{"id":3,"mId":null,"name":null,"portrait":null,"photo":null,"level":"评茶师","specialty":null,"status":null,"introduceContent":null,"createTime":"2019-08-23T08:17:21.000+0000","updateTime":"2019-08-23T12:13:44.000+0000","masterAddress":null,"storeId":null,"isMerchant":null,"nickName":null,"count":0,"isCollection":0,"merchant":null},"isAttention":1,"fanCount":2,"attentionNum":1,"dynamicNum":1,"isFirstLogin":null,"masterId":null}
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
         * userId : 1
         * nickName : Drew
         * personalProfile : 个性签名
         * gender : 1
         * birthday : 1994-06-25T16:00:00.000+0000
         * email : 827321175@qq.com
         * phone : 15927484518
         * photo : https://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTIjv8IiccVtfzLcLTDRcMWwZSuQpjhUfxTZQhK0icQZib5z4zHvbbuISVojeQgW5LWib8mWOROXlAzJeQ/132
         * realName : 汪应龙
         * idcard : 421022199406267513
         * teaRiceMe : 20.0
         * teaRicePresent : 300
         * commission : 0.0
         * income : 0.0
         * sinaToken :
         * qq :
         * qqToken :
         * wechat :
         * wechatToken : oIJYd6HjzKdr3Fl15mRKBR2FroCw
         * rongToken : 57hSCP7pJk8JnzFSy/vvSSMqFDZQNArzrUE8jwbvLiq0IOviTxrx92Cg8X08td94CwgtD/C2NWsHZSM9JAsk2akVzzBkB0jE
         * place : 北京市
         * integral : 320
         * isMaster : true
         * isMerchant : false
         * state : false
         * delFlag : 0
         * loginIp : 192.168.0.88
         * loginDate : null
         * qrcode : null
         * createTime : 2019-08-23 16:17:21
         * updateTime : 2019-08-23T12:13:44.000+0000
         * isSift : true
         * buyMoney : 0.0
         * records : null
         * master : {"id":3,"mId":null,"name":null,"portrait":null,"photo":null,"level":"评茶师","specialty":null,"status":null,"introduceContent":null,"createTime":"2019-08-23T08:17:21.000+0000","updateTime":"2019-08-23T12:13:44.000+0000","masterAddress":null,"storeId":null,"isMerchant":null,"nickName":null,"count":0,"isCollection":0,"merchant":null}
         * isAttention : 1
         * fanCount : 2
         * attentionNum : 1
         * dynamicNum : 1
         * isFirstLogin : null
         * masterId : null
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
        private String sinaToken;
        private String qq;
        private String qqToken;
        private String wechat;
        private String wechatToken;
        private String rongToken;
        private String place;
        private int integral;
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
        private int fanCount;
        private int attentionNum;
        private int dynamicNum;
        private Object isFirstLogin;
        private Object masterId;

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

        public String getSinaToken() {
            return sinaToken;
        }

        public void setSinaToken(String sinaToken) {
            this.sinaToken = sinaToken;
        }

        public String getQq() {
            return qq;
        }

        public void setQq(String qq) {
            this.qq = qq;
        }

        public String getQqToken() {
            return qqToken;
        }

        public void setQqToken(String qqToken) {
            this.qqToken = qqToken;
        }

        public String getWechat() {
            return wechat;
        }

        public void setWechat(String wechat) {
            this.wechat = wechat;
        }

        public String getWechatToken() {
            return wechatToken;
        }

        public void setWechatToken(String wechatToken) {
            this.wechatToken = wechatToken;
        }

        public String getRongToken() {
            return rongToken;
        }

        public void setRongToken(String rongToken) {
            this.rongToken = rongToken;
        }

        public String getPlace() {
            return place;
        }

        public void setPlace(String place) {
            this.place = place;
        }

        public int getIntegral() {
            return integral;
        }

        public void setIntegral(int integral) {
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

        public Object getIsFirstLogin() {
            return isFirstLogin;
        }

        public void setIsFirstLogin(Object isFirstLogin) {
            this.isFirstLogin = isFirstLogin;
        }

        public Object getMasterId() {
            return masterId;
        }

        public void setMasterId(Object masterId) {
            this.masterId = masterId;
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
             * updateTime : 2019-08-23T12:13:44.000+0000
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
