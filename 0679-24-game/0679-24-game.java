import java.util.ArrayList;
import java.util.List;

class Solution {
    private static final double EPSILON = 1e-6;
    private static final double TARGET = 24.0;

    public boolean judgePoint24(int[] cards) {
        List<Double> list = new ArrayList<>();
        for (int card : cards) {
            list.add((double) card);
        }
        return backtrack(list);
    }

    private boolean backtrack(List<Double> list) {
        // Base case: only 1 number left
        if (list.size() == 1) {
            return Math.abs(list.get(0) - TARGET) < EPSILON;
        }

        int n = list.size();
        // Pick any two numbers at index i and j
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) continue;

                // Create a list with the remaining numbers
                List<Double> nextRound = new ArrayList<>();
                for (int k = 0; k < n; k++) {
                    if (k != i && k != j) {
                        nextRound.add(list.get(k));
                    }
                }

                double a = list.get(i);
                double b = list.get(j);

                // Generate possible results for a and b
                // Note: a + b and a * b are commutative, so i < j would suffice,
                // but checking all ordered pairs (a, b) handles non-commutative - and / cleanly.
                for (double result : computePossibilities(a, b)) {
                    nextRound.add(result);
                    if (backtrack(nextRound)) {
                        return true;
                    }
                    // Backtrack
                    nextRound.remove(nextRound.size() - 1);
                }
            }
        }

        return false;
    }

    private List<Double> computePossibilities(double a, double b) {
        List<Double> results = new ArrayList<>();
        results.add(a + b);
        results.add(a - b);
        results.add(a * b);
        if (Math.abs(b) > EPSILON) {
            results.add(a / b);
        }
        return results;
    }
}