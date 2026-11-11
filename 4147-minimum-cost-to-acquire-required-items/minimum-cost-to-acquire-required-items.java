class Solution {
    public long minimumCost(int cost1, int cost2, int costBoth, int need1, int need2) {
        long both = (long) Math.min(need1, need2) * costBoth;
        if (need1 > need2) {
            both += (long) (need1 - need2) * Math.min(cost1, costBoth);
        } else {
            both += (long) (need2 - need1) * Math.min(cost2, costBoth);
        }
        return Math.min(both,
                (long) need1 * cost1 + (long) need2 * cost2);
    }
}