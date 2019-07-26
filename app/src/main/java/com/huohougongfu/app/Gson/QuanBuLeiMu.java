package com.huohougongfu.app.Gson;

import java.util.List;

public class QuanBuLeiMu {


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
         * name : 特约品牌
         * list : [{"id":2,"name":"品牌名称","isSpecial":"1","img":"图片","story":"阿斯蒂芬","order":"0","createTime":"2019-06-20T08:47:09.000+0000","updateTime":"2019-07-19T01:38:59.000+0000","address":"地址","isCollection":null,"productList":null}]
         */

        private String name;
        private List<ListBean> list;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public static class ListBean {
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

            private String level;
            private String photo;
            private String storeName;
            private String storeLogo;
            private String ico;
            private String pic;
            private int mId;


            private String createTime;
            private String updateTime;
            private String address;
            private Object isCollection;
            private Object productList;
            private List<ListBean> list;

            public int getmId() {
                return mId;
            }

            public void setmId(int mId) {
                this.mId = mId;
            }

            public String getPic() {
                return pic;
            }

            public void setPic(String pic) {
                this.pic = pic;
            }

            public String getIco() {
                return ico;
            }

            public void setIco(String ico) {
                this.ico = ico;
            }

            public List<ListBean> getList() {
                return list;
            }

            public void setList(List<ListBean> list) {
                this.list = list;
            }

            public String getLevel() {
                return level;
            }

            public void setLevel(String level) {
                this.level = level;
            }

            public String getPhoto() {
                return photo;
            }

            public void setPhoto(String photo) {
                this.photo = photo;
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
