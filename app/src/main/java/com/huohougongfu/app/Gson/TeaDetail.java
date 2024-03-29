package com.huohougongfu.app.Gson;

import java.io.Serializable;

public class TeaDetail implements Serializable {

    /**
     * teaName : 凤凰单枞
     * price : 0.01
     * introduce : 相关介绍
     * teaId : 1
     * concentration : {"teaWeight":"14","waterWeight":"300","temperature":"96"}
     * picture : http://oss.hotkungfu-tea.com/picture/1568945382910.png
     * efficacy : 提神益思；消脂去腻；降低血脂
     */

    private String teaName;
    private String price;
    private String introduce;
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

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
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

    public static class ConcentrationBean implements Serializable{
        /**
         * teaWeight : 14
         * waterWeight : 300
         * temperature : 96
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
