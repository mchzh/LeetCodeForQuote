class Solution {
public:
    vector<vector<long long>> splitPainting(vector<vector<int>>& segments) {
        map<long long, long long> map;
        for (auto s : segments) {
            map[s[0]] += s[2];
            map[s[1]] -= s[2];
        }
        
        vector<vector<long long>> rets;
        long start = -1, end = -1;
        long sum = 0;
        for (auto m : map) {
            auto [pos, diff] = m;
            
            if (start == -1) {
                start = pos;
            } else {
                end = pos;
                rets.push_back({start, end, sum});
                start = end;
            }
            
            sum += diff;
            if (sum == 0) start = -1;
        }
        return rets;
    }
};
