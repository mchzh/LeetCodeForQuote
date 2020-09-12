class Solution {
public:
    vector<vector<int>>rets;
    vector<vector<int>> combinationSum2(vector<int>& candidates, int target) {
        sort(candidates.begin(), candidates.end());
        vector<int>comb;
        DFS(candidates, target, 0, 0, comb);
        return rets;
    }
    void DFS(vector<int>& candidates, int target, int sum, int pos, vector<int>&comb) {
        if (sum > target) return;
        if (sum == target) {
            rets.push_back(comb);
            return;
        }
        
        for (int i = pos; i < candidates.size(); i++) {
            // remove the duplicate element
            // later one cannot retrive if previous same element not be selected
            if (i > pos && candidates[i-1] == candidates[i]) continue;
            comb.push_back(candidates[i]);
            DFS(candidates, target, sum+candidates[i], i+1, comb);
            comb.pop_back();
        }
    }
};
