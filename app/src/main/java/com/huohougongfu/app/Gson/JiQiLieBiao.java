package com.huohougongfu.app.Gson;

import java.io.Serializable;
import java.util.List;

public class JiQiLieBiao implements Serializable{

    /**
     * msg : 操作成功
     * result : [{"equipmentId":"A0001","detailAddress":"龙祥大厦","latitude":22.7251675577,"longitude":114.262919426,"altitude":1212,"lastGoodsTime":null,"isAbnormal":0,"positionOne":"2","positionTwo":"","positionThree":"3","positionFour":"4","positionFive":"5","positionSix":"6","positionSeven":"7","positionEight":"8","errorCode":null,"ip":"192.168.31.1","port":null,"glass":null,"cupCover":null,"internalBladder":null,"water":null,"surplus":null,"oneLower":0,"twoLower":0,"threeLower":0,"fourLower":0,"fiveLower":0,"sixLower":0,"sevenLower":0,"eightLower":0,"status":null,"createTime":"2019-07-17T06:58:31.000+0000","updateTime":"2019-07-22T03:17:44.000+0000","distance":110.9},{"equipmentId":"A0002","detailAddress":"南联地铁站","latitude":22.7220601972,"longitude":114.2662024498,"altitude":null,"lastGoodsTime":null,"isAbnormal":0,"positionOne":"1","positionTwo":"2","positionThree":"1","positionFour":"1","positionFive":"1","positionSix":"1","positionSeven":"1","positionEight":"1","errorCode":null,"ip":"127.0.0.1","port":null,"glass":null,"cupCover":null,"internalBladder":null,"water":null,"surplus":null,"oneLower":0,"twoLower":0,"threeLower":0,"fourLower":0,"fiveLower":0,"sixLower":0,"sevenLower":0,"eightLower":0,"status":null,"createTime":"2019-07-17T02:10:06.000+0000","updateTime":"2019-07-21T06:58:15.000+0000","distance":578.7}]
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

    public static class ResultBean implements Serializable{
        /**
         * equipmentId : A0001
         * detailAddress : 龙祥大厦
         * latitude : 22.7251675577
         * longitude : 114.262919426
         * altitude : 1212.0
         * lastGoodsTime : null
         * isAbnormal : 0
         * positionOne : 2
         * positionTwo :
         * positionThree : 3
         * positionFour : 4
         * positionFive : 5
         * positionSix : 6
         * positionSeven : 7
         * positionEight : 8
         * errorCode : null
         * ip : 192.168.31.1
         * port : null
         * glass : null
         * cupCover : null
         * internalBladder : null
         * water : null
         * surplus : null
         * oneLower : 0
         * twoLower : 0
         * threeLower : 0
         * fourLower : 0
         * fiveLower : 0
         * sixLower : 0
         * sevenLower : 0
         * eightLower : 0
         * status : null
         * createTime : 2019-07-17T06:58:31.000+0000
         * updateTime : 2019-07-22T03:17:44.000+0000
         * distance : 110.9
         */

        private String equipmentId;
        private String detailAddress;
        private double latitude;
        private double longitude;
        private double altitude;
        private Object lastGoodsTime;
        private int isAbnormal;
        private String positionOne;
        private String positionTwo;
        private String positionThree;
        private String positionFour;
        private String positionFive;
        private String positionSix;
        private String positionSeven;
        private String positionEight;
        private Object errorCode;
        private String ip;
        private Object port;
        private Object glass;
        private Object cupCover;
        private Object internalBladder;
        private Object water;
        private Object surplus;
        private int oneLower;
        private int twoLower;
        private int threeLower;
        private int fourLower;
        private int fiveLower;
        private int sixLower;
        private int sevenLower;
        private int eightLower;
        private Object status;
        private String createTime;
        private String updateTime;
        private double distance;

        public String getEquipmentId() {
            return equipmentId;
        }

        public void setEquipmentId(String equipmentId) {
            this.equipmentId = equipmentId;
        }

        public String getDetailAddress() {
            return detailAddress;
        }

        public void setDetailAddress(String detailAddress) {
            this.detailAddress = detailAddress;
        }

        public double getLatitude() {
            return latitude;
        }

        public void setLatitude(double latitude) {
            this.latitude = latitude;
        }

        public double getLongitude() {
            return longitude;
        }

        public void setLongitude(double longitude) {
            this.longitude = longitude;
        }

        public double getAltitude() {
            return altitude;
        }

        public void setAltitude(double altitude) {
            this.altitude = altitude;
        }

        public Object getLastGoodsTime() {
            return lastGoodsTime;
        }

        public void setLastGoodsTime(Object lastGoodsTime) {
            this.lastGoodsTime = lastGoodsTime;
        }

        public int getIsAbnormal() {
            return isAbnormal;
        }

        public void setIsAbnormal(int isAbnormal) {
            this.isAbnormal = isAbnormal;
        }

        public String getPositionOne() {
            return positionOne;
        }

        public void setPositionOne(String positionOne) {
            this.positionOne = positionOne;
        }

        public String getPositionTwo() {
            return positionTwo;
        }

        public void setPositionTwo(String positionTwo) {
            this.positionTwo = positionTwo;
        }

        public String getPositionThree() {
            return positionThree;
        }

        public void setPositionThree(String positionThree) {
            this.positionThree = positionThree;
        }

        public String getPositionFour() {
            return positionFour;
        }

        public void setPositionFour(String positionFour) {
            this.positionFour = positionFour;
        }

        public String getPositionFive() {
            return positionFive;
        }

        public void setPositionFive(String positionFive) {
            this.positionFive = positionFive;
        }

        public String getPositionSix() {
            return positionSix;
        }

        public void setPositionSix(String positionSix) {
            this.positionSix = positionSix;
        }

        public String getPositionSeven() {
            return positionSeven;
        }

        public void setPositionSeven(String positionSeven) {
            this.positionSeven = positionSeven;
        }

        public String getPositionEight() {
            return positionEight;
        }

        public void setPositionEight(String positionEight) {
            this.positionEight = positionEight;
        }

        public Object getErrorCode() {
            return errorCode;
        }

        public void setErrorCode(Object errorCode) {
            this.errorCode = errorCode;
        }

        public String getIp() {
            return ip;
        }

        public void setIp(String ip) {
            this.ip = ip;
        }

        public Object getPort() {
            return port;
        }

        public void setPort(Object port) {
            this.port = port;
        }

        public Object getGlass() {
            return glass;
        }

        public void setGlass(Object glass) {
            this.glass = glass;
        }

        public Object getCupCover() {
            return cupCover;
        }

        public void setCupCover(Object cupCover) {
            this.cupCover = cupCover;
        }

        public Object getInternalBladder() {
            return internalBladder;
        }

        public void setInternalBladder(Object internalBladder) {
            this.internalBladder = internalBladder;
        }

        public Object getWater() {
            return water;
        }

        public void setWater(Object water) {
            this.water = water;
        }

        public Object getSurplus() {
            return surplus;
        }

        public void setSurplus(Object surplus) {
            this.surplus = surplus;
        }

        public int getOneLower() {
            return oneLower;
        }

        public void setOneLower(int oneLower) {
            this.oneLower = oneLower;
        }

        public int getTwoLower() {
            return twoLower;
        }

        public void setTwoLower(int twoLower) {
            this.twoLower = twoLower;
        }

        public int getThreeLower() {
            return threeLower;
        }

        public void setThreeLower(int threeLower) {
            this.threeLower = threeLower;
        }

        public int getFourLower() {
            return fourLower;
        }

        public void setFourLower(int fourLower) {
            this.fourLower = fourLower;
        }

        public int getFiveLower() {
            return fiveLower;
        }

        public void setFiveLower(int fiveLower) {
            this.fiveLower = fiveLower;
        }

        public int getSixLower() {
            return sixLower;
        }

        public void setSixLower(int sixLower) {
            this.sixLower = sixLower;
        }

        public int getSevenLower() {
            return sevenLower;
        }

        public void setSevenLower(int sevenLower) {
            this.sevenLower = sevenLower;
        }

        public int getEightLower() {
            return eightLower;
        }

        public void setEightLower(int eightLower) {
            this.eightLower = eightLower;
        }

        public Object getStatus() {
            return status;
        }

        public void setStatus(Object status) {
            this.status = status;
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

        public double getDistance() {
            return distance;
        }

        public void setDistance(double distance) {
            this.distance = distance;
        }
    }
}
