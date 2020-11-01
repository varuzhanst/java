package Day2;

/*
 *1. Arrays
 * */
public class Task2_2 {

    public static void main(String[] args) {
        int[] myArr = new int[2];
        myArr[0] = 10;
        myArr[1] = 25;
        System.out.println(myArr[0] + " " + myArr[1]);

        int l = 2;
        char[][] myArr2 = new char[2][l];
        myArr2[0][0] = 'T';
        myArr2[0][1] = 'E';
        myArr2[1][0] = 'S';
        myArr2[1][1] = 'T';
        System.out.println(myArr2[0][0] + " " + myArr2[0][1] + " " + myArr2[1][0] + " " + myArr2[1][1]);


    }
}
