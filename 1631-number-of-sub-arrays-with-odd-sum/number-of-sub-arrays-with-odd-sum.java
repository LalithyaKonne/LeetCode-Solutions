class Solution {
    public int numOfSubarrays(int[] arr) {
        int MOD = 1000000007;
        int odd=0;
        int even=1;
        int sum=0;
        int res=0;
        for(int num:arr)
        {
            sum+=num;
            if(sum%2==0)
            {
                res=(res+odd)%MOD;
                even++;
            }
            else
            {
                res=(res+even)%MOD;
                odd++;
            }
        }
        return res;
    }
}