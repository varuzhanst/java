package Day7;

import java.util.*;

public class TestStack {
    public static void main(String[] args) {
        int[] a = {1, 2, 5, 6, 8, 8};
        a = reverse(a);
        System.out.println(Arrays.toString(a));
    }



    public static int[] reverse(int[] ints) {

        java.util.Stack<Integer> integers = new java.util.Stack<>();

        for (int i = 0; i < ints.length; i++) {
            integers.push(ints[i]);

        }
        for (int i = 0; i < ints.length; i++) {
            ints[i] = integers.pop();

        }
        return ints;
    }
}
