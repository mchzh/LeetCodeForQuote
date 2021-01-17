class Solution {
    public String kthSmallestPath(int[] destination, int k) {
        int H = destination[1];
        int V = destination[0];
        int n = H+V;
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (H == 0) {
                sb.append('V');
                V--;
                continue;
            } else if (V == 0) {
                sb.append('H');
                H--;
                continue;
            }
            
            // discuss with H and V as head
            int restComb = comb(H-1+V, V);
            if (k <= restComb) {
                sb.append('H');
                H--;
            } else {
                sb.append('V');
                V--;
                k -= restComb;
            }
        }
        return sb.toString();
    }
    
    int comb(int n, int m)
    {        
        int cnt = 1;
        for(int i = 0; i < m; i++){
            cnt *= n - i;
            cnt /= i + 1;
        }
        return cnt;
    }
}

// H * * * *  C(4, 2) = 6
// <= 6
// > 6
// V * * * *  k-=6
