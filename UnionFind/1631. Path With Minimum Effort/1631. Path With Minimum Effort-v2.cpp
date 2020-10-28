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
    int minimumEffortPath(vector<vector<int>>& heights) {
        int m = heights.size();
        int n = heights[0].size();
        
        Father.resize(m*n);
        for (int i = 0; i < m*n; i++) Father[i] = i;
        
        vector<vector<int>>edges;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (j+1 < n) edges.push_back({abs(heights[i][j]-heights[i][j+1]), i*n+j, i*n+j+1});
                if (i+1 < m) edges.push_back({abs(heights[i][j]-heights[i+1][j]), i*n+j, (i+1)*n+j});
            }
        }
        sort(edges.begin(), edges.end());
        
        for (auto edge : edges) {
            if (FindFather(edge[1]) != FindFather(edge[2])) Union(edge[1], edge[2]);
            if (FindFather(0) == FindFather(m*n-1)) return edge[0];
        }
        return 0;
    }
};
