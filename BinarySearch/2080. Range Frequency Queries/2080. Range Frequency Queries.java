class RangeFreqQuery {
    // binary search
    Map<Integer, List<Integer>> map;
    public RangeFreqQuery(int[] arr) {
        map = new HashMap<>();
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            int val = arr[i];
            map.computeIfAbsent(val, k -> new ArrayList<>()).add(i);
        }
    }
    
    public int query(int left, int right, int value) {
        if (!map.containsKey(value)) return 0;
        List<Integer> list = map.get(value);
        
        if (left > list.get(list.size() -1) || right <  list.get(0)) {
            return 0;
        }
        //System.out.println(Arrays.toString(list.toArray()));
        // ensure it has valid value
        int n = list.size();
        int l = 0, r = n-1;
        while (l < r) {
            int mid = l + (r-l)/2;
            int idx = list.get(mid);
            if (idx < left) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }

        int l1 = 0, r1 = n-1;
        while (l1 < r1) {
            int mid1 = r1 - (r1-l1)/2;
            int idx1 = list.get(mid1);
            if (idx1 > right) {
                r1 = mid1 - 1;
            } else {
                l1 = mid1;
            }
        }
        //if() return 0;

        return r1-l+1;
    }
}

/**
 * Your RangeFreqQuery object will be instantiated and called as such:
 * RangeFreqQuery obj = new RangeFreqQuery(arr);
 * int param_1 = obj.query(left,right,value);
 */
