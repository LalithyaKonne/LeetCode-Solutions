class Solution {
    public boolean areOccurrencesEqual(String s) {
        int freq[]=new int[26];
        for(char ch:s.toCharArray())
        {
            freq[ch-'a']++;
        }
        int prev=freq[s.charAt(0)-'a'];
        for(int x:freq)
        {
            if(x!=0 && x!=prev)
            {
                return false;
            }
        }
        return true;
    }
}