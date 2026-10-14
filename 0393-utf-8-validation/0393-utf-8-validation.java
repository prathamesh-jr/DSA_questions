class Solution {
    public boolean validUtf8(int[] data) {
        int remaining = 0;

        for (int num : data) {
            // Only consider the lowest 8 bits
            int b = num & 0xFF;

            if (remaining == 0) {
                // Determine character byte length by checking prefix bits
                if ((b >> 7) == 0b0) {
                    remaining = 0; // 1-byte character
                } else if ((b >> 5) == 0b110) {
                    remaining = 1; // 2-byte character (1 continuation byte follows)
                } else if ((b >> 4) == 0b1110) {
                    remaining = 2; // 3-byte character (2 continuation bytes follow)
                } else if ((b >> 3) == 0b11110) {
                    remaining = 3; // 4-byte character (3 continuation bytes follow)
                } else {
                    return false; // Invalid leading byte prefix
                }
            } else {
                // Continuation byte must start with '10'
                if ((b >> 6) != 0b10) {
                    return false;
                }
                remaining--;
            }
        }

        // Must not end mid-character
        return remaining == 0;
    }
}