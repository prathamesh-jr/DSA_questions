import java.util.HashMap;
import java.util.Map;

class Solution {
    public int maxEqualRowsAfterFlips(int[][] matrix) {
        Map<String, Integer> patternCount = new HashMap<>();
        int maxRows = 0;

        for (int[] row : matrix) {
            StringBuilder sb = new StringBuilder();
            int firstVal = row[0];

            // Normalize so that every row representation starts with '0'
            for (int val : row) {
                // If firstVal is 1, invert the bit (val ^ 1); otherwise keep it (val)
                sb.append(val == firstVal ? '0' : '1');
            }

            String pattern = sb.toString();
            int count = patternCount.getOrDefault(pattern, 0) + 1;
            patternCount.put(pattern, count);

            maxRows = Math.max(maxRows, count);
        }

        return maxRows;
    }
}