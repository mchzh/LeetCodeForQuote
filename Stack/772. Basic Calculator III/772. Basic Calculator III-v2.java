class Solution {
    public int calculate(String s) {
        int n = s.length();
        
        Stack<String> stack = new Stack<>();
        String cur = "";
        stack.push(cur);
        for (int i = 0;i < n; i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(cur);
                cur = "";
            } else if (c == ')') {
                cur = stack.pop() + String.valueOf(eval(cur));
            } else {
                cur += c;
            }
        }
        
        return eval(cur);
    }
    private int eval(String str) {
        Stack<Integer> stack = new Stack<>();
        int n = str.length();
        int num = 0;
        char sign = '+';
        int extrasign = 1;
        
        for (int i = 0; i < n; i++) {
            char c = str.charAt(i);
            if (Character.isDigit(c)) {
                num = num*10 + (c-'0');
            }
            if ( (!Character.isDigit(c) && c != ' ') || i == n-1) {
                if (sign == '+') {
                    stack.push(num*extrasign);
                } else if (sign == '-') {
                    stack.push((-num)*extrasign);
                } else if (sign == '*') {
                    stack.push(stack.pop()*num*extrasign);
                } else if (sign == '/') {
                    stack.push(stack.pop()/num*extrasign);
                }
                
                if (i+1 < n && (str.charAt(i+1) == '+' || str.charAt(i+1) == '-')) {
                    extrasign = str.charAt(i+1) == '-' ? -1 : 1;
                    i++;
                } else extrasign = 1;
                
                sign = c;
                num = 0;
            }
        }
        int rets = 0;
        while (!stack.isEmpty()) rets += stack.pop();
        return rets;
    }
}
