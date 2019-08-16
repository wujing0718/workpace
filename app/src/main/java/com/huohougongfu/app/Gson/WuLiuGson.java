package com.huohougongfu.app.Gson;

public class WuLiuGson {

    /**
     * msg : 操作成功
     * result : {"issign":"1","number":"806869872163376301","expName":"圆通速递","deliverystatus":"3","courier":"","expSite":"www.yto.net.cn ","expPhone":"95554","logo":"http://img3.fegine.com/express/yto.jpg","courierPhone":"","type":"yto","list":[{"time":"2019-7-15 20:21:54","status":"客户 签收人: 已签收，签收人凭取货码签收。 已签收 感谢使用圆通速递，期待再次为您服务"},{"time":"2019-7-13 17:29:37","status":"快件已暂存至深圳龙岗南联金地龙城中央五栋十号店菜鸟驿站，如有疑问请联系17324401371"},{"time":"2019-7-13 14:38:56","status":"【广东省深圳市龙岗区龙城公司】 派件人: 廖丽华 派件中 派件员电话17324401093"},{"time":"2019-7-13 14:17:55","status":"【广东省深圳市龙岗区龙城公司】 已收入"},{"time":"2019-7-13 7:37:25","status":"【深圳转运中心】 已发出 下一站 【广东省深圳市龙岗区龙城公司】"},{"time":"2019-7-13 7:34:43","status":"【深圳转运中心】 已收入"},{"time":"2019-7-13 7:30:47","status":"【深圳转运中心】 已收入"},{"time":"2019-7-12 23:42:20","status":"【揭阳转运中心】 已发出 下一站 【深圳转运中心】"},{"time":"2019-7-12 23:39:35","status":"【揭阳转运中心】 已收入"},{"time":"2019-7-12 21:41:06","status":"【广东省潮州市】 已发出 下一站 【揭阳转运中心】"},{"time":"2019-7-12 21:09:04","status":"【广东省潮州市公司】 已打包"},{"time":"2019-7-12 19:58:25","status":"【广东省潮州市公司】 已收件"}]}
     * status : 1
     */

    private String msg;
    private String result;
    private int status;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
