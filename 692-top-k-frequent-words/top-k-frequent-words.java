class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String,Integer> hm=new HashMap<>();
        for(String s:words)
        {
            hm.put(s,hm.getOrDefault(s,0)+1);
        }
        List<String> al=new ArrayList<>(hm.keySet());
        al.sort((a,b)->{
            if(!hm.get(a).equals(hm.get(b)))
                return hm.get(b)-hm.get(a);
            return a.compareTo(b);
        });
        return al.subList(0,k);
    }
}