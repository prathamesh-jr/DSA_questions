class Solution {
    public int videoStitching(int[][] clips, int time) {
        // maxReach[i] stores the farthest point reachable starting at or before second i
        int[] maxReach = new int[time + 1];

        for (int[] clip : clips) {
            int start = clip[0];
            int end = clip[1];
            if (start <= time) {
                maxReach[start] = Math.max(maxReach[start], end);
            }
        }

        int clipsCount = 0;
        int currentEnd = 0;
        int farthest = 0;

        for (int i = 0; i < time; i++) {
            farthest = Math.max(farthest, maxReach[i]);

            // If we cannot even reach beyond the current second i
            if (i >= farthest) {
                return -1;
            }

            // Time to take the next clip
            if (i == currentEnd) {
                clipsCount++;
                currentEnd = farthest;

                if (currentEnd >= time) {
                    return clipsCount;
                }
            }
        }

        return currentEnd >= time ? clipsCount : -1;
    }
}