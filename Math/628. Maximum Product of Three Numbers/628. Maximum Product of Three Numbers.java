class Solution {
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int m = nums.length;
        return Math.max(nums[m-3]*nums[m-2]*nums[m-1], nums[0]*nums[1]*nums[m-1]);
    }
}

// Sort
// 1. all positive
// | X X X X X
// n[m-3]*n[m-2]*n[m-1]
// 2. only one negative, not use this negative element
// X | X X X X
// n[m-3]*n[m-2]*n[m-1]
// 3. at least two negative element, at least two positive element
// X X .. | .. X X X X
// max(n[m-3]*n[m-2]*n[m-1], n[0]*n[1]*n[m-1])
// 4. only one positive
// X X X X X | X
// n[0]*n[1]*n[m-1]
// 5. all negative
// X X X X X X |
// n[m-3]*n[m-2]*n[m-1]

/*class Solution {
    public int maximumProduct(int[] nums) {
        if (nums == null || nums.length < 3) return 0;
        Arrays.sort(nums);
        int res = 0;
        int len = nums.length;
        if (nums[0] < 0 && nums[1] < 0) {
            return Math.max(nums[len-1]*nums[len-2]*nums[len-3], nums[len-1]*nums[0]*nums[1]);
        } else {
            return nums[len-1]*nums[len-2]*nums[len-3];
        }
    }
}*/
