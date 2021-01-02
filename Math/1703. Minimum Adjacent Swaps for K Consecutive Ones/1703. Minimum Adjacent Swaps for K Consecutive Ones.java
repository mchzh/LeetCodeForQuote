class Solution {
    public int minMoves(int[] nums, int k) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0;i < nums.length; i++) {
            if (nums[i] == 1) list.add(i);
        }
        int[] p = list.stream().mapToInt(Integer::intValue).toArray();
        
        // first slide window
        int sum = 0;
        for (int i = 0; i < k ; i++) {
            sum += Math.abs(p[i] - p[k/2]);
        }
        
        int rets = sum;
        
        for (int i = 0; i+k < p.length; i++) {
            int mid = i+k/2;
            sum -= Math.abs(p[mid]-p[i]);
            sum += Math.abs(p[mid+1]-p[i+k]);
            sum += k/2 * (p[mid+1]-p[mid]);
            sum -= (k-1-k/2) * (p[mid+1]-p[mid]);
            rets = Math.min(rets, sum);
        }
        
        //System.out.println(rets);
        int offset = 0;
        for (int i = 0; i < k; i++) {
            offset += Math.abs(i-k/2);
        }
        
        return rets - offset;
    }
}

// min sum |pi - x| 
// => x is the medium position

// 0 1 2 ...  k-1 k
// X X X O  X X X    => sum1
//   X X X--O X X X  => sum2
  
// 1. -= abs(p[left]-p[mid]);
// 2. += abs(p[right+1] - p[mid+1]);
// 3. += k/2 * (p[mid+1]-p[mid]);
// 4. -= (k-1-k/2) * (p[mid+1]-p[mid])
    
//     offset: (k/2+....+2+1+0+1+2....+k/2)
