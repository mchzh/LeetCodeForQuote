class Solution {
    // https://leetcode.com/problems/toss-strange-coins/discuss/427818/Java-(from-DFS-%2B-memo-to-2D-DP-to-1D-DP)
    // Use DP with two states dp[pos][cnt], where pos represents the pos-th coin and cnt is the number of heads seen so far.
    double ret = 0.0;
    private Double[][] dp;
    public double probabilityOfHeads(double[] prob, int target) {
        // dfs(TLE) to dfs+memo to dp
        // dfs return a prob 
        int N = prob.length;
        dp = new Double[N+1][target+1];
        return helper(0, prob, target);
    }
    private double helper(int idx, double[] prob, int target) {
        if (target < 0) return 0.0;
        if (idx == prob.length) {
            return target == 0 ? 1.0 : 0.0;
        }
        
        if (dp[idx][target] != null) {
            return dp[idx][target];
        }
        
        dp[idx][target] = 0.0;
        dp[idx][target] += prob[idx] * helper(idx +1, prob, target-1);
        dp[idx][target] += (1-prob[idx]) * helper(idx +1, prob, target);
        return dp[idx][target];
    }
    
    private void dfs(int idx, int count, double[] prob, int target, double curprob) {
        if (count > target) {
            return;
        }
        if (idx == prob.length) {
            if (count == target) {
                ret += curprob;
            }
            return;
        }
        double withCoin = curprob*prob[idx];
        double withoutCoin = curprob*(1-prob[idx]);
        dfs(idx+1, count+1, prob, target, withCoin);
        dfs(idx+1, count, prob, target, withoutCoin);
    }
}
