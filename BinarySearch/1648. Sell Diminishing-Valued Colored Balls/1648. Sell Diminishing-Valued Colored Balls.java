class Solution {
    public int maxProfit(int[] inventory, int orders) {
        long mod = (long)(1e9+7);
        long left = 1, right = Integer.MAX_VALUE;
        while (left < right) {
            long mid = left + (right-left)/2;
            long num = getOrder(inventory, mid);
            if (num <= orders) {
                right = mid;
            } else {
                left = mid+1;
            }
        } // from left to max has full round
        
        long curorder = getOrder(inventory, left);
        long rets = 0;
        for (int v : inventory) {
            if (v < left) continue;
            rets += (left+v)*(v-left+1)/2%mod;
            rets %= mod;
        } // full
        
        rets += (orders-curorder)*(left-1)%mod; // rest remainder
        rets %= mod;
        return (int)rets;
    }
    private long getOrder(int[] inventory, long p) {
        long count = 0;
        for (int v : inventory) {
            if (v < p) continue;
            count += v-p+1;
        }
        return count;
    }
}
