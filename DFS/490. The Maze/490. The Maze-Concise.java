class Solution {
    // https://leetcode.com/problems/the-maze/solution/
    private int[][] dir = new int[][]{{-1,0},{1,0},{0,-1},{0,1}};
    
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        boolean[][] visited = new boolean[maze.length][maze[0].length];
        return dfs(maze, visited, start, destination);
    }
    
    private boolean dfs(int[][] maze, boolean[][] visited, int[] c, int[] des) {
        if (visited[c[0]][c[1]]) return false;
        if (c[0] == des[0] && c[1] == des[1]) return true;
        
        visited[c[0]][c[1]] = true;
        boolean result = false;
        for (int[] d : dir) {
            int x = c[0] + d[0];
            int y = c[1] + d[1];
            while ( 0 <= x && x < maze.length && 0 <= y && y < maze[0].length && maze[x][y] == 0) {
                x += d[0];
                y += d[1];
            }
            result = result || dfs(maze, visited, new int[]{ x - d[0], y - d[1]}, des);
        }
        return result;
    }
    // DFS TLE then consider BFS
    /*int[][] directions = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        int row = maze.length, col = maze[0].length;
        boolean[][][] visited = new boolean[4][row][col];
        for (int i = 0; i < 4; i ++) {
            if (dfs(maze, start[0], start[1], visited, destination, i)) return true;
        }
        return false;
    }
    // left : x-1, right: x+1; up: y-1; down: y+1
    public boolean dfs(int[][] maze, int x, int y, boolean[][][] visited, int[] tar, int dire) {
        // is wall in that direction
        visited[dire][x][y] = true;
        int dirx = x+directions[dire][0];
        int diry = y+directions[dire][1];
        if (dirx < 0 || dirx >= maze.length || diry < 0 || diry >= maze[0].length
           || maze[dirx][diry] == 1 ) {
            if (x == tar[0] && y == tar[1]) {
                return true;
            } else {
                // change direction
                for (int i = 0; i < 4; i ++) {
                    int cx = x+directions[i][0];
                    int cy = y+directions[i][1];
                    if (i != dire && cx >= 0 && cx < maze.length && 
                        cy >= 0 && cy < maze[0].length 
                        && !visited[i][cx][cy] && maze[cx][cy] != 1) {
                        if (dfs(maze, cx, cy, visited, tar, i)) return true;
                    }
                }
            }
        } else {
            // not wall, go ahead
            if (dfs(maze, dirx, diry, visited, tar, dire)) return true;
        }
        visited[dire][x][y] = false;
        
        return false;
    }*/
}

/*class Solution {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        int[] xDir = {0, 0, 1, -1};
        int[] yDir = {1, -1, 0, 0};
        
        Queue<int[]> q = new LinkedList<int[]>();
        q.add(start);
        maze[start[0]][start[1]] = -1;
        
        while(!q.isEmpty()){
            int[] point = q.poll();
            for(int i=0; i<xDir.length; i++){
                int x = point[0];
                int y = point[1];
                while(x>=0 && y>=0 && x<maze.length && y<maze[0].length && maze[x][y] != 1){
                    x += xDir[i];
                    y += yDir[i];
                }  
                
                x -= xDir[i];
                y -= yDir[i];
                if(x == destination[0] && y == destination[1]) return true;
                
                if(maze[x][y] == 0){
                    maze[x][y] = -1;
                    q.add(new int[]{x,y});
                }
            }
        }
        
        return false;
    }
}*/


/*class Solution {
    private int[][] dir = new int[][]{{-1,0},{1,0},{0,-1},{0,1}};
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        boolean[][] visited = new boolean[maze.length][maze[0].length];
        return dfs(maze, visited, start, destination);
    }
    private boolean dfs(int[][] maze, boolean[][] visited, int[] c, int[] des) {
        if (visited[c[0]][c[1]]) return false;//为了避免无限循环，如果我们见了相同的点就返回false。否则我们会陷入相同点的无限check中。
        if (c[0] == des[0] && c[1] == des[1]) return true;
        
        visited[c[0]][c[1]] = true;//并不是路径上的每一个点都记visited，只有拐点需要记visited。
        for (int[] d : dir) {
            int x = c[0] + d[0];
            int y = c[1] + d[1];
            while (0 <= x && x < maze.length && 0 <= y && y < maze[0].length && maze[x][y] == 0) {
                x += d[0];
                y += d[1];
            }
            if (dfs(maze, visited, new int[]{ x - d[0], y - d[1]}, des)) return true; //new start
        }
        return false;
    }
}*/
