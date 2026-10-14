class Solution {
    public int matrixScore(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        // Column 0 always contributes m * 2^(n - 1)
        int totalScore = m * (1 << (n - 1));

        // Evaluate columns 1 to n - 1 independently
        for (int j = 1; j < n; j++) {
            int countSameAsFirstCol = 0;

            for (int i = 0; i < m; i++) {
                // If grid[i][j] == grid[i][0], then after row flip (if needed), this cell is 1
                if (grid[i][j] == grid[i][0]) {
                    countSameAsFirstCol++;
                }
            }

            // We can flip column j if there are more 0s than 1s
            int maxOnes = Math.max(countSameAsFirstCol, m - countSameAsFirstCol);

            // Add contribution of this column to the total score
            totalScore += maxOnes * (1 << (n - 1 - j));
        }

        return totalScore;
    }
}