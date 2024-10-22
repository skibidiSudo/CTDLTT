package Hw4_23001908_VuQuangNam.Bonus.ex3;

class Node {
    int data;
    Node left, right;
}

class Tree {
    int countLeaves(Node node) {
        if (node == null) {
            return 0;
        }
        if (node.left == null && node.right == null) {
            return 1;
        }
        return countLeaves(node.left) + countLeaves(node.right);
    }
}