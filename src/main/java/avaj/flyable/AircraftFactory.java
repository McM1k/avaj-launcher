package avaj.flyable;

import avaj.exceptions.UnknownFlyableTypeException;
import avaj.simulation.WeatherTower;

public class AircraftFactory {
    static private WeatherTower weatherTower;
    static public void setWeatherTower(WeatherTower wt){
        weatherTower = wt;
    }

    AircraftFactory(WeatherTower weatherTower){
        this.weatherTower = weatherTower;
    }

    public static Flyable newAircraft(String type, String name, int longitude, int latitude, int height){
        Coordinates coordinates = new Coordinates(longitude, latitude, height);
        Flyable flyable;

        if (type.equals("Helicopter")) {
            flyable = new Helicopter(name, coordinates);
            flyable.registerTower(weatherTower);
        }
        else if (type.equals("JetPlane")) {
            flyable = new JetPlane(name, coordinates);
            flyable.registerTower(weatherTower);
        }
        else if (type.equals("Baloon")) {
            flyable = new Baloon(name, coordinates);
            flyable.registerTower(weatherTower);
        }
        else throw new UnknownFlyableTypeException();
        return flyable;
    }
}
