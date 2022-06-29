class Solution {
    public int countPrimes(int n) {
        if (n == 0) return 0;
        boolean[] isPrime = new boolean[n];
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        
        for (int i = 2; i * i < n; i++) {
            if (!isPrime[i]) continue;
            for (int j = i*i; j < n; j+= i) {
                isPrime[j] = false;
            }
        }
        
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (isPrime[i]) count++;
            
        }
        return count;
    }
}
