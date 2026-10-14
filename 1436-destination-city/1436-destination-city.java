import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    public String destCity(List<List<String>> paths) {
        Set<String> startCities = new HashSet<>();

        // Step 1: Collect all cities that have an outgoing path
        for (List<String> path : paths) {
            startCities.add(path.get(0));
        }

        // Step 2: The destination city will never appear in startCities
        for (List<String> path : paths) {
            String destination = path.get(1);
            if (!startCities.contains(destination)) {
                return destination;
            }
        }

        return "";
    }
}