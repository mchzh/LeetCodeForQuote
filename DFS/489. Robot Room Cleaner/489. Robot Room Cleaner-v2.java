class Solution {
    Set<String> visited;
    public void cleanRoom(Robot robot) {
        visited = new HashSet<>();
        String cur = String.valueOf(0) + "#" + String.valueOf(0);
        visited.add(cur);
        dfs(robot, 0, 0, 0);
    }
    private void dfs(Robot robot, int x, int y, int dir) {
        robot.clean();
        
        int[][] dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}}; // n->e->s->w: clockwise
        for (int k = 1; k <= 4; k++) {
            robot.turnRight();
            // get the new point on this direction
            int nextDir = (dir+k)%4;
            int cx = x + dirs[nextDir][0];
            int cy = y + dirs[nextDir][1];
            
            String cur = String.valueOf(cx) + "#" + String.valueOf(cy);
            if (!visited.contains(cur) && robot.move()) {
                visited.add(cur);
                dfs(robot, cx, cy, nextDir);
                // when jump out recursion now keep nextdir and point(cx, cy)
                robot.turnRight();
                robot.turnRight();
                robot.move();
                robot.turnRight();
                robot.turnRight();
            }
        }
    }
}
// {x, y, dirs}
// {x, y, north} -> turn right -> {cx, cy, east}
