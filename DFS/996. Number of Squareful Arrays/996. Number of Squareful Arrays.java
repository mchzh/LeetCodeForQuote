class Solution {
    int ret = 0;
    public int numSquarefulPerms(int[] A) {
        // dfs to get all permutation, for every permutation to check the element
        Arrays.sort(A);
        
        int[] visited = new int[A.length];
        List<Integer> list = new ArrayList<>();
        dfs(A, visited, 0, list);
        return ret;
    }
    private void dfs(int[] A, int[] visited, int pos, List<Integer> list) {
        if (pos == A.length) {
            ret++;
            return;
        }
        
        for (int i = 0; i < A.length; i++) {
            if (visited[i] == 1) continue;
            if (i >= 1 && A[i] == A[i-1] && visited[i-1] == 0) continue;
            if (list.size() > 0) {
                long sum = (long) ( A[i] + list.get(list.size()-1) );
                if (!isSquare(sum)) continue;
            }
            
            
            visited[i] = 1;
            list.add(A[i]);
            dfs(A, visited, pos+1, list);
            visited[i] = 0;
            list.remove(list.size()-1);
        }
    }
    private boolean isSquare(long sum) {
        if (sum < 0) return false;
        // Find floating point value of 
        // square root of x. 
        double sr = Math.sqrt((double)sum); 
      
        // If square root is an integer 
        return ((sr - Math.floor(sr)) == 0);
        
    }
}
