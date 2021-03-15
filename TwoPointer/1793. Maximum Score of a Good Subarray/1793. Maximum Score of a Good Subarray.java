class Solution {
    public int maximumScore(int[] nums, int k) {
        int n = nums.length;
        int l = k, r = k;
        int minVal = nums[k];
        int rets = 0;
        
//         while (l >= 0 && r < n) {
//             if (nums[l] >= minVal && nums[r] >= minVal) {
//                 rets = Math.max(rets, minVal*(r-l+1));
//                 l--;
//                 r++;
//             } else if (nums[l] >= minVal) {
//                 rets = Math.max(rets, minVal*(r-l));
//                 l--;
//             } else if (nums[r] >= minVal) {
//                 rets = Math.max(rets, minVal*(r-l));
//                 r++;
//             } else {
//                 if (nums[l] <= nums[r]) {
//                     minVal = nums[r];
//                 } else {
//                     minVal = nums[l];
//                 }
//             }
//         }
        
//         while (l >= 0) { 
//             if (nums[l] >= minVal) {
//                 rets = Math.max(rets, minVal*(n-l));
//                 l--;
//             } else {
//                 minVal = nums[l];
//             }
//         }
        
//         while (r < n) {
//             if (nums[r] >= minVal) {
//                 rets = Math.max(rets, minVal*(r+1));
//                 r++;
//             } else {    
//                 minVal = nums[r];
//             }
//         }
        while (l >= 0 || r < n) {
            while (l >= 0 && nums[l] >= minVal) l--;
            while (r < n && nums[r] >= minVal) r++;
            rets = Math.max(rets, minVal*(r-l-1));
            minVal = Math.max(l < 0 ? Integer.MIN_VALUE : nums[l], r >= n ? Integer.MIN_VALUE : nums[r]);
        }
        return rets;
    }
}

// score = minVal * subarray_width
// X X X X k Y Y Y Y
//       l   r
