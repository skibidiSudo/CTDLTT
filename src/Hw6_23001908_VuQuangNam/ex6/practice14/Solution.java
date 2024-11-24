package Hw6_23001908_VuQuangNam.ex6.practice14;

class Solution {
    private final int[][] DIRECTION = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}, {1, 1}, {-1, -1}, {1, -1}, {-1, 1}};
    private int ans = 0;
    //Function to find unit area of the largest region of 1s.
    public int findMaxArea(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] != 0 && !visited[i][j]) {
                    int count = dfs(grid, visited, i, j);
                    ans = Math.max(ans, count);
                }
            }
        }
        return ans;
        // Code here
    }

    private int dfs(int[][] grid, boolean[][] visited, int i, int j) {
        if (0 > i || i >= grid.length || 0 > j || j >= grid[0].length || grid[i][j] == 0 || visited[i][j]) {
            return 0;
        }
        visited[i][j] = true;
        int count = 1;
        for (int[] direction : DIRECTION) {
            int newI = i + direction[0], newJ = j + direction[1];
            count += dfs(grid, visited, newI, newJ);
        }
        return count;
    }
}