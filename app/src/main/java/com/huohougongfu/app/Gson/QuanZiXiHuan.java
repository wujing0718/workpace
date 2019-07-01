package com.huohougongfu.app.Gson;

import java.util.List;

public class QuanZiXiHuan {

    /**
     * msg : 操作成功
     * result : {"total":3,"list":[{"id":13,"type":2,"title":"文章标题","content":"动态内容","picture":"http://oss.irving.net.cn/tea/1561018599485.jpg,http://oss.irving.net.cn/tea/1561018595488.jpeg","createTime":"2019-06-20 16:16:35","updateTime":"2019-06-28 14:27:09","longitude":114.261808,"latitude":22.725361,"address":null,"cityCode":null,"member":{"userId":13,"nickName":"测试账号131","personalProfile":null,"phone":null,"photo":"http://zhmp.oss-cn-shenzhen.aliyuncs.com/default.png","realName":null,"idcard":null,"teaRiceMe":null,"teaRicePresent":null,"commission":null,"income":null,"qq":null,"qqToken":null,"wechat":null,"wechatToken":null,"rongToken":null,"place":null,"integral":null,"isMaster":null,"isMerchant":null,"state":null,"delFlag":null,"loginIp":null,"loginDate":null,"qrcode":null,"createTime":null,"updateTime":null,"buyMoney":null,"records":null},"isPraise":null,"praiseNum":null,"mid":43},{"id":15,"type":3,"title":null,"content":"动态内容","picture":"http://oss.irving.net.cn/tea/1561019267337.jpeg","createTime":"2019-06-20 16:27:38","updateTime":"2019-06-28 14:26:41","longitude":114.261847,"latitude":22.725384,"address":null,"cityCode":null,"member":{"userId":15,"nickName":"测试账号131","personalProfile":null,"phone":null,"photo":"http://zhmp.oss-cn-shenzhen.aliyuncs.com/default.png","realName":null,"idcard":null,"teaRiceMe":null,"teaRicePresent":null,"commission":null,"income":null,"qq":null,"qqToken":null,"wechat":null,"wechatToken":null,"rongToken":null,"place":null,"integral":null,"isMaster":null,"isMerchant":null,"state":null,"delFlag":null,"loginIp":null,"loginDate":null,"qrcode":null,"createTime":null,"updateTime":null,"buyMoney":null,"records":null},"isPraise":null,"praiseNum":null,"mid":43},{"id":19,"type":1,"title":"标题","content":"动态文字内容","picture":"http://oss.irving.net.cn/tea/1561706706320.jpg","createTime":"2019-06-28 15:25:00","updateTime":"2019-06-28 15:25:00","longitude":null,"latitude":null,"address":"深圳","cityCode":"0755","member":{"userId":19,"nickName":"测试账号131","personalProfile":null,"phone":null,"photo":"http://zhmp.oss-cn-shenzhen.aliyuncs.com/default.png","realName":null,"idcard":null,"teaRiceMe":null,"teaRicePresent":null,"commission":null,"income":null,"qq":null,"qqToken":null,"wechat":null,"wechatToken":null,"rongToken":null,"place":null,"integral":null,"isMaster":null,"isMerchant":null,"state":null,"delFlag":null,"loginIp":null,"loginDate":null,"qrcode":null,"createTime":null,"updateTime":null,"buyMoney":null,"records":null},"isPraise":null,"praiseNum":null,"mid":43}],"pageNum":1,"pageSize":4,"size":3,"startRow":1,"endRow":3,"pages":1,"prePage":0,"nextPage":0,"isFirstPage":true,"isLastPage":true,"hasPreviousPage":false,"hasNextPage":false,"navigatePages":8,"navigatepageNums":[1],"navigateFirstPage":1,"navigateLastPage":1}
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
         * total : 3
         * list : [{"id":13,"type":2,"title":"文章标题","content":"动态内容","picture":"http://oss.irving.net.cn/tea/1561018599485.jpg,http://oss.irving.net.cn/tea/1561018595488.jpeg","createTime":"2019-06-20 16:16:35","updateTime":"2019-06-28 14:27:09","longitude":114.261808,"latitude":22.725361,"address":null,"cityCode":null,"member":{"userId":13,"nickName":"测试账号131","personalProfile":null,"phone":null,"photo":"http://zhmp.oss-cn-shenzhen.aliyuncs.com/default.png","realName":null,"idcard":null,"teaRiceMe":null,"teaRicePresent":null,"commission":null,"income":null,"qq":null,"qqToken":null,"wechat":null,"wechatToken":null,"rongToken":null,"place":null,"integral":null,"isMaster":null,"isMerchant":null,"state":null,"delFlag":null,"loginIp":null,"loginDate":null,"qrcode":null,"createTime":null,"updateTime":null,"buyMoney":null,"records":null},"isPraise":null,"praiseNum":null,"mid":43},{"id":15,"type":3,"title":null,"content":"动态内容","picture":"http://oss.irving.net.cn/tea/1561019267337.jpeg","createTime":"2019-06-20 16:27:38","updateTime":"2019-06-28 14:26:41","longitude":114.261847,"latitude":22.725384,"address":null,"cityCode":null,"member":{"userId":15,"nickName":"测试账号131","personalProfile":null,"phone":null,"photo":"http://zhmp.oss-cn-shenzhen.aliyuncs.com/default.png","realName":null,"idcard":null,"teaRiceMe":null,"teaRicePresent":null,"commission":null,"income":null,"qq":null,"qqToken":null,"wechat":null,"wechatToken":null,"rongToken":null,"place":null,"integral":null,"isMaster":null,"isMerchant":null,"state":null,"delFlag":null,"loginIp":null,"loginDate":null,"qrcode":null,"createTime":null,"updateTime":null,"buyMoney":null,"records":null},"isPraise":null,"praiseNum":null,"mid":43},{"id":19,"type":1,"title":"标题","content":"动态文字内容","picture":"http://oss.irving.net.cn/tea/1561706706320.jpg","createTime":"2019-06-28 15:25:00","updateTime":"2019-06-28 15:25:00","longitude":null,"latitude":null,"address":"深圳","cityCode":"0755","member":{"userId":19,"nickName":"测试账号131","personalProfile":null,"phone":null,"photo":"http://zhmp.oss-cn-shenzhen.aliyuncs.com/default.png","realName":null,"idcard":null,"teaRiceMe":null,"teaRicePresent":null,"commission":null,"income":null,"qq":null,"qqToken":null,"wechat":null,"wechatToken":null,"rongToken":null,"place":null,"integral":null,"isMaster":null,"isMerchant":null,"state":null,"delFlag":null,"loginIp":null,"loginDate":null,"qrcode":null,"createTime":null,"updateTime":null,"buyMoney":null,"records":null},"isPraise":null,"praiseNum":null,"mid":43}]
         * pageNum : 1
         * pageSize : 4
         * size : 3
         * startRow : 1
         * endRow : 3
         * pages : 1
         * prePage : 0
         * nextPage : 0
         * isFirstPage : true
         * isLastPage : true
         * hasPreviousPage : false
         * hasNextPage : false
         * navigatePages : 8
         * navigatepageNums : [1]
         * navigateFirstPage : 1
         * navigateLastPage : 1
         */

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
             * id : 13
             * type : 2
             * title : 文章标题
             * content : 动态内容
             * picture : http://oss.irving.net.cn/tea/1561018599485.jpg,http://oss.irving.net.cn/tea/1561018595488.jpeg
             * createTime : 2019-06-20 16:16:35
             * updateTime : 2019-06-28 14:27:09
             * longitude : 114.261808
             * latitude : 22.725361
             * address : null
             * cityCode : null
             * member : {"userId":13,"nickName":"测试账号131","personalProfile":null,"phone":null,"photo":"http://zhmp.oss-cn-shenzhen.aliyuncs.com/default.png","realName":null,"idcard":null,"teaRiceMe":null,"teaRicePresent":null,"commission":null,"income":null,"qq":null,"qqToken":null,"wechat":null,"wechatToken":null,"rongToken":null,"place":null,"integral":null,"isMaster":null,"isMerchant":null,"state":null,"delFlag":null,"loginIp":null,"loginDate":null,"qrcode":null,"createTime":null,"updateTime":null,"buyMoney":null,"records":null}
             * isPraise : null
             * praiseNum : null
             * mid : 43
             */

            private int id;
            private int type;
            private String title;
            private String content;
            private String picture;
            private String createTime;
            private String updateTime;
            private double longitude;
            private double latitude;
            private Object address;
            private Object cityCode;
            private MemberBean member;
            private int isPraise;
            private int praiseNum;
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

            public double getLongitude() {
                return longitude;
            }

            public void setLongitude(double longitude) {
                this.longitude = longitude;
            }

            public double getLatitude() {
                return latitude;
            }

            public void setLatitude(double latitude) {
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

            public int getMid() {
                return mid;
            }

            public void setMid(int mid) {
                this.mid = mid;
            }

            public static class MemberBean {
                /**
                 * userId : 13
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
}
