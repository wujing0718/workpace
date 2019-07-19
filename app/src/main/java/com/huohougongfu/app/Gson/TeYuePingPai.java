package com.huohougongfu.app.Gson;

import java.util.List;

public class TeYuePingPai {
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
         * isSpecial : [{"id":2,"name":"品牌名称","isSpecial":"1","img":"图片","story":"阿斯蒂芬","order":"0","createTime":"2019-06-20T08:47:09.000+0000","updateTime":"2019-06-20T08:47:09.000+0000","address":"地址","productList":null}]
         * queryName : name
         * resultList : [{"id":1,"name":"阿萨德","isSpecial":"0","img":"阿斯蒂芬","story":"阿斯蒂芬","order":"1","createTime":"2019-06-14T05:43:21.000+0000","updateTime":"2019-06-20T08:47:28.000+0000","address":"地址","productList":[{"id":1,"name":"测试","categoryId":2,"keywords":"测试","model":"1","virtualNum":2,"price":25,"marketPrice":42,"integral":24,"stock":12,"warningStock":212,"coverUrl":"http://oss.irving.net.cn/tea/%E5%BE%AE%E4%BF%A1%E5%9B%BE%E7%89%87_20190621162756.jpg","state":1,"showOrder":12,"sellNum":12,"isNew":1,"unit":"1","transId":1,"createBy":1,"createTime":"2019-06-05T08:18:59.000+0000","updateBy":1,"updateTime":"2019-07-11T02:51:05.000+0000","del":0,"isRecommend":1,"isCheck":1,"limitIntegral":2020,"subhead":"202","remark":"阿斯顿发失地发生地方","weight":2,"count":2,"sendIntegral":2,"sendGrowth":2,"productPicture":"http://pic34.nipic.com/20131020/6704106_203943375000_2.jpg,http://pic13.nipic.com/20110409/7119492_114440620000_2.jpg,http://pic13.nipic.com/20110409/7119492_114440620000_2.jpg,http://pic13.nipic.com/20110409/7119492_114440620000_2.jpg","storeId":1,"isSift":0,"brandId":1,"mallStore":null,"sellCount":null,"num":null,"basicService":null,"productType":null,"transName":null,"priceType":null,"deliveryType":null,"defaultTransCost":null,"branName":null,"brandImg":null,"brandIsSpecial":null,"brandOrder":null,"brandAddress":null,"attributeId":null,"standardId":null,"userId":null,"collectionNum":null,"standard":null},{"id":19,"name":"测试19","categoryId":2,"keywords":"测试","model":"1","virtualNum":2,"price":25,"marketPrice":42,"integral":24,"stock":12,"warningStock":212,"coverUrl":"http://oss.irving.net.cn/tea/1911562737563_.pic_hd.jpg","state":1,"showOrder":12,"sellNum":12,"isNew":1,"unit":"1","transId":6,"createBy":1,"createTime":"2019-06-05T08:20:34.000+0000","updateBy":1,"updateTime":"2019-07-10T05:49:17.000+0000","del":0,"isRecommend":1,"isCheck":1,"limitIntegral":2020,"subhead":"202","remark":"阿斯顿发失地发生地方","weight":2,"count":2,"sendIntegral":2,"sendGrowth":2,"productPicture":"http://pic34.nipic.com/20131020/6704106_203943375000_2.jpg,http://pic13.nipic.com/20110409/7119492_114440620000_2.jpg,http://pic13.nipic.com/20110409/7119492_114440620000_2.jpg,http://pic13.nipic.com/20110409/7119492_114440620000_2.jpg","storeId":1,"isSift":1,"brandId":1,"mallStore":null,"sellCount":null,"num":null,"basicService":null,"productType":null,"transName":null,"priceType":null,"deliveryType":null,"defaultTransCost":null,"branName":null,"brandImg":null,"brandIsSpecial":null,"brandOrder":null,"brandAddress":null,"attributeId":null,"standardId":null,"userId":null,"collectionNum":null,"standard":null},{"id":21,"name":"测试21","categoryId":1,"keywords":"测试","model":"1","virtualNum":2,"price":25,"marketPrice":42,"integral":24,"stock":12,"warningStock":212,"coverUrl":"http://oss.irving.net.cn/tea/%E5%BE%AE%E4%BF%A1%E5%9B%BE%E7%89%87_20190621162756.jpg","state":1,"showOrder":12,"sellNum":12,"isNew":0,"unit":"1","transId":1,"createBy":1,"createTime":"2019-06-05T08:20:39.000+0000","updateBy":1,"updateTime":"2019-07-11T02:51:35.000+0000","del":0,"isRecommend":1,"isCheck":1,"limitIntegral":2020,"subhead":"202","remark":"阿斯顿发失地发生地方","weight":2,"count":2,"sendIntegral":2,"sendGrowth":2,"productPicture":"http://pic34.nipic.com/20131020/6704106_203943375000_2.jpg,http://pic13.nipic.com/20110409/7119492_114440620000_2.jpg,http://pic13.nipic.com/20110409/7119492_114440620000_2.jpg,http://pic13.nipic.com/20110409/7119492_114440620000_2.jpg","storeId":1,"isSift":0,"brandId":1,"mallStore":null,"sellCount":null,"num":null,"basicService":null,"productType":null,"transName":null,"priceType":null,"deliveryType":null,"defaultTransCost":null,"branName":null,"brandImg":null,"brandIsSpecial":null,"brandOrder":null,"brandAddress":null,"attributeId":null,"standardId":null,"userId":null,"collectionNum":null,"standard":null},{"id":22,"name":"测试22","categoryId":2,"keywords":"测试","model":"1","virtualNum":2,"price":25,"marketPrice":42,"integral":24,"stock":12,"warningStock":212,"coverUrl":"http://zhmp.oss-cn-shenzhen.aliyuncs.com/tea/%E5%BE%AE%E4%BF%A1%E5%9B%BE%E7%89%87_20190621162803.jpg","state":1,"showOrder":12,"sellNum":12,"isNew":0,"unit":"1","transId":7,"createBy":1,"createTime":"2019-06-05T08:20:41.000+0000","updateBy":1,"updateTime":"2019-07-11T02:51:28.000+0000","del":0,"isRecommend":1,"isCheck":1,"limitIntegral":2020,"subhead":"202","remark":"阿斯顿发失地发生地方","weight":2,"count":2,"sendIntegral":2,"sendGrowth":2,"productPicture":"http://pic34.nipic.com/20131020/6704106_203943375000_2.jpg,http://pic13.nipic.com/20110409/7119492_114440620000_2.jpg,http://pic13.nipic.com/20110409/7119492_114440620000_2.jpg,http://pic13.nipic.com/20110409/7119492_114440620000_2.jpg","storeId":1,"isSift":0,"brandId":1,"mallStore":null,"sellCount":null,"num":null,"basicService":null,"productType":null,"transName":null,"priceType":null,"deliveryType":null,"defaultTransCost":null,"branName":null,"brandImg":null,"brandIsSpecial":null,"brandOrder":null,"brandAddress":null,"attributeId":null,"standardId":null,"userId":null,"collectionNum":null,"standard":null},{"id":23,"name":"测试23","categoryId":1,"keywords":"测试","model":"1","virtualNum":2,"price":25,"marketPrice":42,"integral":24,"stock":12,"warningStock":212,"coverUrl":"http://zhmp.oss-cn-shenzhen.aliyuncs.com/tea/%E5%BE%AE%E4%BF%A1%E5%9B%BE%E7%89%87_20190621162803.jpg","state":1,"showOrder":12,"sellNum":12,"isNew":1,"unit":"1","transId":1,"createBy":1,"createTime":"2019-06-05T08:20:44.000+0000","updateBy":1,"updateTime":"2019-07-11T02:51:27.000+0000","del":0,"isRecommend":1,"isCheck":1,"limitIntegral":2020,"subhead":"202","remark":"阿斯顿发失地发生地方","weight":2,"count":2,"sendIntegral":2,"sendGrowth":2,"productPicture":"http://pic34.nipic.com/20131020/6704106_203943375000_2.jpg,http://pic13.nipic.com/20110409/7119492_114440620000_2.jpg,http://pic13.nipic.com/20110409/7119492_114440620000_2.jpg,http://pic13.nipic.com/20110409/7119492_114440620000_2.jpg","storeId":2,"isSift":1,"brandId":1,"mallStore":null,"sellCount":null,"num":null,"basicService":null,"productType":null,"transName":null,"priceType":null,"deliveryType":null,"defaultTransCost":null,"branName":null,"brandImg":null,"brandIsSpecial":null,"brandOrder":null,"brandAddress":null,"attributeId":null,"standardId":null,"userId":null,"collectionNum":null,"standard":null},{"id":26,"name":"测试26","categoryId":2,"keywords":"测试","model":"1","virtualNum":2,"price":25,"marketPrice":42,"integral":24,"stock":12,"warningStock":212,"coverUrl":"http://zhmp.oss-cn-shenzhen.aliyuncs.com/tea/%E5%BE%AE%E4%BF%A1%E5%9B%BE%E7%89%87_20190621162803.jpg","state":1,"showOrder":12,"sellNum":12,"isNew":1,"unit":"1","transId":1,"createBy":1,"createTime":"2019-06-05T08:20:49.000+0000","updateBy":1,"updateTime":"2019-07-11T02:51:24.000+0000","del":0,"isRecommend":1,"isCheck":1,"limitIntegral":2020,"subhead":"202","remark":"阿斯顿发失地发生地方","weight":2,"count":2,"sendIntegral":2,"sendGrowth":2,"productPicture":"http://pic34.nipic.com/20131020/6704106_203943375000_2.jpg,http://pic13.nipic.com/20110409/7119492_114440620000_2.jpg,http://pic13.nipic.com/20110409/7119492_114440620000_2.jpg,http://pic13.nipic.com/20110409/7119492_114440620000_2.jpg","storeId":2,"isSift":0,"brandId":1,"mallStore":null,"sellCount":null,"num":null,"basicService":null,"productType":null,"transName":null,"priceType":null,"deliveryType":null,"defaultTransCost":null,"branName":null,"brandImg":null,"brandIsSpecial":null,"brandOrder":null,"brandAddress":null,"attributeId":null,"standardId":null,"userId":null,"collectionNum":null,"standard":null},{"id":30,"name":"测试30","categoryId":2,"keywords":"测试","model":"1","virtualNum":2,"price":25,"marketPrice":42,"integral":24,"stock":12,"warningStock":212,"coverUrl":"1212","state":1,"showOrder":12,"sellNum":12,"isNew":1,"unit":"1","transId":8,"createBy":1,"createTime":"2019-06-05T08:20:55.000+0000","updateBy":1,"updateTime":"2019-07-03T06:02:55.000+0000","del":0,"isRecommend":1,"isCheck":1,"limitIntegral":2020,"subhead":"202","remark":"阿斯顿发失地发生地方","weight":2,"count":2,"sendIntegral":2,"sendGrowth":2,"productPicture":"http://pic34.nipic.com/20131020/6704106_203943375000_2.jpg,http://pic13.nipic.com/20110409/7119492_114440620000_2.jpg,http://pic13.nipic.com/20110409/7119492_114440620000_2.jpg,http://pic13.nipic.com/20110409/7119492_114440620000_2.jpg","storeId":2,"isSift":1,"brandId":1,"mallStore":null,"sellCount":null,"num":null,"basicService":null,"productType":null,"transName":null,"priceType":null,"deliveryType":null,"defaultTransCost":null,"branName":null,"brandImg":null,"brandIsSpecial":null,"brandOrder":null,"brandAddress":null,"attributeId":null,"standardId":null,"userId":null,"collectionNum":null,"standard":null},{"id":32,"name":"测试32","categoryId":1,"keywords":"测试","model":"1","virtualNum":2,"price":25,"marketPrice":42,"integral":24,"stock":12,"warningStock":212,"coverUrl":"1212","state":1,"showOrder":12,"sellNum":12,"isNew":1,"unit":"1","transId":1,"createBy":1,"createTime":"2019-06-05T08:20:57.000+0000","updateBy":1,"updateTime":"2019-07-03T06:02:57.000+0000","del":0,"isRecommend":1,"isCheck":1,"limitIntegral":2020,"subhead":"202","remark":"阿斯顿发失地发生地方","weight":2,"count":2,"sendIntegral":2,"sendGrowth":2,"productPicture":"http://pic34.nipic.com/20131020/6704106_203943375000_2.jpg,http://pic13.nipic.com/20110409/7119492_114440620000_2.jpg,http://pic13.nipic.com/20110409/7119492_114440620000_2.jpg,http://pic13.nipic.com/20110409/7119492_114440620000_2.jpg","storeId":5,"isSift":1,"brandId":1,"mallStore":null,"sellCount":null,"num":null,"basicService":null,"productType":null,"transName":null,"priceType":null,"deliveryType":null,"defaultTransCost":null,"branName":null,"brandImg":null,"brandIsSpecial":null,"brandOrder":null,"brandAddress":null,"attributeId":null,"standardId":null,"userId":null,"collectionNum":null,"standard":null},{"id":34,"name":"测试34","categoryId":2,"keywords":"测试","model":"1","virtualNum":2,"price":25,"marketPrice":42,"integral":24,"stock":12,"warningStock":212,"coverUrl":"1212","state":1,"showOrder":12,"sellNum":12,"isNew":1,"unit":"1","transId":1,"createBy":1,"createTime":"2019-06-05T08:21:00.000+0000","updateBy":1,"updateTime":"2019-07-03T06:02:59.000+0000","del":0,"isRecommend":1,"isCheck":1,"limitIntegral":2020,"subhead":"202","remark":"阿斯顿发失地发生地方","weight":2,"count":2,"sendIntegral":2,"sendGrowth":2,"productPicture":"http://pic34.nipic.com/20131020/6704106_203943375000_2.jpg,http://pic13.nipic.com/20110409/7119492_114440620000_2.jpg,http://pic13.nipic.com/20110409/7119492_114440620000_2.jpg,http://pic13.nipic.com/20110409/7119492_114440620000_2.jpg","storeId":5,"isSift":0,"brandId":1,"mallStore":null,"sellCount":null,"num":null,"basicService":null,"productType":null,"transName":null,"priceType":null,"deliveryType":null,"defaultTransCost":null,"branName":null,"brandImg":null,"brandIsSpecial":null,"brandOrder":null,"brandAddress":null,"attributeId":null,"standardId":null,"userId":null,"collectionNum":null,"standard":null},{"id":36,"name":"奥术大师多","categoryId":1,"keywords":"奥术大师多","model":"1","virtualNum":25,"price":25.45,"marketPrice":25.45,"integral":5,"stock":15,"warningStock":10,"coverUrl":"封面","state":1,"showOrder":12,"sellNum":11,"isNew":0,"unit":"12","transId":1,"createBy":1,"createTime":"2019-02-14T02:00:00.000+0000","updateBy":2,"updateTime":"2019-07-02T09:06:23.000+0000","del":0,"isRecommend":0,"isCheck":0,"limitIntegral":2,"subhead":"副标题","remark":"商品描述","weight":5,"count":5,"sendIntegral":5,"sendGrowth":5,"productPicture":"http://pic34.nipic.com/20131020/6704106_203943375000_2.jpg,http://pic13.nipic.com/20110409/7119492_114440620000_2.jpg,http://pic13.nipic.com/20110409/7119492_114440620000_2.jpg,http://pic13.nipic.com/20110409/7119492_114440620000_2.jpg","storeId":7,"isSift":1,"brandId":1,"mallStore":null,"sellCount":null,"num":null,"basicService":null,"productType":null,"transName":null,"priceType":null,"deliveryType":null,"defaultTransCost":null,"branName":null,"brandImg":null,"brandIsSpecial":null,"brandOrder":null,"brandAddress":null,"attributeId":null,"standardId":null,"userId":null,"collectionNum":null,"standard":null},{"id":38,"name":"商品标题","categoryId":2,"keywords":"商品关键字","model":"1","virtualNum":25,"price":25.45,"marketPrice":12,"integral":5,"stock":15,"warningStock":10,"coverUrl":"封面图","state":1,"showOrder":0,"sellNum":11,"isNew":1,"unit":"12","transId":4,"createBy":11,"createTime":"2019-02-14T02:00:00.000+0000","updateBy":1,"updateTime":"2019-07-03T06:03:03.000+0000","del":0,"isRecommend":0,"isCheck":0,"limitIntegral":2,"subhead":"副标题6666666","remark":"商品描述66666666666","weight":5,"count":45,"sendIntegral":5,"sendGrowth":21,"productPicture":"http://pic34.nipic.com/20131020/6704106_203943375000_2.jpg,http://pic13.nipic.com/20110409/7119492_114440620000_2.jpg,http://pic13.nipic.com/20110409/7119492_114440620000_2.jpg,http://pic13.nipic.com/20110409/7119492_114440620000_2.jpg","storeId":1,"isSift":0,"brandId":1,"mallStore":null,"sellCount":null,"num":null,"basicService":null,"productType":null,"transName":null,"priceType":null,"deliveryType":null,"defaultTransCost":null,"branName":null,"brandImg":null,"brandIsSpecial":null,"brandOrder":null,"brandAddress":null,"attributeId":null,"standardId":null,"userId":null,"collectionNum":null,"standard":null},{"id":40,"name":"商品标题","categoryId":2,"keywords":"商品关键字","model":"2","virtualNum":25,"price":25.45,"marketPrice":12,"integral":5,"stock":15,"warningStock":10,"coverUrl":"封面图","state":1,"showOrder":0,"sellNum":11,"isNew":1,"unit":"12","transId":1,"createBy":11,"createTime":"2019-02-14T02:00:00.000+0000","updateBy":1,"updateTime":"2019-07-02T09:06:37.000+0000","del":0,"isRecommend":0,"isCheck":0,"limitIntegral":2,"subhead":"副标题6666666","remark":"商品描述66666666666","weight":5,"count":45,"sendIntegral":5,"sendGrowth":21,"productPicture":"http://pic34.nipic.com/20131020/6704106_203943375000_2.jpg,http://pic13.nipic.com/20110409/7119492_114440620000_2.jpg,http://pic13.nipic.com/20110409/7119492_114440620000_2.jpg,http://pic13.nipic.com/20110409/7119492_114440620000_2.jpg","storeId":1,"isSift":1,"brandId":1,"mallStore":null,"sellCount":null,"num":null,"basicService":null,"productType":null,"transName":null,"priceType":null,"deliveryType":null,"defaultTransCost":null,"branName":null,"brandImg":null,"brandIsSpecial":null,"brandOrder":null,"brandAddress":null,"attributeId":null,"standardId":null,"userId":null,"collectionNum":null,"standard":null},{"id":41,"name":"商品标题","categoryId":2,"keywords":"商品关键字","model":"1","virtualNum":25,"price":25.45,"marketPrice":12,"integral":5,"stock":15,"warningStock":10,"coverUrl":"封面图","state":1,"showOrder":0,"sellNum":11,"isNew":1,"unit":"12","transId":1,"createBy":11,"createTime":"2019-02-14T02:00:00.000+0000","updateBy":1,"updateTime":"2019-07-02T09:06:39.000+0000","del":0,"isRecommend":0,"isCheck":0,"limitIntegral":2,"subhead":"副标题6666666","remark":"商品描述66666666666","weight":5,"count":45,"sendIntegral":5,"sendGrowth":21,"productPicture":"http://pic34.nipic.com/20131020/6704106_203943375000_2.jpg,http://pic13.nipic.com/20110409/7119492_114440620000_2.jpg,http://pic13.nipic.com/20110409/7119492_114440620000_2.jpg,http://pic13.nipic.com/20110409/7119492_114440620000_2.jpg","storeId":1,"isSift":1,"brandId":1,"mallStore":null,"sellCount":null,"num":null,"basicService":null,"productType":null,"transName":null,"priceType":null,"deliveryType":null,"defaultTransCost":null,"branName":null,"brandImg":null,"brandIsSpecial":null,"brandOrder":null,"brandAddress":null,"attributeId":null,"standardId":null,"userId":null,"collectionNum":null,"standard":null},{"id":42,"name":"商品标题","categoryId":2,"keywords":"商品关键字","model":"2","virtualNum":25,"price":25.45,"marketPrice":12,"integral":5,"stock":15,"warningStock":10,"coverUrl":"封面图","state":1,"showOrder":0,"sellNum":11,"isNew":1,"unit":"12","transId":1,"createBy":11,"createTime":"2019-02-14T02:00:00.000+0000","updateBy":1,"updateTime":"2019-07-02T09:06:40.000+0000","del":0,"isRecommend":0,"isCheck":0,"limitIntegral":2,"subhead":"副标题6666666","remark":"商品描述66666666666","weight":5,"count":45,"sendIntegral":5,"sendGrowth":21,"productPicture":"http://pic34.nipic.com/20131020/6704106_203943375000_2.jpg,http://pic13.nipic.com/20110409/7119492_114440620000_2.jpg,http://pic13.nipic.com/20110409/7119492_114440620000_2.jpg,http://pic13.nipic.com/20110409/7119492_114440620000_2.jpg","storeId":1,"isSift":1,"brandId":1,"mallStore":null,"sellCount":null,"num":null,"basicService":null,"productType":null,"transName":null,"priceType":null,"deliveryType":null,"defaultTransCost":null,"branName":null,"brandImg":null,"brandIsSpecial":null,"brandOrder":null,"brandAddress":null,"attributeId":null,"standardId":null,"userId":null,"collectionNum":null,"standard":null},{"id":43,"name":"商品标题","categoryId":2,"keywords":"商品关键字","model":"1","virtualNum":25,"price":25.45,"marketPrice":12,"integral":5,"stock":15,"warningStock":10,"coverUrl":"封面图","state":1,"showOrder":0,"sellNum":11,"isNew":1,"unit":"12","transId":5,"createBy":11,"createTime":"2019-02-14T02:00:00.000+0000","updateBy":1,"updateTime":"2019-07-02T09:06:41.000+0000","del":0,"isRecommend":0,"isCheck":0,"limitIntegral":2,"subhead":"副标题6666666","remark":"商品描述66666666666","weight":5,"count":45,"sendIntegral":5,"sendGrowth":21,"productPicture":"http://pic34.nipic.com/20131020/6704106_203943375000_2.jpg,http://pic13.nipic.com/20110409/7119492_114440620000_2.jpg,http://pic13.nipic.com/20110409/7119492_114440620000_2.jpg,http://pic13.nipic.com/20110409/7119492_114440620000_2.jpg","storeId":1,"isSift":1,"brandId":1,"mallStore":null,"sellCount":null,"num":null,"basicService":null,"productType":null,"transName":null,"priceType":null,"deliveryType":null,"defaultTransCost":null,"branName":null,"brandImg":null,"brandIsSpecial":null,"brandOrder":null,"brandAddress":null,"attributeId":null,"standardId":null,"userId":null,"collectionNum":null,"standard":null},{"id":45,"name":"商品标题","categoryId":1,"keywords":"商品关键字","model":"1","virtualNum":1,"price":1,"marketPrice":1,"integral":1,"stock":33,"warningStock":1,"coverUrl":"http://img2.imgtn.bdimg.com/it/u=180868167,273146879&fm=26&gp=0.jpg","state":1,"showOrder":1,"sellNum":1560,"isNew":1,"unit":"1","transId":2,"createBy":1,"createTime":"2019-06-13T03:00:00.000+0000","updateBy":1,"updateTime":"2019-07-09T06:27:56.000+0000","del":1,"isRecommend":1,"isCheck":1,"limitIntegral":1,"subhead":"1","remark":"1","weight":1,"count":1,"sendIntegral":1,"sendGrowth":1,"productPicture":"http://pic34.nipic.com/20131020/6704106_203943375000_2.jpg,http://pic13.nipic.com/20110409/7119492_114440620000_2.jpg,http://pic13.nipic.com/20110409/7119492_114440620000_2.jpg,http://pic13.nipic.com/20110409/7119492_114440620000_2.jpg","storeId":1,"isSift":1,"brandId":1,"mallStore":null,"sellCount":null,"num":null,"basicService":null,"productType":null,"transName":null,"priceType":null,"deliveryType":null,"defaultTransCost":null,"branName":null,"brandImg":null,"brandIsSpecial":null,"brandOrder":null,"brandAddress":null,"attributeId":null,"standardId":null,"userId":null,"collectionNum":null,"standard":null},{"id":47,"name":"商品标题","categoryId":1,"keywords":"商品关键字","model":"2","virtualNum":0,"price":75,"marketPrice":75,"integral":0,"stock":11,"warningStock":12,"coverUrl":"封面图片","state":1,"showOrder":1,"sellNum":1560,"isNew":1,"unit":"1","transId":1,"createBy":1,"createTime":"2019-06-21T08:49:22.000+0000","updateBy":1,"updateTime":"2019-07-02T09:06:47.000+0000","del":1,"isRecommend":1,"isCheck":1,"limitIntegral":1,"subhead":"1","remark":"1","weight":12,"count":21,"sendIntegral":12,"sendGrowth":12,"productPicture":"http://pic34.nipic.com/20131020/6704106_203943375000_2.jpg,http://pic13.nipic.com/20110409/7119492_114440620000_2.jpg,http://pic13.nipic.com/20110409/7119492_114440620000_2.jpg,http://pic13.nipic.com/20110409/7119492_114440620000_2.jpg","storeId":1,"isSift":1,"brandId":1,"mallStore":null,"sellCount":null,"num":null,"basicService":null,"productType":null,"transName":null,"priceType":null,"deliveryType":null,"defaultTransCost":null,"branName":null,"brandImg":null,"brandIsSpecial":null,"brandOrder":null,"brandAddress":null,"attributeId":null,"standardId":null,"userId":null,"collectionNum":null,"standard":null},{"id":48,"name":"商品标题","categoryId":2,"keywords":"茶","model":null,"virtualNum":null,"price":100,"marketPrice":100,"integral":null,"stock":null,"warningStock":null,"coverUrl":"封面图","state":null,"showOrder":1,"sellNum":null,"isNew":1,"unit":"克","transId":null,"createBy":1,"createTime":null,"updateBy":null,"updateTime":"2019-07-16T06:18:33.000+0000","del":null,"isRecommend":null,"isCheck":null,"limitIntegral":null,"subhead":"副标题","remark":"商品描述","weight":null,"count":null,"sendIntegral":null,"sendGrowth":null,"productPicture":"产品图片","storeId":1,"isSift":1,"brandId":1,"mallStore":null,"sellCount":null,"num":null,"basicService":null,"productType":null,"transName":null,"priceType":null,"deliveryType":null,"defaultTransCost":null,"branName":null,"brandImg":null,"brandIsSpecial":null,"brandOrder":null,"brandAddress":null,"attributeId":null,"standardId":null,"userId":null,"collectionNum":null,"standard":null},{"id":53,"name":"商品标题","categoryId":2,"keywords":"茶","model":"","virtualNum":0,"price":100,"marketPrice":100,"integral":0,"stock":null,"warningStock":null,"coverUrl":"封面图","state":0,"showOrder":1,"sellNum":0,"isNew":1,"unit":"克","transId":0,"createBy":1,"createTime":"2019-06-28T01:46:26.000+0000","updateBy":null,"updateTime":"2019-06-28T01:46:26.000+0000","del":0,"isRecommend":0,"isCheck":0,"limitIntegral":null,"subhead":"副标题","remark":"商品描述","weight":null,"count":null,"sendIntegral":null,"sendGrowth":null,"productPicture":"产品图片","storeId":1,"isSift":0,"brandId":1,"mallStore":null,"sellCount":null,"num":null,"basicService":null,"productType":null,"transName":null,"priceType":null,"deliveryType":null,"defaultTransCost":null,"branName":null,"brandImg":null,"brandIsSpecial":null,"brandOrder":null,"brandAddress":null,"attributeId":null,"standardId":null,"userId":null,"collectionNum":null,"standard":null},{"id":54,"name":"商品标题","categoryId":2,"keywords":"茶","model":"","virtualNum":0,"price":100,"marketPrice":100,"integral":0,"stock":null,"warningStock":null,"coverUrl":"封面图","state":0,"showOrder":1,"sellNum":0,"isNew":1,"unit":"克","transId":0,"createBy":1,"createTime":"2019-06-28T01:46:55.000+0000","updateBy":null,"updateTime":"2019-06-28T01:46:55.000+0000","del":0,"isRecommend":0,"isCheck":0,"limitIntegral":null,"subhead":"副标题","remark":"商品描述","weight":null,"count":null,"sendIntegral":null,"sendGrowth":null,"productPicture":"产品图片","storeId":1,"isSift":0,"brandId":1,"mallStore":null,"sellCount":null,"num":null,"basicService":null,"productType":null,"transName":null,"priceType":null,"deliveryType":null,"defaultTransCost":null,"branName":null,"brandImg":null,"brandIsSpecial":null,"brandOrder":null,"brandAddress":null,"attributeId":null,"standardId":null,"userId":null,"collectionNum":null,"standard":null},{"id":55,"name":"商品标题","categoryId":2,"keywords":"茶","model":"","virtualNum":0,"price":100,"marketPrice":100,"integral":0,"stock":null,"warningStock":null,"coverUrl":"封面图","state":0,"showOrder":1,"sellNum":0,"isNew":1,"unit":"克","transId":0,"createBy":1,"createTime":"2019-06-28T02:21:21.000+0000","updateBy":null,"updateTime":"2019-06-28T02:21:21.000+0000","del":0,"isRecommend":0,"isCheck":0,"limitIntegral":null,"subhead":"副标题","remark":"商品描述","weight":null,"count":null,"sendIntegral":null,"sendGrowth":null,"productPicture":"产品图片","storeId":1,"isSift":0,"brandId":1,"mallStore":null,"sellCount":null,"num":null,"basicService":null,"productType":null,"transName":null,"priceType":null,"deliveryType":null,"defaultTransCost":null,"branName":null,"brandImg":null,"brandIsSpecial":null,"brandOrder":null,"brandAddress":null,"attributeId":null,"standardId":null,"userId":null,"collectionNum":null,"standard":null},{"id":56,"name":"商品标题","categoryId":2,"keywords":"茶","model":"","virtualNum":0,"price":100,"marketPrice":100,"integral":0,"stock":null,"warningStock":null,"coverUrl":"封面图","state":0,"showOrder":1,"sellNum":0,"isNew":1,"unit":"克","transId":0,"createBy":1,"createTime":"2019-06-28T02:26:52.000+0000","updateBy":null,"updateTime":"2019-06-28T02:26:52.000+0000","del":0,"isRecommend":0,"isCheck":0,"limitIntegral":null,"subhead":"副标题","remark":"商品描述","weight":null,"count":null,"sendIntegral":null,"sendGrowth":null,"productPicture":"产品图片","storeId":1,"isSift":0,"brandId":1,"mallStore":null,"sellCount":null,"num":null,"basicService":null,"productType":null,"transName":null,"priceType":null,"deliveryType":null,"defaultTransCost":null,"branName":null,"brandImg":null,"brandIsSpecial":null,"brandOrder":null,"brandAddress":null,"attributeId":null,"standardId":null,"userId":null,"collectionNum":null,"standard":null},{"id":57,"name":"商品标题","categoryId":2,"keywords":"茶","model":"","virtualNum":0,"price":100,"marketPrice":100,"integral":0,"stock":null,"warningStock":null,"coverUrl":"封面图","state":0,"showOrder":1,"sellNum":0,"isNew":1,"unit":"克","transId":0,"createBy":1,"createTime":"2019-06-28T02:26:59.000+0000","updateBy":null,"updateTime":"2019-06-28T02:26:59.000+0000","del":0,"isRecommend":0,"isCheck":0,"limitIntegral":null,"subhead":"副标题","remark":"商品描述","weight":null,"count":null,"sendIntegral":null,"sendGrowth":null,"productPicture":"产品图片","storeId":1,"isSift":0,"brandId":1,"mallStore":null,"sellCount":null,"num":null,"basicService":null,"productType":null,"transName":null,"priceType":null,"deliveryType":null,"defaultTransCost":null,"branName":null,"brandImg":null,"brandIsSpecial":null,"brandOrder":null,"brandAddress":null,"attributeId":null,"standardId":null,"userId":null,"collectionNum":null,"standard":null},{"id":58,"name":"商品标题","categoryId":2,"keywords":"茶","model":"","virtualNum":0,"price":100,"marketPrice":100,"integral":0,"stock":null,"warningStock":null,"coverUrl":"封面图","state":0,"showOrder":1,"sellNum":0,"isNew":1,"unit":"克","transId":0,"createBy":1,"createTime":"2019-06-28T02:29:04.000+0000","updateBy":null,"updateTime":"2019-06-28T02:29:04.000+0000","del":0,"isRecommend":0,"isCheck":0,"limitIntegral":null,"subhead":"副标题","remark":"商品描述","weight":null,"count":null,"sendIntegral":null,"sendGrowth":null,"productPicture":"产品图片","storeId":1,"isSift":0,"brandId":1,"mallStore":null,"sellCount":null,"num":null,"basicService":null,"productType":null,"transName":null,"priceType":null,"deliveryType":null,"defaultTransCost":null,"branName":null,"brandImg":null,"brandIsSpecial":null,"brandOrder":null,"brandAddress":null,"attributeId":null,"standardId":null,"userId":null,"collectionNum":null,"standard":null},{"id":59,"name":"好运来","categoryId":1,"keywords":"红茶","model":"","virtualNum":0,"price":25.6,"marketPrice":35,"integral":0,"stock":null,"warningStock":null,"coverUrl":"快快快","state":0,"showOrder":3,"sellNum":0,"isNew":1,"unit":"g","transId":0,"createBy":33,"createTime":"2019-07-08T04:47:37.000+0000","updateBy":null,"updateTime":"2019-07-08T04:47:37.000+0000","del":0,"isRecommend":0,"isCheck":0,"limitIntegral":null,"subhead":"","remark":"fgfgfgfg","weight":null,"count":null,"sendIntegral":null,"sendGrowth":null,"productPicture":"gfgfggffff","storeId":23,"isSift":1,"brandId":1,"mallStore":null,"sellCount":null,"num":null,"basicService":null,"productType":null,"transName":null,"priceType":null,"deliveryType":null,"defaultTransCost":null,"branName":null,"brandImg":null,"brandIsSpecial":null,"brandOrder":null,"brandAddress":null,"attributeId":null,"standardId":null,"userId":null,"collectionNum":null,"standard":null},{"id":60,"name":"好运来","categoryId":1,"keywords":"红茶","model":"","virtualNum":0,"price":25.6,"marketPrice":35,"integral":0,"stock":null,"warningStock":null,"coverUrl":"快快快","state":0,"showOrder":3,"sellNum":0,"isNew":1,"unit":"g","transId":0,"createBy":33,"createTime":"2019-07-08T06:00:25.000+0000","updateBy":null,"updateTime":"2019-07-08T06:00:25.000+0000","del":0,"isRecommend":0,"isCheck":0,"limitIntegral":null,"subhead":"","remark":"fgfgfgfg","weight":null,"count":null,"sendIntegral":null,"sendGrowth":null,"productPicture":"gfgfggffff","storeId":23,"isSift":1,"brandId":1,"mallStore":null,"sellCount":null,"num":null,"basicService":null,"productType":null,"transName":null,"priceType":null,"deliveryType":null,"defaultTransCost":null,"branName":null,"brandImg":null,"brandIsSpecial":null,"brandOrder":null,"brandAddress":null,"attributeId":null,"standardId":null,"userId":null,"collectionNum":null,"standard":null},{"id":61,"name":"好运来","categoryId":1,"keywords":"红茶","model":"","virtualNum":0,"price":25.6,"marketPrice":35,"integral":0,"stock":null,"warningStock":null,"coverUrl":"快快快","state":0,"showOrder":3,"sellNum":0,"isNew":1,"unit":"g","transId":0,"createBy":33,"createTime":"2019-07-08T07:12:52.000+0000","updateBy":null,"updateTime":"2019-07-08T07:12:52.000+0000","del":0,"isRecommend":0,"isCheck":0,"limitIntegral":null,"subhead":"","remark":"fgfgfgfg","weight":null,"count":null,"sendIntegral":null,"sendGrowth":null,"productPicture":"gfgfggffff","storeId":23,"isSift":1,"brandId":1,"mallStore":null,"sellCount":null,"num":null,"basicService":null,"productType":null,"transName":null,"priceType":null,"deliveryType":null,"defaultTransCost":null,"branName":null,"brandImg":null,"brandIsSpecial":null,"brandOrder":null,"brandAddress":null,"attributeId":null,"standardId":null,"userId":null,"collectionNum":null,"standard":null},{"id":62,"name":"好运来","categoryId":1,"keywords":"红茶","model":"","virtualNum":0,"price":25.6,"marketPrice":35,"integral":0,"stock":null,"warningStock":null,"coverUrl":"快快快","state":0,"showOrder":3,"sellNum":0,"isNew":1,"unit":"g","transId":0,"createBy":33,"createTime":"2019-07-08T07:15:01.000+0000","updateBy":null,"updateTime":"2019-07-08T07:15:01.000+0000","del":0,"isRecommend":0,"isCheck":0,"limitIntegral":null,"subhead":"","remark":"fgfgfgfg","weight":null,"count":null,"sendIntegral":null,"sendGrowth":null,"productPicture":"gfgfggffff","storeId":23,"isSift":1,"brandId":1,"mallStore":null,"sellCount":null,"num":null,"basicService":null,"productType":null,"transName":null,"priceType":null,"deliveryType":null,"defaultTransCost":null,"branName":null,"brandImg":null,"brandIsSpecial":null,"brandOrder":null,"brandAddress":null,"attributeId":null,"standardId":null,"userId":null,"collectionNum":null,"standard":null},{"id":20,"name":"测试20","categoryId":2,"keywords":"测试","model":"1","virtualNum":2,"price":25,"marketPrice":42,"integral":24,"stock":12,"warningStock":212,"coverUrl":"http://oss.irving.net.cn/tea/%E5%BE%AE%E4%BF%A1%E5%9B%BE%E7%89%87_20190621162756.jpg","state":1,"showOrder":12,"sellNum":12,"isNew":1,"unit":"1","transId":1,"createBy":1,"createTime":"2019-06-05T08:20:38.000+0000","updateBy":1,"updateTime":"2019-07-11T02:51:34.000+0000","del":0,"isRecommend":1,"isCheck":1,"limitIntegral":2020,"subhead":"202","remark":"阿斯顿发失地发生地方","weight":2,"count":2,"sendIntegral":2,"sendGrowth":2,"productPicture":"http://pic34.nipic.com/20131020/6704106_203943375000_2.jpg,http://pic13.nipic.com/20110409/7119492_114440620000_2.jpg,http://pic13.nipic.com/20110409/7119492_114440620000_2.jpg,http://pic13.nipic.com/20110409/7119492_114440620000_2.jpg","storeId":1,"isSift":1,"brandId":2,"mallStore":null,"sellCount":null,"num":null,"basicService":null,"productType":null,"transName":null,"priceType":null,"deliveryType":null,"defaultTransCost":null,"branName":null,"brandImg":null,"brandIsSpecial":null,"brandOrder":null,"brandAddress":null,"attributeId":null,"standardId":null,"userId":null,"collectionNum":null,"standard":null},{"id":24,"name":"测试24","categoryId":2,"keywords":"测试","model":"1","virtualNum":2,"price":25,"marketPrice":42,"integral":24,"stock":12,"warningStock":212,"coverUrl":"http://zhmp.oss-cn-shenzhen.aliyuncs.com/tea/%E5%BE%AE%E4%BF%A1%E5%9B%BE%E7%89%87_20190621162803.jpg","state":1,"showOrder":12,"sellNum":12,"isNew":1,"unit":"1","transId":1,"createBy":1,"createTime":"2019-06-05T08:20:46.000+0000","updateBy":1,"updateTime":"2019-07-11T02:51:26.000+0000","del":0,"isRecommend":1,"isCheck":1,"limitIntegral":2020,"subhead":"202","remark":"阿斯顿发失地发生地方","weight":2,"count":2,"sendIntegral":2,"sendGrowth":2,"productPicture":"http://pic34.nipic.com/20131020/6704106_203943375000_2.jpg,http://pic13.nipic.com/20110409/7119492_114440620000_2.jpg,http://pic13.nipic.com/20110409/7119492_114440620000_2.jpg,http://pic13.nipic.com/20110409/7119492_114440620000_2.jpg","storeId":2,"isSift":1,"brandId":2,"mallStore":null,"sellCount":null,"num":null,"basicService":null,"productType":null,"transName":null,"priceType":null,"deliveryType":null,"defaultTransCost":null,"branName":null,"brandImg":null,"brandIsSpecial":null,"brandOrder":null,"brandAddress":null,"attributeId":null,"standardId":null,"userId":null,"collectionNum":null,"standard":null},{"id":25,"name":"测试25","categoryId":2,"keywords":"测试","model":"1","virtualNum":2,"price":25,"marketPrice":42,"integral":24,"stock":12,"warningStock":212,"coverUrl":"http://zhmp.oss-cn-shenzhen.aliyuncs.com/tea/%E5%BE%AE%E4%BF%A1%E5%9B%BE%E7%89%87_20190621162803.jpg","state":1,"showOrder":12,"sellNum":12,"isNew":1,"unit":"1","transId":9,"createBy":1,"createTime":"2019-06-05T08:20:48.000+0000","updateBy":1,"updateTime":"2019-07-11T02:51:25.000+0000","del":0,"isRecommend":1,"isCheck":1,"limitIntegral":2020,"subhead":"202","remark":"阿斯顿发失地发生地方","weight":2,"count":2,"sendIntegral":2,"sendGrowth":2,"productPicture":"http://pic34.nipic.com/20131020/6704106_203943375000_2.jpg,http://pic13.nipic.com/20110409/7119492_114440620000_2.jpg,http://pic13.nipic.com/20110409/7119492_114440620000_2.jpg,http://pic13.nipic.com/20110409/7119492_114440620000_2.jpg","storeId":2,"isSift":1,"brandId":2,"mallStore":null,"sellCount":null,"num":null,"basicService":null,"productType":null,"transName":null,"priceType":null,"deliveryType":null,"defaultTransCost":null,"branName":null,"brandImg":null,"brandIsSpecial":null,"brandOrder":null,"brandAddress":null,"attributeId":null,"standardId":null,"userId":null,"collectionNum":null,"standard":null},{"id":27,"name":"测试27","categoryId":1,"keywords":"测试","model":"1","virtualNum":2,"price":25,"marketPrice":42,"integral":24,"stock":12,"warningStock":212,"coverUrl":"http://zhmp.oss-cn-shenzhen.aliyuncs.com/tea/%E5%BE%AE%E4%BF%A1%E5%9B%BE%E7%89%87_20190621162803.jpg","state":1,"showOrder":12,"sellNum":12,"isNew":0,"unit":"1","transId":1,"createBy":1,"createTime":"2019-06-05T08:20:50.000+0000","updateBy":1,"updateTime":"2019-07-11T02:51:23.000+0000","del":0,"isRecommend":1,"isCheck":1,"limitIntegral":2020,"subhead":"202","remark":"阿斯顿发失地发生地方","weight":2,"count":2,"sendIntegral":2,"sendGrowth":2,"productPicture":"http://pic34.nipic.com/20131020/6704106_203943375000_2.jpg,http://pic13.nipic.com/20110409/7119492_114440620000_2.jpg,http://pic13.nipic.com/20110409/7119492_114440620000_2.jpg,http://pic13.nipic.com/20110409/7119492_114440620000_2.jpg","storeId":1,"isSift":1,"brandId":2,"mallStore":null,"sellCount":null,"num":null,"basicService":null,"productType":null,"transName":null,"priceType":null,"deliveryType":null,"defaultTransCost":null,"branName":null,"brandImg":null,"brandIsSpecial":null,"brandOrder":null,"brandAddress":null,"attributeId":null,"standardId":null,"userId":null,"collectionNum":null,"standard":null},{"id":28,"name":"测试28","categoryId":2,"keywords":"测试","model":"1","virtualNum":2,"price":25,"marketPrice":42,"integral":24,"stock":12,"warningStock":212,"coverUrl":"1212","state":1,"showOrder":12,"sellNum":12,"isNew":0,"unit":"1","transId":1,"createBy":1,"createTime":"2019-06-05T08:20:51.000+0000","updateBy":1,"updateTime":"2019-07-03T06:02:53.000+0000","del":0,"isRecommend":1,"isCheck":1,"limitIntegral":2020,"subhead":"202","remark":"阿斯顿发失地发生地方","weight":2,"count":2,"sendIntegral":2,"sendGrowth":2,"productPicture":"http://pic34.nipic.com/20131020/6704106_203943375000_2.jpg,http://pic13.nipic.com/20110409/7119492_114440620000_2.jpg,http://pic13.nipic.com/20110409/7119492_114440620000_2.jpg,http://pic13.nipic.com/20110409/7119492_114440620000_2.jpg","storeId":1,"isSift":1,"brandId":2,"mallStore":null,"sellCount":null,"num":null,"basicService":null,"productType":null,"transName":null,"priceType":null,"deliveryType":null,"defaultTransCost":null,"branName":null,"brandImg":null,"brandIsSpecial":null,"brandOrder":null,"brandAddress":null,"attributeId":null,"standardId":null,"userId":null,"collectionNum":null,"standard":null},{"id":29,"name":"测试29","categoryId":1,"keywords":"测试","model":"1","virtualNum":2,"price":111,"marketPrice":42,"integral":24,"stock":12,"warningStock":212,"coverUrl":"1212","state":1,"showOrder":12,"sellNum":12,"isNew":1,"unit":"1","transId":1,"createBy":1,"createTime":"2019-06-05T08:20:53.000+0000","updateBy":1,"updateTime":"2019-07-03T06:02:54.000+0000","del":0,"isRecommend":1,"isCheck":1,"limitIntegral":2020,"subhead":"202","remark":"阿斯顿发失地发生地方","weight":2,"count":2,"sendIntegral":2,"sendGrowth":2,"productPicture":"http://pic34.nipic.com/20131020/6704106_203943375000_2.jpg,http://pic13.nipic.com/20110409/7119492_114440620000_2.jpg,http://pic13.nipic.com/20110409/7119492_114440620000_2.jpg,http://pic13.nipic.com/20110409/7119492_114440620000_2.jpg","storeId":2,"isSift":1,"brandId":2,"mallStore":null,"sellCount":null,"num":null,"basicService":null,"productType":null,"transName":null,"priceType":null,"deliveryType":null,"defaultTransCost":null,"branName":null,"brandImg":null,"brandIsSpecial":null,"brandOrder":null,"brandAddress":null,"attributeId":null,"standardId":null,"userId":null,"collectionNum":null,"standard":null},{"id":31,"name":"测试31","categoryId":2,"keywords":"测试","model":"1","virtualNum":2,"price":75,"marketPrice":42,"integral":24,"stock":12,"warningStock":212,"coverUrl":"1212","state":1,"showOrder":12,"sellNum":12,"isNew":0,"unit":"1","transId":1,"createBy":1,"createTime":"2019-06-05T08:20:56.000+0000","updateBy":1,"updateTime":"2019-07-03T06:02:56.000+0000","del":0,"isRecommend":1,"isCheck":1,"limitIntegral":2020,"subhead":"202","remark":"阿斯顿发失地发生地方","weight":2,"count":2,"sendIntegral":2,"sendGrowth":2,"productPicture":"http://pic34.nipic.com/20131020/6704106_203943375000_2.jpg,http://pic13.nipic.com/20110409/7119492_114440620000_2.jpg,http://pic13.nipic.com/20110409/7119492_114440620000_2.jpg,http://pic13.nipic.com/20110409/7119492_114440620000_2.jpg","storeId":4,"isSift":0,"brandId":2,"mallStore":null,"sellCount":null,"num":null,"basicService":null,"productType":null,"transName":null,"priceType":null,"deliveryType":null,"defaultTransCost":null,"branName":null,"brandImg":null,"brandIsSpecial":null,"brandOrder":null,"brandAddress":null,"attributeId":null,"standardId":null,"userId":null,"collectionNum":null,"standard":null},{"id":33,"name":"测试33","categoryId":2,"keywords":"测试","model":"1","virtualNum":2,"price":66,"marketPrice":42,"integral":24,"stock":12,"warningStock":212,"coverUrl":"1212","state":1,"showOrder":12,"sellNum":12,"isNew":1,"unit":"1","transId":1,"createBy":1,"createTime":"2019-06-05T08:20:58.000+0000","updateBy":1,"updateTime":"2019-07-03T06:02:58.000+0000","del":0,"isRecommend":1,"isCheck":1,"limitIntegral":2020,"subhead":"202","remark":"阿斯顿发失地发生地方","weight":2,"count":2,"sendIntegral":2,"sendGrowth":2,"productPicture":"http://pic34.nipic.com/20131020/6704106_203943375000_2.jpg,http://pic13.nipic.com/20110409/7119492_114440620000_2.jpg,http://pic13.nipic.com/20110409/7119492_114440620000_2.jpg,http://pic13.nipic.com/20110409/7119492_114440620000_2.jpg","storeId":3,"isSift":0,"brandId":2,"mallStore":null,"sellCount":null,"num":null,"basicService":null,"productType":null,"transName":null,"priceType":null,"deliveryType":null,"defaultTransCost":null,"branName":null,"brandImg":null,"brandIsSpecial":null,"brandOrder":null,"brandAddress":null,"attributeId":null,"standardId":null,"userId":null,"collectionNum":null,"standard":null},{"id":35,"name":"商品标题","categoryId":1,"keywords":"商品关键字","model":"1","virtualNum":1,"price":12,"marketPrice":12,"integral":12,"stock":12,"warningStock":12,"coverUrl":"封面图","state":1,"showOrder":0,"sellNum":10,"isNew":0,"unit":"01","transId":7,"createBy":11,"createTime":"2019-02-14T02:00:00.000+0000","updateBy":66,"updateTime":"2019-07-03T06:03:00.000+0000","del":0,"isRecommend":0,"isCheck":0,"limitIntegral":111,"subhead":"副标题6666666","remark":"商品描述66666666666","weight":25,"count":45,"sendIntegral":12,"sendGrowth":21,"productPicture":"http://pic34.nipic.com/20131020/6704106_203943375000_2.jpg,http://pic13.nipic.com/20110409/7119492_114440620000_2.jpg,http://pic13.nipic.com/20110409/7119492_114440620000_2.jpg,http://pic13.nipic.com/20110409/7119492_114440620000_2.jpg","storeId":1,"isSift":1,"brandId":2,"mallStore":null,"sellCount":null,"num":null,"basicService":null,"productType":null,"transName":null,"priceType":null,"deliveryType":null,"defaultTransCost":null,"branName":null,"brandImg":null,"brandIsSpecial":null,"brandOrder":null,"brandAddress":null,"attributeId":null,"standardId":null,"userId":null,"collectionNum":null,"standard":null},{"id":37,"name":"商品标题","categoryId":2,"keywords":"商品关键字","model":"2","virtualNum":25,"price":25.45,"marketPrice":12,"integral":5,"stock":15,"warningStock":10,"coverUrl":"封面图","state":1,"showOrder":0,"sellNum":11,"isNew":1,"unit":"12","transId":1,"createBy":11,"createTime":"2019-02-14T02:00:00.000+0000","updateBy":1,"updateTime":"2019-07-02T09:06:24.000+0000","del":0,"isRecommend":0,"isCheck":0,"limitIntegral":2,"subhead":"副标题6666666","remark":"商品描述66666666666","weight":5,"count":45,"sendIntegral":5,"sendGrowth":21,"productPicture":"http://pic34.nipic.com/20131020/6704106_203943375000_2.jpg,http://pic13.nipic.com/20110409/7119492_114440620000_2.jpg,http://pic13.nipic.com/20110409/7119492_114440620000_2.jpg,http://pic13.nipic.com/20110409/7119492_114440620000_2.jpg","storeId":1,"isSift":1,"brandId":2,"mallStore":null,"sellCount":null,"num":null,"basicService":null,"productType":null,"transName":null,"priceType":null,"deliveryType":null,"defaultTransCost":null,"branName":null,"brandImg":null,"brandIsSpecial":null,"brandOrder":null,"brandAddress":null,"attributeId":null,"standardId":null,"userId":null,"collectionNum":null,"standard":null},{"id":44,"name":"商品标题","categoryId":2,"keywords":"商品关键字","model":"1","virtualNum":25,"price":25.45,"marketPrice":12,"integral":5,"stock":15,"warningStock":10,"coverUrl":"封面图","state":1,"showOrder":0,"sellNum":11,"isNew":1,"unit":"12","transId":2,"createBy":11,"createTime":"2019-02-14T02:00:00.000+0000","updateBy":1,"updateTime":"2019-07-02T09:06:42.000+0000","del":0,"isRecommend":0,"isCheck":0,"limitIntegral":2,"subhead":"副标题6666666","remark":"商品描述66666666666","weight":5,"count":45,"sendIntegral":5,"sendGrowth":21,"productPicture":"http://pic34.nipic.com/20131020/6704106_203943375000_2.jpg,http://pic13.nipic.com/20110409/7119492_114440620000_2.jpg,http://pic13.nipic.com/20110409/7119492_114440620000_2.jpg,http://pic13.nipic.com/20110409/7119492_114440620000_2.jpg","storeId":1,"isSift":1,"brandId":2,"mallStore":null,"sellCount":null,"num":null,"basicService":null,"productType":null,"transName":null,"priceType":null,"deliveryType":null,"defaultTransCost":null,"branName":null,"brandImg":null,"brandIsSpecial":null,"brandOrder":null,"brandAddress":null,"attributeId":null,"standardId":null,"userId":null,"collectionNum":null,"standard":null},{"id":46,"name":"商品","categoryId":1,"keywords":"士大夫","model":"1","virtualNum":1,"price":50,"marketPrice":1,"integral":1,"stock":11,"warningStock":11,"coverUrl":"10","state":1,"showOrder":0,"sellNum":0,"isNew":0,"unit":null,"transId":1,"createBy":1,"createTime":"2019-06-19T02:27:00.000+0000","updateBy":1,"updateTime":"2019-07-02T09:06:49.000+0000","del":0,"isRecommend":null,"isCheck":null,"limitIntegral":null,"subhead":null,"remark":null,"weight":null,"count":null,"sendIntegral":null,"sendGrowth":null,"productPicture":"http://pic34.nipic.com/20131020/6704106_203943375000_2.jpg,http://pic13.nipic.com/20110409/7119492_114440620000_2.jpg,http://pic13.nipic.com/20110409/7119492_114440620000_2.jpg,http://pic13.nipic.com/20110409/7119492_114440620000_2.jpg","storeId":1,"isSift":0,"brandId":2,"mallStore":null,"sellCount":null,"num":null,"basicService":null,"productType":null,"transName":null,"priceType":null,"deliveryType":null,"defaultTransCost":null,"branName":null,"brandImg":null,"brandIsSpecial":null,"brandOrder":null,"brandAddress":null,"attributeId":null,"standardId":null,"userId":null,"collectionNum":null,"standard":null}]},{"id":2,"name":"品牌名称","isSpecial":"1","img":"图片","story":"阿斯蒂芬","order":"0","createTime":"2019-06-20T08:47:09.000+0000","updateTime":"2019-06-20T08:47:09.000+0000","address":"地址","productList":[{"id":1,"name":"测试","categoryId":2,"keywords":"测试","model":"1","virtualNum":2,"price":25,"marketPrice":42,"integral":24,"stock":12,"warningStock":212,"coverUrl":"http://oss.irving.net.cn/tea/%E5%BE%AE%E4%BF%A1%E5%9B%BE%E7%89%87_20190621162756.jpg","state":1,"showOrder":12,"sellNum":12,"isNew":1,"unit":"1","transId":1,"createBy":1,"createTime":"2019-06-05T08:18:59.000+0000","updateBy":1,"updateTime":"2019-07-11T02:51:05.000+0000","del":0,"isRecommend":1,"isCheck":1,"limitIntegral":2020,"subhead":"202","remark":"阿斯顿发失地发生地方","weight":2,"count":2,"sendIntegral":2,"sendGrowth":2,"productPicture":"http://pic34.nipic.com/20131020/6704106_203943375000_2.jpg,http://pic13.nipic.com/20110409/7119492_114440620000_2.jpg,http://pic13.nipic.com/20110409/7119492_114440620000_2.jpg,http://pic13.nipic.com/20110409/7119492_114440620000_2.jpg","storeId":1,"isSift":0,"brandId":1,"mallStore":null,"sellCount":null,"num":null,"basicService":null,"productType":null,"transName":null,"priceType":null,"deliveryType":null,"defaultTransCost":null,"branName":null,"brandImg":null,"brandIsSpecial":null,"brandOrder":null,"brandAddress":null,"attributeId":null,"standardId":null,"userId":null,"collectionNum":null,"standard":null},{"id":19,"name":"测试19","categoryId":2,"keywords":"测试","model":"1","virtualNum":2,"price":25,"marketPrice":42,"integral":24,"stock":12,"warningStock":212,"coverUrl":"http://oss.irving.net.cn/tea/1911562737563_.pic_hd.jpg","state":1,"showOrder":12,"sellNum":12,"isNew":1,"unit":"1","transId":6,"createBy":1,"createTime":"2019-06-05T08:20:34.000+0000","updateBy":1,"updateTime":"2019-07-10T05:49:17.000+0000","del":0,"isRecommend":1,"isCheck":1,"limitIntegral":2020,"subhead":"202","remark":"阿斯顿发失地发生地方","weight":2,"count":2,"sendIntegral":2,"sendGrowth":2,"productPicture":"http://pic34.nipic.com/20131020/6704106_203943375000_2.jpg,http://pic13.nipic.com/20110409/7119492_114440620000_2.jpg,http://pic13.nipic.com/20110409/7119492_114440620000_2.jpg,http://pic13.nipic.com/20110409/7119492_114440620000_2.jpg","storeId":1,"isSift":1,"brandId":1,"mallStore":null,"sellCount":null,"num":null,"basicService":null,"productType":null,"transName":null,"priceType":null,"deliveryType":null,"defaultTransCost":null,"branName":null,"brandImg":null,"brandIsSpecial":null,"brandOrder":null,"brandAddress":null,"attributeId":null,"standardId":null,"userId":null,"collectionNum":null,"standard":null},{"id":21,"name":"测试21","categoryId":1,"keywords":"测试","model":"1","virtualNum":2,"price":25,"marketPrice":42,"integral":24,"stock":12,"warningStock":212,"coverUrl":"http://oss.irving.net.cn/tea/%E5%BE%AE%E4%BF%A1%E5%9B%BE%E7%89%87_20190621162756.jpg","state":1,"showOrder":12,"sellNum":12,"isNew":0,"unit":"1","transId":1,"createBy":1,"createTime":"2019-06-05T08:20:39.000+0000","updateBy":1,"updateTime":"2019-07-11T02:51:35.000+0000","del":0,"isRecommend":1,"isCheck":1,"limitIntegral":2020,"subhead":"202","remark":"阿斯顿发失地发生地方","weight":2,"count":2,"sendIntegral":2,"sendGrowth":2,"productPicture":"http://pic34.nipic.com/20131020/6704106_203943375000_2.jpg,http://pic13.nipic.com/20110409/7119492_114440620000_2.jpg,http://pic13.nipic.com/20110409/7119492_114440620000_2.jpg,http://pic13.nipic.com/20110409/7119492_114440620000_2.jpg","storeId":1,"isSift":0,"brandId":1,"mallStore":null,"sellCount":null,"num":null,"basicService":null,"productType":null,"transName":null,"priceType":null,"deliveryType":null,"defaultTransCost":null,"branName":null,"brandImg":null,"brandIsSpecial":null,"brandOrder":null,"brandAddress":null,"attributeId":null,"standardId":null,"userId":null,"collectionNum":null,"standard":null},{"id":22,"name":"测试22","categoryId":2,"keywords":"测试","model":"1","virtualNum":2,"price":25,"marketPrice":42,"integral":24,"stock":12,"warningStock":212,"coverUrl":"http://zhmp.oss-cn-shenzhen.aliyuncs.com/tea/%E5%BE%AE%E4%BF%A1%E5%9B%BE%E7%89%87_20190621162803.jpg","state":1,"showOrder":12,"sellNum":12,"isNew":0,"unit":"1","transId":7,"createBy":1,"createTime":"2019-06-05T08:20:41.000+0000","updateBy":1,"updateTime":"2019-07-11T02:51:28.000+0000","del":0,"isRecommend":1,"isCheck":1,"limitIntegral":2020,"subhead":"202","remark":"阿斯顿发失地发生地方","weight":2,"count":2,"sendIntegral":2,"sendGrowth":2,"productPicture":"http://pic34.nipic.com/20131020/6704106_203943375000_2.jpg,http://pic13.nipic.com/20110409/7119492_114440620000_2.jpg,http://pic13.nipic.com/20110409/7119492_114440620000_2.jpg,http://pic13.nipic.com/20110409/7119492_114440620000_2.jpg","storeId":1,"isSift":0,"brandId":1,"mallStore":null,"sellCount":null,"num":null,"basicService":null,"productType":null,"transName":null,"priceType":null,"deliveryType":null,"defaultTransCost":null,"branName":null,"brandImg":null,"brandIsSpecial":null,"brandOrder":null,"brandAddress":null,"attributeId":null,"standardId":null,"userId":null,"collectionNum":null,"standard":null},{"id":23,"name":"测试23","categoryId":1,"keywords":"测试","model":"1","virtualNum":2,"price":25,"marketPrice":42,"integral":24,"stock":12,"warningStock":212,"coverUrl":"http://zhmp.oss-cn-shenzhen.aliyuncs.com/tea/%E5%BE%AE%E4%BF%A1%E5%9B%BE%E7%89%87_20190621162803.jpg","state":1,"showOrder":12,"sellNum":12,"isNew":1,"unit":"1","transId":1,"createBy":1,"createTime":"2019-06-05T08:20:44.000+0000","updateBy":1,"updateTime":"2019-07-11T02:51:27.000+0000","del":0,"isRecommend":1,"isCheck":1,"limitIntegral":2020,"subhead":"202","remark":"阿斯顿发失地发生地方","weight":2,"count":2,"sendIntegral":2,"sendGrowth":2,"productPicture":"http://pic34.nipic.com/20131020/6704106_203943375000_2.jpg,http://pic13.nipic.com/20110409/7119492_114440620000_2.jpg,http://pic13.nipic.com/20110409/7119492_114440620000_2.jpg,http://pic13.nipic.com/20110409/7119492_114440620000_2.jpg","storeId":2,"isSift":1,"brandId":1,"mallStore":null,"sellCount":null,"num":null,"basicService":null,"productType":null,"transName":null,"priceType":null,"deliveryType":null,"defaultTransCost":null,"branName":null,"brandImg":null,"brandIsSpecial":null,"brandOrder":null,"brandAddress":null,"attributeId":null,"standardId":null,"userId":null,"collectionNum":null,"standard":null},{"id":26,"name":"测试26","categoryId":2,"keywords":"测试","model":"1","virtualNum":2,"price":25,"marketPrice":42,"integral":24,"stock":12,"warningStock":212,"coverUrl":"http://zhmp.oss-cn-shenzhen.aliyuncs.com/tea/%E5%BE%AE%E4%BF%A1%E5%9B%BE%E7%89%87_20190621162803.jpg","state":1,"showOrder":12,"sellNum":12,"isNew":1,"unit":"1","transId":1,"createBy":1,"createTime":"2019-06-05T08:20:49.000+0000","updateBy":1,"updateTime":"2019-07-11T02:51:24.000+0000","del":0,"isRecommend":1,"isCheck":1,"limitIntegral":2020,"subhead":"202","remark":"阿斯顿发失地发生地方","weight":2,"count":2,"sendIntegral":2,"sendGrowth":2,"productPicture":"http://pic34.nipic.com/20131020/6704106_203943375000_2.jpg,http://pic13.nipic.com/20110409/7119492_114440620000_2.jpg,http://pic13.nipic.com/20110409/7119492_114440620000_2.jpg,http://pic13.nipic.com/20110409/7119492_114440620000_2.jpg","storeId":2,"isSift":0,"brandId":1,"mallStore":null,"sellCount":null,"num":null,"basicService":null,"productType":null,"transName":null,"priceType":null,"deliveryType":null,"defaultTransCost":null,"branName":null,"brandImg":null,"brandIsSpecial":null,"brandOrder":null,"brandAddress":null,"attributeId":null,"standardId":null,"userId":null,"collectionNum":null,"standard":null},{"id":30,"name":"测试30","categoryId":2,"keywords":"测试","model":"1","virtualNum":2,"price":25,"marketPrice":42,"integral":24,"stock":12,"warningStock":212,"coverUrl":"1212","state":1,"showOrder":12,"sellNum":12,"isNew":1,"unit":"1","transId":8,"createBy":1,"createTime":"2019-06-05T08:20:55.000+0000","updateBy":1,"updateTime":"2019-07-03T06:02:55.000+0000","del":0,"isRecommend":1,"isCheck":1,"limitIntegral":2020,"subhead":"202","remark":"阿斯顿发失地发生地方","weight":2,"count":2,"sendIntegral":2,"sendGrowth":2,"productPicture":"http://pic34.nipic.com/20131020/6704106_203943375000_2.jpg,http://pic13.nipic.com/20110409/7119492_114440620000_2.jpg,http://pic13.nipic.com/20110409/7119492_114440620000_2.jpg,http://pic13.nipic.com/20110409/7119492_114440620000_2.jpg","storeId":2,"isSift":1,"brandId":1,"mallStore":null,"sellCount":null,"num":null,"basicService":null,"productType":null,"transName":null,"priceType":null,"deliveryType":null,"defaultTransCost":null,"branName":null,"brandImg":null,"brandIsSpecial":null,"brandOrder":null,"brandAddress":null,"attributeId":null,"standardId":null,"userId":null,"collectionNum":null,"standard":null},{"id":32,"name":"测试32","categoryId":1,"keywords":"测试","model":"1","virtualNum":2,"price":25,"marketPrice":42,"integral":24,"stock":12,"warningStock":212,"coverUrl":"1212","state":1,"showOrder":12,"sellNum":12,"isNew":1,"unit":"1","transId":1,"createBy":1,"createTime":"2019-06-05T08:20:57.000+0000","updateBy":1,"updateTime":"2019-07-03T06:02:57.000+0000","del":0,"isRecommend":1,"isCheck":1,"limitIntegral":2020,"subhead":"202","remark":"阿斯顿发失地发生地方","weight":2,"count":2,"sendIntegral":2,"sendGrowth":2,"productPicture":"http://pic34.nipic.com/20131020/6704106_203943375000_2.jpg,http://pic13.nipic.com/20110409/7119492_114440620000_2.jpg,http://pic13.nipic.com/20110409/7119492_114440620000_2.jpg,http://pic13.nipic.com/20110409/7119492_114440620000_2.jpg","storeId":5,"isSift":1,"brandId":1,"mallStore":null,"sellCount":null,"num":null,"basicService":null,"productType":null,"transName":null,"priceType":null,"deliveryType":null,"defaultTransCost":null,"branName":null,"brandImg":null,"brandIsSpecial":null,"brandOrder":null,"brandAddress":null,"attributeId":null,"standardId":null,"userId":null,"collectionNum":null,"standard":null},{"id":34,"name":"测试34","categoryId":2,"keywords":"测试","model":"1","virtualNum":2,"price":25,"marketPrice":42,"integral":24,"stock":12,"warningStock":212,"coverUrl":"1212","state":1,"showOrder":12,"sellNum":12,"isNew":1,"unit":"1","transId":1,"createBy":1,"createTime":"2019-06-05T08:21:00.000+0000","updateBy":1,"updateTime":"2019-07-03T06:02:59.000+0000","del":0,"isRecommend":1,"isCheck":1,"limitIntegral":2020,"subhead":"202","remark":"阿斯顿发失地发生地方","weight":2,"count":2,"sendIntegral":2,"sendGrowth":2,"productPicture":"http://pic34.nipic.com/20131020/6704106_203943375000_2.jpg,http://pic13.nipic.com/20110409/7119492_114440620000_2.jpg,http://pic13.nipic.com/20110409/7119492_114440620000_2.jpg,http://pic13.nipic.com/20110409/7119492_114440620000_2.jpg","storeId":5,"isSift":0,"brandId":1,"mallStore":null,"sellCount":null,"num":null,"basicService":null,"productType":null,"transName":null,"priceType":null,"deliveryType":null,"defaultTransCost":null,"branName":null,"brandImg":null,"brandIsSpecial":null,"brandOrder":null,"brandAddress":null,"attributeId":null,"standardId":null,"userId":null,"collectionNum":null,"standard":null},{"id":36,"name":"奥术大师多","categoryId":1,"keywords":"奥术大师多","model":"1","virtualNum":25,"price":25.45,"marketPrice":25.45,"integral":5,"stock":15,"warningStock":10,"coverUrl":"封面","state":1,"showOrder":12,"sellNum":11,"isNew":0,"unit":"12","transId":1,"createBy":1,"createTime":"2019-02-14T02:00:00.000+0000","updateBy":2,"updateTime":"2019-07-02T09:06:23.000+0000","del":0,"isRecommend":0,"isCheck":0,"limitIntegral":2,"subhead":"副标题","remark":"商品描述","weight":5,"count":5,"sendIntegral":5,"sendGrowth":5,"productPicture":"http://pic34.nipic.com/20131020/6704106_203943375000_2.jpg,http://pic13.nipic.com/20110409/7119492_114440620000_2.jpg,http://pic13.nipic.com/20110409/7119492_114440620000_2.jpg,http://pic13.nipic.com/20110409/7119492_114440620000_2.jpg","storeId":7,"isSift":1,"brandId":1,"mallStore":null,"sellCount":null,"num":null,"basicService":null,"productType":null,"transName":null,"priceType":null,"deliveryType":null,"defaultTransCost":null,"branName":null,"brandImg":null,"brandIsSpecial":null,"brandOrder":null,"brandAddress":null,"attributeId":null,"standardId":null,"userId":null,"collectionNum":null,"standard":null},{"id":38,"name":"商品标题","categoryId":2,"keywords":"商品关键字","model":"1","virtualNum":25,"price":25.45,"marketPrice":12,"integral":5,"stock":15,"warningStock":10,"coverUrl":"封面图","state":1,"showOrder":0,"sellNum":11,"isNew":1,"unit":"12","transId":4,"createBy":11,"createTime":"2019-02-14T02:00:00.000+0000","updateBy":1,"updateTime":"2019-07-03T06:03:03.000+0000","del":0,"isRecommend":0,"isCheck":0,"limitIntegral":2,"subhead":"副标题6666666","remark":"商品描述66666666666","weight":5,"count":45,"sendIntegral":5,"sendGrowth":21,"productPicture":"http://pic34.nipic.com/20131020/6704106_203943375000_2.jpg,http://pic13.nipic.com/20110409/7119492_114440620000_2.jpg,http://pic13.nipic.com/20110409/7119492_114440620000_2.jpg,http://pic13.nipic.com/20110409/7119492_114440620000_2.jpg","storeId":1,"isSift":0,"brandId":1,"mallStore":null,"sellCount":null,"num":null,"basicService":null,"productType":null,"transName":null,"priceType":null,"deliveryType":null,"defaultTransCost":null,"branName":null,"brandImg":null,"brandIsSpecial":null,"brandOrder":null,"brandAddress":null,"attributeId":null,"standardId":null,"userId":null,"collectionNum":null,"standard":null},{"id":40,"name":"商品标题","categoryId":2,"keywords":"商品关键字","model":"2","virtualNum":25,"price":25.45,"marketPrice":12,"integral":5,"stock":15,"warningStock":10,"coverUrl":"封面图","state":1,"showOrder":0,"sellNum":11,"isNew":1,"unit":"12","transId":1,"createBy":11,"createTime":"2019-02-14T02:00:00.000+0000","updateBy":1,"updateTime":"2019-07-02T09:06:37.000+0000","del":0,"isRecommend":0,"isCheck":0,"limitIntegral":2,"subhead":"副标题6666666","remark":"商品描述66666666666","weight":5,"count":45,"sendIntegral":5,"sendGrowth":21,"productPicture":"http://pic34.nipic.com/20131020/6704106_203943375000_2.jpg,http://pic13.nipic.com/20110409/7119492_114440620000_2.jpg,http://pic13.nipic.com/20110409/7119492_114440620000_2.jpg,http://pic13.nipic.com/20110409/7119492_114440620000_2.jpg","storeId":1,"isSift":1,"brandId":1,"mallStore":null,"sellCount":null,"num":null,"basicService":null,"productType":null,"transName":null,"priceType":null,"deliveryType":null,"defaultTransCost":null,"branName":null,"brandImg":null,"brandIsSpecial":null,"brandOrder":null,"brandAddress":null,"attributeId":null,"standardId":null,"userId":null,"collectionNum":null,"standard":null},{"id":41,"name":"商品标题","categoryId":2,"keywords":"商品关键字","model":"1","virtualNum":25,"price":25.45,"marketPrice":12,"integral":5,"stock":15,"warningStock":10,"coverUrl":"封面图","state":1,"showOrder":0,"sellNum":11,"isNew":1,"unit":"12","transId":1,"createBy":11,"createTime":"2019-02-14T02:00:00.000+0000","updateBy":1,"updateTime":"2019-07-02T09:06:39.000+0000","del":0,"isRecommend":0,"isCheck":0,"limitIntegral":2,"subhead":"副标题6666666","remark":"商品描述66666666666","weight":5,"count":45,"sendIntegral":5,"sendGrowth":21,"productPicture":"http://pic34.nipic.com/20131020/6704106_203943375000_2.jpg,http://pic13.nipic.com/20110409/7119492_114440620000_2.jpg,http://pic13.nipic.com/20110409/7119492_114440620000_2.jpg,http://pic13.nipic.com/20110409/7119492_114440620000_2.jpg","storeId":1,"isSift":1,"brandId":1,"mallStore":null,"sellCount":null,"num":null,"basicService":null,"productType":null,"transName":null,"priceType":null,"deliveryType":null,"defaultTransCost":null,"branName":null,"brandImg":null,"brandIsSpecial":null,"brandOrder":null,"brandAddress":null,"attributeId":null,"standardId":null,"userId":null,"collectionNum":null,"standard":null},{"id":42,"name":"商品标题","categoryId":2,"keywords":"商品关键字","model":"2","virtualNum":25,"price":25.45,"marketPrice":12,"integral":5,"stock":15,"warningStock":10,"coverUrl":"封面图","state":1,"showOrder":0,"sellNum":11,"isNew":1,"unit":"12","transId":1,"createBy":11,"createTime":"2019-02-14T02:00:00.000+0000","updateBy":1,"updateTime":"2019-07-02T09:06:40.000+0000","del":0,"isRecommend":0,"isCheck":0,"limitIntegral":2,"subhead":"副标题6666666","remark":"商品描述66666666666","weight":5,"count":45,"sendIntegral":5,"sendGrowth":21,"productPicture":"http://pic34.nipic.com/20131020/6704106_203943375000_2.jpg,http://pic13.nipic.com/20110409/7119492_114440620000_2.jpg,http://pic13.nipic.com/20110409/7119492_114440620000_2.jpg,http://pic13.nipic.com/20110409/7119492_114440620000_2.jpg","storeId":1,"isSift":1,"brandId":1,"mallStore":null,"sellCount":null,"num":null,"basicService":null,"productType":null,"transName":null,"priceType":null,"deliveryType":null,"defaultTransCost":null,"branName":null,"brandImg":null,"brandIsSpecial":null,"brandOrder":null,"brandAddress":null,"attributeId":null,"standardId":null,"userId":null,"collectionNum":null,"standard":null},{"id":43,"name":"商品标题","categoryId":2,"keywords":"商品关键字","model":"1","virtualNum":25,"price":25.45,"marketPrice":12,"integral":5,"stock":15,"warningStock":10,"coverUrl":"封面图","state":1,"showOrder":0,"sellNum":11,"isNew":1,"unit":"12","transId":5,"createBy":11,"createTime":"2019-02-14T02:00:00.000+0000","updateBy":1,"updateTime":"2019-07-02T09:06:41.000+0000","del":0,"isRecommend":0,"isCheck":0,"limitIntegral":2,"subhead":"副标题6666666","remark":"商品描述66666666666","weight":5,"count":45,"sendIntegral":5,"sendGrowth":21,"productPicture":"http://pic34.nipic.com/20131020/6704106_203943375000_2.jpg,http://pic13.nipic.com/20110409/7119492_114440620000_2.jpg,http://pic13.nipic.com/20110409/7119492_114440620000_2.jpg,http://pic13.nipic.com/20110409/7119492_114440620000_2.jpg","storeId":1,"isSift":1,"brandId":1,"mallStore":null,"sellCount":null,"num":null,"basicService":null,"productType":null,"transName":null,"priceType":null,"deliveryType":null,"defaultTransCost":null,"branName":null,"brandImg":null,"brandIsSpecial":null,"brandOrder":null,"brandAddress":null,"attributeId":null,"standardId":null,"userId":null,"collectionNum":null,"standard":null},{"id":45,"name":"商品标题","categoryId":1,"keywords":"商品关键字","model":"1","virtualNum":1,"price":1,"marketPrice":1,"integral":1,"stock":33,"warningStock":1,"coverUrl":"http://img2.imgtn.bdimg.com/it/u=180868167,273146879&fm=26&gp=0.jpg","state":1,"showOrder":1,"sellNum":1560,"isNew":1,"unit":"1","transId":2,"createBy":1,"createTime":"2019-06-13T03:00:00.000+0000","updateBy":1,"updateTime":"2019-07-09T06:27:56.000+0000","del":1,"isRecommend":1,"isCheck":1,"limitIntegral":1,"subhead":"1","remark":"1","weight":1,"count":1,"sendIntegral":1,"sendGrowth":1,"productPicture":"http://pic34.nipic.com/20131020/6704106_203943375000_2.jpg,http://pic13.nipic.com/20110409/7119492_114440620000_2.jpg,http://pic13.nipic.com/20110409/7119492_114440620000_2.jpg,http://pic13.nipic.com/20110409/7119492_114440620000_2.jpg","storeId":1,"isSift":1,"brandId":1,"mallStore":null,"sellCount":null,"num":null,"basicService":null,"productType":null,"transName":null,"priceType":null,"deliveryType":null,"defaultTransCost":null,"branName":null,"brandImg":null,"brandIsSpecial":null,"brandOrder":null,"brandAddress":null,"attributeId":null,"standardId":null,"userId":null,"collectionNum":null,"standard":null},{"id":47,"name":"商品标题","categoryId":1,"keywords":"商品关键字","model":"2","virtualNum":0,"price":75,"marketPrice":75,"integral":0,"stock":11,"warningStock":12,"coverUrl":"封面图片","state":1,"showOrder":1,"sellNum":1560,"isNew":1,"unit":"1","transId":1,"createBy":1,"createTime":"2019-06-21T08:49:22.000+0000","updateBy":1,"updateTime":"2019-07-02T09:06:47.000+0000","del":1,"isRecommend":1,"isCheck":1,"limitIntegral":1,"subhead":"1","remark":"1","weight":12,"count":21,"sendIntegral":12,"sendGrowth":12,"productPicture":"http://pic34.nipic.com/20131020/6704106_203943375000_2.jpg,http://pic13.nipic.com/20110409/7119492_114440620000_2.jpg,http://pic13.nipic.com/20110409/7119492_114440620000_2.jpg,http://pic13.nipic.com/20110409/7119492_114440620000_2.jpg","storeId":1,"isSift":1,"brandId":1,"mallStore":null,"sellCount":null,"num":null,"basicService":null,"productType":null,"transName":null,"priceType":null,"deliveryType":null,"defaultTransCost":null,"branName":null,"brandImg":null,"brandIsSpecial":null,"brandOrder":null,"brandAddress":null,"attributeId":null,"standardId":null,"userId":null,"collectionNum":null,"standard":null},{"id":48,"name":"商品标题","categoryId":2,"keywords":"茶","model":null,"virtualNum":null,"price":100,"marketPrice":100,"integral":null,"stock":null,"warningStock":null,"coverUrl":"封面图","state":null,"showOrder":1,"sellNum":null,"isNew":1,"unit":"克","transId":null,"createBy":1,"createTime":null,"updateBy":null,"updateTime":"2019-07-16T06:18:33.000+0000","del":null,"isRecommend":null,"isCheck":null,"limitIntegral":null,"subhead":"副标题","remark":"商品描述","weight":null,"count":null,"sendIntegral":null,"sendGrowth":null,"productPicture":"产品图片","storeId":1,"isSift":1,"brandId":1,"mallStore":null,"sellCount":null,"num":null,"basicService":null,"productType":null,"transName":null,"priceType":null,"deliveryType":null,"defaultTransCost":null,"branName":null,"brandImg":null,"brandIsSpecial":null,"brandOrder":null,"brandAddress":null,"attributeId":null,"standardId":null,"userId":null,"collectionNum":null,"standard":null},{"id":53,"name":"商品标题","categoryId":2,"keywords":"茶","model":"","virtualNum":0,"price":100,"marketPrice":100,"integral":0,"stock":null,"warningStock":null,"coverUrl":"封面图","state":0,"showOrder":1,"sellNum":0,"isNew":1,"unit":"克","transId":0,"createBy":1,"createTime":"2019-06-28T01:46:26.000+0000","updateBy":null,"updateTime":"2019-06-28T01:46:26.000+0000","del":0,"isRecommend":0,"isCheck":0,"limitIntegral":null,"subhead":"副标题","remark":"商品描述","weight":null,"count":null,"sendIntegral":null,"sendGrowth":null,"productPicture":"产品图片","storeId":1,"isSift":0,"brandId":1,"mallStore":null,"sellCount":null,"num":null,"basicService":null,"productType":null,"transName":null,"priceType":null,"deliveryType":null,"defaultTransCost":null,"branName":null,"brandImg":null,"brandIsSpecial":null,"brandOrder":null,"brandAddress":null,"attributeId":null,"standardId":null,"userId":null,"collectionNum":null,"standard":null},{"id":54,"name":"商品标题","categoryId":2,"keywords":"茶","model":"","virtualNum":0,"price":100,"marketPrice":100,"integral":0,"stock":null,"warningStock":null,"coverUrl":"封面图","state":0,"showOrder":1,"sellNum":0,"isNew":1,"unit":"克","transId":0,"createBy":1,"createTime":"2019-06-28T01:46:55.000+0000","updateBy":null,"updateTime":"2019-06-28T01:46:55.000+0000","del":0,"isRecommend":0,"isCheck":0,"limitIntegral":null,"subhead":"副标题","remark":"商品描述","weight":null,"count":null,"sendIntegral":null,"sendGrowth":null,"productPicture":"产品图片","storeId":1,"isSift":0,"brandId":1,"mallStore":null,"sellCount":null,"num":null,"basicService":null,"productType":null,"transName":null,"priceType":null,"deliveryType":null,"defaultTransCost":null,"branName":null,"brandImg":null,"brandIsSpecial":null,"brandOrder":null,"brandAddress":null,"attributeId":null,"standardId":null,"userId":null,"collectionNum":null,"standard":null},{"id":55,"name":"商品标题","categoryId":2,"keywords":"茶","model":"","virtualNum":0,"price":100,"marketPrice":100,"integral":0,"stock":null,"warningStock":null,"coverUrl":"封面图","state":0,"showOrder":1,"sellNum":0,"isNew":1,"unit":"克","transId":0,"createBy":1,"createTime":"2019-06-28T02:21:21.000+0000","updateBy":null,"updateTime":"2019-06-28T02:21:21.000+0000","del":0,"isRecommend":0,"isCheck":0,"limitIntegral":null,"subhead":"副标题","remark":"商品描述","weight":null,"count":null,"sendIntegral":null,"sendGrowth":null,"productPicture":"产品图片","storeId":1,"isSift":0,"brandId":1,"mallStore":null,"sellCount":null,"num":null,"basicService":null,"productType":null,"transName":null,"priceType":null,"deliveryType":null,"defaultTransCost":null,"branName":null,"brandImg":null,"brandIsSpecial":null,"brandOrder":null,"brandAddress":null,"attributeId":null,"standardId":null,"userId":null,"collectionNum":null,"standard":null},{"id":56,"name":"商品标题","categoryId":2,"keywords":"茶","model":"","virtualNum":0,"price":100,"marketPrice":100,"integral":0,"stock":null,"warningStock":null,"coverUrl":"封面图","state":0,"showOrder":1,"sellNum":0,"isNew":1,"unit":"克","transId":0,"createBy":1,"createTime":"2019-06-28T02:26:52.000+0000","updateBy":null,"updateTime":"2019-06-28T02:26:52.000+0000","del":0,"isRecommend":0,"isCheck":0,"limitIntegral":null,"subhead":"副标题","remark":"商品描述","weight":null,"count":null,"sendIntegral":null,"sendGrowth":null,"productPicture":"产品图片","storeId":1,"isSift":0,"brandId":1,"mallStore":null,"sellCount":null,"num":null,"basicService":null,"productType":null,"transName":null,"priceType":null,"deliveryType":null,"defaultTransCost":null,"branName":null,"brandImg":null,"brandIsSpecial":null,"brandOrder":null,"brandAddress":null,"attributeId":null,"standardId":null,"userId":null,"collectionNum":null,"standard":null},{"id":57,"name":"商品标题","categoryId":2,"keywords":"茶","model":"","virtualNum":0,"price":100,"marketPrice":100,"integral":0,"stock":null,"warningStock":null,"coverUrl":"封面图","state":0,"showOrder":1,"sellNum":0,"isNew":1,"unit":"克","transId":0,"createBy":1,"createTime":"2019-06-28T02:26:59.000+0000","updateBy":null,"updateTime":"2019-06-28T02:26:59.000+0000","del":0,"isRecommend":0,"isCheck":0,"limitIntegral":null,"subhead":"副标题","remark":"商品描述","weight":null,"count":null,"sendIntegral":null,"sendGrowth":null,"productPicture":"产品图片","storeId":1,"isSift":0,"brandId":1,"mallStore":null,"sellCount":null,"num":null,"basicService":null,"productType":null,"transName":null,"priceType":null,"deliveryType":null,"defaultTransCost":null,"branName":null,"brandImg":null,"brandIsSpecial":null,"brandOrder":null,"brandAddress":null,"attributeId":null,"standardId":null,"userId":null,"collectionNum":null,"standard":null},{"id":58,"name":"商品标题","categoryId":2,"keywords":"茶","model":"","virtualNum":0,"price":100,"marketPrice":100,"integral":0,"stock":null,"warningStock":null,"coverUrl":"封面图","state":0,"showOrder":1,"sellNum":0,"isNew":1,"unit":"克","transId":0,"createBy":1,"createTime":"2019-06-28T02:29:04.000+0000","updateBy":null,"updateTime":"2019-06-28T02:29:04.000+0000","del":0,"isRecommend":0,"isCheck":0,"limitIntegral":null,"subhead":"副标题","remark":"商品描述","weight":null,"count":null,"sendIntegral":null,"sendGrowth":null,"productPicture":"产品图片","storeId":1,"isSift":0,"brandId":1,"mallStore":null,"sellCount":null,"num":null,"basicService":null,"productType":null,"transName":null,"priceType":null,"deliveryType":null,"defaultTransCost":null,"branName":null,"brandImg":null,"brandIsSpecial":null,"brandOrder":null,"brandAddress":null,"attributeId":null,"standardId":null,"userId":null,"collectionNum":null,"standard":null},{"id":59,"name":"好运来","categoryId":1,"keywords":"红茶","model":"","virtualNum":0,"price":25.6,"marketPrice":35,"integral":0,"stock":null,"warningStock":null,"coverUrl":"快快快","state":0,"showOrder":3,"sellNum":0,"isNew":1,"unit":"g","transId":0,"createBy":33,"createTime":"2019-07-08T04:47:37.000+0000","updateBy":null,"updateTime":"2019-07-08T04:47:37.000+0000","del":0,"isRecommend":0,"isCheck":0,"limitIntegral":null,"subhead":"","remark":"fgfgfgfg","weight":null,"count":null,"sendIntegral":null,"sendGrowth":null,"productPicture":"gfgfggffff","storeId":23,"isSift":1,"brandId":1,"mallStore":null,"sellCount":null,"num":null,"basicService":null,"productType":null,"transName":null,"priceType":null,"deliveryType":null,"defaultTransCost":null,"branName":null,"brandImg":null,"brandIsSpecial":null,"brandOrder":null,"brandAddress":null,"attributeId":null,"standardId":null,"userId":null,"collectionNum":null,"standard":null},{"id":60,"name":"好运来","categoryId":1,"keywords":"红茶","model":"","virtualNum":0,"price":25.6,"marketPrice":35,"integral":0,"stock":null,"warningStock":null,"coverUrl":"快快快","state":0,"showOrder":3,"sellNum":0,"isNew":1,"unit":"g","transId":0,"createBy":33,"createTime":"2019-07-08T06:00:25.000+0000","updateBy":null,"updateTime":"2019-07-08T06:00:25.000+0000","del":0,"isRecommend":0,"isCheck":0,"limitIntegral":null,"subhead":"","remark":"fgfgfgfg","weight":null,"count":null,"sendIntegral":null,"sendGrowth":null,"productPicture":"gfgfggffff","storeId":23,"isSift":1,"brandId":1,"mallStore":null,"sellCount":null,"num":null,"basicService":null,"productType":null,"transName":null,"priceType":null,"deliveryType":null,"defaultTransCost":null,"branName":null,"brandImg":null,"brandIsSpecial":null,"brandOrder":null,"brandAddress":null,"attributeId":null,"standardId":null,"userId":null,"collectionNum":null,"standard":null},{"id":61,"name":"好运来","categoryId":1,"keywords":"红茶","model":"","virtualNum":0,"price":25.6,"marketPrice":35,"integral":0,"stock":null,"warningStock":null,"coverUrl":"快快快","state":0,"showOrder":3,"sellNum":0,"isNew":1,"unit":"g","transId":0,"createBy":33,"createTime":"2019-07-08T07:12:52.000+0000","updateBy":null,"updateTime":"2019-07-08T07:12:52.000+0000","del":0,"isRecommend":0,"isCheck":0,"limitIntegral":null,"subhead":"","remark":"fgfgfgfg","weight":null,"count":null,"sendIntegral":null,"sendGrowth":null,"productPicture":"gfgfggffff","storeId":23,"isSift":1,"brandId":1,"mallStore":null,"sellCount":null,"num":null,"basicService":null,"productType":null,"transName":null,"priceType":null,"deliveryType":null,"defaultTransCost":null,"branName":null,"brandImg":null,"brandIsSpecial":null,"brandOrder":null,"brandAddress":null,"attributeId":null,"standardId":null,"userId":null,"collectionNum":null,"standard":null},{"id":62,"name":"好运来","categoryId":1,"keywords":"红茶","model":"","virtualNum":0,"price":25.6,"marketPrice":35,"integral":0,"stock":null,"warningStock":null,"coverUrl":"快快快","state":0,"showOrder":3,"sellNum":0,"isNew":1,"unit":"g","transId":0,"createBy":33,"createTime":"2019-07-08T07:15:01.000+0000","updateBy":null,"updateTime":"2019-07-08T07:15:01.000+0000","del":0,"isRecommend":0,"isCheck":0,"limitIntegral":null,"subhead":"","remark":"fgfgfgfg","weight":null,"count":null,"sendIntegral":null,"sendGrowth":null,"productPicture":"gfgfggffff","storeId":23,"isSift":1,"brandId":1,"mallStore":null,"sellCount":null,"num":null,"basicService":null,"productType":null,"transName":null,"priceType":null,"deliveryType":null,"defaultTransCost":null,"branName":null,"brandImg":null,"brandIsSpecial":null,"brandOrder":null,"brandAddress":null,"attributeId":null,"standardId":null,"userId":null,"collectionNum":null,"standard":null},{"id":20,"name":"测试20","categoryId":2,"keywords":"测试","model":"1","virtualNum":2,"price":25,"marketPrice":42,"integral":24,"stock":12,"warningStock":212,"coverUrl":"http://oss.irving.net.cn/tea/%E5%BE%AE%E4%BF%A1%E5%9B%BE%E7%89%87_20190621162756.jpg","state":1,"showOrder":12,"sellNum":12,"isNew":1,"unit":"1","transId":1,"createBy":1,"createTime":"2019-06-05T08:20:38.000+0000","updateBy":1,"updateTime":"2019-07-11T02:51:34.000+0000","del":0,"isRecommend":1,"isCheck":1,"limitIntegral":2020,"subhead":"202","remark":"阿斯顿发失地发生地方","weight":2,"count":2,"sendIntegral":2,"sendGrowth":2,"productPicture":"http://pic34.nipic.com/20131020/6704106_203943375000_2.jpg,http://pic13.nipic.com/20110409/7119492_114440620000_2.jpg,http://pic13.nipic.com/20110409/7119492_114440620000_2.jpg,http://pic13.nipic.com/20110409/7119492_114440620000_2.jpg","storeId":1,"isSift":1,"brandId":2,"mallStore":null,"sellCount":null,"num":null,"basicService":null,"productType":null,"transName":null,"priceType":null,"deliveryType":null,"defaultTransCost":null,"branName":null,"brandImg":null,"brandIsSpecial":null,"brandOrder":null,"brandAddress":null,"attributeId":null,"standardId":null,"userId":null,"collectionNum":null,"standard":null},{"id":24,"name":"测试24","categoryId":2,"keywords":"测试","model":"1","virtualNum":2,"price":25,"marketPrice":42,"integral":24,"stock":12,"warningStock":212,"coverUrl":"http://zhmp.oss-cn-shenzhen.aliyuncs.com/tea/%E5%BE%AE%E4%BF%A1%E5%9B%BE%E7%89%87_20190621162803.jpg","state":1,"showOrder":12,"sellNum":12,"isNew":1,"unit":"1","transId":1,"createBy":1,"createTime":"2019-06-05T08:20:46.000+0000","updateBy":1,"updateTime":"2019-07-11T02:51:26.000+0000","del":0,"isRecommend":1,"isCheck":1,"limitIntegral":2020,"subhead":"202","remark":"阿斯顿发失地发生地方","weight":2,"count":2,"sendIntegral":2,"sendGrowth":2,"productPicture":"http://pic34.nipic.com/20131020/6704106_203943375000_2.jpg,http://pic13.nipic.com/20110409/7119492_114440620000_2.jpg,http://pic13.nipic.com/20110409/7119492_114440620000_2.jpg,http://pic13.nipic.com/20110409/7119492_114440620000_2.jpg","storeId":2,"isSift":1,"brandId":2,"mallStore":null,"sellCount":null,"num":null,"basicService":null,"productType":null,"transName":null,"priceType":null,"deliveryType":null,"defaultTransCost":null,"branName":null,"brandImg":null,"brandIsSpecial":null,"brandOrder":null,"brandAddress":null,"attributeId":null,"standardId":null,"userId":null,"collectionNum":null,"standard":null},{"id":25,"name":"测试25","categoryId":2,"keywords":"测试","model":"1","virtualNum":2,"price":25,"marketPrice":42,"integral":24,"stock":12,"warningStock":212,"coverUrl":"http://zhmp.oss-cn-shenzhen.aliyuncs.com/tea/%E5%BE%AE%E4%BF%A1%E5%9B%BE%E7%89%87_20190621162803.jpg","state":1,"showOrder":12,"sellNum":12,"isNew":1,"unit":"1","transId":9,"createBy":1,"createTime":"2019-06-05T08:20:48.000+0000","updateBy":1,"updateTime":"2019-07-11T02:51:25.000+0000","del":0,"isRecommend":1,"isCheck":1,"limitIntegral":2020,"subhead":"202","remark":"阿斯顿发失地发生地方","weight":2,"count":2,"sendIntegral":2,"sendGrowth":2,"productPicture":"http://pic34.nipic.com/20131020/6704106_203943375000_2.jpg,http://pic13.nipic.com/20110409/7119492_114440620000_2.jpg,http://pic13.nipic.com/20110409/7119492_114440620000_2.jpg,http://pic13.nipic.com/20110409/7119492_114440620000_2.jpg","storeId":2,"isSift":1,"brandId":2,"mallStore":null,"sellCount":null,"num":null,"basicService":null,"productType":null,"transName":null,"priceType":null,"deliveryType":null,"defaultTransCost":null,"branName":null,"brandImg":null,"brandIsSpecial":null,"brandOrder":null,"brandAddress":null,"attributeId":null,"standardId":null,"userId":null,"collectionNum":null,"standard":null},{"id":27,"name":"测试27","categoryId":1,"keywords":"测试","model":"1","virtualNum":2,"price":25,"marketPrice":42,"integral":24,"stock":12,"warningStock":212,"coverUrl":"http://zhmp.oss-cn-shenzhen.aliyuncs.com/tea/%E5%BE%AE%E4%BF%A1%E5%9B%BE%E7%89%87_20190621162803.jpg","state":1,"showOrder":12,"sellNum":12,"isNew":0,"unit":"1","transId":1,"createBy":1,"createTime":"2019-06-05T08:20:50.000+0000","updateBy":1,"updateTime":"2019-07-11T02:51:23.000+0000","del":0,"isRecommend":1,"isCheck":1,"limitIntegral":2020,"subhead":"202","remark":"阿斯顿发失地发生地方","weight":2,"count":2,"sendIntegral":2,"sendGrowth":2,"productPicture":"http://pic34.nipic.com/20131020/6704106_203943375000_2.jpg,http://pic13.nipic.com/20110409/7119492_114440620000_2.jpg,http://pic13.nipic.com/20110409/7119492_114440620000_2.jpg,http://pic13.nipic.com/20110409/7119492_114440620000_2.jpg","storeId":1,"isSift":1,"brandId":2,"mallStore":null,"sellCount":null,"num":null,"basicService":null,"productType":null,"transName":null,"priceType":null,"deliveryType":null,"defaultTransCost":null,"branName":null,"brandImg":null,"brandIsSpecial":null,"brandOrder":null,"brandAddress":null,"attributeId":null,"standardId":null,"userId":null,"collectionNum":null,"standard":null},{"id":28,"name":"测试28","categoryId":2,"keywords":"测试","model":"1","virtualNum":2,"price":25,"marketPrice":42,"integral":24,"stock":12,"warningStock":212,"coverUrl":"1212","state":1,"showOrder":12,"sellNum":12,"isNew":0,"unit":"1","transId":1,"createBy":1,"createTime":"2019-06-05T08:20:51.000+0000","updateBy":1,"updateTime":"2019-07-03T06:02:53.000+0000","del":0,"isRecommend":1,"isCheck":1,"limitIntegral":2020,"subhead":"202","remark":"阿斯顿发失地发生地方","weight":2,"count":2,"sendIntegral":2,"sendGrowth":2,"productPicture":"http://pic34.nipic.com/20131020/6704106_203943375000_2.jpg,http://pic13.nipic.com/20110409/7119492_114440620000_2.jpg,http://pic13.nipic.com/20110409/7119492_114440620000_2.jpg,http://pic13.nipic.com/20110409/7119492_114440620000_2.jpg","storeId":1,"isSift":1,"brandId":2,"mallStore":null,"sellCount":null,"num":null,"basicService":null,"productType":null,"transName":null,"priceType":null,"deliveryType":null,"defaultTransCost":null,"branName":null,"brandImg":null,"brandIsSpecial":null,"brandOrder":null,"brandAddress":null,"attributeId":null,"standardId":null,"userId":null,"collectionNum":null,"standard":null},{"id":29,"name":"测试29","categoryId":1,"keywords":"测试","model":"1","virtualNum":2,"price":111,"marketPrice":42,"integral":24,"stock":12,"warningStock":212,"coverUrl":"1212","state":1,"showOrder":12,"sellNum":12,"isNew":1,"unit":"1","transId":1,"createBy":1,"createTime":"2019-06-05T08:20:53.000+0000","updateBy":1,"updateTime":"2019-07-03T06:02:54.000+0000","del":0,"isRecommend":1,"isCheck":1,"limitIntegral":2020,"subhead":"202","remark":"阿斯顿发失地发生地方","weight":2,"count":2,"sendIntegral":2,"sendGrowth":2,"productPicture":"http://pic34.nipic.com/20131020/6704106_203943375000_2.jpg,http://pic13.nipic.com/20110409/7119492_114440620000_2.jpg,http://pic13.nipic.com/20110409/7119492_114440620000_2.jpg,http://pic13.nipic.com/20110409/7119492_114440620000_2.jpg","storeId":2,"isSift":1,"brandId":2,"mallStore":null,"sellCount":null,"num":null,"basicService":null,"productType":null,"transName":null,"priceType":null,"deliveryType":null,"defaultTransCost":null,"branName":null,"brandImg":null,"brandIsSpecial":null,"brandOrder":null,"brandAddress":null,"attributeId":null,"standardId":null,"userId":null,"collectionNum":null,"standard":null},{"id":31,"name":"测试31","categoryId":2,"keywords":"测试","model":"1","virtualNum":2,"price":75,"marketPrice":42,"integral":24,"stock":12,"warningStock":212,"coverUrl":"1212","state":1,"showOrder":12,"sellNum":12,"isNew":0,"unit":"1","transId":1,"createBy":1,"createTime":"2019-06-05T08:20:56.000+0000","updateBy":1,"updateTime":"2019-07-03T06:02:56.000+0000","del":0,"isRecommend":1,"isCheck":1,"limitIntegral":2020,"subhead":"202","remark":"阿斯顿发失地发生地方","weight":2,"count":2,"sendIntegral":2,"sendGrowth":2,"productPicture":"http://pic34.nipic.com/20131020/6704106_203943375000_2.jpg,http://pic13.nipic.com/20110409/7119492_114440620000_2.jpg,http://pic13.nipic.com/20110409/7119492_114440620000_2.jpg,http://pic13.nipic.com/20110409/7119492_114440620000_2.jpg","storeId":4,"isSift":0,"brandId":2,"mallStore":null,"sellCount":null,"num":null,"basicService":null,"productType":null,"transName":null,"priceType":null,"deliveryType":null,"defaultTransCost":null,"branName":null,"brandImg":null,"brandIsSpecial":null,"brandOrder":null,"brandAddress":null,"attributeId":null,"standardId":null,"userId":null,"collectionNum":null,"standard":null},{"id":33,"name":"测试33","categoryId":2,"keywords":"测试","model":"1","virtualNum":2,"price":66,"marketPrice":42,"integral":24,"stock":12,"warningStock":212,"coverUrl":"1212","state":1,"showOrder":12,"sellNum":12,"isNew":1,"unit":"1","transId":1,"createBy":1,"createTime":"2019-06-05T08:20:58.000+0000","updateBy":1,"updateTime":"2019-07-03T06:02:58.000+0000","del":0,"isRecommend":1,"isCheck":1,"limitIntegral":2020,"subhead":"202","remark":"阿斯顿发失地发生地方","weight":2,"count":2,"sendIntegral":2,"sendGrowth":2,"productPicture":"http://pic34.nipic.com/20131020/6704106_203943375000_2.jpg,http://pic13.nipic.com/20110409/7119492_114440620000_2.jpg,http://pic13.nipic.com/20110409/7119492_114440620000_2.jpg,http://pic13.nipic.com/20110409/7119492_114440620000_2.jpg","storeId":3,"isSift":0,"brandId":2,"mallStore":null,"sellCount":null,"num":null,"basicService":null,"productType":null,"transName":null,"priceType":null,"deliveryType":null,"defaultTransCost":null,"branName":null,"brandImg":null,"brandIsSpecial":null,"brandOrder":null,"brandAddress":null,"attributeId":null,"standardId":null,"userId":null,"collectionNum":null,"standard":null},{"id":35,"name":"商品标题","categoryId":1,"keywords":"商品关键字","model":"1","virtualNum":1,"price":12,"marketPrice":12,"integral":12,"stock":12,"warningStock":12,"coverUrl":"封面图","state":1,"showOrder":0,"sellNum":10,"isNew":0,"unit":"01","transId":7,"createBy":11,"createTime":"2019-02-14T02:00:00.000+0000","updateBy":66,"updateTime":"2019-07-03T06:03:00.000+0000","del":0,"isRecommend":0,"isCheck":0,"limitIntegral":111,"subhead":"副标题6666666","remark":"商品描述66666666666","weight":25,"count":45,"sendIntegral":12,"sendGrowth":21,"productPicture":"http://pic34.nipic.com/20131020/6704106_203943375000_2.jpg,http://pic13.nipic.com/20110409/7119492_114440620000_2.jpg,http://pic13.nipic.com/20110409/7119492_114440620000_2.jpg,http://pic13.nipic.com/20110409/7119492_114440620000_2.jpg","storeId":1,"isSift":1,"brandId":2,"mallStore":null,"sellCount":null,"num":null,"basicService":null,"productType":null,"transName":null,"priceType":null,"deliveryType":null,"defaultTransCost":null,"branName":null,"brandImg":null,"brandIsSpecial":null,"brandOrder":null,"brandAddress":null,"attributeId":null,"standardId":null,"userId":null,"collectionNum":null,"standard":null},{"id":37,"name":"商品标题","categoryId":2,"keywords":"商品关键字","model":"2","virtualNum":25,"price":25.45,"marketPrice":12,"integral":5,"stock":15,"warningStock":10,"coverUrl":"封面图","state":1,"showOrder":0,"sellNum":11,"isNew":1,"unit":"12","transId":1,"createBy":11,"createTime":"2019-02-14T02:00:00.000+0000","updateBy":1,"updateTime":"2019-07-02T09:06:24.000+0000","del":0,"isRecommend":0,"isCheck":0,"limitIntegral":2,"subhead":"副标题6666666","remark":"商品描述66666666666","weight":5,"count":45,"sendIntegral":5,"sendGrowth":21,"productPicture":"http://pic34.nipic.com/20131020/6704106_203943375000_2.jpg,http://pic13.nipic.com/20110409/7119492_114440620000_2.jpg,http://pic13.nipic.com/20110409/7119492_114440620000_2.jpg,http://pic13.nipic.com/20110409/7119492_114440620000_2.jpg","storeId":1,"isSift":1,"brandId":2,"mallStore":null,"sellCount":null,"num":null,"basicService":null,"productType":null,"transName":null,"priceType":null,"deliveryType":null,"defaultTransCost":null,"branName":null,"brandImg":null,"brandIsSpecial":null,"brandOrder":null,"brandAddress":null,"attributeId":null,"standardId":null,"userId":null,"collectionNum":null,"standard":null},{"id":44,"name":"商品标题","categoryId":2,"keywords":"商品关键字","model":"1","virtualNum":25,"price":25.45,"marketPrice":12,"integral":5,"stock":15,"warningStock":10,"coverUrl":"封面图","state":1,"showOrder":0,"sellNum":11,"isNew":1,"unit":"12","transId":2,"createBy":11,"createTime":"2019-02-14T02:00:00.000+0000","updateBy":1,"updateTime":"2019-07-02T09:06:42.000+0000","del":0,"isRecommend":0,"isCheck":0,"limitIntegral":2,"subhead":"副标题6666666","remark":"商品描述66666666666","weight":5,"count":45,"sendIntegral":5,"sendGrowth":21,"productPicture":"http://pic34.nipic.com/20131020/6704106_203943375000_2.jpg,http://pic13.nipic.com/20110409/7119492_114440620000_2.jpg,http://pic13.nipic.com/20110409/7119492_114440620000_2.jpg,http://pic13.nipic.com/20110409/7119492_114440620000_2.jpg","storeId":1,"isSift":1,"brandId":2,"mallStore":null,"sellCount":null,"num":null,"basicService":null,"productType":null,"transName":null,"priceType":null,"deliveryType":null,"defaultTransCost":null,"branName":null,"brandImg":null,"brandIsSpecial":null,"brandOrder":null,"brandAddress":null,"attributeId":null,"standardId":null,"userId":null,"collectionNum":null,"standard":null},{"id":46,"name":"商品","categoryId":1,"keywords":"士大夫","model":"1","virtualNum":1,"price":50,"marketPrice":1,"integral":1,"stock":11,"warningStock":11,"coverUrl":"10","state":1,"showOrder":0,"sellNum":0,"isNew":0,"unit":null,"transId":1,"createBy":1,"createTime":"2019-06-19T02:27:00.000+0000","updateBy":1,"updateTime":"2019-07-02T09:06:49.000+0000","del":0,"isRecommend":null,"isCheck":null,"limitIntegral":null,"subhead":null,"remark":null,"weight":null,"count":null,"sendIntegral":null,"sendGrowth":null,"productPicture":"http://pic34.nipic.com/20131020/6704106_203943375000_2.jpg,http://pic13.nipic.com/20110409/7119492_114440620000_2.jpg,http://pic13.nipic.com/20110409/7119492_114440620000_2.jpg,http://pic13.nipic.com/20110409/7119492_114440620000_2.jpg","storeId":1,"isSift":0,"brandId":2,"mallStore":null,"sellCount":null,"num":null,"basicService":null,"productType":null,"transName":null,"priceType":null,"deliveryType":null,"defaultTransCost":null,"branName":null,"brandImg":null,"brandIsSpecial":null,"brandOrder":null,"brandAddress":null,"attributeId":null,"standardId":null,"userId":null,"collectionNum":null,"standard":null}]}]
         */

        private String queryName;
        private List<IsSpecialBean> isSpecial;
        private List<ResultListBean> resultList;

        public String getQueryName() {
            return queryName;
        }

        public void setQueryName(String queryName) {
            this.queryName = queryName;
        }

        public List<IsSpecialBean> getIsSpecial() {
            return isSpecial;
        }

        public void setIsSpecial(List<IsSpecialBean> isSpecial) {
            this.isSpecial = isSpecial;
        }

        public List<ResultListBean> getResultList() {
            return resultList;
        }

        public void setResultList(List<ResultListBean> resultList) {
            this.resultList = resultList;
        }

        public static class IsSpecialBean {
            private int id;
            private String name;
            private String isSpecial;
            private String img;
            private String story;
            private String order;
            private String createTime;
            private String updateTime;
            private String address;
            private Object productList;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getIsSpecial() {
                return isSpecial;
            }

            public void setIsSpecial(String isSpecial) {
                this.isSpecial = isSpecial;
            }

            public String getImg() {
                return img;
            }

            public void setImg(String img) {
                this.img = img;
            }

            public String getStory() {
                return story;
            }

            public void setStory(String story) {
                this.story = story;
            }

            public String getOrder() {
                return order;
            }

            public void setOrder(String order) {
                this.order = order;
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

            public String getAddress() {
                return address;
            }

            public void setAddress(String address) {
                this.address = address;
            }

            public Object getProductList() {
                return productList;
            }

            public void setProductList(Object productList) {
                this.productList = productList;
            }
        }

        public static class ResultListBean {
            /**
             * id : 1
             * name : 阿萨德
             * isSpecial : 0
             * img : 阿斯蒂芬
             * story : 阿斯蒂芬
             * order : 1
             * createTime : 2019-06-14T05:43:21.000+0000
             * updateTime : 2019-06-20T08:47:28.000+0000
             * address : 地址
             * productList : [{"id":1,"name":"测试","categoryId":2,"keywords":"测试","model":"1","virtualNum":2,"price":25,"marketPrice":42,"integral":24,"stock":12,"warningStock":212,"coverUrl":"http://oss.irving.net.cn/tea/%E5%BE%AE%E4%BF%A1%E5%9B%BE%E7%89%87_20190621162756.jpg","state":1,"showOrder":12,"sellNum":12,"isNew":1,"unit":"1","transId":1,"createBy":1,"createTime":"2019-06-05T08:18:59.000+0000","updateBy":1,"updateTime":"2019-07-11T02:51:05.000+0000","del":0,"isRecommend":1,"isCheck":1,"limitIntegral":2020,"subhead":"202","remark":"阿斯顿发失地发生地方","weight":2,"count":2,"sendIntegral":2,"sendGrowth":2,"productPicture":"http://pic34.nipic.com/20131020/6704106_203943375000_2.jpg,http://pic13.nipic.com/20110409/7119492_114440620000_2.jpg,http://pic13.nipic.com/20110409/7119492_114440620000_2.jpg,http://pic13.nipic.com/20110409/7119492_114440620000_2.jpg","storeId":1,"isSift":0,"brandId":1,"mallStore":null,"sellCount":null,"num":null,"basicService":null,"productType":null,"transName":null,"priceType":null,"deliveryType":null,"defaultTransCost":null,"branName":null,"brandImg":null,"brandIsSpecial":null,"brandOrder":null,"brandAddress":null,"attributeId":null,"standardId":null,"userId":null,"collectionNum":null,"standard":null},{"id":19,"name":"测试19","categoryId":2,"keywords":"测试","model":"1","virtualNum":2,"price":25,"marketPrice":42,"integral":24,"stock":12,"warningStock":212,"coverUrl":"http://oss.irving.net.cn/tea/1911562737563_.pic_hd.jpg","state":1,"showOrder":12,"sellNum":12,"isNew":1,"unit":"1","transId":6,"createBy":1,"createTime":"2019-06-05T08:20:34.000+0000","updateBy":1,"updateTime":"2019-07-10T05:49:17.000+0000","del":0,"isRecommend":1,"isCheck":1,"limitIntegral":2020,"subhead":"202","remark":"阿斯顿发失地发生地方","weight":2,"count":2,"sendIntegral":2,"sendGrowth":2,"productPicture":"http://pic34.nipic.com/20131020/6704106_203943375000_2.jpg,http://pic13.nipic.com/20110409/7119492_114440620000_2.jpg,http://pic13.nipic.com/20110409/7119492_114440620000_2.jpg,http://pic13.nipic.com/20110409/7119492_114440620000_2.jpg","storeId":1,"isSift":1,"brandId":1,"mallStore":null,"sellCount":null,"num":null,"basicService":null,"productType":null,"transName":null,"priceType":null,"deliveryType":null,"defaultTransCost":null,"branName":null,"brandImg":null,"brandIsSpecial":null,"brandOrder":null,"brandAddress":null,"attributeId":null,"standardId":null,"userId":null,"collectionNum":null,"standard":null},{"id":21,"name":"测试21","categoryId":1,"keywords":"测试","model":"1","virtualNum":2,"price":25,"marketPrice":42,"integral":24,"stock":12,"warningStock":212,"coverUrl":"http://oss.irving.net.cn/tea/%E5%BE%AE%E4%BF%A1%E5%9B%BE%E7%89%87_20190621162756.jpg","state":1,"showOrder":12,"sellNum":12,"isNew":0,"unit":"1","transId":1,"createBy":1,"createTime":"2019-06-05T08:20:39.000+0000","updateBy":1,"updateTime":"2019-07-11T02:51:35.000+0000","del":0,"isRecommend":1,"isCheck":1,"limitIntegral":2020,"subhead":"202","remark":"阿斯顿发失地发生地方","weight":2,"count":2,"sendIntegral":2,"sendGrowth":2,"productPicture":"http://pic34.nipic.com/20131020/6704106_203943375000_2.jpg,http://pic13.nipic.com/20110409/7119492_114440620000_2.jpg,http://pic13.nipic.com/20110409/7119492_114440620000_2.jpg,http://pic13.nipic.com/20110409/7119492_114440620000_2.jpg","storeId":1,"isSift":0,"brandId":1,"mallStore":null,"sellCount":null,"num":null,"basicService":null,"productType":null,"transName":null,"priceType":null,"deliveryType":null,"defaultTransCost":null,"branName":null,"brandImg":null,"brandIsSpecial":null,"brandOrder":null,"brandAddress":null,"attributeId":null,"standardId":null,"userId":null,"collectionNum":null,"standard":null},{"id":22,"name":"测试22","categoryId":2,"keywords":"测试","model":"1","virtualNum":2,"price":25,"marketPrice":42,"integral":24,"stock":12,"warningStock":212,"coverUrl":"http://zhmp.oss-cn-shenzhen.aliyuncs.com/tea/%E5%BE%AE%E4%BF%A1%E5%9B%BE%E7%89%87_20190621162803.jpg","state":1,"showOrder":12,"sellNum":12,"isNew":0,"unit":"1","transId":7,"createBy":1,"createTime":"2019-06-05T08:20:41.000+0000","updateBy":1,"updateTime":"2019-07-11T02:51:28.000+0000","del":0,"isRecommend":1,"isCheck":1,"limitIntegral":2020,"subhead":"202","remark":"阿斯顿发失地发生地方","weight":2,"count":2,"sendIntegral":2,"sendGrowth":2,"productPicture":"http://pic34.nipic.com/20131020/6704106_203943375000_2.jpg,http://pic13.nipic.com/20110409/7119492_114440620000_2.jpg,http://pic13.nipic.com/20110409/7119492_114440620000_2.jpg,http://pic13.nipic.com/20110409/7119492_114440620000_2.jpg","storeId":1,"isSift":0,"brandId":1,"mallStore":null,"sellCount":null,"num":null,"basicService":null,"productType":null,"transName":null,"priceType":null,"deliveryType":null,"defaultTransCost":null,"branName":null,"brandImg":null,"brandIsSpecial":null,"brandOrder":null,"brandAddress":null,"attributeId":null,"standardId":null,"userId":null,"collectionNum":null,"standard":null},{"id":23,"name":"测试23","categoryId":1,"keywords":"测试","model":"1","virtualNum":2,"price":25,"marketPrice":42,"integral":24,"stock":12,"warningStock":212,"coverUrl":"http://zhmp.oss-cn-shenzhen.aliyuncs.com/tea/%E5%BE%AE%E4%BF%A1%E5%9B%BE%E7%89%87_20190621162803.jpg","state":1,"showOrder":12,"sellNum":12,"isNew":1,"unit":"1","transId":1,"createBy":1,"createTime":"2019-06-05T08:20:44.000+0000","updateBy":1,"updateTime":"2019-07-11T02:51:27.000+0000","del":0,"isRecommend":1,"isCheck":1,"limitIntegral":2020,"subhead":"202","remark":"阿斯顿发失地发生地方","weight":2,"count":2,"sendIntegral":2,"sendGrowth":2,"productPicture":"http://pic34.nipic.com/20131020/6704106_203943375000_2.jpg,http://pic13.nipic.com/20110409/7119492_114440620000_2.jpg,http://pic13.nipic.com/20110409/7119492_114440620000_2.jpg,http://pic13.nipic.com/20110409/7119492_114440620000_2.jpg","storeId":2,"isSift":1,"brandId":1,"mallStore":null,"sellCount":null,"num":null,"basicService":null,"productType":null,"transName":null,"priceType":null,"deliveryType":null,"defaultTransCost":null,"branName":null,"brandImg":null,"brandIsSpecial":null,"brandOrder":null,"brandAddress":null,"attributeId":null,"standardId":null,"userId":null,"collectionNum":null,"standard":null},{"id":26,"name":"测试26","categoryId":2,"keywords":"测试","model":"1","virtualNum":2,"price":25,"marketPrice":42,"integral":24,"stock":12,"warningStock":212,"coverUrl":"http://zhmp.oss-cn-shenzhen.aliyuncs.com/tea/%E5%BE%AE%E4%BF%A1%E5%9B%BE%E7%89%87_20190621162803.jpg","state":1,"showOrder":12,"sellNum":12,"isNew":1,"unit":"1","transId":1,"createBy":1,"createTime":"2019-06-05T08:20:49.000+0000","updateBy":1,"updateTime":"2019-07-11T02:51:24.000+0000","del":0,"isRecommend":1,"isCheck":1,"limitIntegral":2020,"subhead":"202","remark":"阿斯顿发失地发生地方","weight":2,"count":2,"sendIntegral":2,"sendGrowth":2,"productPicture":"http://pic34.nipic.com/20131020/6704106_203943375000_2.jpg,http://pic13.nipic.com/20110409/7119492_114440620000_2.jpg,http://pic13.nipic.com/20110409/7119492_114440620000_2.jpg,http://pic13.nipic.com/20110409/7119492_114440620000_2.jpg","storeId":2,"isSift":0,"brandId":1,"mallStore":null,"sellCount":null,"num":null,"basicService":null,"productType":null,"transName":null,"priceType":null,"deliveryType":null,"defaultTransCost":null,"branName":null,"brandImg":null,"brandIsSpecial":null,"brandOrder":null,"brandAddress":null,"attributeId":null,"standardId":null,"userId":null,"collectionNum":null,"standard":null},{"id":30,"name":"测试30","categoryId":2,"keywords":"测试","model":"1","virtualNum":2,"price":25,"marketPrice":42,"integral":24,"stock":12,"warningStock":212,"coverUrl":"1212","state":1,"showOrder":12,"sellNum":12,"isNew":1,"unit":"1","transId":8,"createBy":1,"createTime":"2019-06-05T08:20:55.000+0000","updateBy":1,"updateTime":"2019-07-03T06:02:55.000+0000","del":0,"isRecommend":1,"isCheck":1,"limitIntegral":2020,"subhead":"202","remark":"阿斯顿发失地发生地方","weight":2,"count":2,"sendIntegral":2,"sendGrowth":2,"productPicture":"http://pic34.nipic.com/20131020/6704106_203943375000_2.jpg,http://pic13.nipic.com/20110409/7119492_114440620000_2.jpg,http://pic13.nipic.com/20110409/7119492_114440620000_2.jpg,http://pic13.nipic.com/20110409/7119492_114440620000_2.jpg","storeId":2,"isSift":1,"brandId":1,"mallStore":null,"sellCount":null,"num":null,"basicService":null,"productType":null,"transName":null,"priceType":null,"deliveryType":null,"defaultTransCost":null,"branName":null,"brandImg":null,"brandIsSpecial":null,"brandOrder":null,"brandAddress":null,"attributeId":null,"standardId":null,"userId":null,"collectionNum":null,"standard":null},{"id":32,"name":"测试32","categoryId":1,"keywords":"测试","model":"1","virtualNum":2,"price":25,"marketPrice":42,"integral":24,"stock":12,"warningStock":212,"coverUrl":"1212","state":1,"showOrder":12,"sellNum":12,"isNew":1,"unit":"1","transId":1,"createBy":1,"createTime":"2019-06-05T08:20:57.000+0000","updateBy":1,"updateTime":"2019-07-03T06:02:57.000+0000","del":0,"isRecommend":1,"isCheck":1,"limitIntegral":2020,"subhead":"202","remark":"阿斯顿发失地发生地方","weight":2,"count":2,"sendIntegral":2,"sendGrowth":2,"productPicture":"http://pic34.nipic.com/20131020/6704106_203943375000_2.jpg,http://pic13.nipic.com/20110409/7119492_114440620000_2.jpg,http://pic13.nipic.com/20110409/7119492_114440620000_2.jpg,http://pic13.nipic.com/20110409/7119492_114440620000_2.jpg","storeId":5,"isSift":1,"brandId":1,"mallStore":null,"sellCount":null,"num":null,"basicService":null,"productType":null,"transName":null,"priceType":null,"deliveryType":null,"defaultTransCost":null,"branName":null,"brandImg":null,"brandIsSpecial":null,"brandOrder":null,"brandAddress":null,"attributeId":null,"standardId":null,"userId":null,"collectionNum":null,"standard":null},{"id":34,"name":"测试34","categoryId":2,"keywords":"测试","model":"1","virtualNum":2,"price":25,"marketPrice":42,"integral":24,"stock":12,"warningStock":212,"coverUrl":"1212","state":1,"showOrder":12,"sellNum":12,"isNew":1,"unit":"1","transId":1,"createBy":1,"createTime":"2019-06-05T08:21:00.000+0000","updateBy":1,"updateTime":"2019-07-03T06:02:59.000+0000","del":0,"isRecommend":1,"isCheck":1,"limitIntegral":2020,"subhead":"202","remark":"阿斯顿发失地发生地方","weight":2,"count":2,"sendIntegral":2,"sendGrowth":2,"productPicture":"http://pic34.nipic.com/20131020/6704106_203943375000_2.jpg,http://pic13.nipic.com/20110409/7119492_114440620000_2.jpg,http://pic13.nipic.com/20110409/7119492_114440620000_2.jpg,http://pic13.nipic.com/20110409/7119492_114440620000_2.jpg","storeId":5,"isSift":0,"brandId":1,"mallStore":null,"sellCount":null,"num":null,"basicService":null,"productType":null,"transName":null,"priceType":null,"deliveryType":null,"defaultTransCost":null,"branName":null,"brandImg":null,"brandIsSpecial":null,"brandOrder":null,"brandAddress":null,"attributeId":null,"standardId":null,"userId":null,"collectionNum":null,"standard":null},{"id":36,"name":"奥术大师多","categoryId":1,"keywords":"奥术大师多","model":"1","virtualNum":25,"price":25.45,"marketPrice":25.45,"integral":5,"stock":15,"warningStock":10,"coverUrl":"封面","state":1,"showOrder":12,"sellNum":11,"isNew":0,"unit":"12","transId":1,"createBy":1,"createTime":"2019-02-14T02:00:00.000+0000","updateBy":2,"updateTime":"2019-07-02T09:06:23.000+0000","del":0,"isRecommend":0,"isCheck":0,"limitIntegral":2,"subhead":"副标题","remark":"商品描述","weight":5,"count":5,"sendIntegral":5,"sendGrowth":5,"productPicture":"http://pic34.nipic.com/20131020/6704106_203943375000_2.jpg,http://pic13.nipic.com/20110409/7119492_114440620000_2.jpg,http://pic13.nipic.com/20110409/7119492_114440620000_2.jpg,http://pic13.nipic.com/20110409/7119492_114440620000_2.jpg","storeId":7,"isSift":1,"brandId":1,"mallStore":null,"sellCount":null,"num":null,"basicService":null,"productType":null,"transName":null,"priceType":null,"deliveryType":null,"defaultTransCost":null,"branName":null,"brandImg":null,"brandIsSpecial":null,"brandOrder":null,"brandAddress":null,"attributeId":null,"standardId":null,"userId":null,"collectionNum":null,"standard":null},{"id":38,"name":"商品标题","categoryId":2,"keywords":"商品关键字","model":"1","virtualNum":25,"price":25.45,"marketPrice":12,"integral":5,"stock":15,"warningStock":10,"coverUrl":"封面图","state":1,"showOrder":0,"sellNum":11,"isNew":1,"unit":"12","transId":4,"createBy":11,"createTime":"2019-02-14T02:00:00.000+0000","updateBy":1,"updateTime":"2019-07-03T06:03:03.000+0000","del":0,"isRecommend":0,"isCheck":0,"limitIntegral":2,"subhead":"副标题6666666","remark":"商品描述66666666666","weight":5,"count":45,"sendIntegral":5,"sendGrowth":21,"productPicture":"http://pic34.nipic.com/20131020/6704106_203943375000_2.jpg,http://pic13.nipic.com/20110409/7119492_114440620000_2.jpg,http://pic13.nipic.com/20110409/7119492_114440620000_2.jpg,http://pic13.nipic.com/20110409/7119492_114440620000_2.jpg","storeId":1,"isSift":0,"brandId":1,"mallStore":null,"sellCount":null,"num":null,"basicService":null,"productType":null,"transName":null,"priceType":null,"deliveryType":null,"defaultTransCost":null,"branName":null,"brandImg":null,"brandIsSpecial":null,"brandOrder":null,"brandAddress":null,"attributeId":null,"standardId":null,"userId":null,"collectionNum":null,"standard":null},{"id":40,"name":"商品标题","categoryId":2,"keywords":"商品关键字","model":"2","virtualNum":25,"price":25.45,"marketPrice":12,"integral":5,"stock":15,"warningStock":10,"coverUrl":"封面图","state":1,"showOrder":0,"sellNum":11,"isNew":1,"unit":"12","transId":1,"createBy":11,"createTime":"2019-02-14T02:00:00.000+0000","updateBy":1,"updateTime":"2019-07-02T09:06:37.000+0000","del":0,"isRecommend":0,"isCheck":0,"limitIntegral":2,"subhead":"副标题6666666","remark":"商品描述66666666666","weight":5,"count":45,"sendIntegral":5,"sendGrowth":21,"productPicture":"http://pic34.nipic.com/20131020/6704106_203943375000_2.jpg,http://pic13.nipic.com/20110409/7119492_114440620000_2.jpg,http://pic13.nipic.com/20110409/7119492_114440620000_2.jpg,http://pic13.nipic.com/20110409/7119492_114440620000_2.jpg","storeId":1,"isSift":1,"brandId":1,"mallStore":null,"sellCount":null,"num":null,"basicService":null,"productType":null,"transName":null,"priceType":null,"deliveryType":null,"defaultTransCost":null,"branName":null,"brandImg":null,"brandIsSpecial":null,"brandOrder":null,"brandAddress":null,"attributeId":null,"standardId":null,"userId":null,"collectionNum":null,"standard":null},{"id":41,"name":"商品标题","categoryId":2,"keywords":"商品关键字","model":"1","virtualNum":25,"price":25.45,"marketPrice":12,"integral":5,"stock":15,"warningStock":10,"coverUrl":"封面图","state":1,"showOrder":0,"sellNum":11,"isNew":1,"unit":"12","transId":1,"createBy":11,"createTime":"2019-02-14T02:00:00.000+0000","updateBy":1,"updateTime":"2019-07-02T09:06:39.000+0000","del":0,"isRecommend":0,"isCheck":0,"limitIntegral":2,"subhead":"副标题6666666","remark":"商品描述66666666666","weight":5,"count":45,"sendIntegral":5,"sendGrowth":21,"productPicture":"http://pic34.nipic.com/20131020/6704106_203943375000_2.jpg,http://pic13.nipic.com/20110409/7119492_114440620000_2.jpg,http://pic13.nipic.com/20110409/7119492_114440620000_2.jpg,http://pic13.nipic.com/20110409/7119492_114440620000_2.jpg","storeId":1,"isSift":1,"brandId":1,"mallStore":null,"sellCount":null,"num":null,"basicService":null,"productType":null,"transName":null,"priceType":null,"deliveryType":null,"defaultTransCost":null,"branName":null,"brandImg":null,"brandIsSpecial":null,"brandOrder":null,"brandAddress":null,"attributeId":null,"standardId":null,"userId":null,"collectionNum":null,"standard":null},{"id":42,"name":"商品标题","categoryId":2,"keywords":"商品关键字","model":"2","virtualNum":25,"price":25.45,"marketPrice":12,"integral":5,"stock":15,"warningStock":10,"coverUrl":"封面图","state":1,"showOrder":0,"sellNum":11,"isNew":1,"unit":"12","transId":1,"createBy":11,"createTime":"2019-02-14T02:00:00.000+0000","updateBy":1,"updateTime":"2019-07-02T09:06:40.000+0000","del":0,"isRecommend":0,"isCheck":0,"limitIntegral":2,"subhead":"副标题6666666","remark":"商品描述66666666666","weight":5,"count":45,"sendIntegral":5,"sendGrowth":21,"productPicture":"http://pic34.nipic.com/20131020/6704106_203943375000_2.jpg,http://pic13.nipic.com/20110409/7119492_114440620000_2.jpg,http://pic13.nipic.com/20110409/7119492_114440620000_2.jpg,http://pic13.nipic.com/20110409/7119492_114440620000_2.jpg","storeId":1,"isSift":1,"brandId":1,"mallStore":null,"sellCount":null,"num":null,"basicService":null,"productType":null,"transName":null,"priceType":null,"deliveryType":null,"defaultTransCost":null,"branName":null,"brandImg":null,"brandIsSpecial":null,"brandOrder":null,"brandAddress":null,"attributeId":null,"standardId":null,"userId":null,"collectionNum":null,"standard":null},{"id":43,"name":"商品标题","categoryId":2,"keywords":"商品关键字","model":"1","virtualNum":25,"price":25.45,"marketPrice":12,"integral":5,"stock":15,"warningStock":10,"coverUrl":"封面图","state":1,"showOrder":0,"sellNum":11,"isNew":1,"unit":"12","transId":5,"createBy":11,"createTime":"2019-02-14T02:00:00.000+0000","updateBy":1,"updateTime":"2019-07-02T09:06:41.000+0000","del":0,"isRecommend":0,"isCheck":0,"limitIntegral":2,"subhead":"副标题6666666","remark":"商品描述66666666666","weight":5,"count":45,"sendIntegral":5,"sendGrowth":21,"productPicture":"http://pic34.nipic.com/20131020/6704106_203943375000_2.jpg,http://pic13.nipic.com/20110409/7119492_114440620000_2.jpg,http://pic13.nipic.com/20110409/7119492_114440620000_2.jpg,http://pic13.nipic.com/20110409/7119492_114440620000_2.jpg","storeId":1,"isSift":1,"brandId":1,"mallStore":null,"sellCount":null,"num":null,"basicService":null,"productType":null,"transName":null,"priceType":null,"deliveryType":null,"defaultTransCost":null,"branName":null,"brandImg":null,"brandIsSpecial":null,"brandOrder":null,"brandAddress":null,"attributeId":null,"standardId":null,"userId":null,"collectionNum":null,"standard":null},{"id":45,"name":"商品标题","categoryId":1,"keywords":"商品关键字","model":"1","virtualNum":1,"price":1,"marketPrice":1,"integral":1,"stock":33,"warningStock":1,"coverUrl":"http://img2.imgtn.bdimg.com/it/u=180868167,273146879&fm=26&gp=0.jpg","state":1,"showOrder":1,"sellNum":1560,"isNew":1,"unit":"1","transId":2,"createBy":1,"createTime":"2019-06-13T03:00:00.000+0000","updateBy":1,"updateTime":"2019-07-09T06:27:56.000+0000","del":1,"isRecommend":1,"isCheck":1,"limitIntegral":1,"subhead":"1","remark":"1","weight":1,"count":1,"sendIntegral":1,"sendGrowth":1,"productPicture":"http://pic34.nipic.com/20131020/6704106_203943375000_2.jpg,http://pic13.nipic.com/20110409/7119492_114440620000_2.jpg,http://pic13.nipic.com/20110409/7119492_114440620000_2.jpg,http://pic13.nipic.com/20110409/7119492_114440620000_2.jpg","storeId":1,"isSift":1,"brandId":1,"mallStore":null,"sellCount":null,"num":null,"basicService":null,"productType":null,"transName":null,"priceType":null,"deliveryType":null,"defaultTransCost":null,"branName":null,"brandImg":null,"brandIsSpecial":null,"brandOrder":null,"brandAddress":null,"attributeId":null,"standardId":null,"userId":null,"collectionNum":null,"standard":null},{"id":47,"name":"商品标题","categoryId":1,"keywords":"商品关键字","model":"2","virtualNum":0,"price":75,"marketPrice":75,"integral":0,"stock":11,"warningStock":12,"coverUrl":"封面图片","state":1,"showOrder":1,"sellNum":1560,"isNew":1,"unit":"1","transId":1,"createBy":1,"createTime":"2019-06-21T08:49:22.000+0000","updateBy":1,"updateTime":"2019-07-02T09:06:47.000+0000","del":1,"isRecommend":1,"isCheck":1,"limitIntegral":1,"subhead":"1","remark":"1","weight":12,"count":21,"sendIntegral":12,"sendGrowth":12,"productPicture":"http://pic34.nipic.com/20131020/6704106_203943375000_2.jpg,http://pic13.nipic.com/20110409/7119492_114440620000_2.jpg,http://pic13.nipic.com/20110409/7119492_114440620000_2.jpg,http://pic13.nipic.com/20110409/7119492_114440620000_2.jpg","storeId":1,"isSift":1,"brandId":1,"mallStore":null,"sellCount":null,"num":null,"basicService":null,"productType":null,"transName":null,"priceType":null,"deliveryType":null,"defaultTransCost":null,"branName":null,"brandImg":null,"brandIsSpecial":null,"brandOrder":null,"brandAddress":null,"attributeId":null,"standardId":null,"userId":null,"collectionNum":null,"standard":null},{"id":48,"name":"商品标题","categoryId":2,"keywords":"茶","model":null,"virtualNum":null,"price":100,"marketPrice":100,"integral":null,"stock":null,"warningStock":null,"coverUrl":"封面图","state":null,"showOrder":1,"sellNum":null,"isNew":1,"unit":"克","transId":null,"createBy":1,"createTime":null,"updateBy":null,"updateTime":"2019-07-16T06:18:33.000+0000","del":null,"isRecommend":null,"isCheck":null,"limitIntegral":null,"subhead":"副标题","remark":"商品描述","weight":null,"count":null,"sendIntegral":null,"sendGrowth":null,"productPicture":"产品图片","storeId":1,"isSift":1,"brandId":1,"mallStore":null,"sellCount":null,"num":null,"basicService":null,"productType":null,"transName":null,"priceType":null,"deliveryType":null,"defaultTransCost":null,"branName":null,"brandImg":null,"brandIsSpecial":null,"brandOrder":null,"brandAddress":null,"attributeId":null,"standardId":null,"userId":null,"collectionNum":null,"standard":null},{"id":53,"name":"商品标题","categoryId":2,"keywords":"茶","model":"","virtualNum":0,"price":100,"marketPrice":100,"integral":0,"stock":null,"warningStock":null,"coverUrl":"封面图","state":0,"showOrder":1,"sellNum":0,"isNew":1,"unit":"克","transId":0,"createBy":1,"createTime":"2019-06-28T01:46:26.000+0000","updateBy":null,"updateTime":"2019-06-28T01:46:26.000+0000","del":0,"isRecommend":0,"isCheck":0,"limitIntegral":null,"subhead":"副标题","remark":"商品描述","weight":null,"count":null,"sendIntegral":null,"sendGrowth":null,"productPicture":"产品图片","storeId":1,"isSift":0,"brandId":1,"mallStore":null,"sellCount":null,"num":null,"basicService":null,"productType":null,"transName":null,"priceType":null,"deliveryType":null,"defaultTransCost":null,"branName":null,"brandImg":null,"brandIsSpecial":null,"brandOrder":null,"brandAddress":null,"attributeId":null,"standardId":null,"userId":null,"collectionNum":null,"standard":null},{"id":54,"name":"商品标题","categoryId":2,"keywords":"茶","model":"","virtualNum":0,"price":100,"marketPrice":100,"integral":0,"stock":null,"warningStock":null,"coverUrl":"封面图","state":0,"showOrder":1,"sellNum":0,"isNew":1,"unit":"克","transId":0,"createBy":1,"createTime":"2019-06-28T01:46:55.000+0000","updateBy":null,"updateTime":"2019-06-28T01:46:55.000+0000","del":0,"isRecommend":0,"isCheck":0,"limitIntegral":null,"subhead":"副标题","remark":"商品描述","weight":null,"count":null,"sendIntegral":null,"sendGrowth":null,"productPicture":"产品图片","storeId":1,"isSift":0,"brandId":1,"mallStore":null,"sellCount":null,"num":null,"basicService":null,"productType":null,"transName":null,"priceType":null,"deliveryType":null,"defaultTransCost":null,"branName":null,"brandImg":null,"brandIsSpecial":null,"brandOrder":null,"brandAddress":null,"attributeId":null,"standardId":null,"userId":null,"collectionNum":null,"standard":null},{"id":55,"name":"商品标题","categoryId":2,"keywords":"茶","model":"","virtualNum":0,"price":100,"marketPrice":100,"integral":0,"stock":null,"warningStock":null,"coverUrl":"封面图","state":0,"showOrder":1,"sellNum":0,"isNew":1,"unit":"克","transId":0,"createBy":1,"createTime":"2019-06-28T02:21:21.000+0000","updateBy":null,"updateTime":"2019-06-28T02:21:21.000+0000","del":0,"isRecommend":0,"isCheck":0,"limitIntegral":null,"subhead":"副标题","remark":"商品描述","weight":null,"count":null,"sendIntegral":null,"sendGrowth":null,"productPicture":"产品图片","storeId":1,"isSift":0,"brandId":1,"mallStore":null,"sellCount":null,"num":null,"basicService":null,"productType":null,"transName":null,"priceType":null,"deliveryType":null,"defaultTransCost":null,"branName":null,"brandImg":null,"brandIsSpecial":null,"brandOrder":null,"brandAddress":null,"attributeId":null,"standardId":null,"userId":null,"collectionNum":null,"standard":null},{"id":56,"name":"商品标题","categoryId":2,"keywords":"茶","model":"","virtualNum":0,"price":100,"marketPrice":100,"integral":0,"stock":null,"warningStock":null,"coverUrl":"封面图","state":0,"showOrder":1,"sellNum":0,"isNew":1,"unit":"克","transId":0,"createBy":1,"createTime":"2019-06-28T02:26:52.000+0000","updateBy":null,"updateTime":"2019-06-28T02:26:52.000+0000","del":0,"isRecommend":0,"isCheck":0,"limitIntegral":null,"subhead":"副标题","remark":"商品描述","weight":null,"count":null,"sendIntegral":null,"sendGrowth":null,"productPicture":"产品图片","storeId":1,"isSift":0,"brandId":1,"mallStore":null,"sellCount":null,"num":null,"basicService":null,"productType":null,"transName":null,"priceType":null,"deliveryType":null,"defaultTransCost":null,"branName":null,"brandImg":null,"brandIsSpecial":null,"brandOrder":null,"brandAddress":null,"attributeId":null,"standardId":null,"userId":null,"collectionNum":null,"standard":null},{"id":57,"name":"商品标题","categoryId":2,"keywords":"茶","model":"","virtualNum":0,"price":100,"marketPrice":100,"integral":0,"stock":null,"warningStock":null,"coverUrl":"封面图","state":0,"showOrder":1,"sellNum":0,"isNew":1,"unit":"克","transId":0,"createBy":1,"createTime":"2019-06-28T02:26:59.000+0000","updateBy":null,"updateTime":"2019-06-28T02:26:59.000+0000","del":0,"isRecommend":0,"isCheck":0,"limitIntegral":null,"subhead":"副标题","remark":"商品描述","weight":null,"count":null,"sendIntegral":null,"sendGrowth":null,"productPicture":"产品图片","storeId":1,"isSift":0,"brandId":1,"mallStore":null,"sellCount":null,"num":null,"basicService":null,"productType":null,"transName":null,"priceType":null,"deliveryType":null,"defaultTransCost":null,"branName":null,"brandImg":null,"brandIsSpecial":null,"brandOrder":null,"brandAddress":null,"attributeId":null,"standardId":null,"userId":null,"collectionNum":null,"standard":null},{"id":58,"name":"商品标题","categoryId":2,"keywords":"茶","model":"","virtualNum":0,"price":100,"marketPrice":100,"integral":0,"stock":null,"warningStock":null,"coverUrl":"封面图","state":0,"showOrder":1,"sellNum":0,"isNew":1,"unit":"克","transId":0,"createBy":1,"createTime":"2019-06-28T02:29:04.000+0000","updateBy":null,"updateTime":"2019-06-28T02:29:04.000+0000","del":0,"isRecommend":0,"isCheck":0,"limitIntegral":null,"subhead":"副标题","remark":"商品描述","weight":null,"count":null,"sendIntegral":null,"sendGrowth":null,"productPicture":"产品图片","storeId":1,"isSift":0,"brandId":1,"mallStore":null,"sellCount":null,"num":null,"basicService":null,"productType":null,"transName":null,"priceType":null,"deliveryType":null,"defaultTransCost":null,"branName":null,"brandImg":null,"brandIsSpecial":null,"brandOrder":null,"brandAddress":null,"attributeId":null,"standardId":null,"userId":null,"collectionNum":null,"standard":null},{"id":59,"name":"好运来","categoryId":1,"keywords":"红茶","model":"","virtualNum":0,"price":25.6,"marketPrice":35,"integral":0,"stock":null,"warningStock":null,"coverUrl":"快快快","state":0,"showOrder":3,"sellNum":0,"isNew":1,"unit":"g","transId":0,"createBy":33,"createTime":"2019-07-08T04:47:37.000+0000","updateBy":null,"updateTime":"2019-07-08T04:47:37.000+0000","del":0,"isRecommend":0,"isCheck":0,"limitIntegral":null,"subhead":"","remark":"fgfgfgfg","weight":null,"count":null,"sendIntegral":null,"sendGrowth":null,"productPicture":"gfgfggffff","storeId":23,"isSift":1,"brandId":1,"mallStore":null,"sellCount":null,"num":null,"basicService":null,"productType":null,"transName":null,"priceType":null,"deliveryType":null,"defaultTransCost":null,"branName":null,"brandImg":null,"brandIsSpecial":null,"brandOrder":null,"brandAddress":null,"attributeId":null,"standardId":null,"userId":null,"collectionNum":null,"standard":null},{"id":60,"name":"好运来","categoryId":1,"keywords":"红茶","model":"","virtualNum":0,"price":25.6,"marketPrice":35,"integral":0,"stock":null,"warningStock":null,"coverUrl":"快快快","state":0,"showOrder":3,"sellNum":0,"isNew":1,"unit":"g","transId":0,"createBy":33,"createTime":"2019-07-08T06:00:25.000+0000","updateBy":null,"updateTime":"2019-07-08T06:00:25.000+0000","del":0,"isRecommend":0,"isCheck":0,"limitIntegral":null,"subhead":"","remark":"fgfgfgfg","weight":null,"count":null,"sendIntegral":null,"sendGrowth":null,"productPicture":"gfgfggffff","storeId":23,"isSift":1,"brandId":1,"mallStore":null,"sellCount":null,"num":null,"basicService":null,"productType":null,"transName":null,"priceType":null,"deliveryType":null,"defaultTransCost":null,"branName":null,"brandImg":null,"brandIsSpecial":null,"brandOrder":null,"brandAddress":null,"attributeId":null,"standardId":null,"userId":null,"collectionNum":null,"standard":null},{"id":61,"name":"好运来","categoryId":1,"keywords":"红茶","model":"","virtualNum":0,"price":25.6,"marketPrice":35,"integral":0,"stock":null,"warningStock":null,"coverUrl":"快快快","state":0,"showOrder":3,"sellNum":0,"isNew":1,"unit":"g","transId":0,"createBy":33,"createTime":"2019-07-08T07:12:52.000+0000","updateBy":null,"updateTime":"2019-07-08T07:12:52.000+0000","del":0,"isRecommend":0,"isCheck":0,"limitIntegral":null,"subhead":"","remark":"fgfgfgfg","weight":null,"count":null,"sendIntegral":null,"sendGrowth":null,"productPicture":"gfgfggffff","storeId":23,"isSift":1,"brandId":1,"mallStore":null,"sellCount":null,"num":null,"basicService":null,"productType":null,"transName":null,"priceType":null,"deliveryType":null,"defaultTransCost":null,"branName":null,"brandImg":null,"brandIsSpecial":null,"brandOrder":null,"brandAddress":null,"attributeId":null,"standardId":null,"userId":null,"collectionNum":null,"standard":null},{"id":62,"name":"好运来","categoryId":1,"keywords":"红茶","model":"","virtualNum":0,"price":25.6,"marketPrice":35,"integral":0,"stock":null,"warningStock":null,"coverUrl":"快快快","state":0,"showOrder":3,"sellNum":0,"isNew":1,"unit":"g","transId":0,"createBy":33,"createTime":"2019-07-08T07:15:01.000+0000","updateBy":null,"updateTime":"2019-07-08T07:15:01.000+0000","del":0,"isRecommend":0,"isCheck":0,"limitIntegral":null,"subhead":"","remark":"fgfgfgfg","weight":null,"count":null,"sendIntegral":null,"sendGrowth":null,"productPicture":"gfgfggffff","storeId":23,"isSift":1,"brandId":1,"mallStore":null,"sellCount":null,"num":null,"basicService":null,"productType":null,"transName":null,"priceType":null,"deliveryType":null,"defaultTransCost":null,"branName":null,"brandImg":null,"brandIsSpecial":null,"brandOrder":null,"brandAddress":null,"attributeId":null,"standardId":null,"userId":null,"collectionNum":null,"standard":null},{"id":20,"name":"测试20","categoryId":2,"keywords":"测试","model":"1","virtualNum":2,"price":25,"marketPrice":42,"integral":24,"stock":12,"warningStock":212,"coverUrl":"http://oss.irving.net.cn/tea/%E5%BE%AE%E4%BF%A1%E5%9B%BE%E7%89%87_20190621162756.jpg","state":1,"showOrder":12,"sellNum":12,"isNew":1,"unit":"1","transId":1,"createBy":1,"createTime":"2019-06-05T08:20:38.000+0000","updateBy":1,"updateTime":"2019-07-11T02:51:34.000+0000","del":0,"isRecommend":1,"isCheck":1,"limitIntegral":2020,"subhead":"202","remark":"阿斯顿发失地发生地方","weight":2,"count":2,"sendIntegral":2,"sendGrowth":2,"productPicture":"http://pic34.nipic.com/20131020/6704106_203943375000_2.jpg,http://pic13.nipic.com/20110409/7119492_114440620000_2.jpg,http://pic13.nipic.com/20110409/7119492_114440620000_2.jpg,http://pic13.nipic.com/20110409/7119492_114440620000_2.jpg","storeId":1,"isSift":1,"brandId":2,"mallStore":null,"sellCount":null,"num":null,"basicService":null,"productType":null,"transName":null,"priceType":null,"deliveryType":null,"defaultTransCost":null,"branName":null,"brandImg":null,"brandIsSpecial":null,"brandOrder":null,"brandAddress":null,"attributeId":null,"standardId":null,"userId":null,"collectionNum":null,"standard":null},{"id":24,"name":"测试24","categoryId":2,"keywords":"测试","model":"1","virtualNum":2,"price":25,"marketPrice":42,"integral":24,"stock":12,"warningStock":212,"coverUrl":"http://zhmp.oss-cn-shenzhen.aliyuncs.com/tea/%E5%BE%AE%E4%BF%A1%E5%9B%BE%E7%89%87_20190621162803.jpg","state":1,"showOrder":12,"sellNum":12,"isNew":1,"unit":"1","transId":1,"createBy":1,"createTime":"2019-06-05T08:20:46.000+0000","updateBy":1,"updateTime":"2019-07-11T02:51:26.000+0000","del":0,"isRecommend":1,"isCheck":1,"limitIntegral":2020,"subhead":"202","remark":"阿斯顿发失地发生地方","weight":2,"count":2,"sendIntegral":2,"sendGrowth":2,"productPicture":"http://pic34.nipic.com/20131020/6704106_203943375000_2.jpg,http://pic13.nipic.com/20110409/7119492_114440620000_2.jpg,http://pic13.nipic.com/20110409/7119492_114440620000_2.jpg,http://pic13.nipic.com/20110409/7119492_114440620000_2.jpg","storeId":2,"isSift":1,"brandId":2,"mallStore":null,"sellCount":null,"num":null,"basicService":null,"productType":null,"transName":null,"priceType":null,"deliveryType":null,"defaultTransCost":null,"branName":null,"brandImg":null,"brandIsSpecial":null,"brandOrder":null,"brandAddress":null,"attributeId":null,"standardId":null,"userId":null,"collectionNum":null,"standard":null},{"id":25,"name":"测试25","categoryId":2,"keywords":"测试","model":"1","virtualNum":2,"price":25,"marketPrice":42,"integral":24,"stock":12,"warningStock":212,"coverUrl":"http://zhmp.oss-cn-shenzhen.aliyuncs.com/tea/%E5%BE%AE%E4%BF%A1%E5%9B%BE%E7%89%87_20190621162803.jpg","state":1,"showOrder":12,"sellNum":12,"isNew":1,"unit":"1","transId":9,"createBy":1,"createTime":"2019-06-05T08:20:48.000+0000","updateBy":1,"updateTime":"2019-07-11T02:51:25.000+0000","del":0,"isRecommend":1,"isCheck":1,"limitIntegral":2020,"subhead":"202","remark":"阿斯顿发失地发生地方","weight":2,"count":2,"sendIntegral":2,"sendGrowth":2,"productPicture":"http://pic34.nipic.com/20131020/6704106_203943375000_2.jpg,http://pic13.nipic.com/20110409/7119492_114440620000_2.jpg,http://pic13.nipic.com/20110409/7119492_114440620000_2.jpg,http://pic13.nipic.com/20110409/7119492_114440620000_2.jpg","storeId":2,"isSift":1,"brandId":2,"mallStore":null,"sellCount":null,"num":null,"basicService":null,"productType":null,"transName":null,"priceType":null,"deliveryType":null,"defaultTransCost":null,"branName":null,"brandImg":null,"brandIsSpecial":null,"brandOrder":null,"brandAddress":null,"attributeId":null,"standardId":null,"userId":null,"collectionNum":null,"standard":null},{"id":27,"name":"测试27","categoryId":1,"keywords":"测试","model":"1","virtualNum":2,"price":25,"marketPrice":42,"integral":24,"stock":12,"warningStock":212,"coverUrl":"http://zhmp.oss-cn-shenzhen.aliyuncs.com/tea/%E5%BE%AE%E4%BF%A1%E5%9B%BE%E7%89%87_20190621162803.jpg","state":1,"showOrder":12,"sellNum":12,"isNew":0,"unit":"1","transId":1,"createBy":1,"createTime":"2019-06-05T08:20:50.000+0000","updateBy":1,"updateTime":"2019-07-11T02:51:23.000+0000","del":0,"isRecommend":1,"isCheck":1,"limitIntegral":2020,"subhead":"202","remark":"阿斯顿发失地发生地方","weight":2,"count":2,"sendIntegral":2,"sendGrowth":2,"productPicture":"http://pic34.nipic.com/20131020/6704106_203943375000_2.jpg,http://pic13.nipic.com/20110409/7119492_114440620000_2.jpg,http://pic13.nipic.com/20110409/7119492_114440620000_2.jpg,http://pic13.nipic.com/20110409/7119492_114440620000_2.jpg","storeId":1,"isSift":1,"brandId":2,"mallStore":null,"sellCount":null,"num":null,"basicService":null,"productType":null,"transName":null,"priceType":null,"deliveryType":null,"defaultTransCost":null,"branName":null,"brandImg":null,"brandIsSpecial":null,"brandOrder":null,"brandAddress":null,"attributeId":null,"standardId":null,"userId":null,"collectionNum":null,"standard":null},{"id":28,"name":"测试28","categoryId":2,"keywords":"测试","model":"1","virtualNum":2,"price":25,"marketPrice":42,"integral":24,"stock":12,"warningStock":212,"coverUrl":"1212","state":1,"showOrder":12,"sellNum":12,"isNew":0,"unit":"1","transId":1,"createBy":1,"createTime":"2019-06-05T08:20:51.000+0000","updateBy":1,"updateTime":"2019-07-03T06:02:53.000+0000","del":0,"isRecommend":1,"isCheck":1,"limitIntegral":2020,"subhead":"202","remark":"阿斯顿发失地发生地方","weight":2,"count":2,"sendIntegral":2,"sendGrowth":2,"productPicture":"http://pic34.nipic.com/20131020/6704106_203943375000_2.jpg,http://pic13.nipic.com/20110409/7119492_114440620000_2.jpg,http://pic13.nipic.com/20110409/7119492_114440620000_2.jpg,http://pic13.nipic.com/20110409/7119492_114440620000_2.jpg","storeId":1,"isSift":1,"brandId":2,"mallStore":null,"sellCount":null,"num":null,"basicService":null,"productType":null,"transName":null,"priceType":null,"deliveryType":null,"defaultTransCost":null,"branName":null,"brandImg":null,"brandIsSpecial":null,"brandOrder":null,"brandAddress":null,"attributeId":null,"standardId":null,"userId":null,"collectionNum":null,"standard":null},{"id":29,"name":"测试29","categoryId":1,"keywords":"测试","model":"1","virtualNum":2,"price":111,"marketPrice":42,"integral":24,"stock":12,"warningStock":212,"coverUrl":"1212","state":1,"showOrder":12,"sellNum":12,"isNew":1,"unit":"1","transId":1,"createBy":1,"createTime":"2019-06-05T08:20:53.000+0000","updateBy":1,"updateTime":"2019-07-03T06:02:54.000+0000","del":0,"isRecommend":1,"isCheck":1,"limitIntegral":2020,"subhead":"202","remark":"阿斯顿发失地发生地方","weight":2,"count":2,"sendIntegral":2,"sendGrowth":2,"productPicture":"http://pic34.nipic.com/20131020/6704106_203943375000_2.jpg,http://pic13.nipic.com/20110409/7119492_114440620000_2.jpg,http://pic13.nipic.com/20110409/7119492_114440620000_2.jpg,http://pic13.nipic.com/20110409/7119492_114440620000_2.jpg","storeId":2,"isSift":1,"brandId":2,"mallStore":null,"sellCount":null,"num":null,"basicService":null,"productType":null,"transName":null,"priceType":null,"deliveryType":null,"defaultTransCost":null,"branName":null,"brandImg":null,"brandIsSpecial":null,"brandOrder":null,"brandAddress":null,"attributeId":null,"standardId":null,"userId":null,"collectionNum":null,"standard":null},{"id":31,"name":"测试31","categoryId":2,"keywords":"测试","model":"1","virtualNum":2,"price":75,"marketPrice":42,"integral":24,"stock":12,"warningStock":212,"coverUrl":"1212","state":1,"showOrder":12,"sellNum":12,"isNew":0,"unit":"1","transId":1,"createBy":1,"createTime":"2019-06-05T08:20:56.000+0000","updateBy":1,"updateTime":"2019-07-03T06:02:56.000+0000","del":0,"isRecommend":1,"isCheck":1,"limitIntegral":2020,"subhead":"202","remark":"阿斯顿发失地发生地方","weight":2,"count":2,"sendIntegral":2,"sendGrowth":2,"productPicture":"http://pic34.nipic.com/20131020/6704106_203943375000_2.jpg,http://pic13.nipic.com/20110409/7119492_114440620000_2.jpg,http://pic13.nipic.com/20110409/7119492_114440620000_2.jpg,http://pic13.nipic.com/20110409/7119492_114440620000_2.jpg","storeId":4,"isSift":0,"brandId":2,"mallStore":null,"sellCount":null,"num":null,"basicService":null,"productType":null,"transName":null,"priceType":null,"deliveryType":null,"defaultTransCost":null,"branName":null,"brandImg":null,"brandIsSpecial":null,"brandOrder":null,"brandAddress":null,"attributeId":null,"standardId":null,"userId":null,"collectionNum":null,"standard":null},{"id":33,"name":"测试33","categoryId":2,"keywords":"测试","model":"1","virtualNum":2,"price":66,"marketPrice":42,"integral":24,"stock":12,"warningStock":212,"coverUrl":"1212","state":1,"showOrder":12,"sellNum":12,"isNew":1,"unit":"1","transId":1,"createBy":1,"createTime":"2019-06-05T08:20:58.000+0000","updateBy":1,"updateTime":"2019-07-03T06:02:58.000+0000","del":0,"isRecommend":1,"isCheck":1,"limitIntegral":2020,"subhead":"202","remark":"阿斯顿发失地发生地方","weight":2,"count":2,"sendIntegral":2,"sendGrowth":2,"productPicture":"http://pic34.nipic.com/20131020/6704106_203943375000_2.jpg,http://pic13.nipic.com/20110409/7119492_114440620000_2.jpg,http://pic13.nipic.com/20110409/7119492_114440620000_2.jpg,http://pic13.nipic.com/20110409/7119492_114440620000_2.jpg","storeId":3,"isSift":0,"brandId":2,"mallStore":null,"sellCount":null,"num":null,"basicService":null,"productType":null,"transName":null,"priceType":null,"deliveryType":null,"defaultTransCost":null,"branName":null,"brandImg":null,"brandIsSpecial":null,"brandOrder":null,"brandAddress":null,"attributeId":null,"standardId":null,"userId":null,"collectionNum":null,"standard":null},{"id":35,"name":"商品标题","categoryId":1,"keywords":"商品关键字","model":"1","virtualNum":1,"price":12,"marketPrice":12,"integral":12,"stock":12,"warningStock":12,"coverUrl":"封面图","state":1,"showOrder":0,"sellNum":10,"isNew":0,"unit":"01","transId":7,"createBy":11,"createTime":"2019-02-14T02:00:00.000+0000","updateBy":66,"updateTime":"2019-07-03T06:03:00.000+0000","del":0,"isRecommend":0,"isCheck":0,"limitIntegral":111,"subhead":"副标题6666666","remark":"商品描述66666666666","weight":25,"count":45,"sendIntegral":12,"sendGrowth":21,"productPicture":"http://pic34.nipic.com/20131020/6704106_203943375000_2.jpg,http://pic13.nipic.com/20110409/7119492_114440620000_2.jpg,http://pic13.nipic.com/20110409/7119492_114440620000_2.jpg,http://pic13.nipic.com/20110409/7119492_114440620000_2.jpg","storeId":1,"isSift":1,"brandId":2,"mallStore":null,"sellCount":null,"num":null,"basicService":null,"productType":null,"transName":null,"priceType":null,"deliveryType":null,"defaultTransCost":null,"branName":null,"brandImg":null,"brandIsSpecial":null,"brandOrder":null,"brandAddress":null,"attributeId":null,"standardId":null,"userId":null,"collectionNum":null,"standard":null},{"id":37,"name":"商品标题","categoryId":2,"keywords":"商品关键字","model":"2","virtualNum":25,"price":25.45,"marketPrice":12,"integral":5,"stock":15,"warningStock":10,"coverUrl":"封面图","state":1,"showOrder":0,"sellNum":11,"isNew":1,"unit":"12","transId":1,"createBy":11,"createTime":"2019-02-14T02:00:00.000+0000","updateBy":1,"updateTime":"2019-07-02T09:06:24.000+0000","del":0,"isRecommend":0,"isCheck":0,"limitIntegral":2,"subhead":"副标题6666666","remark":"商品描述66666666666","weight":5,"count":45,"sendIntegral":5,"sendGrowth":21,"productPicture":"http://pic34.nipic.com/20131020/6704106_203943375000_2.jpg,http://pic13.nipic.com/20110409/7119492_114440620000_2.jpg,http://pic13.nipic.com/20110409/7119492_114440620000_2.jpg,http://pic13.nipic.com/20110409/7119492_114440620000_2.jpg","storeId":1,"isSift":1,"brandId":2,"mallStore":null,"sellCount":null,"num":null,"basicService":null,"productType":null,"transName":null,"priceType":null,"deliveryType":null,"defaultTransCost":null,"branName":null,"brandImg":null,"brandIsSpecial":null,"brandOrder":null,"brandAddress":null,"attributeId":null,"standardId":null,"userId":null,"collectionNum":null,"standard":null},{"id":44,"name":"商品标题","categoryId":2,"keywords":"商品关键字","model":"1","virtualNum":25,"price":25.45,"marketPrice":12,"integral":5,"stock":15,"warningStock":10,"coverUrl":"封面图","state":1,"showOrder":0,"sellNum":11,"isNew":1,"unit":"12","transId":2,"createBy":11,"createTime":"2019-02-14T02:00:00.000+0000","updateBy":1,"updateTime":"2019-07-02T09:06:42.000+0000","del":0,"isRecommend":0,"isCheck":0,"limitIntegral":2,"subhead":"副标题6666666","remark":"商品描述66666666666","weight":5,"count":45,"sendIntegral":5,"sendGrowth":21,"productPicture":"http://pic34.nipic.com/20131020/6704106_203943375000_2.jpg,http://pic13.nipic.com/20110409/7119492_114440620000_2.jpg,http://pic13.nipic.com/20110409/7119492_114440620000_2.jpg,http://pic13.nipic.com/20110409/7119492_114440620000_2.jpg","storeId":1,"isSift":1,"brandId":2,"mallStore":null,"sellCount":null,"num":null,"basicService":null,"productType":null,"transName":null,"priceType":null,"deliveryType":null,"defaultTransCost":null,"branName":null,"brandImg":null,"brandIsSpecial":null,"brandOrder":null,"brandAddress":null,"attributeId":null,"standardId":null,"userId":null,"collectionNum":null,"standard":null},{"id":46,"name":"商品","categoryId":1,"keywords":"士大夫","model":"1","virtualNum":1,"price":50,"marketPrice":1,"integral":1,"stock":11,"warningStock":11,"coverUrl":"10","state":1,"showOrder":0,"sellNum":0,"isNew":0,"unit":null,"transId":1,"createBy":1,"createTime":"2019-06-19T02:27:00.000+0000","updateBy":1,"updateTime":"2019-07-02T09:06:49.000+0000","del":0,"isRecommend":null,"isCheck":null,"limitIntegral":null,"subhead":null,"remark":null,"weight":null,"count":null,"sendIntegral":null,"sendGrowth":null,"productPicture":"http://pic34.nipic.com/20131020/6704106_203943375000_2.jpg,http://pic13.nipic.com/20110409/7119492_114440620000_2.jpg,http://pic13.nipic.com/20110409/7119492_114440620000_2.jpg,http://pic13.nipic.com/20110409/7119492_114440620000_2.jpg","storeId":1,"isSift":0,"brandId":2,"mallStore":null,"sellCount":null,"num":null,"basicService":null,"productType":null,"transName":null,"priceType":null,"deliveryType":null,"defaultTransCost":null,"branName":null,"brandImg":null,"brandIsSpecial":null,"brandOrder":null,"brandAddress":null,"attributeId":null,"standardId":null,"userId":null,"collectionNum":null,"standard":null}]
             */

            private int id;
            private String name;
            private String isSpecial;
            private String img;
            private String story;
            private String order;
            private String createTime;
            private String updateTime;
            private String address;
            private List<ProductListBean> productList;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getIsSpecial() {
                return isSpecial;
            }

            public void setIsSpecial(String isSpecial) {
                this.isSpecial = isSpecial;
            }

            public String getImg() {
                return img;
            }

            public void setImg(String img) {
                this.img = img;
            }

            public String getStory() {
                return story;
            }

            public void setStory(String story) {
                this.story = story;
            }

            public String getOrder() {
                return order;
            }

            public void setOrder(String order) {
                this.order = order;
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

            public String getAddress() {
                return address;
            }

            public void setAddress(String address) {
                this.address = address;
            }

            public List<ProductListBean> getProductList() {
                return productList;
            }

            public void setProductList(List<ProductListBean> productList) {
                this.productList = productList;
            }

            public static class ProductListBean {
                /**
                 * id : 1
                 * name : 测试
                 * categoryId : 2
                 * keywords : 测试
                 * model : 1
                 * virtualNum : 2
                 * price : 25.0
                 * marketPrice : 42.0
                 * integral : 24
                 * stock : 12
                 * warningStock : 212
                 * coverUrl : http://oss.irving.net.cn/tea/%E5%BE%AE%E4%BF%A1%E5%9B%BE%E7%89%87_20190621162756.jpg
                 * state : 1
                 * showOrder : 12
                 * sellNum : 12
                 * isNew : 1
                 * unit : 1
                 * transId : 1
                 * createBy : 1
                 * createTime : 2019-06-05T08:18:59.000+0000
                 * updateBy : 1
                 * updateTime : 2019-07-11T02:51:05.000+0000
                 * del : 0
                 * isRecommend : 1
                 * isCheck : 1
                 * limitIntegral : 2020.0
                 * subhead : 202
                 * remark : 阿斯顿发失地发生地方
                 * weight : 2.0
                 * count : 2
                 * sendIntegral : 2.0
                 * sendGrowth : 2.0
                 * productPicture : http://pic34.nipic.com/20131020/6704106_203943375000_2.jpg,http://pic13.nipic.com/20110409/7119492_114440620000_2.jpg,http://pic13.nipic.com/20110409/7119492_114440620000_2.jpg,http://pic13.nipic.com/20110409/7119492_114440620000_2.jpg
                 * storeId : 1
                 * isSift : 0
                 * brandId : 1
                 * mallStore : null
                 * sellCount : null
                 * num : null
                 * basicService : null
                 * productType : null
                 * transName : null
                 * priceType : null
                 * deliveryType : null
                 * defaultTransCost : null
                 * branName : null
                 * brandImg : null
                 * brandIsSpecial : null
                 * brandOrder : null
                 * brandAddress : null
                 * attributeId : null
                 * standardId : null
                 * userId : null
                 * collectionNum : null
                 * standard : null
                 */

                private int id;
                private String name;
                private int categoryId;
                private String keywords;
                private String model;
                private int virtualNum;
                private double price;
                private double marketPrice;
                private int integral;
                private int stock;
                private int warningStock;
                private String coverUrl;
                private int state;
                private int showOrder;
                private int sellNum;
                private int isNew;
                private String unit;
                private int transId;
                private int createBy;
                private String createTime;
                private int updateBy;
                private String updateTime;
                private int del;
                private int isRecommend;
                private int isCheck;
                private double limitIntegral;
                private String subhead;
                private String remark;
                private double weight;
                private int count;
                private double sendIntegral;
                private double sendGrowth;
                private String productPicture;
                private int storeId;
                private int isSift;
                private int brandId;
                private Object mallStore;
                private Object sellCount;
                private Object num;
                private Object basicService;
                private Object productType;
                private Object transName;
                private Object priceType;
                private Object deliveryType;
                private Object defaultTransCost;
                private Object branName;
                private Object brandImg;
                private Object brandIsSpecial;
                private Object brandOrder;
                private Object brandAddress;
                private Object attributeId;
                private Object standardId;
                private Object userId;
                private Object collectionNum;
                private Object standard;

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public int getCategoryId() {
                    return categoryId;
                }

                public void setCategoryId(int categoryId) {
                    this.categoryId = categoryId;
                }

                public String getKeywords() {
                    return keywords;
                }

                public void setKeywords(String keywords) {
                    this.keywords = keywords;
                }

                public String getModel() {
                    return model;
                }

                public void setModel(String model) {
                    this.model = model;
                }

                public int getVirtualNum() {
                    return virtualNum;
                }

                public void setVirtualNum(int virtualNum) {
                    this.virtualNum = virtualNum;
                }

                public double getPrice() {
                    return price;
                }

                public void setPrice(double price) {
                    this.price = price;
                }

                public double getMarketPrice() {
                    return marketPrice;
                }

                public void setMarketPrice(double marketPrice) {
                    this.marketPrice = marketPrice;
                }

                public int getIntegral() {
                    return integral;
                }

                public void setIntegral(int integral) {
                    this.integral = integral;
                }

                public int getStock() {
                    return stock;
                }

                public void setStock(int stock) {
                    this.stock = stock;
                }

                public int getWarningStock() {
                    return warningStock;
                }

                public void setWarningStock(int warningStock) {
                    this.warningStock = warningStock;
                }

                public String getCoverUrl() {
                    return coverUrl;
                }

                public void setCoverUrl(String coverUrl) {
                    this.coverUrl = coverUrl;
                }

                public int getState() {
                    return state;
                }

                public void setState(int state) {
                    this.state = state;
                }

                public int getShowOrder() {
                    return showOrder;
                }

                public void setShowOrder(int showOrder) {
                    this.showOrder = showOrder;
                }

                public int getSellNum() {
                    return sellNum;
                }

                public void setSellNum(int sellNum) {
                    this.sellNum = sellNum;
                }

                public int getIsNew() {
                    return isNew;
                }

                public void setIsNew(int isNew) {
                    this.isNew = isNew;
                }

                public String getUnit() {
                    return unit;
                }

                public void setUnit(String unit) {
                    this.unit = unit;
                }

                public int getTransId() {
                    return transId;
                }

                public void setTransId(int transId) {
                    this.transId = transId;
                }

                public int getCreateBy() {
                    return createBy;
                }

                public void setCreateBy(int createBy) {
                    this.createBy = createBy;
                }

                public String getCreateTime() {
                    return createTime;
                }

                public void setCreateTime(String createTime) {
                    this.createTime = createTime;
                }

                public int getUpdateBy() {
                    return updateBy;
                }

                public void setUpdateBy(int updateBy) {
                    this.updateBy = updateBy;
                }

                public String getUpdateTime() {
                    return updateTime;
                }

                public void setUpdateTime(String updateTime) {
                    this.updateTime = updateTime;
                }

                public int getDel() {
                    return del;
                }

                public void setDel(int del) {
                    this.del = del;
                }

                public int getIsRecommend() {
                    return isRecommend;
                }

                public void setIsRecommend(int isRecommend) {
                    this.isRecommend = isRecommend;
                }

                public int getIsCheck() {
                    return isCheck;
                }

                public void setIsCheck(int isCheck) {
                    this.isCheck = isCheck;
                }

                public double getLimitIntegral() {
                    return limitIntegral;
                }

                public void setLimitIntegral(double limitIntegral) {
                    this.limitIntegral = limitIntegral;
                }

                public String getSubhead() {
                    return subhead;
                }

                public void setSubhead(String subhead) {
                    this.subhead = subhead;
                }

                public String getRemark() {
                    return remark;
                }

                public void setRemark(String remark) {
                    this.remark = remark;
                }

                public double getWeight() {
                    return weight;
                }

                public void setWeight(double weight) {
                    this.weight = weight;
                }

                public int getCount() {
                    return count;
                }

                public void setCount(int count) {
                    this.count = count;
                }

                public double getSendIntegral() {
                    return sendIntegral;
                }

                public void setSendIntegral(double sendIntegral) {
                    this.sendIntegral = sendIntegral;
                }

                public double getSendGrowth() {
                    return sendGrowth;
                }

                public void setSendGrowth(double sendGrowth) {
                    this.sendGrowth = sendGrowth;
                }

                public String getProductPicture() {
                    return productPicture;
                }

                public void setProductPicture(String productPicture) {
                    this.productPicture = productPicture;
                }

                public int getStoreId() {
                    return storeId;
                }

                public void setStoreId(int storeId) {
                    this.storeId = storeId;
                }

                public int getIsSift() {
                    return isSift;
                }

                public void setIsSift(int isSift) {
                    this.isSift = isSift;
                }

                public int getBrandId() {
                    return brandId;
                }

                public void setBrandId(int brandId) {
                    this.brandId = brandId;
                }

                public Object getMallStore() {
                    return mallStore;
                }

                public void setMallStore(Object mallStore) {
                    this.mallStore = mallStore;
                }

                public Object getSellCount() {
                    return sellCount;
                }

                public void setSellCount(Object sellCount) {
                    this.sellCount = sellCount;
                }

                public Object getNum() {
                    return num;
                }

                public void setNum(Object num) {
                    this.num = num;
                }

                public Object getBasicService() {
                    return basicService;
                }

                public void setBasicService(Object basicService) {
                    this.basicService = basicService;
                }

                public Object getProductType() {
                    return productType;
                }

                public void setProductType(Object productType) {
                    this.productType = productType;
                }

                public Object getTransName() {
                    return transName;
                }

                public void setTransName(Object transName) {
                    this.transName = transName;
                }

                public Object getPriceType() {
                    return priceType;
                }

                public void setPriceType(Object priceType) {
                    this.priceType = priceType;
                }

                public Object getDeliveryType() {
                    return deliveryType;
                }

                public void setDeliveryType(Object deliveryType) {
                    this.deliveryType = deliveryType;
                }

                public Object getDefaultTransCost() {
                    return defaultTransCost;
                }

                public void setDefaultTransCost(Object defaultTransCost) {
                    this.defaultTransCost = defaultTransCost;
                }

                public Object getBranName() {
                    return branName;
                }

                public void setBranName(Object branName) {
                    this.branName = branName;
                }

                public Object getBrandImg() {
                    return brandImg;
                }

                public void setBrandImg(Object brandImg) {
                    this.brandImg = brandImg;
                }

                public Object getBrandIsSpecial() {
                    return brandIsSpecial;
                }

                public void setBrandIsSpecial(Object brandIsSpecial) {
                    this.brandIsSpecial = brandIsSpecial;
                }

                public Object getBrandOrder() {
                    return brandOrder;
                }

                public void setBrandOrder(Object brandOrder) {
                    this.brandOrder = brandOrder;
                }

                public Object getBrandAddress() {
                    return brandAddress;
                }

                public void setBrandAddress(Object brandAddress) {
                    this.brandAddress = brandAddress;
                }

                public Object getAttributeId() {
                    return attributeId;
                }

                public void setAttributeId(Object attributeId) {
                    this.attributeId = attributeId;
                }

                public Object getStandardId() {
                    return standardId;
                }

                public void setStandardId(Object standardId) {
                    this.standardId = standardId;
                }

                public Object getUserId() {
                    return userId;
                }

                public void setUserId(Object userId) {
                    this.userId = userId;
                }

                public Object getCollectionNum() {
                    return collectionNum;
                }

                public void setCollectionNum(Object collectionNum) {
                    this.collectionNum = collectionNum;
                }

                public Object getStandard() {
                    return standard;
                }

                public void setStandard(Object standard) {
                    this.standard = standard;
                }
            }
        }
    }
}
