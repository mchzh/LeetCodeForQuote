class Solution {
    // brute force
    // or presum : every 45 line presum then 
    // from center point to find every shape with radius
    public int[] getBiggestThree(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        Set<Integer> set = new TreeSet<>((a, b) ->(b-a));
        //PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) ->(b-a));

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int cur = grid[i][j];
                set.add(cur);
                int R = Math.min(i, j); // left top distance
                R = Math.min(R, m-1-i); // bottom distance
                R = Math.min(R, n-1-j); // right distance
                for (int r = 1; r <= R; r++) { // radius at least one
                    int sum = 0;
                    // four lines
                    int x = i-r, y = j;
                    // from top-right to left-middle
                    for (int s = 1; s <= r; s++) {
                        x += 1;
                        y -= 1;
                        sum += grid[x][y];
                    }

                    for (int s = 1; s <= r; s++) {
                        x += 1;
                        y += 1;
                        sum += grid[x][y];
                    }

                    for (int s = 1; s <= r; s++) {
                        x -= 1;
                        y += 1;
                        sum += grid[x][y];
                    }

                    for (int s = 1; s <= r; s++) {
                        x -= 1;
                        y -= 1;
                        sum += grid[x][y];
                    }

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
