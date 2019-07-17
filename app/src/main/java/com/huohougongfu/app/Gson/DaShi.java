package com.huohougongfu.app.Gson;

import java.util.List;

public class DaShi {
    /**
     * msg : 操作成功
     * result : [{"id":2,"mId":17,"name":null,"portrait":"大师图片","level":"高级茶艺师","specialty":"白茶","status":0,"introduceContent":"大师介绍1","createTime":"2019-07-16T01:24:48.000+0000","updateTime":"2019-07-16T03:25:18.000+0000","masterAddress":null,"storeId":null,"isMerchant":true,"merchant":true}]
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
         * id : 2
         * mId : 17
         * name : null
         * portrait : 大师图片
         * level : 高级茶艺师
         * specialty : 白茶
         * status : 0
         * introduceContent : 大师介绍1
         * createTime : 2019-07-16T01:24:48.000+0000
         * updateTime : 2019-07-16T03:25:18.000+0000
         * masterAddress : null
         * storeId : null
         * isMerchant : true
         * merchant : true
         */

        private int id;
        private int mId;
        private String name;
        private String portrait;
        private String level;
        private String specialty;
        private int status;
        private String introduceContent;
        private String createTime;
        private String updateTime;
        private Object masterAddress;
        private Object storeId;
        private boolean isMerchant;
        private boolean merchant;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getMId() {
            return mId;
        }

        public void setMId(int mId) {
            this.mId = mId;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPortrait() {
            return portrait;
        }

        public void setPortrait(String portrait) {
            this.portrait = portrait;
        }

        public String getLevel() {
            return level;
        }

        public void setLevel(String level) {
            this.level = level;
        }

        public String getSpecialty() {
            return specialty;
        }

        public void setSpecialty(String specialty) {
            this.specialty = specialty;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public String getIntroduceContent() {
            return introduceContent;
        }

        public void setIntroduceContent(String introduceContent) {
            this.introduceContent = introduceContent;
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

        public Object getMasterAddress() {
            return masterAddress;
        }

        public void setMasterAddress(Object masterAddress) {
            this.masterAddress = masterAddress;
        }

        public Object getStoreId() {
            return storeId;
        }

        public void setStoreId(Object storeId) {
            this.storeId = storeId;
        }

        public boolean isIsMerchant() {
            return isMerchant;
        }

        public void setIsMerchant(boolean isMerchant) {
            this.isMerchant = isMerchant;
        }

        public boolean isMerchant() {
            return merchant;
        }

        public void setMerchant(boolean merchant) {
            this.merchant = merchant;
        }
    }
}
