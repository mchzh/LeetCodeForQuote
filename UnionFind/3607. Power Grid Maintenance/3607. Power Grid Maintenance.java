class Solution {
    int[] parent;
    public int[] processQueries(int c, int[][] connections, int[][] queries) {
        parent = new int[c+1];
        // set paretn initialized value
        for (int i = 1; i <= c; i++) {
            parent[i] = i;
        }
        for (int[] ct : connections) {
            int a = ct[0];
            int b = ct[1];
            union(a, b);
        }
        // get sorted set for every connected graph
        // a-b c-d 2 sorted set

        Map<Integer, TreeSet<Integer>> map = new HashMap<>();
        for (int i = 1; i <= c; i++) {
            int r = find(i);
            map.computeIfAbsent(r, k -> new TreeSet<>()).add(i);
            //System.out.println("create sorted set for every graph -> " + r + " : " + i);
        }
        // // loop map
        // for (int key : map.keySet()) {
        //     System.out.println("---------");
        //     System.out.println(key);
        //     TreeSet<Integer> set = map.get(key);
            
        //     for (int k : set) {
        //         System.out.println(key + " : " + k);
        //     }
        // }

        List<Integer> list = new ArrayList<>();
        for (int[] q : queries) {
            int type = q[0];
            int sta = q[1];
            int r = find(sta);
            //System.out.println("query element -> " + type + " : " + sta + " : " + r);

            if (type == 2) {
                map.get(r).remove(sta);
            } else {
                if (!map.containsKey(r)) list.add(-1);
                else {
                    TreeSet<Integer> set = map.get(r);
                    if (set.isEmpty()) list.add(-1);
                    else {
                        if (set.contains(sta)) list.add(sta);
                        else list.add(set.first());
                    }
                }
            }
        }
        return list.stream().mapToInt(i -> i).toArray();
    }

    private int find(int x) {
        if (x != parent[x]) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
    }

    private void union(int x, int y) {
        int rootx = find(x);
        int rooty = find(y);
        if (rootx < rooty) {
            parent[rooty] = rootx;
        } else {
            parent[rootx] = rooty;
        }
    }
}
// a -> b
//  \   |
//      c
// for connection: union find : DFS/BFS
