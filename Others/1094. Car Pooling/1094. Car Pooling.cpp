class Solution {
public:
    bool carPooling(vector<vector<int>>& trips, int capacity) {
        vector<pair<int, int>>diff;
        for (auto t : trips) {
            diff.push_back({t[1], t[0]});
            diff.push_back({t[2], -t[0]});
        }
        sort(diff.begin(), diff.end());
        int reach = 0;
        for (auto d : diff) {
            reach += d.second;
            if (reach > capacity) return false;
        }
        return true;
    }
};
