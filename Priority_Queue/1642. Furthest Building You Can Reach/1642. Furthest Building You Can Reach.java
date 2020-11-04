class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        int n = heights.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for (int i = 1; i < n; i++) {
            if (heights[i] <= heights[i-1]) continue;
            pq.offer(heights[i] - heights[i-1]);
            if (pq.size() > ladders) {
                if (pq.peek() > bricks) return i-1;
                bricks -= pq.poll();
            }
        }
        return n-1;
    }
}
