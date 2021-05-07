class Solution {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int sign = 1;
        int num = 0, prenum = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                num = num*10 + (c-'0');
            } else if (c == '(') {
                stack.push(prenum);
                stack.push(sign);
                num = 0;
                prenum = 0;
                sign = 1;
            } else if (c == ')') {
                prenum += sign*num;
                //System.out.println(i + " " + prenum);
                prenum *= stack.pop();
                prenum += stack.pop();
                //System.out.println("remove parethensi -> " + i + " " + prenum);
                num = 0;
                sign = 1;
            } else {
                if (c == ' ') continue;
                prenum = sign*num+prenum;
                sign = (c == '+' ? 1 : -1);
                num = 0;
            }
        }
        prenum += sign*num;
        return prenum;
    }
}
