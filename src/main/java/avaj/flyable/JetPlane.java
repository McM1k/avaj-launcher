package avaj.flyable;

import avaj.simulation.WeatherTower;

public class JetPlane extends Aircraft implements Flyable {
    private WeatherTower weatherTower;

    JetPlane(String name, Coordinates coordinates){

    }

    @Override
    public void updateConditions() {
        String weather = weatherTower.getWeather(coordinates);
        String message;
        String type = "JetPlane";

        if (weather == "SUN") {
            this.coordinates = new Coordinates(coordinates.getLongitude(),coordinates.getLatitude() + 10,coordinates.getHeight() + 2);
            message = "A nice weather for effective bombing";
        }
        else if (weather == "RAIN") {
            this.coordinates = new Coordinates(coordinates.getLongitude(),coordinates.getLatitude() + 5,coordinates.getHeight());
            message = "Too bad it's water instead of missiles falling from the sky";
        }
        else if (weather == "FOG") {
            this.coordinates = new Coordinates(coordinates.getLongitude(),coordinates.getLatitude() + 1,coordinates.getHeight());
            message = "napalm makes a lot of smoke";
        }
        else if (weather == "SNOW") {
            this.coordinates = new Coordinates(coordinates.getLongitude(),coordinates.getLatitude(),coordinates.getHeight() - 7);
            message = "napalm makes a lot of ashes";
        }
        else {
            message = "adolf, is that you?";
        }
        System.out.println(this.composeMessage(type, message));
    }

    @Override
    public void registerTower(WeatherTower weatherTower) {

    }
}
