class Solution {
    public int minSwap(int[] A, int[] B) {
        int unswapped = 0, swapped = 1;
        for (int i = 1; i < A.length; i++) {
            int unswapped_prev = unswapped;
            int swapped_prev = swapped;
            
            unswapped = Integer.MAX_VALUE;
            swapped = Integer.MAX_VALUE;
            if (A[i-1] < A[i] && B[i-1] < B[i]) {
                unswapped = Math.min(unswapped, unswapped_prev);
            }
            if (B[i-1] < A[i] && A[i-1] < B[i]) {
                unswapped = Math.min(unswapped, swapped_prev);
            }
            if (A[i-1] < B[i] && B[i-1] < A[i]) {
                swapped = Math.min(swapped, unswapped_prev+1);
            }
            if (B[i-1] < B[i] && A[i-1] < A[i]) {
                swapped = Math.min(swapped, swapped_prev+1);
            }
        }
        return Math.min(unswapped, swapped);
    }
}

// A[i]
// B[i]

// B[i]
// A[i]

// A[i-1]
// B[i-1]

// B[i-1]
// A[i-1]

// dp[i][0], dp[i][1] <= dp[i-1][0], dp[i-1][1]

// dp[i][0] : the minimum number of swaps to make both sequences A[0, i] B[0, i] strictly                  increasing by no swapping A[i] and B[i]
// dp[i][1] : the minimum number of swaps to make both sequences A[0, i] B[0, i] strictly                  increasing by swapping A[i] and B[i]
