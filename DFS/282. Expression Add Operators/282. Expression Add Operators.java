class Solution {
    // search
    List<String> rets;
    public List<String> addOperators(String num, int target) {
        rets = new ArrayList<>();
        dfs(num, (long)target, 0, 0, 0, "");
        return rets;
    }
    private void dfs(String num, long target, int pos, long preval, long lastval, String prestr) {
        // corner case
        if (pos == num.length()) {
            if (preval == target) rets.add(prestr);
        }
        
        for (int i = pos+1; i <= num.length(); i++) {
            String cur = num.substring(pos, i);
            // leading zero
            if (cur.length() > 1 && cur.charAt(0) == '0') continue;
            long curval = Long.valueOf(cur);
            
            if (pos == 0) {
                dfs(num, target, i, preval+curval, curval, prestr + cur); //non
            } else {
                dfs(num, target, i, preval+curval, curval, prestr + "+" + cur); //+
                dfs(num, target, i, preval-curval, -curval, prestr + "-" + cur); //-
                dfs(num, target, i, preval-lastval + lastval*curval, lastval*curval, prestr + "*" + cur); //*
            }  
        }
    }
}

// (12+3+4)*DFS(56789)
