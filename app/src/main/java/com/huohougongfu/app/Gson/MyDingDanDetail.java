package com.huohougongfu.app.Gson;

import java.io.Serializable;
import java.util.List;

public class MyDingDanDetail implements Serializable{

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

    public static class ResultBean implements Serializable{
        /**
         * id : null
         * orderNo : 23
         * orderStatus : 1
         * productId : 34
         * productNum : 4
         * productTotalNum : null
         * productAmountTotal : 12.0
         * orderAmountTotal : 12.0
         * logisticsFee : 12.0
         * integral : 12
         * payChannel : 1
         * outTradeNo : 12
         * escrowTradeNo : 12
         * payTime : 2019-06-04T06:21:24.000+0000
         * delayReceiveDay : 22
         * createBy : 43
         * createTime : 2019-06-18T06:21:34.000+0000
         * updateBy : 2
         * updateTime : 2019-06-25T06:21:41.000+0000
         * invoiceMoney : 12.0
         * standardId : 3
         * standard : null
         * cancelTime : null
         * remark : null
         * status : null
         * mallStores : {"id":1,"storeLogo":"https://werw/w/ge.jpg","storeName":"店铺名称1","info":null,"year":null,"favorableRate":null,"fensNum":null,"sellNum":null,"appraiseCategory":null,"productId":null,"coverUrl":null,"visitNum":null,"visitNumOfDay":null,"serviceRegulations":"满一千1000可用","mallProducts":[{"id":34,"name":"测试34","storeName":null,"categoryId":null,"keywords":null,"model":null,"virtualNum":null,"price":25,"marketPrice":null,"integral":null,"stock":null,"warningStock":null,"coverUrl":"1212","state":null,"showOrder":null,"sellNum":null,"isNew":null,"unit":null,"transId":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"del":null,"isRecommend":null,"isCheck":null,"limitIntegral":null,"subhead":null,"remark":null,"weight":null,"count":null,"sendIntegral":null,"sendGrowth":null,"productPicture":null,"storeId":null,"isSift":null,"brandId":null,"mallStore":null,"sellCount":null,"cartId":null,"cartProductNum":null,"buyNum":null,"num":null,"basicService":null,"productType":null,"transName":null,"priceType":null,"deliveryType":null,"defaultTransCost":null,"branName":null,"brandImg":null,"brandIsSpecial":null,"brandOrder":null,"brandAddress":null,"attributeId":null,"standardId":null,"userId":null,"collectionNum":null,"standard":null,"transportTemplate":null},{"id":21,"name":"测试21","storeName":null,"categoryId":null,"keywords":null,"model":null,"virtualNum":null,"price":4,"marketPrice":null,"integral":null,"stock":null,"warningStock":null,"coverUrl":"http://oss.irving.net.cn/tea/%E5%BE%AE%E4%BF%A1%E5%9B%BE%E7%89%87_20190621162756.jpg","state":null,"showOrder":null,"sellNum":null,"isNew":null,"unit":null,"transId":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"del":null,"isRecommend":null,"isCheck":null,"limitIntegral":null,"subhead":null,"remark":null,"weight":null,"count":null,"sendIntegral":null,"sendGrowth":null,"productPicture":null,"storeId":null,"isSift":null,"brandId":null,"mallStore":null,"sellCount":null,"cartId":null,"cartProductNum":null,"buyNum":null,"num":null,"basicService":null,"productType":null,"transName":null,"priceType":null,"deliveryType":null,"defaultTransCost":null,"branName":null,"brandImg":null,"brandIsSpecial":null,"brandOrder":null,"brandAddress":null,"attributeId":null,"standardId":null,"userId":null,"collectionNum":null,"standard":null,"transportTemplate":null}],"ccoverUrl":null}
         * ocrId : null
         * mallProducts : null
         * name : null
         * coverUrl : null
         * storeId : null
         * logisticsNo : 1232434f
         * logisticsName : null
         * addressId : 65
         * couponId : 3
         * provinceName : 广东省
         * cityName : 广东省
         * areaName : 龙岗区
         * detailAddr : 龙岗街道金晖创业社区A栋407
         * receiverName : 哈哈哈
         * phone : 18910328794
         * serviceRegulations : 满一千1000可用
         * deliveryType : null
         */

        private Object id;
        private String orderNo;
        private int orderStatus;
        private int productId;
        private int productNum;
        private Object productTotalNum;
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
        private String createTime1;
        private int updateBy;
        private String updateTime;
        private double invoiceMoney;
        private int standardId;
        private Object standard;
        private Object cancelTime;
        private String remark;
        private Object status;
        private MallStoresBean mallStores;
        private Object ocrId;
        private Object mallProducts;
        private Object name;
        private Object coverUrl;
        private Object storeId;
        private String logisticsNo;
        private String logisticsName;
        private int addressId;
        private int couponId;
        private String provinceName;
        private String cityName;
        private String areaName;
        private String detailAddr;
        private String receiverName;
        private String phone;
        private String serviceRegulations;
        private Object deliveryType;
        private String transportWay;

        public String getTransportWay() {
            return transportWay;
        }

        public void setTransportWay(String transportWay) {
            this.transportWay = transportWay;
        }

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

        public Object getProductTotalNum() {
            return productTotalNum;
        }

        public void setProductTotalNum(Object productTotalNum) {
            this.productTotalNum = productTotalNum;
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

        public int getCreateBy() {
            return createBy;
        }

        public void setCreateBy(int createBy) {
            this.createBy = createBy;
        }

        public String getCreateTimel() {
            return createTime1;
        }

        public void setCreateTimel(String createTime1) {
            this.createTime1 = createTime1;
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

        public String getRemark() {
            return remark;
        }

        public void setRemark(String remark) {
            this.remark = remark;
        }

        public Object getStatus() {
            return status;
        }

        public void setStatus(Object status) {
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

        public String getLogisticsNo() {
            return logisticsNo;
        }

        public void setLogisticsNo(String logisticsNo) {
            this.logisticsNo = logisticsNo;
        }

        public String getLogisticsName() {
            return logisticsName;
        }

        public void setLogisticsName(String logisticsName) {
            this.logisticsName = logisticsName;
        }

        public int getAddressId() {
            return addressId;
        }

        public void setAddressId(int addressId) {
            this.addressId = addressId;
        }

        public int getCouponId() {
            return couponId;
        }

        public void setCouponId(int couponId) {
            this.couponId = couponId;
        }

        public String getProvinceName() {
            return provinceName;
        }

        public void setProvinceName(String provinceName) {
            this.provinceName = provinceName;
        }

        public String getCityName() {
            return cityName;
        }

        public void setCityName(String cityName) {
            this.cityName = cityName;
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

        public String getServiceRegulations() {
            return serviceRegulations;
        }

        public void setServiceRegulations(String serviceRegulations) {
            this.serviceRegulations = serviceRegulations;
        }

        public Object getDeliveryType() {
            return deliveryType;
        }

        public void setDeliveryType(Object deliveryType) {
            this.deliveryType = deliveryType;
        }

        public static class MallStoresBean implements Serializable{
            /**
             * id : 1
             * storeLogo : https://werw/w/ge.jpg
             * storeName : 店铺名称1
             * info : null
             * year : null
             * favorableRate : null
             * fensNum : null
             * sellNum : null
             * appraiseCategory : null
             * productId : null
             * coverUrl : null
             * visitNum : null
             * visitNumOfDay : null
             * serviceRegulations : 满一千1000可用
             * mallProducts : [{"id":34,"name":"测试34","storeName":null,"categoryId":null,"keywords":null,"model":null,"virtualNum":null,"price":25,"marketPrice":null,"integral":null,"stock":null,"warningStock":null,"coverUrl":"1212","state":null,"showOrder":null,"sellNum":null,"isNew":null,"unit":null,"transId":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"del":null,"isRecommend":null,"isCheck":null,"limitIntegral":null,"subhead":null,"remark":null,"weight":null,"count":null,"sendIntegral":null,"sendGrowth":null,"productPicture":null,"storeId":null,"isSift":null,"brandId":null,"mallStore":null,"sellCount":null,"cartId":null,"cartProductNum":null,"buyNum":null,"num":null,"basicService":null,"productType":null,"transName":null,"priceType":null,"deliveryType":null,"defaultTransCost":null,"branName":null,"brandImg":null,"brandIsSpecial":null,"brandOrder":null,"brandAddress":null,"attributeId":null,"standardId":null,"userId":null,"collectionNum":null,"standard":null,"transportTemplate":null},{"id":21,"name":"测试21","storeName":null,"categoryId":null,"keywords":null,"model":null,"virtualNum":null,"price":4,"marketPrice":null,"integral":null,"stock":null,"warningStock":null,"coverUrl":"http://oss.irving.net.cn/tea/%E5%BE%AE%E4%BF%A1%E5%9B%BE%E7%89%87_20190621162756.jpg","state":null,"showOrder":null,"sellNum":null,"isNew":null,"unit":null,"transId":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"del":null,"isRecommend":null,"isCheck":null,"limitIntegral":null,"subhead":null,"remark":null,"weight":null,"count":null,"sendIntegral":null,"sendGrowth":null,"productPicture":null,"storeId":null,"isSift":null,"brandId":null,"mallStore":null,"sellCount":null,"cartId":null,"cartProductNum":null,"buyNum":null,"num":null,"basicService":null,"productType":null,"transName":null,"priceType":null,"deliveryType":null,"defaultTransCost":null,"branName":null,"brandImg":null,"brandIsSpecial":null,"brandOrder":null,"brandAddress":null,"attributeId":null,"standardId":null,"userId":null,"collectionNum":null,"standard":null,"transportTemplate":null}]
             * ccoverUrl : null
             */

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

            public static class MallProductsBean implements Serializable {
                /**
                 * id : 34
                 * name : 测试34
                 * storeName : null
                 * categoryId : null
                 * keywords : null
                 * model : null
                 * virtualNum : null
                 * price : 25.0
                 * marketPrice : null
                 * integral : null
                 * stock : null
                 * warningStock : null
                 * coverUrl : 1212
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
                 * storeId : null
                 * isSift : null
                 * brandId : null
                 * mallStore : null
                 * sellCount : null
                 * cartId : null
                 * cartProductNum : null
                 * buyNum : null
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
                private int standardId;
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

                public int getStandardId() {
                    return standardId;
                }

                public void setStandardId(int standardId) {
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
