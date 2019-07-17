package com.huohougongfu.app.Gson;

import java.io.Serializable;
import java.util.List;

public class MyDongTai implements Serializable{
    /**
     * msg : 操作成功
     * result : {"total":1,"list":[{"id":93,"type":1,"title":null,"content":"漂亮的很","picture":"http://oss.irving.net.cn/tea/1562834013033.jpeg,http://oss.irving.net.cn/tea/1562834004422.jpg,http://oss.irving.net.cn/tea/1562834003471.jpeg,http://oss.irving.net.cn/tea/1562834003698.jpg,http://oss.irving.net.cn/tea/1562834008713.jpeg,http://oss.irving.net.cn/tea/1562834006153.jpg","pictureWidth":800,"pictureHeight":800,"createTime":"2019-07-11 16:33:23","updateTime":"2019-07-11 16:33:23","longitude":114.261848,"latitude":22.725369,"address":null,"cityCode":"0755","member":null,"isPraise":null,"praiseNum":null,"commentNum":0,"isSift":null,"browseCount":3,"mid":46}],"pageNum":1,"pageSize":10,"size":1,"startRow":1,"endRow":1,"pages":1,"prePage":0,"nextPage":0,"isFirstPage":true,"isLastPage":true,"hasPreviousPage":false,"hasNextPage":false,"navigatePages":8,"navigatepageNums":[1],"navigateFirstPage":1,"navigateLastPage":1}
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

    public static class ResultBean implements Serializable{
        /**
         * total : 1
         * list : [{"id":93,"type":1,"title":null,"content":"漂亮的很","picture":"http://oss.irving.net.cn/tea/1562834013033.jpeg,http://oss.irving.net.cn/tea/1562834004422.jpg,http://oss.irving.net.cn/tea/1562834003471.jpeg,http://oss.irving.net.cn/tea/1562834003698.jpg,http://oss.irving.net.cn/tea/1562834008713.jpeg,http://oss.irving.net.cn/tea/1562834006153.jpg","pictureWidth":800,"pictureHeight":800,"createTime":"2019-07-11 16:33:23","updateTime":"2019-07-11 16:33:23","longitude":114.261848,"latitude":22.725369,"address":null,"cityCode":"0755","member":null,"isPraise":null,"praiseNum":null,"commentNum":0,"isSift":null,"browseCount":3,"mid":46}]
         * pageNum : 1
         * pageSize : 10
         * size : 1
         * startRow : 1
         * endRow : 1
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

        public static class ListBean implements Serializable {
            /**
             * id : 93
             * type : 1
             * title : null
             * content : 漂亮的很
             * picture : http://oss.irving.net.cn/tea/1562834013033.jpeg,http://oss.irving.net.cn/tea/1562834004422.jpg,http://oss.irving.net.cn/tea/1562834003471.jpeg,http://oss.irving.net.cn/tea/1562834003698.jpg,http://oss.irving.net.cn/tea/1562834008713.jpeg,http://oss.irving.net.cn/tea/1562834006153.jpg
             * pictureWidth : 800
             * pictureHeight : 800
             * createTime : 2019-07-11 16:33:23
             * updateTime : 2019-07-11 16:33:23
             * longitude : 114.261848
             * latitude : 22.725369
             * address : null
             * cityCode : 0755
             * member : null
             * isPraise : null
             * praiseNum : null
             * commentNum : 0
             * isSift : null
             * browseCount : 3
             * mid : 46
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
            private double longitude;
            private double latitude;
            private Object address;
            private String cityCode;
            private Object member;
            private Object isPraise;
            private int praiseNum;
            private int commentNum;
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

            public String getCityCode() {
                return cityCode;
            }

            public void setCityCode(String cityCode) {
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
