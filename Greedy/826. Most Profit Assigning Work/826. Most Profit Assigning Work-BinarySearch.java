class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        // binary search : O(mlogn)
        // consider to reduce to O(n)
        int n = difficulty.length;
        int[][] jobs = new int[n][3];
        for (int i = 0; i < n; i++) {
            jobs[i][0] = difficulty[i];
            jobs[i][1] = profit[i];
        }
        Arrays.sort( jobs, (a, b) -> (a[0]==b[0] ? b[1]-a[1] : a[0]-b[0]) );
        int curmax = 0;
        for (int i = 0; i < n; i++) {
            curmax = Math.max(curmax, jobs[i][1]);
            jobs[i][2] = curmax;
        }
        int rets = 0;
        for (int w : worker) {
            int idx = getPos(jobs, w);
            rets += idx == -1 ? 0 : jobs[idx][2];
        }
        return rets;
    }
    private int getPos(int[][] jobs, int tar) {
        int left = 0, right = jobs.length-1;
        while (left < right) {
            int mid = right - (right-left)/2;
            if (jobs[mid][0] <= tar) {
                left = mid;
            } else {
                right = mid-1;
            }
        }
        if (tar < jobs[0][0]) return -1;
        else return left;
    }
}
