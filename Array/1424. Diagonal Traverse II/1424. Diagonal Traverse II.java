class Solution {
    // https://leetcode.com/problems/diagonal-traverse-ii/discuss/597698/JavaC%2B%2B-HashMap-with-Picture-Clean-code-O(N)
    // i, j -> i-1, j+1
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        int n = 0, maxKey = 0;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int r = nums.size()-1; r >= 0; r--) {
            for (int c = 0; c < nums.get(r).size(); c++) {
                map.computeIfAbsent(r+c, k -> new ArrayList<>()).add(nums.get(r).get(c));
                maxKey = Math.max(maxKey, r+c);
                n++;
            }
        }
        int[] ans = new int[n];
        int idx = 0;
        for (int key = 0; key <= maxKey; key++) {
            List<Integer> temp = map.get(key);
            for (int t : temp) {
                ans[idx++] = t;
            }
        }
        return ans;
    }
    
    public int[] findDiagonalOrderBruteForce(List<List<Integer>> nums) {
        List<Integer> res = new ArrayList<>();
        if (nums == null || nums.size() == 0) return new int[0];
        int row = nums.size();
        int maxcol = 0;
        // first column
        for (int i = 0; i < row; i++) {
            // fix i and j
            int down = i, up = 0;
            while(down >= 0) {
                List<Integer> curL = nums.get(down);
                if (curL == null || curL.size() == 0) continue;
                maxcol = Math.max(maxcol, curL.size());
                if (up < curL.size()) res.add(curL.get(up));
                down--;
                up++;
            }
        }
        // last row
        List<Integer> lastRow = nums.get(row-1);
        for (int i = 1; i < maxcol; i++) {
            // fix i and j
            int down = row-1, up = i;
            while(down >= 0) {
                List<Integer> curL = nums.get(down);
                if (curL == null || curL.size() == 0) continue;
                if (up < curL.size()) res.add(curL.get(up));
                down--;
                up++;
            }
        }
        return res.stream().mapToInt(Integer::intValue).toArray();
    }
}
