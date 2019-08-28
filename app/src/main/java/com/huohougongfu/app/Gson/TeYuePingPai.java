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
        /**
         * isSpecial : [{"id":4,"userId":3,"storePicture":null,"storeLogo":null,"storeBoard":null,"storeName":"爱喝茶的人","storePhone":null,"storeType":"2","createTime":"2019-08-26T08:37:09.000+0000","updateTime":"2019-08-27T08:11:31.000+0000","info":null,"year":null,"favorableRate":0,"fensNum":null,"sellNum":null,"appraiseCategory":null,"productId":null,"coverUrl":null,"visitNum":null,"visitNumOfDay":null,"specialBrandInfo":null,"specialInstructions":null,"creditCard":null,"deliveryTime":null,"basicExpressFee":null,"freeAmountOfExpressFee":null,"status":null,"enterStore":null,"doorPhoto":"http://oss.irving.net.cn/tea/1566808633243.jpg","mallProductList":null,"isAttention":null},{"id":5,"userId":1,"storePicture":null,"storeLogo":null,"storeBoard":null,"storeName":"范正勇的店铺","storePhone":null,"storeType":"2","createTime":"2019-08-27T09:52:59.000+0000","updateTime":"2019-08-27T09:54:08.000+0000","info":null,"year":null,"favorableRate":0,"fensNum":null,"sellNum":null,"appraiseCategory":null,"productId":null,"coverUrl":null,"visitNum":null,"visitNumOfDay":null,"specialBrandInfo":null,"specialInstructions":null,"creditCard":null,"deliveryTime":null,"basicExpressFee":null,"freeAmountOfExpressFee":null,"status":null,"enterStore":null,"doorPhoto":"http://oss.irving.net.cn/tea/1566899585195.jpg","mallProductList":null,"isAttention":null}]
         * resultList : {"total":4,"list":[{"id":1,"userId":4,"storePicture":null,"storeLogo":null,"storeBoard":null,"storeName":"爱茶之人","storePhone":null,"createTime":"2019-08-26T07:31:42.000+0000","updateTime":"2019-08-26T07:32:34.000+0000","info":null,"year":null,"favorableRate":0,"fensNum":null,"sellNum":null,"appraiseCategory":null,"productId":null,"coverUrl":null,"visitNum":null,"visitNumOfDay":null,"specialBrandInfo":null,"specialInstructions":null,"creditCard":null,"deliveryTime":null,"basicExpressFee":null,"freeAmountOfExpressFee":null,"status":null,"enterStore":null,"doorPhoto":null,"mallProductList":[{"id":1,"name":"茶叶","storeName":null,"categoryId":null,"keywords":null,"model":null,"virtualNum":null,"price":1,"marketPrice":2,"integral":null,"stock":null,"warningStock":null,"coverUrl":"http://oss.irving.net.cn/tea/1566805533099.jpg","state":null,"showOrder":null,"sellNum":null,"isNew":null,"unit":null,"transId":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"del":null,"isRecommend":null,"isCheck":null,"limitIntegral":null,"subhead":null,"remark":null,"weight":null,"count":null,"sendIntegral":null,"sendGrowth":null,"productPicture":null,"storeId":1,"isSift":null,"brandId":null,"mallStore":null,"sellCount":null,"cartId":null,"cartProductNum":null,"buyNum":null,"commission":null,"reSell":null,"ofCheap":null,"detailDescribe":null,"detailPic":null,"sendAddress":null,"categoryName":null,"basisService":null,"defaultTranCost":null,"num":null,"basicService":null,"productType":null,"transName":null,"priceType":null,"deliveryType":null,"defaultTransCost":null,"branName":null,"brandImg":null,"brandIsSpecial":null,"brandOrder":null,"brandAddress":null,"attributeId":null,"standardId":null,"userId":null,"collectionNum":null,"standard":null,"transportTemplate":null},{"id":2,"name":"普洱","storeName":null,"categoryId":null,"keywords":null,"model":null,"virtualNum":null,"price":1,"marketPrice":2,"integral":null,"stock":null,"warningStock":null,"coverUrl":"http://oss.irving.net.cn/tea/1566805841566.jpg","state":null,"showOrder":null,"sellNum":null,"isNew":null,"unit":null,"transId":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"del":null,"isRecommend":null,"isCheck":null,"limitIntegral":null,"subhead":null,"remark":null,"weight":null,"count":null,"sendIntegral":null,"sendGrowth":null,"productPicture":null,"storeId":1,"isSift":null,"brandId":null,"mallStore":null,"sellCount":null,"cartId":null,"cartProductNum":null,"buyNum":null,"commission":null,"reSell":null,"ofCheap":null,"detailDescribe":null,"detailPic":null,"sendAddress":null,"categoryName":null,"basisService":null,"defaultTranCost":null,"num":null,"basicService":null,"productType":null,"transName":null,"priceType":null,"deliveryType":null,"defaultTransCost":null,"branName":null,"brandImg":null,"brandIsSpecial":null,"brandOrder":null,"brandAddress":null,"attributeId":null,"standardId":null,"userId":null,"collectionNum":null,"standard":null,"transportTemplate":null},{"id":3,"name":"绿茶","storeName":null,"categoryId":null,"keywords":null,"model":null,"virtualNum":null,"price":1,"marketPrice":1,"integral":null,"stock":null,"warningStock":null,"coverUrl":"http://oss.irving.net.cn/tea/1566809411961.jpg","state":null,"showOrder":null,"sellNum":null,"isNew":null,"unit":null,"transId":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"del":null,"isRecommend":null,"isCheck":null,"limitIntegral":null,"subhead":null,"remark":null,"weight":null,"count":null,"sendIntegral":null,"sendGrowth":null,"productPicture":null,"storeId":1,"isSift":null,"brandId":null,"mallStore":null,"sellCount":null,"cartId":null,"cartProductNum":null,"buyNum":null,"commission":null,"reSell":null,"ofCheap":null,"detailDescribe":null,"detailPic":null,"sendAddress":null,"categoryName":null,"basisService":null,"defaultTranCost":null,"num":null,"basicService":null,"productType":null,"transName":null,"priceType":null,"deliveryType":null,"defaultTransCost":null,"branName":null,"brandImg":null,"brandIsSpecial":null,"brandOrder":null,"brandAddress":null,"attributeId":null,"standardId":null,"userId":null,"collectionNum":null,"standard":null,"transportTemplate":null}],"isAttention":0,"storeType":"2"},{"id":4,"userId":3,"storePicture":null,"storeLogo":null,"storeBoard":null,"storeName":"爱喝茶的人","storePhone":null,"storeType":"2","createTime":"2019-08-26T08:37:09.000+0000","updateTime":"2019-08-27T08:11:31.000+0000","info":null,"year":null,"favorableRate":0,"fensNum":null,"sellNum":null,"appraiseCategory":null,"productId":null,"coverUrl":null,"visitNum":null,"visitNumOfDay":null,"specialBrandInfo":null,"specialInstructions":null,"creditCard":null,"deliveryTime":null,"basicExpressFee":null,"freeAmountOfExpressFee":null,"status":null,"enterStore":null,"doorPhoto":null,"mallProductList":[{"id":5,"name":"红白绿茶","storeName":null,"categoryId":null,"keywords":null,"model":null,"virtualNum":null,"price":100,"marketPrice":200,"integral":null,"stock":null,"warningStock":null,"coverUrl":"http://oss.irving.net.cn/tea/1566891978028.jpg","state":null,"showOrder":null,"sellNum":null,"isNew":null,"unit":null,"transId":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"del":null,"isRecommend":null,"isCheck":null,"limitIntegral":null,"subhead":null,"remark":null,"weight":null,"count":null,"sendIntegral":null,"sendGrowth":null,"productPicture":null,"storeId":4,"isSift":null,"brandId":null,"mallStore":null,"sellCount":null,"cartId":null,"cartProductNum":null,"buyNum":null,"commission":null,"reSell":null,"ofCheap":null,"detailDescribe":null,"detailPic":null,"sendAddress":null,"categoryName":null,"basisService":null,"defaultTranCost":null,"num":null,"basicService":null,"productType":null,"transName":null,"priceType":null,"deliveryType":null,"defaultTransCost":null,"branName":null,"brandImg":null,"brandIsSpecial":null,"brandOrder":null,"brandAddress":null,"attributeId":null,"standardId":null,"userId":null,"collectionNum":null,"standard":null,"transportTemplate":null},{"id":6,"name":"黑茶","storeName":null,"categoryId":null,"keywords":null,"model":null,"virtualNum":null,"price":0.1,"marketPrice":0.1,"integral":null,"stock":null,"warningStock":null,"coverUrl":"http://oss.irving.net.cn/tea/1566892267942.jpg","state":null,"showOrder":null,"sellNum":null,"isNew":null,"unit":null,"transId":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"del":null,"isRecommend":null,"isCheck":null,"limitIntegral":null,"subhead":null,"remark":null,"weight":null,"count":null,"sendIntegral":null,"sendGrowth":null,"productPicture":null,"storeId":4,"isSift":null,"brandId":null,"mallStore":null,"sellCount":null,"cartId":null,"cartProductNum":null,"buyNum":null,"commission":null,"reSell":null,"ofCheap":null,"detailDescribe":null,"detailPic":null,"sendAddress":null,"categoryName":null,"basisService":null,"defaultTranCost":null,"num":null,"basicService":null,"productType":null,"transName":null,"priceType":null,"deliveryType":null,"defaultTransCost":null,"branName":null,"brandImg":null,"brandIsSpecial":null,"brandOrder":null,"brandAddress":null,"attributeId":null,"standardId":null,"userId":null,"collectionNum":null,"standard":null,"transportTemplate":null}],"isAttention":0},{"id":5,"userId":1,"storePicture":null,"storeLogo":null,"storeBoard":null,"storeName":"范正勇的店铺","storePhone":null,"storeType":"2","createTime":"2019-08-27T09:52:59.000+0000","updateTime":"2019-08-27T09:54:08.000+0000","info":null,"year":null,"favorableRate":0,"fensNum":null,"sellNum":null,"appraiseCategory":null,"productId":null,"coverUrl":null,"visitNum":null,"visitNumOfDay":null,"specialBrandInfo":null,"specialInstructions":null,"creditCard":null,"deliveryTime":null,"basicExpressFee":null,"freeAmountOfExpressFee":null,"status":null,"enterStore":null,"doorPhoto":null,"mallProductList":[],"isAttention":0},{"id":6,"userId":2,"storePicture":null,"storeLogo":null,"storeBoard":null,"storeName":"Drew","storePhone":null,"createTime":"2019-08-27T09:53:18.000+0000","updateTime":"2019-08-27T09:53:18.000+0000","info":null,"year":null,"favorableRate":0,"fensNum":null,"sellNum":null,"appraiseCategory":null,"productId":null,"coverUrl":null,"visitNum":null,"visitNumOfDay":null,"specialBrandInfo":null,"specialInstructions":null,"creditCard":null,"deliveryTime":null,"basicExpressFee":null,"freeAmountOfExpressFee":null,"status":null,"enterStore":null,"doorPhoto":null,"mallProductList":[],"isAttention":0}],"pageNum":1,"pageSize":10,"size":4,"startRow":1,"endRow":4,"pages":1,"prePage":0,"nextPage":0,"isFirstPage":true,"isLastPage":true,"hasPreviousPage":false,"hasNextPage":false,"navigatePages":8,"navigatepageNums":[1],"navigateFirstPage":1,"navigateLastPage":1}
         */

        private ResultListBean resultList;
        private List<IsSpecialBean> isSpecial;

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
                 * userId : 4
                 * storePicture : null
                 * storeLogo : null
                 * storeBoard : null
                 * storeName : 爱茶之人
                 * storePhone : null
                 * createTime : 2019-08-26T07:31:42.000+0000
                 * updateTime : 2019-08-26T07:32:34.000+0000
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
                 * doorPhoto : null
                 * mallProductList : [{"id":1,"name":"茶叶","storeName":null,"categoryId":null,"keywords":null,"model":null,"virtualNum":null,"price":1,"marketPrice":2,"integral":null,"stock":null,"warningStock":null,"coverUrl":"http://oss.irving.net.cn/tea/1566805533099.jpg","state":null,"showOrder":null,"sellNum":null,"isNew":null,"unit":null,"transId":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"del":null,"isRecommend":null,"isCheck":null,"limitIntegral":null,"subhead":null,"remark":null,"weight":null,"count":null,"sendIntegral":null,"sendGrowth":null,"productPicture":null,"storeId":1,"isSift":null,"brandId":null,"mallStore":null,"sellCount":null,"cartId":null,"cartProductNum":null,"buyNum":null,"commission":null,"reSell":null,"ofCheap":null,"detailDescribe":null,"detailPic":null,"sendAddress":null,"categoryName":null,"basisService":null,"defaultTranCost":null,"num":null,"basicService":null,"productType":null,"transName":null,"priceType":null,"deliveryType":null,"defaultTransCost":null,"branName":null,"brandImg":null,"brandIsSpecial":null,"brandOrder":null,"brandAddress":null,"attributeId":null,"standardId":null,"userId":null,"collectionNum":null,"standard":null,"transportTemplate":null},{"id":2,"name":"普洱","storeName":null,"categoryId":null,"keywords":null,"model":null,"virtualNum":null,"price":1,"marketPrice":2,"integral":null,"stock":null,"warningStock":null,"coverUrl":"http://oss.irving.net.cn/tea/1566805841566.jpg","state":null,"showOrder":null,"sellNum":null,"isNew":null,"unit":null,"transId":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"del":null,"isRecommend":null,"isCheck":null,"limitIntegral":null,"subhead":null,"remark":null,"weight":null,"count":null,"sendIntegral":null,"sendGrowth":null,"productPicture":null,"storeId":1,"isSift":null,"brandId":null,"mallStore":null,"sellCount":null,"cartId":null,"cartProductNum":null,"buyNum":null,"commission":null,"reSell":null,"ofCheap":null,"detailDescribe":null,"detailPic":null,"sendAddress":null,"categoryName":null,"basisService":null,"defaultTranCost":null,"num":null,"basicService":null,"productType":null,"transName":null,"priceType":null,"deliveryType":null,"defaultTransCost":null,"branName":null,"brandImg":null,"brandIsSpecial":null,"brandOrder":null,"brandAddress":null,"attributeId":null,"standardId":null,"userId":null,"collectionNum":null,"standard":null,"transportTemplate":null},{"id":3,"name":"绿茶","storeName":null,"categoryId":null,"keywords":null,"model":null,"virtualNum":null,"price":1,"marketPrice":1,"integral":null,"stock":null,"warningStock":null,"coverUrl":"http://oss.irving.net.cn/tea/1566809411961.jpg","state":null,"showOrder":null,"sellNum":null,"isNew":null,"unit":null,"transId":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"del":null,"isRecommend":null,"isCheck":null,"limitIntegral":null,"subhead":null,"remark":null,"weight":null,"count":null,"sendIntegral":null,"sendGrowth":null,"productPicture":null,"storeId":1,"isSift":null,"brandId":null,"mallStore":null,"sellCount":null,"cartId":null,"cartProductNum":null,"buyNum":null,"commission":null,"reSell":null,"ofCheap":null,"detailDescribe":null,"detailPic":null,"sendAddress":null,"categoryName":null,"basisService":null,"defaultTranCost":null,"num":null,"basicService":null,"productType":null,"transName":null,"priceType":null,"deliveryType":null,"defaultTransCost":null,"branName":null,"brandImg":null,"brandIsSpecial":null,"brandOrder":null,"brandAddress":null,"attributeId":null,"standardId":null,"userId":null,"collectionNum":null,"standard":null,"transportTemplate":null}]
                 * isAttention : 0
                 * storeType : 2
                 */

                private int id;
                private int userId;
                private Object storePicture;
                private Object storeLogo;
                private String storeBoard;
                private String storeName;
                private Object storePhone;
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
                private Object doorPhoto;
                private int isAttention;
                private String storeType;
                private List<MallProductListBean> mallProductList;

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

                public Object getStorePicture() {
                    return storePicture;
                }

                public void setStorePicture(Object storePicture) {
                    this.storePicture = storePicture;
                }

                public Object getStoreLogo() {
                    return storeLogo;
                }

                public void setStoreLogo(Object storeLogo) {
                    this.storeLogo = storeLogo;
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

                public Object getStorePhone() {
                    return storePhone;
                }

                public void setStorePhone(Object storePhone) {
                    this.storePhone = storePhone;
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

                public Object getDoorPhoto() {
                    return doorPhoto;
                }

                public void setDoorPhoto(Object doorPhoto) {
                    this.doorPhoto = doorPhoto;
                }

                public int getIsAttention() {
                    return isAttention;
                }

                public void setIsAttention(int isAttention) {
                    this.isAttention = isAttention;
                }

                public String getStoreType() {
                    return storeType;
                }

                public void setStoreType(String storeType) {
                    this.storeType = storeType;
                }

                public List<MallProductListBean> getMallProductList() {
                    return mallProductList;
                }

                public void setMallProductList(List<MallProductListBean> mallProductList) {
                    this.mallProductList = mallProductList;
                }

                public static class MallProductListBean {
                    /**
                     * id : 1
                     * name : 茶叶
                     * storeName : null
                     * categoryId : null
                     * keywords : null
                     * model : null
                     * virtualNum : null
                     * price : 1.0
                     * marketPrice : 2.0
                     * integral : null
                     * stock : null
                     * warningStock : null
                     * coverUrl : http://oss.irving.net.cn/tea/1566805533099.jpg
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
                     * storeId : 1
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
                     * basisService : null
                     * defaultTranCost : null
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
                    private double price;
                    private double marketPrice;
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
                    private Object basisService;
                    private Object defaultTranCost;
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

                    public double getPrice() {
                        return price;
                    }

                    public void setPrice(double price) {
                        this.price = price;
                    }

                    public double getMarketPrice() {
                        return marketPrice;
                    }

                    public void setMarketPrice(double marketPrice) {
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

                    public Object getBasisService() {
                        return basisService;
                    }

                    public void setBasisService(Object basisService) {
                        this.basisService = basisService;
                    }

                    public Object getDefaultTranCost() {
                        return defaultTranCost;
                    }

                    public void setDefaultTranCost(Object defaultTranCost) {
                        this.defaultTranCost = defaultTranCost;
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
             * id : 4
             * userId : 3
             * storePicture : null
             * storeLogo : null
             * storeBoard : null
             * storeName : 爱喝茶的人
             * storePhone : null
             * storeType : 2
             * createTime : 2019-08-26T08:37:09.000+0000
             * updateTime : 2019-08-27T08:11:31.000+0000
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
             * doorPhoto : http://oss.irving.net.cn/tea/1566808633243.jpg
             * mallProductList : null
             * isAttention : null
             */

            private int id;
            private int userId;
            private Object storePicture;
            private Object storeLogo;
            private Object storeBoard;
            private String storeName;
            private Object storePhone;
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
            private String doorPhoto;
            private Object mallProductList;
            private Object isAttention;

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

            public Object getStorePicture() {
                return storePicture;
            }

            public void setStorePicture(Object storePicture) {
                this.storePicture = storePicture;
            }

            public Object getStoreLogo() {
                return storeLogo;
            }

            public void setStoreLogo(Object storeLogo) {
                this.storeLogo = storeLogo;
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

            public Object getStorePhone() {
                return storePhone;
            }

            public void setStorePhone(Object storePhone) {
                this.storePhone = storePhone;
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

            public String getDoorPhoto() {
                return doorPhoto;
            }

            public void setDoorPhoto(String doorPhoto) {
                this.doorPhoto = doorPhoto;
            }

            public Object getMallProductList() {
                return mallProductList;
            }

            public void setMallProductList(Object mallProductList) {
                this.mallProductList = mallProductList;
            }

            public Object getIsAttention() {
                return isAttention;
            }

            public void setIsAttention(Object isAttention) {
                this.isAttention = isAttention;
            }
        }
    }
}
