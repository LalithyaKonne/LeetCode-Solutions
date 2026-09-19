class Solution {
    public int countPrefixes(String[] words, String s) {
        int count=0;
        for(int i=0;i<words.length;i++)
        {
            String ch=words[i];
            if(ch.length()>0 && s.startsWith(ch))
            {
                count++;
            }
        }
        return count;
    }
}