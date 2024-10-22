package Hw3_23001908_VuQuangNam.ex1;

import java.util.Scanner;
import java.util.Stack;

public class StringCompression {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        compression(sc);
    }

    public static void compression(Scanner sc) {
        //System.out.println("Enter the string: ");
        String s = sc.nextLine();
        StringBuilder result = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (stack.isEmpty() || (c == stack.peek())) {
                stack.push(c);
            } else if (c != stack.peek()) {
                result.append(stack.peek()).append(stack.size());
                stack.clear();
                stack.push(c);
            }
        }
        result.append(stack.peek()).append(stack.size());
        //System.out.println("String after compression: " + result.toString());
        System.out.println(result.toString());
    }
}
