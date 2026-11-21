class Solution {
    public boolean strongPasswordCheckerII(String password) {
        if(password.length()<8)
        {
            return false;
        }
        boolean l=false;
        boolean u=false;
        boolean d=false;
        boolean s=false;
        String special="!@#$%^&*()-+";
        for(int i=0;i<password.length();i++)
        {
            char c=password.charAt(i);
            if(i>0 && c==password.charAt(i-1))
                return false;
            if(Character.isLowerCase(c))
                l=true;
            else if(Character.isUpperCase(c))
                u=true;
            else if(Character.isDigit(c))
                d=true;
            else if(special.indexOf(c)!=-1)
                s=true;
        }
        return l && u && d && s;
    }
}