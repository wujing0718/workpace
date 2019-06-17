package com.huohougongfu.app.Gson;

import java.util.List;

public class BannerGson {
    /**
     * msg : 操作成功
     * result : [{"id":1,"pictureUrl":"http://oss.irving.net.cn/tea/1559210634018.jpg","productId":"1","showOrder":2,"showWhere":1,"isDelete":0,"createBy":45,"createTime":null,"updateBy":null,"isShow":1,"link":null,"updateTime":null},{"id":2,"pictureUrl":"http://oss.irving.net.cn/tea/1559210634018.jpg","productId":"1","showOrder":2,"showWhere":1,"isDelete":0,"createBy":45,"createTime":null,"updateBy":null,"isShow":1,"link":null,"updateTime":null},{"id":8,"pictureUrl":"图片路径图片路径","productId":"1","showOrder":2,"showWhere":1,"isDelete":0,"createBy":1,"createTime":null,"updateBy":null,"isShow":1,"link":"连接路径连接路径","updateTime":null}]
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
         * id : 1
         * pictureUrl : http://oss.irving.net.cn/tea/1559210634018.jpg
         * productId : 1
         * showOrder : 2
         * showWhere : 1
         * isDelete : 0
         * createBy : 45
         * createTime : null
         * updateBy : null
         * isShow : 1
         * link : null
         * updateTime : null
         */

        private int id;
        private String pictureUrl;
        private String productId;
        private int showOrder;
        private int showWhere;
        private int isDelete;
        private int createBy;
        private Object createTime;
        private Object updateBy;
        private int isShow;
        private Object link;
        private Object updateTime;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getPictureUrl() {
            return pictureUrl;
        }

        public void setPictureUrl(String pictureUrl) {
            this.pictureUrl = pictureUrl;
        }

        public String getProductId() {
            return productId;
        }

        public void setProductId(String productId) {
            this.productId = productId;
        }

        public int getShowOrder() {
            return showOrder;
        }

        public void setShowOrder(int showOrder) {
            this.showOrder = showOrder;
        }

        public int getShowWhere() {
            return showWhere;
        }

        public void setShowWhere(int showWhere) {
            this.showWhere = showWhere;
        }

        public int getIsDelete() {
            return isDelete;
        }

        public void setIsDelete(int isDelete) {
            this.isDelete = isDelete;
        }

        public int getCreateBy() {
            return createBy;
        }

        public void setCreateBy(int createBy) {
            this.createBy = createBy;
        }

        public Object getCreateTime() {
            return createTime;
        }

        public void setCreateTime(Object createTime) {
            this.createTime = createTime;
        }

        public Object getUpdateBy() {
            return updateBy;
        }

        public void setUpdateBy(Object updateBy) {
            this.updateBy = updateBy;
        }

        public int getIsShow() {
            return isShow;
        }

        public void setIsShow(int isShow) {
            this.isShow = isShow;
        }

        public Object getLink() {
            return link;
        }

        public void setLink(Object link) {
            this.link = link;
        }

        public Object getUpdateTime() {
            return updateTime;
        }

        public void setUpdateTime(Object updateTime) {
            this.updateTime = updateTime;
        }
    }
}
