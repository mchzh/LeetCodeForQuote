class Solution {
    // minmax(dfs) + memo
    Map<Integer, Boolean> map;
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        int n = maxChoosableInteger;
        if (n*(n+1)/2 < desiredTotal) return false; // total sum
        map = new HashMap<>();
        return dfs(0, 0, maxChoosableInteger, desiredTotal);
    }
    private boolean dfs(int state, int sum, int maxChoosableInteger, int desiredTotal) {
        if (map.containsKey(state)) return map.get(state);
        for (int i = 1; i <= maxChoosableInteger; i++) {
            if ( ((state>>i)&1) == 1) continue;
            if (sum+i >= desiredTotal) {
                map.put(state, true);
                return true;
            }
            
            if (!dfs(state+(1<<i), sum+i, maxChoosableInteger, desiredTotal)) {
                map.put(state, true);
                return true;
            }    
        }
        map.put(state, false);
        return false;
    }
}

// A: 1 => B : win
//    2 => B : win
//    .....
//    4 => B : lose
//         B : 1 => A : win
//             2 => A : lose
