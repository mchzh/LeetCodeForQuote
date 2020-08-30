class Solution {
    int[] father = new int[100000+1];
    public int largestComponentSize(int[] A) {
        List<Integer> primes = makePrime((int)Math.sqrt(100000));
        // initilize
        for (int a : A) father[a] = a;
        for (int p : primes) father[p] = p;
        
        for (int a : A) {
            int cur = a;
            for (int p : primes) {
                if (a%p == 0 && find(a) != find(p)) {
                    union(a, p);
                }
                while (cur%p == 0) cur = cur/p; 
            }
            
            if (cur > 1) { // cur is a last largest prime of 100000
                if (father[cur] == 0) father[cur] = cur;
                union(cur, a);
            }
        }
        // group info
        Map<Integer, Integer> count = new HashMap<>();
        for (int a : A) {
            int parent = find(a);
            count.put(parent, count.getOrDefault(parent, 0) + 1);
        }
        
        int ret = 0;
        for (int val : count.values()) {
            ret = Math.max(ret, val);
        }
        return ret;
    }
    private int find(int x) {
        if (father[x] != x) {
            father[x] = find(father[x]);
        }
        return father[x];
    }
    
    private void union(int x, int y) {
        x = father[x];
        y = father[y];
        if ( x < y ) {
            father[y] = x;
        } else {
            father[x] = y;
        }
    }
    
    private int gcd(int p, int q) {
        if (p%q == 0) return q;
        return gcd(q, p/q);
    }
    private List<Integer> makePrime(int N) {
        List<Integer> ret = new ArrayList<>();
        boolean[] isPrime = new boolean[N+1];
        Arrays.fill(isPrime, true);
        for (long i = 2; i <= N; i++) {
            if( isPrime[(int)i] ) {
                ret.add((int)i);
                for (long j = i*i; j <= N; j+=i) {
                    isPrime[(int)j] = false;
                }
            }
        }
        return ret;
    }
}
