package com.huohougongfu.app.Gson;

public class ZhuanZengChengGong {

    /**
     * msg : 操作成功
     * result : {"url":"www.baidu.com","tId":13}
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
         * url : www.baidu.com
         * tId : 13
         */

        private String url;
        private int tId;

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public int getTId() {
            return tId;
        }

        public void setTId(int tId) {
            this.tId = tId;
        }
    }
}
