class Solution {
    public int findMinMoves(int[] machines) {
        int n = machines.length;
        int sum = 0;
        for (int m : machines) sum += m;

        if (sum%n != 0) return -1;
        int k = sum/n;

        int[] left = new int[n];
        int[] right = new int[n];
        left[n-1] = machines[n-1] - k;
        right[0] = machines[0] - k;

        for (int i = 1; i < n-1; i++) {
            left[i] = -right[i-1];
            right[i] = machines[i] - k - left[i];
        }

        int rets = 0;
        for (int i = 0; i < n; i++) {
            int cur = 0;
            if (left[i] >= 0) cur += left[i];
            if (right[i] >= 0) cur += right[i];
            rets = Math.max(rets, cur);
        }
        return rets;
    }
}

// left[i] + right[i] = m[i] - k
// right[i] = -left[i+1];
// left[i] = -right[i-1]
