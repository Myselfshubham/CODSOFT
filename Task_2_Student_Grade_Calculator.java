import java.util.*;
public class Task_2_Student_Grade_Calculator {
    public static void main(String[] args) {
        System.out.println("************************************");
        System.out.println("--*--[STUDENT GRADE CALCULATOR]--*--");
        System.out.println("************************************");
        Scanner scan = new Scanner(System.in);
        System.out.println("ENTER YOUR DETAILS:-");
        System.out.print("Name : ");
        String name = scan.nextLine();
        System.out.print("Total Subjects(>0) : ");
        int totalSub = scan.nextInt();
        int totalMarks = 0;
        String[] subjects = new String[totalSub];
        int[] marks = new int[totalSub];
        for (int i = 0; i < totalSub; i++) {
            System.out.print("Enter you Sub. " + (i+1) + " : ");
            scan.nextLine();
            subjects[i] = scan.nextLine();
            System.out.print("Enter marks of " + subjects[i] + " : ");
            marks[i] = scan.nextInt();
            totalMarks += marks[i];
        }
        float average = (float) totalMarks/totalSub;
        char grade = calculateGrade(average);
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("------------[Your Grade]-----------");
        System.out.println("Name : " + name);
        System.out.println("SUBJECTS =====> MARKS");
        System.out.println("---------------------");
        for(int i = 0; i < totalSub; i++)
        {
            System.out.println(subjects[i] + "  ===>  " + marks[i]);
        }
        System.out.println("Average Percentage : " + average);
        System.out.println("Grade Obtained : " + grade);
    }
    public static char calculateGrade(float score) {
        if (score >= 90.0 && score <= 100.0) {
            return 'A';
        } else if (score >= 80.0 && score < 90.0) {
            return 'B';
        } else if (score >= 70.0 && score < 80.0) {
            return 'C';
        } else if (score >= 60.0 && score < 70.0) {
            return 'D';
        } else if (score >= 1.0 && score < 60.0) {
            return 'F';
        } else {
            return 'I'; // I for Invalid input
        }
    }
}
