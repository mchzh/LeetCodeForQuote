class Solution {
    static bool cmp(pair<int, int>&a, pair<int, int>&b) {
        if (a.first == b.first) return a.second > b.second;
        else return a.first < b.first;
    }
public:
    vector<vector<int>> insert(vector<vector<int>>& intervals, vector<int>& newInterval) {
        vector<pair<int, int>>q;
        for (auto x : intervals) {
            q.push_back({x[0], 1});
            q.push_back({x[1], -1});
        }
        q.push_back({newInterval[0], 1});
        q.push_back({newInterval[1], -1});
        
        sort(q.begin(), q.end(), cmp);
        
        int count = 0;
        int start, end;
        vector<vector<int>> rets;
        for (auto x : q) {
            count += x.second;
            if (x.second == 1 && count == 1) {
                start = x.first;
            } else if (x.second == -1 && count == 0) {
                end = x.first;
                rets.push_back({start, end});
            }
        }
        return rets;
    }
};

// ------
//     ----
//       -----
//            -----
