class Solution {
    // slide window
    // two pointer
    public int numberOfSubarrays(int[] nums, int k) {
        List<Integer> list = new ArrayList<>();
        int n = nums.length;
        list.add(-1);
        for (int i = 0; i < n; i++) {
            if (nums[i]%2 == 1) list.add(i);
        }
        list.add(n);
        
        int rets = 0;
        if (list.size()-1<= k) return rets;

        for (int i = k+1; i < list.size(); i++) {
            rets += (list.get(i)-list.get(i-1))*(list.get(i-k)-list.get(i-k-1));
        }
        return rets;
    }
}

//  X X X X O X X X O X X X
//  ---------
//     disa
//                  --------
//                     disb
                    
// ret += disa * disb
