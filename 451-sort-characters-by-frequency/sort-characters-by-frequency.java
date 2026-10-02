class Solution {
    public String frequencySort(String s) {
        StringBuilder sb=new StringBuilder();
        HashMap<Character,Integer> hm=new HashMap<>();
        for(char ch:s.toCharArray())
        {
            hm.put(ch,hm.getOrDefault(ch,0)+1);
        }
        List<Character> al=new ArrayList<>(hm.keySet());
        al.sort((a,b)->hm.get(b)-hm.get(a));
        for(char ch:al)
        {
            int count=hm.get(ch);
            for(int i=0;i<count;i++)
            {
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}