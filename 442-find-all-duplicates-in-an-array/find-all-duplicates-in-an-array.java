class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        LinkedHashMap<Integer,Integer> hm=new LinkedHashMap<>();
        for(int x:nums)
        {
            hm.put(x,hm.getOrDefault(x,0)+1);
        }
        List<Integer> al=new ArrayList<>();
        for(int key:hm.keySet())
        {
            if(hm.get(key)>1)
                al.add(key);
        }
        return al;
    }
}