package com.huohougongfu.app.Gson;

import java.util.List;

public class WuLiuString {

    /**
     * issign : 1
     * number : 806869872163376301
     * expName : 圆通速递
     * deliverystatus : 3
     * courier :
     * expSite : www.yto.net.cn
     * expPhone : 95554
     * logo : http://img3.fegine.com/express/yto.jpg
     * courierPhone :
     * type : yto
     * list : [{"time":"2019-7-15 20:21:54","status":"客户 签收人: 已签收，签收人凭取货码签收。 已签收 感谢使用圆通速递，期待再次为您服务"},{"time":"2019-7-13 17:29:37","status":"快件已暂存至深圳龙岗南联金地龙城中央五栋十号店菜鸟驿站，如有疑问请联系17324401371"},{"time":"2019-7-13 14:38:56","status":"【广东省深圳市龙岗区龙城公司】 派件人: 廖丽华 派件中 派件员电话17324401093"},{"time":"2019-7-13 14:17:55","status":"【广东省深圳市龙岗区龙城公司】 已收入"},{"time":"2019-7-13 7:37:25","status":"【深圳转运中心】 已发出 下一站 【广东省深圳市龙岗区龙城公司】"},{"time":"2019-7-13 7:34:43","status":"【深圳转运中心】 已收入"},{"time":"2019-7-13 7:30:47","status":"【深圳转运中心】 已收入"},{"time":"2019-7-12 23:42:20","status":"【揭阳转运中心】 已发出 下一站 【深圳转运中心】"},{"time":"2019-7-12 23:39:35","status":"【揭阳转运中心】 已收入"},{"time":"2019-7-12 21:41:06","status":"【广东省潮州市】 已发出 下一站 【揭阳转运中心】"},{"time":"2019-7-12 21:09:04","status":"【广东省潮州市公司】 已打包"},{"time":"2019-7-12 19:58:25","status":"【广东省潮州市公司】 已收件"}]
     */

    private String issign;
    private String number;
    private String expName;
    private String deliverystatus;
    private String courier;
    private String expSite;
    private String expPhone;
    private String logo;
    private String courierPhone;
    private String type;
    private List<ListBean> list;

    public String getIssign() {
        return issign;
    }

    public void setIssign(String issign) {
        this.issign = issign;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getExpName() {
        return expName;
    }

    public void setExpName(String expName) {
        this.expName = expName;
    }

    public String getDeliverystatus() {
        return deliverystatus;
    }

    public void setDeliverystatus(String deliverystatus) {
        this.deliverystatus = deliverystatus;
    }

    public String getCourier() {
        return courier;
    }

    public void setCourier(String courier) {
        this.courier = courier;
    }

    public String getExpSite() {
        return expSite;
    }

    public void setExpSite(String expSite) {
        this.expSite = expSite;
    }

    public String getExpPhone() {
        return expPhone;
    }

    public void setExpPhone(String expPhone) {
        this.expPhone = expPhone;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getCourierPhone() {
        return courierPhone;
    }

    public void setCourierPhone(String courierPhone) {
        this.courierPhone = courierPhone;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<ListBean> getList() {
        return list;
    }

    public void setList(List<ListBean> list) {
        this.list = list;
    }

    public static class ListBean {
        /**
         * time : 2019-7-15 20:21:54
         * status : 客户 签收人: 已签收，签收人凭取货码签收。 已签收 感谢使用圆通速递，期待再次为您服务
         */

        private String time;
        private String status;

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }
    }
}
