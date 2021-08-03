class Solution {
    long mod = (long)(1e9+7);
    public int countSpecialSubsequences(int[] nums) {
        long[] dp = new long[3];
        
        dp[0] = 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0)
                dp[0] = (dp[0]*2)%mod; // cur 0 sel or non-sel
            else if (nums[i] == 1)
                dp[1] = (dp[0]-1 + dp[1]*2)%mod; // remove the empty calculation
            else if (nums[i] == 2)
                dp[2] = (dp[1] + dp[2]*2)%mod;
        }
        
        return (int)dp[2];
    }
}

// 0
// 01
// 012
    
// init :
// dp[0] = 1; // mean include {} empty
// {0}
// {}
// {0  0}
// {   0}
// if (nums[i] == 0)
//     dp[0] = dp[0]*2; // cur 0 sel or non-sel
// else if (nums[i] == 1)
//     dp[1] = dp[0]-1 + dp[1]*2;
// else if (nums[i] == 2)
//     dp[2] = dp[1] + dp[2]*2;




// X X X X X : i
// X X X X X : 0
// 0   0 
// 0
//     0
// 0   0       0
// 0
//     0       0
