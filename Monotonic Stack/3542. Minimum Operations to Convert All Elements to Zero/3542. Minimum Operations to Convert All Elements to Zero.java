class Solution {
    public int minOperations(int[] nums) {
        // monotonic increading stack
        // stack top:
        // top > curr : pop it and ans +1;
        // top == curr : do nothing
        // top < curr: push curr into stack
        int n = nums.length;
        int[] mock = new int[n+1]; // remove node at the right most
        for (int i = 0; i < n; i++) {
            mock[i] = nums[i];
        }
        int rets = 0;
        Stack<Integer> stack = new Stack<>();

        for (int a : mock) {
            //System.out.println(a + " " + stack.size());
            // top > curr
            while (!stack.isEmpty() && stack.peek() > a) {
                stack.pop();
                rets++;
            }

            if (stack.isEmpty() || stack.peek() < a) {
                stack.push(a);
            }
        }
        return rets;
    }
}
