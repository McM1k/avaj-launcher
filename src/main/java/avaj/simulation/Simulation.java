package avaj.simulation;

import avaj.exceptions.UnknownFlyableTypeException;
import avaj.flyable.AircraftFactory;
import avaj.flyable.Flyable;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Logger;

public class Simulation {
    public static void main(String[] args){
        try {
            BufferedReader reader = new BufferedReader(new FileReader(args[0]));
            String line = reader.readLine();

            if (line != null){
                WeatherTower weatherTower = new WeatherTower();
                int simulations = Integer.parseInt(line.split(" ")[0]);
                if (simulations < 0) {
                    System.out.println("invalid Simulation count " + simulations);
                    System.exit(1);
                }
                while ((line = reader.readLine()) != null){
                    AircraftFactory.setWeatherTower(weatherTower);
                    AircraftFactory.newAircraft(
                            line.split(" ")[0],
                            line.split(" ")[1],
                            Integer.parseInt(line.split(" ")[2]),
                            Integer.parseInt(line.split(" ")[3]),
                            Integer.parseInt(line.split(" ")[4]));
                }
                for (int i = 1; i <= simulations; i++){
                    weatherTower.changeWeather();
                }
            }
        }
        catch (FileNotFoundException e){
            System.out.println("Couldn't find file " + args[0]);
        }
        catch (IOException e){
            System.out.println("There was a problem while reading the file " + args[0]);
        }
        catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Invalid file format");
        }
        catch (UnknownFlyableTypeException e){
            System.out.println(e.getMessage());
        }
    }
}
