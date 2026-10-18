import java.util.Scanner;
import java.util.ArrayList;
import java.util.Locale;

public class App {
    public static class Student {
        public int id;
        public String name;
        public int age;
        public float gpa;
        public int activeStatus;

        public Student() {}
    }

    static ArrayList<Student> studentList = new ArrayList<>();
    static Scanner globalScanner = new Scanner(System.in).useLocale(Locale.US);

    public static void greet() {
        System.out.println("\n===== STUDENT PERFORMANCE TRACKER =====");
        System.out.println("1. Register student");
        System.out.println("2. View student profile");
        System.out.println("3. Calculate score statistics");
        System.out.println("4. Generate Random Practice Score");
        System.out.println("5. Exit");
    }

    public static int choice() {
        while (true) {
            System.out.print("Enter your choice (1-5): ");
            if (globalScanner.hasNextInt()) {
                int choice_l = globalScanner.nextInt();
                globalScanner.nextLine(); 

                if (choice_l >= 1 && choice_l <= 5) {
                    return choice_l;
                }
            } else {
                globalScanner.next(); 
            }
            System.out.println("Invalid choice. please enter a number between 1 and 5, inclusive.");
        }
    }

    public static void RegisterStudent() {
        Student newStudent = new Student();
        
        System.out.print("Enter your name: ");
        newStudent.name = globalScanner.nextLine();
        
        System.out.print("Enter your age: ");
        newStudent.age = globalScanner.nextInt();

        System.out.print("Enter your id: ");
        newStudent.id = globalScanner.nextInt();

        System.out.print("Enter your gpa: ");
        newStudent.gpa = globalScanner.nextFloat();

        while (newStudent.gpa < 0.0 || newStudent.gpa > 4.0) {
            System.out.println("GPA Should be within 0.0 and 4.0");
            System.out.print("Enter your gpa: ");
            newStudent.gpa = globalScanner.nextFloat();
        }
        globalScanner.nextLine(); 

        newStudent.activeStatus = 1;
        studentList.add(newStudent);
        System.out.println("Student registered successfully!");
    }

    public static void ViewProfile() {
        if (studentList.isEmpty()) {
            System.out.println("No students registered yet.");
            return;
        }
        for (int i = 0; i < studentList.size(); i++) {
            Student s = studentList.get(i);
            System.out.printf("Student %d:%n", i + 1);
            System.out.printf("ID: %d | Name: %s | Age: %d | GPA: %.2f | Active: %d%n", 
                s.id, s.name, s.age, s.gpa, s.activeStatus);
            System.out.println("-----------------------------------------");
        }
    }

    public static void scoreStats(){
        if(studentList.size() == 0){
            System.err.println("No student. Please input first");
            return;
        }
        for (int i = 0; i < studentList.size(); i++) {
            Student s = studentList.get(i);
            System.out.printf("Student %d's score = ", i+1);
            if(s.gpa == 0.0){
                System.out.println("Very Bad!");
            } else if(s.gpa > 0.0 && s.gpa < 1.0){
                System.out.println("Bad!");
            } else if(s.gpa > 1.0 && s.gpa > 2.0){
                System.out.println("Average");
            } else if(s.gpa > 2.0 && s.gpa < 3.0){
                System.out.println("Good");
            } else if(s.gpa > 3.0 && s.gpa < 4.0){
                System.out.println("Very good!");
            } else if(s.gpa == 4.0){
                System.out.println("Perfect!");
            }
            System.out.println("-----------------------------------------");
        }
    }

    public static void process(int choice) {
        switch (choice) {
            case 1: RegisterStudent(); break;
            case 2: ViewProfile(); break;
            case 3: scoreStats();; break;
            case 4: System.out.println("Option 4 coming soon!"); break;
            case 5: System.out.println("Exiting tracker..."); break;
        }
    }
    
    public static void main(String[] args) throws Exception {
        boolean isRunning = true;
        while (isRunning) {
            greet();
            int userChoice = choice();
            process(userChoice);
            if (userChoice == 5) {
                isRunning = false;
            }
        }
        globalScanner.close();
        System.out.println("Program Terminated.");
    }
}
