class Solution {
    // prefix xor
    // Keep the prefix xor of arr in another array, check the xor of all sub-arrays in O(n^2), if the xor of sub-array of length x is 0 add x-1 to the answer.
    public int countTriplets(int[] arr) {
        int n = arr.length;
        int[] preXor = new int[n+1];
        for (int i = 0; i < n ; i++) {
            preXor[i+1] = preXor[i]^arr[i];
        }
        
        // find all subarray
        int rets = 0;
        for (int i = 0; i < n-1; i++) {
            for (int j = i+1; j < n; j++) {
                if ( (preXor[j+1]^preXor[i]) ==0) {  // i, j, k : k is fixed j from i+1 to k is total (k-i) times;
                    rets += (j-i);
                }
            }
        }
        return rets;
    }
}

// i ..... k
//   j-----j j can move k-i times
// prefix xor
// [p0, p1, p2,p3, p4, p5,.... pn]
// x0 = p0
// x1 = p0^p1
// x2 = p0^p1^p2
// .
// .
// xi = p0^p1^...pi;
// .
// xj = p0^p1^...pi^...^pj

// x[i...j] = xj^xi = p0^p1^...pi^...^pj ^ p0^p1^...pi
//                  = p[i+1]^....pj
