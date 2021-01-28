class Solution {
    int mod = (int)(1000000007);
    public int concatenatedBinary(int n) {
        long rets = 0;
        // for (int i =1; i <= n; i++) {
        //     int num = getonecount(i)+1; // get top one -> i&(i-1)
        //     rets = (rets*(long)Math.pow(2,num) + i) % mod;
        // }
        // return (int)rets;
        
        int shift = 0;
        for (int i =1; i <= n; i++) {
            if ( (i&(i-1)) == 0) shift++;
            rets = ((rets<<shift)|i) % mod;
        }
        return (int)rets;
        // recursion: cur = r(n-1) sub problem
        // then cur*Math.pow(2, n)+n
        
        // System.out.println(dfs(n));
        // System.out.println(mod);
        // System.out.println(dfs(n)%mod);
        //return (int) (dfs(n)%mod);
    }
    private long dfs(int n) {
        if (n == 1) return 1;
        long next = dfs(n-1);
        // conquer
        long expo = 0;
        long temp = n;
        while (temp != 0) {
            expo++;
            temp >>= 1;
        }
        return (next%mod*(long)Math.pow(2, expo)%mod+n)%mod;
    }
    private int getonecount(int n) {
        int rets = 0;
        for (int i = 0; i < 32; i++) {
            if ( ((n>>i)&1) == 1) rets = i;
        }
        return rets;
    }
}
