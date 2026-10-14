import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> printVertically(String s) {
        String[] words = s.split(" ");
        int maxLen = 0;

        for (String word : words) {
            maxLen = Math.max(maxLen, word.length());
        }

        List<String> result = new ArrayList<>();

        for (int i = 0; i < maxLen; i++) {
            StringBuilder sb = new StringBuilder();

            for (String word : words) {
                if (i < word.length()) {
                    sb.append(word.charAt(i));
                } else {
                    sb.append(' ');
                }
            }

            // Remove trailing spaces from the end of the StringBuilder
            int lastIndex = sb.length() - 1;
            while (lastIndex >= 0 && sb.charAt(lastIndex) == ' ') {
                lastIndex--;
            }

            // Set the length to truncate trailing spaces
            sb.setLength(lastIndex + 1);
            result.add(sb.toString());
        }

        return result;
    }
}