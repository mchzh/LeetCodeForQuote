class Solution {
    //https://leetcode.com/problems/score-after-flipping-matrix/discuss/143722/C%2B%2BJavaPython-Easy-and-Concise
    // greedy
    public int matrixScore(int[][] A) {
        int m = A.length, n = A[0].length;
        
        // step 1 to check the first element every row
        for (int i = 0; i < m; i++) {
            if (A[i][0] == 1) continue;
            flipRow(A, i);
        }
        
        // step 2: get the num of 1s and 0s every column
        for (int j = 1; j < n; j++) {
            int sumone = 0;
            for (int i = 0; i < m; i++) {
                sumone += A[i][j]; 
            }
            if (sumone * 2 >= m) continue;
            flipCol(A, j);
        }
        
        // get the final score
        int rets = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                rets += A[i][j] * (1<<(n-j-1));
            }
        }
        return rets;
    }
    private void flipRow(int[][] A, int row) {
        for (int j = 0; j < A[0].length; j++) {
            A[row][j] = (A[row][j]^1);
        }
    }
    private void flipCol(int[][] A, int col) {
        for (int i = 0; i < A.length; i++) {
            A[i][col] = (A[i][col]^1);
        }
    }
}

// A[i][0] is 1<<n-1, if it is 0 toggle to 1;
// A[i][j] is 1<<(n-1-j), every col to calculate the num of 1s, if 0 more toggle, 1 more not toggle;
