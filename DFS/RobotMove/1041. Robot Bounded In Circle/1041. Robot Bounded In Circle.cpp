class Solution {
public:
    bool isRobotBounded(string instructions) {
        vector<int>cur = {0, 0};
        vector<vector<int>>dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int dir = 0;// 0 north up, 1 right, 2 down, 3 left;
        
        for ( int i = 0; i < instructions.size(); i++ ) {
            if (instructions[i] == 'G') {
                cur[0] += dirs[dir][0];
                cur[1] += dirs[dir][1];
            } else if (instructions[i] == 'L') {
                dir = (dir+3) %4;
            } else {
                dir = (dir+1) %4;
            }
        }
        
        if (cur[0] == 0 && cur[1] == 0) return true; // locate in the original point
        else if (dir == 0) return false; // north direction but has offset
        return true;
    }
};
