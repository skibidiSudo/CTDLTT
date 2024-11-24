package Hw6_23001908_VuQuangNam.ex6.practice11;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    boolean check(int N, int M, ArrayList<ArrayList<Integer>> Edges) {
        int[][] adjMatrix = new int[N][N];
        for (ArrayList<Integer> edge : Edges) {
            int u = edge.get(0) - 1, v = edge.get(1) - 1;
            adjMatrix[u][v] = adjMatrix[v][u] = 1;
        }
        boolean[] visited = new boolean[N];
        //N = so dinh, M = co canh
        for (int i = 0; i < N; i++) {
            if (backtrack(1, visited, adjMatrix, i, N)) {
                return true;
            }
        }
        return false;
        // code here
    }

    private boolean backtrack(int count, boolean[] visited, int[][] adjMatrix, int i, int N) {
        if (count == N) return true;
        visited[i] = true;
        for (int neighbor = 0; neighbor < N; neighbor++) {
            if (adjMatrix[i][neighbor] == 1 && !visited[neighbor]) {
                if (backtrack(count + 1, visited, adjMatrix, neighbor, N)) {
                    return true;
                }
            }
        }
        visited[i] = false;
        return false;
    }
}
