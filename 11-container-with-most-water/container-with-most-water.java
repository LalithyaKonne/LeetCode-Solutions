class Solution {
    public int maxArea(int[] height) {
        int res=0;
        int i=0,j=height.length-1;
        while(i<j)
        {
                int h=Math.min(height[i],height[j]);
                int w=j-i;
                int area=h*w;
                res=Math.max(res,area);
                if(height[i]<height[j])
                    i++;
                else
                    j--;
        }
        return res;
    }
}
