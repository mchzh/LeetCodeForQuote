class Solution {
    // Greedy
    public int minNumberOperations(int[] target) {
        int rets = 0;
        int n = target.length;
        int cur = 0;
        for (int i = 0; i < n; i++) {
            if (target[i] > cur) rets += target[i] - cur;
            cur = target[i];
        }
        return rets;
    }
}
// increasing order to add;
// decreasing sequence do nothing;
