class Solution {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        if (source == target) return 0;
        // create mapping
        int n = routes.length;
        Map<Integer, List<Integer>> stop2bus = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int a : routes[i]) {
                stop2bus.computeIfAbsent(a, k -> new ArrayList<>()).add(i);
            }    
        }

        // bfs skelton
        int step = -1;
        Set<Integer> visitedstop = new HashSet<>();
        Set<Integer> visitedbus = new HashSet<>();
        Queue<Integer> q = new LinkedList<>();
        q.offer(source);
        visitedstop.add(source);

        while (!q.isEmpty()) {
            int size = q.size();
            step++;
            for (int i = 0; i < size; i++) {
                int cur = q.poll();
                // next stop
                if (!stop2bus.containsKey(cur)) continue;
                for (int bus : stop2bus.get(cur)) { // bus loop
                    if (visitedbus.contains(bus)) continue;
                    visitedbus.add(bus);
                    for (int s : routes[bus]) {
                        if (s == target) return step+1;

                        if (visitedstop.contains(s)) continue;
                        visitedstop.add(s);
                        q.offer(s);
                    }
                }
            }
        }
        return -1;
    }
}

// bfs to find min
// stop next stop -> next next stop
// stop relationship:
// same stop -> mutlple bus -> under bus element is next
// stop2bus
