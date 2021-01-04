class Solution {
    public int waysToSplit(int[] nums) {
        long mod = 1000000007;
        int n = nums.length;
        long[] presum = new long[n];
        presum[0] = nums[0];
        for (int i = 1; i <n; i++) {
            presum[i] = presum[i-1] + nums[i];
        }
        
        long rets = 0;
        //long total = presum[n];
        
        int j = 0, k = 0;
        for (int i = 0; i < n; i++) { // j, k not recover to initial postion, it can continue to increasing their pos
            while (j<= i || (j < n && presum[j]-presum[i] <presum[i]) ) j++;
            if (j == n) break;
            
            while (k+1 < n-1 && 2*presum[k+1]<=presum[n-1]+presum[i]) k+=1;
            if (k < j) continue;
            
            rets += k-j+1;
            
            rets %= mod;
        }
        return (int)rets;
    }
}

// [X X X] [X X X| X X X] X X X
//      i        j     k      n-1
// k is a upper bound for the second subarray
// presum[k]-presum[i]<=presum[n]-presum[k]
// 2*presum[k]<=presum[n]+presum[i]
