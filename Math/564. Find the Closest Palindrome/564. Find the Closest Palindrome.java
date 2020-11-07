class Solution {
    //https://leetcode.com/problems/find-the-closest-palindrome/discuss/122957/Java-compare-five-candidates-get-result-easy-to-understand
    public String nearestPalindromic(String n) {
        // long num = Long.parseLong(n);
        // for (long i = 1;; i++) {
        //     if (isPalindrome(num - i))
        //         return "" + (num - i);
        //     if (isPalindrome(num + i))
        //         return "" + (num + i);
        // }
        int len = n.length();
        int midIdx = len%2 == 0 ? len/2-1 : len/2;
        long left = Long.valueOf(n.substring(0, midIdx+1));
        
        // 12345
        List<Long> candidates = new ArrayList<>();
        candidates.add(getPal(left, len%2 == 0));
        candidates.add(getPal(left+1, len%2 == 0));
        candidates.add(getPal(left-1, len%2 == 0));
        candidates.add((long)Math.pow(10, len-1)-1);
        candidates.add((long)Math.pow(10, len-1)+1);
        candidates.add((long)Math.pow(10, len)+1);
        
        long diff = Long.MAX_VALUE;
        long tar = Long.valueOf(n);
        long rets = 0;
        for (long c : candidates) {
            if (c == tar) continue;
            long curDif = (long)Math.abs(c-tar);
            if (curDif < diff) {
                diff = curDif;
                rets = c;
            } else if ( curDif == diff ) {
                rets = Math.min(rets, c);
            }
        }
        return String.valueOf(rets);
    }
    private long getPal(long left, boolean even) {
        long res = left;
        if (!even) left /= 10;
        while (left != 0) {
            res = res * 10 + left%10;
            left /= 10;
        }
        return res;
    }
    boolean isPalindrome(long x) {
        long t = x, rev = 0;
        while (t > 0) {
            rev = 10 * rev + t % 10;
            t /= 10;
        }
        return rev == x;
    }
}

// 12345 five:
// keep left with same right: 12321 +0
// middle +1 : 12421
// middle -1 : 12221
// (9...9) : 9999
// (1.....1) : 100001

/*class Solution {
    public String nearestPalindromic(String n) {
        long num = Long.parseLong(n);
        long temp = num;
        long large = getPalindrome(num);
        long small = large;
        long unit = 1;
        
        for (int i = 0; i < n.length() / 2 - 1; i++) unit *= 10;
        
        while (large <= num) {
            large = getPalindrome(temp += unit);
        }
        
        temp = num;
        
        while (small >= num) {
            small = getPalindrome(temp -= unit);
        }
        
        return num - small <= large - num? String.valueOf(small): String.valueOf(large);
    }
    
    private long getPalindrome(long num) {
        char[] numArr = String.valueOf(num).toCharArray();
        int head = 0;
        int tail = numArr.length - 1;
        
        while (head < tail) {
            numArr[tail--] = numArr[head++];
        }
        
        return Long.parseLong(String.valueOf(numArr));
    }
}*/
