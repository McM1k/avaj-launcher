package avaj.flyable;

import avaj.exceptions.FlyableAlreadyRegisteredException;
import avaj.simulation.WeatherTower;

public class JetPlane extends Aircraft implements Flyable {
    private WeatherTower weatherTower;

    JetPlane(String name, Coordinates coordinates){
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
        String type = "JetPlane";

        if (weather.equals("SUN")) {
            this.coordinates = new Coordinates(coordinates.getLongitude(),coordinates.getLatitude() + 10,coordinates.getHeight() + 2);
            message = "Sun : lat + 10, h + 2";
        }
        else if (weather.equals("RAIN")) {
            this.coordinates = new Coordinates(coordinates.getLongitude(),coordinates.getLatitude() + 5,coordinates.getHeight());
            message = "Rain : lat + 5";
        }
        else if (weather.equals("FOG")) {
            this.coordinates = new Coordinates(coordinates.getLongitude(),coordinates.getLatitude() + 1,coordinates.getHeight());
            message = "Fog : lat + 1";
        }
        else if (weather.equals("SNOW")) {
            this.coordinates = new Coordinates(coordinates.getLongitude(),coordinates.getLatitude(),coordinates.getHeight() - 7);
            message = "Snow : h - 7";
        }
        else {
            message = "o shite";
        }
        System.out.println(this.composeMessage(type, message));
        if (this.coordinates.getHeight() == 0) {
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
