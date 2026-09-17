class Solution {
    int ans=0;
    public int maxLength(List<String> arr) {
        solve("",0,arr);
        return ans; 
    }
    void solve(String current,int index,List<String> arr)
    {
        ans=Math.max(ans,current.length());
        for(int i=index;i<arr.size();i++)
        {
            String s=arr.get(i);
            if(unique(current+s))
                solve(current+s,i+1,arr);
        }

    }
    boolean unique(String s)
    {
        HashSet<Character> hs=new HashSet<>();
        for(char ch:s.toCharArray())
        {
            if(hs.contains(ch))
                return false;
            hs.add(ch);
        }
        return true;
    }
}