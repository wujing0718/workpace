package com.huohougongfu.app.Gson;

import java.io.Serializable;
import java.util.List;

public class ZhuanKeVIP implements Serializable{

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

    public static class ResultBean implements Serializable{

        private RuleBean rule;
        private int status;
        private List<EarnPordutBean> earnPordut;

        public RuleBean getRule() {
            return rule;
        }

        public void setRule(RuleBean rule) {
            this.rule = rule;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public List<EarnPordutBean> getEarnPordut() {
            return earnPordut;
        }

        public void setEarnPordut(List<EarnPordutBean> earnPordut) {
            this.earnPordut = earnPordut;
        }

        public static class RuleBean implements Serializable{

            private int id;
            private int mId;
            private String regulation;
            private String picture;
            private String slogan;
            private String createTime;
            private Object updateTime;

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

            public String getRegulation() {
                return regulation;
            }

            public void setRegulation(String regulation) {
                this.regulation = regulation;
            }

            public String getPicture() {
                return picture;
            }

            public void setPicture(String picture) {
                this.picture = picture;
            }

            public String getSlogan() {
                return slogan;
            }

            public void setSlogan(String slogan) {
                this.slogan = slogan;
            }

            public String getCreateTime() {
                return createTime;
            }

            public void setCreateTime(String createTime) {
                this.createTime = createTime;
            }

            public Object getUpdateTime() {
                return updateTime;
            }

            public void setUpdateTime(Object updateTime) {
                this.updateTime = updateTime;
            }
        }

        public static class EarnPordutBean implements Serializable {

            private int id;
            private String name;
            private String pic;
            private double marketPrice;
            private String introduce;
            private Object createTime;
            private Object updateTime;

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

            public String getPic() {
                return pic;
            }

            public void setPic(String pic) {
                this.pic = pic;
            }

            public double getMarketPrice() {
                return marketPrice;
            }

            public void setMarketPrice(double marketPrice) {
                this.marketPrice = marketPrice;
            }

            public String getIntroduce() {
                return introduce;
            }

            public void setIntroduce(String introduce) {
                this.introduce = introduce;
            }

            public Object getCreateTime() {
                return createTime;
            }

            public void setCreateTime(Object createTime) {
                this.createTime = createTime;
            }

            public Object getUpdateTime() {
                return updateTime;
            }

            public void setUpdateTime(Object updateTime) {
                this.updateTime = updateTime;
            }
        }
    }
}
