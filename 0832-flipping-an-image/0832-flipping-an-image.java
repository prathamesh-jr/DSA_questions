class Solution {
    public int[][] flipAndInvertImage(int[][] image) {
        int n = image.length;

        for (int[] row : image) {
            int left = 0;
            int right = n - 1;

            while (left <= right) {
                if (row[left] == row[right]) {
                    // Invert both elements using XOR
                    int inverted = row[left] ^ 1;
                    row[left] = inverted;
                    row[right] = inverted;
                }
                // If row[left] != row[right], swap and invert cancel out
                left++;
                right--;
            }
        }

        return image;
    }
}