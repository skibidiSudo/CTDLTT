package Hw4_23001908_VuQuangNam.Bonus.ex13;

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

class Tree {
    //Function to return a list containing the postorder traversal of the tree.
    ArrayList<Integer> postOrder(Node root) {
        List<Integer> list = new ArrayList<>();
        postOrder(root, list);
        return new ArrayList<>(list);
        // Code
    }

    private void postOrder(Node root, List<Integer> list) {
        if (root == null) {
            return;
        }
        postOrder(root.left, list);
        postOrder(root.right, list);
        list.add(root.data);
    }
}
