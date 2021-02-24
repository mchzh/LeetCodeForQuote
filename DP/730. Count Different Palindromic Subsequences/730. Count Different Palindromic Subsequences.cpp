class Solution {
public:
    int countPalindromicSubsequences(string S) {
        int N = S.size();
        S = "#" + S;
        int M = 1e9+7;
        auto next = vector<vector<int>>(N+1,vector<int>(4,N+1));
        auto prev = vector<vector<int>>(N+1,vector<int>(4,-1));        
        auto dp = vector<vector<int>>(N+1,vector<int>(N+1,0));  
        
        for (int k = 0; k < 4; k++) {
            int i = 0;
            for (int j = 0; j <= N; j++) {
                if (S[j]-'a' != k) continue;
                while (i <= j) {
                    next[i][k] = j;
                    i++;
                }
            }
        }
        for (int k = 0; k < 4; k++) {
            int i = N;
            for (int j = N; j >= 0; j--) {
                if (S[j]-'a' != k) continue;
                while (i >= j) {
                    prev[i][k] = j;
                    i--;
                }
            }
        }
        
        for (int i = 0; i <= N; i++) {
            dp[i][i] = 1;
        }
        
        for (int len = 2; len <= N; len++) {
            for (int i = 1; i <= N-len+1; i++) {
                int j = i+len-1;
                for (int k = 0; k < 4; k++) {
                    int p = next[i][k];
                    int q = prev[j][k];
                    
                    if (p < q) dp[i][j] += dp[p+1][q-1] + 1;
                    
                    if (next[i][k] <= j) dp[i][j] += 1; // corner case
                    dp[i][j] %= M;
                }
            }
        }
        
        return dp[1][N];
    }
};
