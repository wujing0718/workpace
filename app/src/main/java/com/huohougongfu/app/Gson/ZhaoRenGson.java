package com.huohougongfu.app.Gson;

import java.util.List;

public class ZhaoRenGson {

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

            private int userId;
            private String nickName;
            private String personalProfile;
            private String phone;
            private String photo;
            private String realName;
            private double teaRiceMe;
            private Object teaRicePresent;
            private double commission;
            private double income;
            private Object qq;
            private Object wechat;
            private String place;
            private Object integral;
            private boolean isMaster;
            private Object isMerchant;
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
            private MasterBean master;
            private int isAttention;
            private int fanCount;

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

            public boolean isIsMaster() {
                return isMaster;
            }

            public void setIsMaster(boolean isMaster) {
                this.isMaster = isMaster;
            }

            public Object getIsMerchant() {
                return isMerchant;
            }

            public void setIsMerchant(Object isMerchant) {
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

            public MasterBean getMaster() {
                return master;
            }

            public void setMaster(MasterBean master) {
                this.master = master;
            }
            public int getFanCount() {
                return fanCount;
            }

            public void setFanCount(int fanCount) {
                this.fanCount = fanCount;
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
                 * createTime : 2019-05-30T06:26:02.000+0000
                 * updateTime : 2019-07-04T03:36:17.000+0000
                 */

                private Object id;
                private Object mId;
                private Object name;
                private Object portrait;
                private String level;
                private Object introduceContent;
                private String createTime;
                private String updateTime;

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
            }
        }
    }
}
