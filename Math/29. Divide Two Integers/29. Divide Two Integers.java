class Solution {
    public int divide(int dividend, int divisor) {
        int sign = 1;
        if ( (dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0) ) sign = -1;
        long end = (long)dividend;
        long sor = (long)divisor;
        
        end = Math.abs(end);
        sor = Math.abs(sor);
        
        long count = 0;
        while (sor <= end) {
            long sum = 0;
            long prev = sor;
            long temp = sor;
            while (temp <= end) {
                sum = sum == 0 ? 1 : sum * 2;
                prev = temp;
                temp += temp;
            }
            end -= prev;
            count += sum;
        }
        
        if (sign == 1 && count > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        } else if (sign == -1 && count <=  Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        } else return (int) (sign * count);
    }
}
