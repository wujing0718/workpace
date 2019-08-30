package com.huohougongfu.app.Gson;

import java.util.List;

public class ZhangDan {

    /**
     * msg : 操作成功
     * result : {"negative":-0.01,"records":{"total":1,"list":[{"recordId":null,"count":-0.01,"type":"机器买茶","createtime":"2019-08-29 17:12:12","updatetime":"2019-08-29 17:12:12","photo":"http://oss.irving.net.cn/tea/1566804446416.jpg","nickName":"18910328","mid":null}],"pageNum":1,"pageSize":10,"size":1,"startRow":1,"endRow":1,"pages":1,"prePage":0,"nextPage":0,"isFirstPage":true,"isLastPage":true,"hasPreviousPage":false,"hasNextPage":false,"navigatePages":8,"navigatepageNums":[1],"navigateFirstPage":1,"navigateLastPage":1},"positive":0}
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
         * negative : -0.01
         * records : {"total":1,"list":[{"recordId":null,"count":-0.01,"type":"机器买茶","createtime":"2019-08-29 17:12:12","updatetime":"2019-08-29 17:12:12","photo":"http://oss.irving.net.cn/tea/1566804446416.jpg","nickName":"18910328","mid":null}],"pageNum":1,"pageSize":10,"size":1,"startRow":1,"endRow":1,"pages":1,"prePage":0,"nextPage":0,"isFirstPage":true,"isLastPage":true,"hasPreviousPage":false,"hasNextPage":false,"navigatePages":8,"navigatepageNums":[1],"navigateFirstPage":1,"navigateLastPage":1}
         * positive : 0.0
         */

        private double negative;
        private RecordsBean records;
        private double positive;

        public double getNegative() {
            return negative;
        }

        public void setNegative(double negative) {
            this.negative = negative;
        }

        public RecordsBean getRecords() {
            return records;
        }

        public void setRecords(RecordsBean records) {
            this.records = records;
        }

        public double getPositive() {
            return positive;
        }

        public void setPositive(double positive) {
            this.positive = positive;
        }

        public static class RecordsBean {
            /**
             * total : 1
             * list : [{"recordId":null,"count":-0.01,"type":"机器买茶","createtime":"2019-08-29 17:12:12","updatetime":"2019-08-29 17:12:12","photo":"http://oss.irving.net.cn/tea/1566804446416.jpg","nickName":"18910328","mid":null}]
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

            public static class ListBean {
                /**
                 * recordId : null
                 * count : -0.01
                 * type : 机器买茶
                 * createtime : 2019-08-29 17:12:12
                 * updatetime : 2019-08-29 17:12:12
                 * photo : http://oss.irving.net.cn/tea/1566804446416.jpg
                 * nickName : 18910328
                 * mid : null
                 */

                private Object recordId;
                private double count;
                private String type;
                private String createtime;
                private String updatetime;
                private String photo;
                private String nickName;
                private Object mid;

                public Object getRecordId() {
                    return recordId;
                }

                public void setRecordId(Object recordId) {
                    this.recordId = recordId;
                }

                public double getCount() {
                    return count;
                }

                public void setCount(double count) {
                    this.count = count;
                }

                public String getType() {
                    return type;
                }

                public void setType(String type) {
                    this.type = type;
                }

                public String getCreatetime() {
                    return createtime;
                }

                public void setCreatetime(String createtime) {
                    this.createtime = createtime;
                }

                public String getUpdatetime() {
                    return updatetime;
                }

                public void setUpdatetime(String updatetime) {
                    this.updatetime = updatetime;
                }

                public String getPhoto() {
                    return photo;
                }

                public void setPhoto(String photo) {
                    this.photo = photo;
                }

                public String getNickName() {
                    return nickName;
                }

                public void setNickName(String nickName) {
                    this.nickName = nickName;
                }

                public Object getMid() {
                    return mid;
                }

                public void setMid(Object mid) {
                    this.mid = mid;
                }
            }
        }
    }
}
