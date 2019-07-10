package com.huohougongfu.app.Gson;

import java.util.List;

public class ShopDetail {

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
        private ProductDetailInfoBean productDetailInfo;
        private List<RecommendBean> recommend;

        public ProductDetailInfoBean getProductDetailInfo() {
            return productDetailInfo;
        }

        public void setProductDetailInfo(ProductDetailInfoBean productDetailInfo) {
            this.productDetailInfo = productDetailInfo;
        }

        public List<RecommendBean> getRecommend() {
            return recommend;
        }

        public void setRecommend(List<RecommendBean> recommend) {
            this.recommend = recommend;
        }

        public static class ProductDetailInfoBean {

            private double defaultTranCost;
            private int id;
            private String name;
            private int categoryId;
            private double price;
            private double marketPrice;
            private String coverUrl;
            private int sellNum;
            private int transId;
            private String remark;
            private String productPicture;
            private int storeId;
            private String storePicture;
            private String storeLogo;
            private String storeBoard;
            private String storeName;
            private String storeAddress;
            private String stock;

            public double getDefaultTranCost() {
                return defaultTranCost;
            }

            public void setDefaultTranCost(double defaultTranCost) {
                this.defaultTranCost = defaultTranCost;
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

            public int getCategoryId() {
                return categoryId;
            }

            public void setCategoryId(int categoryId) {
                this.categoryId = categoryId;
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

            public int getTransId() {
                return transId;
            }

            public void setTransId(int transId) {
                this.transId = transId;
            }

            public String getRemark() {
                return remark;
            }

            public void setRemark(String remark) {
                this.remark = remark;
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

            public String getStorePicture() {
                return storePicture;
            }

            public void setStorePicture(String storePicture) {
                this.storePicture = storePicture;
            }

            public String getStoreLogo() {
                return storeLogo;
            }

            public void setStoreLogo(String storeLogo) {
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

            public String getStoreAddress() {
                return storeAddress;
            }

            public void setStoreAddress(String storeAddress) {
                this.storeAddress = storeAddress;
            }

            public String getStock() {
                return stock;
            }

            public void setStock(String stock) {
                this.stock = stock;
            }
        }

        public static class RecommendBean {

            private int id;
            private String name;
            private Object categoryId;
            private Object keywords;
            private Object model;
            private Object virtualNum;
            private int price;
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
            private String remark;
            private Object weight;
            private Object count;
            private Object sendIntegral;
            private Object sendGrowth;
            private Object productPicture;
            private Object storeId;
            private Object isSift;
            private Object brandId;
            private Object mallStore;
            private Object sellCount;
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

            public Object getProductPicture() {
                return productPicture;
            }

            public void setProductPicture(Object productPicture) {
                this.productPicture = productPicture;
            }

            public Object getStoreId() {
                return storeId;
            }

            public void setStoreId(Object storeId) {
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
        }
    }
}
