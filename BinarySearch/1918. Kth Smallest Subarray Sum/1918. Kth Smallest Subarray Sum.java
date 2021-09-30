class Solution {
    public int kthSmallestSubarraySum(int[] nums, int k) {
        int left = Integer.MAX_VALUE, right = 0;
        for (int n : nums) {
            right += n;
            left = Math.min(left, n);
        }
        
        while (left < right) {
            int mid = left + (right-left)/2;
            //System.out.println(mid + " " + getCount(nums, mid) + " " + subPossible(nums, mid) + " " + right);
            if (getCount(nums, mid) >= k) {
                right = mid;
            } else {
                //System.out.println(mid + " " + getCount(nums, mid) + " " + right);
                //if (getCount(nums, mid) == k) return mid;
                //System.out.println("return ok!");
                left = mid+1; // the number of less than target < k should plus one
            }
        }
        
        return left;
    }
    
    private int getCount(int[] arrs, int tar) {
        int n = arrs.length;
        int left = 0;
        int sum = 0;
        int count = 0;
    
        for (int i = 0; i < arrs.length; i++) {
            sum += arrs[i];
            while (sum > tar) {
                sum -= arrs[left];
                left++;
            }
            count += i-left+1;
        }

        return count;
    }
    private int subPossible(int[] nums, int sum) {
        int wS = 0;
        int res = 0;
        int curSum = 0;
        for (int wE = 0; wE < nums.length; wE++) {
            curSum += nums[wE];
            while (curSum > sum) {
                curSum -= nums[wS];
                wS++;
            }
            res += wE - wS + 1;
        }
        return res;
    }
}

// X X X X X X X 
//   [        ]

// [1,9,4,9,7]
// 4
// [2,9,2,10,7]
// 1
// [2,1,3]
// 4
// [3,3,5,5]
// 7
// [3,3,5,5,3,4,5,5,99,100,1000,999,10000,9999,239,3483,43,212,309,1000]
// 69
