class Solution {
public:
    vector<int> smallestRange(vector<vector<int>>& nums) {
        set<pair<int,int>> Set;
        int n = nums.size();
        vector<int>pointer(n);
        for (int i= 0; i < n ; i++) {
            pointer[i] = 0;
            Set.insert({nums[i][0], i});
        }
        
        int range = INT_MAX;
        vector<int>rets;
        while (1) {
            if (Set.rbegin()->first - Set.begin()->first < range) {
                range = Set.rbegin()->first - Set.begin()->first;
                rets = {Set.begin()->first, Set.rbegin()->first};
            }
            int i = Set.begin()->second;
            pointer[i]++;
            // exit condition
            if (pointer[i] == nums[i].size()) break;
            Set.erase(Set.begin());
            Set.insert({nums[i][pointer[i]], i});
        }
        
        return rets;
    }
};
