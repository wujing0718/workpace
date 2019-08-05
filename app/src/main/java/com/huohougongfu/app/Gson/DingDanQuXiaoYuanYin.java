package com.huohougongfu.app.Gson;

import java.util.List;

public class DingDanQuXiaoYuanYin {
    /**
     * msg : 操作成功
     * result : [{"id":1,"reason":"不喜欢/不想要"},{"id":2,"reason":"信息填写错误，重新拍"},{"id":3,"reason":"卖家缺货"},{"id":4,"reason":"其他原因"}]
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
         * reason : 不喜欢/不想要
         */

        private int id;
        private String reason;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getReason() {
            return reason;
        }

        public void setReason(String reason) {
            this.reason = reason;
        }
    }
}
