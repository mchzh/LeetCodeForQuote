class Solution {
    public int longestSubarray(int[] nums) {
        int n = nums.length;
        int[] leftone = new int[n];
        int[] rightone = new int[n];
        // from left to right
        int curonelen = 0;
        for (int i = 0; i < n; i++) {
            leftone[i] = curonelen;
            if (nums[i] == 0) {
                // set onelen
                
                curonelen = 0;
            } else {
                curonelen++;
            }
        }
        curonelen = 0;
        for (int i = n-1; i >= 0; i--) {
            rightone[i] = curonelen;
            if (nums[i] == 0) {
                // set onelen
                
                curonelen = 0;
            } else {
                curonelen++;
            }
        }
        
        int rets = 0;
        for (int i = 0; i < n; i++) {
            int onelen = leftone[i]+rightone[i];
            rets = Math.max(rets, onelen);
        }
        return rets;
    }
}

// class Solution {
//     public int longestSubarray(int[] nums) {
//         int res = 0, n = nums.length, cnt = 0;
//         for(int i = 0, j = 0; i < n; ++i) {
//             if(nums[i] == 0) ++cnt;
//             while(cnt > 1) {
//                 if(nums[j] == 0) --cnt;
//                 ++j;
//             }
//             res = Math.max(res, i - j);
//         }
    
//         return res;
//     }
// }
