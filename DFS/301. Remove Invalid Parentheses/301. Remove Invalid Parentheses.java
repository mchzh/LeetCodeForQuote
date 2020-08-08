class Solution {
    List<String> rets = new ArrayList<>();
    int retLen = -1;
    public List<String> removeInvalidParentheses(String s) {
        String curStr = "";
        dfs(curStr, s, 0, 0);
        return rets;
    }
    private void dfs(String curStr, String s, int pos, int count) {
        if (count < 0) return;
        if (pos == s.length()) {
            if (count == 0) {
                if (curStr.length() > retLen) {
                    rets.clear();
                    rets.add(curStr);
                    retLen = curStr.length();
                } else if (curStr.length() == retLen) {
                    rets.add(curStr);
                }
            }
            return;
        }
        
        char markCh = s.charAt(pos);
        if (markCh != '(' && markCh != ')') {
            dfs(curStr+markCh, s, pos+1, count);
            return;
        }
        dfs(curStr+markCh, s, pos+1, count + (markCh == '(' ? 1 : -1)); // no matter what select current parethes
        if (curStr.length() == 0 || markCh != curStr.charAt(curStr.length()-1)) 
            dfs(curStr, s, pos+1, count); // can skip the current parenthese
    }
}

// (((((( -> (( C(6, 2)
            
// s    ->   ( 
// curS -> ((
// curS -> (((
// curS -> ((X not match, repeat
//         X((
