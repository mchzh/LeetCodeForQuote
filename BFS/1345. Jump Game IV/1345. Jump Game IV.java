class Solution {
    // return minimun consider BFS
    public int minJumps(int[] arr) {
        Map<Integer, List<Integer>> same = new HashMap<>();
        
        
        // mapping all idxes which has the same value
        int N = arr.length;
        for (int i = 0; i < N; i++) {
            same.computeIfAbsent(arr[i], k -> new ArrayList<>()).add(i);
        }
        
        // bfs;
        boolean[] visited = new boolean[N];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        visited[0] = true;
        
        int step = 0;
        if (arr.length == 1) return step;
        while (!queue.isEmpty()) {
            
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int curPos = queue.poll();
                
                // +1 -1
                if (curPos+1 < N && !visited[curPos+1]) {
                    if (curPos+1 >= N-1) return step+1;
                    queue.offer(curPos+1);
                    visited[curPos+1] = true;
                }
                if (curPos-1 >= 0 && !visited[curPos-1]) {
                    if (curPos-1 >= N-1) return step+1;
                    queue.offer(curPos-1);
                    visited[curPos-1] = true;
                }

                if (same.containsKey(arr[curPos])) {
                    for (int samenext : same.get(arr[curPos])) {
                        if (visited[samenext]) continue;
                        if (samenext >= N-1) return step+1;
                        queue.offer(samenext);
                        visited[samenext] = true;
                    }
                    same.remove(arr[curPos]);
                }
            }
            step++;
        }
        return -1;
    }
}
