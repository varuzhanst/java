package Day4.BubbleSorting;

public class Sorting {
    public static void main(String[] args) {
        int[] arr = {1, -3, 50, 0, 9, 8, -50, 10, 6};
        boolean isSorted = false;
        while (!isSorted) {
            isSorted=true;
            for (int i = 0; i < arr.length - 1; i++) {
                if (arr[i] > arr[i + 1]) {
                    int temp;
                    temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                    isSorted = false;
                }
            }

        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
    }
}
