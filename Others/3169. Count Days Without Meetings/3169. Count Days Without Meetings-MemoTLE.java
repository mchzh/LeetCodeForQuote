class Solution {
    // https://leetcode.com/problems/minimum-moves-to-make-array-complementary/?envType=daily-question&envId=2026-05-13
    // diff array
    // [a,b] diff[a] += 1, diff[a+1]-=1
    // TreeMap
    public int countDays(int days, int[][] meetings) {
        int[] diff = new int[days+1]; // spce memory too large -> change as map
        for (int[] m : meetings) {
            diff[m[0]] += 1;
            if (m[1]+1 <= days) {
                diff[m[1]+1] -= 1;
            }
        }
        // recovery diff
        int rets = 0;
        for (int i = 1; i < days+1; i++) {
            diff[i] += diff[i-1];
            if (diff[i] == 0) rets++;
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
