package com.huohougongfu.app.Gson;

public class Register {
    /**
     * msg : 操作成功
     * result : {"code":200,"errorMessage":null,"token":"0AK40ySpdyJuU8FL5OIB1+aULa9ikgcawPKgMF6uCiw7+bNhzO0CcDF+4xYZVVQ5yGCsm/J7Qk2F+NgLR3fP5XJcdMKfLwUp","userId":"18910328110"}
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
         * code : 200
         * errorMessage : null
         * token : 0AK40ySpdyJuU8FL5OIB1+aULa9ikgcawPKgMF6uCiw7+bNhzO0CcDF+4xYZVVQ5yGCsm/J7Qk2F+NgLR3fP5XJcdMKfLwUp
         * userId : 18910328110
         */

        private int code;
        private Object errorMessage;
        private String token;
        private String userId;

        public int getCode() {
            return code;
        }

        public void setCode(int code) {
            this.code = code;
        }

        public Object getErrorMessage() {
            return errorMessage;
        }

        public void setErrorMessage(Object errorMessage) {
            this.errorMessage = errorMessage;
        }

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }
    }
}
