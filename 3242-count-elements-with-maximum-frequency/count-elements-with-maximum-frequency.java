class Solution {
    public int maxFrequencyElements(int[] nums) {
        LinkedHashMap<Integer,Integer> hm=new LinkedHashMap<>();
        for(int x:nums)
        {
            hm.put(x,hm.getOrDefault(x,0)+1);
        }
        int maxfreq=0;
        for(int freq:hm.values())
        {
            if(freq>maxfreq)
              maxfreq=freq;
        }
        int total=0;
        for(int freq:hm.values())
        {
            if(freq==maxfreq)
              total+=freq;
        }
        return total;
    }
}