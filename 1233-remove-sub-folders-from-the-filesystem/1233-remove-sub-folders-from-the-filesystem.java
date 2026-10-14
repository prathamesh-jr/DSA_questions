import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<String> removeSubfolders(String[] folder) {
        // Step 1: Sort paths lexicographically
        Arrays.sort(folder);

        List<String> result = new ArrayList<>();

        for (String f : folder) {
            // If result is empty or f is not a sub-folder of the last added folder
            if (result.isEmpty() || !isSubFolder(result.get(result.size() - 1), f)) {
                result.add(f);
            }
        }

        return result;
    }

    private boolean isSubFolder(String parent, String candidate) {
        // Must start with parent path followed immediately by '/'
        return candidate.startsWith(parent) && candidate.length() > parent.length() && candidate.charAt(parent.length()) == '/';
    }
}