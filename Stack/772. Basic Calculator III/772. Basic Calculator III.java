class Solution {
    public int calculate(String s) {
        // encounter '(' current string push stack
        // encounter ')' current string eval the result then push into stack
        Stack<String> stack = new Stack<>();
        String curVal = "";
        
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                stack.push(curVal);
                curVal = "";
            } else if (ch == ')') {
                int ret = eval(curVal);
                curVal = stack.pop() + String.valueOf(ret);
                //stack.push(curVal);
            } else {
                curVal += ch;
            }
        }
        return eval(curVal);
    }
    private int eval(String strs) {
        StringBuilder sb = new StringBuilder();
        sb.append("+");
        for (char ch : strs.toCharArray()) {
            if (ch == ' ') continue;
            sb.append(ch);
        }
        String curs = sb.toString();
        
        Stack<Long> stack = new Stack<>();
        for (int i = 0; i < curs.length(); i++) {
            char c = curs.charAt(i);
            if (c == '+' || c == '-') {
                int j = i+1;
                if (curs.charAt(j) == '+' || curs.charAt(j) == '-') j++;
                while ( j < curs.length() && Character.isDigit(curs.charAt(j)) ) j++;
                long num = Long.valueOf(curs.substring(i+1, j));
                if (c == '+') stack.push(num);
                else stack.push(-num);
                i = j-1;
            } else {
                int j = i+1;
                if (curs.charAt(j) == '+' || curs.charAt(j) == '-') j++;
                while ( j < curs.length() && Character.isDigit(curs.charAt(j)) ) j++;
                long num = Long.valueOf(curs.substring(i+1, j));
                if (c == '*') stack.push(stack.pop()*num);
                else stack.push(stack.pop()/num);
                i = j-1;
            }
        }
        
        int ret = 0;
        while (!stack.isEmpty()) ret += stack.pop();
        return ret;
    }
}

//"(2+6* 3+5- (3*14/7+2)*5)+3"

// +10--4+3*-2++6-2-3
// +10, --4, +3*(-2), ++6, -2, -3
