class Solution {
    public boolean isIdealPermutation(int[] A) {
        int n = A.length;
        int curmax = Integer.MIN_VALUE;
        int count = 0;
        for (int i = 0; i < n-1; i++) {
            if (A[i] > A[i+1]) {
                count++;
                if (count > 1 || A[i+1] <= curmax) return false;
            } else {
                if (A[i+1] <= curmax) return false;
                count = 0;  
            }
            curmax = Math.max(curmax, A[i]);
        }
        return true;
    }
}
// decreasing trending
// increasing trending
