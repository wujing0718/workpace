package com.huohougongfu.app.Gson;

import java.util.List;

public class ReturnDetails {


    /**
     * msg : 操作成功
     * result : [{"id":10,"refundNo":null,"createBy":2,"ocrId":1,"orderNo":"d201909102113145748542","productId":6,"standardId":91,"prodductNum":null,"refundMoney":0,"refundStatus":0,"type":2,"refundChannel":"余额","expressNo":"828282828","expressCompany":"STO","remark":"8282828282528","userId":2,"nickName":"Drew","picture":"http://oss.irving.net.cn/tea/1568121270491.jpeg","createTime":"2019-09-02T04:11:04.000+0000","createTime1":"2019-09-02 12:11:004","updateTime":null,"products":[{"id":6,"name":"黑茶","storeName":"爱喝茶的人","categoryId":22,"keywords":null,"model":"","virtualNum":-36,"price":0.1,"marketPrice":0.1,"integral":0,"stock":80,"warningStock":null,"coverUrl":"http://oss.irving.net.cn/tea/1566892267942.jpg","state":1,"showOrder":3,"sellNum":24,"isNew":0,"unit":"","transId":0,"createBy":3,"createTime":"2019-08-27T07:51:06.000+0000","updateBy":1,"updateTime":"2019-09-10T13:28:38.000+0000","del":0,"isRecommend":0,"isCheck":1,"limitIntegral":null,"subhead":"","remark":"","weight":null,"count":null,"sendIntegral":null,"sendGrowth":null,"productPicture":"http://oss.irving.net.cn/tea/1566892267942.jpg","storeId":4,"isSift":0,"brandId":null,"mallStore":null,"sellCount":null,"cartId":null,"cartProductNum":null,"buyNum":null,"commission":5,"reSell":null,"ofCheap":null,"detailDescribe":null,"detailPic":"http://oss.irving.net.cn/tea/1566892266793.jpg","sendAddress":"北京市","categoryName":null,"basisService":null,"defaultTranCost":null,"num":null,"basicService":null,"productType":null,"transName":null,"priceType":null,"deliveryType":null,"defaultTransCost":null,"branName":null,"brandImg":null,"brandIsSpecial":null,"brandOrder":null,"brandAddress":null,"attributeId":null,"standardId":null,"userId":null,"collectionNum":null,"standard":"50g","transportTemplate":null}],"reason":"不喜欢/不想要","phone":"15927484518","payChannel":0}]
     * status : 1
     */

    private String msg;
    private int status;
    private List<ResultBean> result;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public List<ResultBean> getResult() {
        return result;
    }

    public void setResult(List<ResultBean> result) {
        this.result = result;
    }

    public static class ResultBean {
        /**
         * id : 10
         * refundNo : null
         * createBy : 2
         * ocrId : 1
         * orderNo : d201909102113145748542
         * productId : 6
         * standardId : 91
         * prodductNum : null
         * refundMoney : 0.0
         * refundStatus : 0
         * type : 2
         * refundChannel : 余额
         * expressNo : 828282828
         * expressCompany : STO
         * remark : 8282828282528
         * userId : 2
         * nickName : Drew
         * picture : http://oss.irving.net.cn/tea/1568121270491.jpeg
         * createTime : 2019-09-02T04:11:04.000+0000
         * createTime1 : 2019-09-02 12:11:004
         * updateTime : null
         * products : [{"id":6,"name":"黑茶","storeName":"爱喝茶的人","categoryId":22,"keywords":null,"model":"","virtualNum":-36,"price":0.1,"marketPrice":0.1,"integral":0,"stock":80,"warningStock":null,"coverUrl":"http://oss.irving.net.cn/tea/1566892267942.jpg","state":1,"showOrder":3,"sellNum":24,"isNew":0,"unit":"","transId":0,"createBy":3,"createTime":"2019-08-27T07:51:06.000+0000","updateBy":1,"updateTime":"2019-09-10T13:28:38.000+0000","del":0,"isRecommend":0,"isCheck":1,"limitIntegral":null,"subhead":"","remark":"","weight":null,"count":null,"sendIntegral":null,"sendGrowth":null,"productPicture":"http://oss.irving.net.cn/tea/1566892267942.jpg","storeId":4,"isSift":0,"brandId":null,"mallStore":null,"sellCount":null,"cartId":null,"cartProductNum":null,"buyNum":null,"commission":5,"reSell":null,"ofCheap":null,"detailDescribe":null,"detailPic":"http://oss.irving.net.cn/tea/1566892266793.jpg","sendAddress":"北京市","categoryName":null,"basisService":null,"defaultTranCost":null,"num":null,"basicService":null,"productType":null,"transName":null,"priceType":null,"deliveryType":null,"defaultTransCost":null,"branName":null,"brandImg":null,"brandIsSpecial":null,"brandOrder":null,"brandAddress":null,"attributeId":null,"standardId":null,"userId":null,"collectionNum":null,"standard":"50g","transportTemplate":null}]
         * reason : 不喜欢/不想要
         * phone : 15927484518
         * payChannel : 0
         */

        private int id;
        private Object refundNo;
        private int createBy;
        private int ocrId;
        private String orderNo;
        private int productId;
        private int standardId;
        private int prodductNum;
        private double refundMoney;
        private int refundStatus;
        private int type;
        private String refundChannel;
        private String expressNo;
        private String expressCompany;
        private String remark;
        private int userId;
        private String nickName;
        private String picture;
        private String createTime;
        private String createTime1;
        private Object updateTime;
        private String reason;
        private String phone;
        private int payChannel;
        private List<ProductsBean> products;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public Object getRefundNo() {
            return refundNo;
        }

        public void setRefundNo(Object refundNo) {
            this.refundNo = refundNo;
        }

        public int getCreateBy() {
            return createBy;
        }

        public void setCreateBy(int createBy) {
            this.createBy = createBy;
        }

        public int getOcrId() {
            return ocrId;
        }

        public void setOcrId(int ocrId) {
            this.ocrId = ocrId;
        }

        public String getOrderNo() {
            return orderNo;
        }

        public void setOrderNo(String orderNo) {
            this.orderNo = orderNo;
        }

        public int getProductId() {
            return productId;
        }

        public void setProductId(int productId) {
            this.productId = productId;
        }

        public int getStandardId() {
            return standardId;
        }

        public void setStandardId(int standardId) {
            this.standardId = standardId;
        }

        public int getProdductNum() {
            return prodductNum;
        }

        public void setProdductNum(int prodductNum) {
            this.prodductNum = prodductNum;
        }

        public double getRefundMoney() {
            return refundMoney;
        }

        public void setRefundMoney(double refundMoney) {
            this.refundMoney = refundMoney;
        }

        public int getRefundStatus() {
            return refundStatus;
        }

        public void setRefundStatus(int refundStatus) {
            this.refundStatus = refundStatus;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public String getRefundChannel() {
            return refundChannel;
        }

        public void setRefundChannel(String refundChannel) {
            this.refundChannel = refundChannel;
        }

        public String getExpressNo() {
            return expressNo;
        }

        public void setExpressNo(String expressNo) {
            this.expressNo = expressNo;
        }

        public String getExpressCompany() {
            return expressCompany;
        }

        public void setExpressCompany(String expressCompany) {
            this.expressCompany = expressCompany;
        }

        public String getRemark() {
            return remark;
        }

        public void setRemark(String remark) {
            this.remark = remark;
        }

        public int getUserId() {
            return userId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }

        public String getNickName() {
            return nickName;
        }

        public void setNickName(String nickName) {
            this.nickName = nickName;
        }

        public String getPicture() {
            return picture;
        }

        public void setPicture(String picture) {
            this.picture = picture;
        }

        public String getCreateTime() {
            return createTime;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
        }

        public String getCreateTime1() {
            return createTime1;
        }

        public void setCreateTime1(String createTime1) {
            this.createTime1 = createTime1;
        }

        public Object getUpdateTime() {
            return updateTime;
        }

        public void setUpdateTime(Object updateTime) {
            this.updateTime = updateTime;
        }

        public String getReason() {
            return reason;
        }

        public void setReason(String reason) {
            this.reason = reason;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public int getPayChannel() {
            return payChannel;
        }

        public void setPayChannel(int payChannel) {
            this.payChannel = payChannel;
        }

        public List<ProductsBean> getProducts() {
            return products;
        }

        public void setProducts(List<ProductsBean> products) {
            this.products = products;
        }

        public static class ProductsBean {
            /**
             * id : 6
             * name : 黑茶
             * storeName : 爱喝茶的人
             * categoryId : 22
             * keywords : null
             * model :
             * virtualNum : -36
             * price : 0.1
             * marketPrice : 0.1
             * integral : 0
             * stock : 80
             * warningStock : null
             * coverUrl : http://oss.irving.net.cn/tea/1566892267942.jpg
             * state : 1
             * showOrder : 3
             * sellNum : 24
             * isNew : 0
             * unit :
             * transId : 0
             * createBy : 3
             * createTime : 2019-08-27T07:51:06.000+0000
             * updateBy : 1
             * updateTime : 2019-09-10T13:28:38.000+0000
             * del : 0
             * isRecommend : 0
             * isCheck : 1
             * limitIntegral : null
             * subhead :
             * remark :
             * weight : null
             * count : null
             * sendIntegral : null
             * sendGrowth : null
             * productPicture : http://oss.irving.net.cn/tea/1566892267942.jpg
             * storeId : 4
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
             * detailPic : http://oss.irving.net.cn/tea/1566892266793.jpg
             * sendAddress : 北京市
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
             * standard : 50g
             * transportTemplate : null
             */

            private int id;
            private String name;
            private String storeName;
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
            private int buyNum;
            private double commission;
            private Object reSell;
            private Object ofCheap;
            private Object detailDescribe;
            private String detailPic;
            private String sendAddress;
            private Object categoryName;
            private Object basisService;
            private Object defaultTranCost;
            private int num;
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
            private String standard;
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

            public int getBuyNum() {
                return buyNum;
            }

            public void setBuyNum(int buyNum) {
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

            public int getNum() {
                return num;
            }

            public void setNum(int num) {
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

            public String getStandard() {
                return standard;
            }

            public void setStandard(String standard) {
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
