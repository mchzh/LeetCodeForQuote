class Solution {
    public String decodeString(String s) {
        // two stack
        if (s == null || s.length() == 0) return "";
        Stack<String> strExtend = new Stack<>();
        Stack<Integer> nums = new Stack<>();
        String curStr = "";

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                int curNum = 0;
                while (i < s.length() && Character.isDigit(s.charAt(i))) {
                    curNum = curNum*10 + (s.charAt(i)-'0');
                    i++;
                }
                nums.push(curNum);
                strExtend.push(curStr);
                curStr = "";
            } else if (c == ']') {
                int extendNum = nums.pop();
                
                String temp = curStr;
                for (int k = 0; k < extendNum-1; k++) {
                    curStr += temp;
                }
                curStr = strExtend.pop()+curStr;
            } else {
                curStr += c;
            }
        }
        return curStr;
        
    }
    
    public String decodeStringOneStack(String s) {
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
