class Solution {
    static bool cmp(pair<int, int> a, pair<int, int> b) {
        if (a.first == b.first) return a.second > b.second;
        else return a.first < b.first;
    }
public:
    vector<vector<int>> merge(vector<vector<int>>& intervals) {
        vector<pair<int, int>>sweep;
        for (auto x : intervals) {
            sweep.push_back({x[0], 1});
            sweep.push_back({x[1], -1});
        }
        sort(sweep.begin(), sweep.end(), cmp);
        
        int count = 0;
        vector<vector<int>>rets;
        int start, end;
        for (auto x : sweep) {
            if (x.second == 1) {
                count++;
                if (count == 1) start = x.first; 
            } else {
                count--;
                if (count == 0) {
                    end = x.first;
                    rets.push_back({start, end});
                }
            }
        }
        return rets;
    }
};

// 2-------4
//     3-------8
// 2-----------8
// time (start/end, label 1/-1)
    
// 1-------4
//         4-------8
