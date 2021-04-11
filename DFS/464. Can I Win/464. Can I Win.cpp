class Solution {
    int visited[1<<21];
public:
    bool canIWin(int maxChoosableInteger, int desiredTotal) {
        int total = maxChoosableInteger*(maxChoosableInteger+1)/2;
        if (total < desiredTotal) return false; // total sum
        
        return dfs(0, 0, maxChoosableInteger, desiredTotal);
    }
    bool dfs(int state, int sum, int maxChoosableInteger, int desiredTotal) {
        if (visited[state] == 2) return true;
        if (visited[state] == 1) return false;
        for (int i = 1; i <= maxChoosableInteger; i++) {
            if ( ((state>>i)&1) == 1) continue;
            if (sum+i >= desiredTotal) {
                visited[state] = 2;
                return true;
            }
            
            if (!dfs(state+(1<<i), sum+i, maxChoosableInteger, desiredTotal)) {
                visited[state] = 2;
                return true;
            }    
        }
        visited[state] = 1;
        return false;
    }
};
