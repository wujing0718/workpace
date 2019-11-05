package com.huohougongfu.app.Gson;

public class QuanZiDetail  {

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

            private int userId;
            private String nickName;
            private Object personalProfile;
            private Object phone;
            private String photo;
            private Object realName;
            private Object teaRiceMe;
            private Object teaRicePresent;
            private Object commission;
            private Object income;
            private Object qq;
            private Object wechat;
            private String place;
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
            private Object isSift;
            private Object buyMoney;
            private Object records;
            private MasterBean master;
            private int isAttention;
            private boolean vip;
            private String memberLevel;

            public String getMemberLevel() {
                return memberLevel;
            }

            public void setMemberLevel(String memberLevel) {
                this.memberLevel = memberLevel;
            }

            public boolean getVip() {
                return vip;
            }

            public void setVip(boolean vip) {
                this.vip = vip;
            }

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

            public Object getIsSift() {
                return isSift;
            }

            public void setIsSift(Object isSift) {
                this.isSift = isSift;
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

            public static class MasterBean {
                /**
                 * id : null
                 * mId : null
                 * name : null
                 * portrait : null
                 * level : 茶艺爱好者
                 * introduceContent : null
                 * createTime : null
                 * updateTime : null
                 */

                private Object id;
                private Object mId;
                private Object name;
                private Object portrait;
                private String level;
                private Object introduceContent;
                private Object createTime;
                private Object updateTime;

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

                public String getLevel() {
                    return level;
                }

                public void setLevel(String level) {
                    this.level = level;
                }

                public Object getIntroduceContent() {
                    return introduceContent;
                }

                public void setIntroduceContent(Object introduceContent) {
                    this.introduceContent = introduceContent;
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
            }
        }
    }
}
