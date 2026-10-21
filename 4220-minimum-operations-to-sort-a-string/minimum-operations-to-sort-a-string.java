class Solution {
    public int minOperations(String s) {
        int n = s.length();
        
        // 1. Check if already sorted
        boolean sorted = true;
        for (int i = 1; i < n; i++) {
            if (s.charAt(i) < s.charAt(i - 1)) {
                sorted = false;
                break;
            }
        }
        if (sorted) return 0;
        
        // 2. Impossible if length is 2 and not sorted
        if (n == 2) return -1;
        
        // Find min and max characters and their frequencies
        char minChar = 'z';
        char maxChar = 'a';
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c < minChar) minChar = c;
            if (c > maxChar) maxChar = c;
        }
        
        int minCount = 0;
        int maxCount = 0;
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == minChar) minCount++;
            if (c == maxChar) maxCount++;
        }
        
        // 3. Can be sorted in 1 operation
        if (s.charAt(0) == minChar || s.charAt(n - 1) == maxChar) {
            return 1;
        }
        
        // 4. Requires 3 operations:
        // First char is the unique max AND last char is the unique min
        if (s.charAt(0) == maxChar && maxCount == 1 && 
            s.charAt(n - 1) == minChar && minCount == 1) {
            return 3;
        }
        
        // 5. Otherwise, 2 operations are always sufficient
        return 2;
    }
}