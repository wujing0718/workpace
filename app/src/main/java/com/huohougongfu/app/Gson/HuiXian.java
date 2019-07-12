package com.huohougongfu.app.Gson;

public class HuiXian {
    /**
     * msg : 操作成功
     * result : {"userId":46,"nickName":"18940328110","personalProfile":null,"gender":null,"birthday":null,"email":null,"phone":"18940328110","photo":"http://zhmp.oss-cn-shenzhen.aliyuncs.com/default.png","realName":"","idcard":null,"teaRiceMe":0,"teaRicePresent":0,"commission":0,"income":0,"qq":"","wechat":"","place":null,"integral":0,"isMaster":false,"isMerchant":false,"state":false,"delFlag":0,"loginIp":"192.168.31.17","loginDate":null,"qrcode":null,"createTime":"2019-07-11 15:11:16","updateTime":"2019-07-11T07:11:16.000+0000","isSift":null,"buyMoney":0,"records":null,"master":null,"isAttention":null,"fanCount":null,"attentionNum":null,"dynamicNum":null}
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
         * userId : 46
         * nickName : 18940328110
         * personalProfile : null
         * gender : null
         * birthday : null
         * email : null
         * phone : 18940328110
         * photo : http://zhmp.oss-cn-shenzhen.aliyuncs.com/default.png
         * realName :
         * idcard : null
         * teaRiceMe : 0.0
         * teaRicePresent : 0
         * commission : 0.0
         * income : 0.0
         * qq :
         * wechat :
         * place : null
         * integral : 0
         * isMaster : false
         * isMerchant : false
         * state : false
         * delFlag : 0
         * loginIp : 192.168.31.17
         * loginDate : null
         * qrcode : null
         * createTime : 2019-07-11 15:11:16
         * updateTime : 2019-07-11T07:11:16.000+0000
         * isSift : null
         * buyMoney : 0.0
         * records : null
         * master : null
         * isAttention : null
         * fanCount : null
         * attentionNum : null
         * dynamicNum : null
         */

        private int userId;
        private String nickName;
        private String personalProfile;
        private Object gender;
        private Object birthday;
        private Object email;
        private String phone;
        private String photo;
        private String realName;
        private Object idcard;
        private double teaRiceMe;
        private int teaRicePresent;
        private double commission;
        private double income;
        private String qq;
        private String wechat;
        private Object place;
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
        private Object isSift;
        private double buyMoney;
        private Object records;
        private Object master;
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

        public String getPersonalProfile() {
            return personalProfile;
        }

        public void setPersonalProfile(String personalProfile) {
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

        public String getQq() {
            return qq;
        }

        public void setQq(String qq) {
            this.qq = qq;
        }

        public String getWechat() {
            return wechat;
        }

        public void setWechat(String wechat) {
            this.wechat = wechat;
        }

        public Object getPlace() {
            return place;
        }

        public void setPlace(Object place) {
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

        public Object getIsSift() {
            return isSift;
        }

        public void setIsSift(Object isSift) {
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

        public Object getMaster() {
            return master;
        }

        public void setMaster(Object master) {
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
    }
}
