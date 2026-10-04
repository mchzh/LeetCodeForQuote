class Solution {
    public boolean checkValidString(String s) {
        int n = s.length();
        int[][] dp= new int[n][2];
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == '(') {
                dp[i][0] = ((i == 0) ? 1 : dp[i-1][0]+1);
                dp[i][1] = ((i == 0) ? 1 : dp[i-1][1]+1);
            } else if (c == ')') {
                dp[i][0] = ((i == 0) ? -1 : dp[i-1][0]-1);
                dp[i][1] = ((i == 0) ? -1 : dp[i-1][1]-1);
            } else {
                dp[i][0] = ((i == 0) ? -1 : dp[i-1][0]-1);
                dp[i][1] = ((i == 0) ? 1 : dp[i-1][1]+1);
            }
            //System.out.println(i + " : " + (dp[i][0] <= 0 && dp[i][1] >= 0));
            //if ( !(dp[i][0] <= 0 && dp[i][1] >= 0) ) return false;
            if ( dp[i][1] < 0 ) return false;
            if (dp[i][0] < 0) {
                dp[i][0] = 0;
            }
        }
        return dp[n-1][0] == 0;

        // two path
        // left -> right;
        // int leftopen = 0, count = 0;
        // for (int i = 0; i < s.length(); i++) {
        //     char c = s.charAt(i);
        //     if (c == '(') {
        //         leftopen++;
        //     } else if (c == ')') {
        //         if (leftopen < 1) {
        //             if (count > 0) {
        //                 count--;
        //             } else return false;
        //         } else leftopen--;
        //     } else {
        //         count++;
        //     }
        // }
        // int rightopen = 0;
        // count = 0;
        // for (int i = s.length()-1; i >= 0; i--) {
        //     char c = s.charAt(i);
        //     if (c == ')') {
        //         rightopen++;
        //     } else if (c == '(') {
        //         if (rightopen < 1) {
        //             if (count > 0) {
        //                 count--;
        //             } else return false;
        //         } else rightopen--;
        //     } else {
        //         count++;
        //     }
        // }
        // return true;
    }
}
