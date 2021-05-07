class Solution {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int sign = 1;
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ') continue;
            if (Character.isDigit(c)) {
                int j = i;
                while (j < s.length() && Character.isDigit(s.charAt(j))) j++;
                sum += sign * Integer.valueOf(s.substring(i, j));
                i = j-1;
            } else if (c == '(') {
                stack.push(sum);
                stack.push(sign);
                sum = 0;
                sign = 1;
            } else if (c == ')') {
                sum *= stack.pop();
                sum += stack.isEmpty() ? 0 : stack.pop();
            } else {
                sign = (c == '+' ? 1 : -1);
            }
        }
        
        return sum;
    }
}
