class Solution {
    public int findMinArrowShots(int[][] points) {
        
        //sort by end with Greedy
        int N = points.length;
        if (points.length == 0) return 0;

        // sort by x_end
        Arrays.sort(points, new Comparator<int[]>() {
          @Override
          public int compare(int[] o1, int[] o2) {
            return o1[1] - o2[1];
          }
        });
        // for (int i = 0; i < points.length; i++) {
        //     System.out.println(points[i][1] + " : " + points.length);
        // }

         int count = 0;
//         int arrPos = points[0][1];
//         int arrcnt = 1;
//         for (int i = 1; i < points.length; i++) {
//             if (arrPos >= points[i][0]) {
//                 continue;
//             }
//             arrcnt++;
//             arrPos = points[i][1];
            
//         }
//         return arrcnt;
        for (int i = 0; i < N;) {
            //System.out.println(points[i][1] + " : " + points.length);
            long right =  points[i][1];
            //System.out.println(right);
            int j = i+1;
            while (j < N && points[j][0] <= right && points[i][0] <= points[j][1]) {
                j++;
            }
            count++;
            i = j;
        }
        return count;
    //     long[][] x = new long[2][2];
    //     Arrays.sort(x, new Comparator<long[]>() {
    //   @Override
    //   public long compare(long[] o1, long[] o2) {
    //     return o1[1] - o2[1];
    //   }
    // });
    //     if (points.length == 0) {
    //         return 0;
    //     }
    //     Arrays.sort(points, (a, b) -> a[1] - b[1]);
    //     int arrowPos = points[0][1];
    //     int arrowCnt = 1;
    //     for (int i = 1; i < points.length; i++) {
    //         if (arrowPos >= points[i][0]) {
    //             continue;
    //         }
    //         arrowCnt++;
    //         arrowPos = points[i][1];
    //     }
    //     return arrowCnt;
    }
}

// [[10,16],[2,8],[1,6],[7,12]]
// [[-2147483646,-2147483645],[2147483646,2147483647]]  : after sort with end, the sequence is reverse cause of the overflow -> [[2147483646,2147483647],[-2147483646,-2147483645]]
// [[1,2],[3,4],[5,6],[7,8]]
// [[1,2]]
// [[2,3],[2,3]]

// -------
//   --------
//          -------
//              -------
