class Solution {
    public int smallestCommonElement(int[][] mat) {
        // binary search
        int m = mat.length, n = mat[0].length;
        for (int j = 0; j < n; j++) {
            int count = 1;
            for (int i = 1; i < m; i++) {
                int idx = findT(mat, i, mat[0][j]);
                if (idx == -1) break;
                count++;
            }
            if (count == m) return mat[0][j];
        }
        return -1;
    }
    private int findT(int[][] mat, int row, int target) {
        int left = 0, right = mat[row].length-1;
        while (left < right) {
            int mid = left + (right-left)/2;
            if (mat[row][mid] < target) {
                left = mid+1;
            } else {
                right = mid;
            }
        }
        return (left < mat[row].length && mat[row][left] == target) ? left : -1;
    }
}
