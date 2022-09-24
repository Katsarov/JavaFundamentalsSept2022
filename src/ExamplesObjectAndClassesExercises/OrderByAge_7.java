package ExamplesObjectAndClassesExercises;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OrderByAge_7 {
    static class Person{
        String name;
        String id;
        int age;

        public Person(String name, String id, int age) {
            this.name = name;
            this.id = id;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public String getId() {
            return id;
        }

        public int getAge() {
            return age;
        }

        @Override
        public String toString() {
            return String.format("%s with ID: %s is %d years old.", getName(), getId(), getAge());
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Person> people = new ArrayList<>();
        String input = scanner.nextLine();

        while (!input.equals("End")){
            String[] line = input.split(" ");

            Person person = new Person(line[0], line[1], Integer.parseInt(line[2]));
            people.add(person);

            input = scanner.nextLine();
        }
        people.stream()
                .sorted((p1,p2) -> Integer.compare(p1.getAge(), p2.getAge()))
                .forEach(p -> System.out.println(p.toString()));
    }
}
