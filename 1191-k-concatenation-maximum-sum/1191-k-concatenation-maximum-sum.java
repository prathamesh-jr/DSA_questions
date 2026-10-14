class Solution {
    public int kConcatenationMaxSum(int[] arr, int k) {
        int MOD = 1_000_000_007;

        long totalSum = 0;
        for (int x : arr) {
            totalSum += x;
        }

        // Standard Kadane's algorithm for 1 copy
        long maxKadane1 = kadane(arr, 1);
        if (k == 1) {
            return (int) (maxKadane1 % MOD);
        }

        // Kadane's algorithm for 2 concatenated copies
        long maxKadane2 = kadane(arr, 2);

        if (totalSum > 0) {
            // Include (k - 2) full blocks in the middle
            long result = (maxKadane2 + (k - 2) * totalSum) % MOD;
            return (int) result;
        } else {
            return (int) (maxKadane2 % MOD);
        }
    }

    private long kadane(int[] arr, int repetitions) {
        long currentSum = 0;
        long maxSum = 0;
        int n = arr.length;

        for (int i = 0; i < n * repetitions; i++) {
            currentSum = Math.max(0L, currentSum + arr[i % n]);
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }
}