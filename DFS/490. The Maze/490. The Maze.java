class Solution {
    // bfs
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        int row = maze.length, col = maze[0].length;
        boolean[][] visited = new boolean[row][col];
        return dfs(maze, start[0], start[1], destination[0], destination[1], visited);
    }
    private boolean dfs(int[][] maze, int srcX, int srcY, int tarX, int tarY, boolean[][] visited) {
        //if (src) return false;
        if (srcX == tarX && srcY == tarY) {
            return true;
        }
        if (visited[srcX][srcY]) return false;
        
        visited[srcX][srcY] = true;
        // four direction
        // left
        int cx = srcX;
        int cy = srcY;
        while (cy >= 0 && maze[cx][cy] == 0) {
            cy--;
        }
        if (dfs(maze, cx, cy+1, tarX, tarY, visited)) return true;
        // right
        cx = srcX;
        cy = srcY;
        while (cy < maze[0].length && maze[cx][cy] == 0) {
            cy++;
        }
        if (dfs(maze, cx, cy-1, tarX, tarY, visited)) return true;
        // up
        cx = srcX;
        cy = srcY;
        while (cx >= 0 && maze[cx][cy] == 0) {
            cx--;
        }
        if (dfs(maze, cx+1, cy, tarX, tarY, visited)) return true;
        // down
        cx = srcX;
        cy = srcY;
        while (cx < maze.length && maze[cx][cy] == 0) {
            cx++;
        }
        if (dfs(maze, cx-1, cy, tarX, tarY, visited)) return true;
        return false;
    }
}
