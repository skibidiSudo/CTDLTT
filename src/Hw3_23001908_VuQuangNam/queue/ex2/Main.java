package Hw3_23001908_VuQuangNam.queue.ex2;

import Hw3_23001908_VuQuangNam.queue.ex1.ArrayQueue;
import Hw3_23001908_VuQuangNam.stack.ex2.ArrayStack;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(isPalindrome(sc));
    }

    public static boolean isPalindrome(Scanner sc) {
        System.out.println("Enter the string: ");
        String s = sc.nextLine();
        ArrayStack<Character> arrayStack = new ArrayStack<>();
        ArrayQueue<Character> arrayQueue = new ArrayQueue<>();
        for (char c : s.toCharArray()) {
            arrayStack.push(c);
            arrayQueue.enqueue(c);
        }
        while (!arrayQueue.isEmpty() && !arrayQueue.isEmpty()) {
            if (arrayQueue.dequeue() != arrayStack.pop()) {
                return false;
            }
        }
        return true;
    }
}
