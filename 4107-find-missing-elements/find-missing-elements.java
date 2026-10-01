class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        List<Integer> al=new ArrayList<>();
        Arrays.sort(nums);
        int next=nums[0];
        for(int i=0;i<nums.length;i++)
        {
            while(next<nums[i])
            {
                al.add(next++);
            }
            next++;
        }
        return al;
    }
}