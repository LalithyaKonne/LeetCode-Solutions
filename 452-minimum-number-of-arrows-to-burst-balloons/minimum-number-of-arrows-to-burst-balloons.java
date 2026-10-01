class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points,(a,b)->Integer.compare(a[0],b[0]));
        int count=1;
        int arrowEnd=points[0][1];
        for(int i=0;i<points.length;i++)
        {
            if(points[i][0]>arrowEnd)
            {
                count++;
                arrowEnd=points[i][1];
            }
            else
            {
                arrowEnd=Math.min(arrowEnd,points[i][1]);
            }
        }
        return count;
    }
}