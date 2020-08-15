class Solution {
    public String decodeString(String s) {
        String strs = s;
        if (strs == null || strs.length() == 0) return "";
        Stack<String> stack = new Stack<>();
        int curnum = 0;
        String vStr = "";

        for (int i = 0; i < strs.length(); i++) {
          char c = strs.charAt(i);
          if (c >= '0' && c <= '9') {
            if (!vStr.equals("")) {
              stack.push(vStr);
              vStr = "";
            }
            curnum = curnum*10 + (c-'0');
          } else if (c == '[') {
            stack.push(String.valueOf(curnum));
            stack.push(String.valueOf(c));
            curnum = 0;
          } else if (c == ']') {
            stack.push(vStr);
            vStr = "";
            //pop operation
            StringBuilder sb = new StringBuilder();
            while (!stack.isEmpty() && !stack.peek().equals("[")) {
              sb.insert(0, stack.pop());
            }
            String extend = sb.toString();
            stack.pop();
            int extendNum = Integer.valueOf(stack.pop());
            String temp = extend;
            for (int k = 0; k < extendNum-1; k++) {
              extend += temp;
            }
            stack.push(extend);
          } else {
            vStr += c;
          }
        }
        if (!vStr.equals("")) stack.push(vStr);

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.insert(0, stack.pop());
        }
        return sb.toString();
        
    }
}
