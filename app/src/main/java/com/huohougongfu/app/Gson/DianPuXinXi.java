package com.huohougongfu.app.Gson;

public class DianPuXinXi {


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
         * updateTime : 2019-08-08T02:14:51.000+0000
         * info : {"id":null,"storeId":11,"idCard":"http://oss.irving.net.cn/tea/1565157964223.jpg,http://oss.irving.net.cn/tea/1565157966949.jpg","businessLicense":"http://oss.irving.net.cn/tea/1565157966918.jpeg","doorPhoto":"http://oss.irving.net.cn/tea/1565157963468.jpg","authorization":"http://oss.irving.net.cn/tea/1565157970147.jpeg","accountName":"黄文俊","bankCardNo":"6228481985797214476","bankName":"农业银行","status":2,"createTime":"2019-07-10T11:30:44.000+0000","updateTime":"2019-08-08T02:14:51.000+0000"}
         * year : null
         * favorableRate : null
         * fensNum : null
         * sellNum : null
         * appraiseCategory : null
         * productId : null
         * coverUrl : null
         * visitNum : null
         * visitNumOfDay : null
         * specialBrandInfo : null
         * specialInstructions : 哈比哈哈哈哈白皑皑哈哈哈爱吧
         * creditCard : 1
         * deliveryTime : 1
         * basicExpressFee : 10.0
         * freeAmountOfExpressFee : 100.0
         */

        private int id;
        private int userId;
        private String storePicture;
        private String storeLogo;
        private String storeName;
        private String storeLicense;
        private String createTime;
        private String updateTime;
        private InfoBean info;
        private Object year;
        private Object favorableRate;
        private Object fensNum;
        private Object sellNum;
        private Object appraiseCategory;
        private Object productId;
        private Object coverUrl;
        private Object visitNum;
        private Object visitNumOfDay;
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

        public InfoBean getInfo() {
            return info;
        }

        public void setInfo(InfoBean info) {
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

        public static class InfoBean {
            /**
             * id : null
             * storeId : 11
             * idCard : http://oss.irving.net.cn/tea/1565157964223.jpg,http://oss.irving.net.cn/tea/1565157966949.jpg
             * businessLicense : http://oss.irving.net.cn/tea/1565157966918.jpeg
             * doorPhoto : http://oss.irving.net.cn/tea/1565157963468.jpg
             * authorization : http://oss.irving.net.cn/tea/1565157970147.jpeg
             * accountName : 黄文俊
             * bankCardNo : 6228481985797214476
             * bankName : 农业银行
             * status : 2
             * createTime : 2019-07-10T11:30:44.000+0000
             * updateTime : 2019-08-08T02:14:51.000+0000
             */

            private Object id;
            private int storeId;
            private String idCard;
            private String businessLicense;
            private String doorPhoto;
            private String authorization;
            private String accountName;
            private String bankCardNo;
            private String bankName;
            private int status;
            private String createTime;
            private String updateTime;

            public Object getId() {
                return id;
            }

            public void setId(Object id) {
                this.id = id;
            }

            public int getStoreId() {
                return storeId;
            }

            public void setStoreId(int storeId) {
                this.storeId = storeId;
            }

            public String getIdCard() {
                return idCard;
            }

            public void setIdCard(String idCard) {
                this.idCard = idCard;
            }

            public String getBusinessLicense() {
                return businessLicense;
            }

            public void setBusinessLicense(String businessLicense) {
                this.businessLicense = businessLicense;
            }

            public String getDoorPhoto() {
                return doorPhoto;
            }

            public void setDoorPhoto(String doorPhoto) {
                this.doorPhoto = doorPhoto;
            }

            public String getAuthorization() {
                return authorization;
            }

            public void setAuthorization(String authorization) {
                this.authorization = authorization;
            }

            public String getAccountName() {
                return accountName;
            }

            public void setAccountName(String accountName) {
                this.accountName = accountName;
            }

            public String getBankCardNo() {
                return bankCardNo;
            }

            public void setBankCardNo(String bankCardNo) {
                this.bankCardNo = bankCardNo;
            }

            public String getBankName() {
                return bankName;
            }

            public void setBankName(String bankName) {
                this.bankName = bankName;
            }

            public int getStatus() {
                return status;
            }

            public void setStatus(int status) {
                this.status = status;
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
        }
    }
}
