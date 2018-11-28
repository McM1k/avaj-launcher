package avaj.flyable;

import avaj.simulation.WeatherTower;

public class Baloon extends Aircraft implements Flyable {
    private WeatherTower weatherTower;

    Baloon(String name, Coordinates coordinates){

    }

    @Override
    public void updateConditions() {
        String weather = weatherTower.getWeather(coordinates);
        String message;
        String type = "Baloon";

        if (weather == "SUN") {
            this.coordinates = new Coordinates(coordinates.getLongitude() + 2,coordinates.getLatitude(),coordinates.getHeight() + 4);
            message = "yellow ball good for skin too high burn";
        }
        else if (weather == "RAIN") {
            this.coordinates = new Coordinates(coordinates.getLongitude(),coordinates.getLatitude(),coordinates.getHeight() - 5);
            message = "small water chunks heavy make go down";
        }
        else if (weather == "FOG") {
            this.coordinates = new Coordinates(coordinates.getLongitude(),coordinates.getLatitude(),coordinates.getHeight() - 3);
            message = "no can see in coton";
        }
        else if (weather == "SNOW") {
            this.coordinates = new Coordinates(coordinates.getLongitude(),coordinates.getLatitude(),coordinates.getHeight() - 15);
            message = "cocaina in sky think me too high";
        }
        else {
            message = "Existence is pain. Nothing is real. If the minecraft world is infinite, how does a sun revolves around it?";
        }
        System.out.println(this.composeMessage(type, message));
    }

    @Override
    public void registerTower(WeatherTower weatherTower) {

    }
}
