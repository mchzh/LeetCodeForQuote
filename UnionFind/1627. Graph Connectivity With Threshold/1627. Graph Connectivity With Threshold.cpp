class Solution {
    vector<int>Father;
    int FindFather(int x) {
        if (x != Father[x]) {
            Father[x] = FindFather(Father[x]);
        }
        return Father[x];
    }
    
    void Union(int x, int y) {
        x = FindFather(x);
        y = FindFather(y);
        if (x < y) {
            Father[y] = x;
        } else {
            Father[x] = y;
        }
    }
public:
    vector<bool> areConnected(int n, int threshold, vector<vector<int>>& queries) {
        // set parent for union find
        Father.resize(n+1);
        for (int i = 1; i <= n; i++) Father[i] = i;
        
        // threshold as the ourter loop
        //unordered_set<int>visited;
        vector<int>visited(n+1);
        for (int k = threshold+1; k <= n; k++) {
            if (visited[k]) continue;
            for (int x = 2*k; x <= n; x+=k) {
                Union(x, k);
                visited[x] = 1;
            }
        }
        
        vector<bool>rets;
        for (auto query : queries) {
            bool b = (FindFather(query[0]) == FindFather(query[1]));
            rets.push_back(b);
        }
            
        return rets;
    }
};
