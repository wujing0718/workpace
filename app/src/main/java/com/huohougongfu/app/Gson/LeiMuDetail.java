package com.huohougongfu.app.Gson;

import java.util.List;

public class LeiMuDetail {

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
         * list : [{"id":28,"name":"白茶23","storeName":"测试店铺","categoryId":2,"keywords":"白茶23","model":"1","virtualNum":2,"price":3,"marketPrice":42,"integral":24,"stock":12,"warningStock":212,"coverUrl":"1212","state":1,"showOrder":12,"sellNum":15,"isNew":0,"unit":"1","transId":6,"createBy":1,"createTime":"2019-06-05T08:20:51.000+0000","updateBy":1,"updateTime":"2019-07-26T01:20:36.000+0000","del":0,"isRecommend":1,"isCheck":1,"limitIntegral":2020,"subhead":"202","remark":"阿斯顿发失地发生地方","weight":2,"count":2,"sendIntegral":2,"sendGrowth":2,"productPicture":"http://pic34.nipic.com/20131020/6704106_203943375000_2.jpg,http://pic13.nipic.com/20110409/7119492_114440620000_2.jpg,http://pic13.nipic.com/20110409/7119492_114440620000_2.jpg,http://pic13.nipic.com/20110409/7119492_114440620000_2.jpg","storeId":1,"isSift":1,"brandId":2,"mallStore":null,"sellCount":null,"cartId":null,"num":null,"basicService":null,"productType":1,"transName":null,"priceType":null,"deliveryType":null,"defaultTransCost":null,"branName":null,"brandImg":null,"brandIsSpecial":null,"brandOrder":null,"brandAddress":null,"attributeId":null,"standardId":null,"userId":null,"collectionNum":null,"standard":null,"transportTemplate":null},{"id":29,"name":"白茶24","storeName":"测试店铺","categoryId":1,"keywords":"白茶24","model":"1","virtualNum":2,"price":111,"marketPrice":42,"integral":24,"stock":12,"warningStock":212,"coverUrl":"1212","state":1,"showOrder":1215,"sellNum":36,"isNew":1,"unit":"1","transId":6,"createBy":1,"createTime":"2019-06-05T08:20:53.000+0000","updateBy":1,"updateTime":"2019-07-26T01:20:38.000+0000","del":0,"isRecommend":1,"isCheck":1,"limitIntegral":2020,"subhead":"202","remark":"阿斯顿发失地发生地方","weight":2,"count":2,"sendIntegral":2,"sendGrowth":2,"productPicture":"http://pic34.nipic.com/20131020/6704106_203943375000_2.jpg,http://pic13.nipic.com/20110409/7119492_114440620000_2.jpg,http://pic13.nipic.com/20110409/7119492_114440620000_2.jpg,http://pic13.nipic.com/20110409/7119492_114440620000_2.jpg","storeId":1,"isSift":1,"brandId":2,"mallStore":null,"sellCount":null,"cartId":null,"num":null,"basicService":null,"productType":1,"transName":null,"priceType":null,"deliveryType":null,"defaultTransCost":null,"branName":null,"brandImg":null,"brandIsSpecial":null,"brandOrder":null,"brandAddress":null,"attributeId":null,"standardId":null,"userId":null,"collectionNum":null,"standard":null,"transportTemplate":null},{"id":31,"name":"白茶2","storeName":"店铺名称","categoryId":2,"keywords":"白茶","model":"1","virtualNum":2,"price":75,"marketPrice":42,"integral":24,"stock":12,"warningStock":212,"coverUrl":"1212","state":1,"showOrder":12,"sellNum":12,"isNew":0,"unit":"1","transId":6,"createBy":1,"createTime":"2019-06-05T08:20:56.000+0000","updateBy":1,"updateTime":"2019-07-26T01:20:41.000+0000","del":0,"isRecommend":1,"isCheck":1,"limitIntegral":2020,"subhead":"202","remark":"阿斯顿发失地发生地方","weight":2,"count":2,"sendIntegral":2,"sendGrowth":2,"productPicture":"http://pic34.nipic.com/20131020/6704106_203943375000_2.jpg,http://pic13.nipic.com/20110409/7119492_114440620000_2.jpg,http://pic13.nipic.com/20110409/7119492_114440620000_2.jpg,http://pic13.nipic.com/20110409/7119492_114440620000_2.jpg","storeId":4,"isSift":0,"brandId":2,"mallStore":null,"sellCount":null,"cartId":null,"num":null,"basicService":null,"productType":1,"transName":null,"priceType":null,"deliveryType":null,"defaultTransCost":null,"branName":null,"brandImg":null,"brandIsSpecial":null,"brandOrder":null,"brandAddress":null,"attributeId":null,"standardId":null,"userId":null,"collectionNum":null,"standard":null,"transportTemplate":null},{"id":33,"name":"白茶","storeName":"测试店铺3","categoryId":2,"keywords":"测试","model":"1","virtualNum":2,"price":66,"marketPrice":42,"integral":24,"stock":12,"warningStock":212,"coverUrl":"1212","state":1,"showOrder":12,"sellNum":12,"isNew":1,"unit":"1","transId":5,"createBy":1,"createTime":"2019-06-05T08:20:58.000+0000","updateBy":1,"updateTime":"2019-07-26T01:20:46.000+0000","del":0,"isRecommend":1,"isCheck":1,"limitIntegral":2020,"subhead":"202","remark":"阿斯顿发失地发生地方","weight":2,"count":2,"sendIntegral":2,"sendGrowth":2,"productPicture":"http://pic34.nipic.com/20131020/6704106_203943375000_2.jpg,http://pic13.nipic.com/20110409/7119492_114440620000_2.jpg,http://pic13.nipic.com/20110409/7119492_114440620000_2.jpg,http://pic13.nipic.com/20110409/7119492_114440620000_2.jpg","storeId":3,"isSift":0,"brandId":2,"mallStore":null,"sellCount":null,"cartId":null,"num":null,"basicService":null,"productType":0,"transName":null,"priceType":null,"deliveryType":null,"defaultTransCost":null,"branName":null,"brandImg":null,"brandIsSpecial":null,"brandOrder":null,"brandAddress":null,"attributeId":null,"standardId":null,"userId":null,"collectionNum":null,"standard":null,"transportTemplate":null}]
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
             * id : 28
             * name : 白茶23
             * storeName : 测试店铺
             * categoryId : 2
             * keywords : 白茶23
             * model : 1
             * virtualNum : 2
             * price : 3.0
             * marketPrice : 42.0
             * integral : 24
             * stock : 12
             * warningStock : 212
             * coverUrl : 1212
             * state : 1
             * showOrder : 12
             * sellNum : 15
             * isNew : 0
             * unit : 1
             * transId : 6
             * createBy : 1
             * createTime : 2019-06-05T08:20:51.000+0000
             * updateBy : 1
             * updateTime : 2019-07-26T01:20:36.000+0000
             * del : 0
             * isRecommend : 1
             * isCheck : 1
             * limitIntegral : 2020.0
             * subhead : 202
             * remark : 阿斯顿发失地发生地方
             * weight : 2.0
             * count : 2
             * sendIntegral : 2.0
             * sendGrowth : 2.0
             * productPicture : http://pic34.nipic.com/20131020/6704106_203943375000_2.jpg,http://pic13.nipic.com/20110409/7119492_114440620000_2.jpg,http://pic13.nipic.com/20110409/7119492_114440620000_2.jpg,http://pic13.nipic.com/20110409/7119492_114440620000_2.jpg
             * storeId : 1
             * isSift : 1
             * brandId : 2
             * mallStore : null
             * sellCount : null
             * cartId : null
             * num : null
             * basicService : null
             * productType : 1
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
            private String storeName;
            private int categoryId;
            private String keywords;
            private String model;
            private int virtualNum;
            private double price;
            private double marketPrice;
            private int integral;
            private int stock;
            private int warningStock;
            private String coverUrl;
            private int state;
            private int showOrder;
            private int sellNum;
            private int isNew;
            private String unit;
            private int transId;
            private int createBy;
            private String createTime;
            private int updateBy;
            private String updateTime;
            private int del;
            private int isRecommend;
            private int isCheck;
            private double limitIntegral;
            private String subhead;
            private String remark;
            private double weight;
            private int count;
            private double sendIntegral;
            private double sendGrowth;
            private String productPicture;
            private int storeId;
            private int isSift;
            private int brandId;
            private Object mallStore;
            private Object sellCount;
            private Object cartId;
            private Object num;
            private Object basicService;
            private int productType;
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

            public String getStoreName() {
                return storeName;
            }

            public void setStoreName(String storeName) {
                this.storeName = storeName;
            }

            public int getCategoryId() {
                return categoryId;
            }

            public void setCategoryId(int categoryId) {
                this.categoryId = categoryId;
            }

            public String getKeywords() {
                return keywords;
            }

            public void setKeywords(String keywords) {
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

            public int getWarningStock() {
                return warningStock;
            }

            public void setWarningStock(int warningStock) {
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

            public int getUpdateBy() {
                return updateBy;
            }

            public void setUpdateBy(int updateBy) {
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

            public double getLimitIntegral() {
                return limitIntegral;
            }

            public void setLimitIntegral(double limitIntegral) {
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

            public double getWeight() {
                return weight;
            }

            public void setWeight(double weight) {
                this.weight = weight;
            }

            public int getCount() {
                return count;
            }

            public void setCount(int count) {
                this.count = count;
            }

            public double getSendIntegral() {
                return sendIntegral;
            }

            public void setSendIntegral(double sendIntegral) {
                this.sendIntegral = sendIntegral;
            }

            public double getSendGrowth() {
                return sendGrowth;
            }

            public void setSendGrowth(double sendGrowth) {
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

            public int getBrandId() {
                return brandId;
            }

            public void setBrandId(int brandId) {
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

            public int getProductType() {
                return productType;
            }

            public void setProductType(int productType) {
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
