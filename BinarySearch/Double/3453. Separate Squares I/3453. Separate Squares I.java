class Solution {
    // 2137 for double type binary search
    public double separateSquares(int[][] squares) {
        double max_y = 0;
        double tarea = 0;
        for (int[] s : squares) {
            double y = (double)s[1];
            double rec = (double)s[2];
            tarea +=  rec *  rec;
            max_y = Math.max(max_y, (y+rec));
        }

        double left = 0;
        double right = max_y;
        while (Math.abs(right-left) > 1e-5) {
            double mid = (right+left)/2;
            if (check(mid, squares, tarea)) {
                // below area > the half of total
                right = mid;
            } else {
                left = mid;
            }
        }

        return right;
        // double max_y = 0;
        // double total_area = 0;
        // for (int[] sq : squares) {
        //     int y = sq[1];
        //     int l = sq[2];
        //     total_area += (double) l * l;
        //     max_y = Math.max(max_y, (double) (y + l));
        // }

        // double lo = 0;
        // double hi = max_y;
        // double eps = 1e-5;
        // while (Math.abs(hi - lo) > eps) {
        //     double mid = (hi + lo) / 2;
        //     if (check(mid, squares, total_area)) {
        //         hi = mid;
        //     } else {
        //         lo = mid;
        //     }
        // }

        // return hi;
    }
    private Boolean check(double y, int[][] squares, double tarea) {
        double curbelow = 0;
        for (int[] s : squares) {
            int cury = s[1];
            int rec = s[2];
            if (cury < y) { // below
                curbelow += (double)rec * Math.min((double)rec, y-cury);
            }
            
        }
        // if curbelow*2 >= tarea
        return curbelow >= tarea / 2;
        // double area = 0;
        // for (int[] sq : squares) {
        //     int y = sq[1];
        //     int l = sq[2];
        //     if (y < limit_y) {
        //         area += (double) l * Math.min(limit_y - y, (double) l);
        //     }
        // }
        // return area >= total_area / 2;
    }
    private boolean check1(double y, int[][] squares, double tarea) {
        // below y line area calculate
        // xi, yi, l: yi > y -> 0; yi<=y -> Math.min(l, (y-yi))*l (yi<=y<=yi+l or y > yi+l)
        double curbelow = 0;
        for (int[] s : squares) {
            int cury = s[1];
            int rec = s[2];
            if (cury < y) { // below
                curbelow += (double)rec * Math.min((double)rec, y-cury);
            }
            
        }
        // if curbelow*2 >= tarea
        return curbelow >= tarea / 2;
    }
}
