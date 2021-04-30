class Solution {
    int[][][][] dp;
    // dp + bitmaskd
    int[] p;
    int[] q;
    public int getMaxGridHappiness(int m, int n, int introvertsCount, int extrovertsCount) {
        int max_state = (int)Math.pow(3, n);
        int rets = 0;
        dp = new int[6][7][7][244];
        p = new int[n];
        q = new int[n];
        for (int i = 0; i <= m; i++) {
            for (int x = 0; x <= introvertsCount; x++) {
                for (int y = 0; y <= extrovertsCount; y++) {
                    for (int state = 0; state < max_state; state++) {
                        dp[i][x][y][state] = Integer.MIN_VALUE/2;
                    }
                }
            }
        }
        dp[0][0][0][0] = 0;
        
        for (int i = 1; i <= m; i++) {
            for (int x = 0; x <= introvertsCount; x++) {
                for (int y = 0; y <= extrovertsCount; y++) {
                    for (int state = 0; state < max_state; state++) {
                        int[] cur = countType(state, n);
                        int a = cur[0], b = cur[1];
                        if (a > x || b > y) continue;
                        for (int prestate = 0; prestate < max_state; prestate++) {
                            if (dp[i-1][x-a][y-b][prestate] == Integer.MIN_VALUE/2) continue;
                            dp[i][x][y][state] = Math.max(dp[i][x][y][state], dp[i-1][x-a][y-b][prestate]+addVal(prestate, state, n));
                        }
                        if (i == m) rets = Math.max(rets, dp[i][x][y][state]);
                    }
                }
            }
        }
        
        return rets;
    }
    
    private int[] countType(int state, int n) {
        int[] count = new int[2];
        for (int i = 0; i < n; i++) {
            if (state%3 ==1) count[0]++;
            else if (state%3 ==2) count[1]++;
            
            state /= 3;
        }
        return count;
    }
    private int addVal(int pre, int cur, int n) {
        int sum = 0;
        for (int i = 0; i < n; i++) {
            p[i] = pre%3;
            q[i] = cur%3;
            pre /= 3;
            cur /= 3;
        }
        for (int i = 0; i < n; i++) {
            if (q[i] == 1) {
                sum += 120;
                // left
                if (i >0 && q[i-1] != 0) sum -= 30;
                if (i < n-1 && q[i+1] != 0) sum -= 30;
                if (p[i] != 0) {
                    sum -= 30;
                    if (p[i] == 1) sum -= 30;
                    else sum += 20;
                }
            } else if (q[i] == 2) {
                sum += 40;
                if (i >0 && q[i-1] != 0) sum += 20;
                if (i < n-1 && q[i+1] != 0) sum += 20;
                if (p[i] != 0) {
                    sum += 20;
                    if (p[i] == 1) sum -= 30;
                    else sum += 20;
                }
            }
        }
        return sum;
    }
}

// current row val depend the prev row
// dp[i][state] : the max happiness of the ith row with state
// dp[i][state] = max(dp[i-1][prestate]+addval());

// consider extro and intro type people, and add two more demension dp

// dp[i][x][y][state] : the max val of the ith row with state and with x e type people and y i type people
// dp[i][x][y][state] = max(dp[i-1][x-a][y-b][prestate]+addval(prestate, state));

// for (int i = 1; i <= m; i++) {
//     for (int x = 0; x < introverts; x++) {
//         for (int y = 0; y < extroverts; y++) {
//             for (int state = 0; state < (3^n); state++) {
//                 for (int prestate = 0; prestate < (3^n); prestate++) {
//                     # a introvert of this row;
//                     # b extrovert of this row;
//                     dp[i][x][y][state] = max(dp[i-1][x-a][y-b][prestate]+addval(prestate, state));
//                 }
//             }
//         }
//     }
// }
// 5*6*6*3^10
