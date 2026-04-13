class Solution {
    public int matrixMedian(int[][] grid) {
        // get max and min of thie grid within sorted row
        int m = grid.length, n = grid[0].length;
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        for (int i = 0; i < m; i++) {
            max = Math.max(max, grid[i][n-1]);
            min = Math.min(min, grid[i][0]);
        }

        int req = (m*n + 1)/2; // median postion
        while (min < max) {
            int mid = min + (max-min)/2;
            int count = 0;
            for (int i = 0; i < m; i++) {
                count += findCount(grid[i], mid);
                //if (mid == 305672) System.out.println(i + " : " + findCount(grid[i], mid));
            }
            //System.out.println(min + " : " + max + " : " + mid + " : " +  count);
            // if (mid == 305672) {
            //     System.out.println(min + " : " + max + " : " + mid + " : " +  count);
            // }
            if (count < req) { //less # < n/2
                min = mid + 1;
            } else { // less # >= n/2
                max = mid;
            }
        }

        return min;
    }

    private int findCount(int[] arr, int tar) {// how many element <= mid
        
        int left = 0, right = arr.length-1;
        while (left < right) {
            int mid = right - (right-left)/2;
            if (arr[mid] <= tar) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        if (arr[left] > tar) {
            return left;
        } else {
            return left + 1;
        }
        
    }
}
// pos: m*n/2 + 1
// X X X X X 
// Y Y Y Y Y
