package com.huohougongfu.app.Gson;

import java.util.List;

public class ShopGuiGe {


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

        private ProductInfoBean productInfo;
        private List<ProductStandardBean> productStandard;

        public ProductInfoBean getProductInfo() {
            return productInfo;
        }

        public void setProductInfo(ProductInfoBean productInfo) {
            this.productInfo = productInfo;
        }

        public List<ProductStandardBean> getProductStandard() {
            return productStandard;
        }

        public void setProductStandard(List<ProductStandardBean> productStandard) {
            this.productStandard = productStandard;
        }

        public static class ProductInfoBean {
            /**
             * defaultTranCost : 10.0
             * id : 6
             * name : 黑茶
             * categoryId : 22
             * storePhone : 18910328122
             * price : 0.1
             * marketPrice : 0.1
             * coverUrl : http://oss.irving.net.cn/tea/1566892267942.jpg
             * sellNum : 16
             * transId : 0
             * remark :
             * productPicture : http://oss.irving.net.cn/tea/1566892267942.jpg
             * storeId : 4
             * storePicture : null
             * storeLogo : null
             * storeBoard : null
             * storeName : 爱喝茶的人
             * stock : 80
             * isAttention : null
             * userHeadPic : http://oss.irving.net.cn/tea/1567404428321.jpg
             * doorPhoto : http://oss.irving.net.cn/tea/1566808633243.jpg
             * createBy : null
             * sendAddress : 北京市
             * specialInstructions : ghhhuh
             * productCollection : 0
             * standardId : null
             * userId : 3
             * detailPic : http://oss.irving.net.cn/tea/1566892266793.jpg
             * creditCard : 0
             * deliveryTime : 1
             * mallBasicService : null
             */

            private double defaultTranCost;
            private int id;
            private String name;
            private int categoryId;
            private String storePhone;
            private double price;
            private double marketPrice;
            private String coverUrl;
            private int sellNum;
            private int transId;
            private String remark;
            private String productPicture;
            private int storeId;
            private Object storePicture;
            private Object storeLogo;
            private Object storeBoard;
            private String storeName;
            private String stock;
            private Object isAttention;
            private String userHeadPic;
            private String doorPhoto;
            private Object createBy;
            private String sendAddress;
            private String specialInstructions;
            private int productCollection;
            private Object standardId;
            private int userId;
            private String detailPic;
            private int creditCard;
            private int deliveryTime;
            private Object mallBasicService;

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

            public String getStorePhone() {
                return storePhone;
            }

            public void setStorePhone(String storePhone) {
                this.storePhone = storePhone;
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

            public String getStock() {
                return stock;
            }

            public void setStock(String stock) {
                this.stock = stock;
            }

            public Object getIsAttention() {
                return isAttention;
            }

            public void setIsAttention(Object isAttention) {
                this.isAttention = isAttention;
            }

            public String getUserHeadPic() {
                return userHeadPic;
            }

            public void setUserHeadPic(String userHeadPic) {
                this.userHeadPic = userHeadPic;
            }

            public String getDoorPhoto() {
                return doorPhoto;
            }

            public void setDoorPhoto(String doorPhoto) {
                this.doorPhoto = doorPhoto;
            }

            public Object getCreateBy() {
                return createBy;
            }

            public void setCreateBy(Object createBy) {
                this.createBy = createBy;
            }

            public String getSendAddress() {
                return sendAddress;
            }

            public void setSendAddress(String sendAddress) {
                this.sendAddress = sendAddress;
            }

            public String getSpecialInstructions() {
                return specialInstructions;
            }

            public void setSpecialInstructions(String specialInstructions) {
                this.specialInstructions = specialInstructions;
            }

            public int getProductCollection() {
                return productCollection;
            }

            public void setProductCollection(int productCollection) {
                this.productCollection = productCollection;
            }

            public Object getStandardId() {
                return standardId;
            }

            public void setStandardId(Object standardId) {
                this.standardId = standardId;
            }

            public int getUserId() {
                return userId;
            }

            public void setUserId(int userId) {
                this.userId = userId;
            }

            public String getDetailPic() {
                return detailPic;
            }

            public void setDetailPic(String detailPic) {
                this.detailPic = detailPic;
            }

            public int getCreditCard() {
                return creditCard;
            }

            public void setCreditCard(int creditCard) {
                this.creditCard = creditCard;
            }

            public int getDeliveryTime() {
                return deliveryTime;
            }

            public void setDeliveryTime(int deliveryTime) {
                this.deliveryTime = deliveryTime;
            }

            public Object getMallBasicService() {
                return mallBasicService;
            }

            public void setMallBasicService(Object mallBasicService) {
                this.mallBasicService = mallBasicService;
            }
        }

        public static class ProductStandardBean {
            /**
             * id : 91
             * productId : 6
             * standardPrice : 0.01
             * marketPrice : 0.01
             * standard : 50g
             */

            private int id;
            private int productId;
            private double standardPrice;
            private double marketPrice;
            private String standard;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public int getProductId() {
                return productId;
            }

            public void setProductId(int productId) {
                this.productId = productId;
            }

            public double getStandardPrice() {
                return standardPrice;
            }

            public void setStandardPrice(double standardPrice) {
                this.standardPrice = standardPrice;
            }

            public double getMarketPrice() {
                return marketPrice;
            }

            public void setMarketPrice(double marketPrice) {
                this.marketPrice = marketPrice;
            }

            public String getStandard() {
                return standard;
            }

            public void setStandard(String standard) {
                this.standard = standard;
            }
        }
    }
}
