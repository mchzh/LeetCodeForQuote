class Solution {
    public int minDeletionSize(String[] A) {
        int m = A.length, n = A[0].length();
        int[] status = new int[m];
        int rets = 0;
        for (int j = 0; j < n; j++) {
            boolean isFull = true;
            int[] copys = Arrays.copyOf(status, m);
            for (int i = 1; i < m; i++) {
                
                char prev = A[i-1].charAt(j);
                char cur = A[i].charAt(j);
                if (copys[i] == 0) {
                    if (prev < cur) {
                        copys[i] = 1;
                    } else if (prev == cur) {
                        copys[i] = 0;
                    } else {
                        isFull = false;
                        break;
                    }
                }
            }
            if (isFull) {
                status = Arrays.copyOf(copys, m);
            } else {
                rets += 1;
            }
        }
        return rets;
    }
}

// p[i] store the previous column non-decreasing order: i-1 -> 1

//          j
// 0 a......fXXX
// 0 a......jXXX
// 0 b......kXXX
// 0 b......lXXX

// p[i] == 1 : means A[i-1] < A{i] -> no matter whatever A[i-1][j] and A[i][j]
// p[i] == 0 : means A[i-1] == A[i] -> previous is equals compare A[i-1][j] and A[i][j], 
//                                                 if A[i-1][j] < A[i][j] p[i] = 1;
//                                                              else A[i-1][j] == A[i][j] p[i] = 0;
//                                                              else rets +1 , continue;
