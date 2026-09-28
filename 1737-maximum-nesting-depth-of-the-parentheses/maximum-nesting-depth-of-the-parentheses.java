class Solution {
    public int maxDepth(String s) {
        int max=0;
        int count=0;
        for(int i=0;i<s.length();i++)
        {
            char ch=s.charAt(i);
            if(ch=='(')
            {
                count++;
                max=Math.max(max,count);
            }
            else if(ch==')')
            {
                count--;
            }

        }
        return max;
    }
}