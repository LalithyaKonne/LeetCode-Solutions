class Solution {
    public int maximumSaleItems(int[][] items, int budget) {
        int n = items.length;
        int[] bonus = new int[n];

        for (int i = 0; i < n; i++) {
            int factorI = items[i][0];
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (i != j && items[j][0] % factorI == 0) {
                    count++;
                }
            }
            bonus[i] = count;
        }

        int[] dp = new int[budget + 1];

        for (int i = 0; i < n; i++) {
            int price = items[i][1];
            int firstGain = 1 + bonus[i];

            if (price <= budget) {
                // First copy of item i (at most once per item type)
                for (int b = budget; b >= price; b--) {
                    dp[b] = Math.max(dp[b], dp[b - price] + firstGain);
                }

                // Additional copies of item i (1 extra copy per 'price' spent)
                for (int b = price; b <= budget; b++) {
                    dp[b] = Math.max(dp[b], dp[b - price] + 1);
                }
            }
        }

        int ans = 0;
        for (int b = 0; b <= budget; b++) {
            ans = Math.max(ans, dp[b]);
        }
        return ans;
    }
}