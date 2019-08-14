package com.huohougongfu.app.Gson;

import java.util.List;

public class ChanPinCanShu {

    /**
     * msg : 操作成功
     * result : {"keys":["产地","厂名","品牌","配料表","食品添加剂","生产日期","包装种类","生产许可证编号","厂址","保质期","净含量","储存方式"]}
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
        private List<String> keys;

        public List<String> getKeys() {
            return keys;
        }

        public void setKeys(List<String> keys) {
            this.keys = keys;
        }
    }
}
