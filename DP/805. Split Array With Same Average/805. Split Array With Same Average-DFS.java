class Solution {
    int tsum = 0;
    int total = 0;
    
    public boolean splitArraySameAverage(int[] A) {
        Arrays.sort(A);
        total = A.length;
        for (int a : A) tsum += a;
        for (int num = 1; num < total; num++) {
            // num*tsum == total*sum
            if (num*tsum%total != 0) continue;
            if (dfs(A, num, num*tsum/total, 0)) return true;
        }
        
        return false;
    }
    private boolean dfs(int[] A, int num, int sum, int idx) {
        if (num == 0 && sum == 0) return true;
        if (num == 0 && sum == 0) return true;
        if (idx == A.length) return false;
        
        if (dfs(A, num-1, sum-A[idx], idx+1)) return true;
        int i = idx;
        while (i < A.length && A[i] == A[idx]) i++; //duplicate element
        if (dfs(A, num, sum, i)) return true;
        
        return false;
    }
    
}

// (x1 + x2 + ... + xn)/ n = avg
// (a1 + .. + am) / n1 == (b1+...+bl) / n2 == avg1  (n1+n2 = n , a1+...+am+b1+...bl == (x1+...xn))
// => n*avg = (n1+n2)*avg1 => avg == avg1
// n is total sum
// total/n == sum/num
// n*sum == total*num 
