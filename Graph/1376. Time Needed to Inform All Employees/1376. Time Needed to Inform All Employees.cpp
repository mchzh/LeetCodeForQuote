class Solution {
public:
    int numOfMinutes(int n, int headID, vector<int>& manager, vector<int>& informTime) {
        int rets = 0;
        for (int i = 0; i < n; i++) {
            rets = max(rets, dfs(i, manager, informTime));
        }
        return rets;
    }
    int dfs(int pos, vector<int>& manager, vector<int>& informTime) {
        if (manager[pos] != -1) {
            informTime[pos] += dfs(manager[pos], manager, informTime);
            manager[pos] = -1;
        }
        return informTime[pos];
    }
};
