class Solution {
    public int secondHighest(String s) {
        int largest=-1;
        int second=-1;
        for(int i=0;i<s.length();i++)
        {
            char ch=s.charAt(i);
            if(Character.isDigit(ch))
            {
                int x=ch-'0';
                if(x>largest)
                {
                    second=largest;
                    largest=x;
                }
                else if(x>second && x<largest)
                {
                    second=x;
                }
            }
        }
        return second;
    }
}