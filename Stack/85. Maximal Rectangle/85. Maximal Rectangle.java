class Solution {
    public int maximalRectangle(char[][] matrix) {
        // ensure up and down then covert 2D as 1D with height
        int area = 0;
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return area;
        int M = matrix.length, N = matrix[0].length;
        int[] heights = new int[N];
        
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                heights[j] = matrix[i][j] == '0' ? 0 : heights[j]+1;
            }
            area = Math.max(area, getLargestRectangle(heights));
        }
        return area;
    }
    private int getLargestRectangle(int[] heights) {
        // increasing stack same as 84
        int N = heights.length;
        int[] H = new int[N+2];
        for (int i = 0; i < N; i++) {
            H[i+1] = heights[i];
        }
        Stack<Integer> stack = new Stack<>();
        
        int ret = 0;
        for (int i = 0; i < N+2; i++) {
            if (stack.isEmpty() || H[i] >= H[stack.peek()]) {
                stack.push(i);
                continue;
            }
            if ( H[i] < H[stack.peek()] ) {
                while ( !stack.isEmpty() && H[i] < H[stack.peek()] ) {
                    int recH = H[stack.peek()];
                    stack.pop();
                    int recW = (i-stack.peek()-1);
                    ret = Math.max(ret, recH * recW);
                }
                stack.push(i);
            }
        }
        return ret;
    }
}
