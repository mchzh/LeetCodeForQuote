class Solution {
    public int distinctSubseqII(String S) {
        int n = S.length();
        long mod = (long)1e9+7;
        long[] dp = new long[n+1];
        String s = "#" + S;
        Map<Character, Integer> map = new HashMap<>();
        
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            char c = s.charAt(i);
            dp[i] = (dp[i-1]*2) %mod;
            if (map.containsKey(c)) {
                dp[i] = (dp[i] - dp[map.get(c)-1] + mod)%mod;
            }
            map.put(c, i);
        }
        return (int)dp[n]-1;
    }
}

// dp[i]: count the number of distinct, non-empty subsequences of S[1...i]

// X X X X X X i a
// ?
// ??
// ???
// ????
// ?a
// ??a
// ???a
// ????a
// dp[i] = dp[i]*2
    
// X X X X a (j) Y Y Y Y a (i)
// X X X X a - j
// X X X X a - i
// dp[i] -= dp[j-1]
