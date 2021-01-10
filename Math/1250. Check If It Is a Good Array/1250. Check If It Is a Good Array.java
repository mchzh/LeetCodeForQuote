class Solution {
    //check prime each other
    public boolean isGoodArray(int[] nums) {
        int k = nums[0];
        for (int i = 1; i < nums.length; i++) {
            k = gcd(k, nums[i]);
            if (k == 1) return true;
        }
        return k == 1;
    }
    private int gcd(int a, int b) {
        if (b == 0) return a;
        else {
            return gcd(b, a%b);
        }
    }
}

// k1*a1+k1*a2+k3*a3 = 1;
// k1*m1*b+k2*m2*b+k3*m3*b = n*b
// => b != 1
