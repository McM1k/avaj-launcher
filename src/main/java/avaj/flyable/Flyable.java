package avaj.flyable;

import avaj.simulation.WeatherTower;

public interface Flyable {
    public void updateConditions();
    public void registerTower(WeatherTower weatherTower);

    String getName();

    long getId();

    int getHeight();
}
