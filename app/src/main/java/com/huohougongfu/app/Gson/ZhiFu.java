package com.huohougongfu.app.Gson;

public class ZhiFu {
    /**
     * msg : 操作成功
     * result : {"orderNo":"P201910301706417092201","orderId":1292}
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
         * orderNo : P201910301706417092201
         * orderId : 1292
         */

        private String orderNo;
        private int orderId;

        public String getOrderNo() {
            return orderNo;
        }

        public void setOrderNo(String orderNo) {
            this.orderNo = orderNo;
        }

        public int getOrderId() {
            return orderId;
        }

        public void setOrderId(int orderId) {
            this.orderId = orderId;
        }
    }
}
