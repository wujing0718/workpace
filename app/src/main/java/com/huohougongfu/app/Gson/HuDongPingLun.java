package com.huohougongfu.app.Gson;

import java.util.List;

public class HuDongPingLun {
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

        public static class ListBean {

            private int id;
            private int dataId;
            private String createTime;
            private MemberBean member;
            private CircleDataBean circleData;
            private int mid;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public int getDataId() {
                return dataId;
            }

            public void setDataId(int dataId) {
                this.dataId = dataId;
            }

            public String getCreateTime() {
                return createTime;
            }

            public void setCreateTime(String createTime) {
                this.createTime = createTime;
            }

            public MemberBean getMember() {
                return member;
            }

            public void setMember(MemberBean member) {
                this.member = member;
            }

            public CircleDataBean getCircleData() {
                return circleData;
            }

            public void setCircleData(CircleDataBean circleData) {
                this.circleData = circleData;
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
                private String personalProfile;
                private int gender;
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
                private Object qq;
                private Object qqToken;
                private Object wechat;
                private Object wechatToken;
                private Object rongToken;
                private String place;
                private int integral;
                private boolean isMaster;
                private boolean isMerchant;
                private boolean state;
                private int delFlag;
                private Object loginIp;
                private Object loginDate;
                private Object qrcode;
                private Object createTime;
                private Object updateTime;
                private Object isSift;
                private Object buyMoney;
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

                    private int id;
                    private int mId;
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

            public static class CircleDataBean {
                /**
                 * id : 7
                 * type : 2
                 * title : null
                 * content : 动态内容
                 * picture : http://oss.irving.net.cn/tea/1561014655349.png,http://oss.irving.net.cn/tea/1561014660270.png
                 * pictureWidth : 600
                 * pictureHeight : 675
                 * createTime : 2019-06-20 15:10:55
                 * updateTime : 2019-07-01 18:48:07
                 * longitude : null
                 * latitude : null
                 * address : null
                 * cityCode : null
                 * member : null
                 * isPraise : null
                 * praiseNum : null
                 * commentNum : null
                 * isSift : null
                 * browseCount : 11
                 * mid : 43
                 */

                private int id;
                private int type;
                private Object title;
                private String content;
                private String picture;
                private int pictureWidth;
                private int pictureHeight;
                private String createTime;
                private String updateTime;
                private Object longitude;
                private Object latitude;
                private Object address;
                private Object cityCode;
                private Object member;
                private Object isPraise;
                private Object praiseNum;
                private Object commentNum;
                private Object isSift;
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

                public Object getTitle() {
                    return title;
                }

                public void setTitle(Object title) {
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

                public Object getAddress() {
                    return address;
                }

                public void setAddress(Object address) {
                    this.address = address;
                }

                public Object getCityCode() {
                    return cityCode;
                }

                public void setCityCode(Object cityCode) {
                    this.cityCode = cityCode;
                }

                public Object getMember() {
                    return member;
                }

                public void setMember(Object member) {
                    this.member = member;
                }

                public Object getIsPraise() {
                    return isPraise;
                }

                public void setIsPraise(Object isPraise) {
                    this.isPraise = isPraise;
                }

                public Object getPraiseNum() {
                    return praiseNum;
                }

                public void setPraiseNum(Object praiseNum) {
                    this.praiseNum = praiseNum;
                }

                public Object getCommentNum() {
                    return commentNum;
                }

                public void setCommentNum(Object commentNum) {
                    this.commentNum = commentNum;
                }

                public Object getIsSift() {
                    return isSift;
                }

                public void setIsSift(Object isSift) {
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
            }
        }
    }
}
