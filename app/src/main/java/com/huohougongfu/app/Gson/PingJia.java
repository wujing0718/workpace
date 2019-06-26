package com.huohougongfu.app.Gson;

import java.util.List;

public class PingJia {

    /**
     * msg : 操作成功
     * result : {"total":1,"list":[{"id":1,"productId":44,"appraiseContent":"66","video":"魔**威","picture":"图片1","appraiseCategory":1,"describeScore":"描述评分","logisticsScore":"物流评分","serviceScore":"服务态度评分","appraiserId":1,"photo":"头像1","levelMember":"等级1","createTime":"2019-06-17T08:35:57.000+0000","updateTime":"2019-06-22T09:33:43.000+0000"}],"pageNum":1,"pageSize":3,"size":1,"startRow":1,"endRow":1,"pages":1,"prePage":0,"nextPage":0,"isFirstPage":true,"isLastPage":true,"hasPreviousPage":false,"hasNextPage":false,"navigatePages":8,"navigatepageNums":[1],"navigateFirstPage":1,"navigateLastPage":1}
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
         * total : 1
         * list : [{"id":1,"productId":44,"appraiseContent":"66","video":"魔**威","picture":"图片1","appraiseCategory":1,"describeScore":"描述评分","logisticsScore":"物流评分","serviceScore":"服务态度评分","appraiserId":1,"photo":"头像1","levelMember":"等级1","createTime":"2019-06-17T08:35:57.000+0000","updateTime":"2019-06-22T09:33:43.000+0000"}]
         * pageNum : 1
         * pageSize : 3
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

        public static class ListBean {
            /**
             * id : 1
             * productId : 44
             * appraiseContent : 66
             * video : 魔**威
             * picture : 图片1
             * appraiseCategory : 1
             * describeScore : 描述评分
             * logisticsScore : 物流评分
             * serviceScore : 服务态度评分
             * appraiserId : 1
             * photo : 头像1
             * levelMember : 等级1
             * createTime : 2019-06-17T08:35:57.000+0000
             * updateTime : 2019-06-22T09:33:43.000+0000
             */

            private int id;
            private int productId;
            private String appraiseContent;
            private String video;
            private String picture;
            private int appraiseCategory;
            private String describeScore;
            private String logisticsScore;
            private String serviceScore;
            private int appraiserId;
            private String photo;
            private String levelMember;
            private String createTime;
            private String updateTime;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public int getProductId() {
                return productId;
            }

            public void setProductId(int productId) {
                this.productId = productId;
            }

            public String getAppraiseContent() {
                return appraiseContent;
            }

            public void setAppraiseContent(String appraiseContent) {
                this.appraiseContent = appraiseContent;
            }

            public String getVideo() {
                return video;
            }

            public void setVideo(String video) {
                this.video = video;
            }

            public String getPicture() {
                return picture;
            }

            public void setPicture(String picture) {
                this.picture = picture;
            }

            public int getAppraiseCategory() {
                return appraiseCategory;
            }

            public void setAppraiseCategory(int appraiseCategory) {
                this.appraiseCategory = appraiseCategory;
            }

            public String getDescribeScore() {
                return describeScore;
            }

            public void setDescribeScore(String describeScore) {
                this.describeScore = describeScore;
            }

            public String getLogisticsScore() {
                return logisticsScore;
            }

            public void setLogisticsScore(String logisticsScore) {
                this.logisticsScore = logisticsScore;
            }

            public String getServiceScore() {
                return serviceScore;
            }

            public void setServiceScore(String serviceScore) {
                this.serviceScore = serviceScore;
            }

            public int getAppraiserId() {
                return appraiserId;
            }

            public void setAppraiserId(int appraiserId) {
                this.appraiserId = appraiserId;
            }

            public String getPhoto() {
                return photo;
            }

            public void setPhoto(String photo) {
                this.photo = photo;
            }

            public String getLevelMember() {
                return levelMember;
            }

            public void setLevelMember(String levelMember) {
                this.levelMember = levelMember;
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
