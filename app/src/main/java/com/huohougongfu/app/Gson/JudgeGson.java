package com.huohougongfu.app.Gson;

public class JudgeGson {

    /**
     * msg : 操作成功
     * result : {"userInfo":{"userId":1,"nickName":"昵称","personalProfile":null,"gender":null,"birthday":null,"email":null,"phone":"15927484519","photo":"http://zhmp.oss-cn-shenzhen.aliyuncs.com/default.png","realName":"真实姓名","idcard":null,"teaRiceMe":32,"teaRicePresent":null,"commission":1,"income":0,"sinaToken":null,"qq":null,"qqToken":"1111111","wechat":null,"wechatToken":null,"rongToken":null,"place":"深圳","integral":null,"isMaster":true,"isMerchant":true,"state":false,"delFlag":0,"loginIp":"","loginDate":null,"qrcode":null,"createTime":"2019-05-30 14:26:02","updateTime":"2019-08-16T08:42:36.000+0000","isSift":false,"buyMoney":0,"records":null,"master":{"id":null,"mId":null,"name":null,"portrait":null,"photo":null,"level":"茶艺爱好者","specialty":null,"status":null,"introduceContent":null,"createTime":"2019-05-30T06:26:02.000+0000","updateTime":"2019-08-16T08:42:36.000+0000","masterAddress":null,"storeId":null,"isMerchant":null,"count":0,"isCollection":0,"merchant":null},"isAttention":null,"fanCount":null,"attentionNum":null,"dynamicNum":null},"hasPayPass":0,"isExist":true,"token":"1921a8ee2f584cd9a61a0e5608c281a4"}
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
         * userInfo : {"userId":1,"nickName":"昵称","personalProfile":null,"gender":null,"birthday":null,"email":null,"phone":"15927484519","photo":"http://zhmp.oss-cn-shenzhen.aliyuncs.com/default.png","realName":"真实姓名","idcard":null,"teaRiceMe":32,"teaRicePresent":null,"commission":1,"income":0,"sinaToken":null,"qq":null,"qqToken":"1111111","wechat":null,"wechatToken":null,"rongToken":null,"place":"深圳","integral":null,"isMaster":true,"isMerchant":true,"state":false,"delFlag":0,"loginIp":"","loginDate":null,"qrcode":null,"createTime":"2019-05-30 14:26:02","updateTime":"2019-08-16T08:42:36.000+0000","isSift":false,"buyMoney":0,"records":null,"master":{"id":null,"mId":null,"name":null,"portrait":null,"photo":null,"level":"茶艺爱好者","specialty":null,"status":null,"introduceContent":null,"createTime":"2019-05-30T06:26:02.000+0000","updateTime":"2019-08-16T08:42:36.000+0000","masterAddress":null,"storeId":null,"isMerchant":null,"count":0,"isCollection":0,"merchant":null},"isAttention":null,"fanCount":null,"attentionNum":null,"dynamicNum":null}
         * hasPayPass : 0
         * isExist : true
         * token : 1921a8ee2f584cd9a61a0e5608c281a4
         */

        private UserInfoBean userInfo;
        private int hasPayPass;
        private boolean isExist;
        private String token;

        public UserInfoBean getUserInfo() {
            return userInfo;
        }

        public void setUserInfo(UserInfoBean userInfo) {
            this.userInfo = userInfo;
        }

        public int getHasPayPass() {
            return hasPayPass;
        }

        public void setHasPayPass(int hasPayPass) {
            this.hasPayPass = hasPayPass;
        }

        public boolean isIsExist() {
            return isExist;
        }

        public void setIsExist(boolean isExist) {
            this.isExist = isExist;
        }

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }

        public static class UserInfoBean {
            /**
             * userId : 1
             * nickName : 昵称
             * personalProfile : null
             * gender : null
             * birthday : null
             * email : null
             * phone : 15927484519
             * photo : http://zhmp.oss-cn-shenzhen.aliyuncs.com/default.png
             * realName : 真实姓名
             * idcard : null
             * teaRiceMe : 32.0
             * teaRicePresent : null
             * commission : 1.0
             * income : 0.0
             * sinaToken : null
             * qq : null
             * qqToken : 1111111
             * wechat : null
             * wechatToken : null
             * rongToken : null
             * place : 深圳
             * integral : null
             * isMaster : true
             * isMerchant : true
             * state : false
             * delFlag : 0
             * loginIp :
             * loginDate : null
             * qrcode : null
             * createTime : 2019-05-30 14:26:02
             * updateTime : 2019-08-16T08:42:36.000+0000
             * isSift : false
             * buyMoney : 0.0
             * records : null
             * master : {"id":null,"mId":null,"name":null,"portrait":null,"photo":null,"level":"茶艺爱好者","specialty":null,"status":null,"introduceContent":null,"createTime":"2019-05-30T06:26:02.000+0000","updateTime":"2019-08-16T08:42:36.000+0000","masterAddress":null,"storeId":null,"isMerchant":null,"count":0,"isCollection":0,"merchant":null}
             * isAttention : null
             * fanCount : null
             * attentionNum : null
             * dynamicNum : null
             */

            private int userId;
            private String nickName;
            private Object personalProfile;
            private Object gender;
            private Object birthday;
            private Object email;
            private String phone;
            private String photo;
            private String realName;
            private Object idcard;
            private double teaRiceMe;
            private Object teaRicePresent;
            private double commission;
            private double income;
            private Object sinaToken;
            private Object qq;
            private String qqToken;
            private Object wechat;
            private Object wechatToken;
            private String rongToken;
            private String place;
            private Object integral;
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
            private Object isAttention;
            private Object fanCount;
            private Object attentionNum;
            private Object dynamicNum;

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

            public Object getPersonalProfile() {
                return personalProfile;
            }

            public void setPersonalProfile(Object personalProfile) {
                this.personalProfile = personalProfile;
            }

            public Object getGender() {
                return gender;
            }

            public void setGender(Object gender) {
                this.gender = gender;
            }

            public Object getBirthday() {
                return birthday;
            }

            public void setBirthday(Object birthday) {
                this.birthday = birthday;
            }

            public Object getEmail() {
                return email;
            }

            public void setEmail(Object email) {
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

            public Object getIdcard() {
                return idcard;
            }

            public void setIdcard(Object idcard) {
                this.idcard = idcard;
            }

            public double getTeaRiceMe() {
                return teaRiceMe;
            }

            public void setTeaRiceMe(double teaRiceMe) {
                this.teaRiceMe = teaRiceMe;
            }

            public Object getTeaRicePresent() {
                return teaRicePresent;
            }

            public void setTeaRicePresent(Object teaRicePresent) {
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

            public Object getSinaToken() {
                return sinaToken;
            }

            public void setSinaToken(Object sinaToken) {
                this.sinaToken = sinaToken;
            }

            public Object getQq() {
                return qq;
            }

            public void setQq(Object qq) {
                this.qq = qq;
            }

            public String getQqToken() {
                return qqToken;
            }

            public void setQqToken(String qqToken) {
                this.qqToken = qqToken;
            }

            public Object getWechat() {
                return wechat;
            }

            public void setWechat(Object wechat) {
                this.wechat = wechat;
            }

            public Object getWechatToken() {
                return wechatToken;
            }

            public void setWechatToken(Object wechatToken) {
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

            public Object getIntegral() {
                return integral;
            }

            public void setIntegral(Object integral) {
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

            public Object getIsAttention() {
                return isAttention;
            }

            public void setIsAttention(Object isAttention) {
                this.isAttention = isAttention;
            }

            public Object getFanCount() {
                return fanCount;
            }

            public void setFanCount(Object fanCount) {
                this.fanCount = fanCount;
            }

            public Object getAttentionNum() {
                return attentionNum;
            }

            public void setAttentionNum(Object attentionNum) {
                this.attentionNum = attentionNum;
            }

            public Object getDynamicNum() {
                return dynamicNum;
            }

            public void setDynamicNum(Object dynamicNum) {
                this.dynamicNum = dynamicNum;
            }

            public static class MasterBean {
                /**
                 * id : null
                 * mId : null
                 * name : null
                 * portrait : null
                 * photo : null
                 * level : 茶艺爱好者
                 * specialty : null
                 * status : null
                 * introduceContent : null
                 * createTime : 2019-05-30T06:26:02.000+0000
                 * updateTime : 2019-08-16T08:42:36.000+0000
                 * masterAddress : null
                 * storeId : null
                 * isMerchant : null
                 * count : 0
                 * isCollection : 0
                 * merchant : null
                 */

                private Object id;
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
                private int count;
                private int isCollection;
                private Object merchant;

                public Object getId() {
                    return id;
                }

                public void setId(Object id) {
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
}
