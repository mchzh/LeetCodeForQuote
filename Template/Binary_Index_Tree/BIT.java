class Solution {
    int MAX_N = 100000;
    long[] bitArr = new long[MAX_N+1];
    long[] nums = new long[MAX_N+1];  // Note: nums is 1-index
    long M = (long)(1e9+7);

    // increase nums[i] by delta  (1-index)
    private void updateDelta(int i, long delta) {
        int idx = i;
        while (idx <= MAX_N)
        {
            bitArr[idx]+=delta;
            bitArr[idx] %= M;
            idx+=idx&(-idx);
        }
    }

    // sum of a range nums[1:j] inclusively, 1-index
    long queryPreSum(int idx){
        long result = 0;
        while (idx > 0){
            result += bitArr[idx];
            result %= M;
            idx-=idx&(-idx);
        }
        return result;
    }

    // sum of a range nums[i:j] inclusively
    long sumRange(int i, int j) {    
        return queryPreSum(j)-queryPreSum(i-1);
    }    
}
