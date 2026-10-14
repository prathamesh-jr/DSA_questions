class Solution {
    public int[] diStringMatch(String s) {
        int n = s.length();
        int[] perm = new int[n + 1];
        
        int low = 0;
        int high = n;
        
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == 'I') {
                perm[i] = low++;
            } else {
                perm[i] = high--;
            }
        }
        
        // At the end, low == high, place the last remaining number
        perm[n] = low;
        
        return perm;
    }
}