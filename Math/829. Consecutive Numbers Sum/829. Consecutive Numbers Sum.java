class Solution {
    public int consecutiveNumbersSum(int N) {
        int count = 0;
        for (int m =1; m <= Math.sqrt(2*N); m++) {
            if ( (2*N - m*m + m) % (2*m) == 0 && (2*N - m*m + m) >= (2*m) ) count++;
        }
        return count;
    }
}

// f(a, b) = N
// x + x+1 + x+2 + ..... x+m-1 (m numbers)
// => (x+x+m-1) * m / 2 = N
// x = N/m -m/2 +1/2 = (2N - m*m + m) / 2m
