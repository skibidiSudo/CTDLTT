package Hw4_23001908_VuQuangNam.Bonus.ex14;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Node {
    int data;
    Node left, right;

    Node(int item) {
        data = item;
        left = right = null;
    }
}

class Solution {
    //Function to return the level order traversal of a tree.
    static ArrayList<Integer> levelOrder(Node root) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        ArrayList<Integer> list = new ArrayList<>();
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            list.add(cur.data);
            if (cur.left != null) {
                queue.add(cur.left);
            }
            if (cur.right != null) {
                queue.add(cur.right);
            }
        }
        return list;
        // Your code here
    }
}
