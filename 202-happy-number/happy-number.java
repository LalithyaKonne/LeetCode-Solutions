class Solution {
    public boolean isHappy(int n) {
        HashSet<Integer> hs=new HashSet<>();
        while(!hs.contains(n))
        {
            hs.add(n);
            n=number(n);
            if(n==1)
                return true;
        }
        return false;
    }
    public int number(int n)
    {
        int sum=0;
        while(n>0)
        {
            int r=n%10;
            sum+=r*r;
            n=n/10;
        }
        return sum;
    }
}