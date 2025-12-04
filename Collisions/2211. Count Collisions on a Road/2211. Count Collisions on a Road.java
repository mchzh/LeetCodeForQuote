class Solution {
    public int countCollisions(String directions) {
        // two pass : from left to right : from right to left
        int rets = 0;
        int n = directions.length();
        int flag = 0;
        for (int i = 0; i < n; i++) {
            char c = directions.charAt(i);
            if (flag ==0 && (c == 'R' || c == 'S')) {
                flag = 1;
            }
            if (flag == 1 && c == 'L') {
                rets++;
            }
        }

        flag = 0;
        for (int i = n-1; i >= 0; i--) {
            char c = directions.charAt(i);
            if (flag ==0 && (c == 'L' || c == 'S')) {
                flag = 1;
            }
            if (flag == 1 && c == 'R') {
                rets++;
            }
        }
        return rets;
    }
}
