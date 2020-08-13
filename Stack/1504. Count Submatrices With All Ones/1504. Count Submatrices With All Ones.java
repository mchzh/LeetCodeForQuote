class Solution {
    // https://leetcode.com/problems/count-submatrices-with-all-ones/discuss/720265/Java-Detailed-Explanation-From-O(MNM)-to-O(MN)-by-using-Stack
    // https://leetcode.com/problems/count-submatrices-with-all-ones/discuss/720280/Java-histogram-count
    // https://leetcode.com/problems/count-submatrices-with-all-ones/discuss/720097/Java-DP-solution-O(m*mn)
    public int numSubmat(int[][] mat) {
        // dp
        // histogram is O(M*N*N)
        // use increasing stack reduce to O(M*N)
        int M = mat.length, N = mat[0].length;
        int[] height = new int[N];
        
        int ret = 0;
        for (int i = 0; i < M; i++) {
            Stack<int[]> stack = new Stack<>();
            for (int j = 0; j < N; j++) {
                height[j] = mat[i][j] == 0 ? 0 : height[j] + 1;
                while (!stack.isEmpty() && height[stack.peek()[0]] >= height[j]) stack.pop();
                int sum = 0;
                if (!stack.isEmpty()) {
                    int[] cur = stack.peek();
                    sum += height[j] * (j-cur[0]) + cur[1];
                } else {
                    sum += height[j] * (j+1);
                }
                stack.push(new int[] {j, sum});
                ret += sum;
            }
        }
        return ret;
    }
    public int numSubmatWithHeight(int[][] mat) {
        // dp
        // histogram is O(M*N*N)
        // use increasing stack reduce to O(M*N)
        int M = mat.length, N = mat[0].length;
        int[] height = new int[N];
        // histogram
        int ret = 0;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                height[j] = mat[i][j] == 0 ? 0 : height[j] + 1;
                //int min = Integer
                for (int k = j, min = height[j]; k >= 0 && min > 0; k--) {
                    min = Math.min(min, height[k]);
                    ret += min;
                }
            }
        }
        return ret;
    }
}

// one dimension
 // X X X X X : 1+2+3+...+n
 // Y Y Y Y Y
