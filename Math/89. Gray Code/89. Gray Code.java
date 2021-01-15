class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> rets = new ArrayList<>();
        rets.add(0);
        if (n == 0) return rets;
        
        for (int i = 0; i <n ;i++) {
            int size = rets.size();
            for (int j = size-1; j >= 0; j--) {
                rets.add(rets.get(j)|(1<<i));
            }
        }
        return rets;
    }
}

// 0 0  00      000
//   1  01      001
//      11      011
//      10      010
//              110
//              111
//              101
//              100
