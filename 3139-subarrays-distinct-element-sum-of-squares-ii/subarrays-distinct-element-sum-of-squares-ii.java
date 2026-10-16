class Solution {
    private static final int MOD = 1_000_000_007;

    // Segment tree arrays (size 4 * N)
    private long[] sum1;
    private long[] sum2;
    private long[] lazy;

    private void apply(int node, int l, int r, long val) {
        val %= MOD;
        long len = r - l + 1;
        // Formula: (x + val)^2 = x^2 + 2*val*x + val^2
        sum2[node] = (sum2[node] + 2 * val * sum1[node] + val * val % MOD * len) % MOD;
        sum1[node] = (sum1[node] + val * len) % MOD;
        lazy[node] = (lazy[node] + val) % MOD;
    }

    private void pushDown(int node, int l, int r) {
        if (lazy[node] != 0) {
            int mid = (l + r) >> 1;
            apply(node << 1, l, mid, lazy[node]);
            apply(node << 1 | 1, mid + 1, r, lazy[node]);
            lazy[node] = 0;
        }
    }

    private void update(int node, int l, int r, int ql, int qr, long val) {
        if (ql <= l && r <= qr) {
            apply(node, l, r, val);
            return;
        }
        pushDown(node, l, r);
        int mid = (l + r) >> 1;
        if (ql <= mid) update(node << 1, l, mid, ql, qr, val);
        if (qr > mid) update(node << 1 | 1, mid + 1, r, ql, qr, val);

        sum1[node] = (sum1[node << 1] + sum1[node << 1 | 1]) % MOD;
        sum2[node] = (sum2[node << 1] + sum2[node << 1 | 1]) % MOD;
    }

    public int sumCounts(int[] nums) {
        int n = nums.length;
        sum1 = new long[4 * n];
        sum2 = new long[4 * n];
        lazy = new long[4 * n];

        // Since constraints say 1 <= nums[i] <= 10^5, use a direct array instead of a Map
        int[] lastPos = new int[100001];
        java.util.Arrays.fill(lastPos, -1);

        long ans = 0;
        for (int i = 0; i < n; i++) {
            int prev = lastPos[nums[i]];
            // Add 1 to all subarrays starting between (prev + 1) and i
            update(1, 0, n - 1, prev + 1, i, 1);
            // sum2[1] holds the sum of squares of distinct counts for all subarrays ending at index i
            ans = (ans + sum2[1]) % MOD;
            lastPos[nums[i]] = i;
        }

        return (int) ans;
    }
}