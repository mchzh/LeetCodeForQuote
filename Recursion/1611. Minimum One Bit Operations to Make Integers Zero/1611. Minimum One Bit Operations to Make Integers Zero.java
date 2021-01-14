class Solution {
    // dfs + memo
    Map<String, Integer> memo1 = new HashMap<>();
    Map<String, Integer> memo2 = new HashMap<>();
    public int minimumOneBitOperations(int n) {
        String cur = Integer.toBinaryString(n);
        return dfs(cur);
    }
    private int dfs(String strs) {
        // corner case
        if (strs.length() == 0) return 0;
        if (strs.equals("0")) return 0;
        if (strs.equals("1")) return 1;
        if (memo1.containsKey(strs)) return memo1.get(strs);
        
        // recursion
        // first remove lead zero
        if (strs.charAt(0) == '0') return dfs(strs.substring(1));
        // get the rest n-1 char
        String hsub = strs.substring(1);
        StringBuilder sb = new StringBuilder();
        sb.append('1');
        for (int i = 1; i < hsub.length(); i++) {
            sb.append('0');
        }
        
        memo1.put(strs, helper(hsub) + 1 + dfs(sb.toString()));
        return memo1.get(strs);
    }
    
    private int helper(String strs) {
        if (strs.length() == 0) return 0;
        if (strs.equals("0")) return 1;
        if (strs.equals("1")) return 0;
        if (memo2.containsKey(strs)) return memo2.get(strs);
        
        // recursion
        if (strs.charAt(0) == '1') {
            memo2.put(strs, dfs(strs.substring(1)));
        } else {
            String hsub = strs.substring(1);
            StringBuilder sb = new StringBuilder();
            sb.append('1');
            for (int i = 1; i < hsub.length(); i++) {
                sb.append('0');
            }
            memo2.put(strs, helper(hsub) + 1 + dfs(sb.toString()));
        }
        return memo2.get(strs);
    }
}

// 101011 => => 1(10000) => 0(10000) => 0(00000)

// 1(XXXXX) => => 1(10000) => 0(10000) => 0(00000)

// dfs : change the current n as zero
// 1(XXXXX) => => 1(10000) => 0(10000) => 0(00000)
// dfs(1(XXXXX)) = helper(XXXXX) {head 1 keep not change} + 1 + dfs(10000);

// helper: the operation required to convert XXXXX to 10000
//     1. 1XXXX => dfs(XXXX);
//     2. 0XXXX => 0(1000) => 1(1000) => 1(0000)
//              => helper(XXXX) + 1 + dfs(1000);
