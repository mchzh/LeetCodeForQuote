class Solution {
    // two pointer
    // deque
    // https://www.geeksforgeeks.org/number-subarrays-maximum-value-given-range/
    // count
    public int numSubarrayBoundedMax(int[] A, int L, int R) {
        int res = 0;
        int exec = 0;
        int inc = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] > R) {
                res += consecutiveNum(inc) - consecutiveNum(exec);
                exec = 0;
                inc = 0;
            } else if (A[i] < L) {
                exec++;
                inc++;
            } else {
                res -= consecutiveNum(exec);
                exec = 0;
                inc++;
            }
        }
        res += consecutiveNum(inc) - consecutiveNum(exec);
        return res;
    }
    private int consecutiveNum(int n) {
        return n*(n+1)/2;
    }
}

/*class Solution {
    public int numSubarrayBoundedMax(int[] A, int L, int R) {
        
        int curr = 0;
        int ret = 0; 
        int n = A.length; 
        
        int j = 0; 
        
        for(int i=0; i<n; i++) 
        { 
            
            if(A[i]<L) 
            {
                
                ret = ret + curr; 
            
            }
            else if(A[i]>R) 
            {  
                curr =0; 
                j = i+1; 
            }
                
            else { 
                curr = -j+1+i; 
                ret = ret + curr; 
                
            } 
        } 
        
        return ret; 
    }
}*/

/*class Solution {
    public int numSubarrayBoundedMax(int[] A, int L, int R) {
        return count(A, R) - count(A, L-1);
    }

    public int count(int[] A, int bound) {
        int ans = 0, cur = 0;
        for (int x: A) {
            cur = x <= bound ? cur + 1 : 0;
            ans += cur;
        }
        return ans;
    }
}*/
