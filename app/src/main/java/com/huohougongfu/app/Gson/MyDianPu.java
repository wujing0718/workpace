package com.huohougongfu.app.Gson;

public class MyDianPu {

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
         * id : 5
         * userId : 43
         * storePicture : https://werw/w/ge.jpg
         * storeLogo : https://werw/w/ge.jpg
         * storeName : 店铺名称1
         * storeLicense : https://werw/w/ge.jpg
         * createTime : 2019-07-10T11:30:44.000+0000
         * updateTime : 2019-08-08T08:19:54.000+0000
         * info : null
         * year : null
         * favorableRate : null
         * fensNum : null
         * sellNum : null
         * appraiseCategory : null
         * productId : null
         * coverUrl : null
         * visitNum : 0
         * visitNumOfDay : 0
         * specialBrandInfo : null
         * specialInstructions : 哈比哈哈哈哈白皑皑哈哈哈爱吧
         * creditCard : 1
         * deliveryTime : 1
         * basicExpressFee : 16.0
         * freeAmountOfExpressFee : 110.0
         */

        private int id;
        private int userId;
        private String storePicture;
        private String storeLogo;
        private String storeName;
        private String storeLicense;
        private String createTime;
        private String updateTime;
        private Object info;
        private Object year;
        private Object favorableRate;
        private Object fensNum;
        private Object sellNum;
        private Object appraiseCategory;
        private Object productId;
        private Object coverUrl;
        private int visitNum;
        private int visitNumOfDay;
        private Object specialBrandInfo;
        private String specialInstructions;
        private int creditCard;
        private int deliveryTime;
        private double basicExpressFee;
        private double freeAmountOfExpressFee;

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

        public String getStoreName() {
            return storeName;
        }

        public void setStoreName(String storeName) {
            this.storeName = storeName;
        }

        public String getStoreLicense() {
            return storeLicense;
        }

        public void setStoreLicense(String storeLicense) {
            this.storeLicense = storeLicense;
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

        public int getVisitNum() {
            return visitNum;
        }

        public void setVisitNum(int visitNum) {
            this.visitNum = visitNum;
        }

        public int getVisitNumOfDay() {
            return visitNumOfDay;
        }

        public void setVisitNumOfDay(int visitNumOfDay) {
            this.visitNumOfDay = visitNumOfDay;
        }

        public Object getSpecialBrandInfo() {
            return specialBrandInfo;
        }

        public void setSpecialBrandInfo(Object specialBrandInfo) {
            this.specialBrandInfo = specialBrandInfo;
        }

        public String getSpecialInstructions() {
            return specialInstructions;
        }

        public void setSpecialInstructions(String specialInstructions) {
            this.specialInstructions = specialInstructions;
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

        public double getBasicExpressFee() {
            return basicExpressFee;
        }

        public void setBasicExpressFee(double basicExpressFee) {
            this.basicExpressFee = basicExpressFee;
        }

        public double getFreeAmountOfExpressFee() {
            return freeAmountOfExpressFee;
        }

        public void setFreeAmountOfExpressFee(double freeAmountOfExpressFee) {
            this.freeAmountOfExpressFee = freeAmountOfExpressFee;
        }
    }
}
