package com.huohougongfu.app.Gson;

import java.util.List;

public class ShopGson {

    /**
     * msg : 操作成功
     * result : {"total":9,"list":[{"id":19,"name":"测试","model":"测试店铺","price":25,"coverUrl":"http://img.redocn.com/sheying/20150213/mulanweichangcaoyuanfengjing_3951976.jpg","sellNum":0},{"id":20,"name":"测试","model":"测试店铺2","price":25,"coverUrl":"1212","sellNum":0},{"id":27,"name":"测试","model":"测试店铺","price":25,"coverUrl":"1212","sellNum":0},{"id":28,"name":"测试","model":"测试店铺","price":25,"coverUrl":"1212","sellNum":0},{"id":29,"name":"测试","model":"测试店铺2","price":111,"coverUrl":"1212","sellNum":0},{"id":30,"name":"测试","model":"测试店铺2","price":25,"coverUrl":"1212","sellNum":0},{"id":35,"name":"商品标题","model":"测试店铺","price":12,"coverUrl":"封面图","sellNum":0},{"id":45,"name":"商品标题","model":"测试店铺","price":1,"coverUrl":"http://img2.imgtn.bdimg.com/it/u=180868167,273146879&fm=26&gp=0.jpg","sellNum":0},{"id":47,"name":"商品标题","model":"测试店铺","price":75,"coverUrl":"封面图片","sellNum":0}],"pageNum":1,"pageSize":20,"size":9,"startRow":1,"endRow":9,"pages":1,"prePage":0,"nextPage":0,"isFirstPage":true,"isLastPage":true,"hasPreviousPage":false,"hasNextPage":false,"navigatePages":8,"navigatepageNums":[1],"navigateFirstPage":1,"navigateLastPage":1}
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
         * total : 9
         * list : [{"id":19,"name":"测试","model":"测试店铺","price":25,"coverUrl":"http://img.redocn.com/sheying/20150213/mulanweichangcaoyuanfengjing_3951976.jpg","sellNum":0},{"id":20,"name":"测试","model":"测试店铺2","price":25,"coverUrl":"1212","sellNum":0},{"id":27,"name":"测试","model":"测试店铺","price":25,"coverUrl":"1212","sellNum":0},{"id":28,"name":"测试","model":"测试店铺","price":25,"coverUrl":"1212","sellNum":0},{"id":29,"name":"测试","model":"测试店铺2","price":111,"coverUrl":"1212","sellNum":0},{"id":30,"name":"测试","model":"测试店铺2","price":25,"coverUrl":"1212","sellNum":0},{"id":35,"name":"商品标题","model":"测试店铺","price":12,"coverUrl":"封面图","sellNum":0},{"id":45,"name":"商品标题","model":"测试店铺","price":1,"coverUrl":"http://img2.imgtn.bdimg.com/it/u=180868167,273146879&fm=26&gp=0.jpg","sellNum":0},{"id":47,"name":"商品标题","model":"测试店铺","price":75,"coverUrl":"封面图片","sellNum":0}]
         * pageNum : 1
         * pageSize : 20
         * size : 9
         * startRow : 1
         * endRow : 9
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
             * id : 19
             * name : 测试
             * model : 测试店铺
             * price : 25.0
             * coverUrl : http://img.redocn.com/sheying/20150213/mulanweichangcaoyuanfengjing_3951976.jpg
             * sellNum : 0
             */

            private int id;
            private String name;
            private String model;
            private double price;
            private String coverUrl;
            private int sellNum;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getModel() {
                return model;
            }

            public void setModel(String model) {
                this.model = model;
            }

            public double getPrice() {
                return price;
            }

            public void setPrice(double price) {
                this.price = price;
            }

            public String getCoverUrl() {
                return coverUrl;
            }

            public void setCoverUrl(String coverUrl) {
                this.coverUrl = coverUrl;
            }

            public int getSellNum() {
                return sellNum;
            }

            public void setSellNum(int sellNum) {
                this.sellNum = sellNum;
            }
        }
    }
}
