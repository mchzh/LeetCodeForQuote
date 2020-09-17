class Solution {
    public int maxAbsValExpr(int[] arr1, int[] arr2) {
        int N = arr1.length;
        int[][] infos = new int[N][3];
        for (int i = 0; i < N; i++) {
            infos[i][0] = arr1[i];
            infos[i][1] = arr2[i];
            infos[i][2] = i;
        }
        
        int ret = 0;
        for (int s = 0; s < (1<<3); s++) {
            int mm = Integer.MAX_VALUE, mx = Integer.MIN_VALUE;
            for (int i = 0; i < N; i++) {
                int sum = 0;
                
                for (int j = 0; j < 3; j++) {
                    if ( ((s>>j)&1) == 1 ) {
                        sum += infos[i][j];
                    } else {
                        sum += -infos[i][j];
                    }
                }
                mx = Math.max(mx, sum);
                mm = Math.min(mm, sum);
            }
            ret = Math.max(ret, mx-mm);
        }
        
        return ret;
    }
}

// Mathnton distance
// For 2D point
// (x1, y1) (x2, y2)

// d() = |x1-x2| + |y1-y2|
//     = max {
//         x1-x2 + y1-y2,
//         -x1+x2 + y1-y2,
//         x1-x2 -y1+y2,
//         -x1+x2-y1+y2
//     }
//     = max {
//         (x1+y1) - (x2+y2),
//         (-x1+y1) - (-x2+y2),
//         (x1-y1) - (x2-y2),
//         (-x1-y1) - (-x2-y2)
//     }

// d(i, j) = max {
//         (xi+yi) - (xj+yj),
//         (-xi+yi) - (-xj+yj),
//         (xi-yi) - (xj-yj),
//         (-xi-yi) - (-xj-yj)
//     }

// d_max = max d(i, j) over (i, j)
//       = max over (i, j) {
//         max {
//             (xi+yi) - (xj+yj),
//             (-xi+yi) - (-xj+yj),
//             (xi-yi) - (xj-yj),
//             (-xi-yi) - (-xj-yj)
//         }
//     }
//       = // change loop level from inside to outside
//           max {
//             max over (i, j) {(xi+yi) - (xj+yj)};   => max(x+y) - min(x+y);
//             max over (i, j) {(-xi+yi) - (-xj+yj)}; => max(-x+y) - min(-x+y);
//             max over (i, j) {(xi-yi) - (xj-yj)};   => max(x-y) - min(x-y);
//             max over (i, j) {(-xi-yi) - (-xj-yj)}  => max(-x-y) - min(-x-y);
//       }
// 3 d has eight scenario  1<<3;
