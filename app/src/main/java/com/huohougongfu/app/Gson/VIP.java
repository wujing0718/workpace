package com.huohougongfu.app.Gson;

import java.util.List;

public class VIP {

    /**
     * msg : 操作成功
     * result : {"vipLevel":"0","totalIntegralNum":0,"customerService":false,"integral":100,"vipPercent":1,"stickyPermissions":false,"isMerchant":false,"teaRiceWelfare":false,"preventPermissions":false,"isVip":true,"integralRecord":[]}
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
         * totalIntegralNum : 0
         * customerService : false
         * integral : 100
         * vipPercent : 1
         * stickyPermissions : false
         * isMerchant : false
         * teaRiceWelfare : false
         * preventPermissions : false
         * isVip : true
         * integralRecord : []
         */

        private String vipLevel;
        private int totalIntegralNum;
        private boolean customerService;
        private int integral;
        private int vipPercent;
        private boolean stickyPermissions;
        private boolean isMerchant;
        private boolean teaRiceWelfare;
        private boolean preventPermissions;
        private boolean isVip;
        private List<?> integralRecord;

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

        public boolean isStickyPermissions() {
            return stickyPermissions;
        }

        public void setStickyPermissions(boolean stickyPermissions) {
            this.stickyPermissions = stickyPermissions;
        }

        public boolean isIsMerchant() {
            return isMerchant;
        }

        public void setIsMerchant(boolean isMerchant) {
            this.isMerchant = isMerchant;
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

        public boolean isIsVip() {
            return isVip;
        }

        public void setIsVip(boolean isVip) {
            this.isVip = isVip;
        }

        public List<?> getIntegralRecord() {
            return integralRecord;
        }

        public void setIntegralRecord(List<?> integralRecord) {
            this.integralRecord = integralRecord;
        }
    }
}
