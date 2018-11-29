package avaj.flyable;

import avaj.exceptions.FlyableAlreadyRegisteredException;
import avaj.exceptions.FlyableNotFoundException;
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
            message = "A nice weather for effective bombing";
        }
        else if (weather.equals("RAIN")) {
            this.coordinates = new Coordinates(coordinates.getLongitude(),coordinates.getLatitude() + 5,coordinates.getHeight());
            message = "Too bad it's water instead of missiles falling from the sky";
        }
        else if (weather.equals("FOG")) {
            this.coordinates = new Coordinates(coordinates.getLongitude(),coordinates.getLatitude() + 1,coordinates.getHeight());
            message = "napalm makes a lot of smoke";
        }
        else if (weather.equals("SNOW")) {
            this.coordinates = new Coordinates(coordinates.getLongitude(),coordinates.getLatitude(),coordinates.getHeight() - 7);
            message = "napalm makes a lot of ashes";
        }
        else {
            message = "I've lost track of target.";
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
