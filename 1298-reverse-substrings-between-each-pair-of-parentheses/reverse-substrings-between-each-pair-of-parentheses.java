class Solution {
    public String reverseParentheses(String s) {
        Stack<String> st=new Stack<>();
        StringBuilder sb=new StringBuilder();
        for(char ch:s.toCharArray())
        {
            if(ch=='(')
            {
                st.push(sb.toString());
                sb.setLength(0);
            }
            else if(ch==')')
            {
                sb.reverse();
                String curr=st.pop();
                sb.insert(0,curr);
            }
            else
            {
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}