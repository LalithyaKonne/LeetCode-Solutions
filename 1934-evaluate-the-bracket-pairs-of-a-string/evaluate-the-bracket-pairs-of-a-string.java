class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        HashMap<String, String> map = new HashMap<>();

        // Store key-value pairs
        for (List<String> k : knowledge) {
            map.put(k.get(0), k.get(1));
        }

        StringBuilder ans = new StringBuilder();
        StringBuilder key = new StringBuilder();

        boolean inside = false;

        for (char ch : s.toCharArray()) {

            if (ch == '(') {
                inside = true;
                key.setLength(0);
            }
            else if (ch == ')') {
                inside = false;

                if (map.containsKey(key.toString())) {
                    ans.append(map.get(key.toString()));
                } else {
                    ans.append('?');
                }
            }
            else if (inside) {
                key.append(ch);
            }
            else {
                ans.append(ch);
            }
        }

        return ans.toString();
    }
}