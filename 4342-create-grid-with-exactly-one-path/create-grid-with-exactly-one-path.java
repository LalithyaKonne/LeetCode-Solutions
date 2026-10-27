class Solution {
    public String[] createGrid(int m, int n) {
        String[] res = new String[m];

        // All rows except the last have '.' at the start, followed by '#'
        String topRows = "." + "#".repeat(n - 1);
        for (int i = 0; i < m - 1; i++) {
            res[i] = topRows;
        }

        // The very last row is entirely '.'
        res[m - 1] = ".".repeat(n);

        return res;
    }
}