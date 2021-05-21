package utils;

import models.Reading;

import java.util.List;


public class StationAnalytics {

    public static String getlatestWeather(List<Reading> readings) {
        if (readings.size() != 0) {
            Reading latestWeather = readings.get(readings.size() - 1);

            if (latestWeather.code == 100) {
                return "Clear";
            }
            if (latestWeather.code == 200) {
                return "Partial clouds";
            }
            if (latestWeather.code == 300) {
                return "Cloudy";
            }
            if (latestWeather.code == 400) {
                return "Light Showers";
            }
            if (latestWeather.code == 500) {
                return "Heavy Showers";
            }
            if (latestWeather.code == 600) {
                return "Rain";
            }
            if (latestWeather.code == 700) {
                return "Snow";
            } else return "Thunder";
        }
        return null;
    }


    public static float getlatestCelsius(List<Reading> readings) {
        if (readings.size() != 0) {
            Reading latestCelsius = readings.get(readings.size() - 1);

            float temperature = latestCelsius.temperature;
            return temperature;

        }
        return 0;
    }

    public static float getlatestFahrenheit(List<Reading> readings) {
        if (readings.size() != 0) {
            Reading latestFahrenheit = readings.get(readings.size() - 1);

            float Fahrenheit = latestFahrenheit.temperature;
            return Fahrenheit * 9 / 5 + 32;
        }
        return 0;
    }

    public static float getlatestwindSpeed(List<Reading> readings) {
        if (readings.size() != 0) {
            Reading latestwindSpeed = readings.get(readings.size() - 1);

            float WindSpeed = latestwindSpeed.windSpeed;
            return WindSpeed;
        }
        return 0;
    }

    public static float getlatestpressure(List<Reading> readings) {
        if (readings.size() != 0) {
            Reading latestpressure = readings.get(readings.size() - 1);

            float Pressure = latestpressure.pressure;
            return Pressure;
        }
        return 0;
    }

    public static String getlatestwindCompass(List<Reading> readings) {
        if (readings.size() != 0) {
            Reading latestwindCompass = readings.get(readings.size() - 1);

            if (348.75 < latestwindCompass.windDirection && latestwindCompass.windDirection < 11.25) {
                return "North";
            }
            if (11.25 < latestwindCompass.windDirection && latestwindCompass.windDirection < 33.75) {
                return "North-Northeast";
            }
            if (33.75 < latestwindCompass.windDirection && latestwindCompass.windDirection < 56.25) {
                return "Northeast";
            }
            if (56.25 < latestwindCompass.windDirection && latestwindCompass.windDirection < 78.25) {
                return "East-Northeast";
            }
            if (78.25 < latestwindCompass.windDirection && latestwindCompass.windDirection < 101.25) {
                return "East";
            }
            if (101.25 < latestwindCompass.windDirection && latestwindCompass.windDirection < 123.75) {
                return "East-Southeast";
            }
            if (123.75 < latestwindCompass.windDirection && latestwindCompass.windDirection < 146.25) {
                return "Southeast";
            }
            if (146.25 < latestwindCompass.windDirection && latestwindCompass.windDirection < 168.75) {
                return "South-Southeast";
            }
            if (168.75 < latestwindCompass.windDirection && latestwindCompass.windDirection < 191.25) {
                return "South";
            }
            if (191.25 < latestwindCompass.windDirection && latestwindCompass.windDirection < 213.75) {
                return "South-Southwest";
            }
            if (213.75 < latestwindCompass.windDirection && latestwindCompass.windDirection < 236.25) {
                return "Southwest";
            }
            if (236.25 < latestwindCompass.windDirection && latestwindCompass.windDirection < 258.75) {
                return "West-Southwest";
            }
            if (258.75 < latestwindCompass.windDirection && latestwindCompass.windDirection < 281.25) {
                return "West";
            }
            if (281.25 < latestwindCompass.windDirection && latestwindCompass.windDirection < 303.75) {
                return "West-Northwest";
            }
            if (303.75 < latestwindCompass.windDirection && latestwindCompass.windDirection < 326.25) {
                return "Northwest";
            }
            if (326.25 < latestwindCompass.windDirection && latestwindCompass.windDirection < 348.75) {
                return "North-Northwest";
            } else return "North";
        }
        return null;
    }

    public static int getlatestwindChill(List<Reading> readings) {
        if (readings.size() != 0) {
            Reading latestwindChill = readings.get(readings.size() - 1);

            int V = latestwindChill.windDirection;
            float T = latestwindChill.temperature;
            final int i = (int) (13.12 + (0.6215 * T) - 11.37 * (Math.pow(V, 0.16)) + (0.39 * T) * (Math.pow(V, 0.16)));
            return i;
        }
        return 0;
    }

    public static float getmaxCelcius(List<Reading> readings) {
        Reading maxCelcius = null;
        if (readings.size() > 0) {
            maxCelcius = readings.get(0);
            for (Reading reading : readings) {
                if (reading.temperature > maxCelcius.temperature) {
                    maxCelcius = reading;
                }
            }
            return maxCelcius.temperature;
        } else {
            return 0;
        }
    }

    public static float getminCelcius(List<Reading> readings) {
        Reading minCelcius = null;
        if (readings.size() > 0) {
            minCelcius = readings.get(0);
            for (Reading reading : readings) {
                if (reading.temperature < minCelcius.temperature) {
                    minCelcius = reading;
                }
            }
            return minCelcius.temperature;
        } else {
            return 0;
        }
    }

    public static float getmaxWind(List<Reading> readings) {
        Reading maxWind = null;
        if (readings.size() > 0) {
            maxWind = readings.get(0);
            for (Reading reading : readings) {
                if (reading.windSpeed > maxWind.windSpeed) {
                    maxWind = reading;
                }
            }
            return maxWind.windSpeed;
        } else {
            return 0;
        }
    }

    public static float getminWind(List<Reading> readings) {
        Reading minWind = null;
        if (readings.size() > 0) {
            minWind = readings.get(0);
            for (Reading reading : readings) {
                if (reading.windSpeed < minWind.windSpeed) {
                    minWind = reading;
                }
            }
            return minWind.windSpeed;
        } else {
            return 0;
        }
    }

    public static float getmaxPressure(List<Reading> readings) {
        Reading maxPressure = null;
        if (readings.size() > 0) {
            maxPressure = readings.get(0);
            for (Reading reading : readings) {
                if (reading.pressure > maxPressure.pressure) {
                    maxPressure = reading;
                }
            }
            return maxPressure.pressure;
        } else {
            return 0;
        }
    }

    public static float getminPressure(List<Reading> readings) {
        Reading minPressure = null;
        if (readings.size() > 0) {
            minPressure = readings.get(0);
            for (Reading reading : readings) {
                if (reading.pressure < minPressure.pressure) {
                    minPressure = reading;
                }
            }
            return minPressure.pressure;
        } else {
            return 0;
        }
    }



    public static String getlatesticon(List<Reading> readings) {
        if (readings.size() != 0) {
            Reading latestIcon = readings.get(readings.size() - 1);

            if (latestIcon.code == 100) {
                return "cloud sun icon";
            }
            if (latestIcon.code == 200) {
                return "cloud meatball icon";
            }
            if (latestIcon.code == 300) {
                return "cloud icon";
            }
            if (latestIcon.code == 400) {
                return "cloud rain icon";
            }
            if (latestIcon.code == 500) {
                return "cloud showers heavy icon";
            }
            if (latestIcon.code == 600) {
                return "umbrella icon";
            }
            if (latestIcon.code == 700) {
                return "snowflake icon";
            } else return "bolt icon";
        }
        return null;
    }




}












