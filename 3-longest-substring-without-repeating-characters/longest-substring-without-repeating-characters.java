class Solution {
    public int lengthOfLongestSubstring(String s) {
        int ans=0;
        int n=s.length();
        int l=0,r=0;
        HashMap<Character,Boolean> hm=new HashMap<>();
        while(r<n)
        {
            while(hm.containsKey(s.charAt(r)) && hm.get(s.charAt(r))==true )
            {
                hm.put(s.charAt(l),false);
                l++;
            }
            hm.put(s.charAt(r),true);
            int len=r-l+1;
            if(len>ans)
                ans=len;
            r++;
        }
        return ans;
    }
}