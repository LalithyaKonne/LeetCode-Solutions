class Solution {
    public int minSwaps(int[] nums) {
        int n=nums.length;
        int arr[][]=new int[n][2];
        for(int i=0;i<n;i++)
        {
            arr[i][0]=nums[i];
            arr[i][1]=digitSum(nums[i]);
        }
        Arrays.sort(arr,(a,b)->{
            if(a[1]!=b[1])
            {
                return a[1]-b[1];
            }
            return a[0]-b[0];
        });
        HashMap<Integer,Integer> hm=new HashMap<>();
        for(int i=0;i<n;i++)
        {
            hm.put(nums[i],i);
        }
        int count=0;
        for(int i=0;i<n;i++)
        {
            int curr=arr[i][0];
            if(curr!=nums[i])
            {
                int j=hm.get(curr);
                hm.put(nums[i],j);
                hm.put(curr,i);

                int temp=nums[i];
                nums[i]=nums[j];
                nums[j]=temp;

                count++;
            }
        }
        return count;
    }
    public int digitSum(int n)
    {
        int sum=0;
        while(n>0)
        {
            sum+=(n%10);
            n/=10;
        }
        return sum;
    }
}