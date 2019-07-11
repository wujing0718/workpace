package com.huohougongfu.app.Gson;

import java.util.List;

public class PingJia {

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
            private String level;
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
            private int favour;
            private String answerContent;
            private String answerTime;
            private boolean status;

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

            public String getLevel() {
                return level;
            }

            public void setLevel(String level) {
                this.level = level;
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

            public int getFavour() {
                return favour;
            }

            public void setFavour(int favour) {
                this.favour = favour;
            }

            public String getAnswerContent() {
                return answerContent;
            }

            public void setAnswerContent(String answerContent) {
                this.answerContent = answerContent;
            }

            public String getAnswerTime() {
                return answerTime;
            }

            public void setAnswerTime(String answerTime) {
                this.answerTime = answerTime;
            }

            public boolean getStatus() {
                return status;
            }

            public void setStatus(boolean status) {
                this.status = status;
            }
        }
    }
}
