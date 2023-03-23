import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class GradeBook {
    private int courseNo;
    private String courseName;
    private String instructor;
    private ArrayList<Student> list = new ArrayList<>();
    Scanner input = new Scanner(System.in);

    public GradeBook() {
    }

    public String getInstructor() {
        return instructor;
    }

    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }

    public int getCourseNo() {
        return courseNo;
    }

    public void setCourseNo(int courseNo) {
        this.courseNo = courseNo;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getNumberOfStudents() {
        return list.size();
    }

    public void addRecord() {
        Student std = new Student();
        list.add(std);
    }

    public void addRecordsFromFile(String fname) {
        try {
            FileReader fileReader = new FileReader(System.getProperty("user.dir") + "\\src\\" + fname + ".txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line;

            while ((line = bufferedReader.readLine()) != null) {
                String[] data = line.split(" ");

                String[] arrName = new String[2];
                int[] arrGrades = new int[3];

                int id = Integer.parseInt(data[0]);
                String firstName = data[1];
                String secondName = data[2];
                arrName[0] = firstName;
                arrName[1] = secondName;

                int firstMark = Integer.parseInt(data[3]);
                int secondMark = Integer.parseInt(data[4]);
                int thirdMark = Integer.parseInt(data[5]);
                arrGrades[0] = firstMark;
                arrGrades[1] = secondMark;
                arrGrades[2] = thirdMark;

                Student std = new Student(id, arrName, arrGrades);
                list.add(std);

                System.out.println(std.toString());
            }

            bufferedReader.close();
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file: " + e.getMessage());
        }
    }

    public Student searchRecord(int id) {
        Student s = null;
        for (int i = 0; i < list.size(); i++) {
            if (id == list.get(i).getId()) {
                s = list.get(i);
                System.out.println(s.toString());
                break;
            } else {
                System.out.println("ERROR: there is no record for student ID #" + id);
            }
        }
        return s;
    }

    public int[] countCharGrades() {
        int[] arrLetters = new int[5];

        int letterA = 0;
        int letterB = 0;
        int letterC = 0;
        int letterD = 0;
        int letterF = 0;

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getCharGrade() == 'A') {
                arrLetters[0] = letterA++;
            } else if (list.get(i).getCharGrade() == 'B') {
                arrLetters[1] = letterB++;
            } else if (list.get(i).getCharGrade() == 'C') {
                arrLetters[2] = letterC++;
            } else if (list.get(i).getCharGrade() == 'D') {
                arrLetters[3] = letterD++;
            }else if (list.get(i).getCharGrade() == 'F') {
                arrLetters[4] = letterF++;
            } else {
                System.out.println("Not Found!!");
            }
        }

        return arrLetters;
    }

    public Student maxRecord() {
        Student std = new Student();
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.size(); j++) {
                if (list.get(i).getAvg() >= list.get(j).getAvg()) {
                    std = list.get(i);
                } else {
                    System.out.println("WARNING!!");
                }
            }
        }
        return std;
    }

    public Student minRecord() {
        Student std = null;
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.size(); j++) {
                if (list.get(i).getAvg() <= list.get(j).getAvg()) {
                    std = list.get(i);
                } else {
                    System.out.println("WARNING!!");
                }
            }
        }
        return std;

    }

    public String printStatistics() {

        double avg = 0;
        for (int i = 0; i < list.size(); i++) {
            avg += list.get(i).getAvg();
        }
        double averageScore = avg / list.size();


        return "Statistical Results of " + getCourseName() + " " + getCourseNo() + " (Instructor: "+getInstructor()+"): \n"
                + "Total number of Student Records: " + getNumberOfStudents() + "\n"
                + "Average Score: " + averageScore + "\n"
                + "Highest Score: " + maxRecord().getAvg() + "\n"
                + "Lowest Score: " + minRecord().getAvg() + "\n"
                +"Total 'A' Grades: "+countCharGrades()[0]+" (0% of class)\n"
                +"Total 'B' Grades: "+countCharGrades()[1]+" (0% of class)\n"
                +"Total 'C' Grades: "+countCharGrades()[2]+" (0% of class)\n"
                +"Total 'D' Grades: "+countCharGrades()[3]+" (0% of class)\n"
                + "Total 'F' Grades: " + countCharGrades()[4] + " (0% of class)";
    }
}
