class Solution {
    // https://leetcode.com/problems/walking-robot-simulation/discuss/155682/Logical-Thinking-with-Clear-Code
    public int robotSim(int[] commands, int[][] obstacles) {
        int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int dir = 0; // 0 up
        
        Set<String> set = new HashSet<>();
        for (int[] obs : obstacles) {
            set.add(obs[0] + " " + obs[1]);
        }
        
        int ret = 0;
        int x = 0, y = 0;
        for (int com : commands) {
            if (com == -1) {
                dir = (dir+1) % 4;
            } else if (com == -2) {
                dir = (dir+3) % 4;
            } else {
                int step = 0;
                while (step < com && !set.contains( (x+dirs[dir][0]) + " " + (y+dirs[dir][1]) )) {
                    x += dirs[dir][0];
                    y += dirs[dir][1];
                    step++;
                }
                ret = Math.max(ret, x*x + y*y);
            }
        }
        return ret;
    }
}

//Euclidean distance: x*x + y*y

/*class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        Set<Position> obstaclePositions = new HashSet<Position>();
        
        for (int i = 0; i < obstacles.length; i++) {
            obstaclePositions.add(new Position(obstacles[i][0], obstacles[i][1]));
        }
        
        int[] distWalked = new int[4];
        int dir = 0;
        int maxDist = 0;
        
        for (int i = 0; i < commands.length; i++) {
            if (commands[i] == -2) {
                dir = (dir + 3) % 4;
            } else if (commands[i] == -1) {
                dir = (dir + 1) % 4;
            } else {
                for (int j = 0; j < commands[i]; j++) {
                    distWalked[dir]++;
                
                    int currX = distWalked[1] - distWalked[3];
                    int currY = distWalked[0] - distWalked[2];

                    if (obstaclePositions.contains(new Position(currX, currY))) {
                        distWalked[dir]--;
                        break;
                    }
                    
                    maxDist = Math.max(maxDist, currX * currX + currY * currY);
                }
                
                
            }
        }
        
        return maxDist;
    }
    
    class Position {
        int x;
        int y;
        
        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
        
        public boolean equals(Object other) {
            if (!(other instanceof Position)) {
                return false;
            } else {
                Position otherPos = (Position) other;
                return this.x == otherPos.x && this.y == otherPos.y;
            }
        }
        
        public int hashCode() {
            return Integer.hashCode(x) * 60000 + Integer.hashCode(y);
        }
    }
}*/
