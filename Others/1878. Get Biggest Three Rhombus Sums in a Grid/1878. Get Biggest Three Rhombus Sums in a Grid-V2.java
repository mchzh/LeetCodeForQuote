class Solution {
    // brute force
    // or presum : every 45 line presum then 
    // from center point to find every shape with radius
    public int[] getBiggestThree(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] presuml = new int[50][50];
        int[][] presumr = new int[50][50];
        // set presuml
        for (int i = 0; i < m; i++) { //"\"
            for (int j = 0; j < n; j++) {
                presuml[i][j] = ((i-1 >= 0 && j-1 >= 0) ? presuml[i-1][j-1] : 0) + grid[i][j];
            }
        }
        // set presumr
        for (int i = 0; i < m; i++) {//"/"
            for (int j = 0; j < n; j++) {
                presumr[i][j] = ((i-1 >= 0 && j+1 < n) ? presumr[i-1][j+1] : 0) + grid[i][j];
            }
        }

        Set<Integer> set = new TreeSet<>((a, b) ->(b-a));
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int cur = grid[i][j];
                set.add(cur);
                
                int R = Math.min(i, j);
                R = Math.min(R, m-1-i);
                R = Math.min(R, n-1-j);
                for (int r = 1; r <= R; r++) {
                    // four lines with presum
                    int sum = 0;
                    // every line has two points
                    int x1 = i-r, y1 = j;
                    int x2 = i, y2 = j-r;
                    sum += presumr[x2][y2] - presumr[x1][y1];

                    x1 = x2; y1 = y2;
                    x2 = i+r; y2 = j;
                    sum += presuml[x2][y2] - presuml[x1][y1];

                    x1 = i; y1 = j+r;
                    sum += presumr[x2-1][y2+1] - ((x1-1>=0 && y1+1 < n) ? presumr[x1-1][y1+1] : 0);
                    
                    x2 = x1; y2 = y1;
                    x1 = i-r; y1 = j;
                    sum += presuml[x2-1][y2-1] - ((x1-1>=0 && y1-1 >= 0) ? presuml[x1-1][y1-1] : 0);

                    set.add(sum);
                }
            }
        }

        int size = set.size();
        if (size >= 3) {
            int[] rets = new int[3];
            int idx = 0;
            Iterator iterator = set.iterator();

            while (iterator.hasNext() && idx < 3)
            {
                rets[idx++] = (int)iterator.next();
            }
            return rets;
        } else {
            int[] rets1 = new int[size];
            Iterator iterator1 = set.iterator();
            int idx1 = 0;

            while (iterator1.hasNext())
            {
                rets1[idx1++] = (int)iterator1.next();
            }
            return rets1;
        }
    }
}
