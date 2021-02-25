class Solution {
    // dp mask
    int m, n;
    public int maxStudents(char[][] seats) {
        // 0 -> empty; 1 -> man
        m = seats.length;
        n = seats[0].length;
        int[][] dp = new int[m][1<<n];
        for (int state = 0; state < 1<<n; state++) {
            if (!isValid(state, seats, 0)) continue;
            dp[0][state] = getnum(state);
        }
        
        for (int i = 1; i < m; i++) {
            for (int prestate = 0; prestate < 1<<n; prestate++) {
                if (!isValid(prestate, seats, i-1)) continue;
                for (int state = 0; state < 1<<n; state++) {
                    if (!isValid(state, seats, i)) continue;
                    if (crossOk(prestate, state)) {
                        dp[i][state] = Math.max(dp[i][state], dp[i-1][prestate]+getnum(state));
                    }
                }
            }
        }
        
        int rets = 0;
        for (int state = 0; state < 1<<n; state++) {
            rets = Math.max(rets, dp[m-1][state]);
        }
        return rets;
    }
    private int getnum(int state) {
        int count = 0;
        
        for (int i = 0; i < n; i++) {
            count += state%2;
            state /= 2;
        }
        
        return count;
    }
    private boolean isValid(int  prestate, char[][] seats, int row) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(prestate%2);
            prestate /= 2;
        }
        for (int i = 0; i < n; i++) {
            if (list.get(i) == 1 && seats[row][i] == '#') return false;
            if (list.get(i) == 1 && i > 0 && list.get(i-1) == 1) return false;
        }
        return true;
    }
    private boolean crossOk(int prestate, int state) {
        List<Integer> prebit = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            prebit.add(prestate%2);
            prestate /= 2;
        }
        List<Integer> curbit = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            curbit.add(state%2);
            state /= 2;
        }
        
        for (int i = 0; i < n; i++) {
            if (curbit.get(i) == 0) continue;
            if (i > 0 && prebit.get(i-1) == 1) return false;
            if (i < n-1 && prebit.get(i+1) == 1) return false;
        }
        return true;
    }
}
// dp[i][status]: he maximum number of students that can take the exam together without any cheating being possible on the ith row
// and with the current status;

// dp[i][status] = max(dp[i-1][status`]) (status` is not conflict status and status and status` both valid on their own row)
// N
// for (i from 1 to N) {
//     for (pre state from 0 to 1<<N) {
//         if (notvalid(pre state on i-1)) continue;
//         for (cur state from 0 to 1<<N) {
//             if (notvalid(cur state on i)) continue;
//             if (notcross(prestate, state)) continue;
//             dp[i][state] = max(dp[i-1][prestate]);
//         }
//     }
// }

// int rets = 0;
// for (state from 0 to 1<<N) {
//     rets = max(rets, dp[N][state]);
// }
// return rets;
