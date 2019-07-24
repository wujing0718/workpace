package com.huohougongfu.app.Gson;

import java.util.List;

public class ShopFenLei {

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
        private List<ProductCategoryBean> productCategory;

        public List<ProductCategoryBean> getProductCategory() {
            return productCategory;
        }

        public void setProductCategory(List<ProductCategoryBean> productCategory) {
            this.productCategory = productCategory;
        }

        public static class ProductCategoryBean {
            /**
             * id : 1
             * parentId : 0
             * name : 茶叶
             * catDir : 1
             * showOrder : 0
             * createBy : 1
             * createTime : 2019-06-14T10:34:12.000+0000
             * updateBy : 2
             * updateTime : 2019-07-21T06:31:28.000+0000
             * ico : 图标
             * keyWord : 关键字
             * productCount : 20
             */

            private int id;
            private int parentId;
            private String name;
            private int catDir;
            private int showOrder;
            private int createBy;
            private String createTime;
            private int updateBy;
            private String updateTime;
            private String ico;
            private String keyWord;
            private int productCount;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public int getParentId() {
                return parentId;
            }

            public void setParentId(int parentId) {
                this.parentId = parentId;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public int getCatDir() {
                return catDir;
            }

            public void setCatDir(int catDir) {
                this.catDir = catDir;
            }

            public int getShowOrder() {
                return showOrder;
            }

            public void setShowOrder(int showOrder) {
                this.showOrder = showOrder;
            }

            public int getCreateBy() {
                return createBy;
            }

            public void setCreateBy(int createBy) {
                this.createBy = createBy;
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

            public String getIco() {
                return ico;
            }

            public void setIco(String ico) {
                this.ico = ico;
            }

            public String getKeyWord() {
                return keyWord;
            }

            public void setKeyWord(String keyWord) {
                this.keyWord = keyWord;
            }

            public int getProductCount() {
                return productCount;
            }

            public void setProductCount(int productCount) {
                this.productCount = productCount;
            }
        }
    }
}
