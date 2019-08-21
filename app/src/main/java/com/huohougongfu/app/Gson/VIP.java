package com.huohougongfu.app.Gson;

import java.util.List;

public class VIP {

    /**
     * msg : 操作成功
     * result : {"vipLevel":"0","totalIntegralNum":20,"customerService":false,"stickyPermissions":false,"teaRiceWelfare":false,"preventPermissions":false,"integral":60,"vipPercent":1,"isMerchant":false,"isVip":true,"integralRecord":[{"id":137,"mId":43,"num":20,"comment":"每日签到","createTime":"2019-08-21T06:20:37.000+0000","updateTime":"2019-08-21T02:33:31.000+0000"}]}
     * status : 1
     */

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
        /**
         * vipLevel : 0
         * totalIntegralNum : 20
         * customerService : false
         * stickyPermissions : false
         * teaRiceWelfare : false
         * preventPermissions : false
         * integral : 60
         * vipPercent : 1
         * isMerchant : false
         * isVip : true
         * integralRecord : [{"id":137,"mId":43,"num":20,"comment":"每日签到","createTime":"2019-08-21T06:20:37.000+0000","updateTime":"2019-08-21T02:33:31.000+0000"}]
         */

        private String vipLevel;
        private int totalIntegralNum;
        private boolean customerService;
        private boolean stickyPermissions;
        private boolean teaRiceWelfare;
        private boolean preventPermissions;
        private int integral;
        private int vipPercent;
        private boolean isMerchant;
        private boolean isVip;
        private List<IntegralRecordBean> integralRecord;

        public String getVipLevel() {
            return vipLevel;
        }

        public void setVipLevel(String vipLevel) {
            this.vipLevel = vipLevel;
        }

        public int getTotalIntegralNum() {
            return totalIntegralNum;
        }

        public void setTotalIntegralNum(int totalIntegralNum) {
            this.totalIntegralNum = totalIntegralNum;
        }

        public boolean isCustomerService() {
            return customerService;
        }

        public void setCustomerService(boolean customerService) {
            this.customerService = customerService;
        }

        public boolean isStickyPermissions() {
            return stickyPermissions;
        }

        public void setStickyPermissions(boolean stickyPermissions) {
            this.stickyPermissions = stickyPermissions;
        }

        public boolean isTeaRiceWelfare() {
            return teaRiceWelfare;
        }

        public void setTeaRiceWelfare(boolean teaRiceWelfare) {
            this.teaRiceWelfare = teaRiceWelfare;
        }

        public boolean isPreventPermissions() {
            return preventPermissions;
        }

        public void setPreventPermissions(boolean preventPermissions) {
            this.preventPermissions = preventPermissions;
        }

        public int getIntegral() {
            return integral;
        }

        public void setIntegral(int integral) {
            this.integral = integral;
        }

        public int getVipPercent() {
            return vipPercent;
        }

        public void setVipPercent(int vipPercent) {
            this.vipPercent = vipPercent;
        }

        public boolean isIsMerchant() {
            return isMerchant;
        }

        public void setIsMerchant(boolean isMerchant) {
            this.isMerchant = isMerchant;
        }

        public boolean isIsVip() {
            return isVip;
        }

        public void setIsVip(boolean isVip) {
            this.isVip = isVip;
        }

        public List<IntegralRecordBean> getIntegralRecord() {
            return integralRecord;
        }

        public void setIntegralRecord(List<IntegralRecordBean> integralRecord) {
            this.integralRecord = integralRecord;
        }

        public static class IntegralRecordBean {
            /**
             * id : 137
             * mId : 43
             * num : 20
             * comment : 每日签到
             * createTime : 2019-08-21T06:20:37.000+0000
             * updateTime : 2019-08-21T02:33:31.000+0000
             */

            private int id;
            private int mId;
            private int num;
            private String comment;
            private String createTime;
            private String updateTime;

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

            public int getNum() {
                return num;
            }

            public void setNum(int num) {
                this.num = num;
            }

            public String getComment() {
                return comment;
            }

            public void setComment(String comment) {
                this.comment = comment;
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
}
