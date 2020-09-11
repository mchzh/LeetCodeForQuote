class Solution {
    public int calculate(String s) {
        StringBuilder sb = new StringBuilder();
        sb.append('+');
        for (char ch : s.toCharArray()) {
            if (ch == ' ') continue;
            sb.append(ch);
            if (ch == '(') sb.append('+');
        }
        String strs = sb.toString();
        
        int sum = 0;
        int sign = 0;
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> signs = new Stack<>();
        for (int i = 0; i < strs.length(); i++) {
            char ch = strs.charAt(i);
            // 4 : + and -; digit; (; )
            if (ch == '+' || ch == '-') {
                sign = ch == '+' ? 1 : -1;
            } else if (Character.isDigit(ch)) {
                int j = i;
                while (j < strs.length() && Character.isDigit(strs.charAt(j))) j++;
                int num = Integer.valueOf(strs.substring(i, j));
                sum += sign*num;
                i = j-1;
            } else if (ch == '(') {
                stack.push(sum);
                signs.push(sign);
                sum = 0;
            } else if (ch == ')') {
                sum = signs.pop() * sum;
                sum = (stack.isEmpty() ? 0 : stack.pop()) + sum;
            }
        }
        return sum;
    }
}

/*class Solution {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int start = 0, sign = 1, res = 0;
        while(start < s.length()){
            char c = s.charAt(start);
            if(Character.isDigit(c)) {
                int sum = c - '0';
                while(start+1 < s.length() && Character.isDigit(s.charAt(start+1))){
                    sum *= 10;
                    sum += s.charAt(++start) - '0';
                }
                
                res += sign * sum;
            }else if(c == '+'){
                sign = 1;
            }else if(c == '-'){
                sign = -1;
            }else if(c == '('){
                stack.push(res);
                stack.push(sign);
                res = 0;
                sign = 1;
            }else if(c == ')'){
                res = stack.pop() * res + stack.pop();
            }
            
            start++;
        }
        
        return res;
    }
}*/
