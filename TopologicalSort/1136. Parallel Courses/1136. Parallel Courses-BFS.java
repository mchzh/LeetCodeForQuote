class Solution {
    public int minimumSemesters(int n, int[][] relations) {
        // has cycle and valide point: count == occurencenumber
        int[] degree = new int[n+1];
        
        Arrays.fill(degree, -1);
        Map<Integer, List<Integer>> dis = new HashMap<>();
        
        for (int[] r : relations) {
            if (degree[r[0]] == -1) degree[r[0]] = 0;
            if (degree[r[1]] == -1) degree[r[1]] = 0;
            degree[r[1]]++;
            dis.computeIfAbsent(r[0], k -> new ArrayList<>()).add(r[1]);
        }
        
        int count = 0;
        int occur = 0;
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <=n; i++) {
            if (degree[i] == -1) continue;
            occur++;
            if (degree[i] ==0 ) {
                count++;
                q.offer(i);
            }
        }
        
        int rets = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            rets++;
            for (int i = 0; i < size; i++) {
                int cur = q.poll();
                if (!dis.containsKey(cur)) continue;
                for (int next : dis.get(cur)) {
                    degree[next]--;
                    if (degree[next] == 0) {
                        count++;
                        q.offer(next);
                    }
                }
            }
        }
        //System.out.println(count + " " + rets);
        return count == occur ? (rets == 0 ? -1 : rets) : -1;
    }
}
