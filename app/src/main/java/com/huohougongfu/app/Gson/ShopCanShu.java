package com.huohougongfu.app.Gson;

public class ShopCanShu {
    /**
     * msg : 操作成功
     * result : {"id":null,"productId":null,"producedDate":"2019-06-13T03:00:00.000+0000","expirationDate":"1","storageWay":"1","productionLicenseCode":"1","productStandardCode":null,"factoryName":"1","factoryAddress":"1","burdenSheet":"1","foodAdditives":1,"netContent":"1","brand":"阿萨德","category":"白茶","producedAddress":"1","packageType":"1","createTime":null,"updateTime":null}
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
         * id : null
         * productId : null
         * producedDate : 2019-06-13T03:00:00.000+0000
         * expirationDate : 1
         * storageWay : 1
         * productionLicenseCode : 1
         * productStandardCode : null
         * factoryName : 1
         * factoryAddress : 1
         * burdenSheet : 1
         * foodAdditives : 1
         * netContent : 1
         * brand : 阿萨德
         * category : 白茶
         * producedAddress : 1
         * packageType : 1
         * createTime : null
         * updateTime : null
         */

        private Object id;
        private Object productId;
        private String producedDate;
        private String expirationDate;
        private String storageWay;
        private String productionLicenseCode;
        private String productStandardCode;
        private String factoryName;
        private String factoryAddress;
        private String burdenSheet;
        private int foodAdditives;
        private String netContent;
        private String brand;
        private String category;
        private String producedAddress;
        private String packageType;
        private Object createTime;
        private Object updateTime;

        public Object getId() {
            return id;
        }

        public void setId(Object id) {
            this.id = id;
        }

        public Object getProductId() {
            return productId;
        }

        public void setProductId(Object productId) {
            this.productId = productId;
        }

        public String getProducedDate() {
            return producedDate;
        }

        public void setProducedDate(String producedDate) {
            this.producedDate = producedDate;
        }

        public String getExpirationDate() {
            return expirationDate;
        }

        public void setExpirationDate(String expirationDate) {
            this.expirationDate = expirationDate;
        }

        public String getStorageWay() {
            return storageWay;
        }

        public void setStorageWay(String storageWay) {
            this.storageWay = storageWay;
        }

        public String getProductionLicenseCode() {
            return productionLicenseCode;
        }

        public void setProductionLicenseCode(String productionLicenseCode) {
            this.productionLicenseCode = productionLicenseCode;
        }

        public String getProductStandardCode() {
            return productStandardCode;
        }

        public void setProductStandardCode(String productStandardCode) {
            this.productStandardCode = productStandardCode;
        }

        public String getFactoryName() {
            return factoryName;
        }

        public void setFactoryName(String factoryName) {
            this.factoryName = factoryName;
        }

        public String getFactoryAddress() {
            return factoryAddress;
        }

        public void setFactoryAddress(String factoryAddress) {
            this.factoryAddress = factoryAddress;
        }

        public String getBurdenSheet() {
            return burdenSheet;
        }

        public void setBurdenSheet(String burdenSheet) {
            this.burdenSheet = burdenSheet;
        }

        public int getFoodAdditives() {
            return foodAdditives;
        }

        public void setFoodAdditives(int foodAdditives) {
            this.foodAdditives = foodAdditives;
        }

        public String getNetContent() {
            return netContent;
        }

        public void setNetContent(String netContent) {
            this.netContent = netContent;
        }

        public String getBrand() {
            return brand;
        }

        public void setBrand(String brand) {
            this.brand = brand;
        }

        public String getCategory() {
            return category;
        }

        public void setCategory(String category) {
            this.category = category;
        }

        public String getProducedAddress() {
            return producedAddress;
        }

        public void setProducedAddress(String producedAddress) {
            this.producedAddress = producedAddress;
        }

        public String getPackageType() {
            return packageType;
        }

        public void setPackageType(String packageType) {
            this.packageType = packageType;
        }

        public Object getCreateTime() {
            return createTime;
        }

        public void setCreateTime(Object createTime) {
            this.createTime = createTime;
        }

        public Object getUpdateTime() {
            return updateTime;
        }

        public void setUpdateTime(Object updateTime) {
            this.updateTime = updateTime;
        }
    }
}
