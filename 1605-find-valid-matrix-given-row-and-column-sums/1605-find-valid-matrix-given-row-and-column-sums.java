class Solution {
    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        int m = rowSum.length;
        int n = colSum.length;
        int[][] matrix = new int[m][n];

        int i = 0, j = 0;

        while (i < m && j < n) {
            // Assign the maximum possible value bounded by both remaining sums
            int val = Math.min(rowSum[i], colSum[j]);
            matrix[i][j] = val;

            rowSum[i] -= val;
            colSum[j] -= val;

            // Move past the satisfied row/column
            if (rowSum[i] == 0) {
                i++;
            }
            if (colSum[j] == 0) {
                j++;
            }
        }

        return matrix;
    }
}