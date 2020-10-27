class Solution {
    // https://leetcode.com/problems/set-intersection-size-at-least-two/discuss/113086/Hope-you-enjoy-this-problem.-%3A-)-O(NlogN)JavaGreedy-Easy-to-understand-solution
    // https://www.cnblogs.com/grandyang/p/8503476.html
    public int intersectionSizeTwo(int[][] intervals) {
        // Greedy
        // sort by smaller range
        Arrays.sort( intervals, (a, b) -> (a[1] == b[1] ? b[0]-a[0] : a[1] - b[1]) ); //O(nlgn)
        
        int rets = 0;
        int left = -1, right = -1;
        //1. cover; 2. intersection with one element; 3. no any intersection
        for (int[] interval : intervals) {
            if (interval[0] <= left) continue; // intersection
            // one element
            if (left < interval[0] && interval[0] <= right) {
                rets += 1;
                left = right;
                right = interval[1];
            } else if (interval[0] > right) {
                rets += 2;
                left = interval[1]-1;
                right = interval[1];
            }
        }
        return rets;
    }
}
