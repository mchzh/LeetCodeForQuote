class Solution {
    public int findIntegers(int n) {
         // robber dp
        int[] dp = new int[33];
        dp[0] = 1;
        dp[1] = 2; // 0 or 1
        for (int i = 2; i <=32; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        
        // get all digit for n
        int[] digits = new int[33];
        for (int i = 1; i <= 32; i++) {
            digits[i] = n%2; // (n>>i)&1
            n /= 2;
        }
        
        // from highest digits go to lowerest digit
        int i = 32;
        int rets = 0;
        while (i >= 1) {
            if (digits[i] == 0) i -= 1; // recursive  C type
            else {
                // Plan A: candidate use 0 
                rets += dp[i-1];
                
                // Plan B: look forward more one digits
                if (i >= 2 && digits[i-1]== 1) {
                    rets += dp[i-2];
                    return rets;
                } else {
                    i -= 2;
                }
            }
        }
        
        rets += 1;
        return rets;
    }
}

// XXXXXXXXX -> robber host
// dp[i]: i is 1 then dp[i-2]; i is not 1 dp[i-1] -> robber i-1 or robber i-2
    
// current number has 32 digits:
// X X X X X X X X
// ? ? ? ? ? ? ? ?

// (A)
// 1 X X X X X X
// 0 ? ? ? ? ? ?    res += dp[i-1] -> use 0 all element < current

// (B)
// 1 X X X X X X X
// 1 ? ? ? ? ? ? ?
    
//     consider the next digits of this highest digit
//     (B1)
//     1 1 X X X X X X    consective 1
//     1 0 ? ? ? ? ? ?    res += dp[i-2] -> has to use 0, if 1 will generate consecutive 1
    
//     (B2)
//     1 0 X X X X X X
//     1 0 ? ? ? ? ? ?   res += dfs(30);

// (C)
// 0 X X X X X X X
// 0 ? ? ? ? ? ? ?      res -> dfs(31);
