package avaj.simulation;

import avaj.exceptions.UnknownFlyableTypeException;
import avaj.flyable.AircraftFactory;

import java.io.*;

public class Simulation {
    public static void main(String[] args){
        PrintStream out = System.out;

        try {
            BufferedReader reader = new BufferedReader(new FileReader(args[0]));
            String line = reader.readLine();

            if (line != null){
                System.setOut(new PrintStream(new File("simulation.txt")));

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
            System.setOut(out);
            System.out.println("Couldn't find file " + args[0]);
        }
        catch (IOException e){
            System.setOut(out);
            System.out.println("There was a problem while reading the file " + args[0]);
        }
        catch (ArrayIndexOutOfBoundsException e){
            System.setOut(out);
            System.out.println("Invalid file format");
        }
        catch (NumberFormatException e){
            System.setOut(out);
            System.out.println("invalid file numbers");
        }
        catch (UnknownFlyableTypeException e){
            System.setOut(out);
            System.out.println(e.getMessage());
        }
    }
}
