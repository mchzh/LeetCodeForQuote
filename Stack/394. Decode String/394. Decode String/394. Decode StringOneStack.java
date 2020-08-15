class Solution {
    public String decodeString(String strs) {
        if (strs == null || strs.length() == 0) return "";
        Stack<String> stack = new Stack<>();
        int curnum = 0;
        String curStr = "";

        for (int i = 0; i < strs.length(); i++) {
          char c = strs.charAt(i);
          if ( Character.isDigit(c) ) {
              int i0 = i;
              while (i < strs.length() && Character.isDigit(strs.charAt(i)) ) {
                  i++;
              }
              stack.push(curStr);
              stack.push(strs.substring(i0, i));
              curStr = "";
          } else if (c == ']') {
            //pop operation
            int extendNum = Integer.valueOf(stack.pop());
            String temp = curStr;
            for (int k = 0; k < extendNum-1; k++) {
              curStr += temp;
            }
            curStr = stack.pop() + curStr;
          } else {
            curStr += c;
          }
        }
        return curStr;
    }
}
