import java.util.*;

public class Test {
    public static void main(String args[]) {
        String s = "[][][][]";
        System.out.println(isCorrect(s));

    }

    private static boolean isCorrect(String s) {
        Stack<Character> check = new Stack<>();
        char temp;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '[' || s.charAt(i) == '(' || s.charAt(i) == '{') {
                check.push(s.charAt(i));
            }
            if (s.charAt(i) == ']' || s.charAt(i) == ')' || s.charAt(i) == '}') {
                try {
                    temp = check.peek();
                } catch (EmptyStackException e) {
                    return false;
                }
                if (s.charAt(i) == ']' && temp == '[') check.pop();
                else if (s.charAt(i) == ')' && temp == '(') check.pop();
                else if (s.charAt(i) == '}' && temp == '{') check.pop();
                else return false;
            }

        }
        return check.empty();
    }


}
