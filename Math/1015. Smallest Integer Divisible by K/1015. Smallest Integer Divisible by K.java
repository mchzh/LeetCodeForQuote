class Solution {
    public int smallestRepunitDivByK(int K) {
        //if (K %2 == 0 || K % 5 == 0) return -1;
        int n = 1, count = 1;
        Set<Integer> set = new HashSet<>();
        while (true) {
            int r = n%K;
            if (r == 0) return count;
            if (set.contains(r)) return -1;
            set.add(r);
            n = 10*r+1;
            count++;
        }
        //return -1;
    }
}
// x1 = K*p + r1;
// x2 = 10*x1+1 = 10*K*p + 10*r1 + 1 = 10*r1+1 = r2 (mod)
// x3 = 10*x2 + 1 = 10*r2+1 = r3
// .......
// 抽屉原理：
// x1 x2 ....xi ... xj
// r1 r2 ....ri ... rj
// if ri == rj it is cycle no result return -1
