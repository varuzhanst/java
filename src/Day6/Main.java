package Day6;

import Day6.model.Student;
import Day6.service.StudentService;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        String path = "C:\\Users\\varuz\\Desktop\\Students.txt";
        Student[] allStudents = StudentService.generateStudentsFromTxt(path);
        System.out.println("--------- Task 1 ---------");
        StudentService.printFullName(allStudents);
        System.out.println("--------- Task 2 ---------");
        StudentService.printMaleStudents(allStudents);
        System.out.println("--------- Task 3 ---------");
        StudentService.printFemale50_4plus(allStudents);
        System.out.println("--------- Task 4 ---------");
        StudentService.printMinimalMarkStudents(allStudents);
        System.out.println("--------- Task 5 ---------");
        StudentService.printBiggestMaleStudent(allStudents);
        System.out.println("--------- Task 6 ---------");
        StudentService.PrintSortedByMark(allStudents);
        System.out.println("--------- Task 7 ---------");
        StudentService.printFemaleYearSorted(allStudents);
    }
}
