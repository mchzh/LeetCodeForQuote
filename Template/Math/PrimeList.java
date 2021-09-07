public List<Integer> getPrimes(int n) {
        List<Integer> rets = new ArrayList<>();
//         if (n < 2) return rets;
//         boolean[] isnotPrime = new boolean[n];
//         for (int i = 2; i*i < n; i++) {
//             for (int j = i*i; j < n; j += i) { // step for i
//                 isnotPrime[j] = true;
//             }
//         }
        
//         for (int i = 2; i < n ; i++) {
//             if (!isnotPrime[i]) rets.add(i);
//         }
//         return rets;
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
