class Solution {
    public int minSteps(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[1] = 0;
        
        for (int i = 2; i <= n; i++) {
            for (int j = 2; j <= i; j++) { // j is the num of divide part
                if (i%j != 0) continue;
                int k = i/j;
                dp[i] = Math.min(dp[i], dp[k]+1+j-1);
                break;
            }
        }
        return dp[n];
    }
}

// 13
// A + 13
    
// 6
// AAA + 2
// AA  + 3
// A   + 6
    
// 12
// AAAAAA + 2
// AAAA   + 3
// AAA    + 4
// AA     + 6
// A      + 12

// n
// n/2 **
// n/3 ***
// n/4 ****
// dfs + memo

// class Solution {
//     public int minSteps(int n) {
//         if(n==1)
//         {
//             return 0;
//         }
//         int s=2;
//         while(s<n/2)
//         {
//             if(n%s==0)
//             {
               
//                 return (s)+ minSteps(n/s);
//             }
//             s++;
//         }
//         return n;
//     }

// }
