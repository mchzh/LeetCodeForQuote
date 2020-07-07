class Solution {
    // for every row to select the most minimu number and the second minimum number
    public int minFallingPathSum(int[][] arr) {
        // brute force dp
        // how to improve the inner loop to O(1)
        int len = arr.length;
        
        // get the first and second minimum element of initilized row
        int idxFirst = findMin(arr[0], -1);
        int idxSecond = findMin(arr[0], idxFirst);
        // for next follow row
        for (int i = 1; i < len; i++) {
            for (int j = 0; j < len; j++) {
                arr[i][j] += j == idxFirst ? arr[i-1][idxSecond] : arr[i-1][idxFirst];
            }
            idxFirst = findMin(arr[i], -1);
            idxSecond = findMin(arr[i], idxFirst);
        }
        
        // get the res on the last row;
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < len; i++) {
            res = Math.min(res, arr[len-1][i]);
        }
        return res;
    }
    
    public int minFallingPathSumBruteForce(int[][] arr) {
        // brute force dp
        // how to improve the inner loop to O(1)
        int len = arr.length;
        int[][] dp = new int[len][len];
        // initilize
        for (int i = 0; i < len; i++) {
            dp[0][i] = arr[0][i];
        }
        // for next follow row
        for (int i = 1; i < len; i++) {
            for (int j = 0; j < len; j++) {
                boolean isFirst = false;
                for (int k = 0; k < len; k++) {
                    if (k != j) {
                        dp[i][j] = isFirst ?  Math.min(dp[i][j], dp[i-1][k] + arr[i][j]) : dp[i-1][k] + arr[i][j];
                        isFirst = true;
                    }
                }
            }
        }
        // get the res on the last row;
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < len; i++) {
            res = Math.min(res, dp[len-1][i]);
        }
        return res;
    }
    
    private int findMin(int[] curRow, int startIdx) {
        int res = -1;
        for (int i = 0; i < curRow.length; i++) {
            if (startIdx == i) continue;
            if (res == -1) {
                res = i;
            } else if (curRow[res] > curRow[i]) {
                res = i;
            }
        }
        return res;
    }
}
