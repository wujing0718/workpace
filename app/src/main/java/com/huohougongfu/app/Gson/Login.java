package com.huohougongfu.app.Gson;

public class Login {

    /**
     * msg : 操作成功
     * result : {"userInfo":{"id":21,"nickName":"18910328110","personalProfile":null,"phone":"18910328110","photo":"http://zhmp.oss-cn-shenzhen.aliyuncs.com/default.png","password":"123456","payPassword":"","realName":null,"idcard":null,"teaRiceMe":0,"teaRicePresent":0,"monetary":0,"qq":null,"qqToken":null,"wechat":null,"wechatToken":null,"rongToken":"0AK40ySpdyJuU8FL5OIB1+aULa9ikgcawPKgMF6uCiw7+bNhzO0CcDF+4xYZVVQ5yGCsm/J7Qk2F+NgLR3fP5XJcdMKfLwUp","place":null,"integral":"0","isMaster":false,"isMerchant":false,"state":0,"delFlag":0,"loginIp":"","loginDate":null,"qrcode":null,"createTime":"2019-06-17T07:06:00.000+0000","updateTime":"2019-06-17T07:06:00.000+0000","buyMoney":0},"token":"1e4aaf7e1d524d5fa875e87c91638822"}
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
         * userInfo : {"id":21,"nickName":"18910328110","personalProfile":null,"phone":"18910328110","photo":"http://zhmp.oss-cn-shenzhen.aliyuncs.com/default.png","password":"123456","payPassword":"","realName":null,"idcard":null,"teaRiceMe":0,"teaRicePresent":0,"monetary":0,"qq":null,"qqToken":null,"wechat":null,"wechatToken":null,"rongToken":"0AK40ySpdyJuU8FL5OIB1+aULa9ikgcawPKgMF6uCiw7+bNhzO0CcDF+4xYZVVQ5yGCsm/J7Qk2F+NgLR3fP5XJcdMKfLwUp","place":null,"integral":"0","isMaster":false,"isMerchant":false,"state":0,"delFlag":0,"loginIp":"","loginDate":null,"qrcode":null,"createTime":"2019-06-17T07:06:00.000+0000","updateTime":"2019-06-17T07:06:00.000+0000","buyMoney":0}
         * token : 1e4aaf7e1d524d5fa875e87c91638822
         */

        private UserInfoBean userInfo;
        private String token;

        public UserInfoBean getUserInfo() {
            return userInfo;
        }

        public void setUserInfo(UserInfoBean userInfo) {
            this.userInfo = userInfo;
        }

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }

        public static class UserInfoBean {
            /**
             * id : 21
             * nickName : 18910328110
             * personalProfile : null
             * phone : 18910328110
             * photo : http://zhmp.oss-cn-shenzhen.aliyuncs.com/default.png
             * password : 123456
             * payPassword :
             * realName : null
             * idcard : null
             * teaRiceMe : 0.0
             * teaRicePresent : 0
             * monetary : 0.0
             * qq : null
             * qqToken : null
             * wechat : null
             * wechatToken : null
             * rongToken : 0AK40ySpdyJuU8FL5OIB1+aULa9ikgcawPKgMF6uCiw7+bNhzO0CcDF+4xYZVVQ5yGCsm/J7Qk2F+NgLR3fP5XJcdMKfLwUp
             * place : null
             * integral : 0
             * isMaster : false
             * isMerchant : false
             * state : 0
             * delFlag : 0
             * loginIp :
             * loginDate : null
             * qrcode : null
             * createTime : 2019-06-17T07:06:00.000+0000
             * updateTime : 2019-06-17T07:06:00.000+0000
             * buyMoney : 0.0
             */

            private int id;
            private String nickName;
            private Object personalProfile;
            private String phone;
            private String photo;
            private String password;
            private String payPassword;
            private Object realName;
            private Object idcard;
            private double teaRiceMe;
            private int teaRicePresent;
            private double monetary;
            private Object qq;
            private Object qqToken;
            private Object wechat;
            private Object wechatToken;
            private String rongToken;
            private Object place;
            private String integral;
            private boolean isMaster;
            private boolean isMerchant;
            private int state;
            private int delFlag;
            private String loginIp;
            private Object loginDate;
            private Object qrcode;
            private String createTime;
            private String updateTime;
            private double buyMoney;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
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

            public String getPassword() {
                return password;
            }

            public void setPassword(String password) {
                this.password = password;
            }

            public String getPayPassword() {
                return payPassword;
            }

            public void setPayPassword(String payPassword) {
                this.payPassword = payPassword;
            }

            public Object getRealName() {
                return realName;
            }

            public void setRealName(Object realName) {
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

            public int getTeaRicePresent() {
                return teaRicePresent;
            }

            public void setTeaRicePresent(int teaRicePresent) {
                this.teaRicePresent = teaRicePresent;
            }

            public double getMonetary() {
                return monetary;
            }

            public void setMonetary(double monetary) {
                this.monetary = monetary;
            }

            public Object getQq() {
                return qq;
            }

            public void setQq(Object qq) {
                this.qq = qq;
            }

            public Object getQqToken() {
                return qqToken;
            }

            public void setQqToken(Object qqToken) {
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

            public Object getPlace() {
                return place;
            }

            public void setPlace(Object place) {
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

            public int getState() {
                return state;
            }

            public void setState(int state) {
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

            public double getBuyMoney() {
                return buyMoney;
            }

            public void setBuyMoney(double buyMoney) {
                this.buyMoney = buyMoney;
            }
        }
    }
}
