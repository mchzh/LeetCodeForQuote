class Solution {
    public int superpalindromesInRange(String left, String right) {
        long a = Long.valueOf(left);
        long b = Long.valueOf(right);
        
        int count = 0;
        for (int i = 1; i <= (int)1e5; i++) {
            for (int type = 0; type <=1; type++) {
                long palin = constructPalin(i, type);
                if (palin > (long)1e9) continue;
                
                long superpalin = palin * palin;
                if (superpalin >= a && superpalin <= b && isPalindrome(superpalin)) count++;
            }
        }
        return count;
    }
    private boolean isPalindrome(long superpalin) {
        String str = String.valueOf(superpalin);
        int left = 0, right = str.length()-1;
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }
    private long constructPalin(int x, int type) {
        // type: 0-> even palin; 1-> odd palin
        long y = x;
        if (type == 1) x /=10;
        while (x != 0) {
            y = y*10 + x%10;
            x /= 10;
        }
        return y;
    }
}
// y = x1x2x3x4
// x = x1x2x3x4
// 1e5  -> 1e9. -> 1e18
