package com.uit.finalproject.model;

import java.util.Arrays;

public class ValueWD {
    private Integer dt;
    private Integer id;
    private Integer cod;
    private Sys sys;
    private String base;
    private Main main;
    private String name;
    private Wind wind;
    private Coord coord;
    private Clouds clouds;
    private Object[] weather;
    private Integer timezone;
    private Integer visibility;

    public Integer getDt() {
        return dt;
    }

    public void setDt(Integer dt) {
        this.dt = dt;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCod() {
        return cod;
    }

    public void setCod(Integer cod) {
        this.cod = cod;
    }

    public Sys getSys() {
        return sys;
    }

    public void setSys(Sys sys) {
        this.sys = sys;
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public Main getMain() {
        return main;
    }

    public void setMain(Main main) {
        this.main = main;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Wind getWind() {
        return wind;
    }

    public void setWind(Wind wind) {
        this.wind = wind;
    }

    public Coord getCoord() {
        return coord;
    }

    public void setCoord(Coord coord) {
        this.coord = coord;
    }

    public Clouds getClouds() {
        return clouds;
    }

    public void setClouds(Clouds clouds) {
        this.clouds = clouds;
    }

    public Object[] getWeather() {
        return weather;
    }

    public void setWeather(Object[] weather) {
        this.weather = weather;
    }

    public Integer getTimezone() {
        return timezone;
    }

    public void setTimezone(Integer timezone) {
        this.timezone = timezone;
    }

    public Integer getVisibility() {
        return visibility;
    }

    public void setVisibility(Integer visibility) {
        this.visibility = visibility;
    }

    @Override
    public String toString() {
        return "ValueWD{" +
                "dt=" + dt +
                ", id=" + id +
                ", cod=" + cod +
                ", sys=" + sys +
                ", base='" + base + '\'' +
                ", main=" + main +
                ", name='" + name + '\'' +
                ", wind=" + wind +
                ", coord=" + coord +
                ", clouds=" + clouds +
                ", weather=" + Arrays.toString(weather) +
                ", timezone=" + timezone +
                ", visibility=" + visibility +
                '}';
    }
}
