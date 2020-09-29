class Solution {
    int memo[1001];
    int dis;
public:
    int maxJumps(vector<int>& arr, int d) {
        int ret = 0;
        dis = d;
        for (int i = 0; i < arr.size(); i++) {
            dfs(i, arr);
            ret = max(ret, memo[i]);
        }        
        
        return ret;
    }
    int dfs(int i, vector<int>& arr) {
        if (memo[i] != 0) return memo[i];
        int ret = 1;
        for (int k = 1; k <= dis; k++) {
            if (i+k >= arr.size()) break;
            if (arr[i+k] >= arr[i]) break; 
            ret = max(ret, dfs(i+k, arr)+1);
        }
        for (int k = 1; k <= dis; k++) {
            if (i-k < 0) break;
            if (arr[i-k] >= arr[i]) break; 
            ret = max(ret, dfs(i-k, arr)+1);
        }
        memo[i] = ret;
        return ret;
    }
};

// 14 -> f(6) 
//     -> f(8)
//     max(all path)
