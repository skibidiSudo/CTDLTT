package Hw6_23001908_VuQuangNam.ex6.practice7;

class Solution {
    private final int[][] DIRECTIONS = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}, {1, 1}, {-1, -1}, {1, -1}, {-1, 1}};

    public int numIslands(char[][] grid) {
        int count = 0, m = grid.length, n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && grid[i][j] != '0') {
                    dfs(visited, grid, i, j);
                    count++;
                }
            }
        }
        return count;
        // Code here
    }

    private void dfs(boolean[][] visited, char[][] grid, int i, int j) {
        visited[i][j] = true;
        for (int[] direction : DIRECTIONS) {
            int r = i + direction[0];
            int c = j + direction[1];
            if (check(r, c, grid, visited)) {
                dfs(visited, grid, r, c);
            }
        }
    }

    private boolean check(int i, int j, char[][] grid, boolean[][] visited) {
        return i >= 0 && i < grid.length && j >= 0 && grid[0].length > j && grid[i][j] != '0' && !visited[i][j];
    }
}