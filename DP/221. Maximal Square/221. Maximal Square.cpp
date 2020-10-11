class Solution {
public:
    int maximalSquare(vector<vector<char>>& matrix) {
        int M = matrix.size();
        if (M == 0) return 0;
        int N = matrix[0].size();
        auto dp = vector<vector<int>>(M+1, vector<int>(N+1, 0));
        int maxsqlen = 0;
        
        for(int i = 1; i<= M; i++) {
            for(int j = 1; j <= N; j++) {
                if(matrix[i-1][j-1] == '1') {
                    dp[i][j] = min(min(dp[i][j-1],dp[i-1][j]), dp[i-1][j-1]) + 1;
                    maxsqlen = max(maxsqlen, dp[i][j]);
                }
            }
        }
        return maxsqlen * maxsqlen ;
    }
};
