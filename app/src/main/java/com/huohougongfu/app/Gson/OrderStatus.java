package com.huohougongfu.app.Gson;

public class OrderStatus {
    /**
     * msg : 操作成功
     * result : {"notDeliverOrder":5,"waitingForEvaluation":0,"notPayOrder":6,"waitingForReceipt":1}
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
         * notDeliverOrder : 5
         * waitingForEvaluation : 0
         * notPayOrder : 6
         * waitingForReceipt : 1
         */

        private int notDeliverOrder;
        private int waitingForEvaluation;
        private int notPayOrder;
        private int waitingForReceipt;

        public int getNotDeliverOrder() {
            return notDeliverOrder;
        }

        public void setNotDeliverOrder(int notDeliverOrder) {
            this.notDeliverOrder = notDeliverOrder;
        }

        public int getWaitingForEvaluation() {
            return waitingForEvaluation;
        }

        public void setWaitingForEvaluation(int waitingForEvaluation) {
            this.waitingForEvaluation = waitingForEvaluation;
        }

        public int getNotPayOrder() {
            return notPayOrder;
        }

        public void setNotPayOrder(int notPayOrder) {
            this.notPayOrder = notPayOrder;
        }

        public int getWaitingForReceipt() {
            return waitingForReceipt;
        }

        public void setWaitingForReceipt(int waitingForReceipt) {
            this.waitingForReceipt = waitingForReceipt;
        }
    }
}
