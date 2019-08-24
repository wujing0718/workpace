package com.huohougongfu.app.Gson;

import java.util.List;

public class ShopCanShu {


    /**
     * msg : 操作成功
     * result : {"vals":["浙江","浙江温州皮革厂","大江南","密封袋包装","2019-12-09","常温","39683fff-rgfhj-05896","牛皮，熟料",0,"2015-5-6","ddd3569-ffaa890","浙江","材质皮革","23g","","茉莉茶"],"keys":["产地","厂名","品牌","包装种类","保质期","储存方式","产品标准号","配料表","食品添加剂","生产日期","生产许可证编号","厂址","材质","净含量","容量","类别"]}
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
        private List<String> vals;
        private List<Object> keys;

        public List<String> getVals() {
            return vals;
        }

        public void setVals(List<String> vals) {
            this.vals = vals;
        }

        public List<Object> getKeys() {
            return keys;
        }

        public void setKeys(List<Object> keys) {
            this.keys = keys;
        }
    }
}
