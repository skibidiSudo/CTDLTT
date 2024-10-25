package Hw5_23001908_VuQuangNam.ex4;

import Hw5_23001908_VuQuangNam.ex1.*;

import java.io.IOException;
import java.util.Random;

public class Test {
    public static void run(PriorityQueueInterface<Integer, String> pq, int n) throws IOException {
        //Random rand = new Random();
        long startTime, endTime;

        startTime = System.nanoTime();
        for (int i = 0; i < n; i++) {
            pq.insert(i, "Value" + i);
        }
        endTime = System.nanoTime();
        long insertTime = (endTime - startTime) / 1000000;
        System.out.println("Insert " + n + " elements: " + insertTime + " ms");

        startTime = System.nanoTime();
        pq.removeMin();
        endTime = System.nanoTime();
        long removeMinTime = (endTime - startTime) / 1000000;
        System.out.println("RemoveMin " + n + " elements: " + removeMinTime + " ms");
    }

    public static void main(String[] args) throws IOException {
        int[] ns = {1000, 10000, 100000, 1000000, 10000000};

        for (int n : ns) {
            System.out.println("n = " + n);
            System.out.println("Sorted Linked Priority Queue:");
            run(new SortedLinkedPriorityQueue<>(), n);
        }

        //System.out.println("Unsorted Array Priority Queue:");
        //run(new UnsortedArrayPriorityQueue<>(), 1);

        //System.out.println("Sorted Array Priority Queue:");
        //run(new SortedArrayPriorityQueue<>(), 1);

        //System.out.println("Unsorted Linked Priority Queue:");
        //run(new UnsortedLinkedPriorityQueue<>(), 1);

    }
}
