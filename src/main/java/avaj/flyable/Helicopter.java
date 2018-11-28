package avaj.flyable;

import avaj.simulation.WeatherTower;

public class Helicopter extends Aircraft implements Flyable {
    private WeatherTower weatherTower;

    Helicopter(String name, Coordinates coordinates) {

    }

    @Override
    public void updateConditions() {
        String weather = weatherTower.getWeather(coordinates);
        String message;
        String type = "Helicopter";

        if (weather == "SUN") {
            this.coordinates = new Coordinates(coordinates.getLongitude() + 10,coordinates.getLatitude(),coordinates.getHeight() + 2);
            message = "ye son";
        }
        else if (weather == "RAIN") {
            this.coordinates = new Coordinates(coordinates.getLongitude() + 5,coordinates.getLatitude(),coordinates.getHeight());
            message = "ye ren";
        }
        else if (weather == "FOG") {
            this.coordinates = new Coordinates(coordinates.getLongitude() + 1,coordinates.getLatitude(),coordinates.getHeight());
            message = "ye fok";
        }
        else if (weather == "SNOW") {
            this.coordinates = new Coordinates(coordinates.getLongitude(),coordinates.getLatitude(),coordinates.getHeight() - 12);
            message = "ye sno";
        }
        else {
            message = "no";
        }
        System.out.println(this.composeMessage(type, message));
    }

    @Override
    public void registerTower(WeatherTower weatherTower) {

    }

}
