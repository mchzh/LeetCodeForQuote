class Solution {
    // https://www.cnblogs.com/grandyang/p/5798275.html
    public List<Integer> lexicalOrder(int n) {
        int cur = 1;
        List<Integer> rets = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            rets.add(cur);
            if (cur*10 <= n) {
                cur *= 10;
            } else {
                if (cur >= n) cur /= 10;
                cur += 1;
                while (cur%10 == 0) cur /= 10;
            }
        }
        return rets;
    }
}
