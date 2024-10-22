package Hw4_23001908_VuQuangNam.Bonus.ex15;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Node
{
    int data;
    Node left,right;
    Node(int d)
    {
        data=d;
        left=right=null;
    }
}

class GFG
{
    //Function to store the zig zag order traversal of tree in a list.
    ArrayList<Integer> zigZagTraversal(Node root)
    {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> result = new ArrayList<>();
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        boolean check = true;
        while (!q.isEmpty()) {
            List<Integer> node = new ArrayList<>();
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Node n = q.poll();
                if (check) {
                    node.add(n.data);
                } else {
                    node.add(0, n.data);
                }

                if (n.left != null) {
                    q.add(n.left);
                }
                if (n.right != null) {
                    q.add(n.right);
                }
            }
            for (int i = 0; i < node.size(); i++) {
                result.add(node.get(i));
            }
            check = !check;
        }
        return new ArrayList<>(result);
    }
}
