package Day6.service;

import Day6.model.Student;

import java.io.IOException;

public class StudentService {
    public static Student[] generateStudentsFromTxt(String path) throws IOException {
        String[] std = FileService.readFile(path);
        Student[] student = new Student[std.length];
        for (int i = 0; i < std.length; i++) {
            String[] temp_student = std[i].split(",");
            student[i] = new Student(temp_student[0], temp_student[1], Integer.parseInt(temp_student[2]), temp_student[3].charAt(0), Double.parseDouble(temp_student[4]));

        }
        return student;
    }

    public static void printAllInfo(Student student) {
        System.out.println("Name:" + student.getName());
        System.out.println("Surname:" + student.getSurname());
        System.out.println("Year:" + student.getYear());
        System.out.println("Gender:" + student.getGender());
        System.out.println("Mark:" + student.getMark());
        System.out.println("*******");
    }

    // Task 1: Print full names of students

    public static void printFullName(Student[] student) {
        for (int i = 0; i < student.length; i++) {
            System.out.println("Full name : " + student[i].getName() + " " + student[i].getSurname());
        }
    }

    // Task 2: Print all male students
    public static void printMaleStudents(Student[] student) {
        for (int i = 0; i < student.length; i++) {
            if (student[i].getGender() == 'm') {
                printAllInfo(student[i]);
            }
        }
    }

    //Task 3: Print all female students who has mark greater then 50.4
    public static void printFemale50_4plus(Student[] student) {
        for (int i = 0; i < student.length; i++) {
            if (student[i].getGender() == 'f' && student[i].getMark() > 50.4) {
                printAllInfo(student[i]);
            }
        }
    }

    //Task 4: Print student information having the minimal mark
    public static void printMinimalMarkStudents(Student[] student) {
        double minMark = student[0].getMark();
        for (int i = 1; i < student.length; i++) {
            if (student[i].getMark() < minMark) {
                minMark = student[i].getMark();
            }
        }
        for (int i = 1; i < student.length; i++) {
            if (student[i].getMark() == minMark) {
                printAllInfo(student[i]);
            }
        }
    }

    // Task 5: Print biggest male student information
    public static void printBiggestMaleStudent(Student[] student) {
        int minYear = -1;
        int i = 0;
        for (; i < student.length; i++) {
            if (student[i].getGender() == 'm') {
                minYear = student[i].getYear();
                break;
            }
        }
        for (; i < student.length; i++) {
            if (student[i].getYear() < minYear && student[i].getGender() == 'm') {
                minYear = student[i].getYear();
            }
        }
        if (minYear == -1) {
            System.out.println("No male student found");
        } else {
            for (i = 0; i < student.length; i++) {
                if (student[i].getGender() == 'm' && student[i].getYear() == minYear) {
                    printAllInfo(student[i]);
                }
            }
        }


    }

    // Task 6: Print students sorted by mark

    public static void PrintSortedByMark(Student[] student) {
        double[][] temp_mark_ind = new double[student.length][2];
        for (int i = 0; i < student.length; i++) {
            temp_mark_ind[i][0] = i;
            temp_mark_ind[i][1] = student[i].getMark();
        }


        boolean isSorted = false;
        while (!isSorted) {
            isSorted = true;
            for (int i = 0; i < student.length - 1; i++) {
                if (temp_mark_ind[i][1] > temp_mark_ind[i + 1][1]) {
                    double temp_mark;
                    double temp_ind;
                    temp_mark = temp_mark_ind[i][1];
                    temp_ind = temp_mark_ind[i][0];
                    temp_mark_ind[i][1] = temp_mark_ind[i + 1][1];
                    temp_mark_ind[i][0] = temp_mark_ind[i + 1][0];
                    temp_mark_ind[i + 1][1] = temp_mark;
                    temp_mark_ind[i + 1][0] = temp_ind;
                    isSorted = false;
                }
            }

        }
        for (int i = 0; i < student.length; i++) {
            printAllInfo(student[(int) temp_mark_ind[i][0]]);
        }
    }

    //Task 7: Print female students sorted by year
    public static void printFemaleYearSorted(Student[] student) {
        int count = 0;
        for (int i = 0; i < student.length; i++) {
            if (student[i].getGender() == 'f')
                count++;
        }
        int[][] temp_year_ind = new int[count][2];
        for (int i = 0, ind = 0; i < student.length; i++) {
            if (student[i].getGender() == 'f'){
                temp_year_ind[ind][0] = i;
                temp_year_ind[ind][1] = student[i].getYear();
                ind++;
            }

        }


        boolean isSorted = false;
        while (!isSorted) {
            isSorted = true;
            for (int i = 0; i < count - 1; i++) {
                if (temp_year_ind[i][1] > temp_year_ind[i + 1][1]) {
                    int temp_year;
                    int temp_ind;
                    temp_year = temp_year_ind[i][1];
                    temp_ind = temp_year_ind[i][0];
                    temp_year_ind[i][1] = temp_year_ind[i + 1][1];
                    temp_year_ind[i][0] = temp_year_ind[i + 1][0];
                    temp_year_ind[i + 1][1] = temp_year;
                    temp_year_ind[i + 1][0] = temp_ind;
                    isSorted = false;
                }
            }

        }
        for (int i = 0; i < count ; i++) {
            printAllInfo(student[temp_year_ind[i][0]]);
        }


    }

}



