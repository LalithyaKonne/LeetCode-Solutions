class Solution {
    public boolean canJump(int[] nums) {
        int reach=0;
        int target=nums.length-1;
        for(int i=0;i<nums.length;i++)
        {
            if(i>reach)
                return false;
            reach=Math.max(reach,nums[i]+i);
            if(reach>=target)
                return true;
        }
        return true;
    }
}