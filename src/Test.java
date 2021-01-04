import java.util.*;

public class Test {
    public static long calculate(int a) {
        long result = 0;
        result += Math.pow((1 - a), 2);
        result += Math.pow((2 - a), 2);
        result += Math.pow((4 - a), 2);
        result += Math.pow((5 - a), 2);
        result += Math.pow((6 - a), 2);
        result += Math.pow((5 - a), 2);
        result += Math.pow((10 - a), 2);
        result += Math.pow((9 - a), 2);
        result += Math.pow((10 - a), 2);
        result += Math.pow((18 - a), 2);
        return result;
    }

    public static void main(String args[]) {
        HashMap<Long, Integer> results = new HashMap<>();
        for (int i = -100; i <= 100; i++) {
            results.put(calculate(i), i);
        }
        Set<Long> longs = results.keySet();
        Iterator<Long> iterator = longs.iterator();
        long min = iterator.next();
        while (iterator.hasNext()) {
            long next = iterator.next();
            if (next < min) min = next;
        }
        System.out.println(min + " " + results.get(min));


    }


}
