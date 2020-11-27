class Solution {
    
    private static Set<Character> OP_SET = new HashSet<>(Arrays.asList('+', '-', '*', '/'));
    
    int i = 0;
    
    public int calculate(String s) {
        char sign = '+';
        Stack<Integer> stack = new Stack<>();
        while (i < s.length()) {
            char c = s.charAt(i ++);
            if (Character.isDigit(c)) {
                int num = c - '0';
                while (i < s.length() && Character.isDigit(s.charAt(i))) {
                    char next = s.charAt(i ++);
                    num *= 10;
                    num += next - '0';
                }
                helper(stack, num, sign);
            } else if (OP_SET.contains(c)) {
                sign = c;                
            } else if (c == '(') {
                int num = calculate(s);
                helper(stack, num, sign);
            } else if (c == ')') {
                break;
            }
        }
        int sum = 0;
        for (int val : stack) {
            sum += val;
        }
        return sum;
    }
    
    private void helper(Stack<Integer> stack, int num, char sign) {
        if (sign == '+') {
            stack.push(num);
        } else if (sign == '-') {
            stack.push(-num);
        } else if (sign == '/') {
            stack.push(stack.pop() / num);
        } else if (sign == '*') {
            stack.push(stack.pop() * num);
        } 
    }
}
