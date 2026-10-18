import java.util.Scanner;
import java.util.ArrayList;
public class App {
    public static class Student{
        public int id;
        public String name;
        public int age;
        public float gpa;
        public int activeStatus;

        public Student(){
        }

        public Student(int id, String name, int age, float gpa, int activeStatus){
            this.id = id;
            this.name = name;
            this.gpa = gpa;
            this.age = age;
            this.activeStatus = activeStatus;
        }

    }

    ArrayList<Student> studentList = new ArrayList<>();
    public static void greet(){
        System.out.println("===== STUDENT PERFORMANCE TRACKER =====");
        System.out.println("1. Register student");
        System.out.println("2. View student profile");
        System.out.println("3. Calculate score statistics");
        System.out.println("4. Generate Random PRactice Score");
        System.out.println("5. Exit");
    }

    public static int choice(){
        Scanner myObj = new Scanner(System.in);
        boolean isRunning = true;

        while(isRunning){
            System.out.print("Enter your choice (1-5): ");
            if(myObj.hasNextInt()){
                int choice_l = myObj.nextInt();

                if(choice_l >= 1 && choice_l <= 5){
                    return choice_l;//returns choice
                }

                myObj.close();
            } else {
                myObj.next(); //clears input
            }
            System.out.println("Invalid choice. please enter a number between 1 and 5, inclusive.");
        }
        
        return -1;
    }

    public static void RegisterStudent(){
        Scanner scanner = new Scanner(System.in);
        Student newStudent = new Student();
        System.out.print("Enter your name: ");
        newStudent.name = scanner.nextLine();
        
        System.out.print("Enter your age: ");
        newStudent.age = scanner.nextInt();

        System.out.print("Enter your id: ");
        newStudent.id = scanner.nextInt();

        System.out.print("Enter your gpa: ");
        newStudent.gpa = scanner.nextFloat();

        System.out.print("Enter your age: ");
        newStudent.age = scanner.nextInt();
    }
    public static void process(int choice){
        switch(choice){
            case 1:
                //RegisterStudent()
            case 2:
                //ViewProfile()
            case 3:
                //CalculateScore()
            case 4:
                //randomScore();
            case 5:

        }
    }
    
    public static void main(String[] args) throws Exception {
        boolean isRunning = true;
        while(isRunning){
            greet();
            int userChoice = choice();
            process(userChoice);

            if(userChoice == 5){
                isRunning = false;
            }
        }

        System.out.println("Program Terminated.");
    }
}
