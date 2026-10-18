import java.util.Scanner;
public class App {
    class Student{
        private int id;
        private String name;
        private int age;
        private float gpa;
        private int activeStatus;

        public Student(){
        }

        public Student(int id, String name, int age, float gpa, int activeStatus){
            this.id = id;
            this.name = name;
            this.gpa = gpa;
            this.age = age;
            this.activeStatus = activeStatus;
        }

        public String getName(){
            return name;
        }

        public void setName(String name){
            this.name = name;
        }

        public int getAge(){
            return age;
        }

        public void setAge(int age){
            this.age = age;
        }

        public float getGPA(){
            return gpa;
        }

        public void setGPA(float gpa){
            this.gpa = gpa;
        }

        public int getID(){
            return id;
        }

        public void setID(int id){
            this.id = id;
        }
    }

    
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
