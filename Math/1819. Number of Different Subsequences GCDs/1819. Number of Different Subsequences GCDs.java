class Solution {
    public int countDifferentSubsequenceGCDs(int[] nums) {
//         Set<Integer> set = new HashSet<>();
//         int max = 0;
//         for (int cur : nums) {
//             set.add(cur);
//             max = Math.max(max, cur);
//         }
//         Integer[] array = set.stream().toArray(Integer[]::new);
//         int m = array.length;
//         int[][] dp = new int[m+1][max+1];
//         for (int j = 0; j <= max; j++) dp[0][j] = 0;
//         for (int i = 1; i <= m; i++) {
//             int num = array[i-1];
//             dp[i][num] = 1;
//         }
        
//         for (int i = 2; i <= m; i++) {
//             for (int g = 1; g <= array[i-1]; g++) {
//                 // not select
//                 dp[i][g] = Math.max(dp[i][g], dp[i-1][g]);
//                 int curgcd = getGCD(g, array[i-1]);
//                 // select
//                 dp[i][curgcd] = Math.max(dp[i][curgcd], dp[i-1][g]+1);
//             }
//         }
//         int rets = 0;
//         for (int d : dp[m]) {
//             if (d > 0) rets++;
//         }
//         return rets;
        int[] g = new int[200001]; // index : factor -> num : input element
        for (int n : nums) {
            for (int i = 1; i <= Math.sqrt(n); i++) {
                if (n%i == 0) {
                    if (g[i] == 0) g[i] = n;
                    else g[i] = getGCD(g[i], n);
                    
                    if (n/i != i) {
                        if (g[n/i] == 0) g[n/i] = n;
                        else g[n/i] = getGCD(g[n/i], n);
                    }
                }
            }
        }
        
        int count = 0;
        for (int i = 1; i <= 200000; i++) {
            //System.out.println(i + " " + g[i]);
            if (g[i] == i) count++;
        }
        return count;
    }
    private int getGCD(int a, int b) {
        if (a == 0 || b == 0) return a+b;
        return getGCD(b, a%b);
    }
}
