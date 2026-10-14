import java.util.Arrays;

class Solution {
    public double trimMean(int[] arr) {
        int n = arr.length;
        Arrays.sort(arr);

        // 5% of the total number of elements
        int k = n / 20;

        double sum = 0.0;
        for (int i = k; i < n - k; i++) {
            sum += arr[i];
        }

        // The remaining count is 90% of n, which is n - 2 * k
        int remainingCount = n - 2 * k;

        return sum / remainingCount;
    }
}