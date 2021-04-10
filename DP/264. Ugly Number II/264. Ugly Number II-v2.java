class Solution {
    // three pointer: represent * which num
    public int nthUglyNumber(int n) {
        int[] nums = new int[n];
        nums[0] = 1;
        int a = 0, b = 0, c = 0;
        for (int i = 1; i < n; i++) {
            nums[i] = Math.min(nums[a]*2, Math.min(nums[b]*3, nums[c]*5));
            if (nums[a]*2 == nums[i]) a++;
            if (nums[b]*3 == nums[i]) b++;
            if (nums[c]*5 == nums[i]) c++;
        }
        return nums[n-1];
    }
}

// {...C...B..A} x -> y // every time to add the next min

// q[a] = A*2       q[a]*2
// q[b] = B*3(min)  q[b+1]*3
// q[c] = C*5       q[c]*5
