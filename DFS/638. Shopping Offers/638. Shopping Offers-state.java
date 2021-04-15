class Solution {
    int N;
    int[] memo = new int[1<<18];
    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        // state expression -> memo
        N = price.size();
        List<List<Integer>> special2 = new ArrayList<>();
        for (List<Integer> s : special) {
            int sum = 0;
            for (int i = 0;i < N; i++) {
                sum += price.get(i) * s.get(i);
            }
            if (sum > s.get(N)) special2.add(new ArrayList<>(s));
        }
        //System.out.println(special2.size());
        int state = 0;
        for (int i = 0; i < N; i++) {
            int cur = needs.get(i);
            state += (cur<<(i*3));
        }
        //System.out.println(state);
        return dfs(state, price, special2);
    }
    private int dfs(int state, List<Integer> price, List<List<Integer>> special) {
        if (state == 0) return 0;
        if (memo[state] != 0) return memo[state];
        // normal order
        int rets = 0;
        for (int i = 0; i < N; i++) {
            rets += price.get(i) * ((state>>(i*3))%8);
        }
        
        for (List<Integer> s : special) {
            int flag = 1;
            int state2 = state;
            for (int i = 0; i < N; i++) {
                int cur = s.get(i);
                if ((state2>>(i*3))%8 < cur) {
                    flag = 0;
                    break;
                }
                state2 -= (cur<<(i*3));
            }
            if (flag == 0) continue;
            //state -= ;
            rets = Math.min(rets, s.get(N) + dfs(state2, price, special));
        }
        
        memo[state] = rets;
        return rets;
    }
}

// {4,2,1,3,4,5}
// XXX XXX XXX XXX XXX. 18 bit
