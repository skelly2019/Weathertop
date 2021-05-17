package controllers;

import models.Reading;
import models.Station;
import play.Logger;
import play.mvc.Controller;
import utils.StationAnalytics;

public class StationCtrl extends Controller
{
    public static void index(Long id)
    {
        Station station = Station.findById(id);
        Logger.info ("Station id = " + id);
        String latestWeather = StationAnalytics.getlatestWeather(station.readings);
        Float latestCelsius = StationAnalytics.getlatestCelsius(station.readings);
        Float latestFahrenheit = StationAnalytics.getlatestFahrenheit(station.readings);
        Float latestwindSpeed = StationAnalytics.getlatestwindSpeed(station.readings);
        Float latestpressure = StationAnalytics.getlatestpressure(station.readings);
        String latestwindCompass = StationAnalytics.getlatestwindCompass(station.readings);
        Integer latestwindChill = StationAnalytics.getlatestwindChill(station.readings);
        Float maxCelcius = StationAnalytics.getmaxCelcius(station.readings);
        Float minCelcius = StationAnalytics.getminCelcius(station.readings);
        Float maxWind = StationAnalytics.getmaxWind(station.readings);
        Float minWind = StationAnalytics.getminWind(station.readings);
        Float minPressure = StationAnalytics.getminPressure(station.readings);
        Float maxPressure = StationAnalytics.getmaxPressure(station.readings);
        String latestIcon = StationAnalytics.getlatesticon(station.readings);
        render("station.html", station, latestWeather, latestCelsius, latestFahrenheit,
                latestwindSpeed, latestpressure, latestwindCompass, latestwindChill, maxCelcius,
                minCelcius, maxWind, minWind, minPressure, maxPressure, latestIcon);
    }

    public static void deletereading (Long id, Long readingid)
    {
        Station station = Station.findById(id);
        Reading reading = Reading.findById(readingid);
        Logger.info ("Removing" + reading.code);
        station.readings.remove(reading);
        station.save();
        reading.delete();
        redirect ("/stations/" + id);
    }

    public static void addReading(Long id, int code, float temperature, float windSpeed, int windDirection, int pressure)
    {
        Reading reading = new Reading(code, temperature, windSpeed, windDirection,pressure);
        Station station = Station.findById(id);
        station.readings.add(reading);
        station.save();
        redirect ("/stations/" + id);
    }
}
