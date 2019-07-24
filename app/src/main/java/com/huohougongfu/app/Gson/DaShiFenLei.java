package com.huohougongfu.app.Gson;

import java.util.List;

public class DaShiFenLei {
    /**
     * msg : 操作成功
     * result : {"masterCategory":["中级评茶师","高级评茶师","中级制茶师","高级制茶师","中级茶艺师","高级茶艺师","匠人","其他"]}
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
        private List<String> masterCategory;

        public List<String> getMasterCategory() {
            return masterCategory;
        }

        public void setMasterCategory(List<String> masterCategory) {
            this.masterCategory = masterCategory;
        }
    }
}
