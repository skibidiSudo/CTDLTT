package Hw1_23001908_VuQuangNam.ex7;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Ex7 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int x = scanner.nextInt();
        int[] A = new int[n];
        for (int i = 0; i < n; i++) {
            A[i] = scanner.nextInt();
        }

        Map<Integer, Integer> countMap = new HashMap<>();
        int pairCount = 0;

        for (int num : A) {
            int complement = x - num;
            if (countMap.containsKey(complement)) {
                pairCount += countMap.get(complement);
            }
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }
        System.out.println(pairCount);
    }
}
