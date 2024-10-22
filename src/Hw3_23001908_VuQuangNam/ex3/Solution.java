package Hw3_23001908_VuQuangNam.ex3;

import java.util.Stack;

public class Solution {
    public void deleteMid(Stack<Integer> s, int sizeOfStack) {
        int mid = sizeOfStack / 2;
        Stack<Integer> stack = new Stack<>();
        while (mid-- > 0) {
            stack.add(s.pop());
        }
        s.pop();
        while (!stack.isEmpty()) {
            s.push(stack.pop());
        }
    }
}
