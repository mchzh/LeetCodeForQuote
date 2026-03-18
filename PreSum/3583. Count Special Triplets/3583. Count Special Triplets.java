class Solution {
    // twice scan: from left to right, and from right to left
    // one scan under current idx: we know the left cnt of cur and total cnt of cur right is total - left
    public int specialTriplets(int[] nums) {
        // freq before and next count within this idex
        int n = nums.length;
        long mod = (long)(1e9 + 7);

        long[] prev = new long[200001];
        long[] next = new long[200001];

        
        // from right to left
        for (int i = n-1; i >= 0; i--) {
            int cur = nums[i];
            next[cur]++; //total cnt of cur
        }

        long rets = 0;
        for (int i = 0; i < n; i++) {
            int cur = nums[i];
            // left: cur*2, right cur*2
            if (cur == 0) {
                rets += prev[0]*(next[0]-prev[0]-1);
            }else {
                rets += prev[cur*2]*(next[cur*2]-prev[cur*2]);
            }
            rets %= mod;
            prev[cur]++;
        }

        return (int)rets;
    }
}
// X X X X X X X X
//  ......i .....
// beforecur cnt on idx
// nextcur cnt on idx
// map or array
// idx -> []{num, cnt}
// num -> cnt
// two map with idx : before and next
