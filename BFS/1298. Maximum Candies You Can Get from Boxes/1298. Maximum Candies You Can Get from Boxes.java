class Solution {
    public int maxCandies(int[] status, int[] candies, int[][] keys, int[][] containedBoxes, int[] initialBoxes) {
        int N = status.length;
        Set<Integer> keysSet = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        
        for (int cur : initialBoxes) {
            queue.offer(cur);
        }
        
        int count = 0;
        boolean opened = true;
        while (!queue.isEmpty() && opened) {
            int size = queue.size();
            opened = false;
            for (int i = 0; i < size; i++) {
                
                int curPos = queue.poll();
                if (status[curPos] == 0 && !keysSet.contains(curPos)) { // cannot open
                    queue.offer(curPos);
                } else { // open a new box
                    opened = true;
                    count += candies[curPos];
                    for (int k : keys[curPos]) {
                        keysSet.add(k);
                    }
                    for (int next : containedBoxes[curPos]) {
                        //if (visited[next]) continue;
                        queue.offer(next);
                    }  
                }
            }
        }
        return count;
    }
}

/*class Solution {
    public int maxCandies(int[] status, int[] candies, int[][] keys, int[][] containedBoxes, int[] initialBoxes) {
        int candy=0;
        boolean[] foundClosedBox=new boolean[status.length];
        Queue<Integer> q=new LinkedList<>();
        for(int box:initialBoxes) {
            if(status[box]==1) q.add(box);
            else foundClosedBox[box]=true;
        }
        while(!q.isEmpty()) {
            int box=q.poll();
            candy+=candies[box];
            for(int b:containedBoxes[box]) {
                if(status[b]==1) q.add(b);
                else foundClosedBox[b]=true;
            }
            for(int key:keys[box]) {
                status[key]=1;
                if(foundClosedBox[key]) {
                    q.add(key);
                    foundClosedBox[key]=false;
                }
            }
        }
        return candy;
    }
}*/
