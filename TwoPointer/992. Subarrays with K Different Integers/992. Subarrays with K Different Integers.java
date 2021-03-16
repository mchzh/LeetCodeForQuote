class Solution {
    // f(k) = atmost(k)-atmost(k-1)
    public int subarraysWithKDistinct(int[] A, int K) {
        return getMostK(A, K) - getMostK(A, K-1);
    }
    // slide window
    private int getMostK(int[] A, int k) {
        int n = A.length;
        int[] count = new int[n+1];
        int i = 0;
        int rets = 0;
        for (int j = 0; j < n; j++) {
            if (count[A[j]]++ == 0) k--;
            while (k < 0) {
                if (--count[A[i++]] == 0) k++;
            }
            
            rets += j-i+1;
        }
        return rets;
    }
}
