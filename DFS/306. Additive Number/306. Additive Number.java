class Solution {
    // https://leetcode.com/problems/additive-number/discuss/75697/Java-Easy-Understand-DFS
    public boolean isAdditiveNumber(String num) {
        // loop to get the two first num then recursion
        int N = num.length();
        
        for (int i = 1; i < N; i++) {
            for (int j = i+1; j < N; j++) {
                long a = parseNum(num.substring(0, i));
                long b = parseNum(num.substring(i, j));
                if (a == -1 || b == -1) continue;
                if (dfs(num.substring(j), a, b)) return true;
            }
        }
        return false;
    }
    
    private boolean dfs(String str, long a, long b) {
        if (str.length() == 0) return true;
        
        for (int i = 1; i <= str.length(); i++) {
            long temp = parseNum(str.substring(0, i));
            if (temp == -1) continue;
            if (a+b == temp && dfs(str.substring(i), b, temp)) {
                return true;
            }
        }
        return false;
    }
    
    private long parseNum(String curStr) {
        if (!curStr.equals("0") && curStr.startsWith("0")) return -1;
        long ret = 0;
        try {
            ret = Long.parseLong(curStr);
        } catch(NumberFormatException e) {
            return -1;
        }
        return ret;
    }
}

/*class Solution {
    public boolean isAdditiveNumber(String num) {
        int n = num.length();
        for (int i = 1; i <= n / 2; i++) {
            for (int j = 1; Math.max(i, j) <= n - i- j; j++)
                if (isValid(i, j, num)) return true;
        }
        
        return false;
    }
    
    public boolean isValid(int i, int j, String num) {
        if (num.charAt(0) == '0' && i > 1) return false;
        if (num.charAt(i) == '0' && j > 1) return false;
        
        Long x1 = Long.parseLong(num.substring(0, i));
        Long x2 = Long.parseLong(num.substring(i, i + j));
        String sum;
        
        for (int start = i + j; start != num.length(); start+=sum.length()) {
            x2 += x1;
            x1 = x2 - x1;
            sum = x2.toString();
            if (!num.startsWith(sum, start)) return false;
        }
        
        return true;
    }
}*/
