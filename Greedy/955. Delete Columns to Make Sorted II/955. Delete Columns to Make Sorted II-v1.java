class Solution {
    public int minDeletionSize(String[] strs) {
        int m = strs.length, n = strs[0].length(); 
        int rets = 0;
        int[] p = new int[m];
        
        
        for (int j = 0; j < n; j++) {
            int flag = 0;
            int[] p2 = Arrays.copyOf(p, m);
            
            for (int i = 1; i < m; i++) { 
                if (p2[i] == 1) continue;
                if (strs[i-1].charAt(j) < strs[i].charAt(j)) {
                    p2[i] = 1;
                } else if (strs[i-1].charAt(j) == strs[i].charAt(j)) {
                    p2[i] = 0;
                } else {
                    // delete current j column
                    flag = 1;
                    break;
                }
            }
            if (flag == 1) {
                rets++;
            } else {
                 for (int i = 0; i < m; i++) {
                    //if (j == 0) System.out.println(i + " : " + p2[i]);
                    p[i] = p2[i];
                 }
            }

        } 
        return rets;
    }
}

// x Y1
// x y2
// 1.. all strictly increase
// 2. increase with same char
// 3. has one broken: prior element > next element
// before j-th column
// p[i] = 1: A[i-1] < A[i] =>
// p[i] = 0: A[i-1] == A[i] =>
