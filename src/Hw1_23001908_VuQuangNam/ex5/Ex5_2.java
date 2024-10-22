package Hw1_23001908_VuQuangNam.ex5;

import java.util.Scanner;

public class Ex5_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (nums[i] < nums[j]) {
                    int foo = nums[i];
                    nums[i] = nums[j];
                    nums[j] = foo;
                }
            }
        }

        for (int num : nums) {
            System.out.println(num + " ");
        }
    }
}
