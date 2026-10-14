class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        // Only tops[0] or bottoms[0] can be the valid uniform value
        int rotations = check(tops[0], tops, bottoms);
        if (rotations != -1 || tops[0] == bottoms[0]) {
            return rotations;
        }
        return check(bottoms[0], tops, bottoms);
    }

    private int check(int target, int[] tops, int[] bottoms) {
        int rotationsTop = 0;
        int rotationsBottom = 0;
        int n = tops.length;

        for (int i = 0; i < n; i++) {
            // Target is absent on both halves of this domino
            if (tops[i] != target && bottoms[i] != target) {
                return -1;
            }

            // Count rotations needed to make tops or bottoms completely equal to target
            if (tops[i] != target) {
                rotationsTop++;
            } else if (bottoms[i] != target) {
                rotationsBottom++;
            }
        }

        return Math.min(rotationsTop, rotationsBottom);
    }
}