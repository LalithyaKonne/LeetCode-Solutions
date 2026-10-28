import java.util.ArrayDeque;
import java.util.Queue;

class Solution {
    public int minCost(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        // visited[r][c][xor] tracks if (r, c) was reached with that XOR
        boolean[][][] visited = new boolean[m][n][1024];
        
        Queue<int[]> queue = new ArrayDeque<>();
        int startVal = grid[0][0];
        visited[0][0][startVal] = true;
        queue.offer(new int[]{0, 0, startVal});

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int r = curr[0];
            int c = curr[1];
            int xor = curr[2];

            // Move Right
            if (c + 1 < n) {
                int nextXor = xor ^ grid[r][c + 1];
                if (!visited[r][c + 1][nextXor]) {
                    visited[r][c + 1][nextXor] = true;
                    queue.offer(new int[]{r, c + 1, nextXor});
                }
            }

            // Move Down
            if (r + 1 < m) {
                int nextXor = xor ^ grid[r + 1][c];
                if (!visited[r + 1][c][nextXor]) {
                    visited[r + 1][c][nextXor] = true;
                    queue.offer(new int[]{r + 1, c, nextXor});
                }
            }
        }

        // Find the smallest XOR reached at (m - 1, n - 1)
        for (int x = 0; x < 1024; x++) {
            if (visited[m - 1][n - 1][x]) {
                return x;
            }
        }

        return -1;
    }
}