package com.huohougongfu.app.Gson;

import java.util.List;

public class BankLIst {

    /**
     * msg : 操作成功
     * result : [{"id":2,"bankName":"招商银行","bankCode":"CMB"},{"id":3,"bankName":"建设银行","bankCode":"CCB"},{"id":4,"bankName":"交通银行","bankCode":"BOCOM"},{"id":5,"bankName":"邮储银行","bankCode":"PSBC"},{"id":6,"bankName":"工商银行","bankCode":"ICBC"},{"id":7,"bankName":"农业银行","bankCode":"ABC"},{"id":8,"bankName":"中国银行","bankCode":"BOC"},{"id":9,"bankName":"中信银行","bankCode":"CITIC"},{"id":10,"bankName":"光大银行","bankCode":"CEB"},{"id":11,"bankName":"华夏银行","bankCode":" HXB"},{"id":12,"bankName":"民生银行","bankCode":"CMSB"},{"id":13,"bankName":"广发银行","bankCode":"CGB"},{"id":14,"bankName":"平安银行","bankCode":"SZD"},{"id":15,"bankName":"星展银行","bankCode":"DBS"},{"id":16,"bankName":"恒生银行","bankCode":"HSBC"},{"id":17,"bankName":"渣打银行","bankCode":"SCBFF"},{"id":18,"bankName":"汇丰银行","bankCode":"HSBC"},{"id":19,"bankName":"东亚银行","bankCode":"HKBEA"},{"id":20,"bankName":"花旗银行","bankCode":""},{"id":21,"bankName":"浙商银行","bankCode":"CZB"},{"id":22,"bankName":"恒丰银行","bankCode":"HFB"},{"id":23,"bankName":"浦东发展银行","bankCode":"SPDB"},{"id":24,"bankName":"兴业银行","bankCode":"CIB"},{"id":26,"bankName":"齐鲁银行","bankCode":"QLB"},{"id":27,"bankName":"烟台银行","bankCode":"YTB"},{"id":28,"bankName":"淮坊银行","bankCode":"WFB"},{"id":31,"bankName":"渤海银行","bankCode":""},{"id":32,"bankName":"上海银行","bankCode":"BOS"},{"id":33,"bankName":"厦门银行","bankCode":""},{"id":34,"bankName":"北京银行","bankCode":"BCCB"},{"id":35,"bankName":"福建海峡银行","bankCode":""},{"id":36,"bankName":"吉林银行","bankCode":""},{"id":38,"bankName":"宁波银行","bankCode":"NBCB"},{"id":39,"bankName":"焦作市商业银行","bankCode":""},{"id":40,"bankName":"温州银行","bankCode":""},{"id":41,"bankName":"广州银行","bankCode":""},{"id":42,"bankName":"汉口银行","bankCode":""},{"id":43,"bankName":"龙江银行","bankCode":""},{"id":44,"bankName":"盛京银行","bankCode":""},{"id":45,"bankName":"洛阳银行","bankCode":""},{"id":46,"bankName":"辽阳银行","bankCode":""},{"id":47,"bankName":"大连银行","bankCode":"BODL"},{"id":48,"bankName":"苏州银行","bankCode":""},{"id":49,"bankName":"河北银行","bankCode":""},{"id":50,"bankName":"杭州银行","bankCode":"HCCB"},{"id":51,"bankName":"南京银行","bankCode":""},{"id":52,"bankName":"东莞银行","bankCode":""},{"id":53,"bankName":"金华银行","bankCode":""},{"id":54,"bankName":"乌鲁木齐商业银行","bankCode":""},{"id":55,"bankName":"绍兴银行","bankCode":""},{"id":56,"bankName":"成都银行","bankCode":""},{"id":57,"bankName":"抚顺银行","bankCode":""},{"id":58,"bankName":"临商银行","bankCode":""},{"id":59,"bankName":"宜昌市商业银行","bankCode":""},{"id":60,"bankName":"葫芦岛银行","bankCode":""},{"id":61,"bankName":"郑州银行","bankCode":""},{"id":62,"bankName":"宁夏银行","bankCode":""},{"id":63,"bankName":"珠海华润银行","bankCode":""},{"id":64,"bankName":"齐商银行","bankCode":""},{"id":65,"bankName":"锦州银行","bankCode":""},{"id":66,"bankName":"徽商银行","bankCode":""},{"id":67,"bankName":"重庆银行","bankCode":""},{"id":68,"bankName":"哈尔滨银行","bankCode":""},{"id":69,"bankName":"贵阳银行","bankCode":""},{"id":70,"bankName":"西安银行","bankCode":""},{"id":71,"bankName":"无锡市商业银行","bankCode":""},{"id":72,"bankName":"丹东银行","bankCode":""},{"id":73,"bankName":"兰州银行","bankCode":""},{"id":74,"bankName":"南昌银行","bankCode":""},{"id":75,"bankName":"晋商银行","bankCode":""},{"id":76,"bankName":"青岛银行","bankCode":""},{"id":77,"bankName":"南通商业银行","bankCode":""},{"id":78,"bankName":"九江银行","bankCode":""},{"id":79,"bankName":"日照银行","bankCode":""},{"id":80,"bankName":"鞍山银行","bankCode":""},{"id":81,"bankName":"秦皇岛银行","bankCode":""},{"id":82,"bankName":"青海银行","bankCode":""},{"id":83,"bankName":"台州银行","bankCode":""},{"id":84,"bankName":"盐城银行","bankCode":""},{"id":85,"bankName":"长沙银行","bankCode":""},{"id":86,"bankName":"赣州银行","bankCode":""},{"id":87,"bankName":"泉州银行","bankCode":""},{"id":88,"bankName":"营口银行","bankCode":""},{"id":89,"bankName":"富滇银行","bankCode":""},{"id":90,"bankName":"阜新银行","bankCode":""},{"id":91,"bankName":"嘉兴银行","bankCode":""},{"id":92,"bankName":"廊坊银行","bankCode":""},{"id":93,"bankName":"泰隆商业银行","bankCode":""},{"id":94,"bankName":"内蒙古银行","bankCode":""},{"id":95,"bankName":"湖州银行","bankCode":""},{"id":96,"bankName":"沧州银行","bankCode":""},{"id":97,"bankName":"广西北部湾银行","bankCode":""},{"id":98,"bankName":"包商银行","bankCode":""},{"id":100,"bankName":"威海商业银行","bankCode":""},{"id":101,"bankName":"攀枝花市商业银行","bankCode":""},{"id":102,"bankName":"绵阳市商业银行","bankCode":""},{"id":103,"bankName":"泸州市商业银行","bankCode":""},{"id":104,"bankName":"三门峡银行","bankCode":""},{"id":106,"bankName":"邢台银行","bankCode":"XTB"},{"id":107,"bankName":"商丘市商业银行","bankCode":""},{"id":108,"bankName":"安徽省农村信用社","bankCode":"AHNSYH"},{"id":109,"bankName":"江西省农村信用社","bankCode":""},{"id":110,"bankName":"湖南农村信用社","bankCode":""},{"id":111,"bankName":"无锡农村商业银行","bankCode":""}]
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
         * id : 2
         * bankName : 招商银行
         * bankCode : CMB
         */

        private int id;
        private String bankName;
        private String bankCode;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getBankName() {
            return bankName;
        }

        public void setBankName(String bankName) {
            this.bankName = bankName;
        }

        public String getBankCode() {
            return bankCode;
        }

        public void setBankCode(String bankCode) {
            this.bankCode = bankCode;
        }
    }
}
