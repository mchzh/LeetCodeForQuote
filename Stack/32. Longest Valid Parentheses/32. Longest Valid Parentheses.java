class Solution {
    public int longestValidParentheses(String s) {
        // stack to save index;
        int ret = 0;
        if (s == null || s.length() == 0) return ret;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (stack.peek() != -1  && s.charAt(i) == ')' && s.charAt(stack.peek()) == '(') {
                stack.pop();
                int lastIdx = stack.peek();
                ret = Math.max(ret, i-lastIdx);
                continue;
            }
            stack.push(i);
        }
        return ret;
    }
}

// () then update ret
// only ) push it to stack
