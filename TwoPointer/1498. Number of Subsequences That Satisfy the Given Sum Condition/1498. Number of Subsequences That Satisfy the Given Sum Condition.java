class Solution {
    // https://leetcode.com/problems/number-of-subsequences-that-satisfy-the-given-sum-condition/discuss/709227/JavaC%2B%2BPython-Two-Sum
    public int numSubseq(int[] nums, int target) {
        int mod = 1_000_000_007;
        Arrays.sort(nums);
        int left = 0, right = nums.length-1;
        int res = 0;
        int[] power = new int[nums.length];
        power[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            power[i] = (power[i-1]*2)%mod;
        }
        
        while (left <= right) {
            if (nums[left] + nums[right] > target) {
                right--;
            } else {
                // fixed left, from left+1 to right, we can pick or not pick element
                // 2^(right-left)
                res = (res + power[right-left]%mod) % mod;
                left++;
            }
        }
        return res;
    }
}

/*class Solution {
    private static final int MOD = 1000000007;
    public int numSubseq(int[] nums, int target) {
        long[] modPow = new long[nums.length + 1];
        modPow[0] = 1;
        for (int i = 1; i < modPow.length; i++) {
            modPow[i] = 2 * modPow[i-1] % MOD;
        }
        
        Arrays.sort(nums);
        int low = 0;
        int high = nums.length -1;
        long result = 0;
        while (low <= high) {
            if (nums[low] + nums[high] > target) {
                high--;
            } else {
                long curPower = modPow[high-low];
                result += curPower%MOD;
                low++;
            }
        }
        result = result%MOD;
        return (int) result;
    }
}*/
