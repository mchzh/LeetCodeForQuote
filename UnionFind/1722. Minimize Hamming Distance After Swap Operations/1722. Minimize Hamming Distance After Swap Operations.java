class Solution {
    // union find
    int[] father;
    public void union(int x, int y) {
        int a = find(x);
        int b = find(y);
        if (a < b) {
            father[b] = a;
        } else {
            father[a] = b;
        }
    }
    public int find(int x) {
        if (father[x] != x) {
            father[x] = find(father[x]);
        }
        return father[x];
    }
    public int minimumHammingDistance(int[] source, int[] target, int[][] allowedSwaps) {
        int n = source.length;
        father = new int[n];
        for (int i = 0; i < n; i++) {
            father[i] = i;
        }
        for (int[] a : allowedSwaps) {
            int x = a[0];
            int y = a[1];
            if (find(x) != find(y)) {
                union(x, y);
            }
        }

        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int p = find(i);
            map.computeIfAbsent(p, k -> new ArrayList<>()).add(i);
        }
        int rets = 0;
        for (int key : map.keySet()) {
            List<Integer> idxs = map.get(key);
            // get un common count
            rets += getUnCommon(idxs, source, target);
        }
        return rets;
    }

    private int getUnCommon(List<Integer> idxs, int[] source, int[] target) {
        Map<Integer, Integer> v2c = new HashMap<>();
        int count = 0;
        for (int i : idxs) {
            v2c.put(source[i], v2c.getOrDefault(source[i], 0) + 1);
        }
        for (int i : idxs) {
            int val = target[i];
            if (v2c.containsKey(val)) {
                int curc = v2c.get(val);
                if (curc == 1) {
                    v2c.remove(val);
                } else {
                    v2c.put(val, curc-1);
                }
            } else {
                count += 1;
            }
        }
        return count;
    }
}

//  X X  X X X X X
//  Y Y  Y Y Y Y Y
//       i   j   k
