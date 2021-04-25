class Solution {
    public int candy(int[] ratings) {
        // 2 pass : left -> right
        int n = ratings.length;
        int[] range = new int[n];
        Arrays.fill(range, 1);
        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i-1]) range[i] = range[i-1]+1;
        }
        
        for (int i = n-2; i >= 0; i--) {
            if (ratings[i] > ratings[i+1]) {
                range[i] = Math.max(range[i], range[i+1]+1);
            }
        }
        int rets = 0;
        for (int r : range) rets += r;
        return rets;
    }
}
