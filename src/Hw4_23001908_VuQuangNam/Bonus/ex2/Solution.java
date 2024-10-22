package Hw4_23001908_VuQuangNam.Bonus.ex2;

class Node {
    int data;
    Node left, right;

    public Node(int data) {
        this.data = data;
        left = right = null;
    }
}

public class Solution {
    private int height = -1;

    public int findDepth(Node root, int x) {
        if (root == null) {
            return -1;
        }
        if (root.data == x) {
            return 0;
        }

        int leftDepth = findDepth(root.left, x);
        int rightDepth = findDepth(root.right, x);

        if (leftDepth >= 0) {
            return leftDepth + 1;
        } else if (rightDepth >= 0) {
            return rightDepth + 1;
        }

        return -1;
    }

    public int findHeight(Node root, int x) {
        if (root == null) {
            return -1;
        }
        int left = findHeight(root.left, x);
        int right = findHeight(root.right, x);
        int temp = Math.max(left, right) + 1;
        if (root.data == x) {
            height = temp;
        }
        return temp;
    }
}
