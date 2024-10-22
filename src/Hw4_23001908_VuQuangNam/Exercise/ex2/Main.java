package Hw4_23001908_VuQuangNam.Exercise.ex2;

import Hw4_23001908_VuQuangNam.Exercise.ex1.LinkedBinaryTree;

public class Main {
    public static void main(String[] args) {
        ExpressionTree<String> expTree = new ExpressionTree<>();

        LinkedBinaryTree.Node<String> root = expTree.addRoot("/");
        LinkedBinaryTree.Node<String> leftChild = expTree.addLeft(root, "+");
        LinkedBinaryTree.Node<String> leftLeftChild = expTree.addLeft(leftChild, "*");
        expTree.addLeft(leftLeftChild, "3");
        expTree.addRight(leftLeftChild, "4");
        LinkedBinaryTree.Node<String> rightLeftChild = expTree.addRight(leftChild, "-");
        expTree.addLeft(rightLeftChild, "5");
        expTree.addRight(rightLeftChild, "2");
        expTree.addRight(root, "7");

        System.out.println("Expression: ((3 * 4) + (5 - 2)) / 7");
        System.out.println("Pre order:");
        expTree.preOrderPrint(root);

        System.out.println("\nIn order:");
        expTree.inOrderPrint(root);

        System.out.println("\nPost order:");
        expTree.postOrderPrint(root);

        System.out.println("\nValue: " + expTree.cal(root));
    }
}
