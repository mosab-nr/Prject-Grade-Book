import java.util.Scanner;

public class TestGradeBook {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        GradeBook gb = new GradeBook();
        System.out.println("Welcome to the IUG Grade Book.");
        System.out.println("Please give us some basic information...");
        System.out.print("What is the course number for your class: ");
        String courseName = input.next();
        gb.setCourseName(courseName);
        int courseNumber = input.nextInt();
        input.nextLine();
        gb.setCourseNo(courseNumber);
        System.out.print("What is the name of the instructor: ");
        String instructor = input.nextLine();
        gb.setInstructor(instructor);
        System.out.println("Thank you. Processing...");


        int userInput;

        while (true) {
            do {
                showMenue();
                userInput = input.nextInt();
                switch (userInput) {
                    case 1:
                        gb.addRecord();
                        break;

                    case 2:
                        System.out.print("Enter your file name: ");
                        String fileName = input.nextLine();
                        gb.addRecordsFromFile(fileName);
                        break;

                    case 3:
                        System.out.print("Enter new ID: ");
                        int id = input.nextInt();
                        gb.searchRecord(id);
                        break;

                    case 4:
                        gb.printStatistics();
                        break;

                    case 5:
                        System.exit(0);
                        break;

                    default:
                        System.out.println("\n**** v_v ****");
                        System.out.println("Invalid Choice: please try again.\n\n");
                }

            } while (userInput >= 1 && userInput <= 5);
        }

    }

    static void showMenue() {
        System.out.println("----------------------------------------------------");
        System.out.println("IUG Grade Book");
        System.out.println("----------------------------------------------------");
        System.out.println("1. Add a student record");
        System.out.println("2. Add student records from file");
        System.out.println("3. Display a student record");
        System.out.println("4. Display statistical results of class");
        System.out.println("5. Quit");
        System.out.print("Enter Your Choice: ");
    }
}
