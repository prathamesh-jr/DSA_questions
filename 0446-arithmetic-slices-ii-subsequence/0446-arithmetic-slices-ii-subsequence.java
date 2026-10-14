import java.util.HashMap;
import java.util.Map;

class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length;
        int total = 0;

        // dp[i] maps common difference (Long) -> count of subsequences ending at index i
        @SuppressWarnings("unchecked")
        Map<Long, Integer>[] dp = new HashMap[n];

        for (int i = 0; i < n; i++) {
            dp[i] = new HashMap<>();
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                // Cast to long to prevent 32-bit integer overflow under subtraction
                long diff = (long) nums[i] - nums[j];

                // Number of weak arithmetic subsequences ending at j with difference diff
                int prevCount = dp[j].getOrDefault(diff, 0);

                // Any subsequence of length >= 2 ending at j becomes length >= 3 by appending nums[i]
                total += prevCount;

                // Update dp[i][diff]:
                // 1) prevCount (extended to length >= 3)
                // 2) 1 for the two-element subsequence [nums[j], nums[i]]
                // 3) any existing subsequences ending at i with the same diff from earlier iterations
                int currentCount = dp[i].getOrDefault(diff, 0);
                dp[i].put(diff, currentCount + prevCount + 1);
            }
        }

        return total;
    }
}