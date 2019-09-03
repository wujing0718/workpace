package com.huohougongfu.app.Gson;

import java.util.List;

public class YaoQingGson {

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

        private EarnPordutBean earnPordut;
        private RuleBean rule;

        public EarnPordutBean getEarnPordut() {
            return earnPordut;
        }

        public void setEarnPordut(EarnPordutBean earnPordut) {
            this.earnPordut = earnPordut;
        }

        public RuleBean getRule() {
            return rule;
        }

        public void setRule(RuleBean rule) {
            this.rule = rule;
        }

        public static class EarnPordutBean {

            private int total;
            private int pageNum;
            private int pageSize;
            private int size;
            private int startRow;
            private int endRow;
            private int pages;
            private int prePage;
            private int nextPage;
            private boolean isFirstPage;
            private boolean isLastPage;
            private boolean hasPreviousPage;
            private boolean hasNextPage;
            private int navigatePages;
            private int navigateFirstPage;
            private int navigateLastPage;
            private List<ListBean> list;
            private List<Integer> navigatepageNums;

            public int getTotal() {
                return total;
            }

            public void setTotal(int total) {
                this.total = total;
            }

            public int getPageNum() {
                return pageNum;
            }

            public void setPageNum(int pageNum) {
                this.pageNum = pageNum;
            }

            public int getPageSize() {
                return pageSize;
            }

            public void setPageSize(int pageSize) {
                this.pageSize = pageSize;
            }

            public int getSize() {
                return size;
            }

            public void setSize(int size) {
                this.size = size;
            }

            public int getStartRow() {
                return startRow;
            }

            public void setStartRow(int startRow) {
                this.startRow = startRow;
            }

            public int getEndRow() {
                return endRow;
            }

            public void setEndRow(int endRow) {
                this.endRow = endRow;
            }

            public int getPages() {
                return pages;
            }

            public void setPages(int pages) {
                this.pages = pages;
            }

            public int getPrePage() {
                return prePage;
            }

            public void setPrePage(int prePage) {
                this.prePage = prePage;
            }

            public int getNextPage() {
                return nextPage;
            }

            public void setNextPage(int nextPage) {
                this.nextPage = nextPage;
            }

            public boolean isIsFirstPage() {
                return isFirstPage;
            }

            public void setIsFirstPage(boolean isFirstPage) {
                this.isFirstPage = isFirstPage;
            }

            public boolean isIsLastPage() {
                return isLastPage;
            }

            public void setIsLastPage(boolean isLastPage) {
                this.isLastPage = isLastPage;
            }

            public boolean isHasPreviousPage() {
                return hasPreviousPage;
            }

            public void setHasPreviousPage(boolean hasPreviousPage) {
                this.hasPreviousPage = hasPreviousPage;
            }

            public boolean isHasNextPage() {
                return hasNextPage;
            }

            public void setHasNextPage(boolean hasNextPage) {
                this.hasNextPage = hasNextPage;
            }

            public int getNavigatePages() {
                return navigatePages;
            }

            public void setNavigatePages(int navigatePages) {
                this.navigatePages = navigatePages;
            }

            public int getNavigateFirstPage() {
                return navigateFirstPage;
            }

            public void setNavigateFirstPage(int navigateFirstPage) {
                this.navigateFirstPage = navigateFirstPage;
            }

            public int getNavigateLastPage() {
                return navigateLastPage;
            }

            public void setNavigateLastPage(int navigateLastPage) {
                this.navigateLastPage = navigateLastPage;
            }

            public List<ListBean> getList() {
                return list;
            }

            public void setList(List<ListBean> list) {
                this.list = list;
            }

            public List<Integer> getNavigatepageNums() {
                return navigatepageNums;
            }

            public void setNavigatepageNums(List<Integer> navigatepageNums) {
                this.navigatepageNums = navigatepageNums;
            }

            public static class ListBean {
                /**
                 * userId : 1
                 * nickName : 老范
                 * personalProfile : null
                 * gender : 1
                 * birthday : 1985-07-02T16:00:00.000+0000
                 * email : 1165400928@qq.com
                 * phone : 13798249230
                 * photo : https://thirdwx.qlogo.cn/mmopen/vi_32/YOuw0zia8s4rpICoWq4fJJc2X9bX5ibic9A1Hu4bfsic3CEb71qPSjiaXhnO0ynia7icicOibcEAQh7HOQ1jB4UeKg9Vm7g/132
                 * realName : 范正勇
                 * idcard : 510321198507036753
                 * teaRiceMe : 98.0
                 * teaRicePresent : 300
                 * commission : 0.0
                 * income : 0.0
                 * sinaToken :
                 * qq :
                 * qqToken :
                 * wechat :
                 * wechatToken : oIJYd6OQLaMz3HT0hWo5EVxuU3w8
                 * rongToken : T41C90RAAS5gZA+oxB8qeUqo98IGW1rovpX2fI7gVpXnBP2MBe8ZEZZtjhPCVgtlJXcwi6bvYsTa35xUzYcbFIPcGsxonjRB
                 * place :
                 * integral : 405
                 * isMaster : true
                 * isMerchant : true
                 * state : false
                 * delFlag : 0
                 * loginIp : 192.168.0.103
                 * loginDate : null
                 * qrcode : null
                 * createTime : 2019-08-26 15:04:31
                 * updateTime : 2019-08-27T09:53:20.000+0000
                 * isSift : null
                 * buyMoney : 0.0
                 * records : null
                 * master : null
                 * isAttention : null
                 * fanCount : null
                 * attentionNum : null
                 * dynamicNum : null
                 * isFirstLogin : null
                 * masterId : null
                 * memberLevel : 无
                 * getReelStatus : 0
                 * recordStatus : 0
                 * zhuanKe : false
                 * vip : false
                 */

                private int userId;
                private String nickName;
                private Object personalProfile;
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
                private Object isSift;
                private double buyMoney;
                private Object records;
                private Object master;
                private Object isAttention;
                private Object fanCount;
                private Object attentionNum;
                private Object dynamicNum;
                private Object isFirstLogin;
                private Object masterId;
                private String memberLevel;
                private int getReelStatus;
                private int recordStatus;
                private boolean zhuanKe;
                private boolean vip;

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

                public String getMemberLevel() {
                    return memberLevel;
                }

                public void setMemberLevel(String memberLevel) {
                    this.memberLevel = memberLevel;
                }

                public int getGetReelStatus() {
                    return getReelStatus;
                }

                public void setGetReelStatus(int getReelStatus) {
                    this.getReelStatus = getReelStatus;
                }

                public int getRecordStatus() {
                    return recordStatus;
                }

                public void setRecordStatus(int recordStatus) {
                    this.recordStatus = recordStatus;
                }

                public boolean isZhuanKe() {
                    return zhuanKe;
                }

                public void setZhuanKe(boolean zhuanKe) {
                    this.zhuanKe = zhuanKe;
                }

                public boolean isVip() {
                    return vip;
                }

                public void setVip(boolean vip) {
                    this.vip = vip;
                }
            }
        }

        public static class RuleBean {
            /**
             * id : 1
             * mId : 2
             * regulation : 规则
             * picture : http://oss.irving.net.cn/tea/1566456882778.jpg
             * slogan : 标语
             * createTime : 2019-08-20T04:28:59.000+0000
             * updateTime : null
             */

            private int id;
            private int mId;
            private String regulation;
            private String picture;
            private String slogan;
            private String createTime;
            private Object updateTime;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public int getMId() {
                return mId;
            }

            public void setMId(int mId) {
                this.mId = mId;
            }

            public String getRegulation() {
                return regulation;
            }

            public void setRegulation(String regulation) {
                this.regulation = regulation;
            }

            public String getPicture() {
                return picture;
            }

            public void setPicture(String picture) {
                this.picture = picture;
            }

            public String getSlogan() {
                return slogan;
            }

            public void setSlogan(String slogan) {
                this.slogan = slogan;
            }

            public String getCreateTime() {
                return createTime;
            }

            public void setCreateTime(String createTime) {
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
