class Solution {
    public int subarraysWithMoreZerosThanOnes(int[] nums) {
        int n = nums.length;
        int[] map = new int[2*n+1];
        long[][] dp = new long[n+1][3]; //[less, same, more]
        
        
        map[0+n] = 1;
        int cursum = 0;
        for (int i = 0; i < n; i++) {
            int cur = nums[i];
            cursum += 1-((cur^1)<<1); // 0 sum with -1
            dp[i+1][1] = map[cursum+n];
            
            if (cur == 1) {
                dp[i+1][2] = 1 + dp[i][2] + dp[i][1];
                dp[i+1][0] = i+1 - dp[i+1][2] - dp[i+1][1];
            } else {
                dp[i+1][0] = 1 + dp[i][0] + dp[i][1];
                dp[i+1][2] = i+1 - dp[i+1][1] - dp[i+1][0];
            }
            
            map[cursum+n]++;
        }
        
        long mod = (long)(1e9+7);
        long rets = 0;
        for (int i = 0; i < n+1; i++) {
            rets = (rets+dp[i][2]) % mod;
        }
        return (int)rets;
    }
}

// X X X X X X i

// a[i] = 0;
// a[i-1]

// a[i] = 1;
// a[i-1]


// 0 0 0 1 1 1 0 1 1 0 | 1

// dp[i][0]: the count of with the same 1 and 0 end with i;
// dp[i][1]: the count of more 1 than 0 end with i;

// so dp[i][-1]: the count of less 1 than 0 end with i = (i+1) - dp[i][0] - dp[i][1] // total minus all other situation
    
// dp[i][0] = how many presum equal;

// 1): a[i] == 1;
//     dp[i][1] += 1 // itself
//     dp[i][1] += dp[i-1][0] + dp[i-1][1]
// 2): a[i] = 0;
//     dp[i][1] = i+1 - dp[i][0] - dp[i][-1];
//     how to caculate dp[i][-1]? dpend on i-1 pos situation
//     end with it will add one more zero for i-1 pos from dp[i-1][0] will be change as dp[i][-1]
//     dp[i][-1] = 1(0 itself)+dp[i-1][0] + dp[i-1][-1] = i - dp[i-1][1]; 
    
