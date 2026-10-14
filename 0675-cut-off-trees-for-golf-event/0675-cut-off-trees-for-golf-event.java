import java.util.*;

class Solution {
    private static final int[][] DIRS = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int cutOffTree(List<List<Integer>> forest) {
        int m = forest.size();
        int n = forest.get(0).size();

        // Collect all trees: [height, row, col]
        List<int[]> trees = new ArrayList<>();
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                int height = forest.get(r).get(c);
                if (height > 1) {
                    trees.add(new int[]{height, r, c});
                }
            }
        }

        // Sort trees strictly by height
        trees.sort(Comparator.comparingInt(a -> a[0]));

        int totalSteps = 0;
        int curR = 0, curC = 0;

        for (int[] tree : trees) {
            int targetR = tree[1];
            int targetC = tree[2];

            int steps = bfs(forest, curR, curC, targetR, targetC, m, n);
            if (steps == -1) {
                return -1; // Cannot reach this tree
            }

            totalSteps += steps;
            curR = targetR;
            curC = targetC;
        }

        return totalSteps;
    }

    private int bfs(List<List<Integer>> forest, int startR, int startC, int targetR, int targetC, int m, int n) {
        if (startR == targetR && startC == targetC) {
            return 0;
        }

        Queue<int[]> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[m][n];

        queue.offer(new int[]{startR, startC});
        visited[startR][startC] = true;

        int steps = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            steps++;

            for (int i = 0; i < size; i++) {
                int[] curr = queue.poll();
                int r = curr[0];
                int c = curr[1];

                for (int[] d : DIRS) {
                    int nr = r + d[0];
                    int nc = c + d[1];

                    if (nr >= 0 && nr < m && nc >= 0 && nc < n && !visited[nr][nc] && forest.get(nr).get(nc) > 0) {
                        if (nr == targetR && nc == targetC) {
                            return steps;
                        }
                        visited[nr][nc] = true;
                        queue.offer(new int[]{nr, nc});
                    }
                }
            }
        }

        return -1;
    }
}