package Hw4_23001908_VuQuangNam.Exercise.ex3;

import Hw4_23001908_VuQuangNam.Exercise.ex1.LinkedBinaryTree;

import java.util.Stack;

public class Convert {
    public String[] infixToSuffix(String[] tokens) {
        StringBuilder suf = new StringBuilder();
        Stack<String> stack = new Stack<>();
        for (String token : tokens) {
            if (Character.isDigit(token.charAt(0))) {
                suf.append(token).append(" ");
            }
            if (token.equals("(")) {
                stack.push(token);
            }
            if (token.equals(")")) {
                while (!stack.isEmpty() && !stack.peek().equals("(")) {
                    suf.append(stack.pop()).append(" ");
                }
                stack.pop();
            }
            if (check(token)) {
                while (!stack.isEmpty() && precedence(stack.peek()) >= precedence(token)) {
                    suf.append(stack.pop()).append(" ");
                }
                stack.push(token);
            }
        }
        while (!stack.isEmpty()) {
            suf.append(stack.pop()).append(" ");
        }
        return suf.toString().trim().split("\\s+");
    }

    public String[] infixToPrefix(String[] tokens) {
        Stack<String> stack = new Stack<>();
        StringBuilder prefix = new StringBuilder();

        for (int i = tokens.length - 1; i >= 0; i--) {
            String token = tokens[i];
            if (Character.isDigit(token.charAt(0))) {
                prefix.append(token).append(" ");
            }
            else if (token.equals(")")) {
                stack.push(token);
            }
            else if (token.equals("(")) {
                while (!stack.isEmpty() && !stack.peek().equals(")")) {
                    prefix.append(stack.pop()).append(" ");
                }
                stack.pop();
            }
            else {
                while (!stack.isEmpty() && precedence(stack.peek()) > precedence(token)) {
                    prefix.append(stack.pop()).append(" ");
                }
                stack.push(token);
            }
        }
        while (!stack.isEmpty()) {
            prefix.append(stack.pop()).append(" ");
        }
        return prefix.reverse().toString().trim().split("\\s+");
    }

    public LinkedBinaryTree.Node<String> buildBinaryTree(String[] tokens) {
        String[] suf = infixToSuffix(tokens);
        Stack<LinkedBinaryTree.Node<String>> stack = new Stack<>();
        for (String s : suf) {
            LinkedBinaryTree.Node<String> node = new LinkedBinaryTree.Node<>(s, null, null, null);
            if (Character.isDigit(s.charAt(0))) {
                stack.push(node);
            }
            if (check(s)) {
                LinkedBinaryTree.Node<String> rightChild = null;
                LinkedBinaryTree.Node<String> leftChild = null;
                if (!stack.isEmpty()) {
                    rightChild = stack.pop();
                }
                if (!stack.isEmpty()) {
                    leftChild = stack.pop();
                }
                node.setLeft(leftChild);
                node.setRight(rightChild);
                stack.push(node);
            }
        }
        return stack.pop();
    }


    private boolean check (String s) {
        return s.equals("*") || s.equals("/") || s.equals("+") || s.equals("-");
    }

    public int precedence(String op) {
        if (op.equals("+") || op.equals("-")) {
            return 1;
        }
        if (op.equals("*") || op.equals("/")) {
            return 2;
        }
        if (op.equals("^")) {
            return 3;
        }
        return -1;
    }
}
