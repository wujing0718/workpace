package com.huohougongfu.app.Gson;

public class TeaDetail {
    /**
     * teaName : 绿茶
     * price : 12.00
     * teaId : 2
     * concentration : {"teaWeight":"5","waterWeight":"200","temperature":"80"}
     * picture : http://oss.irving.net.cn/tea/101561088827_.pic_hd.jpg
     * efficacy : 功效
     */

    private String teaName;
    private String price;
    private String teaId;
    private ConcentrationBean concentration;
    private String picture;
    private String efficacy;

    public String getTeaName() {
        return teaName;
    }

    public void setTeaName(String teaName) {
        this.teaName = teaName;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getTeaId() {
        return teaId;
    }

    public void setTeaId(String teaId) {
        this.teaId = teaId;
    }

    public ConcentrationBean getConcentration() {
        return concentration;
    }

    public void setConcentration(ConcentrationBean concentration) {
        this.concentration = concentration;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getEfficacy() {
        return efficacy;
    }

    public void setEfficacy(String efficacy) {
        this.efficacy = efficacy;
    }

    public static class ConcentrationBean {
        /**
         * teaWeight : 5
         * waterWeight : 200
         * temperature : 80
         */

        private String teaWeight;
        private String waterWeight;
        private String temperature;

        public String getTeaWeight() {
            return teaWeight;
        }

        public void setTeaWeight(String teaWeight) {
            this.teaWeight = teaWeight;
        }

        public String getWaterWeight() {
            return waterWeight;
        }

        public void setWaterWeight(String waterWeight) {
            this.waterWeight = waterWeight;
        }

        public String getTemperature() {
            return temperature;
        }

        public void setTemperature(String temperature) {
            this.temperature = temperature;
        }
    }
}
