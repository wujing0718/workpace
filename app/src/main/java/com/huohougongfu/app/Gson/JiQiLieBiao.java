package com.huohougongfu.app.Gson;

import java.io.Serializable;
import java.util.List;

public class JiQiLieBiao implements Serializable{

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

            private String equipmentId;
            private String detailAddress;
            private double latitude;
            private double longitude;
            private Object altitude;
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
            private String port;
            private int glass;
            private int cupCover;
            private int internalBladder;
            private int water;
            private int surplus;
            private int oneLower;
            private int twoLower;
            private int threeLower;
            private int fourLower;
            private int fiveLower;
            private int sixLower;
            private int sevenLower;
            private int eightLower;
            private int status;
            private double distance;
            private String unit;

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

            public Object getAltitude() {
                return altitude;
            }

            public void setAltitude(Object altitude) {
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

            public String getPort() {
                return port;
            }

            public void setPort(String port) {
                this.port = port;
            }

            public int getGlass() {
                return glass;
            }

            public void setGlass(int glass) {
                this.glass = glass;
            }

            public int getCupCover() {
                return cupCover;
            }

            public void setCupCover(int cupCover) {
                this.cupCover = cupCover;
            }

            public int getInternalBladder() {
                return internalBladder;
            }

            public void setInternalBladder(int internalBladder) {
                this.internalBladder = internalBladder;
            }

            public int getWater() {
                return water;
            }

            public void setWater(int water) {
                this.water = water;
            }

            public int getSurplus() {
                return surplus;
            }

            public void setSurplus(int surplus) {
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

            public int getStatus() {
                return status;
            }

            public void setStatus(int status) {
                this.status = status;
            }

            public double getDistance() {
                return distance;
            }

            public void setDistance(double distance) {
                this.distance = distance;
            }

            public String getUnit() {
                return unit;
            }

            public void setUnit(String unit) {
                this.unit = unit;
            }
        }
    }
}
