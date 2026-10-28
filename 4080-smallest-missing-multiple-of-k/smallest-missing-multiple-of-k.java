class Solution {
    public int missingMultiple(int[] nums, int k) {
        HashSet<Integer> hs=new HashSet<>();
        for(int x:nums)
        {
            hs.add(x);
        }
        int cur=k;
        while(hs.contains(cur))
        {
            cur+=k;
        }
        return cur;
    }
}