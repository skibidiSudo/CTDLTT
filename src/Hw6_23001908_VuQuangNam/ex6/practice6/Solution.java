package Hw6_23001908_VuQuangNam.ex6.practice6;

import java.util.ArrayList;

class Solution {
    // Function to detect cycle in a directed graph.
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        // code here
        int[] visited = new int[V];  //0 - Unvisited, 1 - Visiting, 2 - Visited
        for (int i = 0; i < V; i++) {
            if (visited[i] == 0) {
                if (dfs(i, adj, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(int node, ArrayList<ArrayList<Integer>> adj, int[] visited) {
        visited[node] = 1;
        for (int neighbor : adj.get(node)) {
            if (visited[neighbor] == 1) {
                return true;
            } else if (visited[neighbor] == 0) {
                if (dfs(neighbor, adj, visited)) {
                    return true;
                }
            }
        }
        visited[node] = 2;
        return false;
    }
}
