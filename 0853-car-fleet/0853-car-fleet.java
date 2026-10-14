import java.util.Arrays;

class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        if (n == 0) return 0;

        // Pair each car's position with its speed
        // [0] = position, [1] = speed
        int[][] cars = new int[n][2];
        for (int i = 0; i < n; i++) {
            cars[i][0] = position[i];
            cars[i][1] = speed[i];
        }

        // Sort cars descending by position (closest to target first)
        Arrays.sort(cars, (a, b) -> Integer.compare(b[0], a[0]));

        int fleetCount = 0;
        double currentFleetTime = 0.0;

        for (int[] car : cars) {
            double timeToTarget = (double) (target - car[0]) / car[1];

            // If this car takes longer than the fleet ahead, it cannot catch up.
            // It becomes the leader of a new fleet.
            if (timeToTarget > currentFleetTime) {
                fleetCount++;
                currentFleetTime = timeToTarget;
            }
            // Otherwise, it catches up before or at the target, merging into current fleet.
        }

        return fleetCount;
    }
}