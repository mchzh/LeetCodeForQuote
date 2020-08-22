class Solution {
    // stack and pair (key, value)
    class Pair {
        char c;
        int count;
        public Pair(char c, int count) {
            this.c = c;
            this.count = count;
        }
    }
    
    public String removeDuplicates(String s, int k) {
        Stack<Pair> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (!stack.isEmpty() && stack.peek().c == ch && stack.peek().count == k-1) {
                stack.pop();
            } else {
                Pair cur = stack.isEmpty() ? null : stack.peek();
                if (cur == null || cur.c != ch) {
                    stack.push(new Pair(ch, 1));
                    continue;
                }
                cur.count += 1;
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            Pair restChar = stack.pop();
            for (int i = 0;i < restChar.count; i++) {
                sb.append(restChar.c);
            }
        }
        return sb.reverse().toString();
    }
}
