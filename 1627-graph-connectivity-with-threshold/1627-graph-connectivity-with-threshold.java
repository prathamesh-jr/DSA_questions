import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Boolean> areConnected(int n, int threshold, int[][] queries) {
        // If threshold == 0, every pair shares divisor 1, so all numbers are connected.
        // Handled naturally by the DSU algorithm.
        UnionFind uf = new UnionFind(n + 1);

        // Connect multiples of each divisor > threshold
        for (int z = threshold + 1; z <= n; z++) {
            for (int multiple = 2 * z; multiple <= n; multiple += z) {
                uf.union(z, multiple);
            }
        }

        // Answer each query in nearly O(1) time
        List<Boolean> ans = new ArrayList<>(queries.length);
        for (int[] query : queries) {
            int u = query[0];
            int v = query[1];
            ans.add(uf.find(u) == uf.find(v));
        }

        return ans;
    }

    private static class UnionFind {
        private final int[] parent;
        private final int[] rank;

        public UnionFind(int size) {
            parent = new int[size];
            rank = new int[size];
            for (int i = 0; i < size; i++) {
                parent[i] = i;
            }
        }

        public int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]); // Path compression
            }
            return parent[x];
        }

        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);

            if (rootX != rootY) {
                // Union by rank
                if (rank[rootX] < rank[rootY]) {
                    parent[rootX] = rootY;
                } else if (rank[rootX] > rank[rootY]) {
                    parent[rootY] = rootX;
                } else {
                    parent[rootY] = rootX;
                    rank[rootX]++;
                }
            }
        }
    }
}