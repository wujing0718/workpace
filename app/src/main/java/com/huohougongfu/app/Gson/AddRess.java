package com.huohougongfu.app.Gson;

import java.util.List;

public class AddRess {
    /**
     * msg : 操作成功
     * result : [{"id":60,"provinceName":"广东省","cityName":"深圳市","areaName":"龙岗区","detailAddr":"南联路75号金晖连创社区","receiverName":"吴敬","phone":"13888888888","isDefault":0,"createBy":43,"createTime":"2019-06-26T08:19:54.000+0000","updateTime":"2019-06-26T08:27:34.000+0000"},{"id":61,"provinceName":"湖北省","cityName":"武汉市","areaName":"\b洪山区","detailAddr":"\b光谷","receiverName":"测试\b1","phone":"13888888888","isDefault":0,"createBy":43,"createTime":"2019-06-26T08:27:34.000+0000","updateTime":"2019-06-26T09:26:48.000+0000"}]
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
         * id : 60
         * provinceName : 广东省
         * cityName : 深圳市
         * areaName : 龙岗区
         * detailAddr : 南联路75号金晖连创社区
         * receiverName : 吴敬
         * phone : 13888888888
         * isDefault : 0
         * createBy : 43
         * createTime : 2019-06-26T08:19:54.000+0000
         * updateTime : 2019-06-26T08:27:34.000+0000
         */

        private int id;
        private String provinceName;
        private String cityName;
        private String areaName;
        private String detailAddr;
        private String receiverName;
        private String phone;
        private int isDefault;
        private int createBy;
        private String createTime;
        private String updateTime;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getProvinceName() {
            return provinceName;
        }

        public void setProvinceName(String provinceName) {
            this.provinceName = provinceName;
        }

        public String getCityName() {
            return cityName;
        }

        public void setCityName(String cityName) {
            this.cityName = cityName;
        }

        public String getAreaName() {
            return areaName;
        }

        public void setAreaName(String areaName) {
            this.areaName = areaName;
        }

        public String getDetailAddr() {
            return detailAddr;
        }

        public void setDetailAddr(String detailAddr) {
            this.detailAddr = detailAddr;
        }

        public String getReceiverName() {
            return receiverName;
        }

        public void setReceiverName(String receiverName) {
            this.receiverName = receiverName;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public int getIsDefault() {
            return isDefault;
        }

        public void setIsDefault(int isDefault) {
            this.isDefault = isDefault;
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

        public String getUpdateTime() {
            return updateTime;
        }

        public void setUpdateTime(String updateTime) {
            this.updateTime = updateTime;
        }
    }
}
