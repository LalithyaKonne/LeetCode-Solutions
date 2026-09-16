class Solution {
    public int removeDuplicates(int[] nums) {
        HashSet<Integer> hs=new HashSet<>();
        int k=0;
        for(int x:nums)
        {
            if(!hs.contains(x))
            {
                hs.add(x);
                nums[k]=x;
                k++;
            }
        }
        return k;
    }
}