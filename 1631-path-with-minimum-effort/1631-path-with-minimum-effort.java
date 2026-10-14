import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {
    private static final int[][] DIRS = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int minimumEffortPath(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;

        // effort[r][c] stores the minimum effort required to reach cell (r, c)
        int[][] effort = new int[m][n];
        for (int[] row : effort) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        // Min-heap storing [currentEffort, row, col]
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));

        effort[0][0] = 0;
        pq.offer(new int[]{0, 0, 0});

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int curEffort = curr[0];
            int r = curr[1];
            int c = curr[2];

            // Reached destination with optimal effort
            if (r == m - 1 && c == n - 1) {
                return curEffort;
            }

            // Skip if a path with lower effort to this cell has already been explored
            if (curEffort > effort[r][c]) {
                continue;
            }

            for (int[] d : DIRS) {
                int nr = r + d[0];
                int nc = c + d[1];

                if (nr >= 0 && nr < m && nc >= 0 && nc < n) {
                    int nextEffort = Math.max(curEffort, Math.abs(heights[nr][nc] - heights[r][c]));

                    if (nextEffort < effort[nr][nc]) {
                        effort[nr][nc] = nextEffort;
                        pq.offer(new int[]{nextEffort, nr, nc});
                    }
                }
            }
        }

        return 0;
    }
}