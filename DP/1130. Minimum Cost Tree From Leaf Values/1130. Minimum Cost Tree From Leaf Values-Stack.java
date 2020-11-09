class Solution {
    // dp and tricky
    public int mctFromLeafValues(int[] arr) {
        int n = arr.length;
        int[] nextGreater = new int[n];
        int[] prevGreater = new int[n];
        Arrays.fill(nextGreater, Integer.MAX_VALUE);
        Arrays.fill(prevGreater, Integer.MAX_VALUE);
        
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            // monotaonical decreasing stack
            while (!stack.isEmpty() && arr[i] >= arr[stack.peek()]) {
                nextGreater[stack.peek()] = arr[i];
                stack.pop();
            }
            stack.push(i);
        }
        // clear stack
        while (!stack.isEmpty()) stack.pop();
        
        for (int i = 0; i < n; i++) { // prev greater
            // monotaonical decreasing stack
            if (!stack.isEmpty() && arr[i] < arr[stack.peek()]) {
                prevGreater[i] = arr[stack.peek()];
                stack.push(i);
            } else {
                while (!stack.isEmpty() && arr[i] >= arr[stack.peek()]) stack.pop();
                if (!stack.isEmpty()) prevGreater[i] = arr[stack.peek()];
                stack.push(i);
            }
        }
        // calculate
        int rets = 0;
        for (int i = 0; i < n; i++) {
            int cur = Math.min(prevGreater[i], nextGreater[i]);
            if (cur != Integer.MAX_VALUE) rets += cur*arr[i];
        }
        return rets;
    }
}
