package com.huohougongfu.app.Gson;

public class RongYunUsetInfo {
    /**
     * msg : 操作成功
     * result : {"phone":"15927484518","nickName":null,"photo":"http://zhmp.oss-cn-shenzhen.aliyuncs.com/default.png"}
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
         * phone : 15927484518
         * nickName : null
         * photo : http://zhmp.oss-cn-shenzhen.aliyuncs.com/default.png
         */

        private String phone;
        private String nickName;
        private String photo;

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getNickName() {
            return nickName;
        }

        public void setNickName(String nickName) {
            this.nickName = nickName;
        }

        public String getPhoto() {
            return photo;
        }

        public void setPhoto(String photo) {
            this.photo = photo;
        }
    }
}
