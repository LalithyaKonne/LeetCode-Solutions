class Solution {
    public boolean canMakeSubsequence(String str1, String str2) {
        int i=0,j=0;
        while(i<str1.length() && j<str2.length())
        {
            char ch1=str1.charAt(i);
            char ch2=str2.charAt(j);
            if(ch1==ch2 || (ch1-'a'+1)%26+'a'==ch2)
            {
                i++;
                j++;
            }
            else
            {
                i++;
            }
        }
        return j==str2.length();
    }
}