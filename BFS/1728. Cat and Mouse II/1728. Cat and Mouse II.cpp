class Solution {
    int memo[9][9][9][9][3]; // m: x y; c: x y; turn: 1&2
    pair<int, int>food;
    pair<int, int>mouse;
    pair<int, int>cat;
    vector<string>grid;
    int catJump;
    int mouseJump;
public:
    bool canMouseWin(vector<string>& grid, int catJump, int mouseJump) {
        this->grid = grid;
        this->catJump = catJump;
        this->mouseJump = mouseJump;
        int m = grid.size(), n = grid[0].size();
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 'F') {
                    food = {i, j};
                } else if (grid[i][j] == 'M') {
                    mouse = {i, j};
                } else if (grid[i][j] == 'C') {
                    cat = {i, j};
                }
            }
        }
        
        queue<array<int, 5>> q;
        // get win status
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '#') continue;
                if (i == food.first && j == food.second) continue;
                for (int t =1; t <= 2; t++) {
                    memo[i][j][food.first][food.second][t] = 2;
                    memo[food.first][food.second][i][j][t] = 1;
                    q.push({i, j, food.first, food.second, t});
                    q.push({food.first, food.second, i, j, t});
                }
            }
        }
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int t =1; t <= 2; t++) {
                    if (grid[i][j] == '#') continue;
                    memo[i][j][i][j][t] = 2;
                    q.push({i, j, i, j, t});
                }
            }
        }
        
        int step = 0;
        while (!q.empty()) {
            step++;
            if (step > 2000) return false;
            
            int len = q.size();
            while (len--) {
                int mx = q.front()[0];
                int my = q.front()[1];
                int cx = q.front()[2];
                int cy = q.front()[3];
                int t = q.front()[4];
                int status = memo[mx][my][cx][cy][t];
                q.pop();

                for (auto next : getAllAdjacents(mx, my, cx, cy, t)) {
                    int mx2 = next[0];
                    int my2 = next[1];
                    int cx2 = next[2];
                    int cy2 = next[3];
                    int t2 = next[4];

                    if (memo[mx2][my2][cx2][cy2][t2] != 0) continue;
                    
                    if (t2 == status) {
                        memo[mx2][my2][cx2][cy2][t2] = status;
                        q.push({mx2, my2, cx2, cy2, t2});
                    } else if (allAdjacentWin(mx2, my2, cx2, cy2, t2)) {
                        memo[mx2][my2][cx2][cy2][t2] = (t2 == 1) ? 2 : 1;
                        q.push({mx2, my2, cx2, cy2, t2});
                    }
                }
            }
            
        }
        
        return memo[mouse.first][mouse.second][cat.first][cat.second][1] == 1;
    }
    
    vector<array<int, 5>> getAllAdjacents(int mx, int my, int cx, int cy, int t) {
        vector<array<int, 5>>adjacents;
        int m = grid.size(), n = grid[0].size();
        vector<pair<int, int>> dir = {{0,1}, {0,-1}, {1,0}, {-1,0}};
        if (t == 1) {
            for (int k = 0; k < 4; k++) {
                for (int i = 0; i <= catJump; i++) {
                    int cx2 = cx + dir[k].first*i;
                    int cy2 = cy + dir[k].second*i;
                    if (cx2 < 0 || cx2 >= m || cy2 < 0 || cy2 >= n) continue;
                    if (grid[cx2][cy2] == '#') break;
                    adjacents.push_back({mx, my, cx2, cy2, 2});
                }
            }
        } else if (t == 2){
            for (int k = 0; k < 4; k++) {
                for (int i = 0; i <= mouseJump; i++) {
                    int mx2 = mx + dir[k].first*i;
                    int my2 = my + dir[k].second*i;
                    if (mx2 < 0 || mx2 >= m || my2 < 0 || my2 >= n) continue;
                    if (grid[mx2][my2] == '#') break;
                    adjacents.push_back({mx2, my2, cx, cy, 1});
                }
            }
        }
        
        return adjacents;
    }
    bool allAdjacentWin(int mx, int my, int cx, int cy, int t) {
        int m = grid.size(), n = grid[0].size();
        vector<pair<int, int>> dir = {{0,1}, {0,-1}, {1,0}, {-1,0}};
        if (t == 1) {
            for (int k = 0; k < 4; k++) {
                for (int i = 0; i <= mouseJump; i++) {
                    int mx2 = mx + dir[k].first*i;
                    int my2 = my + dir[k].second*i;
                    if (mx2 < 0 || mx2 >= m || my2 < 0 || my2 >= n) break;
                    if (grid[mx2][my2] == '#') break;
                    
                    if (memo[mx2][my2][cx][cy][2] != 2) return false;
                }
            }
        } else if (t == 2){
            for (int k = 0; k < 4; k++) {
                for (int i = 0; i <= catJump; i++) {
                    int cx2 = cx + dir[k].first*i;
                    int cy2 = cy + dir[k].second*i;
                    if (cx2 < 0 || cx2 >= m || cy2 < 0 || cy2 >= n) break;
                    if (grid[cx2][cy2] == '#') break;
                    if (memo[mx][my][cx2][cy2][1] != 1) return false;
                }
            }
        }
        
        return true;
    }
};
