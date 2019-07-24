package com.huohougongfu.app.Gson;

import java.util.List;

public class ChaTaiDingDan {
    /**
     * msg : 操作成功
     * result : {"total":4,"list":[{"id":40,"machineId":"A0001","detailId":"64","details":[{"id":61,"machineId":"A0001","teaId":2,"concentration":"标准","hasdust":1,"count":1,"createTime":"2019-07-24 10:20:45","updateTime":"2019-07-24 10:20:45"}],"verificationCode":"E88O0ONH","teaRiceNum":0,"couponId":null,"orderStatus":"0","orderTotal":12,"createTime":"1563952088000","updateTime":"2019-07-24T07:08:08.000+0000","teas":"[]","teaNum":null,"mid":43},{"id":41,"machineId":"A0001","detailId":"65","details":[],"verificationCode":"EL61CPT6","teaRiceNum":0,"couponId":null,"orderStatus":"0","orderTotal":12,"createTime":"1563952091000","updateTime":"2019-07-24T07:08:11.000+0000","teas":"[]","teaNum":null,"mid":43},{"id":47,"machineId":"A0001","detailId":"71","details":[],"verificationCode":"V2EKD0CC","teaRiceNum":0,"couponId":null,"orderStatus":"0","orderTotal":12,"createTime":"1563954350000","updateTime":"2019-07-24T07:45:50.000+0000","teas":"[]","teaNum":null,"mid":43},{"id":48,"machineId":"A0001","detailId":"72","details":[],"verificationCode":"GTTJFZB0","teaRiceNum":0,"couponId":null,"orderStatus":"0","orderTotal":12,"createTime":"1563954351000","updateTime":"2019-07-24T07:45:51.000+0000","teas":"[]","teaNum":null,"mid":43}],"pageNum":1,"pageSize":10,"size":4,"startRow":1,"endRow":4,"pages":1,"prePage":0,"nextPage":0,"isFirstPage":true,"isLastPage":true,"hasPreviousPage":false,"hasNextPage":false,"navigatePages":8,"navigatepageNums":[1],"navigateFirstPage":1,"navigateLastPage":1}
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
         * total : 4
         * list : [{"id":40,"machineId":"A0001","detailId":"64","details":[{"id":61,"machineId":"A0001","teaId":2,"concentration":"标准","hasdust":1,"count":1,"createTime":"2019-07-24 10:20:45","updateTime":"2019-07-24 10:20:45"}],"verificationCode":"E88O0ONH","teaRiceNum":0,"couponId":null,"orderStatus":"0","orderTotal":12,"createTime":"1563952088000","updateTime":"2019-07-24T07:08:08.000+0000","teas":"[]","teaNum":null,"mid":43},{"id":41,"machineId":"A0001","detailId":"65","details":[],"verificationCode":"EL61CPT6","teaRiceNum":0,"couponId":null,"orderStatus":"0","orderTotal":12,"createTime":"1563952091000","updateTime":"2019-07-24T07:08:11.000+0000","teas":"[]","teaNum":null,"mid":43},{"id":47,"machineId":"A0001","detailId":"71","details":[],"verificationCode":"V2EKD0CC","teaRiceNum":0,"couponId":null,"orderStatus":"0","orderTotal":12,"createTime":"1563954350000","updateTime":"2019-07-24T07:45:50.000+0000","teas":"[]","teaNum":null,"mid":43},{"id":48,"machineId":"A0001","detailId":"72","details":[],"verificationCode":"GTTJFZB0","teaRiceNum":0,"couponId":null,"orderStatus":"0","orderTotal":12,"createTime":"1563954351000","updateTime":"2019-07-24T07:45:51.000+0000","teas":"[]","teaNum":null,"mid":43}]
         * pageNum : 1
         * pageSize : 10
         * size : 4
         * startRow : 1
         * endRow : 4
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
             * id : 40
             * machineId : A0001
             * detailId : 64
             * details : [{"id":61,"machineId":"A0001","teaId":2,"concentration":"标准","hasdust":1,"count":1,"createTime":"2019-07-24 10:20:45","updateTime":"2019-07-24 10:20:45"}]
             * verificationCode : E88O0ONH
             * teaRiceNum : 0
             * couponId : null
             * orderStatus : 0
             * orderTotal : 12.0
             * createTime : 1563952088000
             * updateTime : 2019-07-24T07:08:08.000+0000
             * teas : []
             * teaNum : null
             * mid : 43
             */

            private int id;
            private String machineId;
            private String detailId;
            private String verificationCode;
            private int teaRiceNum;
            private Object couponId;
            private String orderStatus;
            private double orderTotal;
            private String createTime;
            private String updateTime;
            private String teas;
            private int teaNum;
            private int mid;
            private List<DetailsBean> details;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getMachineId() {
                return machineId;
            }

            public void setMachineId(String machineId) {
                this.machineId = machineId;
            }

            public String getDetailId() {
                return detailId;
            }

            public void setDetailId(String detailId) {
                this.detailId = detailId;
            }

            public String getVerificationCode() {
                return verificationCode;
            }

            public void setVerificationCode(String verificationCode) {
                this.verificationCode = verificationCode;
            }

            public int getTeaRiceNum() {
                return teaRiceNum;
            }

            public void setTeaRiceNum(int teaRiceNum) {
                this.teaRiceNum = teaRiceNum;
            }

            public Object getCouponId() {
                return couponId;
            }

            public void setCouponId(Object couponId) {
                this.couponId = couponId;
            }

            public String getOrderStatus() {
                return orderStatus;
            }

            public void setOrderStatus(String orderStatus) {
                this.orderStatus = orderStatus;
            }

            public double getOrderTotal() {
                return orderTotal;
            }

            public void setOrderTotal(double orderTotal) {
                this.orderTotal = orderTotal;
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

            public String getTeas() {
                return teas;
            }

            public void setTeas(String teas) {
                this.teas = teas;
            }

            public int getTeaNum() {
                return teaNum;
            }

            public void setTeaNum(int teaNum) {
                this.teaNum = teaNum;
            }

            public int getMid() {
                return mid;
            }

            public void setMid(int mid) {
                this.mid = mid;
            }

            public List<DetailsBean> getDetails() {
                return details;
            }

            public void setDetails(List<DetailsBean> details) {
                this.details = details;
            }

            public static class DetailsBean {
                /**
                 * id : 61
                 * machineId : A0001
                 * teaId : 2
                 * concentration : 标准
                 * hasdust : 1
                 * count : 1
                 * createTime : 2019-07-24 10:20:45
                 * updateTime : 2019-07-24 10:20:45
                 */

                private int id;
                private String machineId;
                private int teaId;
                private String concentration;
                private int hasdust;
                private int count;
                private String createTime;
                private String updateTime;

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public String getMachineId() {
                    return machineId;
                }

                public void setMachineId(String machineId) {
                    this.machineId = machineId;
                }

                public int getTeaId() {
                    return teaId;
                }

                public void setTeaId(int teaId) {
                    this.teaId = teaId;
                }

                public String getConcentration() {
                    return concentration;
                }

                public void setConcentration(String concentration) {
                    this.concentration = concentration;
                }

                public int getHasdust() {
                    return hasdust;
                }

                public void setHasdust(int hasdust) {
                    this.hasdust = hasdust;
                }

                public int getCount() {
                    return count;
                }

                public void setCount(int count) {
                    this.count = count;
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
