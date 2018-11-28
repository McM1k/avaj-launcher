package avaj.simulation;

import avaj.flyable.Coordinates;

import java.util.LinkedList;

public class WeatherProvider {
    private static WeatherProvider weatherProvider = new WeatherProvider();
    private String[] weather = {"SUN", "SNOW", "FOG", "RAIN"};

    private WeatherProvider() {
    }

    public static WeatherProvider getProvider() {
        return weatherProvider;
    }

    public String getCurrentWeather(Coordinates coordinates){
        int seed = coordinates.getHeight() * coordinates.getLatitude() * coordinates.getLongitude();
        return weather[seed % 4];
    }

}
