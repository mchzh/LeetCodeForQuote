lass Solution {
    public int maxProduct(int[] nums) {
        // brute force is O(n2), consider to reduce O(N)
        if (nums == null || nums.length == 0) return 0;
        int max_so_far = nums[0], min_so_far = nums[0];
        int ret = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int maxpro = max_so_far*nums[i];
            int minpro = min_so_far*nums[i];
            //System.out.println(maxpro);
            //System.out.println(minpro);
            max_so_far = Math.max(nums[i], Math.max(maxpro, minpro));
            min_so_far = Math.min(nums[i], Math.min(maxpro, minpro));
            //System.out.println(max_so_far);
            //System.out.println(min_so_far);
            ret = Math.max(ret, max_so_far);
        }
        return ret;
    }
    
    public int maxProductEx(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }
        int max = A[0], min = A[0], result = A[0];
        for (int i = 1; i < A.length; i++) {
            int temp = max;
            max = Math.max(Math.max(max * A[i], min * A[i]), A[i]);
            min = Math.min(Math.min(temp * A[i], min * A[i]), A[i]);
            if (max > result) {
                result = max;
            }
        }
        return result;
    }
}

/*class Solution {
    public int maxProduct(int[] nums) {
        //Loop through the array, each time remember the max and min value for the previous product, the most important thing is to update the max and min value: we have to compare among max * A[i], min * A[i] as well as A[i], since this is product, a negative * negative could be positive.
        if (nums == null || nums.length == 0) return 0;
        int max = nums[0];
        int min = nums[0];
        int res = nums[0];
        int len = nums.length;
        int[] posi = new int[len];
        int[] nega = new int[len];
        posi[0] = nums[0] > 0 ? nums[0] : 0;
        nega[0] = nums[0] < 0 ? nums[0] : 0;
        for (int i = 1; i < nums.length; i++) {
            int temp = max;
            max = Math.max(nums[i], Math.max(max * nums[i], min * nums[i]));
            min = Math.min(nums[i], Math.min(temp * nums[i], min * nums[i]));
            if (posi[i-1] != 0) {
                int posr = posi[i-1] * nums[i];
                if (posr > 0) {
                    posi[i] = posr;
                } else {
                    nega[i] = posr;
                }
            } else if (nega[i-1] != 0) {
                int negr = nega[i-1] * nums[i];
                if (negr > 0) {
                    posi[i] = negr;
                } else {
                    nega[i] = negr;
                }
            } 
            //res = Math.max(res, Math.max(nums[i], posi[i]));
            res = Math.max(res, max);
        }
        return res;
    }
}*/
