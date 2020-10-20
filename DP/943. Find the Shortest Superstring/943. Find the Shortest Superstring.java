class Solution {
    public String shortestSuperstring(String[] A) {
        // substring no subsequence
        int N = A.length;
        int M = (1<<N); // status compress
        int[][] dp = new int[M][N]; // N is the number of cities
        int[][] parent = new int[M][N];
        // distance for every two points
        int[][] dis = new int[N][N];
        for (int i = 0; i < M; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE/2);
            Arrays.fill(parent[i], -1);
        }
        
        // get distance
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (i != j) {
                    dis[i][j] = getDistance(A, i, j);
                }
            }
        }
        
        // initialized value for single point
        for (int i = 0; i < N;i++) {
            dp[1<<i][i] = A[i].length();
        }
        
        // main frame work
        for (int iset = 0; iset < M; iset++) { // set status
            for (int last = 0; last < N ; last++) {
                if ( (iset & (1<<last)) == 0) continue;
                int set_prev = iset - (1<<last);
                if (set_prev == 0) continue;
                for (int last_prev = 0; last_prev < N; last_prev++) {
                    if ( (set_prev & (1<<last_prev)) == 0) continue;
                    int curDis = dp[set_prev][last_prev] + dis[last_prev][last];
                    if (curDis < dp[iset][last]) {
                        dp[iset][last] = curDis;
                        parent[iset][last] = last_prev;
                    }  
                }
            }
        }
        
        int ret = Integer.MAX_VALUE;
        int last = -1;
        for (int i = 0; i < N; i++) {
            //ret = Math.min(ret, dp[M-1][i]);
            if (dp[M-1][i] < ret) {
                ret = dp[M-1][i];
                last = i;
            }
        }
        //dp[1111][last]
        // back track to recover this path
        int set = M-1;
        List<Integer> path = new ArrayList<>();
        path.add(0, last);
        while (parent[set][last] != -1) {
            int prev = parent[set][last];
            path.add(0, prev);
            set = set - (1<<last);
            last = prev;
        }
        
        // according to the path to get the combined string
        String str = A[path.get(0)];
        for (int i = 1; i < path.size(); i++) {
            str = combine(str, A[path.get(i)]);
        }
        return str;
    }
    private int getDistance(String[] A, int x, int y) {
        String s = A[x], t = A[y];
        for (int k = Math.min(s.length(), t.length()); k >= 0; k--) {
            if ( s.substring(s.length()-k).equals(t.substring(0, k)) ) return t.length()-k;
        }
        return 0;
    }
    private String combine(String s, String t) {
        int k = Math.min(s.length(), t.length());
        for (; k >= 0; k--) {
            if ( s.substring(s.length()-k).equals(t.substring(0, k)) ) break;
        }
        return s + t.substring(k); // suffix of t
    }
}

// A, B, C
// abc bcd cde

// A->B = 1;
// B->C = 1;
// A->C = 2;
// B->A = 3;
// C->A = 3;
// C->B = 3
    
// ABC => abcde
// ACB
// BAC
// BCA
// CAB
// CBA

// dp[set][last]: the shortest path if we have traveled the cities in the set and the last stop is "last"
// A B C D
// set tranverse sequence is very important
// for set = 0001 : 1111
//     for last =...
//         set_prev = set-last
//         for last_prev = ...
//             dp[set][last] = min(dp[set_prev][last_prev] + dis(last_prev, last))
//             parent[set][last] = last_prev
    
// last is B:
// dp[0111][B] = min(dp[0011][C]+dis(C, B), dp[0011][D]+dis(D, B))   
//     C   D
//      \  /
//        B
