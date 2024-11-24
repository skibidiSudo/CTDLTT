package Hw6_23001908_VuQuangNam.ex6.practice12;

import java.util.*;

class Solution {
    public boolean isBipartite(ArrayList<ArrayList<Integer>> adj) {
        int n = adj.size();
        int[] colors = new int[n]; // 0 = chưa tô , 1 = A, -1 = B
        for (int i = 0; i < n; i++) {
            if (colors[i] == 0) {
                if (!bfsCheck(i, adj, colors)) {
                    return false;
                }
            }
        }

        return true;
    }

    private boolean bfsCheck(int start, ArrayList<ArrayList<Integer>> adj, int[] colors) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        colors[start] = 1;
        while (!queue.isEmpty()) {
            int node = queue.poll();
            int currentColor = colors[node];
            int nextColor = -currentColor;
            for (int neighbor : adj.get(node)) {
                if (colors[neighbor] == 0) {
                    colors[neighbor] = nextColor;
                    queue.add(neighbor);
                } else if (colors[neighbor] == currentColor) {
                    return false;
                }
            }
        }
        return true;
    }
}
