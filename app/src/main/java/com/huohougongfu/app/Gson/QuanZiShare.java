package com.huohougongfu.app.Gson;

public class QuanZiShare {


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
         * photo : http://thirdqq.qlogo.cn/g?b=oidb&k=uB1ld3na9fRwnag05AwYxw&s=100&t=1555725742
         * title : 动态分享
         * url : http://www.hotkungfu-tea.com:8088/circlepage.html?type=1&dataId=117
         * content : 点击进入页面查看
         */

        private String photo;
        private String title;
        private String url;
        private String content;

        public String getPhoto() {
            return photo;
        }

        public void setPhoto(String photo) {
            this.photo = photo;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }
    }
}
