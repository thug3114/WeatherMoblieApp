package com.uit.finalproject.model;

public class ObjectAttributes {
    private SunIrradiance sunIrradiance;
    private Rainfall rainfall;
    private Notes notes;
    private UVIndex uVIndex;
    private SunAzimuth sunAzimuth;
    private SunZenith sunZenith;
    private Temperature temperature;
    private Humidity humidity;
    private WeatherData weatherData;
    private Location location;
    private WindDirection windDirection;
    private WindSpeed windSpeed;
    private SunAltitude sunAltitude;

    public SunIrradiance getSunIrradiance() {
        return sunIrradiance;
    }

    public void setSunIrradiance(SunIrradiance sunIrradiance) {
        this.sunIrradiance = sunIrradiance;
    }

    public Rainfall getRainfall() {
        return rainfall;
    }

    public void setRainfall(Rainfall rainfall) {
        this.rainfall = rainfall;
    }

    public Notes getNotes() {
        return notes;
    }

    public void setNotes(Notes notes) {
        this.notes = notes;
    }

    public UVIndex getuVIndex() {
        return uVIndex;
    }

    public void setuVIndex(UVIndex uVIndex) {
        this.uVIndex = uVIndex;
    }

    public SunAzimuth getSunAzimuth() {
        return sunAzimuth;
    }

    public void setSunAzimuth(SunAzimuth sunAzimuth) {
        this.sunAzimuth = sunAzimuth;
    }

    public SunZenith getSunZenith() {
        return sunZenith;
    }

    public void setSunZenith(SunZenith sunZenith) {
        this.sunZenith = sunZenith;
    }

    public Temperature getTemperature() {
        return temperature;
    }

    public void setTemperature(Temperature temperature) {
        this.temperature = temperature;
    }

    public Humidity getHumidity() {
        return humidity;
    }

    public void setHumidity(Humidity humidity) {
        this.humidity = humidity;
    }

    public WeatherData getWeatherData() {
        return weatherData;
    }

    public void setWeatherData(WeatherData weatherData) {
        this.weatherData = weatherData;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public WindDirection getWindDirection() {
        return windDirection;
    }

    public void setWindDirection(WindDirection windDirection) {
        this.windDirection = windDirection;
    }

    public WindSpeed getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(WindSpeed windSpeed) {
        this.windSpeed = windSpeed;
    }

    public SunAltitude getSunAltitude() {
        return sunAltitude;
    }

    public void setSunAltitude(SunAltitude sunAltitude) {
        this.sunAltitude = sunAltitude;
    }

    @Override
    public String toString() {
        return "ObjectAttributes{" +
                "sunIrradiance=" + sunIrradiance +
                ", rainfall=" + rainfall +
                ", notes=" + notes +
                ", uVIndex=" + uVIndex +
                ", sunAzimuth=" + sunAzimuth +
                ", sunZenith=" + sunZenith +
                ", temperature=" + temperature +
                ", humidity=" + humidity +
                ", weatherData=" + weatherData +
                ", location=" + location +
                ", windDirection=" + windDirection +
                ", windSpeed=" + windSpeed +
                ", sunAltitude=" + sunAltitude +
                '}';
    }
}
