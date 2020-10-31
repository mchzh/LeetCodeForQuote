class Solution {
    public int minCost(String s, int[] cost) {
        // slide window
        // repeat element sum and max val
        int i = 0, j = 0, n = s.length();
        int max = 0, sum = 0;
        int rets = 0;
        while (j < n) {
            if (s.charAt(j) != s.charAt(i)) {
                i = j;
                rets += sum-max;
                sum = 0;
                max = 0;
            }
            sum += cost[j];
            max = Math.max(max, cost[j]);
            j++;
        }
        if (j-1 > i) {
            rets += sum-max;
        } 
        return rets;
    }
}
