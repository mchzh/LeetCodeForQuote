class Solution {
    // https://leetcode.com/problems/find-the-minimum-number-of-fibonacci-numbers-whose-sum-is-k/discuss/670917/Java-Greedy-by-TreeSet
    // https://leetcode.com/problems/find-the-minimum-number-of-fibonacci-numbers-whose-sum-is-k/discuss/585632/JavaC%2B%2BPython-Easy-Prove
    public int findMinFibonacciNumbers(int k) {
        if (k < 2) return k;
        List<Integer> fibs = new ArrayList<>();
        
        fibs.add(1);
        fibs.add(1);
        
        int fib1 = 1;
        int fib2 = 1;
        int temp = 0;
        int count = 0;
        
        while(fib2 < k) {
            temp = fib1 + fib2;
            fib1 = fib2;
            fib2 = temp;
            fibs.add(temp);
        }
        
        for (int i = fibs.size() - 1; i > 0; i--) {
            if (k > 0 && k >= fibs.get(i)) {
                k -= fibs.get(i);
                count++;
            }
        }
        
        if (k == 0) {
            return count;
        }
        return -1;
//         TreeSet<Integer> set = new TreeSet<>();
//         int a = 0, b = 1;
//         while (b < k) {
//             int tmp = b;
//             b += a;
//             a = tmp;
//             set.add(b);
//             //System.out.println(b);
//         }
//         //System.out.println("set success");
        
//         int ret = 0;
//         while (k > 0) {
//             k -= set.floor(k);
//             ret++;
//         }
//         return ret;
    }
}

/*class Solution {
    // Time : O(n)
    public int findMinFibonacciNumbers(int k) {
        List<Integer> fibs = new ArrayList<>();
        
        fibs.add(1);
        fibs.add(1);
        
        int fib1 = 1;
        int fib2 = 1;
        int temp = 0;
        int count = 0;
        
        while(fib2 < k) {
            temp = fib1 + fib2;
            fib1 = fib2;
            fib2 = temp;
            fibs.add(temp);
        }
        
        for (int i = fibs.size() - 1; i > 0; i--) {
            if (k > 0 && k >= fibs.get(i)) {
                k -= fibs.get(i);
                count++;
            }
        }
        
        if (k == 0) {
            return count;
        }
        return -1;
    }
}*/
