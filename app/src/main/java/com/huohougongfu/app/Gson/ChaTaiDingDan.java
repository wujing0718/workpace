package com.huohougongfu.app.Gson;

import java.util.List;

public class ChaTaiDingDan {
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
            /**
             * id : 348
             * type : 2
             * orderNo : P201909021025378203466
             * machineId : AA00002
             * detailId : 1
             * details : [{"id":348,"machineId":"AA00002","teaId":null,"teaName":null,"price":null,"concentration":null,"hasdust":null,"count":null,"createTime":"2019-09-02 10:25:37","updateTime":"2019-09-02 10:25:37"}]
             * machineProduct : null
             * verificationCode :
             * payMethod : null
             * tradeNo : null
             * teaRiceNum : null
             * couponId : null
             * orderStatus : 0
             * orderTotal : 0.01
             * countdownTime : 2019-09-02 10:40:37
             * createTime : 2019-09-02 10:25:37
             * updateTime : 2019-09-02 10:25:37
             * teas : 商品:白茶
             * teaNum : null
             * currentTime : 2019-09-02 10:26:35
             * coupon : null
             * refillNum : 0
             * takeTeaTime : null
             * isOverdue : false
             * mid : 3
             */

            private int id;
            private int type;
            private String orderNo;
            private String machineId;
            private String detailId;
            private Object machineProduct;
            private String verificationCode;
            private Object payMethod;
            private Object tradeNo;
            private Object teaRiceNum;
            private Object couponId;
            private String orderStatus;
            private double orderTotal;
            private String countdownTime;
            private String createTime;
            private String updateTime;
            private String teas;
            private Object teaNum;
            private String currentTime;
            private Object coupon;
            private int refillNum;
            private Object takeTeaTime;
            private boolean isOverdue;
            private int mid;
            private List<DetailsBean> details;

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

            public String getOrderNo() {
                return orderNo;
            }

            public void setOrderNo(String orderNo) {
                this.orderNo = orderNo;
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

            public Object getMachineProduct() {
                return machineProduct;
            }

            public void setMachineProduct(Object machineProduct) {
                this.machineProduct = machineProduct;
            }

            public String getVerificationCode() {
                return verificationCode;
            }

            public void setVerificationCode(String verificationCode) {
                this.verificationCode = verificationCode;
            }

            public Object getPayMethod() {
                return payMethod;
            }

            public void setPayMethod(Object payMethod) {
                this.payMethod = payMethod;
            }

            public Object getTradeNo() {
                return tradeNo;
            }

            public void setTradeNo(Object tradeNo) {
                this.tradeNo = tradeNo;
            }

            public Object getTeaRiceNum() {
                return teaRiceNum;
            }

            public void setTeaRiceNum(Object teaRiceNum) {
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

            public String getCountdownTime() {
                return countdownTime;
            }

            public void setCountdownTime(String countdownTime) {
                this.countdownTime = countdownTime;
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

            public Object getTeaNum() {
                return teaNum;
            }

            public void setTeaNum(Object teaNum) {
                this.teaNum = teaNum;
            }

            public String getCurrentTime() {
                return currentTime;
            }

            public void setCurrentTime(String currentTime) {
                this.currentTime = currentTime;
            }

            public Object getCoupon() {
                return coupon;
            }

            public void setCoupon(Object coupon) {
                this.coupon = coupon;
            }

            public int getRefillNum() {
                return refillNum;
            }

            public void setRefillNum(int refillNum) {
                this.refillNum = refillNum;
            }

            public Object getTakeTeaTime() {
                return takeTeaTime;
            }

            public void setTakeTeaTime(Object takeTeaTime) {
                this.takeTeaTime = takeTeaTime;
            }

            public boolean isIsOverdue() {
                return isOverdue;
            }

            public void setIsOverdue(boolean isOverdue) {
                this.isOverdue = isOverdue;
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
                 * id : 348
                 * machineId : AA00002
                 * teaId : null
                 * teaName : null
                 * price : null
                 * concentration : null
                 * hasdust : null
                 * count : null
                 * createTime : 2019-09-02 10:25:37
                 * updateTime : 2019-09-02 10:25:37
                 */

                private int id;
                private String machineId;
                private Object teaId;
                private Object teaName;
                private Object price;
                private Object concentration;
                private Object hasdust;
                private Object count;
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

                public Object getTeaId() {
                    return teaId;
                }

                public void setTeaId(Object teaId) {
                    this.teaId = teaId;
                }

                public Object getTeaName() {
                    return teaName;
                }

                public void setTeaName(Object teaName) {
                    this.teaName = teaName;
                }

                public Object getPrice() {
                    return price;
                }

                public void setPrice(Object price) {
                    this.price = price;
                }

                public Object getConcentration() {
                    return concentration;
                }

                public void setConcentration(Object concentration) {
                    this.concentration = concentration;
                }

                public Object getHasdust() {
                    return hasdust;
                }

                public void setHasdust(Object hasdust) {
                    this.hasdust = hasdust;
                }

                public Object getCount() {
                    return count;
                }

                public void setCount(Object count) {
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
