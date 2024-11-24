package Hw6_23001908_VuQuangNam.ex6.practice15;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    private final int[][] DIRECTIONS = {
            {1, 0}, {0, 1}, {-1, 0}, {0, -1}
    };

    public int[][] nearest(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] distances = new int[m][n];
        boolean[][] visited = new boolean[m][n];
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    queue.add(new int[]{i, j});
                    visited[i][j] = true;
                    distances[i][j] = 0;
                } else {
                    distances[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int x = cell[0], y = cell[1];
            for (int[] direction : DIRECTIONS) {
                int newX = x + direction[0];
                int newY = y + direction[1];
                if (newX >= 0 && newX < m && newY >= 0 && newY < n && !visited[newX][newY]) {
                    visited[newX][newY] = true;
                    distances[newX][newY] = distances[x][y] + 1;
                    queue.add(new int[]{newX, newY});
                }
            }
        }

        return distances;
    }
}

