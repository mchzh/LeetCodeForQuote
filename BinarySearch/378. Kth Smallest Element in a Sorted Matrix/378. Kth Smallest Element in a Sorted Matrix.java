class Solution {
    // min heap and binary search
    // or quick select?
    // https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/discuss/85177/Java-1ms-nlog(max-min)-solution
    // https://www.cnblogs.com/grandyang/p/5727892.html
    public int kthSmallest(int[][] matrix, int k) {
        int N = matrix.length;
        int left = matrix[0][0], right = matrix[N-1][N-1];
        
        while (left < right) {
            int mid = left + (right - left) /2;
            int count = getCount(matrix, mid); // less than and equal
            if (count < k) {
                left = mid+1;
            } else {
                right = mid;
            }
        }
        return left;
    }
    private int getCount(int[][] matrix, int val) {
        int ret = 0;
        int n = matrix.length, i = n-1, j = 0;
        while (i >= 0 && j < n) {
            if (matrix[i][j] > val) {
                i--;
            } else {
                ret += i+1;
                j++;
            }
        }
        return ret;
    }
}
// pq
