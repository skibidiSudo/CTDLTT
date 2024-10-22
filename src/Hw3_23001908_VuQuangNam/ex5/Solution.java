package Hw3_23001908_VuQuangNam.ex5;

import java.util.Stack;

class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String s : tokens) {
            if (isDigit(s)) {
                stack.push(Integer.parseInt(s));
            } else {
                int x = stack.pop();
                int y = stack.pop();

                if (s.equals("+")) {
                    stack.push(y + x);
                } else if (s.equals("-")) {
                    stack.push(y - x);
                } else if (s.equals("*")) {
                    stack.push(y * x);
                } else if (s.equals("/")) {
                    stack.push(y / x);
                }
            }
        }
        return stack.pop();
    }

    private boolean isDigit(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
