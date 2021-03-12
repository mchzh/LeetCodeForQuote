class Solution {
    // two pass and stack(monolithic decreasing stack)
    // two pointer
    public int trap(int[] height) {
        if (height == null || height.length == 0) return 0;
        int n = height.length;
        Stack<Integer> stack = new Stack<>();
        int rets = 0;
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && height[stack.peek()] < height[i]) {
                int idx = stack.pop();
                if (!stack.isEmpty()) {
                    int secidx = stack.peek();
                    rets += (i-secidx-1)*(Math.min(height[i],height[secidx])-height[idx]);
                }
            }
            stack.push(i);
        }
        return rets;
    }
};
