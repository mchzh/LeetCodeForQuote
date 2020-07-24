class Solution {
    public int[][] diagonalSort(int[][] mat) {
        if (mat == null || mat.length == 0 || mat[0] == null || mat[0].length == 0) return mat;
        // first row
        int row = mat.length, col = mat[0].length;
        for (int j = 0; j < col; j++) {
            orderDiangoLine(mat, 0, j, 0, j);
        }
        
        for (int i = 1; i < row; i++) {
            orderDiangoLine(mat, i, 0, i, 0);
        }
        
        return mat;
    }
    private void orderDiangoLine(int[][] mat, int startx, int starty, int endx, int endy) {
        int row = mat.length, col = mat[0].length;
        int x = startx, y = starty;
        // iterate current dianonal line
        while (x < row && y < col) {
            int ix = x, iy = y;
            while (ix > endx && iy > endy && mat[ix][iy] < mat[ix-1][iy-1]) {
                // swap;
                int temp = mat[ix-1][iy-1];
                mat[ix-1][iy-1] = mat[ix][iy];
                mat[ix][iy] = temp;
                ix--;
                iy--;
            }
            x++;
            y++;
        }
    }
}

/*class Solution {
    public int[][] diagonalSort(int[][] mat) {
        
        int n = mat.length, m = mat[0].length;
        for(int i = 0; i < n - 1; i++) {
            countingSort(mat, i, 0, n, m);
        }
        for(int j = 1; j < m - 1; j++) {
            countingSort(mat, 0, j, n, m);
        }
        return mat;
    }
    
    private void countingSort(int[][] mat, int i, int j, int n, int m) {
        
        int[] arr = new int[101];        
        int k = i, l = j, val = 0;
        while(k < n && l < m) {
            arr[mat[k][l]]++;
            k++; l++;
        }
        
        k = i; l = j;
        for(int p = 0; p < 101; p++) {
            if(arr[p] > 0) {
                val = arr[p];
                while(val > 0){
                    mat[k][l] = p;
                    k++; l++; val--;  
                }
            }
        }
    }
}*/

/*class Solution {
    public int[][] diagonalSort(int[][] mat) {
        // draw the pic, and you can see that i - j for a matrix
        // 0 -1 -2
        // 1  0 -1
        // 2  1  0  so we can get their values and then sort
        Map<Integer, PriorityQueue<Integer>> map = new HashMap<>();
        
        for (int i = 0; i < mat.length; i++)
        {
            for (int j = 0; j < mat[0].length; j++)
            {
                map.putIfAbsent(i - j, new PriorityQueue<>());
                map.get(i - j).offer(mat[i][j]);
            }
        }
        
        for (int i = 0; i < mat.length; i++)
        {
            for (int j = 0; j < mat[0].length; j++)
            {
                mat[i][j] = map.get(i - j).poll();
            }
        }
        
        return mat;
    }
}*/
