package ExamplesObjectAndClassesExercises;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Students_05 {
    static class Student{
        String firstName;
        String lastName;
        double grade;

        public Student(String firstName, String lastName, double grade) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.grade = grade;
        }

        public String getFirstName() {
            return firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public double getGrade() {
            return grade;
        }

        @Override
        public String toString(){
            return String.format("%s %s: %.2f", this.getFirstName(), this.getLastName(), this.getGrade());
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        List<Student> people = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split(" ");
            String firstNameStudent = input[0];
            String lastNameStudent = input[1];
            double gradeStudent = Double.parseDouble(input[2]);

            Student student = new Student(firstNameStudent, lastNameStudent, gradeStudent);
            people.add(student);
        }

        people.stream()
                .sorted((p1,p2) -> Double.compare(p2.getGrade(), p1.getGrade()))
                .forEach(s -> System.out.println(s.toString()));
    }
}
