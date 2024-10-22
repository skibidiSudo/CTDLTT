package Hw4_23001908_VuQuangNam.Bonus.ex8;

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

class Solution {
    int min = Integer.MAX_VALUE;

    int minDepth(Node root) {
        count(root, 0);
        return min + 1;
        //code here
    }

    private void count(Node node, int c) {
        if (node == null) {
            return;
        }
        if (node.left == null && node.right == null) {
            min = Math.min(min, c);
        }
        count(node.left, c + 1);
        count(node.right, c + 1);
    }
}
