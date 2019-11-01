package com.huohougongfu.app.Gson;

import java.io.Serializable;
import java.util.List;

public class QuanZiFaXian implements Serializable {


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

    public static class ResultBean implements Serializable{
        /**
         * condition : null
         * cityCode : null
         * datas : {"total":32,"list":[{"id":131,"type":3,"title":null,"content":"他打我","picture":"http://oss.hotkungfu-tea.com/picture/1572524674744.jpg,http://oss.hotkungfu-tea.com/picture/1572524672461.mp4","pictureWidth":320,"pictureHeight":568,"createTime":"1572524673000","updateTime":"2019-10-31 20:24:33","longitude":114.261919,"latitude":22.725447,"address":"深圳市灏盟信息科技有限公司","cityCode":"0755","member":{"userId":116,"nickName":"谨记 我给过","personalProfile":null,"gender":null,"birthday":null,"email":null,"phone":null,"photo":"http://oss.hotkungfu-tea.com/picture/1572513281998.jpg","realName":null,"idcard":null,"teaRiceMe":null,"teaRicePresent":null,"commission":null,"income":null,"sinaToken":null,"qq":null,"qqToken":null,"wechat":null,"wechatToken":null,"rongToken":null,"place":null,"integral":null,"isMaster":null,"isMerchant":null,"state":null,"delFlag":null,"loginIp":null,"loginDate":null,"qrcode":null,"createTime":null,"updateTime":null,"isSift":null,"buyMoney":null,"records":null,"master":{"id":131,"name":null,"portrait":null,"photo":null,"level":null,"specialty":null,"status":null,"introduceContent":null,"createTime":"2019-10-31T12:24:33.000+0000","updateTime":"2019-10-31T12:24:33.000+0000","masterAddress":null,"storeId":null,"isMerchant":null,"nickName":null,"count":0,"isAttention":0,"mid":116,"mId":116},"isAttention":0,"fanCount":null,"attentionNum":null,"dynamicNum":null,"isFirstLogin":null,"masterId":null,"memberLevel":null,"getReelStatus":0,"recordStatus":0,"productNum":null,"vip":false,"zhuanKe":false},"isPraise":0,"praiseNum":1,"commentNum":0,"isSift":null,"browseCount":18,"mid":116},{"id":135,"type":3,"title":null,"content":"说点什么吧","picture":"http://oss.hotkungfu-tea.com/picture/1572527441657.jpg,http://oss.hotkungfu-tea.com/picture/1572527443012.mp4","pictureWidth":720,"pictureHeight":1280,"createTime":"1572527439000","updateTime":"2019-10-31 21:10:39","longitude":null,"latitude":null,"address":null,"cityCode":null,"member":{"userId":119,"nickName":"黎娅静","personalProfile":null,"gender":null,"birthday":null,"email":null,"phone":null,"photo":"https://thirdqq.qlogo.cn/g?b=oidb&k=Ns8ROf4MRcytJwcyvMXRxQ&s=100&t=1556808120","realName":null,"idcard":null,"teaRiceMe":null,"teaRicePresent":null,"commission":null,"income":null,"sinaToken":null,"qq":null,"qqToken":null,"wechat":null,"wechatToken":null,"rongToken":null,"place":null,"integral":null,"isMaster":null,"isMerchant":null,"state":null,"delFlag":null,"loginIp":null,"loginDate":null,"qrcode":null,"createTime":null,"updateTime":null,"isSift":null,"buyMoney":null,"records":null,"master":{"id":135,"name":null,"portrait":null,"photo":null,"level":null,"specialty":null,"status":null,"introduceContent":null,"createTime":"2019-10-31T13:10:39.000+0000","updateTime":"2019-10-31T13:10:39.000+0000","masterAddress":null,"storeId":null,"isMerchant":null,"nickName":null,"count":0,"isAttention":0,"mid":119,"mId":119},"isAttention":0,"fanCount":null,"attentionNum":null,"dynamicNum":null,"isFirstLogin":null,"masterId":null,"memberLevel":null,"getReelStatus":0,"recordStatus":0,"productNum":null,"vip":false,"zhuanKe":false},"isPraise":0,"praiseNum":0,"commentNum":0,"isSift":null,"browseCount":5,"mid":119},{"id":136,"type":3,"title":null,"content":"好好","picture":"http://oss.hotkungfu-tea.com/picture/1572527597830.jpg,http://oss.hotkungfu-tea.com/picture/1572527597701.mp4","pictureWidth":720,"pictureHeight":1280,"createTime":"1572527596000","updateTime":"2019-10-31 21:13:16","longitude":null,"latitude":null,"address":null,"cityCode":null,"member":{"userId":119,"nickName":"黎娅静","personalProfile":null,"gender":null,"birthday":null,"email":null,"phone":null,"photo":"https://thirdqq.qlogo.cn/g?b=oidb&k=Ns8ROf4MRcytJwcyvMXRxQ&s=100&t=1556808120","realName":null,"idcard":null,"teaRiceMe":null,"teaRicePresent":null,"commission":null,"income":null,"sinaToken":null,"qq":null,"qqToken":null,"wechat":null,"wechatToken":null,"rongToken":null,"place":null,"integral":null,"isMaster":null,"isMerchant":null,"state":null,"delFlag":null,"loginIp":null,"loginDate":null,"qrcode":null,"createTime":null,"updateTime":null,"isSift":null,"buyMoney":null,"records":null,"master":{"id":136,"name":null,"portrait":null,"photo":null,"level":null,"specialty":null,"status":null,"introduceContent":null,"createTime":"2019-10-31T13:13:16.000+0000","updateTime":"2019-10-31T13:13:16.000+0000","masterAddress":null,"storeId":null,"isMerchant":null,"nickName":null,"count":0,"isAttention":0,"mid":119,"mId":119},"isAttention":0,"fanCount":null,"attentionNum":null,"dynamicNum":null,"isFirstLogin":null,"masterId":null,"memberLevel":null,"getReelStatus":0,"recordStatus":0,"productNum":null,"vip":false,"zhuanKe":false},"isPraise":0,"praiseNum":0,"commentNum":0,"isSift":null,"browseCount":0,"mid":119},{"id":133,"type":3,"title":null,"content":"难呐","picture":"http://oss.hotkungfu-tea.com/picture/1572525481558.jpg,http://oss.hotkungfu-tea.com/picture/1572525481434.mp4","pictureWidth":360,"pictureHeight":480,"createTime":"1572525478000","updateTime":"2019-10-31 20:37:58","longitude":114.261852,"latitude":22.725397,"address":"金晖创业社区","cityCode":"0755","member":{"userId":116,"nickName":"谨记 我给过","personalProfile":null,"gender":null,"birthday":null,"email":null,"phone":null,"photo":"http://oss.hotkungfu-tea.com/picture/1572513281998.jpg","realName":null,"idcard":null,"teaRiceMe":null,"teaRicePresent":null,"commission":null,"income":null,"sinaToken":null,"qq":null,"qqToken":null,"wechat":null,"wechatToken":null,"rongToken":null,"place":null,"integral":null,"isMaster":null,"isMerchant":null,"state":null,"delFlag":null,"loginIp":null,"loginDate":null,"qrcode":null,"createTime":null,"updateTime":null,"isSift":null,"buyMoney":null,"records":null,"master":{"id":133,"name":null,"portrait":null,"photo":null,"level":null,"specialty":null,"status":null,"introduceContent":null,"createTime":"2019-10-31T12:37:58.000+0000","updateTime":"2019-10-31T12:37:58.000+0000","masterAddress":null,"storeId":null,"isMerchant":null,"nickName":null,"count":0,"isAttention":0,"mid":116,"mId":116},"isAttention":0,"fanCount":null,"attentionNum":null,"dynamicNum":null,"isFirstLogin":null,"masterId":null,"memberLevel":null,"getReelStatus":0,"recordStatus":0,"productNum":null,"vip":false,"zhuanKe":false},"isPraise":0,"praiseNum":0,"commentNum":0,"isSift":null,"browseCount":1,"mid":116},{"id":32,"type":1,"title":null,"content":"肥猪","picture":"http://oss.hotkungfu-tea.com/picture/1571365260994.jpg","pictureWidth":826,"pictureHeight":826,"createTime":"1571365257000","updateTime":"2019-10-18 10:20:57","longitude":0,"latitude":0,"address":null,"cityCode":null,"member":{"userId":99,"nickName":"霏霏爱喝茶","personalProfile":null,"gender":null,"birthday":null,"email":null,"phone":null,"photo":"http://oss.hotkungfu-tea.com/picture/1570759306422.jpg","realName":null,"idcard":null,"teaRiceMe":null,"teaRicePresent":null,"commission":null,"income":null,"sinaToken":null,"qq":null,"qqToken":null,"wechat":null,"wechatToken":null,"rongToken":null,"place":null,"integral":null,"isMaster":null,"isMerchant":null,"state":null,"delFlag":null,"loginIp":null,"loginDate":null,"qrcode":null,"createTime":null,"updateTime":null,"isSift":null,"buyMoney":null,"records":null,"master":{"id":32,"name":null,"portrait":null,"photo":null,"level":null,"specialty":null,"status":null,"introduceContent":null,"createTime":"2019-10-18T02:20:57.000+0000","updateTime":"2019-10-18T02:20:57.000+0000","masterAddress":null,"storeId":null,"isMerchant":null,"nickName":null,"count":0,"isAttention":0,"mid":99,"mId":99},"isAttention":1,"fanCount":null,"attentionNum":null,"dynamicNum":null,"isFirstLogin":null,"masterId":null,"memberLevel":null,"getReelStatus":0,"recordStatus":0,"productNum":null,"vip":false,"zhuanKe":false},"isPraise":1,"praiseNum":4,"commentNum":1,"isSift":null,"browseCount":74,"mid":99},{"id":25,"type":1,"title":null,"content":"同城数据","picture":"http://oss.hotkungfu-tea.com/picture/1571034412708.jpg","pictureWidth":828,"pictureHeight":1104,"createTime":"1571034405000","updateTime":"2019-10-14 14:26:45","longitude":114.117683,"latitude":22.531995,"address":"深圳站","cityCode":"440303","member":{"userId":101,"nickName":"Drew","personalProfile":null,"gender":null,"birthday":null,"email":null,"phone":null,"photo":"https://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTIjv8IiccVtfzLcLTDRcMWwZSuQpjhUfxTZQhK0icQZib5z4zHvbbuISVo8gOLBXeX7iaYTvdj4zWYRdQ/132","realName":null,"idcard":null,"teaRiceMe":null,"teaRicePresent":null,"commission":null,"income":null,"sinaToken":null,"qq":null,"qqToken":null,"wechat":null,"wechatToken":null,"rongToken":null,"place":null,"integral":null,"isMaster":null,"isMerchant":null,"state":null,"delFlag":null,"loginIp":null,"loginDate":null,"qrcode":null,"createTime":null,"updateTime":null,"isSift":null,"buyMoney":null,"records":null,"master":{"id":25,"name":null,"portrait":null,"photo":null,"level":null,"specialty":null,"status":null,"introduceContent":null,"createTime":"2019-10-14T06:26:45.000+0000","updateTime":"2019-10-14T06:26:45.000+0000","masterAddress":null,"storeId":null,"isMerchant":null,"nickName":null,"count":0,"isAttention":0,"mid":101,"mId":101},"isAttention":0,"fanCount":null,"attentionNum":null,"dynamicNum":null,"isFirstLogin":null,"masterId":null,"memberLevel":null,"getReelStatus":0,"recordStatus":0,"productNum":null,"vip":false,"zhuanKe":false},"isPraise":0,"praiseNum":3,"commentNum":0,"isSift":null,"browseCount":54,"mid":101},{"id":19,"type":1,"title":null,"content":"专注制茶三十年 老手艺人","picture":"http://oss.hotkungfu-tea.com/picture/1570759486683.jpg","pictureWidth":828,"pictureHeight":620,"createTime":"1570759477000","updateTime":"2019-10-11 10:04:37","longitude":0,"latitude":0,"address":null,"cityCode":null,"member":{"userId":99,"nickName":"霏霏爱喝茶","personalProfile":null,"gender":null,"birthday":null,"email":null,"phone":null,"photo":"http://oss.hotkungfu-tea.com/picture/1570759306422.jpg","realName":null,"idcard":null,"teaRiceMe":null,"teaRicePresent":null,"commission":null,"income":null,"sinaToken":null,"qq":null,"qqToken":null,"wechat":null,"wechatToken":null,"rongToken":null,"place":null,"integral":null,"isMaster":null,"isMerchant":null,"state":null,"delFlag":null,"loginIp":null,"loginDate":null,"qrcode":null,"createTime":null,"updateTime":null,"isSift":null,"buyMoney":null,"records":null,"master":{"id":19,"name":null,"portrait":null,"photo":null,"level":null,"specialty":null,"status":null,"introduceContent":null,"createTime":"2019-10-11T02:04:37.000+0000","updateTime":"2019-10-11T02:04:37.000+0000","masterAddress":null,"storeId":null,"isMerchant":null,"nickName":null,"count":0,"isAttention":0,"mid":99,"mId":99},"isAttention":1,"fanCount":null,"attentionNum":null,"dynamicNum":null,"isFirstLogin":null,"masterId":null,"memberLevel":null,"getReelStatus":0,"recordStatus":0,"productNum":null,"vip":false,"zhuanKe":false},"isPraise":0,"praiseNum":5,"commentNum":0,"isSift":null,"browseCount":43,"mid":99},{"id":23,"type":1,"title":null,"content":"啦啦啦啦啦","picture":"http://oss.hotkungfu-tea.com/picture/1570764786218.jpg","pictureWidth":2016,"pictureHeight":1508,"createTime":"1570764779000","updateTime":"2019-10-11 11:32:59","longitude":null,"latitude":null,"address":null,"cityCode":null,"member":{"userId":102,"nickName":"测试","personalProfile":null,"gender":null,"birthday":null,"email":null,"phone":null,"photo":"http://oss.hotkungfu-tea.com/picture/1572246720260.jpg","realName":null,"idcard":null,"teaRiceMe":null,"teaRicePresent":null,"commission":null,"income":null,"sinaToken":null,"qq":null,"qqToken":null,"wechat":null,"wechatToken":null,"rongToken":null,"place":null,"integral":null,"isMaster":null,"isMerchant":null,"state":null,"delFlag":null,"loginIp":null,"loginDate":null,"qrcode":null,"createTime":null,"updateTime":null,"isSift":null,"buyMoney":null,"records":null,"master":{"id":23,"name":null,"portrait":null,"photo":null,"level":null,"specialty":null,"status":null,"introduceContent":null,"createTime":"2019-10-11T03:32:59.000+0000","updateTime":"2019-10-11T03:32:59.000+0000","masterAddress":null,"storeId":null,"isMerchant":null,"nickName":null,"count":0,"isAttention":0,"mid":102,"mId":102},"isAttention":0,"fanCount":null,"attentionNum":null,"dynamicNum":null,"isFirstLogin":null,"masterId":null,"memberLevel":null,"getReelStatus":0,"recordStatus":0,"productNum":null,"vip":false,"zhuanKe":false},"isPraise":0,"praiseNum":2,"commentNum":1,"isSift":null,"browseCount":29,"mid":102},{"id":35,"type":1,"title":null,"content":"中央音乐学院","picture":"http://oss.hotkungfu-tea.com/picture/1571623094226.jpg","pictureWidth":480,"pictureHeight":480,"createTime":"1571623087000","updateTime":"2019-10-21 09:58:07","longitude":114.085947,"latitude":22.547,"address":"深圳市","cityCode":"0755","member":{"userId":102,"nickName":"测试","personalProfile":null,"gender":null,"birthday":null,"email":null,"phone":null,"photo":"http://oss.hotkungfu-tea.com/picture/1572246720260.jpg","realName":null,"idcard":null,"teaRiceMe":null,"teaRicePresent":null,"commission":null,"income":null,"sinaToken":null,"qq":null,"qqToken":null,"wechat":null,"wechatToken":null,"rongToken":null,"place":null,"integral":null,"isMaster":null,"isMerchant":null,"state":null,"delFlag":null,"loginIp":null,"loginDate":null,"qrcode":null,"createTime":null,"updateTime":null,"isSift":null,"buyMoney":null,"records":null,"master":{"id":35,"name":null,"portrait":null,"photo":null,"level":null,"specialty":null,"status":null,"introduceContent":null,"createTime":"2019-10-21T01:58:07.000+0000","updateTime":"2019-10-21T01:58:07.000+0000","masterAddress":null,"storeId":null,"isMerchant":null,"nickName":null,"count":0,"isAttention":0,"mid":102,"mId":102},"isAttention":0,"fanCount":null,"attentionNum":null,"dynamicNum":null,"isFirstLogin":null,"masterId":null,"memberLevel":null,"getReelStatus":0,"recordStatus":0,"productNum":null,"vip":false,"zhuanKe":false},"isPraise":0,"praiseNum":0,"commentNum":0,"isSift":null,"browseCount":24,"mid":102},{"id":111,"type":1,"title":null,"content":"牛","picture":"http://oss.hotkungfu-tea.com/picture/1572333615073.jpg","pictureWidth":1728,"pictureHeight":2304,"createTime":"1572333608000","updateTime":"2019-10-29 15:20:08","longitude":null,"latitude":null,"address":null,"cityCode":null,"member":{"userId":105,"nickName":"jio","personalProfile":null,"gender":null,"birthday":null,"email":null,"phone":null,"photo":"http://oss.hotkungfu-tea.com/picture/1571037569487.jpg","realName":null,"idcard":null,"teaRiceMe":null,"teaRicePresent":null,"commission":null,"income":null,"sinaToken":null,"qq":null,"qqToken":null,"wechat":null,"wechatToken":null,"rongToken":null,"place":null,"integral":null,"isMaster":null,"isMerchant":null,"state":null,"delFlag":null,"loginIp":null,"loginDate":null,"qrcode":null,"createTime":null,"updateTime":null,"isSift":null,"buyMoney":null,"records":null,"master":{"id":111,"name":null,"portrait":null,"photo":null,"level":null,"specialty":null,"status":null,"introduceContent":null,"createTime":"2019-10-29T07:20:08.000+0000","updateTime":"2019-10-29T07:20:08.000+0000","masterAddress":null,"storeId":null,"isMerchant":null,"nickName":null,"count":0,"isAttention":0,"mid":105,"mId":105},"isAttention":0,"fanCount":null,"attentionNum":null,"dynamicNum":null,"isFirstLogin":null,"masterId":null,"memberLevel":null,"getReelStatus":0,"recordStatus":0,"productNum":null,"vip":false,"zhuanKe":false},"isPraise":0,"praiseNum":2,"commentNum":1,"isSift":null,"browseCount":21,"mid":105}],"pageNum":1,"pageSize":10,"size":10,"startRow":1,"endRow":10,"pages":4,"prePage":0,"nextPage":2,"isFirstPage":true,"isLastPage":false,"hasPreviousPage":false,"hasNextPage":true,"navigatePages":8,"navigatepageNums":[1,2,3,4],"navigateFirstPage":1,"navigateLastPage":4}
         * type : null
         */

        private Object condition;
        private Object cityCode;
        private DatasBean datas;
        private Object type;

        public Object getCondition() {
            return condition;
        }

        public void setCondition(Object condition) {
            this.condition = condition;
        }

        public Object getCityCode() {
            return cityCode;
        }

        public void setCityCode(Object cityCode) {
            this.cityCode = cityCode;
        }

        public DatasBean getDatas() {
            return datas;
        }

        public void setDatas(DatasBean datas) {
            this.datas = datas;
        }

        public Object getType() {
            return type;
        }

        public void setType(Object type) {
            this.type = type;
        }

        public static class DatasBean implements Serializable{
            /**
             * total : 32
             * list : [{"id":131,"type":3,"title":null,"content":"他打我","picture":"http://oss.hotkungfu-tea.com/picture/1572524674744.jpg,http://oss.hotkungfu-tea.com/picture/1572524672461.mp4","pictureWidth":320,"pictureHeight":568,"createTime":"1572524673000","updateTime":"2019-10-31 20:24:33","longitude":114.261919,"latitude":22.725447,"address":"深圳市灏盟信息科技有限公司","cityCode":"0755","member":{"userId":116,"nickName":"谨记 我给过","personalProfile":null,"gender":null,"birthday":null,"email":null,"phone":null,"photo":"http://oss.hotkungfu-tea.com/picture/1572513281998.jpg","realName":null,"idcard":null,"teaRiceMe":null,"teaRicePresent":null,"commission":null,"income":null,"sinaToken":null,"qq":null,"qqToken":null,"wechat":null,"wechatToken":null,"rongToken":null,"place":null,"integral":null,"isMaster":null,"isMerchant":null,"state":null,"delFlag":null,"loginIp":null,"loginDate":null,"qrcode":null,"createTime":null,"updateTime":null,"isSift":null,"buyMoney":null,"records":null,"master":{"id":131,"name":null,"portrait":null,"photo":null,"level":null,"specialty":null,"status":null,"introduceContent":null,"createTime":"2019-10-31T12:24:33.000+0000","updateTime":"2019-10-31T12:24:33.000+0000","masterAddress":null,"storeId":null,"isMerchant":null,"nickName":null,"count":0,"isAttention":0,"mid":116,"mId":116},"isAttention":0,"fanCount":null,"attentionNum":null,"dynamicNum":null,"isFirstLogin":null,"masterId":null,"memberLevel":null,"getReelStatus":0,"recordStatus":0,"productNum":null,"vip":false,"zhuanKe":false},"isPraise":0,"praiseNum":1,"commentNum":0,"isSift":null,"browseCount":18,"mid":116},{"id":135,"type":3,"title":null,"content":"说点什么吧","picture":"http://oss.hotkungfu-tea.com/picture/1572527441657.jpg,http://oss.hotkungfu-tea.com/picture/1572527443012.mp4","pictureWidth":720,"pictureHeight":1280,"createTime":"1572527439000","updateTime":"2019-10-31 21:10:39","longitude":null,"latitude":null,"address":null,"cityCode":null,"member":{"userId":119,"nickName":"黎娅静","personalProfile":null,"gender":null,"birthday":null,"email":null,"phone":null,"photo":"https://thirdqq.qlogo.cn/g?b=oidb&k=Ns8ROf4MRcytJwcyvMXRxQ&s=100&t=1556808120","realName":null,"idcard":null,"teaRiceMe":null,"teaRicePresent":null,"commission":null,"income":null,"sinaToken":null,"qq":null,"qqToken":null,"wechat":null,"wechatToken":null,"rongToken":null,"place":null,"integral":null,"isMaster":null,"isMerchant":null,"state":null,"delFlag":null,"loginIp":null,"loginDate":null,"qrcode":null,"createTime":null,"updateTime":null,"isSift":null,"buyMoney":null,"records":null,"master":{"id":135,"name":null,"portrait":null,"photo":null,"level":null,"specialty":null,"status":null,"introduceContent":null,"createTime":"2019-10-31T13:10:39.000+0000","updateTime":"2019-10-31T13:10:39.000+0000","masterAddress":null,"storeId":null,"isMerchant":null,"nickName":null,"count":0,"isAttention":0,"mid":119,"mId":119},"isAttention":0,"fanCount":null,"attentionNum":null,"dynamicNum":null,"isFirstLogin":null,"masterId":null,"memberLevel":null,"getReelStatus":0,"recordStatus":0,"productNum":null,"vip":false,"zhuanKe":false},"isPraise":0,"praiseNum":0,"commentNum":0,"isSift":null,"browseCount":5,"mid":119},{"id":136,"type":3,"title":null,"content":"好好","picture":"http://oss.hotkungfu-tea.com/picture/1572527597830.jpg,http://oss.hotkungfu-tea.com/picture/1572527597701.mp4","pictureWidth":720,"pictureHeight":1280,"createTime":"1572527596000","updateTime":"2019-10-31 21:13:16","longitude":null,"latitude":null,"address":null,"cityCode":null,"member":{"userId":119,"nickName":"黎娅静","personalProfile":null,"gender":null,"birthday":null,"email":null,"phone":null,"photo":"https://thirdqq.qlogo.cn/g?b=oidb&k=Ns8ROf4MRcytJwcyvMXRxQ&s=100&t=1556808120","realName":null,"idcard":null,"teaRiceMe":null,"teaRicePresent":null,"commission":null,"income":null,"sinaToken":null,"qq":null,"qqToken":null,"wechat":null,"wechatToken":null,"rongToken":null,"place":null,"integral":null,"isMaster":null,"isMerchant":null,"state":null,"delFlag":null,"loginIp":null,"loginDate":null,"qrcode":null,"createTime":null,"updateTime":null,"isSift":null,"buyMoney":null,"records":null,"master":{"id":136,"name":null,"portrait":null,"photo":null,"level":null,"specialty":null,"status":null,"introduceContent":null,"createTime":"2019-10-31T13:13:16.000+0000","updateTime":"2019-10-31T13:13:16.000+0000","masterAddress":null,"storeId":null,"isMerchant":null,"nickName":null,"count":0,"isAttention":0,"mid":119,"mId":119},"isAttention":0,"fanCount":null,"attentionNum":null,"dynamicNum":null,"isFirstLogin":null,"masterId":null,"memberLevel":null,"getReelStatus":0,"recordStatus":0,"productNum":null,"vip":false,"zhuanKe":false},"isPraise":0,"praiseNum":0,"commentNum":0,"isSift":null,"browseCount":0,"mid":119},{"id":133,"type":3,"title":null,"content":"难呐","picture":"http://oss.hotkungfu-tea.com/picture/1572525481558.jpg,http://oss.hotkungfu-tea.com/picture/1572525481434.mp4","pictureWidth":360,"pictureHeight":480,"createTime":"1572525478000","updateTime":"2019-10-31 20:37:58","longitude":114.261852,"latitude":22.725397,"address":"金晖创业社区","cityCode":"0755","member":{"userId":116,"nickName":"谨记 我给过","personalProfile":null,"gender":null,"birthday":null,"email":null,"phone":null,"photo":"http://oss.hotkungfu-tea.com/picture/1572513281998.jpg","realName":null,"idcard":null,"teaRiceMe":null,"teaRicePresent":null,"commission":null,"income":null,"sinaToken":null,"qq":null,"qqToken":null,"wechat":null,"wechatToken":null,"rongToken":null,"place":null,"integral":null,"isMaster":null,"isMerchant":null,"state":null,"delFlag":null,"loginIp":null,"loginDate":null,"qrcode":null,"createTime":null,"updateTime":null,"isSift":null,"buyMoney":null,"records":null,"master":{"id":133,"name":null,"portrait":null,"photo":null,"level":null,"specialty":null,"status":null,"introduceContent":null,"createTime":"2019-10-31T12:37:58.000+0000","updateTime":"2019-10-31T12:37:58.000+0000","masterAddress":null,"storeId":null,"isMerchant":null,"nickName":null,"count":0,"isAttention":0,"mid":116,"mId":116},"isAttention":0,"fanCount":null,"attentionNum":null,"dynamicNum":null,"isFirstLogin":null,"masterId":null,"memberLevel":null,"getReelStatus":0,"recordStatus":0,"productNum":null,"vip":false,"zhuanKe":false},"isPraise":0,"praiseNum":0,"commentNum":0,"isSift":null,"browseCount":1,"mid":116},{"id":32,"type":1,"title":null,"content":"肥猪","picture":"http://oss.hotkungfu-tea.com/picture/1571365260994.jpg","pictureWidth":826,"pictureHeight":826,"createTime":"1571365257000","updateTime":"2019-10-18 10:20:57","longitude":0,"latitude":0,"address":null,"cityCode":null,"member":{"userId":99,"nickName":"霏霏爱喝茶","personalProfile":null,"gender":null,"birthday":null,"email":null,"phone":null,"photo":"http://oss.hotkungfu-tea.com/picture/1570759306422.jpg","realName":null,"idcard":null,"teaRiceMe":null,"teaRicePresent":null,"commission":null,"income":null,"sinaToken":null,"qq":null,"qqToken":null,"wechat":null,"wechatToken":null,"rongToken":null,"place":null,"integral":null,"isMaster":null,"isMerchant":null,"state":null,"delFlag":null,"loginIp":null,"loginDate":null,"qrcode":null,"createTime":null,"updateTime":null,"isSift":null,"buyMoney":null,"records":null,"master":{"id":32,"name":null,"portrait":null,"photo":null,"level":null,"specialty":null,"status":null,"introduceContent":null,"createTime":"2019-10-18T02:20:57.000+0000","updateTime":"2019-10-18T02:20:57.000+0000","masterAddress":null,"storeId":null,"isMerchant":null,"nickName":null,"count":0,"isAttention":0,"mid":99,"mId":99},"isAttention":1,"fanCount":null,"attentionNum":null,"dynamicNum":null,"isFirstLogin":null,"masterId":null,"memberLevel":null,"getReelStatus":0,"recordStatus":0,"productNum":null,"vip":false,"zhuanKe":false},"isPraise":1,"praiseNum":4,"commentNum":1,"isSift":null,"browseCount":74,"mid":99},{"id":25,"type":1,"title":null,"content":"同城数据","picture":"http://oss.hotkungfu-tea.com/picture/1571034412708.jpg","pictureWidth":828,"pictureHeight":1104,"createTime":"1571034405000","updateTime":"2019-10-14 14:26:45","longitude":114.117683,"latitude":22.531995,"address":"深圳站","cityCode":"440303","member":{"userId":101,"nickName":"Drew","personalProfile":null,"gender":null,"birthday":null,"email":null,"phone":null,"photo":"https://thirdwx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTIjv8IiccVtfzLcLTDRcMWwZSuQpjhUfxTZQhK0icQZib5z4zHvbbuISVo8gOLBXeX7iaYTvdj4zWYRdQ/132","realName":null,"idcard":null,"teaRiceMe":null,"teaRicePresent":null,"commission":null,"income":null,"sinaToken":null,"qq":null,"qqToken":null,"wechat":null,"wechatToken":null,"rongToken":null,"place":null,"integral":null,"isMaster":null,"isMerchant":null,"state":null,"delFlag":null,"loginIp":null,"loginDate":null,"qrcode":null,"createTime":null,"updateTime":null,"isSift":null,"buyMoney":null,"records":null,"master":{"id":25,"name":null,"portrait":null,"photo":null,"level":null,"specialty":null,"status":null,"introduceContent":null,"createTime":"2019-10-14T06:26:45.000+0000","updateTime":"2019-10-14T06:26:45.000+0000","masterAddress":null,"storeId":null,"isMerchant":null,"nickName":null,"count":0,"isAttention":0,"mid":101,"mId":101},"isAttention":0,"fanCount":null,"attentionNum":null,"dynamicNum":null,"isFirstLogin":null,"masterId":null,"memberLevel":null,"getReelStatus":0,"recordStatus":0,"productNum":null,"vip":false,"zhuanKe":false},"isPraise":0,"praiseNum":3,"commentNum":0,"isSift":null,"browseCount":54,"mid":101},{"id":19,"type":1,"title":null,"content":"专注制茶三十年 老手艺人","picture":"http://oss.hotkungfu-tea.com/picture/1570759486683.jpg","pictureWidth":828,"pictureHeight":620,"createTime":"1570759477000","updateTime":"2019-10-11 10:04:37","longitude":0,"latitude":0,"address":null,"cityCode":null,"member":{"userId":99,"nickName":"霏霏爱喝茶","personalProfile":null,"gender":null,"birthday":null,"email":null,"phone":null,"photo":"http://oss.hotkungfu-tea.com/picture/1570759306422.jpg","realName":null,"idcard":null,"teaRiceMe":null,"teaRicePresent":null,"commission":null,"income":null,"sinaToken":null,"qq":null,"qqToken":null,"wechat":null,"wechatToken":null,"rongToken":null,"place":null,"integral":null,"isMaster":null,"isMerchant":null,"state":null,"delFlag":null,"loginIp":null,"loginDate":null,"qrcode":null,"createTime":null,"updateTime":null,"isSift":null,"buyMoney":null,"records":null,"master":{"id":19,"name":null,"portrait":null,"photo":null,"level":null,"specialty":null,"status":null,"introduceContent":null,"createTime":"2019-10-11T02:04:37.000+0000","updateTime":"2019-10-11T02:04:37.000+0000","masterAddress":null,"storeId":null,"isMerchant":null,"nickName":null,"count":0,"isAttention":0,"mid":99,"mId":99},"isAttention":1,"fanCount":null,"attentionNum":null,"dynamicNum":null,"isFirstLogin":null,"masterId":null,"memberLevel":null,"getReelStatus":0,"recordStatus":0,"productNum":null,"vip":false,"zhuanKe":false},"isPraise":0,"praiseNum":5,"commentNum":0,"isSift":null,"browseCount":43,"mid":99},{"id":23,"type":1,"title":null,"content":"啦啦啦啦啦","picture":"http://oss.hotkungfu-tea.com/picture/1570764786218.jpg","pictureWidth":2016,"pictureHeight":1508,"createTime":"1570764779000","updateTime":"2019-10-11 11:32:59","longitude":null,"latitude":null,"address":null,"cityCode":null,"member":{"userId":102,"nickName":"测试","personalProfile":null,"gender":null,"birthday":null,"email":null,"phone":null,"photo":"http://oss.hotkungfu-tea.com/picture/1572246720260.jpg","realName":null,"idcard":null,"teaRiceMe":null,"teaRicePresent":null,"commission":null,"income":null,"sinaToken":null,"qq":null,"qqToken":null,"wechat":null,"wechatToken":null,"rongToken":null,"place":null,"integral":null,"isMaster":null,"isMerchant":null,"state":null,"delFlag":null,"loginIp":null,"loginDate":null,"qrcode":null,"createTime":null,"updateTime":null,"isSift":null,"buyMoney":null,"records":null,"master":{"id":23,"name":null,"portrait":null,"photo":null,"level":null,"specialty":null,"status":null,"introduceContent":null,"createTime":"2019-10-11T03:32:59.000+0000","updateTime":"2019-10-11T03:32:59.000+0000","masterAddress":null,"storeId":null,"isMerchant":null,"nickName":null,"count":0,"isAttention":0,"mid":102,"mId":102},"isAttention":0,"fanCount":null,"attentionNum":null,"dynamicNum":null,"isFirstLogin":null,"masterId":null,"memberLevel":null,"getReelStatus":0,"recordStatus":0,"productNum":null,"vip":false,"zhuanKe":false},"isPraise":0,"praiseNum":2,"commentNum":1,"isSift":null,"browseCount":29,"mid":102},{"id":35,"type":1,"title":null,"content":"中央音乐学院","picture":"http://oss.hotkungfu-tea.com/picture/1571623094226.jpg","pictureWidth":480,"pictureHeight":480,"createTime":"1571623087000","updateTime":"2019-10-21 09:58:07","longitude":114.085947,"latitude":22.547,"address":"深圳市","cityCode":"0755","member":{"userId":102,"nickName":"测试","personalProfile":null,"gender":null,"birthday":null,"email":null,"phone":null,"photo":"http://oss.hotkungfu-tea.com/picture/1572246720260.jpg","realName":null,"idcard":null,"teaRiceMe":null,"teaRicePresent":null,"commission":null,"income":null,"sinaToken":null,"qq":null,"qqToken":null,"wechat":null,"wechatToken":null,"rongToken":null,"place":null,"integral":null,"isMaster":null,"isMerchant":null,"state":null,"delFlag":null,"loginIp":null,"loginDate":null,"qrcode":null,"createTime":null,"updateTime":null,"isSift":null,"buyMoney":null,"records":null,"master":{"id":35,"name":null,"portrait":null,"photo":null,"level":null,"specialty":null,"status":null,"introduceContent":null,"createTime":"2019-10-21T01:58:07.000+0000","updateTime":"2019-10-21T01:58:07.000+0000","masterAddress":null,"storeId":null,"isMerchant":null,"nickName":null,"count":0,"isAttention":0,"mid":102,"mId":102},"isAttention":0,"fanCount":null,"attentionNum":null,"dynamicNum":null,"isFirstLogin":null,"masterId":null,"memberLevel":null,"getReelStatus":0,"recordStatus":0,"productNum":null,"vip":false,"zhuanKe":false},"isPraise":0,"praiseNum":0,"commentNum":0,"isSift":null,"browseCount":24,"mid":102},{"id":111,"type":1,"title":null,"content":"牛","picture":"http://oss.hotkungfu-tea.com/picture/1572333615073.jpg","pictureWidth":1728,"pictureHeight":2304,"createTime":"1572333608000","updateTime":"2019-10-29 15:20:08","longitude":null,"latitude":null,"address":null,"cityCode":null,"member":{"userId":105,"nickName":"jio","personalProfile":null,"gender":null,"birthday":null,"email":null,"phone":null,"photo":"http://oss.hotkungfu-tea.com/picture/1571037569487.jpg","realName":null,"idcard":null,"teaRiceMe":null,"teaRicePresent":null,"commission":null,"income":null,"sinaToken":null,"qq":null,"qqToken":null,"wechat":null,"wechatToken":null,"rongToken":null,"place":null,"integral":null,"isMaster":null,"isMerchant":null,"state":null,"delFlag":null,"loginIp":null,"loginDate":null,"qrcode":null,"createTime":null,"updateTime":null,"isSift":null,"buyMoney":null,"records":null,"master":{"id":111,"name":null,"portrait":null,"photo":null,"level":null,"specialty":null,"status":null,"introduceContent":null,"createTime":"2019-10-29T07:20:08.000+0000","updateTime":"2019-10-29T07:20:08.000+0000","masterAddress":null,"storeId":null,"isMerchant":null,"nickName":null,"count":0,"isAttention":0,"mid":105,"mId":105},"isAttention":0,"fanCount":null,"attentionNum":null,"dynamicNum":null,"isFirstLogin":null,"masterId":null,"memberLevel":null,"getReelStatus":0,"recordStatus":0,"productNum":null,"vip":false,"zhuanKe":false},"isPraise":0,"praiseNum":2,"commentNum":1,"isSift":null,"browseCount":21,"mid":105}]
             * pageNum : 1
             * pageSize : 10
             * size : 10
             * startRow : 1
             * endRow : 10
             * pages : 4
             * prePage : 0
             * nextPage : 2
             * isFirstPage : true
             * isLastPage : false
             * hasPreviousPage : false
             * hasNextPage : true
             * navigatePages : 8
             * navigatepageNums : [1,2,3,4]
             * navigateFirstPage : 1
             * navigateLastPage : 4
             */

            private int total;
            private int pageNum;
            private int pageSize;
            private int size;
            private int startRow;
            private int endRow;
            private int pages;
            private int prePage;
            private int nextPage;
            private boolean isFirstPage;
            private boolean isLastPage;
            private boolean hasPreviousPage;
            private boolean hasNextPage;
            private int navigatePages;
            private int navigateFirstPage;
            private int navigateLastPage;
            private List<ListBean> list;
            private List<Integer> navigatepageNums;

            public int getTotal() {
                return total;
            }

            public void setTotal(int total) {
                this.total = total;
            }

            public int getPageNum() {
                return pageNum;
            }

            public void setPageNum(int pageNum) {
                this.pageNum = pageNum;
            }

            public int getPageSize() {
                return pageSize;
            }

            public void setPageSize(int pageSize) {
                this.pageSize = pageSize;
            }

            public int getSize() {
                return size;
            }

            public void setSize(int size) {
                this.size = size;
            }

            public int getStartRow() {
                return startRow;
            }

            public void setStartRow(int startRow) {
                this.startRow = startRow;
            }

            public int getEndRow() {
                return endRow;
            }

            public void setEndRow(int endRow) {
                this.endRow = endRow;
            }

            public int getPages() {
                return pages;
            }

            public void setPages(int pages) {
                this.pages = pages;
            }

            public int getPrePage() {
                return prePage;
            }

            public void setPrePage(int prePage) {
                this.prePage = prePage;
            }

            public int getNextPage() {
                return nextPage;
            }

            public void setNextPage(int nextPage) {
                this.nextPage = nextPage;
            }

            public boolean isIsFirstPage() {
                return isFirstPage;
            }

            public void setIsFirstPage(boolean isFirstPage) {
                this.isFirstPage = isFirstPage;
            }

            public boolean isIsLastPage() {
                return isLastPage;
            }

            public void setIsLastPage(boolean isLastPage) {
                this.isLastPage = isLastPage;
            }

            public boolean isHasPreviousPage() {
                return hasPreviousPage;
            }

            public void setHasPreviousPage(boolean hasPreviousPage) {
                this.hasPreviousPage = hasPreviousPage;
            }

            public boolean isHasNextPage() {
                return hasNextPage;
            }

            public void setHasNextPage(boolean hasNextPage) {
                this.hasNextPage = hasNextPage;
            }

            public int getNavigatePages() {
                return navigatePages;
            }

            public void setNavigatePages(int navigatePages) {
                this.navigatePages = navigatePages;
            }

            public int getNavigateFirstPage() {
                return navigateFirstPage;
            }

            public void setNavigateFirstPage(int navigateFirstPage) {
                this.navigateFirstPage = navigateFirstPage;
            }

            public int getNavigateLastPage() {
                return navigateLastPage;
            }

            public void setNavigateLastPage(int navigateLastPage) {
                this.navigateLastPage = navigateLastPage;
            }

            public List<ListBean> getList() {
                return list;
            }

            public void setList(List<ListBean> list) {
                this.list = list;
            }

            public List<Integer> getNavigatepageNums() {
                return navigatepageNums;
            }

            public void setNavigatepageNums(List<Integer> navigatepageNums) {
                this.navigatepageNums = navigatepageNums;
            }

            public static class ListBean implements Serializable{
                /**
                 * id : 131
                 * type : 3
                 * title : null
                 * content : 他打我
                 * picture : http://oss.hotkungfu-tea.com/picture/1572524674744.jpg,http://oss.hotkungfu-tea.com/picture/1572524672461.mp4
                 * pictureWidth : 320
                 * pictureHeight : 568
                 * createTime : 1572524673000
                 * updateTime : 2019-10-31 20:24:33
                 * longitude : 114.261919
                 * latitude : 22.725447
                 * address : 深圳市灏盟信息科技有限公司
                 * cityCode : 0755
                 * member : {"userId":116,"nickName":"谨记 我给过","personalProfile":null,"gender":null,"birthday":null,"email":null,"phone":null,"photo":"http://oss.hotkungfu-tea.com/picture/1572513281998.jpg","realName":null,"idcard":null,"teaRiceMe":null,"teaRicePresent":null,"commission":null,"income":null,"sinaToken":null,"qq":null,"qqToken":null,"wechat":null,"wechatToken":null,"rongToken":null,"place":null,"integral":null,"isMaster":null,"isMerchant":null,"state":null,"delFlag":null,"loginIp":null,"loginDate":null,"qrcode":null,"createTime":null,"updateTime":null,"isSift":null,"buyMoney":null,"records":null,"master":{"id":131,"name":null,"portrait":null,"photo":null,"level":null,"specialty":null,"status":null,"introduceContent":null,"createTime":"2019-10-31T12:24:33.000+0000","updateTime":"2019-10-31T12:24:33.000+0000","masterAddress":null,"storeId":null,"isMerchant":null,"nickName":null,"count":0,"isAttention":0,"mid":116,"mId":116},"isAttention":0,"fanCount":null,"attentionNum":null,"dynamicNum":null,"isFirstLogin":null,"masterId":null,"memberLevel":null,"getReelStatus":0,"recordStatus":0,"productNum":null,"vip":false,"zhuanKe":false}
                 * isPraise : 0
                 * praiseNum : 1
                 * commentNum : 0
                 * isSift : null
                 * browseCount : 18
                 * mid : 116
                 */

                private int id;
                private int type;
                private String title;
                private String content;
                private String picture;
                private int pictureWidth;
                private int pictureHeight;
                private String createTime;
                private String updateTime;
                private double longitude;
                private double latitude;
                private String address;
                private String cityCode;
                private MemberBean member;
                private int isPraise;
                private int praiseNum;
                private int commentNum;
                private Object isSift;
                private int browseCount;
                private int mid;

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public int getType() {
                    return type;
                }

                public void setType(int type) {
                    this.type = type;
                }

                public String getTitle() {
                    return title;
                }

                public void setTitle(String title) {
                    this.title = title;
                }

                public String getContent() {
                    return content;
                }

                public void setContent(String content) {
                    this.content = content;
                }

                public String getPicture() {
                    return picture;
                }

                public void setPicture(String picture) {
                    this.picture = picture;
                }

                public int getPictureWidth() {
                    return pictureWidth;
                }

                public void setPictureWidth(int pictureWidth) {
                    this.pictureWidth = pictureWidth;
                }

                public int getPictureHeight() {
                    return pictureHeight;
                }

                public void setPictureHeight(int pictureHeight) {
                    this.pictureHeight = pictureHeight;
                }

                public String getCreateTime() {
                    return createTime;
                }

                public void setCreateTime(String createTime) {
                    this.createTime = createTime;
                }

                public String getUpdateTime() {
                    return updateTime;
                }

                public void setUpdateTime(String updateTime) {
                    this.updateTime = updateTime;
                }

                public double getLongitude() {
                    return longitude;
                }

                public void setLongitude(double longitude) {
                    this.longitude = longitude;
                }

                public double getLatitude() {
                    return latitude;
                }

                public void setLatitude(double latitude) {
                    this.latitude = latitude;
                }

                public String getAddress() {
                    return address;
                }

                public void setAddress(String address) {
                    this.address = address;
                }

                public String getCityCode() {
                    return cityCode;
                }

                public void setCityCode(String cityCode) {
                    this.cityCode = cityCode;
                }

                public MemberBean getMember() {
                    return member;
                }

                public void setMember(MemberBean member) {
                    this.member = member;
                }

                public int getIsPraise() {
                    return isPraise;
                }

                public void setIsPraise(int isPraise) {
                    this.isPraise = isPraise;
                }

                public int getPraiseNum() {
                    return praiseNum;
                }

                public void setPraiseNum(int praiseNum) {
                    this.praiseNum = praiseNum;
                }

                public int getCommentNum() {
                    return commentNum;
                }

                public void setCommentNum(int commentNum) {
                    this.commentNum = commentNum;
                }

                public Object getIsSift() {
                    return isSift;
                }

                public void setIsSift(Object isSift) {
                    this.isSift = isSift;
                }

                public int getBrowseCount() {
                    return browseCount;
                }

                public void setBrowseCount(int browseCount) {
                    this.browseCount = browseCount;
                }

                public int getMid() {
                    return mid;
                }

                public void setMid(int mid) {
                    this.mid = mid;
                }

                public static class MemberBean implements Serializable{
                    /**
                     * userId : 116
                     * nickName : 谨记 我给过
                     * personalProfile : null
                     * gender : null
                     * birthday : null
                     * email : null
                     * phone : null
                     * photo : http://oss.hotkungfu-tea.com/picture/1572513281998.jpg
                     * realName : null
                     * idcard : null
                     * teaRiceMe : null
                     * teaRicePresent : null
                     * commission : null
                     * income : null
                     * sinaToken : null
                     * qq : null
                     * qqToken : null
                     * wechat : null
                     * wechatToken : null
                     * rongToken : null
                     * place : null
                     * integral : null
                     * isMaster : null
                     * isMerchant : null
                     * state : null
                     * delFlag : null
                     * loginIp : null
                     * loginDate : null
                     * qrcode : null
                     * createTime : null
                     * updateTime : null
                     * isSift : null
                     * buyMoney : null
                     * records : null
                     * master : {"id":131,"name":null,"portrait":null,"photo":null,"level":null,"specialty":null,"status":null,"introduceContent":null,"createTime":"2019-10-31T12:24:33.000+0000","updateTime":"2019-10-31T12:24:33.000+0000","masterAddress":null,"storeId":null,"isMerchant":null,"nickName":null,"count":0,"isAttention":0,"mid":116,"mId":116}
                     * isAttention : 0
                     * fanCount : null
                     * attentionNum : null
                     * dynamicNum : null
                     * isFirstLogin : null
                     * masterId : null
                     * memberLevel : null
                     * getReelStatus : 0
                     * recordStatus : 0
                     * productNum : null
                     * vip : false
                     * zhuanKe : false
                     */

                    private int userId;
                    private String nickName;
                    private Object personalProfile;
                    private Object gender;
                    private Object birthday;
                    private Object email;
                    private Object phone;
                    private String photo;
                    private Object realName;
                    private Object idcard;
                    private Object teaRiceMe;
                    private Object teaRicePresent;
                    private Object commission;
                    private Object income;
                    private Object sinaToken;
                    private Object qq;
                    private Object qqToken;
                    private Object wechat;
                    private Object wechatToken;
                    private Object rongToken;
                    private Object place;
                    private Object integral;
                    private Object isMaster;
                    private Object isMerchant;
                    private Object state;
                    private Object delFlag;
                    private Object loginIp;
                    private Object loginDate;
                    private Object qrcode;
                    private Object createTime;
                    private Object updateTime;
                    private Object isSift;
                    private Object buyMoney;
                    private Object records;
                    private MasterBean master;
                    private int isAttention;
                    private Object fanCount;
                    private Object attentionNum;
                    private Object dynamicNum;
                    private Object isFirstLogin;
                    private Object masterId;
                    private Object memberLevel;
                    private int getReelStatus;
                    private int recordStatus;
                    private Object productNum;
                    private boolean vip;
                    private boolean zhuanKe;

                    public int getUserId() {
                        return userId;
                    }

                    public void setUserId(int userId) {
                        this.userId = userId;
                    }

                    public String getNickName() {
                        return nickName;
                    }

                    public void setNickName(String nickName) {
                        this.nickName = nickName;
                    }

                    public Object getPersonalProfile() {
                        return personalProfile;
                    }

                    public void setPersonalProfile(Object personalProfile) {
                        this.personalProfile = personalProfile;
                    }

                    public Object getGender() {
                        return gender;
                    }

                    public void setGender(Object gender) {
                        this.gender = gender;
                    }

                    public Object getBirthday() {
                        return birthday;
                    }

                    public void setBirthday(Object birthday) {
                        this.birthday = birthday;
                    }

                    public Object getEmail() {
                        return email;
                    }

                    public void setEmail(Object email) {
                        this.email = email;
                    }

                    public Object getPhone() {
                        return phone;
                    }

                    public void setPhone(Object phone) {
                        this.phone = phone;
                    }

                    public String getPhoto() {
                        return photo;
                    }

                    public void setPhoto(String photo) {
                        this.photo = photo;
                    }

                    public Object getRealName() {
                        return realName;
                    }

                    public void setRealName(Object realName) {
                        this.realName = realName;
                    }

                    public Object getIdcard() {
                        return idcard;
                    }

                    public void setIdcard(Object idcard) {
                        this.idcard = idcard;
                    }

                    public Object getTeaRiceMe() {
                        return teaRiceMe;
                    }

                    public void setTeaRiceMe(Object teaRiceMe) {
                        this.teaRiceMe = teaRiceMe;
                    }

                    public Object getTeaRicePresent() {
                        return teaRicePresent;
                    }

                    public void setTeaRicePresent(Object teaRicePresent) {
                        this.teaRicePresent = teaRicePresent;
                    }

                    public Object getCommission() {
                        return commission;
                    }

                    public void setCommission(Object commission) {
                        this.commission = commission;
                    }

                    public Object getIncome() {
                        return income;
                    }

                    public void setIncome(Object income) {
                        this.income = income;
                    }

                    public Object getSinaToken() {
                        return sinaToken;
                    }

                    public void setSinaToken(Object sinaToken) {
                        this.sinaToken = sinaToken;
                    }

                    public Object getQq() {
                        return qq;
                    }

                    public void setQq(Object qq) {
                        this.qq = qq;
                    }

                    public Object getQqToken() {
                        return qqToken;
                    }

                    public void setQqToken(Object qqToken) {
                        this.qqToken = qqToken;
                    }

                    public Object getWechat() {
                        return wechat;
                    }

                    public void setWechat(Object wechat) {
                        this.wechat = wechat;
                    }

                    public Object getWechatToken() {
                        return wechatToken;
                    }

                    public void setWechatToken(Object wechatToken) {
                        this.wechatToken = wechatToken;
                    }

                    public Object getRongToken() {
                        return rongToken;
                    }

                    public void setRongToken(Object rongToken) {
                        this.rongToken = rongToken;
                    }

                    public Object getPlace() {
                        return place;
                    }

                    public void setPlace(Object place) {
                        this.place = place;
                    }

                    public Object getIntegral() {
                        return integral;
                    }

                    public void setIntegral(Object integral) {
                        this.integral = integral;
                    }

                    public Object getIsMaster() {
                        return isMaster;
                    }

                    public void setIsMaster(Object isMaster) {
                        this.isMaster = isMaster;
                    }

                    public Object getIsMerchant() {
                        return isMerchant;
                    }

                    public void setIsMerchant(Object isMerchant) {
                        this.isMerchant = isMerchant;
                    }

                    public Object getState() {
                        return state;
                    }

                    public void setState(Object state) {
                        this.state = state;
                    }

                    public Object getDelFlag() {
                        return delFlag;
                    }

                    public void setDelFlag(Object delFlag) {
                        this.delFlag = delFlag;
                    }

                    public Object getLoginIp() {
                        return loginIp;
                    }

                    public void setLoginIp(Object loginIp) {
                        this.loginIp = loginIp;
                    }

                    public Object getLoginDate() {
                        return loginDate;
                    }

                    public void setLoginDate(Object loginDate) {
                        this.loginDate = loginDate;
                    }

                    public Object getQrcode() {
                        return qrcode;
                    }

                    public void setQrcode(Object qrcode) {
                        this.qrcode = qrcode;
                    }

                    public Object getCreateTime() {
                        return createTime;
                    }

                    public void setCreateTime(Object createTime) {
                        this.createTime = createTime;
                    }

                    public Object getUpdateTime() {
                        return updateTime;
                    }

                    public void setUpdateTime(Object updateTime) {
                        this.updateTime = updateTime;
                    }

                    public Object getIsSift() {
                        return isSift;
                    }

                    public void setIsSift(Object isSift) {
                        this.isSift = isSift;
                    }

                    public Object getBuyMoney() {
                        return buyMoney;
                    }

                    public void setBuyMoney(Object buyMoney) {
                        this.buyMoney = buyMoney;
                    }

                    public Object getRecords() {
                        return records;
                    }

                    public void setRecords(Object records) {
                        this.records = records;
                    }

                    public MasterBean getMaster() {
                        return master;
                    }

                    public void setMaster(MasterBean master) {
                        this.master = master;
                    }

                    public int getIsAttention() {
                        return isAttention;
                    }

                    public void setIsAttention(int isAttention) {
                        this.isAttention = isAttention;
                    }

                    public Object getFanCount() {
                        return fanCount;
                    }

                    public void setFanCount(Object fanCount) {
                        this.fanCount = fanCount;
                    }

                    public Object getAttentionNum() {
                        return attentionNum;
                    }

                    public void setAttentionNum(Object attentionNum) {
                        this.attentionNum = attentionNum;
                    }

                    public Object getDynamicNum() {
                        return dynamicNum;
                    }

                    public void setDynamicNum(Object dynamicNum) {
                        this.dynamicNum = dynamicNum;
                    }

                    public Object getIsFirstLogin() {
                        return isFirstLogin;
                    }

                    public void setIsFirstLogin(Object isFirstLogin) {
                        this.isFirstLogin = isFirstLogin;
                    }

                    public Object getMasterId() {
                        return masterId;
                    }

                    public void setMasterId(Object masterId) {
                        this.masterId = masterId;
                    }

                    public Object getMemberLevel() {
                        return memberLevel;
                    }

                    public void setMemberLevel(Object memberLevel) {
                        this.memberLevel = memberLevel;
                    }

                    public int getGetReelStatus() {
                        return getReelStatus;
                    }

                    public void setGetReelStatus(int getReelStatus) {
                        this.getReelStatus = getReelStatus;
                    }

                    public int getRecordStatus() {
                        return recordStatus;
                    }

                    public void setRecordStatus(int recordStatus) {
                        this.recordStatus = recordStatus;
                    }

                    public Object getProductNum() {
                        return productNum;
                    }

                    public void setProductNum(Object productNum) {
                        this.productNum = productNum;
                    }

                    public boolean isVip() {
                        return vip;
                    }

                    public void setVip(boolean vip) {
                        this.vip = vip;
                    }

                    public boolean isZhuanKe() {
                        return zhuanKe;
                    }

                    public void setZhuanKe(boolean zhuanKe) {
                        this.zhuanKe = zhuanKe;
                    }

                    public static class MasterBean implements Serializable{
                        /**
                         * id : 131
                         * name : null
                         * portrait : null
                         * photo : null
                         * level : null
                         * specialty : null
                         * status : null
                         * introduceContent : null
                         * createTime : 2019-10-31T12:24:33.000+0000
                         * updateTime : 2019-10-31T12:24:33.000+0000
                         * masterAddress : null
                         * storeId : null
                         * isMerchant : null
                         * nickName : null
                         * count : 0
                         * isAttention : 0
                         * mid : 116
                         * mId : 116
                         */

                        private int id;
                        private Object name;
                        private Object portrait;
                        private Object photo;
                        private Object level;
                        private Object specialty;
                        private Object status;
                        private Object introduceContent;
                        private String createTime;
                        private String updateTime;
                        private Object masterAddress;
                        private Object storeId;
                        private Object isMerchant;
                        private Object nickName;
                        private int count;
                        private int isAttention;
                        private int mid;
                        private int mId;

                        public int getId() {
                            return id;
                        }

                        public void setId(int id) {
                            this.id = id;
                        }

                        public Object getName() {
                            return name;
                        }

                        public void setName(Object name) {
                            this.name = name;
                        }

                        public Object getPortrait() {
                            return portrait;
                        }

                        public void setPortrait(Object portrait) {
                            this.portrait = portrait;
                        }

                        public Object getPhoto() {
                            return photo;
                        }

                        public void setPhoto(Object photo) {
                            this.photo = photo;
                        }

                        public Object getLevel() {
                            return level;
                        }

                        public void setLevel(Object level) {
                            this.level = level;
                        }

                        public Object getSpecialty() {
                            return specialty;
                        }

                        public void setSpecialty(Object specialty) {
                            this.specialty = specialty;
                        }

                        public Object getStatus() {
                            return status;
                        }

                        public void setStatus(Object status) {
                            this.status = status;
                        }

                        public Object getIntroduceContent() {
                            return introduceContent;
                        }

                        public void setIntroduceContent(Object introduceContent) {
                            this.introduceContent = introduceContent;
                        }

                        public String getCreateTime() {
                            return createTime;
                        }

                        public void setCreateTime(String createTime) {
                            this.createTime = createTime;
                        }

                        public String getUpdateTime() {
                            return updateTime;
                        }

                        public void setUpdateTime(String updateTime) {
                            this.updateTime = updateTime;
                        }

                        public Object getMasterAddress() {
                            return masterAddress;
                        }

                        public void setMasterAddress(Object masterAddress) {
                            this.masterAddress = masterAddress;
                        }

                        public Object getStoreId() {
                            return storeId;
                        }

                        public void setStoreId(Object storeId) {
                            this.storeId = storeId;
                        }

                        public Object getIsMerchant() {
                            return isMerchant;
                        }

                        public void setIsMerchant(Object isMerchant) {
                            this.isMerchant = isMerchant;
                        }

                        public Object getNickName() {
                            return nickName;
                        }

                        public void setNickName(Object nickName) {
                            this.nickName = nickName;
                        }

                        public int getCount() {
                            return count;
                        }

                        public void setCount(int count) {
                            this.count = count;
                        }

                        public int getIsAttention() {
                            return isAttention;
                        }

                        public void setIsAttention(int isAttention) {
                            this.isAttention = isAttention;
                        }

                        public int getMid() {
                            return mid;
                        }

                        public void setMid(int mid) {
                            this.mid = mid;
                        }

                        public int getMId() {
                            return mId;
                        }

                        public void setMId(int mId) {
                            this.mId = mId;
                        }
                    }
                }
            }
        }
    }
}
