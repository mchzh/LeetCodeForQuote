class Solution {
    // slide window: [a, b]
    public int[] countServers(int n, int[][] logs, int x, int[] queries) {
        Arrays.sort(logs, (a,b) -> (a[1] - b[1]));

        int m = queries.length;
        int[][] offlinequery = new int[m][2];
        for (int i = 0; i < m ; i++) {
            offlinequery[i][0] = queries[i];
            offlinequery[i][1] = i;
        }
        Arrays.sort(offlinequery, (a,b) -> (a[0] - b[0]));

        int[] rets = new int[m];
        Map<Integer, Integer> ser2count = new HashMap<>(); // server id count
        // two point 
        int i = 0, j = 0;
        int loglen = logs.length;
        for (int[] q : offlinequery) {
            int s = q[0]-x, e = q[0];
            while (j < loglen && logs[j][1] <= e) {
                int id = logs[j][0];
                ser2count.put(id, ser2count.getOrDefault(id, 0) + 1);
                j++;
            }
            while (i < loglen && logs[i][1] < s) {
                int id = logs[i][0];
                ser2count.put(id, ser2count.getOrDefault(id, 0) - 1);
                if (ser2count.get(id) == 0) {
                    ser2count.remove(id);
                }
                i++;
            }
            rets[q[1]] = n-ser2count.size();
        }
        return rets;
    }
}

// binary search with sorted logs
// use a to get the first idx to insert and use b to get the last idx to insert
// lidx-fidx is covere all elements num, n-num is non-cover
// sort + two pointer
// when update s, and e
// has left and right pointer:
// while left < s to remove the current log from map then left++
// while right < e to add the cuurent log into map the right++;
