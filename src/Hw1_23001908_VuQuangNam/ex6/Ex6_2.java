package Hw1_23001908_VuQuangNam.ex6;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Ex6_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        Integer[] nums = new Integer[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        Arrays.sort(nums, Collections.reverseOrder());
        System.out.println(nums[k - 1]);
    }
}
