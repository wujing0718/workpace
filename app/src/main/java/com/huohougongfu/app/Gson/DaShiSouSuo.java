package com.huohougongfu.app.Gson;

import java.util.List;

public class DaShiSouSuo {
    /**
     * msg : 操作成功
     * result : {"total":3,"list":[{"id":2,"mId":17,"name":"大师名称","portrait":"大师师片","photo":null,"level":"高级茶艺师","specialty":"白茶","status":1,"introduceContent":"大师介绍1","createTime":"2019-07-16T01:24:48.000+0000","updateTime":"2019-07-19T06:09:53.000+0000","masterAddress":"深圳","storeId":null,"isMerchant":true,"count":0,"merchant":true},{"id":3,"mId":18,"name":"师","portrait":"师","photo":null,"level":"高级茶艺师","specialty":"红茶","status":1,"introduceContent":"吃顿饭","createTime":"2019-07-19T05:39:13.000+0000","updateTime":"2019-07-19T05:40:20.000+0000","masterAddress":null,"storeId":null,"isMerchant":null,"count":0,"merchant":null},{"id":4,"mId":40,"name":"寄快递","portrait":"大师MM","photo":null,"level":"高级茶艺师","specialty":"皇茶","status":1,"introduceContent":"大幅度","createTime":"2019-07-19T05:41:41.000+0000","updateTime":"2019-07-19T06:09:50.000+0000","masterAddress":"深圳","storeId":2,"isMerchant":false,"count":0,"merchant":false}],"pageNum":1,"pageSize":3,"size":3,"startRow":0,"endRow":2,"pages":1,"prePage":0,"nextPage":0,"isFirstPage":true,"isLastPage":true,"hasPreviousPage":false,"hasNextPage":false,"navigatePages":8,"navigatepageNums":[1],"navigateFirstPage":1,"navigateLastPage":1}
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
         * list : [{"id":2,"mId":17,"name":"大师名称","portrait":"大师师片","photo":null,"level":"高级茶艺师","specialty":"白茶","status":1,"introduceContent":"大师介绍1","createTime":"2019-07-16T01:24:48.000+0000","updateTime":"2019-07-19T06:09:53.000+0000","masterAddress":"深圳","storeId":null,"isMerchant":true,"count":0,"merchant":true},{"id":3,"mId":18,"name":"师","portrait":"师","photo":null,"level":"高级茶艺师","specialty":"红茶","status":1,"introduceContent":"吃顿饭","createTime":"2019-07-19T05:39:13.000+0000","updateTime":"2019-07-19T05:40:20.000+0000","masterAddress":null,"storeId":null,"isMerchant":null,"count":0,"merchant":null},{"id":4,"mId":40,"name":"寄快递","portrait":"大师MM","photo":null,"level":"高级茶艺师","specialty":"皇茶","status":1,"introduceContent":"大幅度","createTime":"2019-07-19T05:41:41.000+0000","updateTime":"2019-07-19T06:09:50.000+0000","masterAddress":"深圳","storeId":2,"isMerchant":false,"count":0,"merchant":false}]
         * pageNum : 1
         * pageSize : 3
         * size : 3
         * startRow : 0
         * endRow : 2
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
             * id : 2
             * mId : 17
             * name : 大师名称
             * portrait : 大师师片
             * photo : null
             * level : 高级茶艺师
             * specialty : 白茶
             * status : 1
             * introduceContent : 大师介绍1
             * createTime : 2019-07-16T01:24:48.000+0000
             * updateTime : 2019-07-19T06:09:53.000+0000
             * masterAddress : 深圳
             * storeId : null
             * isMerchant : true
             * count : 0
             * merchant : true
             */

            private int id;
            private int mId;
            private String name;
            private String portrait;
            private Object photo;
            private String level;
            private String specialty;
            private int status;
            private String introduceContent;
            private String createTime;
            private String updateTime;
            private String masterAddress;
            private Object storeId;
            private boolean isMerchant;
            private int count;
            private boolean merchant;

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

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getPortrait() {
                return portrait;
            }

            public void setPortrait(String portrait) {
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

            public String getSpecialty() {
                return specialty;
            }

            public void setSpecialty(String specialty) {
                this.specialty = specialty;
            }

            public int getStatus() {
                return status;
            }

            public void setStatus(int status) {
                this.status = status;
            }

            public String getIntroduceContent() {
                return introduceContent;
            }

            public void setIntroduceContent(String introduceContent) {
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

            public String getMasterAddress() {
                return masterAddress;
            }

            public void setMasterAddress(String masterAddress) {
                this.masterAddress = masterAddress;
            }

            public Object getStoreId() {
                return storeId;
            }

            public void setStoreId(Object storeId) {
                this.storeId = storeId;
            }

            public boolean isIsMerchant() {
                return isMerchant;
            }

            public void setIsMerchant(boolean isMerchant) {
                this.isMerchant = isMerchant;
            }

            public int getCount() {
                return count;
            }

            public void setCount(int count) {
                this.count = count;
            }

            public boolean isMerchant() {
                return merchant;
            }

            public void setMerchant(boolean merchant) {
                this.merchant = merchant;
            }
        }
    }
}
