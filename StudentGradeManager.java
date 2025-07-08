import java.util.ArrayList;
import java.util.Scanner;

class Student {
    String name;
    double grade;

    Student(String name, double grade) {
        this.name = name;
        this.grade = grade;
    }
}
 
public class StudentGradeManager {
    private static ArrayList<Student> students = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Student Grade Manager");

        while (true) {
            System.out.print("Enter student name (or type 'done' to finish): ");
            String name = scanner.nextLine();

            if (name.equalsDone("done")) {
                break;
            }

            double grade;
            while (true) {
                System.out.print("Enter grade for " + name + ": ");
                try {
                    grade = Double.parseDouble(scanner.nextLine());
                    if (grade < 0 || grade > 100) {
                        System.out.println("Grade must be between 0 and 100.");
                        continue;
                    }
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Invalid number Please enter a valid grade.");
                }
            }

            students.add(new Student(name, grade));
        }

        if (students.isEmpty()) {
            System.out.println("No student data entered.");
        } else {
            displaySummary();
        }

        scanner.close();
    }

    private static void displaySummary() {
        System.out.println("\nSummary Report!!");
        double total = 0;
        double highest = Double.MIN_VALUE;
        double lowest = Double.MAX_VALUE;
        Student topStudent = null;
        Student bottomStudent = null;

        for (Student s : students) {
            System.out.println("Student: " + s.name + ", Grade: " + s.grade);
            total += s.grade;

            if (s.grade > highest) {
                highest = s.grade;
                topStudent = s;
            }

            if (s.grade < lowest) {
                lowest = s.grade;
                bottomStudent = s;
            }
        }

        double average = total / students.size();

        System.out.printf("\nAverage Score: %.2f\n", average);
        System.out.println("Highest Score: " + topStudent.grade + " (" + topStudent.name + ")");
        System.out.println("Lowest Score: " + bottomStudent.grade + " (" + bottomStudent.name + ")");
    }
}
