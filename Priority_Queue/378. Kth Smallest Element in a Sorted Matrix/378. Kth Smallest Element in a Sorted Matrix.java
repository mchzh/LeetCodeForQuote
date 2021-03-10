class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int left = matrix[0][0];
        int right = matrix[n-1][n-1];
        while (left < right) {
            int mid = left + (right-left) /2;
            
            if (smallerEquals(mid, matrix) < k) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
    private int smallerEquals(int val, int[][] matrix) {
        int n = matrix.length;
        int i = n-1, j = 0;
        int count = 0;
        while (i >= 0 && j < n) {
            if (matrix[i][j] > val) {
                i--;
            } else {
                count += (i+1);
                j++;
            }
        }
        return count;
    }
}
