class Solution {
    public int maxProfit(int[] inventory, int orders) {
        Arrays.sort(inventory);
        int n = inventory.length;
        int[] nums = new int[n+1];
        for (int i = 0; i < n ; i++) {
            nums[i] = inventory[n-i-1];
        } // reverse
        
        long mod = (long)(1e9+7);
        long rets = 0;
        for (int i = 0; i < n ; i++) {
            long a = nums[i];
            long b = nums[i+1];
            
            long total = (a-b)*(i+1);
            if (total <= orders) {
                rets += (a+b+1)*(a-b)/2*(i+1)%mod;
                rets %= mod;
                orders -= total;
            } else {
                long k = orders/(i+1);
                rets += (a+a-k+1)*k/2*(i+1)%mod;
                rets %= mod;
                
                long r = orders%(i+1);
                rets += (a-k)*r%mod;
                rets %= mod;
                break;
            }
        }
        return (int)rets;
    }
}

// 10 8 6 4 2 | 0

// 9 8 6 4 2   +10 *1
// 8 8 6 4 2   +9  *1

// 7 7 6 4 2.  +8 *2
// 6 6 6 4 2.  +7 *2
    
// 5 5 5 4 2   +6 *3
// 4 4 4 4 2.  +5 *3

// 3 3 3 3 2.  +4 *4
// 2 2 2 2 2   +3 *4

// 1 1 1 1 1 0  +2 *5
// 0 0 0 0 0 0  +1 *5
