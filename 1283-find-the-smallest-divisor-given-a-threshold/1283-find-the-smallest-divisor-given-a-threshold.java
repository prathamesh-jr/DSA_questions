class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int low = 1;
        int high = 0;

        for (int num : nums) {
            high = Math.max(high, num);
        }

        while (low < high) {
            int mid = low + (high - low) / 2;

            if (isValid(nums, threshold, mid)) {
                high = mid; // Try to find a smaller divisor
            } else {
                low = mid + 1; // mid is too small, sum exceeded threshold
            }
        }

        return low;
    }

    private boolean isValid(int[] nums, int threshold, int divisor) {
        int sum = 0;

        for (int num : nums) {
            // Integer ceiling division: ceil(a / b) = (a + b - 1) / b
            sum += (num + divisor - 1) / divisor;

            // Early exit if sum already exceeds threshold
            if (sum > threshold) {
                return false;
            }
        }

        return sum <= threshold;
    }
}