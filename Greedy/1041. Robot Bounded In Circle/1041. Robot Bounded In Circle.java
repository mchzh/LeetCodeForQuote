class Solution {
    public boolean isRobotBounded(String instructions) {
        // direction : i%4;
        int x = 0, y = 0, direction = 0;
        for (char c : instructions.toCharArray()) {
            if (c == 'G') {
                if (direction == 0) {
                    y += 1;
                } else if (direction == 1) {
                    x += 1;
                } else if (direction == 2) {
                    y -= 1;
                } else {
                    x -= 1;
                }
            } else if (c == 'L') {
                direction = (direction-1+4)%4;
            } else if (c == 'R') {
                direction = (direction+1+4)%4;
            }
        }
        
        if (x == 0 && y==0) return true;
        else {
            if (direction != 0) return true;
            else return false;
        }
    }
}
