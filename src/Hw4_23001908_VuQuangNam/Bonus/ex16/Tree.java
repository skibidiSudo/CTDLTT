package Hw4_23001908_VuQuangNam.Bonus.ex16;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

class Tree {
    public ArrayList<Integer> diagonal(Node root) {
        List<Integer> result = new ArrayList<>();
        Map<Integer, List<Integer>> map = new HashMap<>();
        search(root, 0, map);
        for (int i = 0; map.containsKey(i); i++) {
            result.addAll(map.get(i));
        }
        return new ArrayList<>(result);
        //add your code here.
    }

    public void search(Node node, int dep, Map<Integer, List<Integer>> map) {
        if (node == null) {
            return;
        }
        map.computeIfAbsent(dep, a -> new ArrayList<>()).add(node.data);
        search(node.left, dep + 1, map);
        search(node.right, dep, map);
    }
}
