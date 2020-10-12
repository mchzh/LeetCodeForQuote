class Solution {
    public int getMaxLen(int[] nums) {
        int ret = 0, left = 0, countNegative = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                // from left to i
                ret = Math.max(ret, getMaxProdLen(nums, left, i-1, countNegative));
                countNegative = 0;
                left = i+1;
                continue;
            } else if (nums[i] < 0) {
                countNegative++;
            }
        }
        ret = Math.max(ret, getMaxProdLen(nums, left, nums.length-1, countNegative));
        return ret;
    }
    private int getMaxProdLen(int[] nums, int left, int right, int countNegative) {
        int ret = 0;
        if (countNegative % 2 == 0) {
            return right-left+1;
        } else {
            int j = left;
            while (j <= right && nums[j] > 0) {
                j++;
            }
            ret = Math.max(ret, right-j);
    
            j = right;
            while (j >= left && nums[j] > 0) {
                j--;
            }
            ret = Math.max(ret, j-left);
        }
        return ret;
    }
    private int getMaxProdVal(int[] nums, int left, int right, int prod, int countNegative) {
        int ret = 1;
        if (countNegative % 2 == 0) {
            return right-left+1;
        } else {
            // prefix and suffix
            //int prefixProd = prod;
            int j = left;
            while (j <= right && nums[j] > 0) {
                j++;
                //prefixProd /= nums[j];
            }
            //prefixProd /= nums[j];
            //ret = Math.max(ret, prefixProd);
            ret = Math.max(ret, right-j);
            // suffix prod
            //int suffixProd = prod;
            j = right;
            while (j >= left && nums[j] > 0) {
                j--;
                //suffixProd /= nums[j];
            }
            //suffixProd /= nums[j];
            //ret = Math.max(ret, suffixProd);
            ret = Math.max(ret, j-left);
        }
        return ret;
    }
}
