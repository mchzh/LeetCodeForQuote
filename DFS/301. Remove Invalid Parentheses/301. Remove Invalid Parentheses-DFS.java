class Solution {
    List<String> rets;
    int maxlen = 0;
    public List<String> removeInvalidParentheses(String s) {
        // dfs + pruning
        rets = new ArrayList<>();
        // get max len
        int count = 0, remove = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                count++;
            } else if (c == ')') {
                count--;
                if (count < 0) {
                    remove++;
                    count = 0;
                }
            }
        }
        remove += count;

        maxlen = s.length() - remove;
        String curstr = "";
        dfs(s, 0, curstr, 0);
        return rets;
    }
    
    private void dfs(String s, int idx, String curstr, int count) {
        if (count < 0) return;
        if (curstr.length() > maxlen) return;
        if (idx == s.length()) {
            //System.out.println(idx + " " + curstr + " " + maxlen);
            if (count == 0 && curstr.length() == maxlen) rets.add(curstr);
            return;
        }

        char c = s.charAt(idx);
        if (c != '(' && c != ')') {
            dfs(s, idx+1, curstr+c, count);
        } else {
            dfs(s, idx+1, curstr+c, count+(c == '(' ? 1 : -1));
            if (curstr.length() == 0 || c != curstr.charAt(curstr.length()-1)) 
                dfs(s, idx+1, curstr, count);
        }
    }
}

// maxlen = total - minremove

// pruning:
// 1. count < 0;
// 2. size > maxlen

// dfs : 
// (((())
// 2^4 = 16
// C(4,2) = 6
// -> 
// 1
// (())

// dfs(s, index, curstr, count)

// 1. if s[i] != curstr.back()
//         // two : sel and non-sel
//         dfs(s, index+1, curste+s[i], count)
//         dfs(s, index+1, curstr, count)
// 2. if s[i] == curstr.back()
//         dfs(s, index+1, curste+s[i], count) // must sel
