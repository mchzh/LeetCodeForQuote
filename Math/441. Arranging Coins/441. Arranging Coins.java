class Solution {
    // binary search
    public int arrangeCoins(int n) {
        if (n== 0) return 0;
        
        long s = n;
        long m = 2*s;
        for (long k = (long)(Math.sqrt(m)-2); k < (long)Math.sqrt(m)+5; k++) {
            //System.out.println(k);
            if ( (k+1)*k <=m && (k+1)*(k+2) >m ) return (int)k;
        }
        return -1;
    }
}

/*class Solution {
    public int arrangeCoins(int n) {
        if (n <= 0) return 0;
        // 1+2+3+4+..... +k = k(k+1)/2;
        // binary search
        long left = 1, right = n;
        long target = (long)2*n;
        while (left < right) {
            long mid = left + (right-left)/2;
            if (mid *(mid+1) <= target) {
                left = mid+1;
            }else {
                right = mid;
            }
        }
        return left*(left+1) > target ? (int)left-1 : (int)left;
    }
}*/
