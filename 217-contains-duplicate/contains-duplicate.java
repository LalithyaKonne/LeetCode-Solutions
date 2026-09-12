class Solution {
    public boolean containsDuplicate(int[] nums) {
        LinkedHashMap<Integer,Integer> hm=new LinkedHashMap<>();
        for(int x:nums)
        {
            hm.put(x,hm.getOrDefault(x,0)+1);
        }
        for(int i=0;i<nums.length;i++)
        {
            if(hm.get(nums[i])>1)
               return true;
        }
        return false;
    }
}