package Hw4_23001908_VuQuangNam.Bonus.ex9;

import java.util.ArrayList;
import java.util.Collections;
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
    ArrayList<Integer> noSibling(Node node) {
        List<Integer> list = new ArrayList<>();
        find(node, list);
        if (list.isEmpty()) {
            list.add(-1);
        }
        Collections.sort(list);
        return new ArrayList<>(list);
        // code here
    }

    private void find(Node node, List<Integer> list) {
        if (node == null) {
            return;
        }

        if (node.left != null && node.right == null) {
            list.add(node.left.data);
        }

        if (node.left == null && node.right != null) {
            list.add(node.right.data);
        }
        find(node.left, list);
        find(node.right, list);
    }

}