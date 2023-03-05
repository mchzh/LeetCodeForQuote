 private List<Integer> getPrime(int n) {
        int range = n+1;
        boolean[] isPrime = new boolean[range];
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        
        for (int i = 2; i * i < range; i++) {
            if (!isPrime[i]) continue;
            for (int j = i*i; j < range; j+= i) {
                isPrime[j] = false;
            }
        }
        List<Integer> primelist = new ArrayList<>();
        int count = 0;
        for (int i = 2; i < range; i++) {
            if (isPrime[i]) {
                primelist.add(i);
                count++;   
            }
        }
        return primelist;
  }
