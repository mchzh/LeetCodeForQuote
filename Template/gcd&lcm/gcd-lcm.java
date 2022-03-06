class Solution {
    // stack
    // https://leetcode.com/problems/fraction-addition-and-subtraction/discuss/103408/Java-Solution-Fraction-Addition-and-GCD
    // gcd or lcm
    public String fractionAddition(String expression) {
        
    }
    //gcd
    private int getGCD(int a, int b) {
        if (a == 0 || b == 0) return a+b;
        return getGCD(b, a%b);
    }
    private int getLCM(int a, int b) {
        int gcd = getGCD(a, b);
        return (a/gcd * b /gcd) * gcd;
    }
    private int gcd(int a, int b) {
        if (a == 0)
            return b;
        return gcd(b % a, a);
    }
}
