class Solution {
    // https://leetcode.com/problems/valid-parenthesis-string/discuss/107572/Java-using-2-stacks.-O(n)-space-and-time-complexity.
    public boolean checkValidString(String s) {
        Stack<Integer> leftStack = new Stack<>();
        Stack<Integer> starStack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                leftStack.push(i);
            } else if (c == ')') {
                if ( leftStack.isEmpty() && starStack.isEmpty() ) return false;
                if ( !leftStack.isEmpty() ) {
                    leftStack.pop();
                } else {
                    starStack.pop();
                }
            } else {
                starStack.push(i);
            }
        }
        
        while ( !leftStack.isEmpty() && !starStack.isEmpty() ) {
            if (leftStack.pop() > starStack.pop()) return false;
        }
        return leftStack.isEmpty();
    }
}
