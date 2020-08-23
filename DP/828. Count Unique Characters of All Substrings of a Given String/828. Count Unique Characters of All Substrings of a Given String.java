class Solution {
    // https://leetcode.com/problems/count-unique-characters-of-all-substrings-of-a-given-string/discuss/129021/O(N)-Java-Solution-DP-Clear-and-easy-to-Understand
    // https://leetcode.com/problems/count-unique-characters-of-all-substrings-of-a-given-string/discuss/128952/C%2B%2BJavaPython-One-pass-O(N)
    public int uniqueLetterString(String s) {
        int res = 0;
        int[][] idex = new int[26][2];
        for (int i = 0; i < 26; i++) Arrays.fill(idex[i], -1);
        
        int N = s.length(), mod = (int)Math.pow(10,9) + 7;
        for (int i = 0; i < N; i++) {
            int c = s.charAt(i)-'A';
            res = (res + (i-idex[c][1])*(idex[c][1] - idex[c][0]) % mod) % mod;
            idex[c] = new int[] {idex[c][1], i};
        }
        for (int c = 0; c < 26; c++) {
            res = (res + (N-idex[c][1])*(idex[c][1] - idex[c][0]) % mod) % mod;
        }
        return res;
    }
    public int uniqueLetterStringWithSuffix(String s) {
        int res = 0;
        if (s == null || s.length() == 0) return res;
        int[] showlastPosition = new int[128];
        int[] contribution = new int[128];
        int cur = 0;
        for (int i = 0; i < s.length(); i++) {
            char x = s.charAt(i);
            cur -= contribution[x];
            contribution[x] = (i- (showlastPosition[x]-1));
            cur += contribution[x];
            showlastPosition[x] = i+1;
            res += cur; 
        }
        return res;
    }
}
