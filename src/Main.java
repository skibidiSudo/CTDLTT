import java.util.ArrayList;
import java.util.List;

public class Main {
    private final int[][] DIRECTIONS = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public Iterable<int[][]> neighbors(int[][] m) {
        List<int[][]> result = new ArrayList<>();
        int r = -1, c = -1;
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[0].length; j++) {
                if (m[i][j] == 0) {
                    r = i;
                    c = j;
                    break;
                }
            }
            if (r != -1) {
                break;
            }
        }
        for (int[] direction : DIRECTIONS) {
            int newR = r + direction[0];
            int newC = c + direction[1];
            if (0 <= newR && newR < m.length && 0 <= newC && newC < m[0].length) {
                int[][] copy = copy(m);
                copy[r][c] = copy[newR][newC];
                copy[newR][newC] = 0;
                result.add(copy);
            }
        }
        return result;
    }

    private int[][] copy(int[][] m) {
        int[][] copy = new int[m.length][m[0].length];
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[0].length; j++) {
                copy[i][j] = m[i][j];
            }
        }
        return copy;
    }

}