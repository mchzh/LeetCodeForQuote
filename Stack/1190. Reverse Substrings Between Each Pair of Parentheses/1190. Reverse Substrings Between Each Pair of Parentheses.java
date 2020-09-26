class Solution {
    // stack
    public String reverseParentheses(String s) {
        String ret = "";
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isAlphabetic(c)) {
                ret += c;
            } else if (c == '(') {
                stack.push(ret.length());
            } else { // ')'
                int start = stack.pop();
                ret = reverseRet(ret, start, ret.length()-1);
            }
        }
        return ret;
    }
    private String reverseRet(String s, int start, int end) {
        char[] chars = s.toCharArray();
        while (start < end) {
            char temp = chars[start];
            chars[start] = chars[end];
            chars[end] = temp;
            start++;
            end--;
        }
        return String.valueOf(chars);
    }
}

// stack

// (abcd)
    
// dcba

// (u(love)i)
// char : str
// (: 
// )
// stack: 1,
// u (love)i
// u love -> u evol i
// 1 end
