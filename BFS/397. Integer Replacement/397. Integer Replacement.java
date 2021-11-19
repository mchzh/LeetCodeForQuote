class Solution {
    public int integerReplacement(int n) {
        Queue<Long> q = new LinkedList<>();
        q.offer((long)n);
        Set<Long> visited = new HashSet<>();
        //System.out.println(Integer.MAX_VALUE);

        int level = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                long cur = q.poll();
                //System.out.println(cur + " " + size);
                if (cur == 1) return level;
                visited.add(cur);
                // next
                if (cur%2 == 0) {
                    //System.out.println(cur + " " + size + " " + n/2); 
                    if (!visited.contains(cur/2)) q.offer(cur/2);
                    //q.offer();
                } else {
                    if (!visited.contains(cur+1)) q.offer(cur+1);
                    if (!visited.contains(cur-1)) q.offer(cur-1);
                }
            }
            level++;
        }
        return -1;
    }
}
