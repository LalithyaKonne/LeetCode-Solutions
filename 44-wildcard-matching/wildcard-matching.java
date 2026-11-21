
class Solution {
    public boolean isMatch(String s, String p) {

        int i = 0;
        int j = 0;

        int star = -1;
        int match = 0;

        while (i < s.length()) {

            // Case 1: Characters match or ? is found
            if (j < p.length() &&
                (s.charAt(i) == p.charAt(j) ||
                 p.charAt(j) == '?')) {

                i++;
                j++;
            }

            // Case 2: * is found
            else if (j < p.length() &&
                     p.charAt(j) == '*') {

                star = j;
                match = i;

                j++;
            }

            // Case 3: Mismatch, but previous * exists
            else if (star != -1) {

                j = star + 1;

                match++;
                i = match;
            }

            // Case 4: No possible match
            else {

                return false;
            }
        }

        // Remaining pattern characters must all be *
        while (j < p.length() &&
               p.charAt(j) == '*') {

            j++;
        }

        return j == p.length();
    }
}
