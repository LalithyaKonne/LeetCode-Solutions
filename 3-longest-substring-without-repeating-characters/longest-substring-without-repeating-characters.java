class Solution {
    public int lengthOfLongestSubstring(String s) {
       /* int ans=0;
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
        return ans;*/

        HashSet<Character> hs=new HashSet<>();
        int k=0;
        int max=0;
        for(int i=0;i<s.length();i++)
        {
            char ch=s.charAt(i);
            while(hs.contains(ch))
            {
                hs.remove(s.charAt(k));
                k++;
            }
            hs.add(ch);
            max=Math.max(max,i-k+1);
        }
        return max;
    }
}