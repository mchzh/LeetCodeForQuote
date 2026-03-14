class Solution {
    // recursion
    public String getHappyString(int n, int k) {
        int pow2 = (int)Math.pow(2, n-1);
        if (k > 3*pow2) return "";
        //System.out.println(pow2 + " " + k);
        if (k <= pow2) {
            return "a" + dfs(n-1, k, 'a');
        } else if (k <= 2*pow2) {
            return "b" + dfs(n-1, k-pow2, 'b');
        } else {
            return "c" + dfs(n-1, k-2*pow2, 'c');
        }
    }
    private String dfs(int n, int k, char c) {
        // c is previous char
        if (n == 0) return "";
        
        int pownext = (int)Math.pow(2, n-1);
        if (c == 'a') {
            if (k <= pownext) {
                return "b" + dfs(n-1, k, 'b');
            } else {
                return "c" + dfs(n-1, k-pownext, 'c');
            }
        } else if (c == 'b') {
            if (k <= pownext) {
                return "a" + dfs(n-1, k, 'a');
            } else {
                return "c" + dfs(n-1, k-pownext, 'c');
            }
        } else if (c == 'c') {
            if (k <= pownext) {
                return "a" + dfs(n-1, k, 'a');
            } else {
                return "b" + dfs(n-1, k-pownext, 'b');
            }
        } else return "";
        //return "";
    }
}

// total ： 3*2^(n-1)
