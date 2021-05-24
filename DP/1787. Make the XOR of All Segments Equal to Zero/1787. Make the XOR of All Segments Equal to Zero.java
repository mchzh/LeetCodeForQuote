class Solution {
    int[][] dp = new int[2001][1024];
    int[] totalCnt = new int[2001];
    int[][] count = new int[2001][1024];
    public int minChanges(int[] nums, int k) {
        for (int[] d : dp) Arrays.fill(d, Integer.MAX_VALUE);
        int n = nums.length;
        for (int i = 0; i < k; i++) {
            for (int j = i; j < n; j += k) {
                totalCnt[i]++;
                count[i][nums[j]]++;
            }
        }
        for (int d = 0; d < 1024; d++) {
            dp[0][d] = totalCnt[0]-count[0][d];
        }
       
        for (int i = 1; i < k; i++) {
            // the minimun number of dp[i-1][X]
            int minCost = Integer.MAX_VALUE;
            int x = -1;
            for (int d = 0; d < 1024; d++) {
                if (dp[i-1][d] < minCost) {
                    minCost = dp[i-1][d];
                    x = d;
                }
            }
            
            for (int d = 0; d < 1024; d++) {
                //v is not in set
                dp[i][d] = Math.min(dp[i][d], minCost + (totalCnt[i]-count[i][d^x]));
                // v is in set
                for (int j = i; j < n; j += k) {
                    int v = nums[j];
                    dp[i][d] = Math.min(dp[i][d], dp[i-1][d^v] + (totalCnt[i]-count[i][v]));
                }
            }
        }
        
        return dp[k-1][0];
    }
}
// A1^A2^A3
// =
// A2^A3^A4
// =
// A3^A4^A5
// A1 = A4 =A7
// Set: {A[i], A[i+k], A[i+2k]....A[i+j*k]}
// i is pos, d is the XOR-sum
// dp[i][d]: the minimum number of elements to change in the array such that the XOR-sum is d end with ith element of K size
// dp[i][d] = min(dp[i][d], dp[i-1][x] + costofchangeasV(nums, i, v)); (v : 0...1024 v^x = d) nums[i] -> v

// for (int i = 0; i <= k; i++) {
//     for (int d = 0; d < 1024; d++) {
//         for (int v = 0; v < 1024; v++) {
//             dp[i][d] = min(dp[i][d], dp[i-1][d^v] + costofchangeasV(nums, i, v));
//         }
//     }
// }
// 1. v is in Set{i}
// for (int i = 0; i <= k; i++) {
//     for (int d = 0; d < 1024; d++) {
//         for (int v in Set{i}) {
//             dp[i][d] = min(dp[i][d], dp[i-1][d^v] + totalCnt{i}-count[i][v]);
//         }
//     }
// }
// 2. v is not in Set{i} => count[i][v] == 0 means the third loop is non-related v
// for (int i = 0; i <= k; i++) {
//     for (int d = 0; d < 1024; d++) {
//         v is not in set
//         the minimun number of dp[i-1][X]
//         dp[i][d] = min(dp[i][d], dp[i-1][X] + totalCnt{i}); // depend on dp[i-1]
//     }
// }
