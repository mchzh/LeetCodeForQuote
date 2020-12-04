class Solution {
    // https://leetcode.com/problems/smallest-range-covering-elements-from-k-lists/discuss/104893/Java-Code-using-PriorityQueue.-similar-to-merge-k-array
    public int[] smallestRange(List<List<Integer>> nums) {
        // store the number and pointer pos info
        int n = nums.size();
        int[] pointer = new int[n];
        TreeSet<int[]> set = new TreeSet<>((a,b) -> (a[0] == b[0] ? a[1] - b[1] : a[0]-b[0]));
        
        for (int i = 0; i < n; i++) {
            List<Integer> cur = nums.get(i);
            set.add(new int[] {cur.get(0), i});
        }
        
        int range = Integer.MAX_VALUE;
        int[] rets = new int[2];
        while (true) {
            // compare the current range;
            if (set.last()[0] - set.first()[0] < range) {
                range = set.last()[0] - set.first()[0];
                rets[0] = set.first()[0];
                rets[1] = set.last()[0];
            }
            
            // remove the smallest
            int[] smallest = set.pollFirst();
            pointer[smallest[1]]++;
            if ( pointer[smallest[1]] >= nums.get(smallest[1]).size() ) break;
            set.add(new int[] {nums.get(smallest[1]).get(pointer[smallest[1]]), smallest[1]});
        }
        return rets;
    }
}
// TreeSet for first smallest and last highest
// [4,10,15,24,26]
// [0,9,12,20]
// [5,18,22,30]

// [a, b]
// [0,4,5]
// 1. this range cover all nums
// 2. a is the smallest number of current array (exclude the previous smallest num)
