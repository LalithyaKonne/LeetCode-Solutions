class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> res=new ArrayList<>();
        int n=nums.length;
        if(n==0) 
            return res;
        int i=0;
        while(i<n)
        {
            int start=nums[i];
            while(i+1<n && nums[i+1]==nums[i]+1)
            {
                i++;
            }
            int end=nums[i];
            if(start==end)
            {
                res.add(String.valueOf(start));
            }
            else
            {
                res.add(start+"->"+end);
            }
            i++;
        }
        return res;
    }
}