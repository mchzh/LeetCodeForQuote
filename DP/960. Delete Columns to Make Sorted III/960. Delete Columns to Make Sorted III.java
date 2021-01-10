class Solution {
    // LIS + binary search X not nlogn(has a strict limitation)
    // use the common dp LIS
    public int minDeletionSize(String[] A) {
        int m = A.length, n = A[0].length();
        int[] dp = new int[n];
//         List<Integer> list = new ArrayList<>();
//         for (int j = 0; j < n; j++) {
//             int pos = binarySearch(list, A, j);
            
//             if (pos == list.size()) {
//                 list.add(j);
//             } else {
//                 list.set(pos, j);
//             }
//         }
        Arrays.fill(dp, 1);
        int rets = 0;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (isSmaller(j, i, A)) {
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
                rets = Math.max(rets, dp[i]);
            }
        }
        return n-rets;
    }
    private int binarySearch(List<Integer> list, String[] A, int j) {
        if (list == null || list.size() == 0) return 0;
        int left = 0, right = list.size()-1;
        while (left <= right) {
            int mid = left + (right-left)/2;
            if (isSmaller(list.get(mid), j, A)) {
                left = mid+1;
            } else {
                right = mid-1;
            }
        }
        return left;
    }
    private boolean isSmaller(int i, int j, String[] A) {
        for (int k = 0; k < A.length; k++) {
            if (A[k].charAt(i) > A[k].charAt(j)) return false;
        }
        return true;
    }
}
