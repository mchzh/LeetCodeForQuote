class Solution {
    // not modify the array
    // binary search sum?
    // cycle dection and consider the linked list cycle II
    public int findDuplicate(int[] nums) {
        int N = nums.length-1;
        int left = 1, right = N;
        
        // o(nlogn)
        while (left < right) {
            int mid = left + (right -left) / 2;
            int count1 = 0, count2 = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] < mid) {
                    count1++;
                } else if (nums[i] == mid) count2++;
            }
            if (count2 > 1) return mid; // this step ensure whether the cur mid is duplicate
            if (count1 <= mid-1) {
                left = mid+1;
            } else {
                right = mid-1;
            }
        }
        return left;
    }
}

// 1 3 4 2 2
    
//     index binary search or value binary search
    
//     1,....mid, mid+1, ... N
