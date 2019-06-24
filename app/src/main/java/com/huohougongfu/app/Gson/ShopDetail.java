package com.huohougongfu.app.Gson;

import java.util.List;

public class ShopDetail {
    /**
     * msg : 操作成功
     * result : {"mallProduct":{"name":"测试19","categoryId":2,"price":66,"marketPrice":42,"coverUrl":"http://img.redocn.com/sheying/20150213/mulanweichangcaoyuanfengjing_3951976.jpg","sellNum":12,"transId":6,"remark":"阿斯顿发失地发生地方","productPicture":"http://pic34.nipic.com/20131020/6704106_203943375000_2.jpg,http://pic13.nipic.com/20110409/7119492_114440620000_2.jpg,http://pic13.nipic.com/20110409/7119492_114440620000_2.jpg,http://pic13.nipic.com/20110409/7119492_114440620000_2.jpg","storeId":1,"storePicture":"https://werw/w/ge.jpg","storeLogo":"https://werw/w/ge.jpg","storeBoard":"店铺公告","storeName":"测试店铺","storeAddress":"广东深圳"},"recommendation":[{"id":1,"name":"测试","price":25,"coverUrl":"1212"},{"id":19,"name":"测试19","price":25,"coverUrl":"http://img.redocn.com/sheying/20150213/mulanweichangcaoyuanfengjing_3951976.jpg"},{"id":20,"name":"测试20","price":25,"coverUrl":"1212"},{"id":22,"name":"测试22","price":25,"coverUrl":"1212"},{"id":24,"name":"测试24","price":25,"coverUrl":"1212"},{"id":25,"name":"测试25","price":25,"coverUrl":"1212"}]}
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
         * mallProduct : {"name":"测试19","categoryId":2,"price":66,"marketPrice":42,"coverUrl":"http://img.redocn.com/sheying/20150213/mulanweichangcaoyuanfengjing_3951976.jpg","sellNum":12,"transId":6,"remark":"阿斯顿发失地发生地方","productPicture":"http://pic34.nipic.com/20131020/6704106_203943375000_2.jpg,http://pic13.nipic.com/20110409/7119492_114440620000_2.jpg,http://pic13.nipic.com/20110409/7119492_114440620000_2.jpg,http://pic13.nipic.com/20110409/7119492_114440620000_2.jpg","storeId":1,"storePicture":"https://werw/w/ge.jpg","storeLogo":"https://werw/w/ge.jpg","storeBoard":"店铺公告","storeName":"测试店铺","storeAddress":"广东深圳"}
         * recommendation : [{"id":1,"name":"测试","price":25,"coverUrl":"1212"},{"id":19,"name":"测试19","price":25,"coverUrl":"http://img.redocn.com/sheying/20150213/mulanweichangcaoyuanfengjing_3951976.jpg"},{"id":20,"name":"测试20","price":25,"coverUrl":"1212"},{"id":22,"name":"测试22","price":25,"coverUrl":"1212"},{"id":24,"name":"测试24","price":25,"coverUrl":"1212"},{"id":25,"name":"测试25","price":25,"coverUrl":"1212"}]
         */

        private MallProductBean mallProduct;
        private List<RecommendationBean> recommendation;

        public MallProductBean getMallProduct() {
            return mallProduct;
        }

        public void setMallProduct(MallProductBean mallProduct) {
            this.mallProduct = mallProduct;
        }

        public List<RecommendationBean> getRecommendation() {
            return recommendation;
        }

        public void setRecommendation(List<RecommendationBean> recommendation) {
            this.recommendation = recommendation;
        }

        public static class MallProductBean {
            /**
             * name : 测试19
             * categoryId : 2
             * price : 66
             * marketPrice : 42.0
             * coverUrl : http://img.redocn.com/sheying/20150213/mulanweichangcaoyuanfengjing_3951976.jpg
             * sellNum : 12
             * transId : 6
             * remark : 阿斯顿发失地发生地方
             * productPicture : http://pic34.nipic.com/20131020/6704106_203943375000_2.jpg,http://pic13.nipic.com/20110409/7119492_114440620000_2.jpg,http://pic13.nipic.com/20110409/7119492_114440620000_2.jpg,http://pic13.nipic.com/20110409/7119492_114440620000_2.jpg
             * storeId : 1
             * storePicture : https://werw/w/ge.jpg
             * storeLogo : https://werw/w/ge.jpg
             * storeBoard : 店铺公告
             * storeName : 测试店铺
             * storeAddress : 广东深圳
             */

            private String name;
            private int categoryId;
            private int price;
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
        }

        public static class RecommendationBean {
            /**
             * id : 1
             * name : 测试
             * price : 25.0
             * coverUrl : 1212
             */

            private int id;
            private String name;
            private double price;
            private String coverUrl;

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

            public double getPrice() {
                return price;
            }

            public void setPrice(double price) {
                this.price = price;
            }

            public String getCoverUrl() {
                return coverUrl;
            }

            public void setCoverUrl(String coverUrl) {
                this.coverUrl = coverUrl;
            }
        }
    }
}
