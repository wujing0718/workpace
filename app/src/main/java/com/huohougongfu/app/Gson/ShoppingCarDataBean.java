package com.huohougongfu.app.Gson;

import java.util.List;

/**
 * 购物车数据的bean类
 */

public class ShoppingCarDataBean implements Cloneable {

    /**
     * msg : 操作成功
     * result : [{"price":0,"id":2,"storeName":"测试店铺2","storeLogo":"https://werw/w/ge.jpg","productNum":0,"products":[{"id":47,"name":"商品标题","price":75,"storeId":2},{"id":46,"name":"商品","price":50,"storeId":2},{"id":45,"name":"商品标题","price":1,"storeId":2},{"id":44,"name":"商品标题","price":25.45,"storeId":2},{"id":43,"name":"商品标题","price":25.45,"storeId":2}]},{"price":0,"id":1,"storeName":"测试店铺","storeLogo":"https://werw/w/ge.jpg","productNum":0,"products":[{"id":22,"name":"测试22","price":25,"storeId":1},{"id":23,"name":"测试23","price":25,"storeId":1},{"id":24,"name":"测试24","price":25,"storeId":1}]}]
     * status : 1
     */

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
        /**
         * price : 0.0
         * id : 2
         * storeName : 测试店铺2
         * storeLogo : https://werw/w/ge.jpg
         * productNum : 0
         * products : [{"id":47,"name":"商品标题","price":75,"storeId":2},{"id":46,"name":"商品","price":50,"storeId":2},{"id":45,"name":"商品标题","price":1,"storeId":2},{"id":44,"name":"商品标题","price":25.45,"storeId":2},{"id":43,"name":"商品标题","price":25.45,"storeId":2}]
         */

        private double price;
        private int id;
        private String storeName;
        private String storeLogo;
        private int productNum;
        private List<ProductsBean> products;

        private boolean isSelect_shop;      //店铺是否在购物车中被选中

        public boolean getIsSelect_shop() {
            return isSelect_shop;
        }

        public void setIsSelect_shop(boolean select_shop) {
            isSelect_shop = select_shop;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getStoreName() {
            return storeName;
        }

        public void setStoreName(String storeName) {
            this.storeName = storeName;
        }

        public String getStoreLogo() {
            return storeLogo;
        }

        public void setStoreLogo(String storeLogo) {
            this.storeLogo = storeLogo;
        }

        public int getProductNum() {
            return productNum;
        }

        public void setProductNum(int productNum) {
            this.productNum = productNum;
        }

        public List<ProductsBean> getProducts() {
            return products;
        }

        public void setProducts(List<ProductsBean> products) {
            this.products = products;
        }

        public static class ProductsBean {
            /**
             * id : 47
             * name : 商品标题
             * price : 75.0
             * storeId : 2
             */

            private int id;
            private String name;
            private double price;
            private int storeId;
            private int num;
            private int stock;
            private String coverUrl;
            private boolean isSelect;        //商品是否在购物车中被选中

            public boolean getIsSelect() {
                return isSelect;
            }

            public void setIsSelect(boolean isSelect) {
                this.isSelect = isSelect;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public int getNum() {
                return num;
            }

            public void setNum(int num) {
                this.num = num;
            }

            public int getStock() {
                return stock;
            }

            public void setStock(int num) {
                this.stock = stock;
            }

            public String getCoverUrl() {
                return coverUrl;
            }

            public void setCoverUrl(String coverUrl) {
                this.coverUrl = coverUrl;
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

            public int getStoreId() {
                return storeId;
            }

            public void setStoreId(int storeId) {
                this.storeId = storeId;
            }
        }
    }
}
