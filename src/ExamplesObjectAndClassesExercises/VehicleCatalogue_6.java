package ExamplesObjectAndClassesExercises;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class VehicleCatalogue_6 {
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

        public String getModel() {
            return model;
        }

        public String getColour() {
            return colour;
        }

        public int getHorsePower() {
            return horsePower;
        }

        @Override
        public String toString() {
            return String.format("Type: %s\n" +
                    "Model: %s\n" +
                    "Color: %s\n" +
                    "Horsepower: %s", getType().toUpperCase().charAt(0) + getType().substring(1),
                    getModel(), getColour(),getHorsePower());
        }
    }

    static double avrHp(List<Vehicle> vehicles){
        if(vehicles.size() == 0){
            return 0;
        }

        return vehicles.stream()
                // mapToDouble  взима getHorsePower, който е integer и го прави на double. Това е за целич stream
                .mapToDouble(Vehicle::getHorsePower)
                // след това ги сумираме и ги делим на броя на колите, което ни дава средно аритметично (average)
                .sum() / vehicles.size();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Тук ще си създадем един лист с превозни средства
        List<Vehicle> vehicleList = new ArrayList<>();

        String line = scanner.nextLine();
        while (!line.equals("End")){
            String[] data = line.split(" ");

            // Създаваме си нашият н нов обект Vehicle и го добавяме към листа vehicleList
            Vehicle vehicle = new Vehicle(data[0], data[1], data[2], Integer.parseInt(data[3]));
            vehicleList.add(vehicle);

            line = scanner.nextLine();
        }

        String line2 = scanner.nextLine();
        while (!line2.equals("Close the Catalogue")){
            String model = line2;

            vehicleList.stream()
                    .filter(vehicle -> vehicle.getModel().equals(model))
                    .forEach(vehicle -> System.out.println(vehicle.toString()));

            line2 = scanner.nextLine();
        }
        // Филтрираме от превозните средства само колите (cars), и ги запазваме в един лист
        List<Vehicle> cars = vehicleList.stream()
                .filter(vehicle -> vehicle.getType().equals("car"))
                .collect(Collectors.toList());

        // По същия начин си филтрираме от превозните средства само камионите (trucks), и ги запазваме в един лист
        List<Vehicle> trucks = vehicleList.stream()
                .filter(vehicle -> vehicle.getType().equals("truck"))
                .collect(Collectors.toList());

        // От този стрийм с коли взимаме параметъра конски сили и ги превръщаме в дробни числа (double).
        // Това ще ни върне един лист с конските сили на всички коли, но като дробнио числа
        double carsAvgHp = avrHp(cars);
        double trucksAvgHp = avrHp(trucks);

        System.out.printf("Cars have average horsepower of: %.2f.\n", carsAvgHp);
        System.out.printf("Trucks have average horsepower of: %.2f.\n", trucksAvgHp);
    }
}
