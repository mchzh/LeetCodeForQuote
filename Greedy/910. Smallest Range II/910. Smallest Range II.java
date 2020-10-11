class Solution {
    public int smallestRangeII(int[] A, int K) {
        Arrays.sort(A);
        int N = A.length;
        int diff = A[N-1] - A[0];
        for (int i = 0; i < N-1; i++) {
            int max = Math.max(A[i] + K, A[N-1]-K);
            int min = Math.min(A[0]+K, A[i+1] - K);
            diff = Math.min(diff, max-min);
        }
        return diff;
    }
}


// 1 2 3 || 4 5 6 7 8 9
// + + +    - - - - - -
