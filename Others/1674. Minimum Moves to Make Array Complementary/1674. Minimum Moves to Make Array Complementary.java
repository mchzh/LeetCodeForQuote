class Solution {
    // 差分数组
    public int minMoves(int[] nums, int limit) {
        int[] diff = new int[2*100000+2];
        
        // generate the diff array from every pair
        int n = nums.length;
        for (int i = 0; i < n/2; i++) {
            int a = Math.min(nums[i], nums[n-1-i]);
            int b = Math.max(nums[i], nums[n-1-i]);
            
            diff[2] += 2;
            diff[a+1] += -1;
            diff[a+b] += -1;
            diff[a+b+1] += 1;
            diff[b+limit+1] += 1;
        }
        
        // for every pair sum to get the change move times
        int rets = Integer.MAX_VALUE;
        int y = 0;
        for (int x = 2; x <= 2*limit; x++) {
            y += diff[x];
            rets = Math.min(rets, y);
        }
        return rets;
    }
}

// consider jump/interactive point
// pair sum : x [2, 2*limit]
//  nums[i] + nums[n-1-i] = x
//   a   <  b  <=> x
//  range:
// increasing direction: (a+b < x)
// 0 move : a+b = x (one point)
// 1 move : [a+b+1, b+limit] (move a -> add more [a+1, limit])
// 2 move : [b+limit+1, 2*limit] (move a&b)

// decreasing direction:  (a+b > x)
// 1 move : [a+1, a+b-1] (move b -> reduce more [1, b-1])
// 2 move : [2, a] (move a&b min-> both is 1, max: a as a-1, b is 1)

// diff array:
// for one pair -> multiple pair use add operation (five interactive points)
// diff[2] = 2;
// diff[a+1] = -1;
// diff[a+b] = -1;
// diff[a+b+1] = 1;
// diff[b+limit+1] = 1;
