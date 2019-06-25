package com.huohougongfu.app.Gson;

import java.util.List;

/**
 * 购物车数据的bean类
 */

public class ShoppingCarDataBean implements Cloneable {


    /**
     * msg : 操作成功
     * result : [{"price":0,"id":1,"storeName":"测试店铺","storeLogo":"https://werw/w/ge.jpg","productNum":0,"products":[{"productId":45,"standardId":2,"standard":"45g","price":1,"name":"商品标题","couverUrl":"http://img2.imgtn.bdimg.com/it/u=180868167,273146879&fm=26&gp=0.jpg","productNum":60}]},{"price":0,"id":2,"storeName":"测试店铺2","storeLogo":"https://werw/w/ge.jpg","productNum":0,"products":[{"productId":47,"standardId":1,"standard":"16g","price":75,"name":"商品标题","couverUrl":"封面图片","productNum":1}]}]
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

    public static class ResultBean implements Cloneable{
        /**
         * price : 0.0
         * id : 1
         * storeName : 测试店铺
         * storeLogo : https://werw/w/ge.jpg
         * productNum : 0
         * products : [{"productId":45,"standardId":2,"standard":"45g","price":1,"name":"商品标题","couverUrl":"http://img2.imgtn.bdimg.com/it/u=180868167,273146879&fm=26&gp=0.jpg","productNum":60}]
         */

        public ResultBean clone() {
            ResultBean o = null;
            try {
                o = (ResultBean) super.clone();
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
            }
            return o;
        }

        private double price;
        private int id;
        private String storeName;
        private String storeLogo;
        private int productNum;
        private boolean isSelect_shop;//店铺是否在购物车中被选中
        private List<ProductsBean> products;

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
        public boolean getIsSelect_shop() {
            return isSelect_shop;
        }

        public void setIsSelect_shop(boolean select_shop) {
            isSelect_shop = select_shop;
        }


        public static class ProductsBean {
            /**
             * productId : 45
             * standardId : 2
             * standard : 45g
             * price : 1.0
             * name : 商品标题
             * couverUrl : http://img2.imgtn.bdimg.com/it/u=180868167,273146879&fm=26&gp=0.jpg
             * productNum : 60
             */

            private int productId;
            private int standardId;
            private String standard;
            private double price;
            private String name;
            private String couverUrl;
            private boolean isSelect;
            private int productNum;

            public int getProductId() {
                return productId;
            }

            public void setProductId(int productId) {
                this.productId = productId;
            }

            public int getStandardId() {
                return standardId;
            }

            public void setStandardId(int standardId) {
                this.standardId = standardId;
            }

            public String getStandard() {
                return standard;
            }

            public void setStandard(String standard) {
                this.standard = standard;
            }

            public double getPrice() {
                return price;
            }

            public void setPrice(double price) {
                this.price = price;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getCouverUrl() {
                return couverUrl;
            }

            public void setCouverUrl(String couverUrl) {
                this.couverUrl = couverUrl;
            }

            public int getProductNum() {
                return productNum;
            }

            public void setProductNum(int productNum) {
                this.productNum = productNum;
            }

            public boolean getIsSelect() {
                return isSelect;
            }

            public void setIsSelect(boolean isSelect) {
                this.isSelect = isSelect;
            }
        }
    }
}
