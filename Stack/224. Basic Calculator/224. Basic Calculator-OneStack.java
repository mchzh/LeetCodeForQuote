class Solution {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int sign = 1, num = 0, curnum = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == ' ') continue;
            if (Character.isDigit(ch)) {
                curnum = curnum*10 + (ch-'0');
            } else if (ch == '+' || ch == '-') {
                num = num + sign *curnum;
                curnum = 0;
                sign = ch == '+' ? 1 : -1;
            } else if (ch == '(') {
                // push to stack
                stack.push(num);
                stack.push(sign);
                num = 0;
                curnum = 0;
                sign = 1;
            } else if (ch == ')') {
                // pop from stack
                num += sign * curnum;
                num = stack.pop()*num + stack.pop();
                curnum = 0;
                sign = 1;
            }
        }
        num += sign*curnum;
        return num;
    }
}
