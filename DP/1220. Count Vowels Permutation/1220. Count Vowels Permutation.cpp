class Solution {
public:
    int countVowelPermutation(int n) {
        long mod = 1e9+7;
        vector<long>dp(5, 0);
        for (int k = 0; k < 5; k++) {
            dp[k] = 1;
        }
        
        for (int i = n-2; i >= 0; i--) {
            auto old_dp = dp;
            
            dp[0] = old_dp[1];
            dp[1] = (old_dp[0] + old_dp[2]) %mod;
            dp[2] = (old_dp[0] + old_dp[1] + old_dp[3] + old_dp[4]) %mod;
            dp[3] = (old_dp[2] + old_dp[4]) % mod;
            dp[4] = old_dp[0];
        }
        
        // sum all five status
        long total = 0;
        for (int k = 0; k < 5; k++) {
            total = (total + dp[k]) % mod;
        }
        
        return total;
    }
};


// dp[i][0]: how many strings of s[0..i] can be formed ending with s[i] = 'a';
// dp[i][1]: how many strings of s[0..i] can be formed ending with s[i] = 'e';
// dp[i][2]: how many strings of s[0..i] can be formed ending with s[i] = 'i';
// dp[i][3]: how many strings of s[0..i] can be formed ending with s[i] = 'o';
// dp[i][4]: how many strings of s[0..i] can be formed ending with s[i] = 'u';

// dp[i][0] = dp[i+1][1];
// dp[i][1] = dp[i+1][0] + dp[i+1][2];
// ....
