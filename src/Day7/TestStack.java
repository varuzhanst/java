package Day7;

import java.util.*;

public class TestStack {
    public static void main(String[] args) {
        //Task: reverse the order of array
        int[] ints = {1, 2, 3, 4};
        java.util.Stack<Integer> integers = new java.util.Stack<>();
        System.out.print("Before:");

        for (int x : ints) {
            System.out.print(x+" ");
        }
        System.out.println("\nPushing items to Stack");
        for (int i = 0; i < ints.length; i++) {
            integers.push(ints[i]);
            System.out.println("Stack : " + integers);
        }
        System.out.println("Popping items from Stack");
        for (int i = 0; i < ints.length; i++) {
            ints[i] = integers.pop();
            System.out.println("Stack : " + integers);
        }
        System.out.println("Is stack empty? " + integers.empty());
        System.out.print("After:");

        for (int x : ints) {
            System.out.print(x+" ");
        }
        //show the LinkedHashSet in reverse order
        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>(Arrays.asList("Hello", "and", "Welcome"));
        System.out.println();
        System.out.println(linkedHashSet);
        Stack<String> stringStack = new Stack<>();
        Iterator iterator = linkedHashSet.iterator();
        while(iterator.hasNext()){
            stringStack.push((String)iterator.next());
        }
        while(!stringStack.empty()){
            System.out.println(stringStack.pop());
        }
    }
}
