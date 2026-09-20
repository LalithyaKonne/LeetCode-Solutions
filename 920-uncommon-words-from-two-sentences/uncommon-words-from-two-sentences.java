class Solution {
    public String[] uncommonFromSentences(String s1, String s2) {
        String s=s1 + " " + s2;
        HashMap<String,Integer> hm=new HashMap<>();
        String words[]=s.split(" ");
        for(String word:words)
        {
            hm.put(word,hm.getOrDefault(word,0)+1);
        }
        ArrayList<String> al=new ArrayList<>();
        for(Map.Entry<String,Integer> e:hm.entrySet())
        {
            if(e.getValue()==1)
                al.add(e.getKey());
        }
        return al.toArray(new String[0]);
    }
}