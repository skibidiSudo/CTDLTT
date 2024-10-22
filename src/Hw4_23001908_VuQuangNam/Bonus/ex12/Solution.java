package Hw4_23001908_VuQuangNam.Bonus.ex12;

import java.util.ArrayList;
import java.util.List;

class Node {
    int data;
    Node left, right;

    Node(int d) {
        data = d;
        left = right = null;
    }
}

class BinaryTree {
    //Function to return a list containing the preorder traversal of the tree.
    static ArrayList<Integer> preorder(Node root) {
        List<Integer> list = new ArrayList<>();
        preOrder(root, list);
        return new ArrayList<>(list);
        // Code here
    }

    private static void preOrder(Node root, List<Integer> list) {
        if (root == null) {
            return;
        }
        list.add(root.data);
        preOrder(root.left, list);
        preOrder(root.right, list);
    }

}
