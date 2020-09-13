class Solution {
    static bool cmp(pair<int, int>&a, pair<int, int>&b) {
        if (a.first == b.first) {
            return a.second > b.second;
        } else {
            return a.first < b.first;
        }
    }
public:
    vector<vector<int>> intervalIntersection(vector<vector<int>>& A, vector<vector<int>>& B) {
        vector<pair<int, int>>p;
        for (auto x : A) {
            p.push_back({x[0], 1});
            p.push_back({x[1], -1});
        }
        for (auto x : B) {
            p.push_back({x[0], 1});
            p.push_back({x[1], -1});
        }
        sort(p.begin(), p.end(), cmp);
        
        vector<vector<int>>rets;
        int start, end;
        int count = 0;
        for (auto x : p) {
            count += x.second;
            if (x.second == 1 && count == 2) {
                start = x.first;
            } else if (x.second == -1 && count == 1) {
                end = x.first;
                rets.push_back({start, end});
            }
        }
        return rets;
    }
};
