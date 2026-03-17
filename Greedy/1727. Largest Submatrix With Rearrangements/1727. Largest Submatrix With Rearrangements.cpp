class Solution {
public:
    int largestSubmatrix(vector<vector<int>>& matrix) {
        int m = matrix.size(), n = matrix[0].size();
        vector<int> height(n, 0);
        int rets = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int cur = matrix[i][j];
                height[j] = cur == 0 ? 0 : height[j] + 1;
            }
            auto cur = height;
            sort(cur.begin(), cur.end());
            reverse(cur.begin(), cur.end());
            for (int s = 0; s < n; s++) {
                rets = max(rets, cur[s]*(s+1)); // h* len
            }
        }
        return rets;
    }
};
