package Hw4_23001908_VuQuangNam.Exercise.ex2;

import Hw4_23001908_VuQuangNam.Exercise.ex1.LinkedBinaryTree;

import java.util.PriorityQueue;

public class ExpressionTree<E> extends LinkedBinaryTree {
    public void preOrderPrint(Node<E> p) {
        if (p == null) {
            return;
        }
        System.out.print(p.getElement() + " ");
        preOrderPrint(p.getLeft());
        preOrderPrint(p.getRight());
    }

    public void postOrderPrint(Node<E> p) {
        if (p == null) {
            return;
        }
        postOrderPrint(p.getLeft());
        postOrderPrint(p.getRight());
        System.out.print(p.getElement() + " ");
    }

    public void inOrderPrint(Node<E> p) {
        if (p == null) {
            return;
        }
        inOrderPrint(p.getLeft());
        System.out.print(p.getElement() + " ");
        inOrderPrint(p.getRight());
    }

    public double cal(Node<E> node) {
        if (node == null) {
            return 0;
        }
        if (node.getLeft() == null && node.getRight() == null) {
            return Double.parseDouble((String) node.getElement());
        }

        double left = cal(node.getLeft());
        double right = cal(node.getRight());

        switch ((String) node.getElement()) {
            case "+":
                return left + right;
            case "-":
                return left - right;
            case "*":
                return left * right;
            case "/":
                return left / right;
            default:
                throw new IllegalArgumentException("Toán tử không hợp lệ: " +node.getElement());
        }
    }
}

