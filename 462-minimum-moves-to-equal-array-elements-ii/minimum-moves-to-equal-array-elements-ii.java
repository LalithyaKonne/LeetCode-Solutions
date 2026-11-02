class Solution {
    public int minMoves2(int[] nums) {
        int n=nums.length;
        Arrays.sort(nums);
        int res=0;
        int mid=nums[n/2];
        for(int i=0;i<n;i++)
        {
            if(nums[i]>mid)
               res+=(nums[i]-mid);
            else
               res+=(mid-nums[i]);
        }
        return res;
    }
}