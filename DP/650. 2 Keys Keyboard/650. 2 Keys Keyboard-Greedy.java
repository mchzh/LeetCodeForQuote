class Solution {
    public int minSteps(int n) {
        if (n <= 1) return 0;
        int s = 0;
        for (int d = 2; d <= n; d++) {
            while (n % d == 0) {
                s += d;
                n /= d;
            }
        }
        return s;
    }
}
