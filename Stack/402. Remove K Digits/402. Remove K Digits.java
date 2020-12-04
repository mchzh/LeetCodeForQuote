class Solution {
    public String removeKdigits(String num, int k) {
        if (k >= num.length()) return "0";
        //monotone increasing stack
        int count = 0;
        Stack<Integer> stack = new Stack<>();
        for (char c : num.toCharArray()) {
            int cur = c -'0';
            while (!stack.isEmpty() && cur < stack.peek() && count < k) {
                stack.pop();
                count++;
            }
            stack.push(cur);
        }
        // regenerate string
        for (int i =0; i < k-count; i++) stack.pop();
        String str = "";
        while (!stack.isEmpty()) str = (char)(stack.pop()+'0') + str;
        int idx = 0;
        while (idx < str.length() && str.charAt(idx) == '0') idx++;
        if (idx == str.length()) return "0";
        return str.substring(idx);
    }
}

//  1 4 <-3 <-2 2 <-1 9
// 1 2 3 4 5 6
