class Solution {
    public int minSwaps(int[] data) {
        int n = data.length;
        int[] countzero = new int[n+1];
        int count = 0, countone = 0;
        for (int i = 0; i < n; i++) {
            if (data[i] == 0) count++;
            countzero[i+1] = count;
        }
        int size = n-count;
        
        int rets = Integer.MAX_VALUE;
        for (int i = size-1; i < n; i++) {
            rets = Math.min(rets, countzero[i+1] - countzero[i+1-size]);
        }
        return rets;
    }
}
