package Hw4_23001908_VuQuangNam.Bonus.ex11;

import java.util.ArrayList;
import java.util.List;

class Node {
    int data;
    Node left, right;

    Node(int item) {
        data = item;
        left = right = null;
    }
}

class Solution {
    // Function to return a list containing the inorder traversal of the tree.
    ArrayList<Integer> inOrder(Node root) {
        List<Integer> list = new ArrayList<>();
        inOrder(root, list);
        return new ArrayList<>(list);
        // Code
    }

    private void inOrder(Node root, List<Integer> list) {
        if (root == null) {
            return;
        }
        inOrder(root.left, list);
        list.add(root.data);
        inOrder(root.right, list);
    }
}