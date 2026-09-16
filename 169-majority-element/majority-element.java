class Solution {
    public int majorityElement(int[] nums) {
        LinkedHashMap<Integer,Integer> hm=new LinkedHashMap<>();
        for(int x:nums)
        {
            hm.put(x,hm.getOrDefault(x,0)+1);
        }
        int n=nums.length;
        for(int i=0;i<n;i++)
        {
            if(hm.get(nums[i])>n/2)
              return nums[i];
        }
        return -1;
    }
}