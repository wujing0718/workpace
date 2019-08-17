package com.huohougongfu.app.Gson;

import java.io.Serializable;
import java.util.List;

public class ShopDingDan implements Serializable {

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

    public static class ResultBean implements Serializable{

        private double teaRice;
        private DefaultAddressBean defaultAddress;
        private List<OrderListBean> orderList;

        public double getTeaRice() {
            return teaRice;
        }

        public void setTeaRice(double teaRice) {
            this.teaRice = teaRice;
        }

        public DefaultAddressBean getDefaultAddress() {
            return defaultAddress;
        }

        public void setDefaultAddress(DefaultAddressBean defaultAddress) {
            this.defaultAddress = defaultAddress;
        }

        public List<OrderListBean> getOrderList() {
            return orderList;
        }

        public void setOrderList(List<OrderListBean> orderList) {
            this.orderList = orderList;
        }

        public static class DefaultAddressBean implements Serializable{

            private int id;
            private Object provinceId;
            private String provinceName;
            private Object cityId;
            private String cityName;
            private Object areaId;
            private String areaName;
            private String detailAddr;
            private String receiverName;
            private String phone;
            private int isDefault;
            private Object createBy;
            private Object createTime;
            private Object updateBy;
            private Object updateTime;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public Object getProvinceId() {
                return provinceId;
            }

            public void setProvinceId(Object provinceId) {
                this.provinceId = provinceId;
            }

            public String getProvinceName() {
                return provinceName;
            }

            public void setProvinceName(String provinceName) {
                this.provinceName = provinceName;
            }

            public Object getCityId() {
                return cityId;
            }

            public void setCityId(Object cityId) {
                this.cityId = cityId;
            }

            public String getCityName() {
                return cityName;
            }

            public void setCityName(String cityName) {
                this.cityName = cityName;
            }

            public Object getAreaId() {
                return areaId;
            }

            public void setAreaId(Object areaId) {
                this.areaId = areaId;
            }

            public String getAreaName() {
                return areaName;
            }

            public void setAreaName(String areaName) {
                this.areaName = areaName;
            }

            public String getDetailAddr() {
                return detailAddr;
            }

            public void setDetailAddr(String detailAddr) {
                this.detailAddr = detailAddr;
            }

            public String getReceiverName() {
                return receiverName;
            }

            public void setReceiverName(String receiverName) {
                this.receiverName = receiverName;
            }

            public String getPhone() {
                return phone;
            }

            public void setPhone(String phone) {
                this.phone = phone;
            }

            public int getIsDefault() {
                return isDefault;
            }

            public void setIsDefault(int isDefault) {
                this.isDefault = isDefault;
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
        }

        public static class OrderListBean implements Serializable{

            private Object id;
            private String orderId;
            private Object attrFirstId;
            private Object attrSecondId;
            private String standard;
            private int productId;
            private int storeId;
            private double productPrice;
            private Object productDiscountPrice;
            private Object discount;
            private String productName;
            private String productPicUrl;
            private Object productSkuData;
            private int productNum;
            private Object subtotal;
            private int integral;
            private int createBy;
            private String createTime;
            private Object updateBy;
            private Object updateTime;
            private int payStatus;
            private Object delayReceiveDay;
            private Object escrowTradeNo;
            private Object outTradeNo;
            private Object payChannel;
            private Object payTime;
            private MallStoreBean mallStore;
            private Object total;
            private Object cartId;
            private Object standardId;
            private Object couponsId;
            private Object couponId;

            public Object getId() {
                return id;
            }

            public void setId(Object id) {
                this.id = id;
            }

            public String getOrderId() {
                return orderId;
            }

            public void setOrderId(String orderId) {
                this.orderId = orderId;
            }

            public Object getAttrFirstId() {
                return attrFirstId;
            }

            public void setAttrFirstId(Object attrFirstId) {
                this.attrFirstId = attrFirstId;
            }

            public Object getAttrSecondId() {
                return attrSecondId;
            }

            public void setAttrSecondId(Object attrSecondId) {
                this.attrSecondId = attrSecondId;
            }

            public String getStandard() {
                return standard;
            }

            public void setStandard(String standard) {
                this.standard = standard;
            }

            public int getProductId() {
                return productId;
            }

            public void setProductId(int productId) {
                this.productId = productId;
            }

            public int getStoreId() {
                return storeId;
            }

            public void setStoreId(int storeId) {
                this.storeId = storeId;
            }

            public double getProductPrice() {
                return productPrice;
            }

            public void setProductPrice(double productPrice) {
                this.productPrice = productPrice;
            }

            public Object getProductDiscountPrice() {
                return productDiscountPrice;
            }

            public void setProductDiscountPrice(Object productDiscountPrice) {
                this.productDiscountPrice = productDiscountPrice;
            }

            public Object getDiscount() {
                return discount;
            }

            public void setDiscount(Object discount) {
                this.discount = discount;
            }

            public String getProductName() {
                return productName;
            }

            public void setProductName(String productName) {
                this.productName = productName;
            }

            public String getProductPicUrl() {
                return productPicUrl;
            }

            public void setProductPicUrl(String productPicUrl) {
                this.productPicUrl = productPicUrl;
            }

            public Object getProductSkuData() {
                return productSkuData;
            }

            public void setProductSkuData(Object productSkuData) {
                this.productSkuData = productSkuData;
            }

            public int getProductNum() {
                return productNum;
            }

            public void setProductNum(int productNum) {
                this.productNum = productNum;
            }

            public Object getSubtotal() {
                return subtotal;
            }

            public void setSubtotal(Object subtotal) {
                this.subtotal = subtotal;
            }

            public int getIntegral() {
                return integral;
            }

            public void setIntegral(int integral) {
                this.integral = integral;
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

            public Object getUpdateTime() {
                return updateTime;
            }

            public void setUpdateTime(Object updateTime) {
                this.updateTime = updateTime;
            }

            public int getPayStatus() {
                return payStatus;
            }

            public void setPayStatus(int payStatus) {
                this.payStatus = payStatus;
            }

            public Object getDelayReceiveDay() {
                return delayReceiveDay;
            }

            public void setDelayReceiveDay(Object delayReceiveDay) {
                this.delayReceiveDay = delayReceiveDay;
            }

            public Object getEscrowTradeNo() {
                return escrowTradeNo;
            }

            public void setEscrowTradeNo(Object escrowTradeNo) {
                this.escrowTradeNo = escrowTradeNo;
            }

            public Object getOutTradeNo() {
                return outTradeNo;
            }

            public void setOutTradeNo(Object outTradeNo) {
                this.outTradeNo = outTradeNo;
            }

            public Object getPayChannel() {
                return payChannel;
            }

            public void setPayChannel(Object payChannel) {
                this.payChannel = payChannel;
            }

            public Object getPayTime() {
                return payTime;
            }

            public void setPayTime(Object payTime) {
                this.payTime = payTime;
            }

            public MallStoreBean getMallStore() {
                return mallStore;
            }

            public void setMallStore(MallStoreBean mallStore) {
                this.mallStore = mallStore;
            }

            public Object getTotal() {
                return total;
            }

            public void setTotal(Object total) {
                this.total = total;
            }

            public Object getCartId() {
                return cartId;
            }

            public void setCartId(Object cartId) {
                this.cartId = cartId;
            }

            public Object getStandardId() {
                return standardId;
            }

            public void setStandardId(Object standardId) {
                this.standardId = standardId;
            }

            public Object getCouponsId() {
                return couponsId;
            }

            public void setCouponsId(Object couponsId) {
                this.couponsId = couponsId;
            }

            public Object getCouponId() {
                return couponId;
            }

            public void setCouponId(Object couponId) {
                this.couponId = couponId;
            }

            public static class MallStoreBean implements Serializable{

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
                private String serviceRegulations;
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

                public String getServiceRegulations() {
                    return serviceRegulations;
                }

                public void setServiceRegulations(String serviceRegulations) {
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

                public static class MallProductsBean implements Serializable{

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
                    private int cartProductNum;
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
                    private TransportTemplateBean transportTemplate;

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

                    public int getCartProductNum() {
                        return cartProductNum;
                    }

                    public void setCartProductNum(int cartProductNum) {
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

                    public TransportTemplateBean getTransportTemplate() {
                        return transportTemplate;
                    }

                    public void setTransportTemplate(TransportTemplateBean transportTemplate) {
                        this.transportTemplate = transportTemplate;
                    }

                    public static class TransportTemplateBean implements Serializable{

                        private int id;
                        private String name;
                        private int priceType;
                        private int deliveryType;
                        private Object delFlag;
                        private Object createBy;
                        private Object createTime;
                        private Object updateBy;
                        private Object updateTime;
                        private Object defaultTransCost;

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

                        public int getPriceType() {
                            return priceType;
                        }

                        public void setPriceType(int priceType) {
                            this.priceType = priceType;
                        }

                        public int getDeliveryType() {
                            return deliveryType;
                        }

                        public void setDeliveryType(int deliveryType) {
                            this.deliveryType = deliveryType;
                        }

                        public Object getDelFlag() {
                            return delFlag;
                        }

                        public void setDelFlag(Object delFlag) {
                            this.delFlag = delFlag;
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

                        public Object getDefaultTransCost() {
                            return defaultTransCost;
                        }

                        public void setDefaultTransCost(Object defaultTransCost) {
                            this.defaultTransCost = defaultTransCost;
                        }
                    }
                }
            }
        }
    }
}
