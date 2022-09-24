package ExamplesObjectAndClassesExercises;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class VehicleCatalogue_06 {
    static class Vehicle{
        String type;
        String model;
        String colour;
        int horsePower;

        public Vehicle(String type, String model, String colour, int horsePower) {
            this.type = type;
            this.model = model;
            this.colour = colour;
            this.horsePower = horsePower;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getModel() {
            return model;
        }

        public void setModel(String model) {
            this.model = model;
        }

        public String getColour() {
            return colour;
        }

        public void setColour(String colour) {
            this.colour = colour;
        }

        public int getHorsePower() {
            return horsePower;
        }

        public void setHorsePower(int horsePower) {
            this.horsePower = horsePower;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> cars = new ArrayList<>();
        List<String> trucks = new ArrayList<>();

        int truckCount = 0;
        int carsCount = 0;
        int totalHorsePowerTrucks = 0;
        int totalHorsePowerCars = 0;


        String input = scanner.nextLine();

        while (!input.equals("End")){
            String[] data = input.split(" ");
            String type = data[0];
            String modelData = data[1];
            String colorData = data[2];
            int horsePowerData = Integer.parseInt(data[3]);

            //Vehicle vehicle = new Vehicle(type, modelData, colorData, horsePowerData);

            if(type.equals("truck")){
                trucks.add(type);
                trucks.add(modelData);
                trucks.add(colorData);
                trucks.add(data[3]);
                truckCount++;
                totalHorsePowerTrucks += horsePowerData;



            }

            else if(type.equals("car")){
                cars.add(type);
                cars.add(modelData);
                cars.add(colorData);
                cars.add((data[3]));
                carsCount++;
                totalHorsePowerCars += horsePowerData;
            }


            System.out.printf("Type: %s\n", type);
            System.out.printf("Model: %s\n", modelData);
            System.out.printf("Color: %s\n", colorData);
            System.out.printf("Horsepower: %d\n", horsePowerData);

            input = scanner.nextLine();

        }

        String modelOfVehicle = scanner.nextLine();

        while (!modelOfVehicle.equals("Close the Catalogue")){
            modelOfVehicle = scanner.nextLine();
            //if(modelOfVehicle.contains())
        }

        double averageHorsePowerTrucks = 1.0 * totalHorsePowerTrucks / truckCount;
        double averageHorsePowerCars = 1.0 * totalHorsePowerCars / carsCount;

        System.out.printf("Cars have average horsepower of %.2f.\n", averageHorsePowerCars);
        System.out.printf("Trucks have average horsepower of %.2f.\n", averageHorsePowerTrucks);
    }
}
