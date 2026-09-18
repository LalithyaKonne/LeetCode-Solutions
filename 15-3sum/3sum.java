class Solution {
    public List<List<Integer>> threeSum(int[] a) {
        List<List<Integer>> res=new ArrayList<>();
        Arrays.sort(a);
        int n=a.length;
        for(int i=0;i<n-2;i++)
        {
            if(i>0 && a[i]==a[i-1])
                continue;
            int l=i+1,r=n-1;
            while(l<r)
            {
                if(a[i]+a[l]+a[r]==0)
                {
                    ArrayList<Integer> al=new ArrayList<>();
                    al.add(a[i]);
                    al.add(a[l]);
                    al.add(a[r]);
                    res.add(al);
                    while(l<r && a[l]==a[l+1]) l++;
                    while(l<r && a[r]==a[r-1]) r--;
                    l++;
                    r--;
                }
                else if(a[i]+a[l]+a[r]<0)
                    l++;
                else
                    r--;
            }
        }
        return res;
    }
}