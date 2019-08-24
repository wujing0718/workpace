package com.huohougongfu.app.Gson;

import java.util.List;

public class TeYuePingPai {


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
        private String queryName;
        private ResultListBean resultList;
        private List<IsSpecialBean> isSpecial;

        public String getQueryName() {
            return queryName;
        }

        public void setQueryName(String queryName) {
            this.queryName = queryName;
        }

        public ResultListBean getResultList() {
            return resultList;
        }

        public void setResultList(ResultListBean resultList) {
            this.resultList = resultList;
        }

        public List<IsSpecialBean> getIsSpecial() {
            return isSpecial;
        }

        public void setIsSpecial(List<IsSpecialBean> isSpecial) {
            this.isSpecial = isSpecial;
        }

        public static class ResultListBean {
            /**
             * total : 3
             * list : [{"id":36,"userId":2,"storeBoard":null,"storeName":"比比画画","storeType":"2","storeAttention":"0","createTime":"2019-08-23T08:58:54.000+0000","updateTime":"2019-08-24T04:31:58.000+0000","info":null,"year":null,"favorableRate":0,"fensNum":null,"sellNum":null,"appraiseCategory":null,"productId":null,"coverUrl":null,"visitNum":null,"visitNumOfDay":null,"specialBrandInfo":null,"specialInstructions":null,"creditCard":null,"deliveryTime":null,"basicExpressFee":null,"freeAmountOfExpressFee":null,"status":null,"enterStore":null,"mallProductList":[{"id":79,"name":"我","storeName":null,"categoryId":null,"keywords":null,"model":null,"virtualNum":null,"price":45,"marketPrice":56,"integral":null,"stock":null,"warningStock":null,"coverUrl":"http://oss.irving.net.cn/tea/1566552498622.jpg","state":null,"showOrder":null,"sellNum":null,"isNew":null,"unit":null,"transId":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"del":null,"isRecommend":null,"isCheck":null,"limitIntegral":null,"subhead":null,"remark":null,"weight":null,"count":null,"sendIntegral":null,"sendGrowth":null,"productPicture":null,"storeId":36,"isSift":null,"brandId":null,"mallStore":null,"sellCount":null,"cartId":null,"cartProductNum":null,"buyNum":null,"commission":null,"reSell":null,"ofCheap":null,"detailDescribe":null,"detailPic":null,"sendAddress":null,"categoryName":null,"num":null,"basicService":null,"productType":null,"transName":null,"priceType":null,"deliveryType":null,"defaultTransCost":null,"branName":null,"brandImg":null,"brandIsSpecial":null,"brandOrder":null,"brandAddress":null,"attributeId":null,"standardId":null,"userId":null,"collectionNum":null,"standard":null,"transportTemplate":null},{"id":80,"name":"我","storeName":null,"categoryId":null,"keywords":null,"model":null,"virtualNum":null,"price":22,"marketPrice":34,"integral":null,"stock":null,"warningStock":null,"coverUrl":"http://oss.irving.net.cn/tea/1566456887405.jpg","state":null,"showOrder":null,"sellNum":null,"isNew":null,"unit":null,"transId":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"del":null,"isRecommend":null,"isCheck":null,"limitIntegral":null,"subhead":null,"remark":null,"weight":null,"count":null,"sendIntegral":null,"sendGrowth":null,"productPicture":null,"storeId":36,"isSift":null,"brandId":null,"mallStore":null,"sellCount":null,"cartId":null,"cartProductNum":null,"buyNum":null,"commission":null,"reSell":null,"ofCheap":null,"detailDescribe":null,"detailPic":null,"sendAddress":null,"categoryName":null,"num":null,"basicService":null,"productType":null,"transName":null,"priceType":null,"deliveryType":null,"defaultTransCost":null,"branName":null,"brandImg":null,"brandIsSpecial":null,"brandOrder":null,"brandAddress":null,"attributeId":null,"standardId":null,"userId":null,"collectionNum":null,"standard":null,"transportTemplate":null},{"id":81,"name":"特惠商品","storeName":null,"categoryId":null,"keywords":null,"model":null,"virtualNum":null,"price":15,"marketPrice":20,"integral":null,"stock":null,"warningStock":null,"coverUrl":"http://oss.irving.net.cn/tea/1566456890346.jpg","state":null,"showOrder":null,"sellNum":null,"isNew":null,"unit":null,"transId":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"del":null,"isRecommend":null,"isCheck":null,"limitIntegral":null,"subhead":null,"remark":null,"weight":null,"count":null,"sendIntegral":null,"sendGrowth":null,"productPicture":null,"storeId":36,"isSift":null,"brandId":null,"mallStore":null,"sellCount":null,"cartId":null,"cartProductNum":null,"buyNum":null,"commission":null,"reSell":null,"ofCheap":null,"detailDescribe":null,"detailPic":null,"sendAddress":null,"categoryName":null,"num":null,"basicService":null,"productType":null,"transName":null,"priceType":null,"deliveryType":null,"defaultTransCost":null,"branName":null,"brandImg":null,"brandIsSpecial":null,"brandOrder":null,"brandAddress":null,"attributeId":null,"standardId":null,"userId":null,"collectionNum":null,"standard":null,"transportTemplate":null}],"doorPhoto":"http://oss.irving.net.cn/tea/1566550740864.jpg"},{"id":37,"userId":4,"storeBoard":null,"storeName":"敬哥奶茶店","storeType":"2","storeAttention":"0","createTime":"2019-08-23T09:49:24.000+0000","updateTime":"2019-08-24T04:32:05.000+0000","info":null,"year":null,"favorableRate":0,"fensNum":null,"sellNum":null,"appraiseCategory":null,"productId":null,"coverUrl":null,"visitNum":null,"visitNumOfDay":null,"specialBrandInfo":null,"specialInstructions":null,"creditCard":null,"deliveryTime":null,"basicExpressFee":null,"freeAmountOfExpressFee":null,"status":null,"enterStore":null,"mallProductList":[{"id":82,"name":"商品名称","storeName":null,"categoryId":null,"keywords":null,"model":null,"virtualNum":null,"price":888,"marketPrice":998,"integral":null,"stock":null,"warningStock":null,"coverUrl":"http://oss.irving.net.cn/tea/1566554184589.jpg","state":null,"showOrder":null,"sellNum":null,"isNew":null,"unit":null,"transId":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"del":null,"isRecommend":null,"isCheck":null,"limitIntegral":null,"subhead":null,"remark":null,"weight":null,"count":null,"sendIntegral":null,"sendGrowth":null,"productPicture":null,"storeId":37,"isSift":null,"brandId":null,"mallStore":null,"sellCount":null,"cartId":null,"cartProductNum":null,"buyNum":null,"commission":null,"reSell":null,"ofCheap":null,"detailDescribe":null,"detailPic":null,"sendAddress":null,"categoryName":null,"num":null,"basicService":null,"productType":null,"transName":null,"priceType":null,"deliveryType":null,"defaultTransCost":null,"branName":null,"brandImg":null,"brandIsSpecial":null,"brandOrder":null,"brandAddress":null,"attributeId":null,"standardId":null,"userId":null,"collectionNum":null,"standard":null,"transportTemplate":null},{"id":83,"name":"精选商品1","storeName":null,"categoryId":null,"keywords":null,"model":null,"virtualNum":null,"price":30,"marketPrice":30,"integral":null,"stock":null,"warningStock":null,"coverUrl":"http://oss.irving.net.cn/tea/1566456890346.jpg","state":null,"showOrder":null,"sellNum":null,"isNew":null,"unit":null,"transId":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"del":null,"isRecommend":null,"isCheck":null,"limitIntegral":null,"subhead":null,"remark":null,"weight":null,"count":null,"sendIntegral":null,"sendGrowth":null,"productPicture":null,"storeId":37,"isSift":null,"brandId":null,"mallStore":null,"sellCount":null,"cartId":null,"cartProductNum":null,"buyNum":null,"commission":null,"reSell":null,"ofCheap":null,"detailDescribe":null,"detailPic":null,"sendAddress":null,"categoryName":null,"num":null,"basicService":null,"productType":null,"transName":null,"priceType":null,"deliveryType":null,"defaultTransCost":null,"branName":null,"brandImg":null,"brandIsSpecial":null,"brandOrder":null,"brandAddress":null,"attributeId":null,"standardId":null,"userId":null,"collectionNum":null,"standard":null,"transportTemplate":null}],"doorPhoto":"http://oss.irving.net.cn/tea/1566553773371.jpg"}]
             * pageNum : 1
             * pageSize : 2
             * size : 2
             * startRow : 1
             * endRow : 2
             * pages : 2
             * prePage : 0
             * nextPage : 2
             * isFirstPage : true
             * isLastPage : false
             * hasPreviousPage : false
             * hasNextPage : true
             * navigatePages : 8
             * navigatepageNums : [1,2]
             * navigateFirstPage : 1
             * navigateLastPage : 2
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
                 * id : 36
                 * userId : 2
                 * storeBoard : null
                 * storeName : 比比画画
                 * storeType : 2
                 * storeAttention : 0
                 * createTime : 2019-08-23T08:58:54.000+0000
                 * updateTime : 2019-08-24T04:31:58.000+0000
                 * info : null
                 * year : null
                 * favorableRate : 0
                 * fensNum : null
                 * sellNum : null
                 * appraiseCategory : null
                 * productId : null
                 * coverUrl : null
                 * visitNum : null
                 * visitNumOfDay : null
                 * specialBrandInfo : null
                 * specialInstructions : null
                 * creditCard : null
                 * deliveryTime : null
                 * basicExpressFee : null
                 * freeAmountOfExpressFee : null
                 * status : null
                 * enterStore : null
                 * mallProductList : [{"id":79,"name":"我","storeName":null,"categoryId":null,"keywords":null,"model":null,"virtualNum":null,"price":45,"marketPrice":56,"integral":null,"stock":null,"warningStock":null,"coverUrl":"http://oss.irving.net.cn/tea/1566552498622.jpg","state":null,"showOrder":null,"sellNum":null,"isNew":null,"unit":null,"transId":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"del":null,"isRecommend":null,"isCheck":null,"limitIntegral":null,"subhead":null,"remark":null,"weight":null,"count":null,"sendIntegral":null,"sendGrowth":null,"productPicture":null,"storeId":36,"isSift":null,"brandId":null,"mallStore":null,"sellCount":null,"cartId":null,"cartProductNum":null,"buyNum":null,"commission":null,"reSell":null,"ofCheap":null,"detailDescribe":null,"detailPic":null,"sendAddress":null,"categoryName":null,"num":null,"basicService":null,"productType":null,"transName":null,"priceType":null,"deliveryType":null,"defaultTransCost":null,"branName":null,"brandImg":null,"brandIsSpecial":null,"brandOrder":null,"brandAddress":null,"attributeId":null,"standardId":null,"userId":null,"collectionNum":null,"standard":null,"transportTemplate":null},{"id":80,"name":"我","storeName":null,"categoryId":null,"keywords":null,"model":null,"virtualNum":null,"price":22,"marketPrice":34,"integral":null,"stock":null,"warningStock":null,"coverUrl":"http://oss.irving.net.cn/tea/1566456887405.jpg","state":null,"showOrder":null,"sellNum":null,"isNew":null,"unit":null,"transId":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"del":null,"isRecommend":null,"isCheck":null,"limitIntegral":null,"subhead":null,"remark":null,"weight":null,"count":null,"sendIntegral":null,"sendGrowth":null,"productPicture":null,"storeId":36,"isSift":null,"brandId":null,"mallStore":null,"sellCount":null,"cartId":null,"cartProductNum":null,"buyNum":null,"commission":null,"reSell":null,"ofCheap":null,"detailDescribe":null,"detailPic":null,"sendAddress":null,"categoryName":null,"num":null,"basicService":null,"productType":null,"transName":null,"priceType":null,"deliveryType":null,"defaultTransCost":null,"branName":null,"brandImg":null,"brandIsSpecial":null,"brandOrder":null,"brandAddress":null,"attributeId":null,"standardId":null,"userId":null,"collectionNum":null,"standard":null,"transportTemplate":null},{"id":81,"name":"特惠商品","storeName":null,"categoryId":null,"keywords":null,"model":null,"virtualNum":null,"price":15,"marketPrice":20,"integral":null,"stock":null,"warningStock":null,"coverUrl":"http://oss.irving.net.cn/tea/1566456890346.jpg","state":null,"showOrder":null,"sellNum":null,"isNew":null,"unit":null,"transId":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"del":null,"isRecommend":null,"isCheck":null,"limitIntegral":null,"subhead":null,"remark":null,"weight":null,"count":null,"sendIntegral":null,"sendGrowth":null,"productPicture":null,"storeId":36,"isSift":null,"brandId":null,"mallStore":null,"sellCount":null,"cartId":null,"cartProductNum":null,"buyNum":null,"commission":null,"reSell":null,"ofCheap":null,"detailDescribe":null,"detailPic":null,"sendAddress":null,"categoryName":null,"num":null,"basicService":null,"productType":null,"transName":null,"priceType":null,"deliveryType":null,"defaultTransCost":null,"branName":null,"brandImg":null,"brandIsSpecial":null,"brandOrder":null,"brandAddress":null,"attributeId":null,"standardId":null,"userId":null,"collectionNum":null,"standard":null,"transportTemplate":null}]
                 * doorPhoto : http://oss.irving.net.cn/tea/1566550740864.jpg
                 */

                private int id;
                private int userId;
                private String storeBoard;
                private String storeName;
                private String storeType;
                private String storeAttention;
                private String createTime;
                private String updateTime;
                private Object info;
                private Object year;
                private int favorableRate;
                private Object fensNum;
                private Object sellNum;
                private Object appraiseCategory;
                private Object productId;
                private Object coverUrl;
                private Object visitNum;
                private Object visitNumOfDay;
                private Object specialBrandInfo;
                private Object specialInstructions;
                private Object creditCard;
                private Object deliveryTime;
                private Object basicExpressFee;
                private Object freeAmountOfExpressFee;
                private Object status;
                private Object enterStore;
                private String doorPhoto;
                private int isAttention;
                private List<MallProductListBean> mallProductList;

                public int getIsAttention() {
                    return isAttention;
                }

                public void setIsAttention(int iisAttentiond) {
                    this.isAttention = isAttention;
                }

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public int getUserId() {
                    return userId;
                }

                public void setUserId(int userId) {
                    this.userId = userId;
                }

                public String getStoreBoard() {
                    return storeBoard;
                }

                public void setStoreBoard(String storeBoard) {
                    this.storeBoard = storeBoard;
                }

                public String getStoreName() {
                    return storeName;
                }

                public void setStoreName(String storeName) {
                    this.storeName = storeName;
                }

                public String getStoreType() {
                    return storeType;
                }

                public void setStoreType(String storeType) {
                    this.storeType = storeType;
                }

                public String getStoreAttention() {
                    return storeAttention;
                }

                public void setStoreAttention(String storeAttention) {
                    this.storeAttention = storeAttention;
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

                public Object getInfo() {
                    return info;
                }

                public void setInfo(Object info) {
                    this.info = info;
                }

                public Object getYear() {
                    return year;
                }

                public void setYear(Object year) {
                    this.year = year;
                }

                public int getFavorableRate() {
                    return favorableRate;
                }

                public void setFavorableRate(int favorableRate) {
                    this.favorableRate = favorableRate;
                }

                public Object getFensNum() {
                    return fensNum;
                }

                public void setFensNum(Object fensNum) {
                    this.fensNum = fensNum;
                }

                public Object getSellNum() {
                    return sellNum;
                }

                public void setSellNum(Object sellNum) {
                    this.sellNum = sellNum;
                }

                public Object getAppraiseCategory() {
                    return appraiseCategory;
                }

                public void setAppraiseCategory(Object appraiseCategory) {
                    this.appraiseCategory = appraiseCategory;
                }

                public Object getProductId() {
                    return productId;
                }

                public void setProductId(Object productId) {
                    this.productId = productId;
                }

                public Object getCoverUrl() {
                    return coverUrl;
                }

                public void setCoverUrl(Object coverUrl) {
                    this.coverUrl = coverUrl;
                }

                public Object getVisitNum() {
                    return visitNum;
                }

                public void setVisitNum(Object visitNum) {
                    this.visitNum = visitNum;
                }

                public Object getVisitNumOfDay() {
                    return visitNumOfDay;
                }

                public void setVisitNumOfDay(Object visitNumOfDay) {
                    this.visitNumOfDay = visitNumOfDay;
                }

                public Object getSpecialBrandInfo() {
                    return specialBrandInfo;
                }

                public void setSpecialBrandInfo(Object specialBrandInfo) {
                    this.specialBrandInfo = specialBrandInfo;
                }

                public Object getSpecialInstructions() {
                    return specialInstructions;
                }

                public void setSpecialInstructions(Object specialInstructions) {
                    this.specialInstructions = specialInstructions;
                }

                public Object getCreditCard() {
                    return creditCard;
                }

                public void setCreditCard(Object creditCard) {
                    this.creditCard = creditCard;
                }

                public Object getDeliveryTime() {
                    return deliveryTime;
                }

                public void setDeliveryTime(Object deliveryTime) {
                    this.deliveryTime = deliveryTime;
                }

                public Object getBasicExpressFee() {
                    return basicExpressFee;
                }

                public void setBasicExpressFee(Object basicExpressFee) {
                    this.basicExpressFee = basicExpressFee;
                }

                public Object getFreeAmountOfExpressFee() {
                    return freeAmountOfExpressFee;
                }

                public void setFreeAmountOfExpressFee(Object freeAmountOfExpressFee) {
                    this.freeAmountOfExpressFee = freeAmountOfExpressFee;
                }

                public Object getStatus() {
                    return status;
                }

                public void setStatus(Object status) {
                    this.status = status;
                }

                public Object getEnterStore() {
                    return enterStore;
                }

                public void setEnterStore(Object enterStore) {
                    this.enterStore = enterStore;
                }

                public String getDoorPhoto() {
                    return doorPhoto;
                }

                public void setDoorPhoto(String doorPhoto) {
                    this.doorPhoto = doorPhoto;
                }

                public List<MallProductListBean> getMallProductList() {
                    return mallProductList;
                }

                public void setMallProductList(List<MallProductListBean> mallProductList) {
                    this.mallProductList = mallProductList;
                }

                public static class MallProductListBean {
                    /**
                     * id : 79
                     * name : 我
                     * storeName : null
                     * categoryId : null
                     * keywords : null
                     * model : null
                     * virtualNum : null
                     * price : 45
                     * marketPrice : 56
                     * integral : null
                     * stock : null
                     * warningStock : null
                     * coverUrl : http://oss.irving.net.cn/tea/1566552498622.jpg
                     * state : null
                     * showOrder : null
                     * sellNum : null
                     * isNew : null
                     * unit : null
                     * transId : null
                     * createBy : null
                     * createTime : null
                     * updateBy : null
                     * updateTime : null
                     * del : null
                     * isRecommend : null
                     * isCheck : null
                     * limitIntegral : null
                     * subhead : null
                     * remark : null
                     * weight : null
                     * count : null
                     * sendIntegral : null
                     * sendGrowth : null
                     * productPicture : null
                     * storeId : 36
                     * isSift : null
                     * brandId : null
                     * mallStore : null
                     * sellCount : null
                     * cartId : null
                     * cartProductNum : null
                     * buyNum : null
                     * commission : null
                     * reSell : null
                     * ofCheap : null
                     * detailDescribe : null
                     * detailPic : null
                     * sendAddress : null
                     * categoryName : null
                     * num : null
                     * basicService : null
                     * productType : null
                     * transName : null
                     * priceType : null
                     * deliveryType : null
                     * defaultTransCost : null
                     * branName : null
                     * brandImg : null
                     * brandIsSpecial : null
                     * brandOrder : null
                     * brandAddress : null
                     * attributeId : null
                     * standardId : null
                     * userId : null
                     * collectionNum : null
                     * standard : null
                     * transportTemplate : null
                     */

                    private int id;
                    private String name;
                    private Object storeName;
                    private Object categoryId;
                    private Object keywords;
                    private Object model;
                    private Object virtualNum;
                    private int price;
                    private int marketPrice;
                    private Object integral;
                    private Object stock;
                    private Object warningStock;
                    private String coverUrl;
                    private Object state;
                    private Object showOrder;
                    private Object sellNum;
                    private Object isNew;
                    private Object unit;
                    private Object transId;
                    private Object createBy;
                    private Object createTime;
                    private Object updateBy;
                    private Object updateTime;
                    private Object del;
                    private Object isRecommend;
                    private Object isCheck;
                    private Object limitIntegral;
                    private Object subhead;
                    private Object remark;
                    private Object weight;
                    private Object count;
                    private Object sendIntegral;
                    private Object sendGrowth;
                    private Object productPicture;
                    private int storeId;
                    private Object isSift;
                    private Object brandId;
                    private Object mallStore;
                    private Object sellCount;
                    private Object cartId;
                    private Object cartProductNum;
                    private Object buyNum;
                    private Object commission;
                    private Object reSell;
                    private Object ofCheap;
                    private Object detailDescribe;
                    private Object detailPic;
                    private Object sendAddress;
                    private Object categoryName;
                    private Object num;
                    private Object basicService;
                    private Object productType;
                    private Object transName;
                    private Object priceType;
                    private Object deliveryType;
                    private Object defaultTransCost;
                    private Object branName;
                    private Object brandImg;
                    private Object brandIsSpecial;
                    private Object brandOrder;
                    private Object brandAddress;
                    private Object attributeId;
                    private Object standardId;
                    private Object userId;
                    private Object collectionNum;
                    private Object standard;
                    private Object transportTemplate;

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

                    public Object getStoreName() {
                        return storeName;
                    }

                    public void setStoreName(Object storeName) {
                        this.storeName = storeName;
                    }

                    public Object getCategoryId() {
                        return categoryId;
                    }

                    public void setCategoryId(Object categoryId) {
                        this.categoryId = categoryId;
                    }

                    public Object getKeywords() {
                        return keywords;
                    }

                    public void setKeywords(Object keywords) {
                        this.keywords = keywords;
                    }

                    public Object getModel() {
                        return model;
                    }

                    public void setModel(Object model) {
                        this.model = model;
                    }

                    public Object getVirtualNum() {
                        return virtualNum;
                    }

                    public void setVirtualNum(Object virtualNum) {
                        this.virtualNum = virtualNum;
                    }

                    public int getPrice() {
                        return price;
                    }

                    public void setPrice(int price) {
                        this.price = price;
                    }

                    public int getMarketPrice() {
                        return marketPrice;
                    }

                    public void setMarketPrice(int marketPrice) {
                        this.marketPrice = marketPrice;
                    }

                    public Object getIntegral() {
                        return integral;
                    }

                    public void setIntegral(Object integral) {
                        this.integral = integral;
                    }

                    public Object getStock() {
                        return stock;
                    }

                    public void setStock(Object stock) {
                        this.stock = stock;
                    }

                    public Object getWarningStock() {
                        return warningStock;
                    }

                    public void setWarningStock(Object warningStock) {
                        this.warningStock = warningStock;
                    }

                    public String getCoverUrl() {
                        return coverUrl;
                    }

                    public void setCoverUrl(String coverUrl) {
                        this.coverUrl = coverUrl;
                    }

                    public Object getState() {
                        return state;
                    }

                    public void setState(Object state) {
                        this.state = state;
                    }

                    public Object getShowOrder() {
                        return showOrder;
                    }

                    public void setShowOrder(Object showOrder) {
                        this.showOrder = showOrder;
                    }

                    public Object getSellNum() {
                        return sellNum;
                    }

                    public void setSellNum(Object sellNum) {
                        this.sellNum = sellNum;
                    }

                    public Object getIsNew() {
                        return isNew;
                    }

                    public void setIsNew(Object isNew) {
                        this.isNew = isNew;
                    }

                    public Object getUnit() {
                        return unit;
                    }

                    public void setUnit(Object unit) {
                        this.unit = unit;
                    }

                    public Object getTransId() {
                        return transId;
                    }

                    public void setTransId(Object transId) {
                        this.transId = transId;
                    }

                    public Object getCreateBy() {
                        return createBy;
                    }

                    public void setCreateBy(Object createBy) {
                        this.createBy = createBy;
                    }

                    public Object getCreateTime() {
                        return createTime;
                    }

                    public void setCreateTime(Object createTime) {
                        this.createTime = createTime;
                    }

                    public Object getUpdateBy() {
                        return updateBy;
                    }

                    public void setUpdateBy(Object updateBy) {
                        this.updateBy = updateBy;
                    }

                    public Object getUpdateTime() {
                        return updateTime;
                    }

                    public void setUpdateTime(Object updateTime) {
                        this.updateTime = updateTime;
                    }

                    public Object getDel() {
                        return del;
                    }

                    public void setDel(Object del) {
                        this.del = del;
                    }

                    public Object getIsRecommend() {
                        return isRecommend;
                    }

                    public void setIsRecommend(Object isRecommend) {
                        this.isRecommend = isRecommend;
                    }

                    public Object getIsCheck() {
                        return isCheck;
                    }

                    public void setIsCheck(Object isCheck) {
                        this.isCheck = isCheck;
                    }

                    public Object getLimitIntegral() {
                        return limitIntegral;
                    }

                    public void setLimitIntegral(Object limitIntegral) {
                        this.limitIntegral = limitIntegral;
                    }

                    public Object getSubhead() {
                        return subhead;
                    }

                    public void setSubhead(Object subhead) {
                        this.subhead = subhead;
                    }

                    public Object getRemark() {
                        return remark;
                    }

                    public void setRemark(Object remark) {
                        this.remark = remark;
                    }

                    public Object getWeight() {
                        return weight;
                    }

                    public void setWeight(Object weight) {
                        this.weight = weight;
                    }

                    public Object getCount() {
                        return count;
                    }

                    public void setCount(Object count) {
                        this.count = count;
                    }

                    public Object getSendIntegral() {
                        return sendIntegral;
                    }

                    public void setSendIntegral(Object sendIntegral) {
                        this.sendIntegral = sendIntegral;
                    }

                    public Object getSendGrowth() {
                        return sendGrowth;
                    }

                    public void setSendGrowth(Object sendGrowth) {
                        this.sendGrowth = sendGrowth;
                    }

                    public Object getProductPicture() {
                        return productPicture;
                    }

                    public void setProductPicture(Object productPicture) {
                        this.productPicture = productPicture;
                    }

                    public int getStoreId() {
                        return storeId;
                    }

                    public void setStoreId(int storeId) {
                        this.storeId = storeId;
                    }

                    public Object getIsSift() {
                        return isSift;
                    }

                    public void setIsSift(Object isSift) {
                        this.isSift = isSift;
                    }

                    public Object getBrandId() {
                        return brandId;
                    }

                    public void setBrandId(Object brandId) {
                        this.brandId = brandId;
                    }

                    public Object getMallStore() {
                        return mallStore;
                    }

                    public void setMallStore(Object mallStore) {
                        this.mallStore = mallStore;
                    }

                    public Object getSellCount() {
                        return sellCount;
                    }

                    public void setSellCount(Object sellCount) {
                        this.sellCount = sellCount;
                    }

                    public Object getCartId() {
                        return cartId;
                    }

                    public void setCartId(Object cartId) {
                        this.cartId = cartId;
                    }

                    public Object getCartProductNum() {
                        return cartProductNum;
                    }

                    public void setCartProductNum(Object cartProductNum) {
                        this.cartProductNum = cartProductNum;
                    }

                    public Object getBuyNum() {
                        return buyNum;
                    }

                    public void setBuyNum(Object buyNum) {
                        this.buyNum = buyNum;
                    }

                    public Object getCommission() {
                        return commission;
                    }

                    public void setCommission(Object commission) {
                        this.commission = commission;
                    }

                    public Object getReSell() {
                        return reSell;
                    }

                    public void setReSell(Object reSell) {
                        this.reSell = reSell;
                    }

                    public Object getOfCheap() {
                        return ofCheap;
                    }

                    public void setOfCheap(Object ofCheap) {
                        this.ofCheap = ofCheap;
                    }

                    public Object getDetailDescribe() {
                        return detailDescribe;
                    }

                    public void setDetailDescribe(Object detailDescribe) {
                        this.detailDescribe = detailDescribe;
                    }

                    public Object getDetailPic() {
                        return detailPic;
                    }

                    public void setDetailPic(Object detailPic) {
                        this.detailPic = detailPic;
                    }

                    public Object getSendAddress() {
                        return sendAddress;
                    }

                    public void setSendAddress(Object sendAddress) {
                        this.sendAddress = sendAddress;
                    }

                    public Object getCategoryName() {
                        return categoryName;
                    }

                    public void setCategoryName(Object categoryName) {
                        this.categoryName = categoryName;
                    }

                    public Object getNum() {
                        return num;
                    }

                    public void setNum(Object num) {
                        this.num = num;
                    }

                    public Object getBasicService() {
                        return basicService;
                    }

                    public void setBasicService(Object basicService) {
                        this.basicService = basicService;
                    }

                    public Object getProductType() {
                        return productType;
                    }

                    public void setProductType(Object productType) {
                        this.productType = productType;
                    }

                    public Object getTransName() {
                        return transName;
                    }

                    public void setTransName(Object transName) {
                        this.transName = transName;
                    }

                    public Object getPriceType() {
                        return priceType;
                    }

                    public void setPriceType(Object priceType) {
                        this.priceType = priceType;
                    }

                    public Object getDeliveryType() {
                        return deliveryType;
                    }

                    public void setDeliveryType(Object deliveryType) {
                        this.deliveryType = deliveryType;
                    }

                    public Object getDefaultTransCost() {
                        return defaultTransCost;
                    }

                    public void setDefaultTransCost(Object defaultTransCost) {
                        this.defaultTransCost = defaultTransCost;
                    }

                    public Object getBranName() {
                        return branName;
                    }

                    public void setBranName(Object branName) {
                        this.branName = branName;
                    }

                    public Object getBrandImg() {
                        return brandImg;
                    }

                    public void setBrandImg(Object brandImg) {
                        this.brandImg = brandImg;
                    }

                    public Object getBrandIsSpecial() {
                        return brandIsSpecial;
                    }

                    public void setBrandIsSpecial(Object brandIsSpecial) {
                        this.brandIsSpecial = brandIsSpecial;
                    }

                    public Object getBrandOrder() {
                        return brandOrder;
                    }

                    public void setBrandOrder(Object brandOrder) {
                        this.brandOrder = brandOrder;
                    }

                    public Object getBrandAddress() {
                        return brandAddress;
                    }

                    public void setBrandAddress(Object brandAddress) {
                        this.brandAddress = brandAddress;
                    }

                    public Object getAttributeId() {
                        return attributeId;
                    }

                    public void setAttributeId(Object attributeId) {
                        this.attributeId = attributeId;
                    }

                    public Object getStandardId() {
                        return standardId;
                    }

                    public void setStandardId(Object standardId) {
                        this.standardId = standardId;
                    }

                    public Object getUserId() {
                        return userId;
                    }

                    public void setUserId(Object userId) {
                        this.userId = userId;
                    }

                    public Object getCollectionNum() {
                        return collectionNum;
                    }

                    public void setCollectionNum(Object collectionNum) {
                        this.collectionNum = collectionNum;
                    }

                    public Object getStandard() {
                        return standard;
                    }

                    public void setStandard(Object standard) {
                        this.standard = standard;
                    }

                    public Object getTransportTemplate() {
                        return transportTemplate;
                    }

                    public void setTransportTemplate(Object transportTemplate) {
                        this.transportTemplate = transportTemplate;
                    }
                }
            }
        }

        public static class IsSpecialBean {
            /**
             * id : 36
             * userId : 2
             * storeBoard : null
             * storeName : 比比画画
             * storeType : 2
             * createTime : 2019-08-23T08:58:54.000+0000
             * updateTime : 2019-08-24T04:31:58.000+0000
             * info : null
             * year : null
             * favorableRate : 0
             * fensNum : null
             * sellNum : null
             * appraiseCategory : null
             * productId : null
             * coverUrl : null
             * visitNum : null
             * visitNumOfDay : null
             * specialBrandInfo : null
             * specialInstructions : null
             * creditCard : null
             * deliveryTime : null
             * basicExpressFee : null
             * freeAmountOfExpressFee : null
             * status : null
             * enterStore : null
             * mallProductList : null
             * doorPhoto : http://oss.irving.net.cn/tea/1566550740864.jpg
             */

            private int id;
            private int userId;
            private Object storeBoard;
            private String storeName;
            private String storeType;
            private String createTime;
            private String updateTime;
            private Object info;
            private Object year;
            private int favorableRate;
            private Object fensNum;
            private Object sellNum;
            private Object appraiseCategory;
            private Object productId;
            private Object coverUrl;
            private Object visitNum;
            private Object visitNumOfDay;
            private Object specialBrandInfo;
            private Object specialInstructions;
            private Object creditCard;
            private Object deliveryTime;
            private Object basicExpressFee;
            private Object freeAmountOfExpressFee;
            private Object status;
            private Object enterStore;
            private Object mallProductList;
            private String doorPhoto;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public int getUserId() {
                return userId;
            }

            public void setUserId(int userId) {
                this.userId = userId;
            }

            public Object getStoreBoard() {
                return storeBoard;
            }

            public void setStoreBoard(Object storeBoard) {
                this.storeBoard = storeBoard;
            }

            public String getStoreName() {
                return storeName;
            }

            public void setStoreName(String storeName) {
                this.storeName = storeName;
            }

            public String getStoreType() {
                return storeType;
            }

            public void setStoreType(String storeType) {
                this.storeType = storeType;
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

            public Object getInfo() {
                return info;
            }

            public void setInfo(Object info) {
                this.info = info;
            }

            public Object getYear() {
                return year;
            }

            public void setYear(Object year) {
                this.year = year;
            }

            public int getFavorableRate() {
                return favorableRate;
            }

            public void setFavorableRate(int favorableRate) {
                this.favorableRate = favorableRate;
            }

            public Object getFensNum() {
                return fensNum;
            }

            public void setFensNum(Object fensNum) {
                this.fensNum = fensNum;
            }

            public Object getSellNum() {
                return sellNum;
            }

            public void setSellNum(Object sellNum) {
                this.sellNum = sellNum;
            }

            public Object getAppraiseCategory() {
                return appraiseCategory;
            }

            public void setAppraiseCategory(Object appraiseCategory) {
                this.appraiseCategory = appraiseCategory;
            }

            public Object getProductId() {
                return productId;
            }

            public void setProductId(Object productId) {
                this.productId = productId;
            }

            public Object getCoverUrl() {
                return coverUrl;
            }

            public void setCoverUrl(Object coverUrl) {
                this.coverUrl = coverUrl;
            }

            public Object getVisitNum() {
                return visitNum;
            }

            public void setVisitNum(Object visitNum) {
                this.visitNum = visitNum;
            }

            public Object getVisitNumOfDay() {
                return visitNumOfDay;
            }

            public void setVisitNumOfDay(Object visitNumOfDay) {
                this.visitNumOfDay = visitNumOfDay;
            }

            public Object getSpecialBrandInfo() {
                return specialBrandInfo;
            }

            public void setSpecialBrandInfo(Object specialBrandInfo) {
                this.specialBrandInfo = specialBrandInfo;
            }

            public Object getSpecialInstructions() {
                return specialInstructions;
            }

            public void setSpecialInstructions(Object specialInstructions) {
                this.specialInstructions = specialInstructions;
            }

            public Object getCreditCard() {
                return creditCard;
            }

            public void setCreditCard(Object creditCard) {
                this.creditCard = creditCard;
            }

            public Object getDeliveryTime() {
                return deliveryTime;
            }

            public void setDeliveryTime(Object deliveryTime) {
                this.deliveryTime = deliveryTime;
            }

            public Object getBasicExpressFee() {
                return basicExpressFee;
            }

            public void setBasicExpressFee(Object basicExpressFee) {
                this.basicExpressFee = basicExpressFee;
            }

            public Object getFreeAmountOfExpressFee() {
                return freeAmountOfExpressFee;
            }

            public void setFreeAmountOfExpressFee(Object freeAmountOfExpressFee) {
                this.freeAmountOfExpressFee = freeAmountOfExpressFee;
            }

            public Object getStatus() {
                return status;
            }

            public void setStatus(Object status) {
                this.status = status;
            }

            public Object getEnterStore() {
                return enterStore;
            }

            public void setEnterStore(Object enterStore) {
                this.enterStore = enterStore;
            }

            public Object getMallProductList() {
                return mallProductList;
            }

            public void setMallProductList(Object mallProductList) {
                this.mallProductList = mallProductList;
            }

            public String getDoorPhoto() {
                return doorPhoto;
            }

            public void setDoorPhoto(String doorPhoto) {
                this.doorPhoto = doorPhoto;
            }
        }
    }
}
