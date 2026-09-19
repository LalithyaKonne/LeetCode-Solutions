class Solution {
    public String reverseVowels(String s) {
        char word[]=s.toCharArray();
        int i=0,j=word.length-1;
        String s1="aeiouAEIOU";
        while(i<j)
        {
            while(i<j && s1.indexOf(word[i])==-1)
            {
                i++;
            }
            while(i<j && s1.indexOf(word[j])==-1)
            {
                j--;
            }
            if(i<j)
            {
                char temp=word[i];
                word[i]=word[j];
                word[j]=temp;
                i++;
                j--;
            }
        }
        String ans=new String(word);
            return ans;
    }
}