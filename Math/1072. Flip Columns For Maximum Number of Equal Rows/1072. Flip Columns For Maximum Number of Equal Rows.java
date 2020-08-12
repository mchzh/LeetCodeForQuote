class Solution {
    public int maxEqualRowsAfterFlips(int[][] matrix) {
        Map<String, Integer> map = new HashMap<>();
        
        for (int[] row : matrix) {
            StringBuilder sb1 = new StringBuilder();
            StringBuilder sb2 = new StringBuilder();
            
            for (int r : row) {
                sb1.append(r);
                sb2.append(1-r);
            }
            
            String str1 = sb1.toString();
            String str2 = sb2.toString();
            map.put(str1, map.getOrDefault(str1, 0) + 1);
            map.put(str2, map.getOrDefault(str2, 0) + 1);
        }
        
        int ret = 0;
        for (int v : map.values()) {
            ret = Math.max(ret, v);
        }
        return ret;
    }
}

/*class Solution {
    public int maxEqualRowsAfterFlips(int[][] matrix) {
        int ans = 0;
        int m = matrix.length, n = matrix[0].length;
        for(int i = 0; i < m; i++) {
            int cnt = 0;
            int[] flip = new int[n];
            for(int j = 0; j < n; j++) flip[j] = 1 - matrix[i][j];
            for(int k = i; k < m; k++) {
                if(Arrays.equals(matrix[k], matrix[i]) || Arrays.equals(matrix[k], flip)) cnt++;
            }
            ans = Math.max(ans, cnt);
        }
        return ans;
    }
}*/
