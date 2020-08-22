class Solution {
public:
    bool escapeGhosts(vector<vector<int>>& ghosts, vector<int>& target) {
        int dis = abs(target[0]) + abs(target[1]);
        for (auto g : ghosts) {
            int gd = abs(target[0]-g[0]) + abs(target[1]-g[1]);
            if (gd <= dis) return false;
        }
        return true;
    }
};
