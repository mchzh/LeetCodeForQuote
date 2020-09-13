class Solution {
    //SweepLine
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> rets = new ArrayList<>();
        
        for (int[] val : intervals) {
            if (val[1] < newInterval[0]) {
                rets.add(val);
            } else if (newInterval[1] < val[0]) {
                rets.add(new int[] {newInterval[0], newInterval[1]});
                newInterval[0] = val[0];
                newInterval[1] = val[1];
            } else {
                newInterval[0] = Math.min(newInterval[0], val[0]);
                newInterval[1] = Math.max(newInterval[1], val[1]);
            }
        }
        rets.add(newInterval);
        
        int[][] retsArr = new int[rets.size()][2];
        for (int i = 0; i < rets.size(); i++) {
            retsArr[i] = rets.get(i);
        }
        return retsArr;
    }
}
