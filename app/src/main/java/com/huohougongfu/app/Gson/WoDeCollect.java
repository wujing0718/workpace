package com.huohougongfu.app.Gson;

import java.util.List;

public class WoDeCollect {


    /**
     * msg : 操作成功
     * result : {"total":2,"list":[{"id":98,"name":"茶1","storeName":null,"categoryId":22,"keywords":null,"model":"","virtualNum":-46,"price":0.01,"marketPrice":1,"integral":0,"stock":100,"warningStock":null,"coverUrl":"http://oss.hotkungfu-tea.com/picture/1568269753737.jpeg","state":1,"showOrder":0,"sellNum":33,"isNew":0,"unit":"","transId":0,"createBy":90,"createTime":"2019-09-12T06:29:06.000+0000","updateBy":null,"updateTime":"2019-09-16T06:05:42.000+0000","del":0,"isRecommend":0,"isCheck":0,"limitIntegral":null,"subhead":"","remark":"","weight":null,"count":null,"sendIntegral":null,"sendGrowth":null,"productPicture":"http://oss.hotkungfu-tea.com/picture/1568269753737.jpeg,http://oss.hotkungfu-tea.com/picture/1568269751452.jpeg","storeId":66,"isSift":0,"brandId":null,"mallStore":null,"sellCount":null,"cartId":null,"cartProductNum":null,"buyNum":null,"commission":5,"reSell":null,"ofCheap":null,"detailDescribe":null,"detailPic":"http://oss.hotkungfu-tea.com/picture/1568269747887.jpeg,http://oss.hotkungfu-tea.com/picture/1568269750090.jpeg","earnProduct":0,"sendAddress":"天津市","categoryName":null,"basisService":null,"defaultTranCost":null,"num":null,"basicService":null,"productType":null,"transName":null,"priceType":null,"deliveryType":null,"defaultTransCost":null,"branName":null,"brandImg":null,"brandIsSpecial":null,"brandOrder":null,"brandAddress":null,"attributeId":null,"standardId":null,"userId":null,"collectionNum":1,"standard":null,"transportTemplate":null},{"id":106,"name":"绿豆糕","storeName":null,"categoryId":41,"keywords":null,"model":"","virtualNum":-3,"price":0.01,"marketPrice":0.02,"integral":0,"stock":500,"warningStock":null,"coverUrl":"http://oss.hotkungfu-tea.com/picture/1568281678331.jpeg","state":1,"showOrder":0,"sellNum":1,"isNew":0,"unit":"","transId":0,"createBy":93,"createTime":"2019-09-12T09:47:51.000+0000","updateBy":null,"updateTime":"2019-09-15T09:04:03.000+0000","del":0,"isRecommend":0,"isCheck":0,"limitIntegral":null,"subhead":"","remark":"","weight":null,"count":null,"sendIntegral":null,"sendGrowth":null,"productPicture":"http://oss.hotkungfu-tea.com/picture/1568281678331.jpeg","storeId":70,"isSift":0,"brandId":null,"mallStore":null,"sellCount":null,"cartId":null,"cartProductNum":null,"buyNum":null,"commission":0,"reSell":null,"ofCheap":null,"detailDescribe":null,"detailPic":"http://oss.hotkungfu-tea.com/picture/1568281673522.jpeg","earnProduct":0,"sendAddress":"揭阳市","categoryName":null,"basisService":null,"defaultTranCost":null,"num":null,"basicService":null,"productType":null,"transName":null,"priceType":null,"deliveryType":null,"defaultTransCost":null,"branName":null,"brandImg":null,"brandIsSpecial":null,"brandOrder":null,"brandAddress":null,"attributeId":null,"standardId":null,"userId":null,"collectionNum":1,"standard":null,"transportTemplate":null}],"pageNum":1,"pageSize":10,"size":2,"startRow":1,"endRow":2,"pages":1,"prePage":0,"nextPage":0,"isFirstPage":true,"isLastPage":true,"hasPreviousPage":false,"hasNextPage":false,"navigatePages":8,"navigatepageNums":[1],"navigateFirstPage":1,"navigateLastPage":1}
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
         * total : 2
         * list : [{"id":98,"name":"茶1","storeName":null,"categoryId":22,"keywords":null,"model":"","virtualNum":-46,"price":0.01,"marketPrice":1,"integral":0,"stock":100,"warningStock":null,"coverUrl":"http://oss.hotkungfu-tea.com/picture/1568269753737.jpeg","state":1,"showOrder":0,"sellNum":33,"isNew":0,"unit":"","transId":0,"createBy":90,"createTime":"2019-09-12T06:29:06.000+0000","updateBy":null,"updateTime":"2019-09-16T06:05:42.000+0000","del":0,"isRecommend":0,"isCheck":0,"limitIntegral":null,"subhead":"","remark":"","weight":null,"count":null,"sendIntegral":null,"sendGrowth":null,"productPicture":"http://oss.hotkungfu-tea.com/picture/1568269753737.jpeg,http://oss.hotkungfu-tea.com/picture/1568269751452.jpeg","storeId":66,"isSift":0,"brandId":null,"mallStore":null,"sellCount":null,"cartId":null,"cartProductNum":null,"buyNum":null,"commission":5,"reSell":null,"ofCheap":null,"detailDescribe":null,"detailPic":"http://oss.hotkungfu-tea.com/picture/1568269747887.jpeg,http://oss.hotkungfu-tea.com/picture/1568269750090.jpeg","earnProduct":0,"sendAddress":"天津市","categoryName":null,"basisService":null,"defaultTranCost":null,"num":null,"basicService":null,"productType":null,"transName":null,"priceType":null,"deliveryType":null,"defaultTransCost":null,"branName":null,"brandImg":null,"brandIsSpecial":null,"brandOrder":null,"brandAddress":null,"attributeId":null,"standardId":null,"userId":null,"collectionNum":1,"standard":null,"transportTemplate":null},{"id":106,"name":"绿豆糕","storeName":null,"categoryId":41,"keywords":null,"model":"","virtualNum":-3,"price":0.01,"marketPrice":0.02,"integral":0,"stock":500,"warningStock":null,"coverUrl":"http://oss.hotkungfu-tea.com/picture/1568281678331.jpeg","state":1,"showOrder":0,"sellNum":1,"isNew":0,"unit":"","transId":0,"createBy":93,"createTime":"2019-09-12T09:47:51.000+0000","updateBy":null,"updateTime":"2019-09-15T09:04:03.000+0000","del":0,"isRecommend":0,"isCheck":0,"limitIntegral":null,"subhead":"","remark":"","weight":null,"count":null,"sendIntegral":null,"sendGrowth":null,"productPicture":"http://oss.hotkungfu-tea.com/picture/1568281678331.jpeg","storeId":70,"isSift":0,"brandId":null,"mallStore":null,"sellCount":null,"cartId":null,"cartProductNum":null,"buyNum":null,"commission":0,"reSell":null,"ofCheap":null,"detailDescribe":null,"detailPic":"http://oss.hotkungfu-tea.com/picture/1568281673522.jpeg","earnProduct":0,"sendAddress":"揭阳市","categoryName":null,"basisService":null,"defaultTranCost":null,"num":null,"basicService":null,"productType":null,"transName":null,"priceType":null,"deliveryType":null,"defaultTransCost":null,"branName":null,"brandImg":null,"brandIsSpecial":null,"brandOrder":null,"brandAddress":null,"attributeId":null,"standardId":null,"userId":null,"collectionNum":1,"standard":null,"transportTemplate":null}]
         * pageNum : 1
         * pageSize : 10
         * size : 2
         * startRow : 1
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
             * id : 98
             * name : 茶1
             * storeName : null
             * categoryId : 22
             * keywords : null
             * model :
             * virtualNum : -46
             * price : 0.01
             * marketPrice : 1.0
             * integral : 0
             * stock : 100
             * warningStock : null
             * coverUrl : http://oss.hotkungfu-tea.com/picture/1568269753737.jpeg
             * state : 1
             * showOrder : 0
             * sellNum : 33
             * isNew : 0
             * unit :
             * transId : 0
             * createBy : 90
             * createTime : 2019-09-12T06:29:06.000+0000
             * updateBy : null
             * updateTime : 2019-09-16T06:05:42.000+0000
             * del : 0
             * isRecommend : 0
             * isCheck : 0
             * limitIntegral : null
             * subhead :
             * remark :
             * weight : null
             * count : null
             * sendIntegral : null
             * sendGrowth : null
             * productPicture : http://oss.hotkungfu-tea.com/picture/1568269753737.jpeg,http://oss.hotkungfu-tea.com/picture/1568269751452.jpeg
             * storeId : 66
             * isSift : 0
             * brandId : null
             * mallStore : null
             * sellCount : null
             * cartId : null
             * cartProductNum : null
             * buyNum : null
             * commission : 5.0
             * reSell : null
             * ofCheap : null
             * detailDescribe : null
             * detailPic : http://oss.hotkungfu-tea.com/picture/1568269747887.jpeg,http://oss.hotkungfu-tea.com/picture/1568269750090.jpeg
             * earnProduct : 0
             * sendAddress : 天津市
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
             * collectionNum : 1
             * standard : null
             * transportTemplate : null
             */

            private int id;
            private String name;
            private Object storeName;
            private int categoryId;
            private Object keywords;
            private String model;
            private int virtualNum;
            private double price;
            private double marketPrice;
            private int integral;
            private int stock;
            private Object warningStock;
            private String coverUrl;
            private int state;
            private boolean isSelect;
            private int showOrder;
            private int sellNum;
            private int isNew;
            private String unit;
            private int transId;
            private int createBy;
            private String createTime;
            private Object updateBy;
            private String updateTime;
            private int del;
            private int isRecommend;
            private int isCheck;
            private Object limitIntegral;
            private String subhead;
            private String remark;
            private Object weight;
            private Object count;
            private Object sendIntegral;
            private Object sendGrowth;
            private String productPicture;
            private int storeId;
            private int isSift;
            private Object brandId;
            private Object mallStore;
            private Object sellCount;
            private Object cartId;
            private Object cartProductNum;
            private Object buyNum;
            private double commission;
            private Object reSell;
            private Object ofCheap;
            private Object detailDescribe;
            private String detailPic;
            private int earnProduct;
            private String sendAddress;
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
            private int collectionNum;
            private Object standard;
            private Object transportTemplate;

            public boolean getIsSelect() {
                return isSelect;
            }

            public void setIsSelect(boolean isSelect) {
                this.isSelect = isSelect;
            }

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

            public int getCategoryId() {
                return categoryId;
            }

            public void setCategoryId(int categoryId) {
                this.categoryId = categoryId;
            }

            public Object getKeywords() {
                return keywords;
            }

            public void setKeywords(Object keywords) {
                this.keywords = keywords;
            }

            public String getModel() {
                return model;
            }

            public void setModel(String model) {
                this.model = model;
            }

            public int getVirtualNum() {
                return virtualNum;
            }

            public void setVirtualNum(int virtualNum) {
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

            public int getIntegral() {
                return integral;
            }

            public void setIntegral(int integral) {
                this.integral = integral;
            }

            public int getStock() {
                return stock;
            }

            public void setStock(int stock) {
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

            public int getState() {
                return state;
            }

            public void setState(int state) {
                this.state = state;
            }

            public int getShowOrder() {
                return showOrder;
            }

            public void setShowOrder(int showOrder) {
                this.showOrder = showOrder;
            }

            public int getSellNum() {
                return sellNum;
            }

            public void setSellNum(int sellNum) {
                this.sellNum = sellNum;
            }

            public int getIsNew() {
                return isNew;
            }

            public void setIsNew(int isNew) {
                this.isNew = isNew;
            }

            public String getUnit() {
                return unit;
            }

            public void setUnit(String unit) {
                this.unit = unit;
            }

            public int getTransId() {
                return transId;
            }

            public void setTransId(int transId) {
                this.transId = transId;
            }

            public int getCreateBy() {
                return createBy;
            }

            public void setCreateBy(int createBy) {
                this.createBy = createBy;
            }

            public String getCreateTime() {
                return createTime;
            }

            public void setCreateTime(String createTime) {
                this.createTime = createTime;
            }

            public Object getUpdateBy() {
                return updateBy;
            }

            public void setUpdateBy(Object updateBy) {
                this.updateBy = updateBy;
            }

            public String getUpdateTime() {
                return updateTime;
            }

            public void setUpdateTime(String updateTime) {
                this.updateTime = updateTime;
            }

            public int getDel() {
                return del;
            }

            public void setDel(int del) {
                this.del = del;
            }

            public int getIsRecommend() {
                return isRecommend;
            }

            public void setIsRecommend(int isRecommend) {
                this.isRecommend = isRecommend;
            }

            public int getIsCheck() {
                return isCheck;
            }

            public void setIsCheck(int isCheck) {
                this.isCheck = isCheck;
            }

            public Object getLimitIntegral() {
                return limitIntegral;
            }

            public void setLimitIntegral(Object limitIntegral) {
                this.limitIntegral = limitIntegral;
            }

            public String getSubhead() {
                return subhead;
            }

            public void setSubhead(String subhead) {
                this.subhead = subhead;
            }

            public String getRemark() {
                return remark;
            }

            public void setRemark(String remark) {
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

            public String getProductPicture() {
                return productPicture;
            }

            public void setProductPicture(String productPicture) {
                this.productPicture = productPicture;
            }

            public int getStoreId() {
                return storeId;
            }

            public void setStoreId(int storeId) {
                this.storeId = storeId;
            }

            public int getIsSift() {
                return isSift;
            }

            public void setIsSift(int isSift) {
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

            public double getCommission() {
                return commission;
            }

            public void setCommission(double commission) {
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

            public String getDetailPic() {
                return detailPic;
            }

            public void setDetailPic(String detailPic) {
                this.detailPic = detailPic;
            }

            public int getEarnProduct() {
                return earnProduct;
            }

            public void setEarnProduct(int earnProduct) {
                this.earnProduct = earnProduct;
            }

            public String getSendAddress() {
                return sendAddress;
            }

            public void setSendAddress(String sendAddress) {
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

            public int getCollectionNum() {
                return collectionNum;
            }

            public void setCollectionNum(int collectionNum) {
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
