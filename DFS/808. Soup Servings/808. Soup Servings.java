class Solution {
    // https://leetcode.com/problems/soup-servings/discuss/121711/C%2B%2BJavaPython-When-N-greater-4800-just-return-1
    Map<String, Double> map = new HashMap<>();
    public double soupServings(int N) {
        //if (N == 1) return 1;
        if (N >= 5000) return 1;
        return dfs(N, N);
    }
    private double dfs(int A, int B) {
        if (B <=0 && A > 0) return 0;
        if (B >0 && A<= 0) return 1;
        if (A <= 0 && B <= 0) return 0.5;
        
        String str = A + "#" + B;
        if (map.containsKey(str)) return map.get(str);
        
        double x = 0.25*(dfs(A-100, B) + dfs(A-75, B-25) + dfs(A-50, B-50) + dfs(A-25, B-75));
        map.put(str, x);
        return x;
    }
}
