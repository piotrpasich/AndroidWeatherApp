package com.example.weather2;

public class WeatherLog {
    private String place;
    private String dateTime;
    private Double maxTemp;
    private Double minTemp;
    private Double humidity;
    private Double windSpeed;
    private Integer pressure;
    private Double rain;

    public WeatherLog(String place, String dateTime, Double maxTemp, Double minTemp, Double humidity, Double windSpeed, Integer pressure, Double rain) {
        this.place = place;
        this.dateTime = dateTime;
        this.maxTemp = maxTemp;
        this.minTemp = minTemp;
        this.humidity = humidity;
        this.windSpeed = windSpeed;
        this.pressure = pressure;
        this.rain = rain;
    }

    public String getPlace() {
        return place;
    }

    public String getDateTime() {
        return dateTime;
    }

    public Double getMaxTemp() {
        return maxTemp;
    }

    public Double getMinTemp() {
        return minTemp;
    }

    public Double getHumidity() {
        return humidity;
    }

    public Double getWindSpeed() {
        return windSpeed;
    }

    public Integer getPressure() {
        return pressure;
    }

    public Double getRain() {
        return rain;
    }
}
