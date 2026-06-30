class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        
        // Traverse the array backward
        for (int i = n - 1; i >= 0; i--) {
            // If the digit is less than 9, just add 1 and we are done
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            
            // If the digit is 9, it becomes 0 (carry goes to the next iteration)
            digits[i] = 0;
        }
        
        // If we reach here, it means all digits were 9 (e.g., [9, 9, 9] -> [1, 0, 0, 0])
        int[] newDigits = new int[n + 1];
        newDigits[0] = 1; // Remaining elements automatically initialize to 0 in Java
        
        return newDigits;
    }
}