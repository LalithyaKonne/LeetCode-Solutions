class Solution {
    public int longestSubstring(String s, int k) {
        if (s.length() == 0) return 0;
        int[] freq=new int[26];
        for (char c:s.toCharArray())
            freq[c-'a']++;
        for (int i=0;i<s.length();i++) 
        {
            if (freq[s.charAt(i)-'a']<k) 
            {
                return Math.max(
                    longestSubstring(s.substring(0, i), k),
                    longestSubstring(s.substring(i + 1), k)
                );
            }
        }
        return s.length();
    }
}