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


/*class Solution {
    private int getMaxLen(int[] nums, int l, int r) {
        if (l > r) {
            return 0;
        }
        int count = 0;
        int firstNeg = -1;
        int lastNeg = -1;
        for (int i = l; i <= r; i++) {
            if (nums[i] < 0) {
                count++;
                if (firstNeg == -1) {
                    firstNeg = i;
                }
                lastNeg = i;
            }
        }
        if (count % 2 == 0) {
            return r - l + 1;
        } else {
            return Math.max(lastNeg - l, r - firstNeg);
        }
    }
    
    public int getMaxLen(int[] nums) {
        int n = nums.length;
        int l = 0;
        int best = 0;
        for (int r = 0; r < n; r++) {
            if (nums[r] == 0) {
                best = Math.max(best, getMaxLen(nums, l, r-1));
                l = r+1;
            }
        }
        if (nums[n-1] != 0) {
            best = Math.max(best, getMaxLen(nums, l, n-1));
        }
        return best;
    }
}*/
// XXX i
// yyyJ
// XXXXX 0 YYYYY
// (XX(XX)XX)
