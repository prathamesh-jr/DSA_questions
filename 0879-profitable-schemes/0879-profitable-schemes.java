class Solution {
    public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
        int MOD = 1_000_000_007;
        int m = group.length;

        // dp[j][k]: number of schemes using at most j members with at least k profit
        int[][] dp = new int[n + 1][minProfit + 1];

        // Base case: 0 members and at least 0 profit has 1 scheme (pick nothing)
        dp[0][0] = 1;

        for (int i = 0; i < m; i++) {
            int membersNeeded = group[i];
            int p = profit[i];

            // Traverse backwards to avoid using the same crime multiple times
            for (int j = n; j >= membersNeeded; j--) {
                for (int k = minProfit; k >= 0; k--) {
                    int prevProfit = Math.max(0, k - p);
                    dp[j][k] = (dp[j][k] + dp[j - membersNeeded][prevProfit]) % MOD;
                }
            }
        }

        // Sum all schemes that use at most n members and make at least minProfit
        int totalSchemes = 0;
        for (int j = 0; j <= n; j++) {
            totalSchemes = (totalSchemes + dp[j][minProfit]) % MOD;
        }

        return totalSchemes;
    }
}