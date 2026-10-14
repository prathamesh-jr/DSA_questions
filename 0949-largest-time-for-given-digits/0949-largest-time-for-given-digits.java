class Solution {
    public String largestTimeFromDigits(int[] arr) {
        int maxTime = -1;

        // Generate all 4! = 24 permutations using 4 nested loops
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (j == i) continue;
                for (int k = 0; k < 4; k++) {
                    if (k == i || k == j) continue;
                    
                    // The remaining index l
                    int l = 6 - i - j - k; // 0 + 1 + 2 + 3 = 6

                    int hours = arr[i] * 10 + arr[j];
                    int minutes = arr[k] * 10 + arr[l];

                    if (hours < 24 && minutes < 60) {
                        int totalMinutes = hours * 60 + minutes;
                        maxTime = Math.max(maxTime, totalMinutes);
                    }
                }
            }
        }

        if (maxTime == -1) {
            return "";
        }

        int bestHours = maxTime / 60;
        int bestMinutes = maxTime % 60;

        return String.format("%02d:%02d", bestHours, bestMinutes);
    }
}