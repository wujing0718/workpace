package com.huohougongfu.app.Gson;

import java.util.List;

public class MyPingJia {

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

            private Object mId;
            private Object level;
            private int id;
            private int productId;
            private String appraiseContent;
            private Object video;
            private String picture;
            private int appraiseCategory;
            private String describeScore;
            private Object logisticsScore;
            private String serviceScore;
            private int appraiserId;
            private Object photo;
            private Object levelMember;
            private Object createTime1;
            private String createTime;
            private String updateTime;
            private Object updateTime1;
            private int favour;
            private Object answerContent;
            private Object answerTime;
            private Object status;

            public Object getMId() {
                return mId;
            }

            public void setMId(Object mId) {
                this.mId = mId;
            }

            public Object getLevel() {
                return level;
            }

            public void setLevel(Object level) {
                this.level = level;
            }

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

            public Object getVideo() {
                return video;
            }

            public void setVideo(Object video) {
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

            public Object getLogisticsScore() {
                return logisticsScore;
            }

            public void setLogisticsScore(Object logisticsScore) {
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

            public Object getPhoto() {
                return photo;
            }

            public void setPhoto(Object photo) {
                this.photo = photo;
            }

            public Object getLevelMember() {
                return levelMember;
            }

            public void setLevelMember(Object levelMember) {
                this.levelMember = levelMember;
            }

            public Object getCreateTime1() {
                return createTime1;
            }

            public void setCreateTime1(Object createTime1) {
                this.createTime1 = createTime1;
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

            public Object getUpdateTime1() {
                return updateTime1;
            }

            public void setUpdateTime1(Object updateTime1) {
                this.updateTime1 = updateTime1;
            }

            public int getFavour() {
                return favour;
            }

            public void setFavour(int favour) {
                this.favour = favour;
            }

            public Object getAnswerContent() {
                return answerContent;
            }

            public void setAnswerContent(Object answerContent) {
                this.answerContent = answerContent;
            }

            public Object getAnswerTime() {
                return answerTime;
            }

            public void setAnswerTime(Object answerTime) {
                this.answerTime = answerTime;
            }

            public Object getStatus() {
                return status;
            }

            public void setStatus(Object status) {
                this.status = status;
            }
        }
    }
}
