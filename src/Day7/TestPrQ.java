package Day7;

import java.util.Collections;
import java.util.Iterator;
import java.util.PriorityQueue;

public class TestPrQ {
    public static void main(String[] args) {
        PriorityQueue<Integer> integerPriorityQueue = new PriorityQueue<>(Collections.reverseOrder());
        integerPriorityQueue.add(10);
        integerPriorityQueue.add(30);
        integerPriorityQueue.add(22);
        integerPriorityQueue.add(51);
        integerPriorityQueue.add(48);
        Iterator iterator = integerPriorityQueue.iterator();
        while(iterator.hasNext()){
            int next =(Integer) iterator.next();
            System.out.println(next);
        }
        System.out.println("------");
        int size=integerPriorityQueue.size();
        for(int i=0;i<size;i++){
            System.out.println(integerPriorityQueue.poll());
        }


    }
}
