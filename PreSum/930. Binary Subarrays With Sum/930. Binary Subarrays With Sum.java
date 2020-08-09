class Solution {
    public int numSubarraysWithSum(int[] A, int S) {
        // hash + presum
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        
        int preSum = 0, ret = 0;
        for (int i = 0; i < A.length; i++) {
            preSum += A[i];
            if (map.containsKey(preSum-S)) {
                ret += map.get(preSum-S);
            }
            map.put(preSum, map.getOrDefault(preSum, 0) + 1);
        }
        return ret;
    }
}

/*class Solution {
    public int numSubarraysWithSum(int[] A, int S) {
        int iLo = 0, iHi = 0;
        int sumLo = 0, sumHi = 0;
        int ans = 0;

        for (int j = 0; j < A.length; ++j) {
            // While sumLo is too big, iLo++
            sumLo += A[j];
            sumHi += A[j];
            while (sumLo > S)
                sumLo -= A[iLo++];
            // While sumHi is too big, or equal and we can move, iHi++
            while (iHi < j && (sumHi > S || sumHi == S && A[iHi] == 0))
                sumHi -= A[iHi++];

            if (sumLo == S)
                ans += iHi - iLo + 1;
        }

        return ans;
    }
}*/
