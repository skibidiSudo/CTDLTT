package Hw4_23001908_VuQuangNam.Exercise.ex3;

import Hw4_23001908_VuQuangNam.Exercise.ex1.LinkedBinaryTree;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        Convert convert = new Convert();

        String[] tokens = {"(", "6", "/", "3", "+", "2", ")", "*", "(", "7", "-", "4", ")"};
        System.out.print("Expression: ");
        print(tokens);

        System.out.println("Infix to Suffix:");
        String[] suffix = convert.infixToSuffix(tokens);
        print(suffix);

        System.out.println("Infix to Prefix:");
        String[] prefix = convert.infixToPrefix(tokens);
        print(prefix);

        System.out.print("Build tree: ");
        LinkedBinaryTree.Node<String> root = convert.buildBinaryTree(tokens);
        System.out.println("Complete!!!");

        System.out.println("Tree:");
        printTree(root);
    }

    private static void printTree(LinkedBinaryTree.Node<String> root) {
        printTree(root, 0);
    }

    private static void printTree(LinkedBinaryTree.Node<String> node, int depth) {
        if (node != null) {
            printTree(node.getRight(), depth + 1);
            for (int i = 0; i < depth; i++) {
                System.out.print("   ");
            }
            System.out.println(node.getElement());
            printTree(node.getLeft(), depth + 1);
        }
    }

    private static void print(String[] tokens) {
        for (String token : tokens) {
            System.out.print(token + " ");
        }
        System.out.println();
    }
}
