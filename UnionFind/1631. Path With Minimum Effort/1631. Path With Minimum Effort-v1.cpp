class Solution {
public:
    int minimumEffortPath(vector<vector<int>>& heights) {
        // binary serach
        int left = 0, right = 1000000;
        
        while (left < right) {
            int mid = left + (right - left)/2;
            if ( isOk(heights, mid) ) {
                right = mid;
            } else 
                left = mid + 1;
        }
        return left;
    }
    bool isOk(vector<vector<int>>& heights, int a) {
        int m = heights.size();
        int n = heights[0].size();
        
        queue<pair<int, int>>q;
        q.push({0, 0});
        auto visited = vector<vector<int>>(m, vector<int>(n, 0));
        visited[0][0] = 1;
        auto dir = vector<pair<int, int>>({{1, 0},{-1, 0},{0, 1},{0, -1}});
        
        while (!q.empty()) {
            int x = q.front().first;
            int y = q.front().second;
            q.pop();
            
            for (int k = 0; k < 4; k++) {
                int cx = x + dir[k].first;
                int cy = y + dir[k].second;
                
                if (cx < 0 || cx >= m) continue;
                if (cy < 0 || cy >= n) continue;
                if (visited[cx][cy] == 1) continue;
                if (abs(heights[cx][cy] - heights[x][y]) > a) continue;
                
                q.push({cx, cy});
                visited[cx][cy] = 1;
            }
        }
        return visited[m-1][n-1] == true;
    }
};

// [0, INT_MAX] 32 pow(2, 32)
