class Solution {
    private Integer[][] memoCost;
    private int[][] memoDp;
    private String s;
    private int n;

    public int minimumChanges(String s, int k) {
        this.s = s;
        this.n = s.length();
        
        this.memoCost = new Integer[n][n];
        this.memoDp = new int[n][k + 1];
        for (int i = 0; i < n; i++) {
            java.util.Arrays.fill(memoDp[i], -1);
        }
        
        return solve(0, k);
    }
    
    private int solve(int idx, int rem) {
        if (rem == 1) {
            return getCost(idx, n - 1);
        }
        if (n - idx < rem) {
            return 1000000; // Infinity marker
        }
        if (memoDp[idx][rem] != -1) {
            return memoDp[idx][rem];
        }
        
        int minChanges = 1000000;
        // Try ending the current partition at index j
        for (int j = idx; j < n - rem + 1; j++) {
            int currentCost = getCost(idx, j) + solve(j + 1, rem - 1);
            minChanges = Math.min(minChanges, currentCost);
        }
        
        return memoDp[idx][rem] = minChanges;
    }
    
    private int getCost(int l, int r) {
        if (memoCost[l][r] != null) {
            return memoCost[l][r];
        }
        
        int len = r - l + 1;
        int minChanges = 1000000;
        
        // Check all proper divisors d of len
        for (int d = 1; d < len; d++) {
            if (len % d == 0) {
                int changes = 0;
                // Group characters by remainder mod d starting at offset i
                for (int i = 0; i < d; i++) {
                    int left = l + i;
                    int right = l + len - d + i;
                    while (left < right) {
                        if (s.charAt(left) != s.charAt(right)) {
                            changes++;
                        }
                        left += d;
                        right -= d;
                    }
                }
                minChanges = Math.min(minChanges, changes);
            }
        }
        return memoCost[l][r] = minChanges;
    }
}