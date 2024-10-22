package Hw3_23001908_VuQuangNam.ex1;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class PhoneDisplay {
    public static void main(String[] args) {
        solve();
    }

    public static void solve() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] phone = new int[n];
        for (int i = 0; i < n; i++) {
            phone[i] = sc.nextInt();
        }
        int k = sc.nextInt();
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (!queue.contains(phone[i])) {
                queue.add(phone[i]);
            }
            if (queue.size() > k) {
                queue.poll();
            }
        }
        while (!queue.isEmpty()) {
            System.out.print(queue.poll() + " ");
        }
    }
}
