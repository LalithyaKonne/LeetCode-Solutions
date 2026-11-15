class Solution {
    public boolean wordPattern(String pattern, String s) {
        String words[]=s.split(" ");
        if(pattern.length()!=words.length)
            return false;
        HashMap<Character,Integer> hm1=new HashMap<>();
        HashMap<String,Integer> hm2=new HashMap<>();
        for(int i=0;i<pattern.length();i++)
        {
            char c=pattern.charAt(i);
            String w=words[i];
            if(!hm1.getOrDefault(c,0).equals(hm2.getOrDefault(w,0)))
            {
                return false;
            }
            hm1.put(c,i+1);
            hm2.put(w,i+1);
        }
        return true;
    }
}