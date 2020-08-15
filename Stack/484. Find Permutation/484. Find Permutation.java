class Solution {
    public int[] findPermutation(String s) {
        // use stack to reverse the segment number
        int[] ret = new int[s.length()+1];
        Stack<Integer> stack = new Stack<>();
        
        int idx = 0;
        for (int i = 1; i < s.length()+1; i++) {
            char c = s.charAt(i-1);
            if ( c == 'I' ) {
                stack.push(i);
                while ( !stack.isEmpty() ) {
                    ret[idx++] = stack.pop();
                }
            } else {
                stack.push(i);
            }
        }
        stack.push(s.length()+1);
        while ( !stack.isEmpty() ) {
            ret[idx++] = stack.pop();
        }
        return ret;
    }
}
