/**
 * // This is the robot's control interface.
 * // You should not implement it, or speculate about its implementation
 * class Robot {
 *   public:
 *     // Returns true if the cell in front is open and robot moves into the cell.
 *     // Returns false if the cell in front is blocked and robot stays in the current cell.
 *     bool move();
 *
 *     // Robot will stay in the same cell after calling turnLeft/turnRight.
 *     // Each turn will be 90 degrees.
 *     void turnLeft();
 *     void turnRight();
 *
 *     // Clean the current cell.
 *     void clean();
 * };
 */

class Solution {
    vector<pair<int, int>> nextDir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    unordered_set<string>visited;
public:
    void cleanRoom(Robot& robot) {
        dfs(robot, 0, 0, 0); // backtracking
    }
    void dfs(Robot& robot, int x, int y, int dir) {
        string tmp = to_string(x)+ "#" + to_string(y);
        if ( visited.find(tmp) != visited.end() ) return;
        
        robot.clean();
        visited.insert(tmp);
        for (int k = 0; k < 4; k++) {
            int next = (dir+k)%4;
            int cx = x + nextDir[next].first;
            int cy = y + nextDir[next].second;
            if (robot.move()) {
                dfs(robot, cx, cy, next);
                robot.turnRight();
                robot.turnRight();
                robot.move();
                robot.turnRight();
                robot.turnRight();
            }
            robot.turnRight();
        }
    }
};
