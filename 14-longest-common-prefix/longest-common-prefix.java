class Solution {
    public String longestCommonPrefix(String[] arr) {
        Arrays.sort(arr);
        int n=arr.length;
        int i=0;
        String first=arr[0];
        String last=arr[n-1];
        while(i<first.length() && i<last.length() && first.charAt(i)==last.charAt(i))
        {
            i++;
        }
        return first.substring(0,i);
    }
}