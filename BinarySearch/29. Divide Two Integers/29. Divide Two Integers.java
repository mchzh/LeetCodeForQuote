class Solution {
    // binary search
    // 2*divisor <= dividend continue to 2*
    public int divide(int dividend, int divisor) {
        int sign = 1;
        if ((dividend < 0 && divisor > 0 )|| (dividend >0 && divisor < 0 )) sign = -1;

        long a = Math.abs((long)dividend);
        long b = Math.abs((long)divisor);
        long rets = 0;
        //System.out.println(a + " : " + b);
        while (a >= b) {
            long c = b;

            long count = 1;
            while ((c<<1) <= a) {
                //System.out.println(c + " : " + a + " : " + b);
                c = (c<<1);
                count += count;
            }
            //System.out.println(c + " : " + count);
            rets += count;
            a = a-c;
        }
        if (sign == 1) {
            if (rets > Integer.MAX_VALUE) return Integer.MAX_VALUE;
            else return (int)rets;
        } else {
            // -1
            return (int)(sign*rets);
        }
    }
}
