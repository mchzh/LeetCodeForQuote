class Solution {
    // dp is too slow, has greedy solution
    // start end
    public int jump(int[] nums) {
        int n = nums.length;
        int start = 0, end = 0; // index
        if (n == 1) return 0;

        int step = 0;
        while (start <= end) {
            step++;
            int end_new = end;
            for (int i = start; i <= end; i++) {
                end_new = Math.max(end_new, Math.min(n-1, i+nums[i]));
                if (end_new >= n-1) return step;
            }
            
            start = end+1;
            end = end_new;
        }
        return -1;
    }
}
// [x] [x,x] [0,0],[*,*,*,*,*]
