package com.huohougongfu.app.Gson;

import java.util.List;

public class ChaTaiGson {

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

        private boolean isSelect;
        private int id;
        private Object equipmentId;
        private int teaId;
        private int hasDust;
        private String concentration;
        private int num;
        private TeaBean tea;
        private String createTime;
        private String updateTime;
        private int mid;

        public boolean getIsSelect() {
            return isSelect;
        }

        public void setIsSelect(boolean isSelect) {
            this.isSelect = isSelect;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public Object getEquipmentId() {
            return equipmentId;
        }

        public void setEquipmentId(Object equipmentId) {
            this.equipmentId = equipmentId;
        }

        public int getTeaId() {
            return teaId;
        }

        public void setTeaId(int teaId) {
            this.teaId = teaId;
        }

        public int getHasDust() {
            return hasDust;
        }

        public void setHasDust(int hasDust) {
            this.hasDust = hasDust;
        }

        public String getConcentration() {
            return concentration;
        }

        public void setConcentration(String concentration) {
            this.concentration = concentration;
        }

        public int getNum() {
            return num;
        }

        public void setNum(int num) {
            this.num = num;
        }

        public TeaBean getTea() {
            return tea;
        }

        public void setTea(TeaBean tea) {
            this.tea = tea;
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

        public int getMid() {
            return mid;
        }

        public void setMid(int mid) {
            this.mid = mid;
        }

        public static class TeaBean {

            private Object id;
            private String teaName;
            private Object upperDeviation;
            private Object lowerDeviation;
            private Object makeTeaTime;
            private Object light;
            private Object normal;
            private Object strong;
            private double price;
            private Object picture;
            private Object efficacy;
            private Object createTime;
            private Object updateTime;

            public Object getId() {
                return id;
            }

            public void setId(Object id) {
                this.id = id;
            }

            public String getTeaName() {
                return teaName;
            }

            public void setTeaName(String teaName) {
                this.teaName = teaName;
            }

            public Object getUpperDeviation() {
                return upperDeviation;
            }

            public void setUpperDeviation(Object upperDeviation) {
                this.upperDeviation = upperDeviation;
            }

            public Object getLowerDeviation() {
                return lowerDeviation;
            }

            public void setLowerDeviation(Object lowerDeviation) {
                this.lowerDeviation = lowerDeviation;
            }

            public Object getMakeTeaTime() {
                return makeTeaTime;
            }

            public void setMakeTeaTime(Object makeTeaTime) {
                this.makeTeaTime = makeTeaTime;
            }

            public Object getLight() {
                return light;
            }

            public void setLight(Object light) {
                this.light = light;
            }

            public Object getNormal() {
                return normal;
            }

            public void setNormal(Object normal) {
                this.normal = normal;
            }

            public Object getStrong() {
                return strong;
            }

            public void setStrong(Object strong) {
                this.strong = strong;
            }

            public double getPrice() {
                return price;
            }

            public void setPrice(double price) {
                this.price = price;
            }

            public Object getPicture() {
                return picture;
            }

            public void setPicture(Object picture) {
                this.picture = picture;
            }

            public Object getEfficacy() {
                return efficacy;
            }

            public void setEfficacy(Object efficacy) {
                this.efficacy = efficacy;
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
        }
    }
}
