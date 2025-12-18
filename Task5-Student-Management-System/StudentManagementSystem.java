package studentmanagement;

import java.io.*;
import java.util.*;

public class StudentManagementSystem {

    private ArrayList<Student> students = new ArrayList<>();
    private Scanner sc = new Scanner(System.in);
    private final String FILE_NAME = "students.dat";

    public StudentManagementSystem() {
        loadFromFile();
    }

    public void start() {
        int choice;

        do {
            System.out.println("\n--- STUDENT MANAGEMENT SYSTEM ---");
            System.out.println("1. Add Student");
            System.out.println("2. Edit Student");
            System.out.println("3. Remove Student");
            System.out.println("4. Search Student");
            System.out.println("5. Display All Students");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 -> addStudent();
                case 2 -> editStudent();
                case 3 -> removeStudent();
                case 4 -> searchStudent();
                case 5 -> displayStudents();
                case 6 -> saveToFile();
                default -> System.out.println("Invalid choice!");
            }
        } while (choice != 6);

        System.out.println("Exiting Student Management System...");
    }

    private void addStudent() {
        System.out.print("Enter name: ");
        String name = sc.nextLine();

        System.out.print("Enter roll number: ");
        int roll = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter grade: ");
        String grade = sc.nextLine();

        if (name.isEmpty() || grade.isEmpty()) {
            System.out.println("Error: Fields cannot be empty.");
            return;
        }

        students.add(new Student(name, roll, grade));
        System.out.println("Student added successfully.");
    }

    private void editStudent() {
        System.out.print("Enter roll number to edit: ");
        int roll = sc.nextInt();
        sc.nextLine();

        for (Student s : students) {
            if (s.getRollNumber() == roll) {
                System.out.print("Enter new name: ");
                s.setName(sc.nextLine());

                System.out.print("Enter new grade: ");
                s.setGrade(sc.nextLine());

                System.out.println("Student updated successfully.");
                return;
            }
        }
        System.out.println("Student not found.");
    }

    private void removeStudent() {
        System.out.print("Enter roll number to remove: ");
        int roll = sc.nextInt();

        boolean removed = students.removeIf(s -> s.getRollNumber() == roll);
        System.out.println(removed ? "Student removed." : "Student not found.");
    }

    private void searchStudent() {
        System.out.print("Enter roll number to search: ");
        int roll = sc.nextInt();

        for (Student s : students) {
            if (s.getRollNumber() == roll) {
                System.out.println(s);
                return;
            }
        }
        System.out.println("Student not found.");
    }

    private void displayStudents() {
        if (students.isEmpty()) {
            System.out.println("No students available.");
            return;
        }

        for (Student s : students) {
            System.out.println(s);
        }
    }

    private void saveToFile() {
        try (ObjectOutputStream out =
                     new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            out.writeObject(students);
        } catch (Exception e) {
            System.out.println("Error saving data.");
        }
    }

    private void loadFromFile() {
        try (ObjectInputStream in =
                     new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            students = (ArrayList<Student>) in.readObject();
        } catch (Exception e) {
            students = new ArrayList<>();
        }
    }

    public static void main(String[] args) {
        new StudentManagementSystem().start();
    }
}

