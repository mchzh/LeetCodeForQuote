class Solution {
    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) return 0;
        // monotonic increasing stack
        int n = heights.length;
        int[] heightsNew = new int[n+2];
        for (int i = 0; i < n; i++) {
            heightsNew[i+1] = heights[i];
        }
        heightsNew[0] = 0;
        heightsNew[n+1] = 0;
        Stack<Integer> stack = new Stack<>();
        int rets = 0;
        for (int i = 0; i < n+2; i++) {
            while ( !stack.isEmpty() && heightsNew[stack.peek()] > heightsNew[i]) {
                int h = heightsNew[stack.pop()];
                rets = Math.max(rets, h*(i-stack.peek()-1));
            }
            stack.push(i);
        }
        return rets;
    }
}
