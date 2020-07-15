class Solution {
    // https://leetcode.com/problems/couples-holding-hands/discuss/729261/Java-cyclic-circle
    // https://leetcode.com/problems/couples-holding-hands/discuss/113362/JavaC%2B%2B-O(N)-solution-using-cyclic-swapping
    /*Approach #3: Greedy [Accepted]
Intuition

From guessing, or by the proof in Approach #2, our strategy is to resolve each couch in order.

To resolve a couch, fix the first person and have their partner swap into the second seat if they are not already there.*/
    int[] parent;
    public int minSwapsCouples(int[] row) {
        int N = row.length;
        
        parent = new int[N];
        for (int i = 0; i < N; i+=2) {
            parent[i] = i;
            parent[i+1] = i;
        }
        
        // connected different couple to comman parent
        for (int i = 0; i < N; i+=2) {
            if (find(row[i]) != find(row[i+1])) 
                union(row[i], row[i+1]);
        }
        
        // handle group information with map
        Map<Integer, Integer> group = new HashMap<>();
        for (int i = 0; i < N; i++) {
            int parentOfCur = find(i);
            group.put(parentOfCur, group.getOrDefault(parentOfCur, 0) + 1);
        }
        
        // get the result
        int ret = 0;
        for (int val : group.values()) {
            ret += val/2 -1;
        }
        return ret;
    }
    private void union(int x, int y) {
        x = parent[x];
        y = parent[y];
        if (x < y)
            parent[y] = x;
        else
            parent[x] = y;
    }
    
    private int find(int x) {
        if (x != parent[x]) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }
    
    public int minSwapsCouplesGreedy(int[] row) {
        // greedy
        // for i to find i+1 pos couple
        
        int ret = 0;
        for (int i = 0; i < row.length; i += 2) {
            int x = row[i];
            if ( row[i+1] == (x^1) ) continue;
            ret++;
            for (int j = i+1; j < row.length; j++) {
                if ( row[j] != (x^1) ) continue;
                row[j] = row[i+1];
                row[i+1] = x^1;
                break;
            }
        }
        return ret;
    }
}

// 02 13 || 48 65 79
    
//  O1          O2
//  m           n-1
//  m-1 swaps   n-2 swaps
 
//  group and group number
//  cyclic friend
