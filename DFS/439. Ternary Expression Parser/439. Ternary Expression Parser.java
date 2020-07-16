class Solution {
    // stack or dfs
    // https://leetcode.com/problems/ternary-expression-parser/discuss/728887/Java-DFS-easy
    // https://leetcode.com/problems/ternary-expression-parser/discuss/92165/5ms-JAVA-DFS-Solution
    public String parseTernary(String expression) {
        // critical point to ensure the current level ':'
        return helper(expression, 0, expression.length()-1);
    }
    private String helper(String expression, int start, int end) {
        if (start == end) {
            return String.valueOf(expression.charAt(start));
        }
        
        // find the pos of ':' of this level
        int count = 1;
        int idx = start+2;
        while (idx <= end) {
            // ':', '?'
            if (expression.charAt(idx) == ':') {
                count--;
            }
            if (expression.charAt(idx) == '?') {
                count++;
            }
            if (count== 0) {
                break;
            }
            idx++;
        }
        
        // if it is true
        if (expression.charAt(start) == 'T') {
            return helper(expression, start+2, idx-1);
        }
        // otherwise it is False;
        return helper(expression, idx+1, end);
    }
}
/*class Solution {
        public String parseTernary(String expression) {
        int n = expression.length();
        int checkLevel = 0;
        for (int j = 1; j < n; j++) {
            if (expression.charAt(j) == '?') checkLevel++;
            if (expression.charAt(j) == ':') checkLevel--;
            if (checkLevel == 0) return (expression.charAt(0) == 'T') ? parseTernary(expression.substring(2, j)) : parseTernary(expression.substring(j+1));
        }
        return expression;
    }

}*/
