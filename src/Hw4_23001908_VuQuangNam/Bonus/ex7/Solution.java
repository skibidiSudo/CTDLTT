package Hw4_23001908_VuQuangNam.Bonus.ex7;

class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

public class Solution {
    public void print(Node node) {
        if (node == null) {
            return;
        }
        if (node.left == null && node.right == null) {
            return;
        }
        System.out.print(node.data + " ");
        print(node.left);
        print(node.right);
    }
}
