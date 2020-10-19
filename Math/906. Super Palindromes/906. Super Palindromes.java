class Solution {
    public int superpalindromesInRange(String L, String R) {
        long start = Long.parseLong(L);
        long end = Long.parseLong(R);
        
        int count = 0;
        for (long i = 1; i <= (long)1e5; i++) {
            for (int type = 1; type <= 2; type++) {
                long palin = getPalin(i, type); // generate two type palindromes
                long squarePalin = palin*palin;
                if ( squarePalin >= start && squarePalin <= end && isPalindrome(squarePalin) ) {
                    count++;
                }
            }
            
        }
        return count;
    }
    private long getPalin(long x, int type) {
        long ret = x;
        if (type == 1) x /= 10;
        while (x != 0) {
            ret = ret*10 + x%10;
            x /= 10;
        }
        return ret;
    }
    private boolean isPalindrome(long input) {
        String str = String.valueOf(input);
        int left = 0, right = str.length()-1;
        while (left < right) {
            if ( str.charAt(left) != str.charAt(right) ) return false;
            left++;
            right--;
        }
        return true;
    }
}

// 1e5 -> 1e9 -> 1e18
    
// x1x2x3x4x5 x4x3x2x1
