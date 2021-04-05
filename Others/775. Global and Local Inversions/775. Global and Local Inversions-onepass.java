class Solution {
    public boolean isIdealPermutation(int[] A) {
        int n = A.length;
        int curmax = A[0];
        for (int i = 0; i < n; i++) {
            if (i >= 2) curmax = Math.max(curmax, A[i-2]);
            if (i >= 2 && A[i] < curmax) return false;
        }
        return true;
    }
}
