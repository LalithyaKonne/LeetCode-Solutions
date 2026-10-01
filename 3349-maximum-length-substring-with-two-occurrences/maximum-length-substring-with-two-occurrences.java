class Solution {
    public int maximumLengthSubstring(String s) {
        HashMap<Character,Integer> hm=new HashMap<>();
        int max=0;
        int i=0;
        for(int j=0;j<s.length();j++)
        {
            char ch=s.charAt(j);
            hm.put(ch,hm.getOrDefault(ch,0)+1);
            while(hm.get(ch)>2)
            {
                char ch1=s.charAt(i);
                hm.put(ch1,hm.get(ch1)-1);
                i++;
            }
            max=Math.max(max,j-i+1);
        }
        return max;
    }
}