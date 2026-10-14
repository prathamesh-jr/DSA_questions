class Solution {
    public int longestArithSeqLength(int[] nums) {
        int n = nums.length;
        if (n <= 2) {
            return n;
        }

        // Differences range from -500 to 500. Offset by 500 -> [0, 1000]
        int OFFSET = 500;
        int[][] dp = new int[n][1001];
        int maxLength = 2;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                int diff = nums[i] - nums[j] + OFFSET;

                // If a sequence ending at j with this diff exists, extend it.
                // Otherwise, the pair (nums[j], nums[i]) forms a sequence of length 2.
                dp[i][diff] = Math.max(dp[i][diff], dp[j][diff] > 0 ? dp[j][diff] + 1 : 2);

                maxLength = Math.max(maxLength, dp[i][diff]);
            }
        }

        return maxLength;
    }
}