class Solution {
    public String longestPalindrome(String s) {
        if(s==null || s.length()<2)
            return s;
        String longest="";
        for(int i=0;i<s.length()-1;i++)
        {
            String oddPal=expand(s,i,i);
            String evenPal=expand(s,i,i+1);
            if(oddPal.length()>longest.length())
            {
                longest=oddPal;
            }
            if(evenPal.length()>longest.length())
            {
                longest=evenPal;
            }
        }
        return longest;
    }
    public String expand(String s,int i,int j)
    {
        while(i>=0 && j<s.length() && s.charAt(i)==s.charAt(j))
        {
            i--;
            j++;
        }
        return s.substring(i+1,j);
    }
}