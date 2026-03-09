class Solution {
    // binary search
    // every time to set how many alloys need to be generate - mid;
    // if (mid mincost > budget) {
    //    right = mid-1;
    //} else {
    //    left = mid;
    //}
    // 
    public int maxNumberOfAlloys(int n, int k, int budget, List<List<Integer>> composition, List<Integer> stock, List<Integer> cost) {
        // set alloy number
        long left = 0, right = (long)1e9;
        while (left < right) {
            long mid = right - (right-left)/2;
            if (isValid(mid, n, k, budget, composition, stock, cost)) {
                // find it
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return (int)left;
    }
    public boolean isValid(long alloys, int n, int k, int budget, List<List<Integer>> composition, List<Integer> stock, List<Integer> cost) {
        // k machine
        long minCost = Integer.MAX_VALUE;
        for (int i = 0; i < k; i++) {
            // every compsition
            long curCost = 0;
            for (int j = 0; j < n; j++) {
                long cnum = alloys*composition.get(i).get(j);
                long cstock = (long)stock.get(j);
                if (cstock >= cnum) {
                    // nothing
                    continue;
                } else {
                    curCost += (cnum - cstock)*(long)cost.get(j);
                }
            }
            minCost = Math.min(minCost, curCost);
        }

        return ((int)minCost<=budget);
    }
}
