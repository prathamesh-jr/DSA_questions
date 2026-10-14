import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        // Step 1: Count occurrences of each number
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int num : arr) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }

        // Step 2: Check if frequencies are unique
        Set<Integer> uniqueCounts = new HashSet<>();
        for (int freq : countMap.values()) {
            // If the frequency already exists, it is not unique
            if (!uniqueCounts.add(freq)) {
                return false;
            }
        }

        return true;
    }
}