class Solution {
    // https://leetcode.com/problems/minimum-moves-to-make-array-complementary/?envType=daily-question&envId=2026-05-13
    // diff array
    // [a,b] diff[a] += 1, diff[a+1]-=1
    // TreeMap
    public int countDays(int days, int[][] meetings) {
        Map<Integer, Integer> diff = new TreeMap<>();
        boolean hasLastStep = true;
        for (int[] m : meetings) {
            diff.put(m[0], diff.getOrDefault(m[0], 0)+1);
            if (m[1]+1 <= days ) diff.put(m[1]+1, diff.getOrDefault(m[1]+1, 0)-1);
            if (m[1] == days) hasLastStep = false;
        }
        // recovery diff
        int rets = 0;
        int prevday = 1;
        int prevcount = 0;
        for (int key : diff.keySet()) {
            if (prevcount == 0) {
                rets += key-prevday;
            }
            prevcount += diff.get(key);
            prevday = key;
        }
        // days
        if (hasLastStep) {
            rets += days-prevday+1;
        }
        return rets;
    }
}
//[1,3],[2,4]
// [1,0,0,-1,0]
// [0,1,0,0,-1]
// [1,1,0,-1,-1]
// diff[i] = diff[i-1] + val
// [1,2,2,1,0]
