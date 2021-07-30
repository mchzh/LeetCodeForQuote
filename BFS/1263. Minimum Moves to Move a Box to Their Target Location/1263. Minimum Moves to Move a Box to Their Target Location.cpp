class Solution {
    struct Node {
        int bx, by, px, py;        
    };
public:
    int minPushBox(vector<vector<char>>& grid) {
        int bx, by, px, py, tx, ty;
        int m = grid.size(), n = grid[0].size();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 'S') {
                    px = i;
                    py = j;
                    grid[i][j] = '.';
                } else if (grid[i][j] == 'T') {
                    tx = i;
                    ty = j;
                    grid[i][j] = '.';
                } else if (grid[i][j] == 'B') {
                    bx = i;
                    by = j;
                    grid[i][j] = '.';
                }
            }
        }
        
        deque<Node>q;
        int level[21][21][21][21];
        q.push_back({bx, by, px, py});
        memset(level, 255, sizeof(level));
        level[bx][by][px][py] = 0;
        auto dirs = vector<pair<int, int>>({{-1,0},{1,0},{0,-1},{0,1}});
        
        while (!q.empty()) {
            auto [bx, by, px, py] = q.front();
            q.pop_front();
            
            if (bx == tx && by == ty) return level[bx][by][px][py];
            
            // only person move
            for (int k = 0; k < 4; k++) {
                int x = px + dirs[k].first;
                int y = py + dirs[k].second;
                if (x < 0 || x >= m || y < 0 || y >= n) continue;
                
                if (grid[x][y] != '.') continue;
                if (x == bx && y == by) continue;
                if (level[bx][by][x][y] >= 0) continue;
                level[bx][by][x][y] = level[bx][by][px][py];
                q.push_front({bx, by, x, y});
            }
            
            // move the person and box with neighbour
            if (abs(px-bx) + abs(py-by) == 1) {
                for (int k = 0; k < 4; k++) { 
                    if ( px+dirs[k].first == bx && py+dirs[k].second == by) { // on same direction to push
                        int bx2 = bx + dirs[k].first ;
                        int by2 = by + dirs[k].second;
                        if (bx2 < 0 || bx2 >= m || by2 < 0 || by2 >= n) continue;
                        if (grid[bx2][by2] != '.') continue;
                        if (level[bx2][by2][bx][by] >= 0) continue;
                        level[bx2][by2][bx][by] = level[bx][by][px][py]+1;
                        q.push_back({bx2, by2, bx, by});
                    }
                    
                }
            }
        }
        return -1;
    }
};
