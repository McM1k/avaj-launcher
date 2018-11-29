package avaj.flyable;

import avaj.exceptions.FlyableAlreadyRegisteredException;
import avaj.exceptions.FlyableNotFoundException;
import avaj.simulation.WeatherTower;

import java.nio.file.FileAlreadyExistsException;

public class Helicopter extends Aircraft implements Flyable {
    private WeatherTower weatherTower;

    Helicopter(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    public String getName() {
        return name;
    }

    public long getId() {
        return id;
    }

    public int getHeight(){
        return this.coordinates.getHeight();
    }

    @Override
    public void updateConditions() {
        String weather = weatherTower.getWeather(coordinates);
        String message;
        String type = "Helicopter";

        if (weather.equals("SUN")) {
            this.coordinates = new Coordinates(coordinates.getLongitude() + 10,coordinates.getLatitude(),coordinates.getHeight() + 2);
            message = "ye son";
        }
        else if (weather.equals("RAIN")) {
            this.coordinates = new Coordinates(coordinates.getLongitude() + 5,coordinates.getLatitude(),coordinates.getHeight());
            message = "ye ren";
        }
        else if (weather.equals("FOG")) {
            this.coordinates = new Coordinates(coordinates.getLongitude() + 1,coordinates.getLatitude(),coordinates.getHeight());
            message = "ye fok";
        }
        else if (weather.equals("SNOW")) {
            this.coordinates = new Coordinates(coordinates.getLongitude(),coordinates.getLatitude(),coordinates.getHeight() - 12);
            message = "ye sno";
        }
        else {
            message = "no";
        }
        System.out.println(this.composeMessage(type, message));
        if (this.coordinates.getHeight() == 0){
            System.out.println(this.composeMessage(type, "landing."));
        }
    }

    @Override
    public void registerTower(WeatherTower weatherTower) {
        try {
            weatherTower.register(this);
            this.weatherTower = weatherTower;
        }
        catch(FlyableAlreadyRegisteredException e){
            System.out.println(e.getMessage());
        }
    }

}
