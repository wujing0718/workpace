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
                 * name : 阿萨德
                 * isSpecial : 0
                 * img : 阿斯蒂芬
                 * story : 阿斯蒂芬
                 * order : 1
                 * createTime : 2019-06-14T05:43:21.000+0000
                 * updateTime : 2019-07-19T01:38:50.000+0000
                 * address : 地址
                 * isCollection : 0
                 * productList : [{"id":1,"name":"测试","storeName":null,"categoryId":null,"keywords":null,"model":null,"virtualNum":null,"price":5909,"marketPrice":null,"integral":null,"stock":null,"warningStock":null,"coverUrl":"http://oss.irving.net.cn/tea/%E5%BE%AE%E4%BF%A1%E5%9B%BE%E7%89%87_20190621162756.jpg","state":null,"showOrder":null,"sellNum":null,"isNew":null,"unit":null,"transId":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"del":null,"isRecommend":null,"isCheck":null,"limitIntegral":null,"subhead":null,"remark":null,"weight":null,"count":null,"sendIntegral":null,"sendGrowth":null,"productPicture":null,"storeId":null,"isSift":null,"brandId":1,"mallStore":null,"sellCount":null,"num":null,"basicService":null,"productType":null,"transName":null,"priceType":null,"deliveryType":null,"defaultTransCost":null,"branName":null,"brandImg":null,"brandIsSpecial":null,"brandOrder":null,"brandAddress":null,"attributeId":null,"standardId":null,"userId":null,"collectionNum":null,"standard":null},{"id":19,"name":"测试19","storeName":null,"categoryId":null,"keywords":null,"model":null,"virtualNum":null,"price":2,"marketPrice":null,"integral":null,"stock":null,"warningStock":null,"coverUrl":"http://oss.irving.net.cn/tea/1911562737563_.pic_hd.jpg","state":null,"showOrder":null,"sellNum":null,"isNew":null,"unit":null,"transId":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"del":null,"isRecommend":null,"isCheck":null,"limitIntegral":null,"subhead":null,"remark":null,"weight":null,"count":null,"sendIntegral":null,"sendGrowth":null,"productPicture":null,"storeId":null,"isSift":null,"brandId":1,"mallStore":null,"sellCount":null,"num":null,"basicService":null,"productType":null,"transName":null,"priceType":null,"deliveryType":null,"defaultTransCost":null,"branName":null,"brandImg":null,"brandIsSpecial":null,"brandOrder":null,"brandAddress":null,"attributeId":null,"standardId":null,"userId":null,"collectionNum":null,"standard":null},{"id":21,"name":"测试21","storeName":null,"categoryId":null,"keywords":null,"model":null,"virtualNum":null,"price":4,"marketPrice":null,"integral":null,"stock":null,"warningStock":null,"coverUrl":"http://oss.irving.net.cn/tea/%E5%BE%AE%E4%BF%A1%E5%9B%BE%E7%89%87_20190621162756.jpg","state":null,"showOrder":null,"sellNum":null,"isNew":null,"unit":null,"transId":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"del":null,"isRecommend":null,"isCheck":null,"limitIntegral":null,"subhead":null,"remark":null,"weight":null,"count":null,"sendIntegral":null,"sendGrowth":null,"productPicture":null,"storeId":null,"isSift":null,"brandId":1,"mallStore":null,"sellCount":null,"num":null,"basicService":null,"productType":null,"transName":null,"priceType":null,"deliveryType":null,"defaultTransCost":null,"branName":null,"brandImg":null,"brandIsSpecial":null,"brandOrder":null,"brandAddress":null,"attributeId":null,"standardId":null,"userId":null,"collectionNum":null,"standard":null},{"id":20,"name":"测试20","storeName":null,"categoryId":null,"keywords":null,"model":null,"virtualNum":null,"price":3,"marketPrice":null,"integral":null,"stock":null,"warningStock":null,"coverUrl":"http://oss.irving.net.cn/tea/%E5%BE%AE%E4%BF%A1%E5%9B%BE%E7%89%87_20190621162756.jpg","state":null,"showOrder":null,"sellNum":null,"isNew":null,"unit":null,"transId":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"del":null,"isRecommend":null,"isCheck":null,"limitIntegral":null,"subhead":null,"remark":null,"weight":null,"count":null,"sendIntegral":null,"sendGrowth":null,"productPicture":null,"storeId":null,"isSift":null,"brandId":2,"mallStore":null,"sellCount":null,"num":null,"basicService":null,"productType":null,"transName":null,"priceType":null,"deliveryType":null,"defaultTransCost":null,"branName":null,"brandImg":null,"brandIsSpecial":null,"brandOrder":null,"brandAddress":null,"attributeId":null,"standardId":null,"userId":null,"collectionNum":null,"standard":null},{"id":24,"name":"测试24","storeName":null,"categoryId":null,"keywords":null,"model":null,"virtualNum":null,"price":25,"marketPrice":null,"integral":null,"stock":null,"warningStock":null,"coverUrl":"http://zhmp.oss-cn-shenzhen.aliyuncs.com/tea/%E5%BE%AE%E4%BF%A1%E5%9B%BE%E7%89%87_20190621162803.jpg","state":null,"showOrder":null,"sellNum":null,"isNew":null,"unit":null,"transId":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"del":null,"isRecommend":null,"isCheck":null,"limitIntegral":null,"subhead":null,"remark":null,"weight":null,"count":null,"sendIntegral":null,"sendGrowth":null,"productPicture":null,"storeId":null,"isSift":null,"brandId":2,"mallStore":null,"sellCount":null,"num":null,"basicService":null,"productType":null,"transName":null,"priceType":null,"deliveryType":null,"defaultTransCost":null,"branName":null,"brandImg":null,"brandIsSpecial":null,"brandOrder":null,"brandAddress":null,"attributeId":null,"standardId":null,"userId":null,"collectionNum":null,"standard":null},{"id":25,"name":"测试25","storeName":null,"categoryId":null,"keywords":null,"model":null,"virtualNum":null,"price":25,"marketPrice":null,"integral":null,"stock":null,"warningStock":null,"coverUrl":"http://zhmp.oss-cn-shenzhen.aliyuncs.com/tea/%E5%BE%AE%E4%BF%A1%E5%9B%BE%E7%89%87_20190621162803.jpg","state":null,"showOrder":null,"sellNum":null,"isNew":null,"unit":null,"transId":null,"createBy":null,"createTime":null,"updateBy":null,"updateTime":null,"del":null,"isRecommend":null,"isCheck":null,"limitIntegral":null,"subhead":null,"remark":null,"weight":null,"count":null,"sendIntegral":null,"sendGrowth":null,"productPicture":null,"storeId":null,"isSift":null,"brandId":2,"mallStore":null,"sellCount":null,"num":null,"basicService":null,"productType":null,"transName":null,"priceType":null,"deliveryType":null,"defaultTransCost":null,"branName":null,"brandImg":null,"brandIsSpecial":null,"brandOrder":null,"brandAddress":null,"attributeId":null,"standardId":null,"userId":null,"collectionNum":null,"standard":null}]
                 */

                private int id;
                private String name;
                private String isSpecial;
                private String img;
                private String story;
                private String order;
                private String createTime;
                private String updateTime;
                private String address;
                private int isCollection;
                private List<ProductListBean> productList;

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

                public String getIsSpecial() {
                    return isSpecial;
                }

                public void setIsSpecial(String isSpecial) {
                    this.isSpecial = isSpecial;
                }

                public String getImg() {
                    return img;
                }

                public void setImg(String img) {
                    this.img = img;
                }

                public String getStory() {
                    return story;
                }

                public void setStory(String story) {
                    this.story = story;
                }

                public String getOrder() {
                    return order;
                }

                public void setOrder(String order) {
                    this.order = order;
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

                public String getAddress() {
                    return address;
                }

                public void setAddress(String address) {
                    this.address = address;
                }

                public int getIsCollection() {
                    return isCollection;
                }

                public void setIsCollection(int isCollection) {
                    this.isCollection = isCollection;
                }

                public List<ProductListBean> getProductList() {
                    return productList;
                }

                public void setProductList(List<ProductListBean> productList) {
                    this.productList = productList;
                }

                public static class ProductListBean {
                    /**
                     * id : 1
                     * name : 测试
                     * storeName : null
                     * categoryId : null
                     * keywords : null
                     * model : null
                     * virtualNum : null
                     * price : 5909.0
                     * marketPrice : null
                     * integral : null
                     * stock : null
                     * warningStock : null
                     * coverUrl : http://oss.irving.net.cn/tea/%E5%BE%AE%E4%BF%A1%E5%9B%BE%E7%89%87_20190621162756.jpg
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
                     * brandId : 1
                     * mallStore : null
                     * sellCount : null
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
                    private int brandId;
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
                    private Object collectionNum;
                    private Object standard;

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
                }
            }
        }

        public static class IsSpecialBean {
            /**
             * id : 2
             * name : 品牌名称
             * isSpecial : 1
             * img : 图片
             * story : 阿斯蒂芬
             * order : 0
             * createTime : 2019-06-20T08:47:09.000+0000
             * updateTime : 2019-07-19T01:38:59.000+0000
             * address : 地址
             * isCollection : null
             * productList : null
             */

            private int id;
            private String name;
            private String isSpecial;
            private String img;
            private String story;
            private String order;
            private String createTime;
            private String updateTime;
            private String address;
            private Object isCollection;
            private Object productList;

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

            public String getIsSpecial() {
                return isSpecial;
            }

            public void setIsSpecial(String isSpecial) {
                this.isSpecial = isSpecial;
            }

            public String getImg() {
                return img;
            }

            public void setImg(String img) {
                this.img = img;
            }

            public String getStory() {
                return story;
            }

            public void setStory(String story) {
                this.story = story;
            }

            public String getOrder() {
                return order;
            }

            public void setOrder(String order) {
                this.order = order;
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

            public String getAddress() {
                return address;
            }

            public void setAddress(String address) {
                this.address = address;
            }

            public Object getIsCollection() {
                return isCollection;
            }

            public void setIsCollection(Object isCollection) {
                this.isCollection = isCollection;
            }

            public Object getProductList() {
                return productList;
            }

            public void setProductList(Object productList) {
                this.productList = productList;
            }
        }
    }
}
