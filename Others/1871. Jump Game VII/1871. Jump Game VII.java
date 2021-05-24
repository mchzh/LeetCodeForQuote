class Solution {
    public boolean canReach(String s, int minJump, int maxJump) {
        int n = s.length();
        if (s.charAt(n-1) == '1') return false;
        int[] sum = new int[n+1];
        for (int i = 0; i < n; i++) {
            sum[i+1] = sum[i] + (s.charAt(i)-'0');
        }
        int[] diff = new int[n+1];
        diff[0+minJump] += 1;
        diff[0+maxJump+1] -= 1;
        int reach = 0;
        for (int i = 1; i < n; i++) {
            reach += diff[i];
            if (reach == 0) continue;
            if (s.charAt(i) == '1') continue;
            
            if (i+minJump <= n) diff[i+minJump] += 1;
            if (i+maxJump+1 <= n) diff[i+maxJump+1] -= 1;
        }
        return reach > 0;
        // boolean[] dp = new boolean[n];
        // dp[0] = true;
        // for (int i = 1; i < n; i++) {
        //     if (s.charAt(i) == '1') continue;
        //     for (int j = i-minJump; j >= Math.max(0, i-maxJump); j--) {
        //         if (s.charAt(j) == '0') {
        //             if (dp[j]) {
        //                 dp[i] = true;
        //                 break;
        //             }
        //         }
        //     }
        // }
        // return dp[n-1];
    }
}
