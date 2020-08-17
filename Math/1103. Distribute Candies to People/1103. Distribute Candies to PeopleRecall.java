class Solution {
    public int[] distributeCandies(int candies, int num_people) {
        int[] ret = new int[num_people];
        // get max whole round
        int N = num_people;
        int oneCommon = N*(N+1)/2;
        int numRound = 0;
        while (candies >= numRound * N * N + oneCommon) {
            candies -= numRound * N * N + oneCommon;
            numRound++;
            //curNum = numRound * N * N + oneCommon;
        }
        // numRound is the last round for candy distribute
        // set last round val to the ret
        if (numRound > 0) {
            for (int i = 0; i < N; i++) {
                ret[i] = numRound*(numRound-1)*N/2 + (i+1)*numRound;
            }
        }
        
        // set the rest of candy to the peopel by order sequence
        int idx = 0;
        while (candies >= (numRound*N+(idx+1)) ) {
            //System.out.println("cur val of array -> "+ ret[idx] + " : cur idx -> " + idx + ": val is -> " +(numRound*N+(idx+1)) );
            ret[idx] += (numRound*N+(idx+1));
            candies -= (numRound*N+(idx+1));
            idx++;
        }
        ret[idx++] += candies;
        return ret;
    }
}


// 1rd: 1, 2, .... , n;               n(n+1)/2
// 2nd: n+1, n+2, .... n+n;           n*n + n*(n+1)/2
// ...
//     ...
// kth: (k-1)*n+1, (k-1)*n+2, ..... (k-1)*n+n     (k-1)*n*n + n*(n+1)/2
// (k+1)th: k*n+1, k*n+2, .... k*n+s

// every element of whole round: 0*n + 1*n + 2*n +.... (k-1)*n + i*k
