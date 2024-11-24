package Hw6_23001908_VuQuangNam.ex6.practice4;

import java.util.*;

public class Solution {
    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        List<Integer> list = new ArrayList<>();
        boolean[] visited = new boolean[V];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        while (!queue.isEmpty()) {
            int node = queue.poll();
            if (!visited[node]) {
                visited[node] = true;
                list.add(node);
            }
            for (int i = 0; i < adj.get(node).size(); i++) {
                int nei = adj.get(node).get(i);
                if (!visited[nei]) {
                    queue.add(nei);
                }
            }
        }
        return (ArrayList<Integer>) list;
        // code here
    }
}
