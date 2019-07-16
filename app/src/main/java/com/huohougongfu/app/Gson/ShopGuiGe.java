package com.huohougongfu.app.Gson;

import java.util.List;

public class ShopGuiGe {
    /**
     * msg : 操作成功
     * result : {"productStandard":[{"id":1,"productId":45,"standardPrice":66,"standard":"16g"},{"id":9,"productId":45,"standardPrice":77,"standard":"18g"}],"productInfo":{"id":45,"name":"商品标题","categoryId":1,"price":1,"marketPrice":1,"coverUrl":"http://img2.imgtn.bdimg.com/it/u=180868167,273146879&fm=26&gp=0.jpg","sellNum":1560,"transId":2,"remark":"1","productPicture":"http://pic34.nipic.com/20131020/6704106_203943375000_2.jpg,http://pic13.nipic.com/20110409/7119492_114440620000_2.jpg,http://pic13.nipic.com/20110409/7119492_114440620000_2.jpg,http://pic13.nipic.com/20110409/7119492_114440620000_2.jpg","storeId":1,"storePicture":"https://werw/w/ge.jpg","storeLogo":"https://werw/w/ge.jpg","storeBoard":"店铺公告","storeName":"测试店铺","storeAddress":"广东深圳"}}
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
         * productStandard : [{"id":1,"productId":45,"standardPrice":66,"standard":"16g"},{"id":9,"productId":45,"standardPrice":77,"standard":"18g"}]
         * productInfo : {"id":45,"name":"商品标题","categoryId":1,"price":1,"marketPrice":1,"coverUrl":"http://img2.imgtn.bdimg.com/it/u=180868167,273146879&fm=26&gp=0.jpg","sellNum":1560,"transId":2,"remark":"1","productPicture":"http://pic34.nipic.com/20131020/6704106_203943375000_2.jpg,http://pic13.nipic.com/20110409/7119492_114440620000_2.jpg,http://pic13.nipic.com/20110409/7119492_114440620000_2.jpg,http://pic13.nipic.com/20110409/7119492_114440620000_2.jpg","storeId":1,"storePicture":"https://werw/w/ge.jpg","storeLogo":"https://werw/w/ge.jpg","storeBoard":"店铺公告","storeName":"测试店铺","storeAddress":"广东深圳"}
         */
        private String noStandard;
        private ProductInfoBean productInfo;
        private List<ProductStandardBean> productStandard;

        public String getNoStandard() {
            return noStandard;
        }

        public void setNoStandard(String noStandard) {
            this.noStandard = noStandard;
        }


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
             * id : 45
             * name : 商品标题
             * categoryId : 1
             * price : 1
             * marketPrice : 1
             * coverUrl : http://img2.imgtn.bdimg.com/it/u=180868167,273146879&fm=26&gp=0.jpg
             * sellNum : 1560
             * transId : 2
             * remark : 1
             * productPicture : http://pic34.nipic.com/20131020/6704106_203943375000_2.jpg,http://pic13.nipic.com/20110409/7119492_114440620000_2.jpg,http://pic13.nipic.com/20110409/7119492_114440620000_2.jpg,http://pic13.nipic.com/20110409/7119492_114440620000_2.jpg
             * storeId : 1
             * storePicture : https://werw/w/ge.jpg
             * storeLogo : https://werw/w/ge.jpg
             * storeBoard : 店铺公告
             * storeName : 测试店铺
             * storeAddress : 广东深圳
             */

            private int id;
            private String name;
            private int categoryId;
            private int price;
            private int marketPrice;
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

            public int getPrice() {
                return price;
            }

            public void setPrice(int price) {
                this.price = price;
            }

            public int getMarketPrice() {
                return marketPrice;
            }

            public void setMarketPrice(int marketPrice) {
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
        }

        public static class ProductStandardBean {
            /**
             * id : 1
             * productId : 45
             * standardPrice : 66
             * standard : 16g
             */

            private int id;
            private int productId;
            private int standardPrice;
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

            public int getStandardPrice() {
                return standardPrice;
            }

            public void setStandardPrice(int standardPrice) {
                this.standardPrice = standardPrice;
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
