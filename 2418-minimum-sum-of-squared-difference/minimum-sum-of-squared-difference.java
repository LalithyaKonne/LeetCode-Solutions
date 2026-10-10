import java.util.*;

class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        int n = nums1.length;
        long k = (long) k1 + k2;
        long[] diff = new long[n];
        long max = 0, sum = 0;

        for (int i = 0; i < n; i++) {
            diff[i] = Math.abs(nums1[i] - nums2[i]);
            max = Math.max(max, diff[i]);
            sum += diff[i];
        }

        if (sum <= k) return 0;

        long low = 0, high = max;

        while (low < high) {
            long mid = (low + high) / 2;
            long needed = 0;

            for (long d : diff) {
                if (d > mid) needed += d - mid;
            }

            if (needed <= k) high = mid;
            else low = mid + 1;
        }

        long remaining = k;
        for (int i = 0; i < n; i++) {
            if (diff[i] > low) {
                remaining -= diff[i] - low;
                diff[i] = low;
            }
        }

        for (int i = 0; i < n && remaining > 0; i++) {
            if (diff[i] == low && low > 0) {
                diff[i]--;
                remaining--;
            }
        }

        long ans = 0;
        for (long d : diff) {
            ans += d * d;
        }

        return ans;
    }
}