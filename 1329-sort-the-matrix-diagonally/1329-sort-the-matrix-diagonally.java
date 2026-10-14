import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class Solution {
    public int[][] diagonalSort(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        // Map each diagonal ID (r - c) to a Min-Heap
        Map<Integer, PriorityQueue<Integer>> diagonals = new HashMap<>();

        // Step 1: Collect elements into their respective diagonal min-heaps
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                int diagId = r - c;
                diagonals.putIfAbsent(diagId, new PriorityQueue<>());
                diagonals.get(diagId).offer(mat[r][c]);
            }
        }

        // Step 2: Place sorted elements back into the matrix
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                int diagId = r - c;
                mat[r][c] = diagonals.get(diagId).poll();
            }
        }

        return mat;
    }
}