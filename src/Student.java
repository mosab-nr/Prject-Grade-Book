import java.util.Scanner;

public class Student {
    private int id;
    private String[] name = new String[2];
    private int[] grades = new int[3];
    private double avg;
    private char charGrade;
    Scanner input = new Scanner(System.in);

    public Student(int id, String[] name, int[] grades) {
        this.id = id;
        this.name = name;
        this.grades = grades;
    }

    public Student() {
        System.out.print("Enter Student ID: ");
        int studentId = input.nextInt();
        this.id = studentId;
        System.out.print("Enter First Name of the student: ");
        name[0] = input.next();
        System.out.print("Enter Second Name of the student: ");
        name[1] = input.next();

        System.out.println("Enter grades for this Students -> ID(" + studentId + ")");
        int c = 1;
        for (int i = 0; i < 3; i++) {
            System.out.print("Enter the Exam number $" + c + " grade: ");
            int studentGrade = input.nextInt();
            grades[i] = studentGrade;
            c++;
        }

        System.out.println("The final grade for "+getName()+" (#"+getId()+") is "+calculateAvg()+"("+calculateCharacterGrade()+")");

    }

    public String toString() {
        return "Student Record for " + this.name[0] + " " + this.name[1] + " (ID#" + this.id + "):\n"
                + "Exam1: " + this.grades[0] + "\nExam2: " + this.grades[1] + "\nExam3: " + this.grades[2] + "\n"
                + "Final Grade: " + calculateAvg() + "\nLetter Grade: " + calculateCharacterGrade();
    }

    public String getName() {
        return this.name[0] + " " + this.name[1];
    }

    public int getId() {
        return id;
    }

    public double getAvg() {
        return avg;
    }

    public char getCharGrade() {
        return charGrade;
    }

    private double calculateAvg() {
        double percentFirstExam = this.grades[0] * 0.3;
        double percentSecondExam = this.grades[1] * 0.3;
        double percentThirdExam = this.grades[2] * 0.4;

        return percentFirstExam + percentSecondExam + percentThirdExam;
    }

    private char calculateCharacterGrade() {
        if (calculateAvg() >= 90 && calculateAvg() <= 100) {
            return 'A';
        } else if (calculateAvg() >= 80) {
            return 'B';
        } else if (calculateAvg() >= 70) {
            return 'C';
        } else {
            return 'F';
        }
    }
}
