class Solution {
public:
    vector<vector<int>>rets_re;
    vector<vector<int>> combine(int n, int k) {
        vector<int>comb;
        DFS(n, k, 1, comb);
        return rets_re;
    }
    void DFS(int n, int k, int cur, vector<int>&comb) {
        if (comb.size() == k) {
            rets_re.push_back(comb);
            return;
        }
        //backtracking
        for (int i = cur; i <= n; i++) {
            comb.push_back(i);
            DFS(n, k, i+1, comb);
            comb.pop_back();
        }
    }
};
