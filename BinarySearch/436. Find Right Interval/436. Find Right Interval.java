class Solution {
    public int[] findRightInterval(int[][] intervals) {
        int[] res = new int[intervals.length];
        HashMap<int[], Integer> hash = new HashMap<>();
        for (int i = 0; i < intervals.length; i++) {
            hash.put(intervals[i], i);
        }
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        for (int i = 0; i < intervals.length; i++) {
            int[] interval = binary_search(intervals, intervals[i][1], 0, intervals.length - 1);
            res[hash.get(intervals[i])] = interval == null ? -1 : hash.get(interval);
        }
        return res;
        // mononthic increasing stack
        // hashmap + binar search
        // int[] rightInterval = new int[intervals.length];
        // Arrays.fill(rightInterval, -1);
        // Map<int[], Integer> map = new HashMap<>();
        // for (int i = 0; i < intervals.length; i++) {
        //     map.put(intervals[i], i);
        // }
        // Arrays.sort(intervals, (a, b) -> (a[0] - b[0]));
        // // minimun index with minimun start point
        // for (int i = 0; i < intervals.length; i++) {
        //     int minidx = -1;
        //     int min = Integer.MAX_VALUE;
        //     for (int j = i+1; j < intervals.length; j++) {
        //         if (intervals[j][0] >= intervals[i][1] && intervals[j][0] < min) {
        //             min = intervals[j][0];
        //             minidx = map.get(intervals[j]);
        //         }
        //     }
        //     rightInterval[map.get(intervals[i])] = minidx;
        // }
        // return rightInterval;
        // int[] res = new int[intervals.length];
        // for (int i = 0; i < intervals.length; i++) {
        //     int min = Integer.MAX_VALUE;
        //     int minindex = -1;
        //     for (int j = 0; j < intervals.length; j++) {
        //         if (intervals[j][0] >= intervals[i][1] && intervals[j][0] < min) {
        //             min = intervals[j][0];
        //             minindex = j;
        //         }
        //     }
        //     res[i] = minindex;
        // }
        // return res;
    }
    public int[] binary_search(int[][] intervals, int target, int start, int end) {
        if (start >= end) {
          if (intervals[start][0] >= target) {
            return intervals[start];
          }
          return null;
        }
        int mid = (start + end) / 2;
        if (intervals[mid][0] < target) {
          return binary_search(intervals, target, mid + 1, end);
        } else {
          return binary_search(intervals, target, start, mid);
        }
   }
}

/*public class Solution {
    public int[] findRightInterval(Interval[] intervals) {
        int[] result = new int[intervals.length];
        java.util.NavigableMap<Integer, Integer> intervalMap = new TreeMap<>();
        
        for (int i = 0; i < intervals.length; ++i) {
            intervalMap.put(intervals[i].start, i);    
        }
        
        for (int i = 0; i < intervals.length; ++i) {
            Map.Entry<Integer, Integer> entry = intervalMap.ceilingEntry(intervals[i].end);
            result[i] = (entry != null) ? entry.getValue() : -1;
        }
        
        return result;
    }
}*/
