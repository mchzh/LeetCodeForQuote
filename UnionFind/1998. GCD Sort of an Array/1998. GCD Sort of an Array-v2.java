class Solution {
    int[] Father = new int[100001];
    int L = 100000;
    private List<Integer> getPrimes(int n) {
        List<Integer> rets = new ArrayList<>();
        if (n == 0) return rets;
        boolean[] isPrime = new boolean[n+1];
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        
        for (int i = 2; i * i <= n; i++) {
            if (!isPrime[i]) continue;
            for (int j = i*i; j <= n; j+= i) {
                isPrime[j] = false;
            }
        }
        
        for (int i = 2; i <= n; i++) {
            if (isPrime[i]) rets.add(i);
            
        }
        return rets;
    }
    
    private int FindFather(int a) {
        if (Father[a] != a) {
            Father[a] = FindFather(Father[a]);
        }
        return Father[a];
    }
    
    private void Union(int a, int b) {
        a = Father[a];
        b = Father[b];
        if (a < b)
            Father[b] = a;
        else
            Father[a] = b;
    }
    public boolean gcdSort(int[] nums) {
        List<Integer> primes = getPrimes(((int)Math.sqrt(L))+5);
        
        for (int i = 0; i < Father.length; i++) Father[i] = i;
        
        for (int n : nums) {
            int x = n;
            for (int p : primes) {
                if (x < p) break;
                if (x%p == 0) {
                    if (FindFather(n) != FindFather(p)) Union(n, p);
                    while(x%p == 0) x /= p;
                }
            }
            if (x > 1) { // x is prime
                if (FindFather(n) != FindFather(x)) Union(n, x);
            }
        }
        
        // sort array to compare initial array element with the same index
        int[] sorted = Arrays.copyOf(nums, nums.length);
        Arrays.sort(sorted);
        for (int i = 0; i < nums.length; i++) {
            if (FindFather(sorted[i]) != FindFather(nums[i])) return false;
        }
        
        return true;
    }
}
