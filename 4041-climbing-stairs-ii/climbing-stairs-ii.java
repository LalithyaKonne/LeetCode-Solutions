class Solution {
    public int climbStairs(int n, int[] costs) {
        // dp[j] stores the minimum cost to reach step j
        long[] dp = new long[n + 1];
        java.util.Arrays.fill(dp, Long.MAX_VALUE);
        
        dp[0] = 0;
        
        for (int j = 1; j <= n; j++) {
            // Check jumps from j - 1, j - 2, and j - 3
            for (int k = 1; k <= 3; k++) {
                int i = j - k;
                if (i >= 0) {
                    long costJump = costs[j - 1] + (long)(j - i) * (j - i);
                    dp[j] = Math.min(dp[j], dp[i] + costJump);
                }
            }
        }
        
        return (int) dp[n];
    }
}