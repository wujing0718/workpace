package com.huohougongfu.app.Gson;

import java.io.Serializable;
import java.util.List;

public class MaiChaDetail implements Serializable{
    /**
     * msg : 操作成功
     * result : [{"id":1,"name":"白茶","productPrice":10,"weight":70,"commodityDescription":"真的很好喝的白茶","masterGraph":"http://oss.irving.net.cn/tea/1567070045063.png","detailsFigureOne":"http://hotkungfu.oss-cn-beijing.aliyuncs.com/picture/commodity_one.jpg","detailsFigureTwo":"http://hotkungfu.oss-cn-beijing.aliyuncs.com/picture/commodity_two.jpg","detailsFigureThree":"http://hotkungfu.oss-cn-beijing.aliyuncs.com/picture/commodity_three.jpg","createTime":"2019-08-29T09:14:22.000+0000","updateTime":"2019-08-30T08:29:56.000+0000"}]
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

    public static class ResultBean implements Serializable{
        /**
         * id : 1
         * name : 白茶
         * productPrice : 10.0
         * weight : 70
         * commodityDescription : 真的很好喝的白茶
         * masterGraph : http://oss.irving.net.cn/tea/1567070045063.png
         * detailsFigureOne : http://hotkungfu.oss-cn-beijing.aliyuncs.com/picture/commodity_one.jpg
         * detailsFigureTwo : http://hotkungfu.oss-cn-beijing.aliyuncs.com/picture/commodity_two.jpg
         * detailsFigureThree : http://hotkungfu.oss-cn-beijing.aliyuncs.com/picture/commodity_three.jpg
         * createTime : 2019-08-29T09:14:22.000+0000
         * updateTime : 2019-08-30T08:29:56.000+0000
         */

        private int id;
        private String name;
        private double productPrice;
        private int weight;
        private String commodityDescription;
        private String masterGraph;
        private String detailsFigureOne;
        private String detailsFigureTwo;
        private String detailsFigureThree;
        private String createTime;
        private String updateTime;

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

        public double getProductPrice() {
            return productPrice;
        }

        public void setProductPrice(double productPrice) {
            this.productPrice = productPrice;
        }

        public int getWeight() {
            return weight;
        }

        public void setWeight(int weight) {
            this.weight = weight;
        }

        public String getCommodityDescription() {
            return commodityDescription;
        }

        public void setCommodityDescription(String commodityDescription) {
            this.commodityDescription = commodityDescription;
        }

        public String getMasterGraph() {
            return masterGraph;
        }

        public void setMasterGraph(String masterGraph) {
            this.masterGraph = masterGraph;
        }

        public String getDetailsFigureOne() {
            return detailsFigureOne;
        }

        public void setDetailsFigureOne(String detailsFigureOne) {
            this.detailsFigureOne = detailsFigureOne;
        }

        public String getDetailsFigureTwo() {
            return detailsFigureTwo;
        }

        public void setDetailsFigureTwo(String detailsFigureTwo) {
            this.detailsFigureTwo = detailsFigureTwo;
        }

        public String getDetailsFigureThree() {
            return detailsFigureThree;
        }

        public void setDetailsFigureThree(String detailsFigureThree) {
            this.detailsFigureThree = detailsFigureThree;
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
