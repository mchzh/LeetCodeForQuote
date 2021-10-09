class SummaryRanges {

     class Interval {
        int start;
        int end;
        public Interval(int s, int e) {
            this.start = start;
            this.end = e;
        }
    }
    // treemap
    TreeMap<Integer, int[]> tree;
    public SummaryRanges() {
        tree = new TreeMap<>();
    }
    
    public void addNum(int val) {
        if (tree.containsKey(val)) return;
        Integer l = tree.lowerKey(val);
        Integer h = tree.higherKey(val);
        if (l != null && h != null && tree.get(l)[1] +1 == val && h == val+1) {
            tree.get(l)[1] = tree.get(h)[1];
            tree.remove(h);
        } else if (l != null && tree.get(l)[1] +1 >= val) {
            tree.get(l)[1] = Math.max(tree.get(l)[1], val);
        } else if (h != null && h == val+1) {
            tree.put(val, new int[] {val, tree.get(h)[1]});
            tree.remove(h); // h > val
        } else {
            tree.put(val, new int[] {val, val});
        }
    }
    
    public int[][] getIntervals() {
        int[][] rets = new int[tree.size()][2];
        int idx = 0;
        for (int[] t : tree.values()) {
            rets[idx++] = t;
        }
        return rets;
    }
}

/**
 * Your SummaryRanges object will be instantiated and called as such:
 * SummaryRanges obj = new SummaryRanges();
 * obj.addNum(val);
 * int[][] param_2 = obj.getIntervals();
 */
