class Solution {
    int M = 1000000007;
    public int kConcatenationMaxSum(int[] arr, int k) {
        // k == 1: kadane algorightm
        if (k == 1) return kadaneSol(arr);
        
        long sum = 0;
        for (int i : arr) {
            sum += i;
            sum %= M;
        }
        // sum < 0 or > 0
        long ret = 0;
        if (sum > 0) {
            ret += ((k-2)*sum)%M;
        }
        
        int[] cur = new int[2*arr.length];
        for (int i = 0; i < arr.length; i++) {
            cur[i] = arr[i];
            cur[i+arr.length] = arr[i];
        }
        
        return (int)((kadaneSol(cur)+ret)%M);
    }
    
    private int kadaneSol(int[] arr) {
        int max_total = 0;
        int max_ending_here = 0;
        
        for (int a : arr) {
            max_ending_here += a;
            if (max_ending_here < 0) {
                max_ending_here = 0;
            }
            max_total = Math.max(max_total, max_ending_here);
        }
        return max_total;
    }
}

// TTTTTTTTTTT
// ATTTTTTTTTB: A: last part of T, B: firt part of T
// T < 0: AB
// else: ATTTTTTTTB
// Verification: {XXX}[XXXXXXX]{X}.{XXX}[XXXXXXX]{X}
