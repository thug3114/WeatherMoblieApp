package com.uit.finalproject.model;

public class Wind {
    private Integer deg;
    private Double gust;
    private Double speed;

    public Integer getDeg() {
        return deg;
    }

    public void setDeg(Integer deg) {
        this.deg = deg;
    }

    public Double getGust() {
        return gust;
    }

    public void setGust(Double gust) {
        this.gust = gust;
    }

    public Double getSpeed() {
        return speed;
    }

    public void setSpeed(Double speed) {
        this.speed = speed;
    }

    @Override
    public String toString() {
        return "Wind{" +
                "deg=" + deg +
                ", gust=" + gust +
                ", speed=" + speed +
                '}';
    }
}
