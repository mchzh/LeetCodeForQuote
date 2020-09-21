class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int ret = 0;
        int i = 0;
        long sum = 1;
        for (int j = 0; j < nums.length; j++) {
            sum *= nums[j];
            int curleft = i;
            if (sum < k) ret += j-i+1;
            while (i < j && sum >= k) {
                sum /= nums[i++];
            }
            if (i > curleft && sum < k) ret += j-i+1;
        }
        return ret;
    }
}

/*class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1) return 0;
        // contiguous
        // two pointer
        // positive integer no zero
        int len = nums.length, left = 0, right = 0;
        int res = 0;
        long product = 1;
        //boolean first = true;
        while (right < len) {
            product *= nums[right];
            
            
            while (product >= k) {
                //if (first) res += (right-left+1)*(right-left)/2;
                //System.out.println("left idex -> " + left + " : right idex -> " + right);
                
                product /= nums[left];
                left++;
            }
            //if (product < k) res++;
            res += right-left+1;
            right++;
        }
        //System.out.println("last left idex -> " + left + " : last right idex -> " + right);
        //if (product < k) res += (right-left+1)*(right-left)/2;
        return res;
    }
}*/
