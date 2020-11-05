package Day3;

public class Homework {
    public static void main(String[] args) {

        System.out.println("Task 1\n" + "Create an array and fill it with 2 number");
        int[] arr1 = new int[10];
        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = 2;
        }

        System.out.println("Task 2\n" + "Create an array and fill it with numbers from 1:1000");
        int[] arr2 = new int[1000];
        for (int i = 0; i < arr2.length; i++) {
            arr2[i] = i + 1;
        }

        System.out.println("Task 3\n" + "Create an array and fill it with odd numbers from -20:20");
        int[] arr3 = new int[20];
        for (int i = 0, j = -19; i < arr3.length; i++, j += 2) {
            arr3[i] = j;
        }

        System.out.println("Task 4\n" + "Create an array and fill it. Print all elements which can be divided by 5.");
        int[] arr4 = {-1, -5, 8, 100, 21, 56, -45, 9, -8, 120};
        for (int i = 0; i < arr4.length; i++) {
            if (arr4[i] % 5 == 0) {
                System.out.print(arr4[i] + " ");
            }
        }
        System.out.println();

        System.out.println("Task 5\n" +
                "Create an array and fill it. Print all elements which are between 24.12 and 467.23");
        int[] arr5 = {20, -5, 26, 100, 210, 560, -450, 90, 38, 120};
        for (int i = 0; i < arr5.length; i++) {
            if (arr5[i] > 24.12 && arr5[i] < 467.23) {
                System.out.print(arr5[i] + " ");
            }
        }
        System.out.println();

        System.out.println("Task 6\n" +
                "Create an array and fill it. Print count of elements which can be divided by 2");
        int[] arr6 = {11, -25, 38, 100, 21, 56, -145, 9, -8, 120};
        int count = 0;
        for (int i = 0; i < arr6.length; i++) {
            if (arr6[i] % 2 == 0) {
                count++;
            }
        }
        System.out.println("Count : " + count);

        System.out.println("Task 7\n" + "Given an integer, 0< N < 21 , print its first 10 multiples. \n" +
                "Each multiple  N x i (where 0<i<11) should be printed on a new line in the form: N x i = result.");

        int N = 11;
        for (int i = 1; i < 11; i++) {
            System.out.println(i + " x " + N + " = " + (i*N));
        }
    }
}
