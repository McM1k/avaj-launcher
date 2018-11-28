package avaj.flyable;

import avaj.exceptions.UnknownFlyableTypeException;

public class AircraftFactory {
    public static Flyable newAircraft(String type, String name, int longitude, int latitude, int height){
        Coordinates coordinates = new Coordinates(longitude, latitude, height);

        if (type == "Helicopter") {
            return new Helicopter(name, coordinates);
        }
        else if (type == "JetPlane") {
            return new JetPlane(name, coordinates);
        }
        else if (type == "Baloon") {
            return new Baloon(name, coordinates);
        }
        else throw new UnknownFlyableTypeException();
        return null;
    }
}
