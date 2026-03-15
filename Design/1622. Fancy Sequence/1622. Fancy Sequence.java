class Fancy {
    long mul;
    long add;
    long mod = (long)(1e9+7);
    List<Long> list;

    public Fancy() {
        mul = 1;
        add = 0;
        list = new ArrayList<>();
    }
    
    public void append(int val) {
        //System.out.println(val + " : " + add + " : " + mul);
        long pend = (long)val;
        pend = (pend-add+mod)%mod;
        // get the inverse element of mul and convert '/' as '*'
        pend = (pend * inv((int)mul))%mod;
        list.add(pend); // /has decimal with prescison issue and use inverse element alogrithm
        //System.out.println(list);
    }
    
    public void addAll(int inc) {
        add += inc;
        add %= mod;
    }
    
    public void multAll(int m) {
        mul *= m;
        add *= m;
        mul %= mod;
        add %= mod;
    }
    
    public int getIndex(int idx) {
        if (idx >= list.size()) return -1;
        long cur = list.get(idx);
        //System.out.println(idx + " : " + cur + " : " + mul + " : " + add);
        return (int)(((cur*mul)%mod + add)%mod);
    }

    private long quickPow(int x, int y) 
    {
        long ret = 1;
        long cur = (long)x;
        while (y != 0) 
        {
            if ((y & 1) == 1) 
            {
                ret = ret * cur % mod;
            }
            cur = cur * cur % mod;
            y >>= 1;
        }
        return ret;
    }
    
    private long inv(int x) 
    {
        return quickPow(x, (int)(mod - 2));
    }
}

/**
 * Your Fancy object will be instantiated and called as such:
 * Fancy obj = new Fancy();
 * obj.append(val);
 * obj.addAll(inc);
 * obj.multAll(m);
 * int param_4 = obj.getIndex(idx);
 */

 // val + a1 + a2 + .... an *m1 * m2....*mn
 // XXX X X X
 // 0 1 2            i ... j
 //  * +     * + + 
 // get id 0: nums[0]*mul + add
 // get id 3: nums[3]*mul` + add`
 // val = (nums[3]-add)/mul
