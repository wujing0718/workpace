package com.huohougongfu.app.Gson;

import java.util.List;

public class DSZhuanChang {

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
        private List<AllMasterBean> allMaster;
        private List<YourLikeBean> yourLike;

        public List<AllMasterBean> getAllMaster() {
            return allMaster;
        }

        public void setAllMaster(List<AllMasterBean> allMaster) {
            this.allMaster = allMaster;
        }

        public List<YourLikeBean> getYourLike() {
            return yourLike;
        }

        public void setYourLike(List<YourLikeBean> yourLike) {
            this.yourLike = yourLike;
        }

        public static class AllMasterBean {
            /**
             * id : 2
             * mId : 17
             * name : 大师名称
             * portrait : 大师师片
             * photo : null
             * level : 高级茶艺师
             * specialty : 白茶
             * status : 1
             * introduceContent : 大师介绍1
             * createTime : 2019-07-16T01:24:48.000+0000
             * updateTime : 2019-07-19T06:09:53.000+0000
             * masterAddress : 深圳
             * storeId : null
             * isMerchant : true
             * count : 0
             * merchant : true
             */

            private int id;
            private int mId;
            private String name;
            private String portrait;
            private Object photo;
            private String level;
            private String specialty;
            private int status;
            private String introduceContent;
            private String createTime;
            private String updateTime;
            private String masterAddress;
            private Object storeId;
            private boolean isMerchant;
            private int count;
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

            public Object getPhoto() {
                return photo;
            }

            public void setPhoto(Object photo) {
                this.photo = photo;
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

            public String getMasterAddress() {
                return masterAddress;
            }

            public void setMasterAddress(String masterAddress) {
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

            public int getCount() {
                return count;
            }

            public void setCount(int count) {
                this.count = count;
            }

            public boolean isMerchant() {
                return merchant;
            }

            public void setMerchant(boolean merchant) {
                this.merchant = merchant;
            }
        }

        public static class YourLikeBean {
            /**
             * id : 2
             * mId : 17
             * name : 大师名称
             * portrait : 大师师片
             * photo : http://zhmp.oss-cn-shenzhen.aliyuncs.com/default.png
             * level : 高级茶艺师
             * specialty : 白茶
             * status : 1
             * introduceContent : 大师介绍1
             * createTime : 2019-07-16T01:24:48.000+0000
             * updateTime : 2019-07-19T06:09:53.000+0000
             * masterAddress : 深圳
             * storeId : null
             * isMerchant : true
             * count : 0
             * merchant : true
             */

            private int id;
            private int mId;
            private String name;
            private String portrait;
            private String photo;
            private String level;
            private String specialty;
            private int status;
            private String introduceContent;
            private String createTime;
            private String updateTime;
            private String masterAddress;
            private Object storeId;
            private boolean isMerchant;
            private int count;
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

            public String getPhoto() {
                return photo;
            }

            public void setPhoto(String photo) {
                this.photo = photo;
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

            public String getMasterAddress() {
                return masterAddress;
            }

            public void setMasterAddress(String masterAddress) {
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

            public int getCount() {
                return count;
            }

            public void setCount(int count) {
                this.count = count;
            }

            public boolean isMerchant() {
                return merchant;
            }

            public void setMerchant(boolean merchant) {
                this.merchant = merchant;
            }
        }
    }
}
