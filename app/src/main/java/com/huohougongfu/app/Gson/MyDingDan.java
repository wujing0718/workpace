package com.huohougongfu.app.Gson;

import java.util.List;

public class MyDingDan {

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

        private Object id;
        private String orderNo;
        private int orderStatus;
        private int productId;
        private int productNum;
        private int productTotalNum;
        private double productAmountTotal;
        private double orderAmountTotal;
        private double logisticsFee;
        private int integral;
        private int payChannel;
        private String outTradeNo;
        private String escrowTradeNo;
        private String payTime;
        private int delayReceiveDay;
        private int createBy;
        private String createTime;
        private int updateBy;
        private String updateTime;
        private double invoiceMoney;
        private int standardId;
        private Object standard;
        private Object cancelTime;
        private Object remark;
        private String status;
        private MallStoresBean mallStores;
        private Object ocrId;
        private Object mallProducts;
        private Object name;
        private Object coverUrl;
        private Object storeId;

        public Object getId() {
            return id;
        }

        public void setId(Object id) {
            this.id = id;
        }

        public String getOrderNo() {
            return orderNo;
        }

        public void setOrderNo(String orderNo) {
            this.orderNo = orderNo;
        }

        public int getOrderStatus() {
            return orderStatus;
        }

        public void setOrderStatus(int orderStatus) {
            this.orderStatus = orderStatus;
        }

        public int getProductId() {
            return productId;
        }

        public void setProductId(int productId) {
            this.productId = productId;
        }

        public int getProductNum() {
            return productNum;
        }

        public void setProductNum(int productNum) {
            this.productNum = productNum;
        }

        public double getProductAmountTotal() {
            return productAmountTotal;
        }

        public void setProductAmountTotal(double productAmountTotal) {
            this.productAmountTotal = productAmountTotal;
        }

        public double getOrderAmountTotal() {
            return orderAmountTotal;
        }

        public void setOrderAmountTotal(double orderAmountTotal) {
            this.orderAmountTotal = orderAmountTotal;
        }

        public double getLogisticsFee() {
            return logisticsFee;
        }

        public void setLogisticsFee(double logisticsFee) {
            this.logisticsFee = logisticsFee;
        }

        public int getIntegral() {
            return integral;
        }

        public void setIntegral(int integral) {
            this.integral = integral;
        }

        public int getPayChannel() {
            return payChannel;
        }

        public void setPayChannel(int payChannel) {
            this.payChannel = payChannel;
        }

        public String getOutTradeNo() {
            return outTradeNo;
        }

        public void setOutTradeNo(String outTradeNo) {
            this.outTradeNo = outTradeNo;
        }

        public String getEscrowTradeNo() {
            return escrowTradeNo;
        }

        public void setEscrowTradeNo(String escrowTradeNo) {
            this.escrowTradeNo = escrowTradeNo;
        }

        public String getPayTime() {
            return payTime;
        }

        public void setPayTime(String payTime) {
            this.payTime = payTime;
        }

        public int getDelayReceiveDay() {
            return delayReceiveDay;
        }

        public void setDelayReceiveDay(int delayReceiveDay) {
            this.delayReceiveDay = delayReceiveDay;
        }

        public int getProductTotalNum() {
            return productTotalNum;
        }

        public void setProductTotalNum(int delayReceiveDay) {
            this.productTotalNum = productTotalNum;
        }

        public int getCreateBy() {
            return productTotalNum;
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

        public double getInvoiceMoney() {
            return invoiceMoney;
        }

        public void setInvoiceMoney(double invoiceMoney) {
            this.invoiceMoney = invoiceMoney;
        }

        public int getStandardId() {
            return standardId;
        }

        public void setStandardId(int standardId) {
            this.standardId = standardId;
        }

        public Object getStandard() {
            return standard;
        }

        public void setStandard(Object standard) {
            this.standard = standard;
        }

        public Object getCancelTime() {
            return cancelTime;
        }

        public void setCancelTime(Object cancelTime) {
            this.cancelTime = cancelTime;
        }

        public Object getRemark() {
            return remark;
        }

        public void setRemark(Object remark) {
            this.remark = remark;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public MallStoresBean getMallStores() {
            return mallStores;
        }

        public void setMallStores(MallStoresBean mallStores) {
            this.mallStores = mallStores;
        }

        public Object getOcrId() {
            return ocrId;
        }

        public void setOcrId(Object ocrId) {
            this.ocrId = ocrId;
        }

        public Object getMallProducts() {
            return mallProducts;
        }

        public void setMallProducts(Object mallProducts) {
            this.mallProducts = mallProducts;
        }

        public Object getName() {
            return name;
        }

        public void setName(Object name) {
            this.name = name;
        }

        public Object getCoverUrl() {
            return coverUrl;
        }

        public void setCoverUrl(Object coverUrl) {
            this.coverUrl = coverUrl;
        }

        public Object getStoreId() {
            return storeId;
        }

        public void setStoreId(Object storeId) {
            this.storeId = storeId;
        }

        public static class MallStoresBean {

            private int id;
            private String storeLogo;
            private String storeName;
            private Object info;
            private Object year;
            private Object favorableRate;
            private Object fensNum;
            private Object sellNum;
            private Object appraiseCategory;
            private Object productId;
            private Object coverUrl;
            private Object visitNum;
            private Object visitNumOfDay;
            private Object serviceRegulations;
            private Object ccoverUrl;
            private List<MallProductsBean> mallProducts;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getStoreLogo() {
                return storeLogo;
            }

            public void setStoreLogo(String storeLogo) {
                this.storeLogo = storeLogo;
            }

            public String getStoreName() {
                return storeName;
            }

            public void setStoreName(String storeName) {
                this.storeName = storeName;
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

            public Object getFavorableRate() {
                return favorableRate;
            }

            public void setFavorableRate(Object favorableRate) {
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

            public Object getServiceRegulations() {
                return serviceRegulations;
            }

            public void setServiceRegulations(Object serviceRegulations) {
                this.serviceRegulations = serviceRegulations;
            }

            public Object getCcoverUrl() {
                return ccoverUrl;
            }

            public void setCcoverUrl(Object ccoverUrl) {
                this.ccoverUrl = ccoverUrl;
            }

            public List<MallProductsBean> getMallProducts() {
                return mallProducts;
            }

            public void setMallProducts(List<MallProductsBean> mallProducts) {
                this.mallProducts = mallProducts;
            }

            public static class MallProductsBean {

                private int id;
                private String name;
                private Object storeName;
                private Object categoryId;
                private Object keywords;
                private Object model;
                private Object virtualNum;
                private double price;
                private Object marketPrice;
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
                private Object storeId;
                private Object isSift;
                private Object brandId;
                private Object mallStore;
                private Object sellCount;
                private Object cartId;
                private Object cartProductNum;
                private Object buyNum;
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

                public Object getMarketPrice() {
                    return marketPrice;
                }

                public void setMarketPrice(Object marketPrice) {
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
}
