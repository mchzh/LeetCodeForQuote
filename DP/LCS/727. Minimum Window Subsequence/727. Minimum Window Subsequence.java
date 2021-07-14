class Solution {
    // https://leetcode.com/problems/minimum-window-subsequence/discuss/617034/Java-AC-Brute-Force-with-Optimisation-or-Easy-to-understand-Explanation
    // https://leetcode.com/problems/minimum-window-subsequence/discuss/649370/Heavily-commented-Dynamic-Programming-code-in-Java
    // dp or dfs
    public String minWindow(String S, String T) {
        // dp
        /*int[] suboccur = new int[26];
        Set<Character> setT = new HashSet<>();
        for (char ch : T.toCharArray()) {
            setT.add(ch);
            suboccur[ch-'a']++;
        }
        String res = "";
        int min = Integer.MAX_VALUE;
        int left = 0, right = 0;
        while (right < S.length()) {
            char cright = S.charAt(right);
            if (setT.contains(cright)){
                suboccur[cright-'a']--;
            } 
            if (isMatch(suboccur)) {
                if (isSubsequence(S.substring(left, right+1), T)) {
                    int idx = left;
                    while (idx < right && !setT.contains(S.charAt(idx))) {
                        idx++;
                    }
                    if (min > right-idx+1) {
                        min = right-idx+1;
                        res = S.substring(idx, right+1);
                    }
                } //res = Math.max(res, right-left+1);
            }
            while (left < right && isMatch(suboccur)) {
                char cleft = S.charAt(left);
                if (setT.contains(cleft)){
                    suboccur[cleft-'a']++;
                } 
                left++;
            }
            right++;
        }
        return res;*/
       /* if(S == null || T == null) {
            return "";
        }
        
        if(S.length() == 0 || T.length() == 0 || S.length() < T.length()) {
            return ""; 
        }
        
        int[] map = new int[256];
        int left = 0;
        int minStart = 0;
        int minLen = Integer.MAX_VALUE;
        int count = 0;
        
        for(char c : T.toCharArray()) {
            map[c]++;
        }
        
        for(int i = 0; i < S.length(); i++) {
            char p = S.charAt(i);
            if(map[p] > 0) {
                count++;
            }
            map[p]--;
            
            while(count == T.length()) {
                System.out.println("get substring include all T element -> " + S.substring(left, i+1));
                if(i - left + 1 < minLen) {
                    
                    if (isSubsequence(S.substring(left, i+1), T)) {
                        minLen = i - left + 1;
                        minStart = left;
                    }
                }
                map[S.charAt(left)]++;
                if(map[S.charAt(left)] > 0) {
                    count--;
                }
                left++;
            }
        }
        
        return minLen == Integer.MAX_VALUE? "" : S.substring(minStart, minStart + minLen);*/
        // dp[i][j]: the minimum (contiguous) substring W of S[0:i] ending with S[i], that contains T[0:j].
        // xxxx[xxxx] i
        // yy{yyyy} j
        // 1. dp[i][j] = dp[i-1][j-1] +1; 2. dp[i][j] = dp[i-1][j] +1;
        int m = S.length(), n = T.length();
        int[][] dp = new int[m+1][n+1];
        
        //initial this dp
        for (int j = 0; j <= n; j++) {
            dp[0][j] = Integer.MAX_VALUE /2 ;
        }
        for (int i = 0; i <= m; i++) {
            dp[i][0] = 0;
        }
        
        // loop this dp and apply the state transition euqation
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (S.charAt(i-1) == T.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1] +1;
                } else {
                    dp[i][j] = dp[i-1][j] +1;
                }
            }
        }
        
        int len = Integer.MAX_VALUE;
        int endidx = 0;
        for (int i = 1; i <= m; i++) {
            if (len > dp[i][n]) {
                len = dp[i][n];
                endidx = i-1;
            }
        }
        if (len >= Integer.MAX_VALUE /2) {
            return "";
        } else {
            return S.substring(endidx-len+1, endidx+1);
        }
        
    }
    private boolean isMatch(int[] sub) {
        for (int i = 0; i < sub.length; i++) {
            if (sub[i] != 0) return false;
        }
        return true;
    }
    private boolean isSubsequence(String s, String t) {
        int sp =0, tp = 0;
        while (sp < s.length() && tp < t.length()) {
            if (s.charAt(sp) == t.charAt(tp)) {
                sp++;
                tp++;
            } else {
                sp++;
            }
        }
        return tp == t.length();
    }
}

/*class Solution {
    public String minWindow(String S, String T) {
        int sindex=0,tindex=0,slen=S.length(),tlen=T.length();
        int ans=S.length()+1,start=-1;
        char []s=S.toCharArray();
        char []t=T.toCharArray();
        for(;sindex<slen;sindex++){
            if(s[sindex]==t[tindex]){
                
                if(++tindex==tlen){
                    int end=sindex+1;
                    while(--tindex>=0){
                        while(s[sindex--]!=t[tindex]);
                    }
                    sindex++;
                    tindex++;
                    if(end-sindex<ans){
                        ans=end-sindex;
                        start=sindex;
                    }
                }

            }
        }
        return start==-1?"":S.substring(start,start+ans);
    }
}*/
