package com.huohougongfu.app.Gson;

import com.chad.library.adapter.base.entity.MultiItemEntity;

import java.util.List;

public class XiTongGson {

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

        public static class ListBean implements MultiItemEntity {
            /**
             * id : 31
             * title : 点赞
             * content : 老范点赞了你的动态
             * picture : null
             * fromId : 6
             * toId : 1
             * type : 2
             * createTime : 2019-08-25 21:23:08
             * updateTime : 2019-08-25 21:23:08
             * member : {"userId":6,"nickName":"老范","personalProfile":null,"gender":null,"birthday":null,"email":null,"phone":"13798249230","photo":"https://thirdwx.qlogo.cn/mmopen/vi_32/YOuw0zia8s4rpICoWq4fJJc2X9bX5ibic9A1Hu4bfsic3CEb71qPSjiaXhnO0ynia7icicOibcEAQh7HOQ1jB4UeKg9Vm7g/132","realName":null,"idcard":null,"teaRiceMe":null,"teaRicePresent":null,"commission":null,"income":null,"sinaToken":null,"qq":null,"qqToken":null,"wechat":null,"wechatToken":null,"rongToken":null,"place":"","integral":null,"isMaster":false,"isMerchant":true,"state":null,"delFlag":null,"loginIp":null,"loginDate":null,"qrcode":null,"createTime":null,"updateTime":null,"isSift":null,"buyMoney":null,"records":null,"master":{"id":31,"mId":null,"name":null,"portrait":null,"photo":null,"level":"茶艺爱好者","specialty":null,"status":null,"introduceContent":null,"createTime":"2019-08-25T13:23:08.000+0000","updateTime":"2019-08-25T13:23:08.000+0000","masterAddress":null,"storeId":null,"isMerchant":null,"nickName":null,"count":0,"isCollection":0,"merchant":null},"isAttention":1,"fanCount":null,"attentionNum":null,"dynamicNum":null,"isFirstLogin":null,"masterId":null}
             */

            private int id;
            private String title;
            private String content;
            private Object picture;
            private int fromId;
            private int toId;
            private int type;
            private String createTime;
            private String updateTime;
            private MemberBean member;
            private int itemType;

            public void setItemType(int itemType) {
                this.itemType = itemType;
            }

            @Override
            public int getItemType() {
                return itemType;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
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

            public Object getPicture() {
                return picture;
            }

            public void setPicture(Object picture) {
                this.picture = picture;
            }

            public int getFromId() {
                return fromId;
            }

            public void setFromId(int fromId) {
                this.fromId = fromId;
            }

            public int getToId() {
                return toId;
            }

            public void setToId(int toId) {
                this.toId = toId;
            }

            public int getType() {
                return type;
            }

            public void setType(int type) {
                this.type = type;
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

            public MemberBean getMember() {
                return member;
            }

            public void setMember(MemberBean member) {
                this.member = member;
            }

            public static class MemberBean {
                /**
                 * userId : 6
                 * nickName : 老范
                 * personalProfile : null
                 * gender : null
                 * birthday : null
                 * email : null
                 * phone : 13798249230
                 * photo : https://thirdwx.qlogo.cn/mmopen/vi_32/YOuw0zia8s4rpICoWq4fJJc2X9bX5ibic9A1Hu4bfsic3CEb71qPSjiaXhnO0ynia7icicOibcEAQh7HOQ1jB4UeKg9Vm7g/132
                 * realName : null
                 * idcard : null
                 * teaRiceMe : null
                 * teaRicePresent : null
                 * commission : null
                 * income : null
                 * sinaToken : null
                 * qq : null
                 * qqToken : null
                 * wechat : null
                 * wechatToken : null
                 * rongToken : null
                 * place :
                 * integral : null
                 * isMaster : false
                 * isMerchant : true
                 * state : null
                 * delFlag : null
                 * loginIp : null
                 * loginDate : null
                 * qrcode : null
                 * createTime : null
                 * updateTime : null
                 * isSift : null
                 * buyMoney : null
                 * records : null
                 * master : {"id":31,"mId":null,"name":null,"portrait":null,"photo":null,"level":"茶艺爱好者","specialty":null,"status":null,"introduceContent":null,"createTime":"2019-08-25T13:23:08.000+0000","updateTime":"2019-08-25T13:23:08.000+0000","masterAddress":null,"storeId":null,"isMerchant":null,"nickName":null,"count":0,"isCollection":0,"merchant":null}
                 * isAttention : 1
                 * fanCount : null
                 * attentionNum : null
                 * dynamicNum : null
                 * isFirstLogin : null
                 * masterId : null
                 */

                private int userId;
                private String nickName;
                private Object personalProfile;
                private Object gender;
                private Object birthday;
                private Object email;
                private String phone;
                private String photo;
                private Object realName;
                private Object idcard;
                private Object teaRiceMe;
                private Object teaRicePresent;
                private Object commission;
                private Object income;
                private Object sinaToken;
                private Object qq;
                private Object qqToken;
                private Object wechat;
                private Object wechatToken;
                private Object rongToken;
                private String place;
                private Object integral;
                private boolean isMaster;
                private boolean isMerchant;
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
                private Object fanCount;
                private Object attentionNum;
                private Object dynamicNum;
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

                public static class MasterBean {
                    /**
                     * id : 31
                     * mId : null
                     * name : null
                     * portrait : null
                     * photo : null
                     * level : 茶艺爱好者
                     * specialty : null
                     * status : null
                     * introduceContent : null
                     * createTime : 2019-08-25T13:23:08.000+0000
                     * updateTime : 2019-08-25T13:23:08.000+0000
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
                    private String name;
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

                    public String getName() {
                        return name;
                    }

                    public void setName(String name) {
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
    }
}
