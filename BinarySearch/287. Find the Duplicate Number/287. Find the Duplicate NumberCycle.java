class Solution {
    // not modify the array
    // binary search sum?
    // cycle dection and consider the linked list cycle II
    public int findDuplicate(int[] nums) {
        // validate cycle
        int t = nums[0];
        int h = nums[0];
        do {
            t = nums[t];
            h = nums[nums[h]]; // two step
        } while (t != h);
        
        // find entrance of loop
        t = nums[0];
        while (t != h) {
            t = nums[t];
            h = nums[h];
        }
        return t;
    }
}
