package Hw3_23001908_VuQuangNam.stack.ex3;

import Hw3_23001908_VuQuangNam.stack.ex2.ArrayStack;
import Hw3_23001908_VuQuangNam.stack.ex2.LinkedListStack;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //System.out.println(isValid(sc));
        //cal(sc);
    }

    public static boolean isValid(Scanner sc) {
        LinkedListStack<Character> linkedListStack = new LinkedListStack<>();
        System.out.println("Enter the expression: ");
        String exp = sc.nextLine();
        for (char c : exp.toCharArray()) {
            if (c == '(') {
                linkedListStack.push(c);
            }
            if (c == ')') {
                if (linkedListStack.isEmpty()) {
                    return false;
                }
                linkedListStack.pop();
            }
        }
        return linkedListStack.isEmpty();
    }

    public static boolean isValid(String exp) {
        LinkedListStack<Character> linkedListStack = new LinkedListStack<>();
        for (char c : exp.toCharArray()) {
            if (c == '(') {
                linkedListStack.push(c);
            }
            if (c == ')') {
                if (linkedListStack.isEmpty()) {
                    return false;
                }
                linkedListStack.pop();
            }
        }
        return linkedListStack.isEmpty();
    }

    public static void cal(Scanner sc) {
        System.out.println("Enter the expression: ");
        String express = sc.nextLine();
        String exp = express.replaceAll(" ", "")
                .replace('−', '-')
                .replace('∗', '*');
        if (isValid(exp)) {
            LinkedListStack<Double> num = new LinkedListStack<>();
            ArrayStack<Character> sign = new ArrayStack<>();
            for (int i = 0; i < exp.length(); i++) {
                char e = exp.charAt(i);
                if (Character.isDigit(e)) {
                    StringBuilder sb = new StringBuilder();
                    while (i < exp.length() && (Character.isDigit(exp.charAt(i)) || exp.charAt(i) == '.')) {
                        sb.append(exp.charAt(i++));
                    }
                    num.push(Double.parseDouble(sb.toString()));
                    i--;
                } else if (e == '(') {
                    sign.push(e);
                } else if (e == ')') {
                    while (!sign.isEmpty() && sign.top() != '(') {
                        double num2 = num.pop();
                        double num1 = num.pop();
                        num.push(number(num1, num2, sign.pop()));
                    }
                    sign.pop();
                } else if (e == '*' || e == '/' || e == '+' || e == '-') {
                    sign.push(e);
                }
            }
            while (!sign.isEmpty()) {
                double num2 = num.pop();
                double num1 = num.pop();
                num.push(number(num1, num2, sign.pop()));
            }
            System.out.println("Result: " + num.pop());
            return;
        }
        System.out.println("Expression not valid!");
    }

    public static double number(double n1, double n2, char sign) {
        switch (sign) {
            case '*': return n1 * n2;
            case '/': return n1 / n2;
            case '+': return n1 + n2;
            case '-': return n1 - n2;
            default: throw new IllegalArgumentException("Invalid operator");
        }
    }

}
