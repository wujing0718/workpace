package com.huohougongfu.app.Gson;

public class QuanZiDetail  {
    /**
     * msg : 操作成功
     * result : {"id":63,"type":2,"title":"5图库轮我绿裤子","content":"@&$,,@&$,,第2点，就是驾照换证时间，汽车是需要年审的，而之前驾照也是需要年审的，但是现在驾照只需要按时换证就可以了，家找上面都是有有效日期的，大家如果发现驾照快到有效期了，就要及时去车管所办理换证，车主要在驾照有效期内才能上路行驶，另外，有效期前90天就可以办理换证了，如果过了有效期没有换证，但是超期在一年内也是可以办理换证的，但是如果是超期3年，那驾照就等于作废了。,,@&$,,第2点，就是驾照换证时间，汽车是需要年审的，而之前驾照也是需要年审的，但是现在驾照只需要按时换证就可以了，家找上面都是有有效日期的，大家如果发现驾照快到有效期了，就要及时去车管所办理换证，车主要在驾照有效期内才能上路行驶，另外，有效期前90天就可以办理换证了，如果过了有效期没有换证，但是超期在一年内也是可以办理换证的，但是如果是超期3年，那驾照就等于作废了。,,,,@&$,,","picture":"http://oss.irving.net.cn/tea/1562139463207.jpeg,http://oss.irving.net.cn/tea/1562139457514.jpg,http://oss.irving.net.cn/tea/1562139456739.jpg,http://oss.irving.net.cn/tea/1562139463309.jpeg","pictureWidth":1560,"pictureHeight":2080,"createTime":"1562139456000","updateTime":"2019-07-03 16:30:21","longitude":null,"latitude":null,"address":null,"cityCode":"","member":{"userId":63,"nickName":"测试账号131","personalProfile":null,"phone":null,"photo":"http://zhmp.oss-cn-shenzhen.aliyuncs.com/default.png","realName":null,"idcard":null,"teaRiceMe":null,"teaRicePresent":null,"commission":null,"income":null,"qq":null,"qqToken":null,"wechat":null,"wechatToken":null,"rongToken":null,"place":null,"integral":null,"isMaster":null,"isMerchant":null,"state":null,"delFlag":null,"loginIp":null,"loginDate":null,"qrcode":null,"createTime":null,"updateTime":null,"buyMoney":null,"records":null},"isPraise":1,"praiseNum":0,"commentNum":0,"isSift":true,"browseCount":5,"mid":43}
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
         * id : 63
         * type : 2
         * title : 5图库轮我绿裤子
         * content : @&$,,@&$,,第2点，就是驾照换证时间，汽车是需要年审的，而之前驾照也是需要年审的，但是现在驾照只需要按时换证就可以了，家找上面都是有有效日期的，大家如果发现驾照快到有效期了，就要及时去车管所办理换证，车主要在驾照有效期内才能上路行驶，另外，有效期前90天就可以办理换证了，如果过了有效期没有换证，但是超期在一年内也是可以办理换证的，但是如果是超期3年，那驾照就等于作废了。,,@&$,,第2点，就是驾照换证时间，汽车是需要年审的，而之前驾照也是需要年审的，但是现在驾照只需要按时换证就可以了，家找上面都是有有效日期的，大家如果发现驾照快到有效期了，就要及时去车管所办理换证，车主要在驾照有效期内才能上路行驶，另外，有效期前90天就可以办理换证了，如果过了有效期没有换证，但是超期在一年内也是可以办理换证的，但是如果是超期3年，那驾照就等于作废了。,,,,@&$,,
         * picture : http://oss.irving.net.cn/tea/1562139463207.jpeg,http://oss.irving.net.cn/tea/1562139457514.jpg,http://oss.irving.net.cn/tea/1562139456739.jpg,http://oss.irving.net.cn/tea/1562139463309.jpeg
         * pictureWidth : 1560
         * pictureHeight : 2080
         * createTime : 1562139456000
         * updateTime : 2019-07-03 16:30:21
         * longitude : null
         * latitude : null
         * address : null
         * cityCode :
         * member : {"userId":63,"nickName":"测试账号131","personalProfile":null,"phone":null,"photo":"http://zhmp.oss-cn-shenzhen.aliyuncs.com/default.png","realName":null,"idcard":null,"teaRiceMe":null,"teaRicePresent":null,"commission":null,"income":null,"qq":null,"qqToken":null,"wechat":null,"wechatToken":null,"rongToken":null,"place":null,"integral":null,"isMaster":null,"isMerchant":null,"state":null,"delFlag":null,"loginIp":null,"loginDate":null,"qrcode":null,"createTime":null,"updateTime":null,"buyMoney":null,"records":null}
         * isPraise : 1
         * praiseNum : 0
         * commentNum : 0
         * isSift : true
         * browseCount : 5
         * mid : 43
         */

        private int id;
        private int type;
        private String title;
        private String content;
        private String picture;
        private int pictureWidth;
        private int pictureHeight;
        private String createTime;
        private String updateTime;
        private Object longitude;
        private Object latitude;
        private String address;
        private String cityCode;
        private MemberBean member;
        private int isPraise;
        private int praiseNum;
        private int commentNum;
        private boolean isSift;
        private int browseCount;
        private int mid;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getPicture() {
            return picture;
        }

        public void setPicture(String picture) {
            this.picture = picture;
        }

        public int getPictureWidth() {
            return pictureWidth;
        }

        public void setPictureWidth(int pictureWidth) {
            this.pictureWidth = pictureWidth;
        }

        public int getPictureHeight() {
            return pictureHeight;
        }

        public void setPictureHeight(int pictureHeight) {
            this.pictureHeight = pictureHeight;
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

        public Object getLongitude() {
            return longitude;
        }

        public void setLongitude(Object longitude) {
            this.longitude = longitude;
        }

        public Object getLatitude() {
            return latitude;
        }

        public void setLatitude(Object latitude) {
            this.latitude = latitude;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getCityCode() {
            return cityCode;
        }

        public void setCityCode(String cityCode) {
            this.cityCode = cityCode;
        }

        public MemberBean getMember() {
            return member;
        }

        public void setMember(MemberBean member) {
            this.member = member;
        }

        public int getIsPraise() {
            return isPraise;
        }

        public void setIsPraise(int isPraise) {
            this.isPraise = isPraise;
        }

        public int getPraiseNum() {
            return praiseNum;
        }

        public void setPraiseNum(int praiseNum) {
            this.praiseNum = praiseNum;
        }

        public int getCommentNum() {
            return commentNum;
        }

        public void setCommentNum(int commentNum) {
            this.commentNum = commentNum;
        }

        public boolean isIsSift() {
            return isSift;
        }

        public void setIsSift(boolean isSift) {
            this.isSift = isSift;
        }

        public int getBrowseCount() {
            return browseCount;
        }

        public void setBrowseCount(int browseCount) {
            this.browseCount = browseCount;
        }

        public int getMid() {
            return mid;
        }

        public void setMid(int mid) {
            this.mid = mid;
        }

        public static class MemberBean {
            /**
             * userId : 63
             * nickName : 测试账号131
             * personalProfile : null
             * phone : null
             * photo : http://zhmp.oss-cn-shenzhen.aliyuncs.com/default.png
             * realName : null
             * idcard : null
             * teaRiceMe : null
             * teaRicePresent : null
             * commission : null
             * income : null
             * qq : null
             * qqToken : null
             * wechat : null
             * wechatToken : null
             * rongToken : null
             * place : null
             * integral : null
             * isMaster : null
             * isMerchant : null
             * state : null
             * delFlag : null
             * loginIp : null
             * loginDate : null
             * qrcode : null
             * createTime : null
             * updateTime : null
             * buyMoney : null
             * records : null
             */

            private int userId;
            private String nickName;
            private Object personalProfile;
            private Object phone;
            private String photo;
            private Object realName;
            private Object idcard;
            private Object teaRiceMe;
            private Object teaRicePresent;
            private Object commission;
            private Object income;
            private Object qq;
            private Object qqToken;
            private Object wechat;
            private Object wechatToken;
            private Object rongToken;
            private Object place;
            private Object integral;
            private Object isMaster;
            private Object isMerchant;
            private Object state;
            private Object delFlag;
            private Object loginIp;
            private Object loginDate;
            private Object qrcode;
            private Object createTime;
            private Object updateTime;
            private Object buyMoney;
            private Object records;

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

            public Object getPhone() {
                return phone;
            }

            public void setPhone(Object phone) {
                this.phone = phone;
            }

            public String getPhoto() {
                return photo;
            }

            public void setPhoto(String photo) {
                this.photo = photo;
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

            public Object getTeaRiceMe() {
                return teaRiceMe;
            }

            public void setTeaRiceMe(Object teaRiceMe) {
                this.teaRiceMe = teaRiceMe;
            }

            public Object getTeaRicePresent() {
                return teaRicePresent;
            }

            public void setTeaRicePresent(Object teaRicePresent) {
                this.teaRicePresent = teaRicePresent;
            }

            public Object getCommission() {
                return commission;
            }

            public void setCommission(Object commission) {
                this.commission = commission;
            }

            public Object getIncome() {
                return income;
            }

            public void setIncome(Object income) {
                this.income = income;
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

            public Object getRongToken() {
                return rongToken;
            }

            public void setRongToken(Object rongToken) {
                this.rongToken = rongToken;
            }

            public Object getPlace() {
                return place;
            }

            public void setPlace(Object place) {
                this.place = place;
            }

            public Object getIntegral() {
                return integral;
            }

            public void setIntegral(Object integral) {
                this.integral = integral;
            }

            public Object getIsMaster() {
                return isMaster;
            }

            public void setIsMaster(Object isMaster) {
                this.isMaster = isMaster;
            }

            public Object getIsMerchant() {
                return isMerchant;
            }

            public void setIsMerchant(Object isMerchant) {
                this.isMerchant = isMerchant;
            }

            public Object getState() {
                return state;
            }

            public void setState(Object state) {
                this.state = state;
            }

            public Object getDelFlag() {
                return delFlag;
            }

            public void setDelFlag(Object delFlag) {
                this.delFlag = delFlag;
            }

            public Object getLoginIp() {
                return loginIp;
            }

            public void setLoginIp(Object loginIp) {
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

            public Object getCreateTime() {
                return createTime;
            }

            public void setCreateTime(Object createTime) {
                this.createTime = createTime;
            }

            public Object getUpdateTime() {
                return updateTime;
            }

            public void setUpdateTime(Object updateTime) {
                this.updateTime = updateTime;
            }

            public Object getBuyMoney() {
                return buyMoney;
            }

            public void setBuyMoney(Object buyMoney) {
                this.buyMoney = buyMoney;
            }

            public Object getRecords() {
                return records;
            }

            public void setRecords(Object records) {
                this.records = records;
            }
        }
    }
}
