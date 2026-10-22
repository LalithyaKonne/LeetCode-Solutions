class Solution {
    public int minOperations(int[] nums) {
        int n=nums.length;
        int i=1,j=1;
        for(int k=1;k<n;k++)
        {
            if(nums[k]==(nums[k-1]+1)%n)
            {
                i++;
            }
            if(nums[k-1]==(nums[k]+1)%n)
            {
                j++;
            }
        }
        if(i==n)
        {
            return nums[0]==0?0:Math.min(n-nums[0],nums[0]+2);
        }
        if(j==n)
        {
            return Math.min(n-nums[n-1],nums[n-1])+1;
        }
        return -1;
    }
}