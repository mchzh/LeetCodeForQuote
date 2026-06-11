class Solution {
    public int assignEdgeWeights(int[][] edges) {
        // compute all C(n,m) saved in comb
       long[][] comb= new long[1000][1000];  
        for (int i = 0; i <= n; ++i) 
        {
            comb[i][i] = comb[i][0] = 1;            
            if (i==0) continue;
            for (int j = 1; j < i; ++j) 
            {
                comb[i][j] = comb[i - 1][j - 1] + comb[i - 1][j];
            }
        }  
    }
    long powval(long a, long size) {
        long mod = (long)(1e9+7);
        long ans = 1;
        for (int i = 1; i <= size; i++) {
            ans = (ans*a)%mod;
        }
        return ans;
    }

  // Compute C(n,m) on demand
    long help(int n, int m)
    {
        long cnt = 1;
        for(int i = 0; i < m; i++)
        {
            cnt *= n - i;
            cnt /= i + 1;
        }
        return cnt;
    }
}

// c(n,1) + c(n,3) +... = 2^(n-1)
