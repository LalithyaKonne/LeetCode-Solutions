class Solution {
    public int maxLengthBetweenEqualCharacters(String s) {
        int len = -1;
        int i = 0;
        while (i < s.length()) {
            int j = s.length() - 1;
            while (j > i) {
                if (s.charAt(i) == s.charAt(j)) {
                    len = Math.max(len, j - i - 1);
                    break;
                } else {
                    j--;
                }
            }
            i++;
        }
        return len;
    }
}