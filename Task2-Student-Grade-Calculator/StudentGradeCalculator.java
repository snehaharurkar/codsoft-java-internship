// import java.util.Scanner;

// public class StudentGradeCalculator {
//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);

//         System.out.print("Enter number of subjects: ");
//         int n = sc.nextInt();
//         sc.nextLine(); // consume newline

//         String[] subjects = new String[n];
//         int[] marks = new int[n];

//         int total = 0;

//         // Input subject names + marks
//         for (int i = 0; i < n; i++) {
//             System.out.print("Enter subject " + (i + 1) + " name: ");
//             subjects[i] = sc.nextLine();

//             System.out.print("Enter marks obtained in " + subjects[i] + " (out of 100): ");
//             marks[i] = sc.nextInt();
//             sc.nextLine(); // consume newline

//             total += marks[i];
//         }

//         // Average
//         double average = (double) total / n;

//         // Grade Calculation (Standard)
//         String grade;
//         if (average >= 90) grade = "A+";
//         else if (average >= 80) grade = "A";
//         else if (average >= 70) grade = "B+";
//         else if (average >= 60) grade = "B";
//         else if (average >= 50) grade = "C";
//         else if (average >= 35) grade = "D";
//         else grade = "Fail";

//         // Display Results
//         System.out.println("\n----- RESULT -----");
//         for (int i = 0; i < n; i++) {
//             System.out.println(subjects[i] + ": " + marks[i]);
//         }

//         System.out.println("------------------");
//         System.out.println("Total Marks: " + total + " / " + (n * 100));
//         System.out.println("Average Percentage: " + average + "%");
//         System.out.println("Grade: " + grade);
//     }
// }


// import java.util.Scanner;

// public class StudentGradeCalculatorColor {

//     // ANSI Color Codes
//     public static final String RESET = "\u001B[0m";
//     public static final String RED = "\u001B[31m";
//     public static final String GREEN = "\u001B[32m";
//     public static final String YELLOW = "\u001B[33m";
//     public static final String BLUE = "\u001B[34m";
//     public static final String CYAN = "\u001B[36m";
//     public static final String PURPLE = "\u001B[35m";

//     public static void main(String[] args) {

//         Scanner sc = new Scanner(System.in);

//         System.out.println(CYAN + "🎓 STUDENT GRADE CALCULATOR" + RESET);
//         System.out.print(YELLOW + "Enter number of subjects: " + RESET);
//         int n = sc.nextInt();
//         sc.nextLine(); // consume newline

//         String[] subjects = new String[n];
//         int[] marks = new int[n];
//         int total = 0;

//         // Input section
//         for (int i = 0; i < n; i++) {
//             System.out.print(BLUE + "\nEnter subject " + (i + 1) + " name: " + RESET);
//             subjects[i] = sc.nextLine();

//             System.out.print("Enter marks obtained in " + PURPLE + subjects[i] + RESET + " (out of 100): ");
//             marks[i] = sc.nextInt();
//             sc.nextLine();

//             total += marks[i];
//         }

//         double average = (double) total / n;

//         // Grade
//         String grade;
//         if (average >= 90) grade = GREEN + "A+" + RESET;
//         else if (average >= 80) grade = GREEN + "A" + RESET;
//         else if (average >= 70) grade = YELLOW + "B+" + RESET;
//         else if (average >= 60) grade = YELLOW + "B" + RESET;
//         else if (average >= 50) grade = PURPLE + "C" + RESET;
//         else if (average >= 35) grade = RED + "D" + RESET;
//         else grade = RED + "FAIL" + RESET;

//         // Results
//         System.out.println("\n" + CYAN + "------- 📘 RESULT -------" + RESET);

//         for (int i = 0; i < n; i++) {
//             System.out.println(PURPLE + subjects[i] + RESET + ": " + YELLOW + marks[i] + RESET);
//         }

//         System.out.println("---------------------------");
//         System.out.println(BLUE + "Total Marks: " + RESET + total + " / " + (n * 100));
//         System.out.println(BLUE + "Average Percentage: " + RESET + average + "%");
//         System.out.println(BLUE + "Grade: " + RESET + grade);
//     }
// }



import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;

public class StudentGradeCalculator {

    // ANSI Colors
    public static final String RESET = "\u001B[0m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String BLUE = "\u001B[34m";
    public static final String PURPLE = "\u001B[35m";
    public static final String CYAN = "\u001B[36m";

    public static void main(String[] args) throws InterruptedException {
        Scanner sc = new Scanner(System.in);

        System.out.println(CYAN + "🎓 ENHANCED STUDENT GRADE CALCULATOR" + RESET);
        System.out.print(YELLOW + "Enter number of subjects: " + RESET);
        int n = sc.nextInt();
        sc.nextLine();

        String[] subjects = new String[n];
        int[] marks = new int[n];
        int total = 0;

        // Input subject names + marks
        for (int i = 0; i < n; i++) {
            System.out.print(BLUE + "\nEnter subject " + (i + 1) + " name: " + RESET);
            subjects[i] = sc.nextLine();

            System.out.print("Enter marks obtained in " + PURPLE + subjects[i] + RESET + " (out of 100): ");
            marks[i] = sc.nextInt();
            sc.nextLine();
            total += marks[i];
        }

        double average = (double) total / n;

        // Determine grade with color
        String grade;
        String gradeColor;
        if (average >= 90) { grade = "A+"; gradeColor = GREEN; }
        else if (average >= 80) { grade = "A"; gradeColor = GREEN; }
        else if (average >= 70) { grade = "B+"; gradeColor = YELLOW; }
        else if (average >= 60) { grade = "B"; gradeColor = YELLOW; }
        else if (average >= 50) { grade = "C"; gradeColor = PURPLE; }
        else if (average >= 35) { grade = "D"; gradeColor = RED; }
        else { grade = "FAIL"; gradeColor = RED; }

        // Display results with table formatting
        System.out.println(CYAN + "\n------- 📘 RESULT -------" + RESET);
        System.out.printf("%-20s | %-10s\n", "Subject", "Marks");
        System.out.println("----------------------------");
        for (int i = 0; i < n; i++) {
            System.out.printf("%-20s | %-10d\n", subjects[i], marks[i]);
            Thread.sleep(300); // ⏳ small delay animation
        }
        System.out.println("----------------------------");
        System.out.printf("%-20s | %-10d\n", "Total", total);
        System.out.printf("%-20s | %-10.2f%%\n", "Average", average);
        System.out.printf("%-20s | %s%s%s\n", "Grade", gradeColor, grade, RESET);

        // 🔊 Sound alert for pass/fail (Windows beep)
        if (average < 35) System.out.print("\007"); // fail beep
        else System.out.print("\007"); // pass beep

        // Save report to file
        try (FileWriter writer = new FileWriter("StudentReport.txt")) {
            writer.write("----- STUDENT REPORT -----\n");
            for (int i = 0; i < n; i++) {
                writer.write(subjects[i] + ": " + marks[i] + "\n");
            }
            writer.write("-------------------------\n");
            writer.write("Total Marks: " + total + " / " + (n*100) + "\n");
            writer.write("Average: " + String.format("%.2f", average) + "%\n");
            writer.write("Grade: " + grade + "\n");
            writer.flush();
            System.out.println(GREEN + "\n✅ Report saved to StudentReport.txt" + RESET);
        } catch (IOException e) {
            System.out.println(RED + "Error saving report!" + RESET);
        }
    }
}
