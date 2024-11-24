package Hw6_23001908_VuQuangNam.ex6.practice8;

class Solution {
    private int[][] image;
    private int originalColor;
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        this.image = image;
        this.originalColor = image[sr][sc];
        if (originalColor == newColor) {
            return this.image;
        }
        boolean[][] visited = new boolean[image.length][image[0].length];
        dfs(sr, sc, newColor, visited);
        return this.image;
    }

    private final int[][] DIRECTIONS = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    private void dfs(int r, int c, int newColor, boolean[][] visited) {
        if (r < 0 || r >= image.length || c < 0 || c >= image[0].length || visited[r][c] || image[r][c] != originalColor) {
            return;
        }
        visited[r][c] = true;
        image[r][c] = newColor;
        for (int[] direction : DIRECTIONS) {
            dfs(r + direction[0], c + direction[1], newColor, visited);
        }
    }
}
