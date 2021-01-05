class Solution {
public:
    int minOperations(vector<int>& target, vector<int>& arr) {
        unordered_map<int, int>map;
        for (int i = 0; i < target.size(); i++) {
            map[target[i]] = i;
        }
        
        vector<int>arrextra;
        for (auto a : arr) {
            if (map.find(a) == map.end()) continue;
            arrextra.push_back(map[a]);
        }
        
        // LIS
        vector<int>lis;
        for (auto x : arrextra) {
            if (lis.size() == 0 || lis.back() < x ) {
                lis.push_back(x);
            } else {
                // get insert pos then update
                auto iter = lower_bound(lis.begin(), lis.end(), x);
                *iter = x;
            }
        }
        return target.size() - lis.size();
    }
};
