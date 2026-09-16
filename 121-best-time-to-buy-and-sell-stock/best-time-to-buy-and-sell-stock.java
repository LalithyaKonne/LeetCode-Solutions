class Solution {
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int maxsofer=prices[n-1];
        int maxprofit=0;
        for(int i=n-2;i>=0;i--)
        {
            if(prices[i]>maxsofer)
            {
                maxsofer=prices[i];
            }
            maxprofit=Math.max(maxprofit,maxsofer-prices[i]);
        }
        return maxprofit;
    }
}