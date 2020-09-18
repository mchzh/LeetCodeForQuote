class Solution {
    // https://leetcode.com/problems/robot-bounded-in-circle/discuss/290859/java-solution-%2B-clear-explanation
    // https://leetcode.com/problems/robot-bounded-in-circle/discuss/850536/Clear-Explanation-with-images-For-Beginners-like-me
    public boolean isRobotBounded(String instructions) {
        int[] cur = {0, 0};
        int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int dir = 0;// 0 north up, 1 right, 2 down, 3 left;
        
        for ( char ch : instructions.toCharArray() ) {
            if (ch == 'G') {
                cur[0] += dirs[dir][0];
                cur[1] += dirs[dir][1];
            } else if (ch == 'L') {
                dir = (dir+3) %4;
            } else {
                dir = (dir+1) %4;
            }
        }
        
        if (cur[0] == 0 && cur[1] == 0) return true; // locate in the original point
        else if (dir == 0) return false; // north direction but has offset
        return true;
    }
}
