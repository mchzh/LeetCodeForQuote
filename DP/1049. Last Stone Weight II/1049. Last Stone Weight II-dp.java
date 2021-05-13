class Solution {
    public int lastStoneWeightII(int[] stones) {
        int n = stones.length;
        int sum = 0;
        for (int s : stones) sum += s;
        int halfSum = sum/2;
        int[] dp = new int[halfSum+1];
        
        for (int i = 1; i <= n; i++) {
            for (int j = halfSum;  j >= stones[i-1]; j--) {
                dp[j] = Math.max(dp[j], dp[j-stones[i-1]]+stones[i-1]); // j is capacity
            }
        }
        return sum-2*dp[halfSum];
    }
}
//dp[i] = max(dp[i], dp[i-s[i]]+s[i]);
