package com.uit.finalproject.model;

public class Sys {
    private Integer id;
    private Integer type;
    private Integer sunset;
    public String country;
    private Integer sunrise;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getSunset() {
        return sunset;
    }

    public void setSunset(Integer sunset) {
        this.sunset = sunset;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Integer getSunrise() {
        return sunrise;
    }

    public void setSunrise(Integer sunrise) {
        this.sunrise = sunrise;
    }

    @Override
    public String toString() {
        return "Sys{" +
                "id=" + id +
                ", type=" + type +
                ", sunset=" + sunset +
                ", country='" + country + '\'' +
                ", sunrise=" + sunrise +
                '}';
    }
}
